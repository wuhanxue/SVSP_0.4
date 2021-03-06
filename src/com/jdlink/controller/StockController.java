package com.jdlink.controller;
import com.jdlink.domain.*;
import com.jdlink.domain.Produce.Stock;
import com.jdlink.domain.Produce.StockItem;
import com.jdlink.service.ClientService;
import com.jdlink.service.StockService;
import com.jdlink.service.SupplierService;
import com.jdlink.service.WastesInfoService;
import com.jdlink.util.RandomUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class StockController {
    @Autowired
    StockService stockService;
    @Autowired
    WastesInfoService wastesInfoService;
    @Autowired
    ClientService clientService;
    @Autowired
    SupplierService supplierService;
    //添加申报信息==>主表
    @RequestMapping("addStock")
    @ResponseBody
    public String addStock(@RequestBody Stock stock) {
        JSONObject res=new JSONObject();
        System.out.println(JSONObject.fromBean(stock).toString());
        //  1.获取库存申报ID
        List<String> list= stockService.getStockIdList();//合同id集合
        if(list.size()<=0){
            stock.setStockId("1");
        }
        if(list.size()>0) {
            List<Integer> list1 = new ArrayList<>();
            for (String s:list
                    ) {
                int i=Integer.parseInt(s);
                list1.add(i);
            }
            Collections.sort(list1);
            String newId= String.valueOf((list1.get(list1.size()-1)+1)) ;//当前编号
            stock.setStockId(newId);
        }
        stock.setCheckState(CheckState.ToSubmit);//设置为待提交
        //更新产废单位的库容
        stockService.updateCapacity(stock.getClient().getClientId(),stock.getClient().getCapacity());
        stockService.add(stock);
        return res.toString();
    }

    //添加申报信息==>明细
    @RequestMapping("addStockItem")
    @ResponseBody
    public String addStockItem(@RequestBody StockItem stockItem){
        JSONObject res=new JSONObject();
        try{
            List<String> list= stockService.getStockIdList();//合同id集合
            if(list.size()<=0){
                stockItem.setStockId("1");
            }
            else {
                stockItem.setStockId(list.get(0));
            }

           stockService.addStockItem(stockItem);
            //更新报价单状态
            stockService.updateQuotationItemState(stockItem.getId());
            res.put("status", "success");
            res.put("message", "字表添加成功");
        }
        catch (Exception e){
            e.printStackTrace();
            res.put("status", "fail");
            res.put("message", "字表添加失败");

        }



        return  res.toString();



    }






//获取所欲申报信息
    @RequestMapping("loadPageStocktList")
    @ResponseBody
    public String loadPageStocktList(@RequestBody Page page){
        JSONObject res = new JSONObject();
     //1查找所有的库存申报信息
        try {
            List<Stock> stockList=stockService.list(page);
            JSONArray array = JSONArray.fromArray(stockList.toArray(new Stock[stockList.size()]));
            res.put("status", "success");
            res.put("message", "查询成功");
            res.put("stocktList",array);
        }
        catch (Exception e){
            e.printStackTrace();
            res.put("status", "fail");
            res.put("message", "查询失败");
        }
         return  res.toString();

    }
//根据申报编号获取信息
    @RequestMapping("getStockById")
    @ResponseBody
    public String getStockById(String stockId,Page page){
        JSONObject res = new JSONObject();
        try {
            Stock stock=stockService.getById(stockId);
            JSONObject json=JSONObject.fromBean(stock);
            List<WastesInfo> wastesInfoList = wastesInfoService.list();
            JSONArray data = JSONArray.fromArray(wastesInfoList.toArray(new WastesInfo[wastesInfoList.size()]));
            List<Client> clientList = clientService.list();
            List<Supplier> supplierList=supplierService.transportList(page);
            res.put("supplierList",supplierList);
            res.put("clientList",clientList);
             res.put("data", data);
            res.put("stock",json);
            res.put("status", "success");
            res.put("message", "查询成功");
        }
        catch (Exception e){
            e.printStackTrace();
            res.put("status", "fail");
            res.put("message", "查询失败");
        }
     return  res.toString();
    }
//根据公司名获取信息
    @RequestMapping("getStockByName")
    @ResponseBody
    public String getStockByName(String stockName){
        JSONObject res = new JSONObject();
        try {
            Stock stock=stockService.getByName(stockName);
            JSONObject json=JSONObject.fromBean(stock);
            res.put("stock",json);
            res.put("status", "success");
            res.put("message", "查询成功");
        }
        catch (Exception e){
            e.printStackTrace();
            res.put("status", "fail");
            res.put("message", "查询失败");
        }
     return  res.toString();
    }
    //修改申报信息==>主表
    @RequestMapping("adjust1Stock")
    @ResponseBody
    public String adjustStock(@RequestBody Stock stock) {
        JSONObject res=new JSONObject();
        try {
            stockService.updateCapacity(stock.getClient().getClientId(),stock.getClient().getCapacity());
            //更新stock字段
            stockService.updateStock(stock);
            //stockService.time1(stock);
            JSONObject json = JSONObject.fromBean(stock);

            stockService.deleteStockItem(stock.getStockId());
            res.put("stock1", json);
            res.put("status", "success");
            res.put("message", "更新成功");
        }
        catch (Exception e){
            e.printStackTrace();
            res.put("status", "fail");
            res.put("message", "更新失败");
        }
        return res.toString();
    }

    //修改申报信息==>明细表
    @RequestMapping("addStockItem1")
    @ResponseBody
    public String addStockItem1(@RequestBody StockItem stockItem){
        JSONObject res=new JSONObject();

        try {
           stockService.addStockItem(stockItem);
            res.put("status", "success");
            res.put("message", "字表更新成功");
        }
        catch (Exception e){
            e.printStackTrace();
            res.put("status", "fail");
            res.put("message", "字表更新失败");
        }

        return res.toString();


    }


    //提交申报信息
    @RequestMapping("submitStock")
    @ResponseBody
    public String submitStock(String stockId){
   JSONObject res=new JSONObject();
   try {
       stockService.submitStock(stockId);
       res.put("status", "success");
       res.put("message", "提交成功");
   }
   catch (Exception e){
       e.printStackTrace();
       res.put("status", "fail");
       res.put("message", "提交失败");
   }
        return res.toString();
    }
    //作废申报信息
    @RequestMapping("cancelStock")
    @ResponseBody
    public String cancelStock(String stockId){
        JSONObject res=new JSONObject();
        try {
            stockService.cancelStock(stockId);
            res.put("status", "success");
            res.put("message", "作废成功");
        }
        catch (Exception e){
            e.printStackTrace();
            res.put("status", "fail");
            res.put("message", "作废失败");
        }

        return res.toString();
    }
    //获取审核状态
    @RequestMapping("getCheckStateList")
    @ResponseBody
    public String getCheckStateList(){
        JSONObject res = new JSONObject();
        // 获取枚举
        JSONArray checkStateList = JSONArray.fromArray(CheckState.values());
        res.put("checkStateList", checkStateList);
        return res.toString();
    }
//查询功能
    @RequestMapping("searchStock")
    @ResponseBody
    public String searchStock(@RequestBody Stock stock){
        JSONObject res = new JSONObject();
        try {
            List<Stock> stockList = stockService.search(stock);
            JSONArray data = JSONArray.fromArray(stockList.toArray(new Stock[stockList.size()]));
            res.put("status", "success");
            res.put("message", "查询成功");
            res.put("stocktList", data);
        } catch (Exception e) {
            e.printStackTrace();
            res.put("status", "fail");
            res.put("message", "查询失败");
        }
        return res.toString();

    }

    /**
     * 获取总记录数
     * @return
     */
     @RequestMapping("totalStockRecord")
    @ResponseBody
    public int totalStockRecord(){
        try {
            return stockService.total();
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }
    }
    @RequestMapping("searchStockTotal")
    @ResponseBody
    public int searchStockTotal(@RequestBody Stock stock) {
        try {
            return stockService.searchCount(stock);
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }
    }
    /**
     *
     * 库存审批
     */
    @RequestMapping("approvalStock")
    @ResponseBody
    public String approvalStock(String stockId,String opinion){
        JSONObject res=new JSONObject();
        try{
            res.put("status", "success");
            res.put("message", "审批通过！");
            stockService.opinion(stockId,opinion);
        }
        catch (Exception e){
            e.printStackTrace();
            res.put("status", "fail");
            res.put("message", "审批失败！");
        }


        return res.toString();
    }
    /**
     *
     * 库存驳回
     */
    @RequestMapping("backStock")
    @ResponseBody
    public String backStock(String stockId,String backContent){
        JSONObject res=new JSONObject();
        try{
            res.put("status", "success");
            res.put("message", "驳回通过！");
            stockService.back(stockId,backContent);
        }
        catch (Exception e){
            e.printStackTrace();
            res.put("status", "fail");
            res.put("message", "驳回失败！");
        }
        return res.toString();

    }
    @RequestMapping("loadPageStockList")
    @ResponseBody
    public String loadPageStockList(@RequestBody Page page){
        try {
            // 取出查询客户
            List<Stock> stockList = stockService.list(page);
            // 计算最后页位置
            //page.caculateLast(clientService.total());
            JSONArray array = JSONArray.fromArray(stockList.toArray(new Stock[stockList.size()]));
            // 返回结果
            return array.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    /**
     * 获得所有的客户信息
     */
    @RequestMapping("getClientListFromStock")
    @ResponseBody
    public String getClientListFromStock(){
        JSONObject res=new JSONObject();
        try {
            List<Client> clientList = clientService.list();
            res.put("data", clientList);
            res.put("status", "success");
            res.put("message", "客户列表查询成功");
        }
        catch (Exception e){
            e.printStackTrace();
            res.put("status", "fail");
            res.put("message", "客户列表查询失败");
        }
        return  res.toString();
    }
    /**
     * 根据客户编号获得客户
     */
    @RequestMapping("getClientByClientId")
    @ResponseBody
    public  String getClientByClientId(String clientId){
        JSONObject res=new JSONObject();
        try{
            Client client = clientService.getByClientId(clientId);//获得用户
            //获取所有改单位下合同内的报价单信息(未申报的)
            List<QuotationItem>quotationItemList=stockService.getQuotationitemByUndeclared(clientId);

             res.put("status", "success");
            res.put("message", "客户查询成功");
            res.put("data", client);
            res.put("quotationItemData", quotationItemList);
        }
        catch (Exception e){
            e.printStackTrace();
            res.put("status", "fail");
            res.put("message", "客户查询失败");

        }
        return  res.toString();
    }

    //获取所有的供应商
    @RequestMapping("getSupplierListFromStock")
    @ResponseBody
    public String getSupplierListFromStock(Page page){
        JSONObject res=new JSONObject();
        try {
       List<Supplier> supplierList=supplierService.transportList(page);
            res.put("data", supplierList);
            res.put("status", "success");
            res.put("message", "运输类供应商列表查询成功");
        }
        catch (Exception e){
            e.printStackTrace();
            res.put("status", "fail");
            res.put("message", "运输类供应商列表查询失败");
        }
        return  res.toString();
    }

    /*完善库才申报*/
    @RequestMapping("perfectStockItem")
    @ResponseBody
    public String perfectStockItem(@RequestBody StockItem stockItem){
        JSONObject res=new JSONObject();

        try {
                stockService.perfectStockItem(stockItem);
               res.put("status", "success");
              res.put("message", "库存申报完善成功");

        }
        catch (Exception e){
            e.printStackTrace();
            res.put("status", "fail");
            res.put("message", "库存申报完善失败");

        }

            return res.toString();

    }
}
