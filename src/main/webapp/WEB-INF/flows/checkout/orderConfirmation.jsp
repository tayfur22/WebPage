<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Order Confirmation</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Order</h1>
            <p>Order Confirmation</p>
        </div>
    </div>
</section>
<div class="container">
    <div class="row">
        <form:form modelAttribute="order" class="form-horizontal">
            <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}" />
            <div class="well col-xs-10 col-sm-10 col-md-6 col-xs-offset-1 col-sm-offset-1 col-md-offset-3">
                <div class="text-center">
                    <h1>Receipt</h1>
                </div>
                <div class="row">
                    <div class="col-xs-6 col-sm-6 col-md-6">
                        <address>
                            <strong>Shipping Address</strong> <br>
                                ${order.shippingDetail.name}<br>
                                ${order.shippingDetail.shippingDate}<br>
                                ${order.shippingDetail.shippingAddress.doorNo}<br>
                                ${order.shippingDetail.shippingAddress.street}<br>
                                ${order.shippingDetail.shippingAddress.city}<br>
                                ${order.shippingDetail.shippingAddress.state}<br>
                                ${order.shippingDetail.shippingAddress.zipcode}
                        </address>
                    </div>

                    <!-- Order ID -->
                    <div class="form-group">
                        <label class="control-label col-lg-2" for="orderId">Order ID</label>
                        <div class="col-lg-10">
                            <form:input id="orderId" path="orderId" type="text" class="form-control" readonly="true"/>
                        </div>
                    </div>

                    <!-- Cart details -->
                    <div class="form-group">
                        <label class="control-label col-lg-2" for="cart">Cart</label>
                        <div class="col-lg-10">
                            <form:input id="cart" path="cart" type="text" class="form-control" readonly="true"/>
                        </div>
                    </div>

                    <!-- Customer details -->
                    <div class="form-group">
                        <label class="control-label col-lg-2" for="customer.customerId">Customer ID</label>
                        <div class="col-lg-10">
                            <form:input id="customerId" path="customer.customerId" type="text" class="form-control" readonly="true"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-lg-2" for="customer.name">Customer Name</label>
                        <div class="col-lg-10">
                            <form:input id="customerName" path="customer.name" type="text" class="form-control" readonly="true"/>
                        </div>
                    </div>

                    <!-- Shipping Address fields -->
                    <div class="form-group">
                        <label class="control-label col-lg-2" for="shippingDetail.shippingAddress.doorNo">Door No</label>
                        <div class="col-lg-10">
                            <form:input id="doorNo" path="shippingDetail.shippingAddress.doorNo" type="text" class="form-control" readonly="true"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-lg-2" for="shippingDetail.shippingAddress.street">Street</label>
                        <div class="col-lg-10">
                            <form:input id="street" path="shippingDetail.shippingAddress.street" type="text" class="form-control" readonly="true"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-lg-2" for="shippingDetail.shippingAddress.city">City</label>
                        <div class="col-lg-10">
                            <form:input id="city" path="shippingDetail.shippingAddress.city" type="text" class="form-control" readonly="true"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-lg-2" for="shippingDetail.shippingAddress.state">State</label>
                        <div class="col-lg-10">
                            <form:input id="state" path="shippingDetail.shippingAddress.state" type="text" class="form-control" readonly="true"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-lg-2" for="shippingDetail.shippingAddress.zipcode">Zipcode</label>
                        <div class="col-lg-10">
                            <form:input id="zipcode" path="shippingDetail.shippingAddress.zipcode" type="text" class="form-control" readonly="true"/>
                        </div>
                    </div>

                    <!-- Action Buttons -->
                    <button id="back" class="btn btn-default" name="_eventId_backToCollectShippingDetail">Back</button>
                    <button type="submit" class="btn btn-success" name="_eventId_orderConfirmed">
                        Confirm <span class="glyphicon glyphicon-chevron-right"></span>
                    </button>
                    <button id="btnCancel" class="btn btn-default" name="_eventId_cancel">Cancel</button>
                </div>
            </div>
        </form:form>
    </div>
</div>
</body>
</html>
