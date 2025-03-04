<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Add Product</title>
</head>
<body>
<section>
    <div class="jumbotron" style="padding: 20px 0;">
        <div class="container">
            <h1>Products</h1>
            <p>Add a new product</p>
            <a href="<c:url value="/j_spring_security_logout" />" class="btn btn-danger btn-mini pull-right">Logout</a>

            <div class="pull-right" style="padding-right:50px">
                <a href="?language=en" >English</a>|<a href="?language=nl" >Dutch</a>
            </div>
        </div>
    </div>
</section>
<section class="container" style="max-width: 600px; margin-top: 10px;">
<%--    <form:form modelAttribute="newProduct" class="form-horizontal">--%>
    <form:form modelAttribute="newProduct" class="form-horizontal" enctype="multipart/form-data">
        <form:errors path="*" cssClass="alert alert-danger" element="div"/>

        <fieldset>
            <legend>Add new product</legend>

            <!-- Product ID -->
            <div class="form-group">
                <label class="control-label col-lg-2" for="productId">
                    <spring:message code="addProduct.form.productId.label"/>
                </label>
                <div class="col-lg-10">
                    <form:input id="productId" path="productId" type="text" class="form-control"/>
                    <form:errors path="productId" cssClass="text-danger"/>
                </div>
            </div>

            <!-- Name -->
            <div class="form-group">
                <label class="control-label col-lg-2" for="name">Name</label>
                <div class="col-lg-10">
                    <form:input id="name" path="name" type="text" class="form-control"/>
                    <form:errors path="name" cssClass="text-danger"/>
                </div>
            </div>

            <!-- Unit Price -->
            <div class="form-group">
                <label class="control-label col-lg-2" for="unitPrice">Unit Price</label>
                <div class="col-lg-10">
                    <form:input id="unitPrice" path="unitPrice" type="text" class="form-control"/>
                    <form:errors path="unitPrice" cssClass="text-danger"/>
                </div>
            </div>

            <!-- Description -->
            <div class="form-group">
                <label class="control-label col-lg-2" for="description">Description</label>
                <div class="col-lg-10">
                    <form:textarea id="description" path="description" rows="2" class="form-control"/>
                </div>
            </div>

            <!-- Manufacturer -->
            <div class="form-group">
                <label class="control-label col-lg-2" for="manufacturer">Manufacturer</label>
                <div class="col-lg-10">
                    <form:input id="manufacturer" path="manufacturer" type="text" class="form-control"/>
                </div>
            </div>

            <!-- Category -->
            <div class="form-group">
                <label class="control-label col-lg-2" for="category">Category</label>
                <div class="col-lg-10">
                    <form:input id="category" path="category" type="text" class="form-control"/>
                </div>
            </div>

            <!-- Units in Stock -->
            <div class="form-group">
                <label class="control-label col-lg-2" for="unitsInStock">Units in Stock</label>
                <div class="col-lg-10">
                    <form:input id="unitsInStock" path="unitsInStock" type="number" class="form-control"/>
                </div>
            </div>

        <!-- Condition -->
            <div class="form-group">
                <label class="control-label col-lg-2" for="condition">Condition</label>
                <div class="col-lg-10">
                    <form:radiobutton path="condition" value="New"/> New
                    <form:radiobutton path="condition" value="Old"/> Old
                    <form:radiobutton path="condition" value="Refurbished"/> Refurbished
                </div>
            </div>

<%--            image--%>
            <div class="form-group">
                <label class="control-label col-lg-2" for="productImage">
                    <spring:message code="addProduct.form.productImage.label"/></label>
                <div class="col-lg-10">
<%--                    <form:input id="productImage" path="productImage" type="file"--%>
<%--                                class="form:input-large" />--%>
    <form:input id="productImage" path="productImage" type="file" class="form-control" />
    <form:errors path="productImage" cssClass="text-danger"/>


                </div>
            </div>

<%--            pdf--%>
            <div class="form-group">
                <label class="control-label col-lg-2" for="userManual">Product Manual (PDF)</label>
                <div class="col-lg-10">
                    <form:input id="userManual" path="userManual" type="file" class="form-control"/>
                </div>
            </div>


            <!-- Submit Button -->
            <div class="form-group">
                <div class="col-lg-offset-2 col-lg-10">
                    <input type="submit" id="btnAdd" class="btn btn-primary btn-sm" value="Add"/>
                </div>
            </div>
        </fieldset>
    </form:form>
</section>
</body>
</html>



