<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="top02.jsp"/>

<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2 style="color: #FFFFFF"> 商 品 列 表 </h2>
            <p class="lead"></p>
        </div>
        <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
            <div class="panel  heading-border">
                <div class="panel-menu">
                    <div class="row">
                        <div class="hidden-xs hidden-sm col-md-3">
                            <div class="btn-group">
                                <button type="button" class="btn btn-default light">
                                    <i class="fa fa-refresh" onclick="javascript:window.history.go(0);"></i>
                                </button>
                                <button type="button" class="btn btn-default light">
                                    <i class="fa fa-trash"></i>
                                </button>
                                <button type="button" class="btn btn-default light">
                                    <i class="fa fa-plus" onclick="javascript:window.location.href='/goods/goods_to_add';"></i>
                                </button>
                            </div>
                        </div>
                        <div class="col-xs-12 col-md-9 text-right">
                            <div class="btn-group">
                                <button type="button" class="btn btn-default light">
                                    <i class="fa fa-chevron-left"></i>
                                </button>
                                <button type="button" class="btn btn-default light">
                                    <i class="fa fa-chevron-right"></i>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="panel-body pn">
                    <table id="message-table" class="table admin-form theme-warning tc-checkbox-1">
                        <thead>
                        <tr class="">
                            <th class="text-center hidden-xs">Select</th>
                            <th class="hidden-xs">商品编号</th>
                            <th class="hidden-xs">商品名称</th>
                            <th class="hidden-xs">商品类型</th>
                            <th class="hidden-xs">商品价格</th>
                            <th class="hidden-xs">所属商家</th>
                            <th class="hidden-xs">商家电话</th>
                            <th class="hidden-xs">商品介绍</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${goodslist}" var="emp">
                            <tr class="message-unread">
                                <td class="hidden-xs">
                                    <label class="option block mn">
                                        <input type="checkbox" name="mobileos" value="FR">
                                        <span class="checkbox mn"></span>
                                    </label>
                                </td>
                                <td>${emp.goodsId}</td>
                                <td>${emp.goodsName}</td>
                                <td class="hidden-xs">
                                    <c:if test="${emp.goodsType=='服装'}">
                                        <span class="badge badge-warning mr10 fs11" style="background-color: olivedrab">${emp.goodsType}</span>
                                    </c:if>
                                    <c:if test="${emp.goodsType=='食品'}">
                                        <span class="badge badge-warning mr10 fs11" style="background-color: lightsalmon">${emp.goodsType}</span>
                                    </c:if>
                                    <c:if test="${emp.goodsType=='家具'}">
                                        <span class="badge badge-warning mr10 fs11" style="background-color: lightsteelblue">${emp.goodsType}</span>
                                    </c:if>
                                    <c:if test="${emp.goodsType=='家电'}">
                                        <span class="badge badge-warning mr10 fs11" style="background-color: lightskyblue">${emp.goodsType}</span>
                                    </c:if>
                                    <c:if test="${emp.goodsType=='生活用品'}">
                                        <span class="badge badge-warning mr10 fs11" style="background-color: lightseagreen">${emp.goodsType}</span>
                                    </c:if>
                                    <c:if test="${emp.goodsType=='智能产品'}">
                                        <span class="badge badge-warning mr10 fs11" style="background-color: lightslategray">${emp.goodsType}</span>
                                    </c:if>
                                    <c:if test="${emp.goodsType=='玩具'}">
                                        <span class="badge badge-warning mr10 fs11" style="background-color: lightcoral">${emp.goodsType}</span>
                                    </c:if>
                                </td>
                                <td>${emp.goodsPrice}</td>
                                <td>${emp.user.userName}</td>
                                <td><b>${emp.user.phone}</b></td>
                                <td>
                                    <a href="/goods/to_update_goods?goodsId=${emp.goodsId}">编辑</a>
                                    <a href="/goods/remove_goods?goodsId=${emp.goodsId}" onclick="var b=confirm('你确定要删除该商品吗');alert(b);">删除</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</section>


