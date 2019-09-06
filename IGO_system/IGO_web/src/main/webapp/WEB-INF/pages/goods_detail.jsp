<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="top.jsp"/>

<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> 商品详细信息 </h2>
            <p class="lead"></p>
            <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
                <div class="panel heading-border">
                    <div class="panel-body bg-light">
                    <div class="section-divider mt20 mb40">
                        <span> 商品详细信息 </span>
                    </div>
                    <div class="section row">
                        <div class="row">
                            <div>
                                <img src="<c:url value="/assets/img/goods/${goods.goodsPhoto}"/>" alt="...">
                            </div>
                        </div>
                    </div>
                    <div class="section row">
                        <div class="col-md-2">商品编号</div>
                        <div class="col-md-4">${sessionScope.goods.goodsId}</div>
                        <div class="col-md-2">商品名称</div>
                        <div class="col-md-4">${sessionScope.goods.goodsName}</div>
                    </div>
                    <div class="section row">
                        <div class="col-md-2">商品类型</div>
                        <div class="col-md-4">${sessionScope.goods.goodsType}</div>
                        <div class="col-md-2">商品价格</div>
                        <div class="col-md-4">${sessionScope.goods.goodsPrice}</div>
                    </div>
                    <div class="section row">
                        <div class="col-md-2">商家</div>
                        <div class="col-md-4">${sessionScope.goods.user.userName}</div>
                        <div class="col-md-2">商家电话</div>
                        <div class="col-md-4">${sessionScope.goods.user.phone}</div>
                    </div>
                    <div class="section row">
                        <div class="col-md-2">商品介绍</div>
                        <div class="col-md-4">${sessionScope.goods.introduce}</div>
                        <div class="col-md-2"><a href="/bill/to_add?goodsId=${goods.goodsId}" class="btn btn-default" role="button">加购物车</a></div>
                        <div class="col-md-4"><a href="/bill/to_session?businessId=${goods.businessId}" class="btn btn-default" role="button">联系客服</a></div>
                    </div>

                    <div class="panel-footer text-right">
                        <button type="button" class="button" onclick="javascript:window.history.go(-1);"> 返回 </button>
                    </div>
                    </div>
                </div>
            </div>
        </div>
        </div>
    </div>
    </div>
</section>

