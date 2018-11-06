
/**
 * 合约量统计脚本
 * */

var isSearch = false;
var currentPage = 1;                          //当前页数
var data;


/**
 * 返回count值
 * */
function countValue() {
    var mySelect = document.getElementById("count");
    var index = mySelect.selectedIndex;
    return mySelect.options[index].text;
}

function keyLogin(){
    if (event.keyCode==13)  //回车键的键值为13
        document.getElementById("input1").click(); //调用登录按钮的登录事件
}



/**
 * 计算总页数
 * */
function totalPage() {
    var totalRecord = 0;
    if (!isSearch) {
        $.ajax({
            type: "POST",                       // 方法类型
            url: "totalContractVolume",                  // url
            async: false,                      // 同步：意思是当有返回值以后才会进行后面的js程序
            dataType: "json",
            success: function (result) {
                // console.log(result);
                if (result > 0) {
                    totalRecord = result;
                } else {
                    console.log("fail: " + result);
                    totalRecord = 0;
                }
            },
            error: function (result) {
                console.log("error: " + result);
                totalRecord = 0;
            }
        });
    } else {
        totalRecord = array1.length;
    }
    var count = countValue();                         // 可选
    return loadPages(totalRecord, count);
}

/**
 * 计算分页总页数
 * @param totalRecord
 * @param count
 * @returns {number}
 */
function loadPages(totalRecord, count) {
    if (totalRecord == 0) {
        console.log("总记录数为0，请检查！");
        return 0;
    }
    else if (totalRecord % count == 0)
        return totalRecord / count;
    else
        return parseInt(totalRecord / count) + 1;
}

/**
 * 克隆页码
 * @param result
 */
function setPageClone(result) {
    $(".beforeClone").remove();
    if(result!=null){
        setContractVolume(result);
    }
    var total = totalPage();
    $("#next").prev().hide();
    var st = "共" + total + "页";
    $("#totalPage").text(st);
    var myArray = new Array();
    for (var i = 0; i < total; i++) {
        var li = $("#next").prev();
        myArray[i] = i + 1;
        var clonedLi = li.clone();
        clonedLi.show();
        clonedLi.find('a:first-child').text(myArray[i]);
        clonedLi.find('a:first-child').click(function () {
            var num = $(this).text();
            switchPage(num);
            AddAndRemoveClass(this);
        });
        clonedLi.addClass("beforeClone");
        clonedLi.removeAttr("id");
        clonedLi.insertAfter(li);
    }
    $("#previous").next().next().eq(0).addClass("active");       // 将首页页面标蓝
    $("#previous").next().next().eq(0).addClass("oldPageClass");
}

/**
 * 设置选中页页码标蓝
 */
function AddAndRemoveClass(item) {
    $('.oldPageClass').removeClass("active");
    $('.oldPageClass').removeClass("oldPageClass");
    $(item).parent().addClass("active");
    $(item).parent().addClass("oldPageClass");
}

/**
 * 点击页数跳转页面
 * @param pageNumber 跳转页数
 * */
function switchPage(pageNumber) {

    if (pageNumber == 0) {                 //首页
        pageNumber = 1;
    }
    if (pageNumber == -2) {
        pageNumber = totalPage();        //尾页
    }
    if (pageNumber == null || pageNumber == undefined) {
        console.log("参数为空,返回首页!");
        pageNumber = 1;
    }
    $("#current").find("a").text("当前页：" + pageNumber);
    if (pageNumber == 1) {
        $("#previous").addClass("disabled");
        $("#firstPage").addClass("disabled");
        $("#next").removeClass("disabled");
        $("#endPage").removeClass("disabled");
    }
    if (pageNumber == totalPage()) {
        $("#next").addClass("disabled");
        $("#endPage").addClass("disabled");
        $("#previous").removeClass("disabled");
        $("#firstPage").removeClass("disabled");
    }
    if (pageNumber > 1) {
        $("#previous").removeClass("disabled");
        $("#firstPage").removeClass("disabled");
    }
    if (pageNumber < totalPage()) {
        $("#next").removeClass("disabled");
        $("#endPage").removeClass("disabled");
    }
    var page = {};
    page.count = countValue();                        //可选
    page.pageNumber = pageNumber;
    currentPage = pageNumber;          //当前页面
    setPageCloneAfter(pageNumber);        // 重新设置页码
    addPageClass(pageNumber);           // 设置页码标蓝
    //addClass("active");
    page.start = (pageNumber - 1) * page.count;
    if (!isSearch) { //分页用的
        $.ajax({
            type: "POST",                       // 方法类型
            url: "loadContractVolumeList",         // url
            async: false,                      // 同步：意思是当有返回值以后才会进行后面的js程序
            data: JSON.stringify(page),
            dataType: "json",
            contentType: 'application/json;charset=utf-8',
            success: function (result) {
                if (result != undefined) {
                    // console.log(result);
                    setContractVolume(result.data);
                } else {
                    console.log("fail: " + result);
                    // setClientList(result);
                }
            },
            error: function (result) {
                console.log("error: " + result);
                // setClientList(result);
            }
        });
    }
    if (isSearch) {//查询用的
        for(var i=0;i<array1.length;i++){
            $(array1[i]).hide();
        }
        var i=parseInt((pageNumber-1)*countValue());
        var j=parseInt((pageNumber-1)*countValue())+parseInt(countValue()-1);
        for(var i=i;i<=j;i++){
            $('#tbody1').append(array1[i]);
            $(array1[i]).show();
        }
    }
    CalculateAggregate() ;
}

