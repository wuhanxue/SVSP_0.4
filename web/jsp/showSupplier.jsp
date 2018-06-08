<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>供应商新增</title>
    <script src="js/jquery/2.0.0/jquery.min.js"></script>
    <script src="js/jquery/2.0.0/jquery.serializejson.js"></script>
    <link href="css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
    <script src="js/bootstrap/3.3.6/bootstrap.min.js"></script>
    <link href="css/dashboard.css" rel="stylesheet">
</head>
<style>
    .gap {
        margin-top: 5%;
    }
</style>
<script type="text/javascript">
    function loadSelectList() {
        $.ajax({
            type: "POST",                            // 方法类型
            url: "getSelectedList",                  // url
            dataType: "json",
            success: function (result) {
                if (result != undefined) {
                    var data = eval(result);
                    // 各下拉框数据填充
                    var enterpriseType = $("#enterpriseType");
                    enterpriseType.children().remove();
                    $.each(data.enterpriseTypeStrList, function (index, item) {
                        var option = $('<option />');
                        option.val(index);
                        option.text(item.name);
                        enterpriseType.append(option);
                    });
                    enterpriseType.get(0).selectedIndex = ${supplier.enterpriseType.index}-1;
                    var operationType = $("#operationType");
                    operationType.children().remove();
                    $.each(data.operationTypeStrList, function (index, item) {
                        var option = $('<option />');
                        option.val(index);
                        option.text(item.name);
                        operationType.append(option);
                    });
                    operationType.get(0).selectedIndex = ${supplier.operationType.index}-1;
                    var operationRecord = $("#operationRecord");
                    operationRecord.children().remove();
                    $.each(data.operationRecordStrList, function (index, item) {
                        var option = $('<option />');
                        option.val(index);
                        option.text(item.name);
                        operationRecord.append(option);
                    });
                    operationRecord.get(0).selectedIndex = ${supplier.operationRecord.index}-1;
                    var operationMode = $("#operationMode");
                    operationMode.children().remove();
                    $.each(data.operationModeStrList, function (index, item) {
                        var option = $('<option />');
                        option.val(index);
                        option.text(item.name);
                        operationMode.append(option);
                    });
                    operationMode.get(0).selectedIndex = ${supplier.operationMode.index}-1;
                    var contingencyPlan = $("#contingencyPlan");
                    contingencyPlan.children().remove();
                    $.each(data.contingencyPlanStrList, function (index, item) {
                        var option = $('<option />');
                        option.val(index);
                        option.text(item.name);
                        contingencyPlan.append(option);
                    });
                    contingencyPlan.get(0).selectedIndex = ${supplier.contingencyPlan.index}-1;
                    var applicationStatus = $("#applicationStatus");
                    applicationStatus.children().remove();
                    $.each(data.applicationStatusStrList, function (index, item) {
                        var option = $('<option />');
                        option.val(index);
                        option.text(item.name);
                        applicationStatus.append(option);
                    });
                    applicationStatus.get(0).selectedIndex = ${supplier.applicationStatus.index}-1;
                    var supplierType = $("#supplierType");
                    supplierType.children().remove();
                    $.each(data.supplierTypeStrList, function (index, item) {
                        var option = $('<option />');
                        option.val(index);
                        option.text(item.name);
                        supplierType.append(option);
                    });
                    supplierType.get(0).selectedIndex = ${supplier.supplierType.index}-1;
                } else {
                    console.log(result);
                }
            },
            error:function (result) {
                console.log(result);
            }
        });
    }
    function supplierSave() {
        $.ajax({
            type: "POST",                            // 方法类型
            url: "saveSupplier",                       // url
            async : false,                           // 同步：意思是当有返回值以后才会进行后面的js程序
            data: JSON.stringify($('#supplierInfoForm').serializeJSON()),
            dataType: "json",
            contentType: "application/json; charset=utf-8",
            success: function (result) {
                if (result != undefined) {
                    console.log("success: " + result);
                    alert("保存成功!");
                    $(location).attr('href', 'supplierBackup.html');
                } else {
                    console.log("fail: " + result);
                    alert("保存失败!");
                }
            },
            error:function (result) {
                console.log(JSON.stringify($('#supplierInfoForm').serializeJSON()));
                console.log("error: " + result);
                alert("服务器异常!");
            }
        });
    }
    function supplierSubmit() {
        $.ajax({
            type: "POST",                            // 方法类型
            url: "submitSupplier",                     // url
            async : false,                           // 同步：意思是当有返回值以后才会进行后面的js程序
            data: JSON.stringify($('#supplierInfoForm').serializeJSON()),
            dataType: "json",
            contentType: "application/json; charset=utf-8",
            success: function (result) {
                if (result != undefined) {
                    console.log("success: " + result);
                    alert("提交成功!");
                    $(location).attr('href', 'supplierBackup.html');
                } else {
                    console.log("fail: " + result);
                    alert("提交失败!");
                }
            },
            error:function (result) {
                console.log("error: " + result);
                alert("服务器异常!");
            }
        });
    }
