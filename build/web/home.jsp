<%-- 
    Document   : home
    Created on : May 23, 2024, 11:02:07 AM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Customer" %>
<%@page import="java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <link rel="icon" href="img/webLogo.jpg" type="image/x-icon" />
        <style>
            .dropdown-toggle::after{
                color: white;
            }

            label{
                color: #8e7c7c;
            }

            select{
                padding: 16px;

            }

            .input{
                margin: 10px 0;
            }

            .search{
                width: 100%;
                margin-top: 10px;
                padding: 16px 0;
            }
            
             .cart-icon{
                font-size: 22px;
                margin-right: 10px;
            }
            .cart-number{
                display: inline-block;
                position: relative;
                left: -22px;
                top: -5px;
                background-color: orange;
                width: 18px;
                height: 18px;
                text-align: center;
                border-radius: 50%;
            }

            .cart-number span{
                position: relative;
                top: -3px;
            }
            
            .bi-cart3:hover{
                opacity: 0.9;
                cursor: pointer;
            }
        </style>

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>
    <body>

        <!-- START HEADER -->

        <header class="p-3 text-bg-dark" style="z-index: 1;
                position: relative;">
            <div class="container">
                <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
                    <a href="intro.jsp" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
                        <i style="font-size: 32px" class="bi bi-house-door-fill"></i>
                    </a>

                    <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                        <!--<li><a href="#" class="nav-link px-2 text-secondary">Home</a></li>-->
                        <li><a href="#" class="nav-link px-2 text-white">Features</a></li>
                        <li><a href="#" class="nav-link px-2 text-white">Pricing</a></li>
                        <li><a href="#" class="nav-link px-2 text-white">FAQs</a></li>
                        <li><a href="#" class="nav-link px-2 text-white">About</a></li>
                    </ul>

                    <!-- User check exist -->
                    <%

                        Customer customer = (Customer)session.getAttribute("customer");
                        if(customer==null){
                    %>
                    <div class="text-end">
                        <a href="login.jsp" class="btn btn-outline-light me-2" previewlistener="true">Login</a>
                        <a href="register.jsp" class="btn btn-warning" previewlistener="true">Sign-up</a>
                    </div>

                    <% }else{ %>

                    <div class="text-end" style="display: flex;">
                        <%
                         String totalCart = session.getAttribute("totalCart")+"";
                        %>
                        <a href="cart"><i style="color: white;" class="bi bi-cart3 cart-icon"></i></a>
                        <div class="cart-number"> <span><%=totalCart%></span> </div>
                        
                        <div class="dropdown text-end">
                            <a href="#" class="d-block link-body-emphasis text-decoration-none dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
                                <img src="img/user.png" alt="mdo" width="32" height="32" class="rounded-circle">
                            </a>
                            <ul class="dropdown-menu text-small">

                                <li>
                                    <a class="dropdown-item" href="#" class="d-block link-body-emphasis text-decoration-none dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
                                        <img src="img/user.png" alt="mdo" width="32" height="32" class="rounded-circle"> <%=customer.getUsername()%> 
                                    </a>

                                </li>
                                <li><a class="dropdown-item" href="deal">Your deal</a></li>
                                <li><a class="dropdown-item" href="changepass.jsp">Change password</a></li>
                                <li><a class="dropdown-item" href="profile.jsp">Profile</a></li>
                                <li><hr class="dropdown-divider"></li>
                                <li><a class="dropdown-item" href="logout">Sign out</a></li>
                            </ul>
                        </div>
                    </div>

                    <% } %>


                </div>
            </div>
        </header>

        <!-- END HEADER -->

        <!-- START Body -->

        <%
        String pickuplocation = session.getAttribute("pickuplocation")+"";
        String pickupdate = session.getAttribute("pickupdate")+"";
        String pickuptime = session.getAttribute("pickuptime")+"";
        String dropoffdate = session.getAttribute("dropoffdate")+"";
        String dropofftime = session.getAttribute("dropofftime")+"";
        if(pickuplocation.equals("null")) pickuplocation = "";
        if(pickupdate.equals("null")) pickupdate = "";
        if(pickuptime.equals("null")) pickuptime = "";
        if(dropoffdate.equals("null")) dropoffdate = "";
        if(dropofftime.equals("null")) dropofftime = "";
        String npud = "";
        if(pickupdate.length()>0){
        String[] s = pickupdate.split("-");
                    String year = s[0];
                    String month = s[1];
                    String day = s[2];
                    npud = day+"/"+month+"/"+year;
        }
        
        %>
        <div class="d-flex h-100 text-center text-bg-dark" style="margin-top: -78px;
             
             ">

            <div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
                <header class="mb-auto" style="height: 250px;">

                </header>

                <main class="px-3 container">

                    <h1>Car Rental - Search</h1>
                    <main class="form-signin w-100 m-auto">
                        <form class="row" action="search_home" method="post">
                            
                            <!-- Load pickupLocation -->
                            <%
                            List<String> stationList = (List<String>)session.getAttribute("stationList");
                            %>
                            <div class="col-lg-3">
                                <div class="form-floating input">
                                    <select required="" name="pickuplocation" class="form-select form-control style-input" id="pickuplocation" aria-label="Default select example">
                                        <option selected>Choose...</option>
                                        <%
                                            for (String string: stationList) {
                                        %>
                                        <option <%=string.equals(pickuplocation)?"selected":"" %> value="<%=string%>"><%=string%></option>
                                        <%
                                        }                                         
                                        %>
                                    </select>
                                    <label for="pickuplocation">Pick-up location</label>
                                </div>
                            </div>

                            
                            <div class="col-lg-2">
                                <div class="form-floating input">
                                    <input required="" name="pickupdate" type="date" class="form-control style-input" id="pickupdate"  value=<%=pickupdate%>>
                                    <label for="pickupdate">Pick-up date</label>
                                </div>
                            </div>
                            <div class="col-lg-2">
                                <div class="form-floating input">
                                    <select required="" name="pickuptime" class="form-select form-control style-input" id="pickuptime" aria-label="Default select example">
                                        <option selected>Choose...</option>
                                        <%
                                            for (int i = 0; i <= 23; i++) {
                                            String minute = ":00";
                                            for (int j = 0; j <= 1; j++) {
                                                String time ="";
                                                if(j==0){
                                                    time = i+""+minute;
                                                } else {
                                                    minute=":30";
                                                    time = i+""+minute;
                                                }
                                            
                                           
                                        %>
                                        <option <%= time.equals(pickuptime)?"selected":"" %> value=<%=time%>><%=time%></option>
                                        <%
                                        }
                                         }                                           
                                        %>

                                    </select>
                                    <label for="pickuptime">Time</label>
                                </div>
                            </div>

                            <div class="col-lg-2">
                                <div class="form-floating input">
                                    <input required="" name="dropoffdate" type="date" class="form-control style-input" id="dropoffdate"  value=<%=dropoffdate%>>
                                    <label for="dropoffdate">Drop-off date</label>
                                </div>
                            </div>

                            <div class="col-lg-2">
                                <div class="form-floating input">
                                    <select required="" name="dropofftime" class="form-select form-control style-input" id="dropofftime" aria-label="Default select example">
                                        <option selected>Choose...</option>
                                        <%
                                            for (int i = 0; i <= 23; i++) {
                                            String minute = ":00";
                                            for (int j = 0; j <= 1; j++) {
                                                String time ="";
                                                if(j==0){
                                                    time = i+""+minute;
                                                } else {
                                                    minute=":30";
                                                    time = i+""+minute;
                                                }
                                            
                                           
                                        %>
                                        <option <%= time.equals(dropofftime)?"selected":"" %> value=<%=time%>><%=time%></option>
                                        <%
                                        }
                                         }                                           
                                        %>

                                    </select>
                                    <label for="dropofftime">Time</label>
                                </div>
                            </div>
                            <div class="container col-lg-1" >
                                <button type="submit" class="btn btn-primary search" style="padding: 16px 0;">Search</button>
                            </div>

                        </form>
                    </main>
                    <% 
                     String loi = session.getAttribute("loi")+"";
                    if(loi.equals("null")) loi = "";
                    %>
                    <div style="color: red; text-align: left;">
                        <%=loi%> <br>
                    </div>
                </main>

                <footer class="mt-auto text-white-50" style="height: 250px;">
                </footer>
            </div>


        </div>

        <!-- END Body -->

        <!-- Script Link Bootstrap -->
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
    </body>
</html>
