<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page isELIgnored="false" %>

<jsp:include page="top.jsp"/>
<section id="content" class="table-layout animated fadeIn"
         style="width: 1200px;border-color: snow;margin-left: 100px">



    <div class="row" style="...">
        <c:forEach items="${blist}" var="goods">
            <div class="col-sm-6 col-md-3">
                <div class="thumbnail">

                    <img src="<c:url value="/assets/img/goods/${goods.goodsPhoto}"/>" alt="...">
                    <div class="caption">
                        <div>${goods.goodsId}</div>
                        <div>${goods.goodsName}</div>
                        <div>${goods.goodsPrice}</div>
                        <p><a href="/goods/goods_detail?goodsId=${goods.goodsId}" class="btn btn-primary" role="button">商品详情</a>
                            <a href="/bill/to_add?goodsId=${goods.goodsId}" class="btn btn-default" role="button">加购物车</a></p>
                    </div>

                </div>
            </div>
        </c:forEach>

    </div>

    <%--=====================================================================================--%>
</section>
<div class="panel-footer text-right">
    <button type="button" class="button"><a href="/to_start">返回</a></button>
</div>
