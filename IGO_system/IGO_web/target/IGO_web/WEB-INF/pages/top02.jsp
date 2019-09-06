<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ page isELIgnored="false" %>
<%@ page import="com.project.igo.entity.User" %>


<html>
<head>

    <link rel="stylesheet" type="text/css" href="/assets/skin/default_skin/css/theme.css">
    <link rel="stylesheet" type="text/css" href="/assets/admin-tools/admin-forms/css/admin-forms.css">
    <link rel="shortcut icon" href="/assets/img/favicon.ico">

    <link rel="stylesheet" href="/lib/bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
    <script src="/lib/jquery-3.2.1/jquery-3.2.1.min.js"></script>
    <script src="/lib/bootstrap-3.3.7-dist/js/bootstrap.js/bootstrap.min.js"></script>
    <script src="/lib/masonry-docs/masonry-docs/css/masonry-docs.css"></script>

    <script src="/vendor/jquery/jquery-1.11.1.min.js"></script>
    <script src="/vendor/jquery/jquery_ui/jquery-ui.min.js"></script>
    <script src="/assets/admin-tools/admin-forms/js/jquery.validate.min.js"></script>
    <script src="/assets/admin-tools/admin-forms/js/additional-methods.min.js"></script>
    <script src="/assets/admin-tools/admin-forms/js/jquery-ui-datepicker.min.js"></script>
    <script src="/assets/js/utility/utility.js"></script>
    <script src="/assets/js/demo/demo.js"></script>
    <script src="/assets/js/main.js"></script>
    <script type="text/javascript" src="/js/pages.js"></script>
    <script type="text/javascript" src="/js/items.js"></script>
    <title>Title</title>
</head>
<body style="background-image: url(/assets/img/goods/aaa.jpg);
             background-repeat: no-repeat;
             background-attachment: fixed">
<div class="container">
    <div class="row">
        <div class="page-header">
            <h1 style="color: #FFFFFF">IGO&nbsp;&nbsp;&nbsp;爱&nbsp;购&nbsp;商&nbsp;城
                <small>www.igo.com</small>
            </h1>
        </div>
    </div>
    <%--导航条--%>
    <div class="list-group" style="width: 1100px;text-align: center">
        <div class="list-group-item active"  style="background-color: lightseagreen">
            <b>后 台 管 理 系 统</b>
        </div>
        <a href="/user/user_list" class="list-group-item" style="background-color: #a3fdf1">用 户 列 表</a>
        <a href="/user/business_list" class="list-group-item" style="background-color: #a3fdf1">商 家 列 表</a>
        <a href="/goods/goods_list" class="list-group-item" style="background-color: #a3fdf1">商 品 列 表</a>
        <a href="/bill/handle_list" class="list-group-item" style="background-color: #a3fdf1">交 易 列 表</a>
        <a href="/quit" class="list-group-item active" style="background-color: lightseagreen">退 出 系 统</a>
    </div>
</div>
</body>
</html>
