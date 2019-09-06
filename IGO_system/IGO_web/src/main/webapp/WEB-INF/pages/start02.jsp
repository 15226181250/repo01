<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page isELIgnored="false" %>

<jsp:include page="top03.jsp"/>
<section id="content" class="table-layout animated fadeIn"
         style="width: 1200px;border-color: snow;margin-left: 100px">



    <div class="row" style="...">
        <c:forEach items="${goodslist}" var="goods">
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
        <nav aria-label="Page navigation" style="margin-left: 420px">
            <ul class="pagination">
<%--===========<li>当前第:${pageInfo.pageNum}页,共:${pageInfo.pages}页,共:${pageInfo.total}条记录</li>===============--%>
                <li><a href="${pageContext.request.contextPath}/toIndex02?&num=1">首页</a></li>
                <c:if test="${pageInfo.hasPreviousPage}">
                    <li>
                        <a href="${pageContext.request.contextPath}/toIndex02?&num=${pageInfo.pageNum-1}" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                </c:if>

                <c:forEach   items="${pageInfo.navigatepageNums}" var="page_num">
                    <c:if test="${page_num==pageInfo.pageNum}">
                        <li><a href="#">${page_num}</a></li>
                    </c:if>
                    <c:if test="${page_num!=pageInfo.pageNum}">
                        <li><a href="${pageContext.request.contextPath}/toIndex02?&num=${page_num}">${page_num}</a></li>
                    </c:if>
                </c:forEach>
                <c:if test="${pageInfo.hasNextPage}">
                    <li>
                        <a href="${pageContext.request.contextPath}/toIndex02?&num=${pageInfo.pageNum+1}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </c:if>
                <li><a href="${pageContext.request.contextPath}/toIndex02?&num=${pageInfo.pages}">末页</a></li>
            </ul>
        </nav>
    </div>

    <%--=====================================================================================--%>


</section>

