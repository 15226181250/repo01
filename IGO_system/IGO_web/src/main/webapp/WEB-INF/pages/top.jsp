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
<div class="container" >
    <div class="row">
        <div class="page-header">
            <h1 style="color: #FFFFFF">IGO&nbsp;&nbsp;&nbsp;爱&nbsp;购&nbsp;商&nbsp;城
                <small>www.igo.com</small>
            </h1>
        </div>
    </div>
    <%--导航条--%>
    <div class="row" >
        <nav class="navbar navbar-default" style="background-color: lightseagreen">
            <div class="container-fluid" style="background-color: lightseagreen">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">导航栏</a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li><a  href="/to_start" style="font-size: 18px"><b> 首页 </b> <span class="sr-only">(current)</span></a></li>
                        <li><a href="#" style="font-size: 18px"> 限时特惠 </a></li>
                        <%--这里是第一个下拉框--%>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"  style="font-size: 18px"> 分类 <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="/goods/goods_type_list?goodsType=${"食品"}">食品</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="/goods/goods_type_list?goodsType=${"玩具"}">玩具</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="/goods/goods_type_list?goodsType=${"家电"}">家电</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="/goods/goods_type_list?goodsType=${"服装"}">服装</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="/goods/goods_type_list?goodsType=${"家具"}">家具</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="/goods/goods_type_list?goodsType=${"生活用品"}">生活用品</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="/goods/goods_type_list?goodsType=${"智能产品"}">智能产品</a></li>
                            </ul>
                        </li>
                    </ul>
                    <form class="navbar-form navbar-left" action="/goods/goods_find" method="post">
                        <div class="form-group">
                            <input type="text" name="goodsName" class="form-control" placeholder="🔍">
                        </div>
                        <button type="submit" class="btn btn-default"  style="font-size: 15px">搜索商品</button>
                    </form>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="#"  style="font-size: 18px"> 消息 </a></li>
                        <li><a href="/bill/to_bill_list"  style="font-size: 18px"> 购物车 </a></li>
                    <%--这里是第二个下拉框，用来存放用户相关操作--%>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><b  style="font-size: 18px"> 个人中心 </b><span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a><%
                                    User user = request.getSession()==null?null:(User)request.getSession().getAttribute("user");
                                    String loginName = (user==null?"未登录":user.getUserName());
                                %>
                                    <%=loginName%></a></li>
                                <li><a href="/to_login">用户登录</a></li>
                                <li><a href="/self">个人信息</a></li>
                                <li><a href="/quit">退出登录</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="/user/to_add">注册新用户</a></li>
                            </ul>
                        </li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>
    </div>
</div>
</body>
</html>
