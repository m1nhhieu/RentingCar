<%-- 
    Document   : detail
    Created on : May 28, 2024, 4:37:05 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Car" %>
<%@page import="model.Cart" %>
<%@page import="java.util.*" %>
<%@page import="model.Customer" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detail Page</title>


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

            .search-bar, .search-result{
                margin-top: 20px
            }

            .filter{
                margin-top: 0;
                border: 1px solid #ccc;
                border-radius: 10px;
                padding: 20px;
            }

            .break-line{
                width: 80px;
                margin-top: 0;
                color: black;
                opacity: 1;
                border: 1px solid;
            }

            .item{
                align-items: center;
            }

            .description{
                margin: 5px 0;
            }

            .item-title{
                margin: 0;
                font-size: 12px;
                opacity: 0.8;
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

            .check{
                margin-right: 5px;
                color: #4ebd4e;
            }
            
            .bi-cart3:hover{
                opacity: 0.9;
                cursor: pointer;
            }
        </style>

        <!-- CSS Bootstrap -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" 
              integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" 
              crossorigin="anonymous">
        <!-- Script Link Bootstrap -->
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

    </head>
    <body>
        <!-- START HEADER -->

        <header class="p-3 text-bg-dark" style="z-index: 1;
                position: relative;">
            <div class="container">
                <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
                    <a href="home.jsp" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
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

                    <%
                         String totalCart = session.getAttribute("totalCart")+"";
                        %>
                    <div class="text-end" style="display: flex;">
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

        <div class="container row" style="position: relative; margin: auto;">
            <%
            Car car = (Car)session.getAttribute("carInCartDetail");

            %>
            <!-- START Products Display-->

            <div class="col-lg-8">
                <div style="margin: 21px;">
                    <h4>Your deal  </h4>
                    <hr class="break-line">
                </div>

                <!-- START product item -->
                <div class="row mb-2">
                    <div class="col-md-12">
                        <div class="item row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">

                            <div class="col-md-4">
                                <img style="width: 100%;" src="<%=car.getImgage()%>" >
                            </div>

                            <div class="col-md-8 p-4 d-flex flex-column position-static">
                                <h3 class="mb-0"><%=car.getName()%></h3>
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="description"><i class="bi bi-person"></i> <%=car.getNumberOfSeats()%> seats</div>
                                        <div class="description"><i class="bi bi-suitcase-lg"></i> <%=car.getLargeBags()%> large bag</div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="description"><i class="bi bi-suitcase"></i> <%=car.getSmallBags()%> small bag</div>
                                    </div>
                                </div>
                                <a href="#" class="icon-link gap-1 icon-link-hover stretched-link">
                                    <%=car.getPickuplocation()%>
                                </a>

                                <hr class="my-4">
                                <div class="row" >
                                    <div class="col-md-5">
                                        <strong>
                                            <i class=" check bi bi-info-circle-fill"></i>Important Info:
                                        </strong>
                                    </div>
                                    <div class="col-md-7">
                                        <div>
                                            When you pick the car up, you'll need:
                                        </div>
                                        <div>
                                            <i class="bi bi-check-circle-fill check"></i>Passport or national ID card
                                        </div>
                                        <div>
                                            <i class="bi bi-check-circle-fill check"></i>Driving licence
                                        </div>
                                        <div>
                                            <i class="bi bi-check-circle-fill check"></i>Credit card
                                        </div>


                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
                <!-- End product item -->
                <hr class="my-4">
                <div class="row">
                    <h4>Include in the price:</h4>
                    <table>
                        <tr>
                            <td><i class="check bi bi-check-lg"></i>Free cancellation up to 48 hours before pick-up</td>
                            <td><i class="check bi bi-check-lg"></i>Theft Protection with ₫8,113,076 excess</td>
                        </tr>
                       
                        <tr>
                            <td><i class="check bi bi-check-lg"></i>Collision Damage Waiver with ₫16,226,151 deductible</td>
                            <td><i class="check bi bi-check-lg"></i>Driverless</td>
                        </tr>
                    </table>
                    
                    

                </div>
            </div>
            <!-- END Products Display-->

            <!-- START Booking detail-->
            <%
            Cart cart = (Cart)session.getAttribute("cartDetail");
            %>
            <div class="col-lg-4">
                <div class="container">
                    <main>
                        <div class="row g-5" style="justify-content: center;">
                            <div class="col-md-8" style="margin-top: 80px;">

                            </div>
                            <div class="col-md-8 filter">
                                <form class="needs-validation" novalidate action="cartbooking" method="post">

                                    <div>
                                        <h4>Booking detail </h4>
                                        <hr class="break-line">
                                    </div>
                                    <div>
                                        <h6>Pick-up </h6>
                                        <div><%=car.getPickuplocation()%></div>
                                        <div><%= cart.getPickUpDateTime()%></div>
                                    </div>

                                    <hr class="my-4">

                                    <div>
                                        <h6>Drop-off </h6>
                                        <div><%=car.getPickuplocation()%></div>
                                        <div><%=cart.getReturnDateTime()%></div>
                                    </div>

                                    <hr class="my-4">

                                    <div>
                                        <h6>Price detail: </h6>
                                        <div class="row" style="margin-top: 20px">
                                            <div class="">
                                                <p class="item-title">Deposit required at pick-up:</p>
                                                <h5>$<%=car.getDeposit()%></h5>
                                            </div>
                                        </div>

                                        <div class="row" style="margin-top: 20px">
                                            <div class="">
                                                <p class="item-title">Price for <%=car.getTotalDayRent()%> days:</p>
                                                <h5>$<%=car.getDailyprice()*car.getTotalDayRent()%></h5>
                                            </div>
                                        </div>
                                    </div>

                                    <hr class="my-4">

                                    <button class="w-100 btn btn-primary btn-lg" type="submit">Booking</button>
                                </form>
                            </div>
                        </div>
                    </main>


                </div>
            </div>
            <!-- END Filter-->

        </div>

        <!-- END Body -->
    </body>
</html>
