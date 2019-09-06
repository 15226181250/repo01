<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="top.jsp"/>
<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> 联系客服 </h2>
            <p class="lead"></p>
        </div>
        <div class="theme-primary mw1000 center-block" style="width: 600px;margin-left: 400px">
            <div class="panel heading-border">
                <%--使用springMVC提供的form标签,action为提交到哪个控制器,modelAttribute是最后添加完封装成的对象,要保持一致--%>
                <%--保存之后自动封装成modelAttribute指定的对象然后通过action来传给指定的修改控制器--%>
                <%--springMVCform标签提供的表单--%>
                <form:form action="/bill/session" modelAttribute="session" method="post" commandName="session" id="admin-form" name="addForm">
                    <div class="panel-body bg-light">
                        <div class="panel-body bg-light">
                            <div class="section row">
                                <div class="col-md-6">
                                    <label class="field prepend-icon">
                                            <%--springMVCform标签提供的输出框,path是属性名--%>
                                        <form:input path="content" cssClass="gui-input" placeholder="内容" />
                                        <label class="field-icon">
                                            <i class="fa fa-user"></i>
                                        </label>
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
</section>

