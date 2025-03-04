<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Customer</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Customer</h1>
            <p>Customer details</p>
        </div>
    </div>
</section>
<section class="container">
    <form:form modelAttribute="order.customer" class="form-horizontal">
        <fieldset>
            <legend>Customer Details</legend>

            <!-- Customer ID -->
            <div class="form-group">
                <label class="control-label col-lg-2" for="customerId">Customer Id</label>
                <div class="col-lg-10">
                    <form:input id="customerId" path="customerId" type="text" class="form-control"/>
                </div>
            </div>

            <!-- Customer Name -->
            <div class="form-group">
                <label class="control-label col-lg-2" for="name">Customer Name</label>
                <div class="col-lg-10">
                    <form:input id="name" path="name" type="text" class="form-control"/>
                </div>
            </div>

            <!-- Phone Number -->
            <div class="form-group">
                <label class="control-label col-lg-2" for="phoneNumber">Phone Number</label>
                <div class="col-lg-10">
                    <form:input id="phoneNumber" path="phoneNumber" type="text" class="form-control"/>
                </div>
            </div>

            <!-- Billing Address Fields -->
            <fieldset>
                <legend>Billing Address</legend>

                <!-- Address Line 1 -->
                <div class="form-group">
                    <label class="control-label col-lg-2" for="billingAddress.street">Street</label>
                    <div class="col-lg-10">
                        <form:input id="street" path="billingAddress.street" type="text" class="form-control"/>
                    </div>
                </div>

                <!-- Address Line 2 -->
                <div class="form-group">
                    <label class="control-label col-lg-2" for="billingAddress.city">City</label>
                    <div class="col-lg-10">
                        <form:input id="city" path="billingAddress.city" type="text" class="form-control"/>
                    </div>
                </div>

                <!-- State -->
                <div class="form-group">
                    <label class="control-label col-lg-2" for="billingAddress.state">State</label>
                    <div class="col-lg-10">
                        <form:input id="state" path="billingAddress.state" type="text" class="form-control"/>
                    </div>
                </div>

                <!-- Postal Code -->
                <div class="form-group">
                    <label class="control-label col-lg-2" for="billingAddress.zipcode">Zipcode</label>
                    <div class="col-lg-10">
                        <form:input id="zipcode" path="billingAddress.zipcode" type="text" class="form-control"/>
                    </div>
                </div>
            </fieldset>

            <!-- Hidden field to handle flow execution key -->
            <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>

            <!-- Submit and Cancel Buttons -->
            <div class="form-group">
                <div class="col-lg-offset-2 col-lg-10">
                    <input type="submit" id="btnAdd" class="btn btn-primary" value="Add" name="_eventId_customerInfoCollected" />
                    <button id="btnCancel" class="btn btn-default" name="_eventId_cancel">Cancel</button>
                </div>
            </div>
        </fieldset>
    </form:form>
</section>
</body>
</html>
