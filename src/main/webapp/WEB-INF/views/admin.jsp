<%@include file="/WEB-INF/views/template/header.jsp"%>

<%--
  Created by IntelliJ IDEA.
  User: Manoj Baral
  Date: 12/29/2016
  Time: 6:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Administrator Page</h1>
            <p class="lead">This is the administration page</p>
        </div>

        <c:if test="${pageContext.request.userPrincipal.name !=null}">
        <h2>
            Welcome: ${pageContext.request.userPrincipal.name} | <a href="<c:url
            value="/j_spring_security_logout" />">LogOut</a>

        </h2>
        </c:if>

        <h3>
            <a href="<c:url value="/admin/productInventory" /> ">Product Inventory</a>
        </h3>
        <p>Here you can view.Check and modify the product inventory</p>

        <br><br>

        <h3>
            <a href="<c:url value="/admin/customer" /> ">Customer Management</a>
        </h3>
        <p>Here you can view Customer Information</p>

        <%@include file="/WEB-INF/views/template/footer.jsp"%>


