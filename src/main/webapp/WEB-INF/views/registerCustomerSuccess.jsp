<%--
  Created by IntelliJ IDEA.
  User: Manoj Baral
  Date: 4/12/2017
  Time: 10:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Customer Register Successfully</h1>

                </div>
            </div>
        </section>

        <section class="container">
            <p>
            <a href="<spring:url value="/product/productList" />" class="btn btn-default">Products</a>
            </p>
        </section>

    </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
<script src="<c:url value="/resources/js/controller.js" /> "></script>
<%@include file="/WEB-INF/views/template/footer.jsp" %>
