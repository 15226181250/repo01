<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="top.jsp"/>
<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> 注册新用户 </h2>
            <p class="lead"></p>
        </div>
        <div class="theme-primary mw1000 center-block" style="width: 600px;margin-left: 400px">
            <div class="panel heading-border">
                <%--使用springMVC提供的form标签,action为提交到哪个控制器,modelAttribute是最后添加完封装成的对象,要保持一致--%>
                <%--保存之后自动封装成modelAttribute指定的对象然后通过action来传给指定的修改控制器--%>
                <%--springMVCform标签提供的表单--%>
                <form:form action="/user/add" modelAttribute="user" method="post" commandName="user" id="admin-form" name="addForm">
                    <div class="panel-body bg-light">
                        <div class="section-divider mt20 mb40">
                            <span> 基本信息 </span>
                        </div>
                        <div class="section row">
                            <div class="col-md-6">
                                <label class="field prepend-icon">
                                        <%--springMVCform标签提供的输出框,path是属性名--%>
                                    <form:input path="userId" cssClass="gui-input" placeholder="用户账号" />
                                    <label class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                            <div class="col-md-6">
                                <label class="field prepend-icon">
                                        <%--springMVCform标签提供的输出框--%>
                                    <form:input path="userName" class="gui-input" placeholder="用户姓名"/>
                                    <label class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                        </div>
                        <div class="section row">
                            <div class="col-md-6">
                                <label class="field prepend-icon">
                                        <%--springMVCform标签提供的输出框,path是属性名--%>
                                    <form:input path="password" class="gui-input" placeholder="用户密码"/>
                                    <label class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                            <div class="col-md-6">
                                <label class="field prepend-icon">
                                        <%--springMVCform标签提供的输出框--%>
                                    <form:input path="phone" class="gui-input" placeholder="联系方式"/>
                                    <label class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                        </div>
                        <div class="section">
                            <label class="field prepend-icon">
                                    <%--springMVCform标签提供的输出框--%>
                                <form:select path="identity" items="${plist}" cssClass="gui-input" placeholder="用户身份"/>
                                <label class="field-icon">
                                    <i class="fa fa-lock"></i>
                                </label>
                            </label>
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

