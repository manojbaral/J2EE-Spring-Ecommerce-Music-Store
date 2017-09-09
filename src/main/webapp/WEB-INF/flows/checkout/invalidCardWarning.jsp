<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%--
  Created by IntelliJ IDEA.
  User: Manoj Baral
  Date: 4/17/2017
  Time: 7:15 PM
  To change this template use File | Settings | File Templates.
--%>
<body>
<div class="container-wrapper">
    <div class="container">
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1 class="alert alert-danger"> Invalid Cart</h1>
                </div>
            </div>
        </section>

        <section>
            <div class="container">
                <p>
                    <a href="<spring:url value="/product/productList" />" class="btn btn-primary">
                        <span class="glyphicon-hand-left glyphicon"></span> products
                    </a>
                </p>
            </div>

        </section>
    </div>
</div>
</body>
<%@include file="/WEB-INF/views/template/footer.jsp" %>