/**
 * 输入页数跳转页面
 * */
function inputSwitchPage() {
    var pageNumber = $("#pageNumber").val();    // 获取输入框的值
    $("#current").find("a").text("当前页：" + pageNumber);
    if (pageNumber == null || pageNumber == undefined) {
        window.alert("跳转页数不能为空！")
    } else {
        if (pageNumber == 1) {
            $("#previous").addClass("disabled");
            $("#firstPage").addClass("disabled");
            $("#next").removeClass("disabled");
            $("#endPage").removeClass("disabled");
        }
        if (pageNumber == totalPage()) {
            $("#next").addClass("disabled");
            $("#endPage").addClass("disabled");
            $("#previous").removeClass("disabled");
            $("#firstPage").removeClass("disabled");
        }
        if (pageNumber > 1) {
            $("#previous").removeClass("disabled");
            $("#firstPage").removeClass("disabled");
        }
        if (pageNumber < totalPage()) {
            $("#next").removeClass("disabled");
            $("#endPage").removeClass("disabled");
        }
        currentPage = pageNumber;
        setPageCloneAfter(pageNumber);        // 重新设置页码
        addPageClass(pageNumber);           // 设置页码标蓝
        var page = {};
        page.count = countValue();//可选
        page.pageNumber = pageNumber;
        page.start = (pageNumber - 1) * page.count;
        if (!isSearch) {
            $.ajax({
                type: "POST",                       // 方法类型
                url: "loadPageStockList",         // url
                async: false,                      // 同步：意思是当有返回值以后才会进行后面的js程序
                data: JSON.stringify(page),
                dataType: "json",
                contentType: 'application/json;charset=utf-8',
                success: function (result) {
                    if (result != undefined) {
                        // console.log(result);
                        setStockList(result);
                    } else {
                        console.log("fail: " + result);
                        // setClientList(result);
                    }
                },
                error: function (result) {
                    console.log("error: " + result);
                    // setClientList(result);
                }
            });
        }
        if (isSearch) {//查询用的
            for (var i = 0; i < array1.length; i++) {
                $(array1[i]).hide();
            }
            var i = parseInt((pageNumber - 1) * countValue());
            var j = parseInt((pageNumber - 1) * countValue()) + parseInt(countValue() - 1);
            for (var i = i; i <= j; i++) {
                $('#tbody1').append(array1[i]);
                $(array1[i]).show();
            }
        }
        CalculateAggregate() ;
    }
}

/**加载合约量统计页面*/
function loadContractVolumeList() {
    $("#current").find("a").text("当前页：1");
    $("#previous").addClass("disabled");
    $("#firstPage").addClass("disabled");
    if (totalPage() == 1) {
        $("#next").addClass("disabled");
        $("#endPage").addClass("disabled");
    }
    var page = {};
    var pageNumber = 1;                       // 显示首页
    page.count = countValue();                                 // 可选
    page.pageNumber = pageNumber;
    page.start = (pageNumber - 1) * page.count;
    $.ajax({
        type: "POST",                       // 方法类型
        url: "loadContractVolumeList",          // url
        async: false,                       // 同步：意思是当有返回值以后才会进行后面的js程序
        data: JSON.stringify(page),
        dataType: "json",
        contentType: 'application/json;charset=utf-8',
        success: function (result) {
            if (result != undefined && result.status == 'success') {
                console.log(result);
                 setPageClone(result.data);
                setPageCloneAfter(pageNumber);        // 重新设置页码
            } else {
                console.log("fail: " + result);
            }
        },
        error: function (result) {
            console.log("error: " + result);
            console.log("失败");
        }
    });

    isSearch = false;

   CalculateAggregate() ;



}

/**
 * 设置合约量数据
 * @param result
 */