</script>
<body onload="loadSelectList();">
    <!--导航条-->
    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">产废服务平台</a>
            </div>
            <div id="navbar" class="collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <li><a href="wastesPlatform.html">首页</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">客户管理<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="clientBackup.html">客户备案</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="salesManage.html">业务员分配管理</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="questionnaireManage.html">危废数据调查表管理</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="sampleManage.html">客户样品登记</a></li>
                        </ul>
                    </li>
                    <li class="dropdown active">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">供应商管理<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="supplierBackup.html">供应商备案</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">合同管理<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="contractManage.html">合同列表</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="contractTemplate.html">合同模板</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">价格管理<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="quotation.html">报价管理</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="cost.html">成本管理</a></li>
                        </ul>
                    </li>
                    <li><a href="#">一企一档</a></li>

                </ul>
            </div><!--/.nav-collapse -->
        </div>
    </nav>

    <div class="container-fluid">
        <div class="row">
            <div class="col-sm-3 col-md-2 sidebar">
                <ul class="nav nav-sidebar">
                    <li><a href="wastesPlatform.html">概览</a></li>
                    <li class="active"><a href="#">商务管理 <span class="sr-only">(current)</span></a></li>
                    <li><a href="#">接收管理</a></li>
                    <li><a href="#">贮存管理</a></li>
                    <li><a href="#">预处理管理</a></li>
                    <li><a href="#">处置管理</a></li>
                    <li><a href="#">次生管理</a></li>
                </ul>
            </div>
        </div>

        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <div class="row">
                <ol class="breadcrumb">
                    <li><a href="businessModel.html">商务管理</a></li>
                    <li><a href="#">供应商管理</a></li>
                    <li><a href="supplierBackup.html">供应商备案</a></li>
                    <li class="active">供应商修改</li>
                </ol>
            </div>
            <h2 class="sub-header">供应商新增</h2>
            <form method="post" id="supplierInfoForm">
                <h4 class="text-info">基本信息</h4>
                <div class="row">
                    <div class="form-horizontal col-md-6">
                        <div class="form-group">
                            <label for="companyName" class="col-sm-4 control-label">企业名称</label>
                            <div class="col-xs-5">
                                <input type="text" class="form-control" id="companyName" name="companyName" placeholder="" value="${supplier.companyName}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="organizationCode" class="col-sm-4 control-label">组织机构代码</label>
                            <div class="col-xs-5">
                                <input type="text" class="form-control" id="organizationCode" name="organizationCode" placeholder="" value="${supplier.organizationCode}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="representative" class="col-sm-4 control-label">法人代表</label>
                            <div class="col-xs-5">
                                <input type="text" class="form-control" id="representative" name="representative" placeholder="" value="${supplier.representative}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="industry" class="col-sm-4 control-label">所属行业</label>
                            <div class="col-xs-5">
                                <input type="text" class="form-control" id="industry" name="industry" placeholder="" value="${supplier.industry}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="enterpriseType" class="col-sm-4 control-label">企业类型</label>
                            <div class="col-xs-5">
                                <select class="form-control" name="enterpriseType" id="enterpriseType">
                                    <option value="0">--请选择--</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="operationType" class="col-sm-4 control-label">经营单位类别</label>
                            <div class="col-xs-5">
                                <select class="form-control" name="operationType" id="operationType">
                                    <option value="0">--请选择--</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="operationRecord" class="col-sm-4 control-label">建立危废经营记录情况</label>
                            <div class="col-xs-5">
                                <select class="form-control" name="operationRecord" id="operationRecord">
                                    <option value="0">--请选择--</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="supplierType" class="col-sm-4 control-label">供应商类型</label>
                            <div class="col-xs-5">
                                <select class="form-control" name="supplierType" id="supplierType">
                                    <option value="0">--请选择--</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="street" class="col-sm-4 control-label">所属街道</label>
                            <div class="col-xs-5">
                                <input type="text" class="form-control" id="street" name="street" placeholder="" value="${supplier.street}">
                            </div>
                        </div>
                    </div>
                    <div class="form-horizontal col-md-6">
                        <div class="form-group">
                            <label for="supplierId" class="col-sm-4 control-label">供应商编码</label>
                            <div class="col-xs-5">
                                <input type="text" class="form-control" id="supplierId" name="supplierId" placeholder="" value="${supplier.supplierId}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="licenseCode" class="col-sm-4 control-label">营业执照注册号</label>
                            <div class="col-xs-5">
                                <input type="text" class="form-control" id="licenseCode" name="licenseCode" placeholder="" value="${supplier.licenseCode}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="postCode" class="col-sm-4 control-label">工商注册地邮编</label>
                            <div class="col-xs-5">
                                <input type="text" class="form-control" id="postCode" name="postCode" placeholder="" value="${supplier.postCode}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="product" class="col-sm-4 control-label">主要产品</label>
                            <div class="col-xs-5">
                                <input type="text" class="form-control" id="product" name="product" placeholder="" value="${supplier.product}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="operationMode" class="col-sm-4 control-label">经营方式</label>
                            <div class="col-xs-5">
                                <select class="form-control" name="operationMode" id="operationMode">
                                    <option value="0">--请选择--</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="contingencyPlan" class="col-sm-4 control-label">事故防范和应急预案</label>
                            <div class="col-xs-5">
                                <select class="form-control" name="contingencyPlan" id="contingencyPlan">
                                    <option value="0">--请选择--</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="applicationStatus" class="col-sm-4 control-label">申报状态</label>
                            <div class="col-xs-5">
                                <select class="form-control" name="applicationStatus" id="applicationStatus">
                                    <option value="0">--请选择--</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="location" class="col-sm-4 control-label">工商注册地址</label>
                            <div class="col-xs-5">
                                <input type="text" class="form-control" id="location" name="location" placeholder="" value="${supplier.location}">
                            </div>
                        </div>
                    </div>
                </div>
                <h4 class="text-info">联系方式</h4>
                <div class="row">
                    <div class="form-horizontal col-md-6">
                        <div class="form-group">
                            <label for="contactName" class="col-sm-4 control-label">联系人</label>
                            <div class="col-xs-5">
                                <input type="text" class="form-control" id="contactName" name="contactName" placeholder="" value="${supplier.contactName}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="mobile" class="col-sm-4 control-label">手机号</label>
                            <div class="col-xs-5">
                                <input type="text" class="form-control" id="mobile" name="mobile" placeholder="" value="${supplier.mobile}">
                            </div>
                        </div>
                    </div>
                    <div class="form-horizontal col-md-6">
                        <div class="form-group">
                            <label for="phone" class="col-sm-4 control-label">联系电话</label>
                            <div class="col-xs-5">
                                <input type="text" class="form-control" id="phone" name="phone" placeholder="" value="${supplier.phone}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="email" class="col-sm-4 control-label">邮箱</label>
                            <div class="col-xs-5">
                                <input type="email" class="form-control" id="email" name="email" placeholder="" value="${supplier.email}">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row text-center gap">
                    <a class="btn btn-success" onclick="supplierSave();">保存</a>
                    <a class="btn btn-primary" onclick="supplierSubmit();">提交</a>
                    <a class="btn btn-danger" href="supplierBackup.html">返回</a>
                </div>
            </form>
        </div>
    </div>
</body>
<script type="text/javascript">
    /**
     * 界面加载完成后延时10ms再进行jq操作，ajax的post请求后会发生短暂的局部刷新
     */
    $(document).ready(function(){
        setTimeout('setSelectValue()', 20);
    });
    /**
     * 设置界面中下拉框的选中情况
     */
    function setSelectValue() {

    }
</script>
</html>