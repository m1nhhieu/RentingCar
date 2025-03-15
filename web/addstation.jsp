<%-- 
    Document   : profile
    Created on : May 24, 2024, 1:21:04 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Customer" %>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Station Page</title>
        <link rel="icon" href="img/webLogo.jpg" type="image/x-icon" />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
        <!-- CSS Bootstrap -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" 
              integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" 
              crossorigin="anonymous">
        <!-- Script Link Bootstrap -->
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>


    </head>
    <body class="bg-body-tertiary">

        <div class="container">
            <header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
                <a href="admin.jsp" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
                    <i style="margin-right: 10px;
                       font-size: 24px;" class="bi bi-arrow-90deg-left"></i>
                    <span class="fs-4">Back to home</span>
                </a>                
            </header>
        </div>

        
        <%
        
        
        String address = request.getAttribute("address")+"";
        if(address.equals("null")) address="";
        String carAvailable = request.getAttribute("carAvailable")+"";
        if(carAvailable.equals("null")) carAvailable="";
        String pickupLocation = request.getAttribute("pickupLocation")+"";
        if(pickupLocation.equals("null")) pickupLocation="";
        String country = request.getAttribute("country")+"";
        if(country.equals("null")) country="";
        String city = request.getAttribute("city")+"";
        if(city.equals("null")) city="";
        %>
        <div class="container">
            <main>
                <div class="py-5 text-center" >
                    <img class="d-block mx-auto mb-4" src="img/user.png" alt="" width="72">
                    <h2>Add new station</h2>
                </div>

                <div class="row g-5" style="justify-content: center;">

                    
                    <div class="col-md-8">
                        <form class="needs-validation" action="addstation" method="post">
                            <div class="row g-3">
                                <div class="col-sm-6">
                                    <label for="address" class="form-label">Address</label>
                                    <input value="<%=address%>" name="address" type="text" class="form-control" id="address" required>

                                </div>

                                <div class="col-sm-6">
                                    <label for="carAvailable" class="form-label">Car Available</label>
                                    <input value="<%=carAvailable%>" name="carAvailable" type="number" class="form-control" id="carAvailable" placeholder="" required>

                                </div>


                                <div class="col-12">
                                    <label for="pickupLocation" class="form-label">Pick-up Location</label>
                                    <input value="<%=pickupLocation%>" type="text" name="pickupLocation" class="form-control" id="pickupLocation">
                                </div>
                                <div class="col-12">
                                    <label for="country" class="form-label">Country</label>
                                    <input type="text" name="country" class="form-control" id="country">
                                </div>
                                <div class="col-12">
                                    <label for="city" class="form-label">City</label>
                                    <input type="text" name="city" class="form-control" id="city">
                                </div>
                               


                            </div>

                            <hr class="my-4">
                             <!-- Error check Username and Password -->
                             <%
                                 String e = request.getAttribute("loi")+"";
                                 if(e.equals("null")) e = "";                   
                             %>
                             <div style="text-align: left;
                                        color: red;
                                        margin-left: 5px;">
                                 <%=e%>
                             </div>

                            <button class="w-100 btn btn-primary btn-lg" type="submit">Add</button>
                        </form>
                    </div>
                </div>
            </main>

            <footer class="my-5 pt-5 text-body-secondary text-center text-small">

            </footer>
        </div>

    </body>
</html>
