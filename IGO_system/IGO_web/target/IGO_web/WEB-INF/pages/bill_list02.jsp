<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="top03.jsp"/>

<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> 商 品 列 表 </h2>
            <p class="lead"></p>
        </div>
        <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
            <div class="panel  heading-border">
                <div class="panel-menu">
                    <div class="row">
                        <div class="hidden-xs hidden-sm col-md-3">
                            <div class="btn-group">
                                <button type="button" class="btn btn-default light">
                                    <i class="fa fa-refresh"></i>
                                </button>
                                <button type="button" class="btn btn-default light">
                                    <i class="fa fa-trash"></i>
                                </button>
                                <button type="button" class="btn btn-default light">
                                    <i class="fa fa-plus" ></i>
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
                            <th class="hidden-xs">订单编号</th>
                            <th class="hidden-xs">商品名称</th>
                            <th class="hidden-xs">商品类型</th>
                            <th class="hidden-xs">商品价格</th>
                            <th class="hidden-xs">创建日期</th>
                            <th class="hidden-xs">订单状态</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${blist}" var="emp">
                            <tr class="message-unread">
                                <td class="hidden-xs">
                                    <label class="option block mn">
                                        <input type="checkbox" name="mobileos" value="FR">
                                        <span class="checkbox mn"></span>
                                    </label>
                                </td>
                                <td>${emp.bid}</td>
                                <td>${emp.goods.goodsName}</td>
                                <td>${emp.goods.goodsType}</td>
                                <td>${emp.totalPrice}</td>
                                <td><b>${emp.createTime}</b></td>
                                <td class="hidden-xs">
                                    <c:if test="${emp.status=='新创建'}">
                                        <span class="badge badge-warning mr10 fa-2x" style="background-color: lightsalmon">${emp.status}</span>
                                    </c:if>
                                    <c:if test="${emp.status=='待发货'}">
                                        <span class="badge badge-warning mr10 fa-2x" style="background-color: lightseagreen">${emp.status}</span>
                                    </c:if>
                                    <c:if test="${emp.status=='已发货'}">
                                        <span class="badge badge-warning mr10 fa-2x" style="background-color: lightskyblue">${emp.status}</span>
                                    </c:if>
                                    <c:if test="${emp.status=='已收货'}">
                                        <span class="badge badge-warning mr10 fa-2x" style="background-color: lightsteelblue">${emp.status}</span>
                                    </c:if>
                                </td>
                                <td>
                                    <a href="/bill/bill_detail02?bibi=${emp.bid}">查看订单</a>
                                    <a href="/bill/bill_sent_goods?bibi=${emp.bid}">发货</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <div class="panel-footer text-right">
                        <button type="button" class="button"><a href="/to_start02">返回</a></button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

