<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="top02.jsp"/>
<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> 编辑员工信息 </h2>
            <p class="lead"></p>
        </div>
        <div class="theme-primary mw1000 center-block" style="width: 600px;margin-left: 400px">
            <div class="panel heading-border">
                <form:form action="/user/update_user" modelAttribute="user" method="post" commandName="user" id="admin-form" name="addForm">
                    <%--为了保证提交信息的完整性，用隐藏域的方式将密码获取到，并提交上去--%>
                    <form:hidden path="password"/>
                    <div class="panel-body bg-light">
                        <div class="section-divider mt20 mb40">
                            <span> 基本信息 </span>
                        </div>
                        <div class="section row">
                            <div class="col-md-6">
                                <label for="userName" class="field prepend-icon">
                                    <form:input path="userId" cssClass="gui-input" placeholder="用户账号" readonly="true" />
                                    <label for="userName" class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                            <div class="col-md-6">
                                <label for="phone" class="field prepend-icon">
                                    <form:input path="userName" class="gui-input" placeholder="用户姓名" readonly="true"/>
                                    <label for="phone" class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                        </div>
                        <div class="section row">
                            <div class="col-md-6">
                                <label for="phone" class="field prepend-icon">
                                    <form:input path="phone" class="gui-input" placeholder="用户电话" readonly="true"/>
                                    <label for="phone" class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                            <div class="col-md-6">
                                <label for="identity" class="field select">
                                    <form:select path="identity" items="${plist}" cssClass="gui-input" placeholder="用户身份"/>
                                    <i class="arrow double"></i>
                                </label>
                            </div>
                        </div>
                        <div class="panel-footer text-right">
                            <button type="submit" class="button"> 保存 </button>
                            <button type="button" class="button" onclick="javascript:window.history.go(-1);"> 返回 </button>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</section>