function setContractVolume(result) {
   // 获取id为cloneTr的tr元素
    var tr = $("#cloneTr");
    tr.siblings().remove();
    $.each(result,function (index,item) {
        var clonedTr = tr.clone();
        clonedTr.attr('class', 'myclass');
        clonedTr.show();
        clonedTr.children('td').each(function (inner_index) {
            var obj = eval(item);
            // 根据索引为部分td赋值
            switch (inner_index) {
                case (1):
                    $(this).html(index+1);
                    break;

                    //公司
                case (2):
                    if(obj.client!=null){
                        $(this).html(obj.client.companyName);
                    }
                    break;
                    //危废名称
                case (3):
                        $(this).html(obj.wastesName);
                    break;
                    //危废代码
                case (4):
                    $(this).html(obj.wastesCode);
                    break;
                    //合约量
                case (5):
                    $(this).html(obj.contractAmount.toFixed(2));
                    break;
                    //处置金额
                case (6):
                    $(this).html(obj.unitPriceTax.toFixed(2));
                    break;
                    //签订日期
                case (7):
                    $(this).html(getDateStr(obj.contract.beginTime));
                    break;
                    //截止日期
                case (8):
                    $(this).html(getDateStr(obj.contract.endTime));
                    break;
            }
            clonedTr.removeAttr("id");
          clonedTr.insertBefore(tr);


        })

    })
    tr.hide();

}



array=[];//存放所有的tr
array1=[];//存放目标的tr
//危废出库查询


$(document).ready(function () {//页面载入是就会进行加载里面的内容
    var last;
    $('#searchContent').keyup(function (event) { //给Input赋予onkeyup事件
        last = event.timeStamp;//利用event的timeStamp来标记时间，这样每次的keyup事件都会修改last的值，注意last必需为全局变量
        setTimeout(function () {
            if(last-event.timeStamp==0){
                searchFuzzy();
            }
            else if (event.keyCode === 13) {   // 如果按下键为回车键，即执行搜素
                searchFuzzy();      //
            }
        },600);
    });
});

//合约量粗查询
function searchFuzzy() {
    isSearch=false;
    //分页模糊查询
    array.length=0;//清空数组
    array1.length=0;
    var text=$.trim($('#searchContent').val());

    for(var i=totalPage();i>0;i--){
        switchPage(parseInt());
        array.push($('.myclass'));
    }

    if(text.length<=0){
        localStorage.name="Wastes";
        loadPageContractManageList();
    }

    isSearch=true;
    for(var j=0;j<array.length;j++){
        $.each(array[j],function () {
            //console.log(this);
            if(($(this).children('td').text().indexOf(text)==-1)){
                $(this).hide();
            }
            if($(this).children('td').text().indexOf(text)!=-1){
                array1.push($(this));
            }
        });
    }
    console.log(array1)
    var total;

    if(array1.length%countValue()==0){
        total=array1.length/countValue()
    }

    if(array1.length%countValue()>0){
        total=Math.ceil(array1.length/countValue());
    }

    if(array1.length/countValue()<1){
        total=1;
    }

    $("#totalPage").text("共" + total + "页");

    var myArray = new Array();

    $('.beforeClone').remove();

    for ( i = 0; i < total; i++) {
        var li = $("#next").prev();
        myArray[i] = i+1;
        var clonedLi = li.clone();
        clonedLi.show();
        clonedLi.find('a:first-child').text(myArray[i]);
        clonedLi.find('a:first-child').click(function () {
            var num = $(this).text();
            switchPage(num);
            AddAndRemoveClass(this);
        });
        clonedLi.addClass("beforeClone");
        clonedLi.removeAttr("id");
        clonedLi.insertAfter(li);
    }
    $("#previous").next().next().eq(0).addClass("active");       // 将首页页面标蓝
    $("#previous").next().next().eq(0).addClass("oldPageClass");

    for(var i=0;i<array1.length;i++){
        array1[i].hide();
    }

    for(var i=0;i<countValue();i++){
        $(array1[i]).show();
        $('#tbody1').append((array1[i]));
    }


    CalculateAggregate() ;

}


