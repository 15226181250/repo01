<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="top02.jsp"/>
<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> 编辑商品信息 </h2>
            <p class="lead"></p>
        </div>
        <div class="theme-primary mw1000 center-block" style="width: 600px;margin-left: 400px">
            <div class="panel heading-border">
                <form:form action="/goods/update_goods" modelAttribute="goods" method="post" commandName="goods" id="admin-form" name="addForm">
                    <%--为了保证提交信息的完整性，用隐藏域的方式将密码获取到，并提交上去--%>
                    <div class="panel-body bg-light">
                        <div class="section-divider mt20 mb40">
                            <span> 基本信息 </span>
                        </div>
                        <div class="section row">
                            <div class="col-md-6">
                                <label for="goodsId" class="field prepend-icon">
                                    <form:input path="goodsId" cssClass="gui-input" placeholder="商品编号" readonly="true" />
                                    <label for="goodsId" class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                            <div class="col-md-6">
                                <label for="goodsName" class="field prepend-icon">
                                    <form:input path="goodsName" class="gui-input" placeholder="商品名称" readonly="true"/>
                                    <label for="goodsName" class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                        </div>
                        <div class="section row">
                            <div class="col-md-6">
                                <label for="goodsPrice" class="field prepend-icon">
                                    <form:input path="goodsPrice" class="gui-input" placeholder="商品价格"/>
                                    <label for="goodsPrice" class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                            <div class="col-md-6">
                                <label for="goodsType" class="field select">
                                    <form:select path="goodsType" items="${plist}" cssClass="gui-input" placeholder="商品类型"/>
                                    <i class="arrow double"></i>
                                </label>
                            </div>
                        </div>
                        <div class="section row">
                            <div class="col-md-6">
                                <label for="businessId" class="field prepend-icon">
                                    <form:input path="businessId" cssClass="gui-input" placeholder="商家编号" />
                                    <label for="businessId" class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                            <div class="col-md-6">
                                <label for="goodsPhoto" class="field prepend-icon">
                                    <form:input path="goodsPhoto" class="gui-input" placeholder="商品照片"/>
                                    <label for="goodsPhoto" class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                        </div>
                        <div class="section row">
                            <div class="col-md-6">
                                <label for="introduce" class="field prepend-icon">
                                    <form:input path="introduce" cssClass="gui-input" placeholder="商品介绍"/>
                                    <label for="businessId" class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                        </div>
                        <div class="panel-footer text-right">
                            <button type="submit" class="button"> 保存修改 </button>
                            <button type="button" class="button" onclick="javascript:window.history.go(-1);"> 返回 </button>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</section>

