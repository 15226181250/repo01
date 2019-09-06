<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="top03.jsp"/>

<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> 商品详细信息 </h2>
            <p class="lead"></p>
        </div>
        <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
            <div class="panel heading-border">
                <div class="panel-body bg-light">
                    <div class="section-divider mt20 mb40">
                        <span> 商品详细信息 </span>
                    </div>
                    <div class="section row">
                        <div class="col-md-2">订单编号</div>
                        <div class="col-md-4">${sessionScope.billd.bid}</div>
                        <div class="col-md-2">商品类型</div>
                        <div class="col-md-4">${sessionScope.billd.goods.goodsType}</div>
                    </div>
                    <div class="section row">
                        <div class="col-md-2">商品名称</div>
                        <div class="col-md-4">${sessionScope.billd.goods.goodsName}</div>
                        <div class="col-md-2">应付金额</div>
                        <div class="col-md-4">${sessionScope.billd.goods.goodsPrice}</div>
                    </div>
                    <div class="section row">
                        <div class="col-md-2">商家</div>
                        <div class="col-md-4">${sessionScope.billd.business.userName}</div>
                        <div class="col-md-2">商家电话</div>
                        <div class="col-md-4">${sessionScope.billd.business.phone}</div>
                    </div>
                    <div class="section row">
                        <div class="col-md-2">用户</div>
                        <div class="col-md-4">${sessionScope.billd.custom.userName}</div>
                        <div class="col-md-2">用户电话</div>
                        <div class="col-md-4">${sessionScope.billd.custom.phone}</div>
                    </div>
                    <div class="section row">
                        <div class="col-md-2">创建时间</div>
                        <div class="col-md-4">${sessionScope.billd.createTime}</div>
                        <div class="col-md-2">订单状态</div>
                        <div class="col-md-4">${sessionScope.billd.status}</div>
                    </div>
                    <div class="section row">
                        <div class="col-md-2"><a href="/bill/bill_sent_goods?bibi=${sessionScope.billd.bid}" class="btn btn-default" role="button">发货</a> </div>

                    </div>
                    <div class="panel-footer text-right">
                        <button type="button" class="button"><a href="/bill/to_bill_list02">返回</a></button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