//合约量高级查询
function searchContract() {
    isSearch=false;
    array.length=0;//清空数组
    array1.length=0;

    var text=$.trim($('#searchContent').val());//输入框

    var companyName=$.trim($('#search-companyName').val());//产废单位


   var wastesName=$.trim($('#search-wastesName').val());//危废名称

    var wastesCode=$.trim($('#search-wastesCode').val());//危废编码


    var beginTime=$.trim($('#beginTime').val());

    var endTime=$.trim($('#endTime').val());

    var startDate=getDateByStr(beginTime);

    var endDate=getDateByStr(endTime);



        for(var i=totalPage();i>0;i--){
            switchPage(parseInt(i));
            array.push($('.myclass'));
        }
        console.log(array.length)







    isSearch=true;
    var arraydate=[];//签订日期
    for(var j=0;j<array.length;j++){
        $.each(array[j],function () {
            arraydate.push(($(this).children('td').eq(7).text()))
        });
    }
    // console.log(arraydate)
    var arraydate1=[];//截止日期
    for(var j=0;j<array.length;j++){
        $.each(array[j],function () {
            arraydate1.push(($(this).children('td').eq(8).text()))
        });
    }


    var dateMin=(arraydate[0]);
    var dateMax=(arraydate1[0]);
    for(var i=0;i<arraydate.length;i++){
        if(new Date(arraydate[i]).getTime()<new Date(dateMin)||dateMin.length==0){
            dateMin=(arraydate[i]);
        }

    }
    for(var i=0;i<arraydate1.length;i++){
        if(new Date(arraydate1[i]).getTime()>new Date(dateMax)||dateMax.length==0){
            dateMax=(arraydate1[i]);
        }
    }
    // console.log(dateMin+dateMax)
    for(var j=0;j<array.length;j++){
        $.each(array[j],function () {

            if(startDate.toString()=='Invalid Date'){
                startDate=dateMin;
            }
            if(endDate.toString()=='Invalid Date'){
                endDate=dateMax;
            }
            var  start=$(this).children('td').eq(7).text();
            var  end=$(this).children('td').eq(8).text();
            var code=($(this).children('td').eq(4).text().toString()).substring($(this).children('td').eq(4).text().length-2,$(this).children('td').eq(4).text().length);
            // console.log(code)
            if(start.length==0){
                start=startDate;
            }
            if(end.length==0){
                end=endDate;
            }
            if(!($(this).children('td').eq(2).text().indexOf(companyName)!=-1
                &&$(this).children('td').text().indexOf(text)!=-1
                &&$(this).children('td').eq(3).text().indexOf(wastesName)!=-1&&(new Date(start).getTime()>=new Date(startDate).getTime())
                &&(new Date(end).getTime()<=new Date(endDate).getTime()&&code.indexOf(wastesCode)!=-1)
            )){
                $(this).hide();
            }
            if(($(this).children('td').eq(2).text().indexOf(companyName)!=-1
                &&$(this).children('td').text().indexOf(text)!=-1&&
                (new Date(start).getTime()>=new Date(startDate).getTime())
                &&$(this).children('td').eq(3).text().indexOf(wastesName)!=-1
                &&(new Date(end).getTime()<=new Date(endDate).getTime())&&code.indexOf(wastesCode)!=-1)
            ){
                array1.push($(this));
            }
        });
    }


    console.log(array1)

    var total;

    if(array1.length%countValue()==0){
        total=array1.length/countValue()
    }

    if(array1.length%countValue()>0){
        total=Math.ceil(array1.length/countValue());
    }

    if(array1.length/countValue()<1){
        total=1;
    }

    $("#totalPage").text("共" + total + "页");

    var myArray = new Array();

    $('.beforeClone').remove();

    for ( i = 0; i < total; i++) {
        var li = $("#next").prev();
        myArray[i] = i+1;
        var clonedLi = li.clone();
        clonedLi.show();
        clonedLi.find('a:first-child').text(myArray[i]);
        clonedLi.find('a:first-child').click(function () {
            var num = $(this).text();
            switchPage(num);
            AddAndRemoveClass(this);
        });
        clonedLi.addClass("beforeClone");
        clonedLi.removeAttr("id");
        clonedLi.insertAfter(li);
    }
    $("#previous").next().next().eq(0).addClass("active");       // 将首页页面标蓝
    $("#previous").next().next().eq(0).addClass("oldPageClass");

    for(var i=0;i<array1.length;i++){
        array1[i].hide();
    }

    for(var i=0;i<countValue();i++){
        $(array1[i]).show();
        $('#tbody1').append((array1[i]));
    }



    CalculateAggregate();
}



/**
 * 回车查询
 */
function enterSearch() {
    if (event.keyCode === 13) {   // 如果按下键为回车键，即执行搜素
        searchContract();      //
    }
}

//计算合计==合约量合计 处置金额合计
function CalculateAggregate() {
    var totalVolume=0;//合约量合计
    var totalMoney=0;//处置金额合计
    $('.myclass').each(function () {
        //只要显示的行即可
        if($(this).attr('style')=='display: table-row;'){
            var Volume=parseFloat($(this).children('td').eq(5).html());
            totalVolume+=parseFloat(Volume);
            var Money=parseFloat($(this).children('td').eq(6).html());
            totalMoney+=parseFloat(Money);
        }
    })
    console.log(totalVolume+" "+totalMoney)

    $('#total').children('td').eq(5).html(totalVolume.toFixed(2));
    $('#total').children('td').eq(6).html(totalMoney.toFixed(2));

}