<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="top02.jsp"/>

<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> 订 单 交 易 详 情</h2>
            <p class="lead"></p>
        </div>
        <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
            <div class="panel  heading-border">
                <div class="panel-menu">
                    <div class="row">
                        <div class="col-xs-12 col-md-9 text-right">
                        </div>
                    </div>
                </div>
                <div class="panel-body pn">
                        <c:forEach items="${hlist}" var="emp">
                </div>
                        <div class="panel-body bg-light">
                            <div class="section row">
                                <div class="col-md-2">订单编号</div>
                                <div class="col-md-4">${emp.billId}</div>
                                <div class="col-md-2"></div>
                                <div class="col-md-4"></div>
                            </div>
                            <div class="section row">
                                <div class="col-md-2">商品编号</div>
                                <div class="col-md-4">${emp.bill.goodsId}</div>
                                <div class="col-md-2">交易金额</div>
                                <div class="col-md-4">${emp.bill.totalPrice}</div>
                            </div>
                            <div class="section row">
                                <div class="col-md-2">商家账号</div>
                                <div class="col-md-4">${emp.businessId}</div>
                                <div class="col-md-2">用户账号</div>
                                <div class="col-md-4">${emp.customId}</div>
                            </div>
                            <div class="section row">
                                <div class="col-md-2">商家</div>
                                <div class="col-md-4">${emp.business.userName}</div>
                                <div class="col-md-2">商家电话</div>
                                <div class="col-md-4">${emp.business.phone}</div>
                            </div>
                            <div class="section row">
                                <div class="col-md-2">用户</div>
                                <div class="col-md-4">${emp.custom.userName}</div>
                                <div class="col-md-2">用户电话</div>
                                <div class="col-md-4">${emp.custom.phone}</div>
                            </div>
                            <div class="section row">
                                <div class="col-md-2">订单状态</div>
                                <div class="col-md-4">${emp.post}</div>
                                <div class="col-md-2">时间</div>
                                <div class="col-md-4">${emp.handleTime}</div>
                            </div>
                        </c:forEach>
                        </div>
                    </div>
                        <div class="panel-footer text-right">
                            <button type="button" class="button" onclick="javascript:window.history.go(-1);"> 返回 </button>
                        </div>
                </div>
            </div>
        </div>
    </div>
</section>


