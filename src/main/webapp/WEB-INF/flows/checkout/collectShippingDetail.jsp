<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Shipping</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Shipping</h1>
            <p>Shipping details</p>
        </div>
    </div>
</section>
<section class="container">
    <form:form modelAttribute="order.shippingDetail" class="form-horizontal">
        <fieldset>
            <legend>Shipping Details</legend>

            <!-- Shipping Name -->
            <div class="form-group">
                <label class="control-label col-lg-2" for="name">Name</label>
                <div class="col-lg-10">
                    <form:input id="name" path="name" type="text" class="form-control"/>
                </div>
            </div>

            <!-- Shipping Date -->
            <div class="form-group">
                <label class="control-label col-lg-2" for="shippingDate">Shipping Date (dd/mm/yyyy)</label>
                <div class="col-lg-10">
                    <form:input id="shippingDate" path="shippingDate" type="text" class="form-control"/>
                </div>
            </div>

            <!-- Shipping Address Fields -->
            <fieldset>
                <legend>Shipping Address</legend>

                <!-- Door Number -->
                <div class="form-group">
                    <label class="control-label col-lg-2" for="shippingAddress.doorNo">Door No</label>
                    <div class="col-lg-10">
                        <form:input id="doorNo" path="shippingAddress.doorNo" type="text" class="form-control"/>
                    </div>
                </div>

                <!-- Street -->
                <div class="form-group">
                    <label class="control-label col-lg-2" for="shippingAddress.street">Street</label>
                    <div class="col-lg-10">
                        <form:input id="street" path="shippingAddress.street" type="text" class="form-control"/>
                    </div>
                </div>

                <!-- City -->
                <div class="form-group">
                    <label class="control-label col-lg-2" for="shippingAddress.city">City</label>
                    <div class="col-lg-10">
                        <form:input id="city" path="shippingAddress.city" type="text" class="form-control"/>
                    </div>
                </div>

                <!-- State -->
                <div class="form-group">
                    <label class="control-label col-lg-2" for="shippingAddress.state">State</label>
                    <div class="col-lg-10">
                        <form:input id="state" path="shippingAddress.state" type="text" class="form-control"/>
                    </div>
                </div>

                <!-- Zipcode -->
                <div class="form-group">
                    <label class="control-label col-lg-2" for="shippingAddress.zipcode">Zipcode</label>
                    <div class="col-lg-10">
                        <form:input id="zipcode" path="shippingAddress.zipcode" type="text" class="form-control"/>
                    </div>
                </div>
            </fieldset>

            <!-- Hidden field for flow execution key -->
            <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>

            <!-- Submit and Cancel Buttons -->
            <div class="form-group">
                <div class="col-lg-offset-2 col-lg-10">
                    <button id="back" class="btn btn-default" name="_eventId_backToCollectCustomerInfo">Back</button>
                    <input type="submit" id="btnAdd" class="btn btn-primary" value="Add" name="_eventId_shippingDetailCollected"/>
                    <button id="btnCancel" class="btn btn-default" name="_eventId_cancel">Cancel</button>
                </div>
            </div>
        </fieldset>
    </form:form>
</section>
</body>
</html>
