<%-- 
    Document   : product
    Created on : May 25, 2024, 10:25:06 AM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Car" %>
<%@page import="java.util.*"%>
<%@page import="model.Customer" %>
<%@page import="model.Contract" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Page</title>
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


            .break-hr{

                margin-left: 24px;
            }

            .review{
                margin-bottom: 15px;

            }

            .review-score{
                background-color: #1879ca;
                color: white;
                width: 52px;
                display: flex;
                align-items: center;
                justify-content: center;
                border-radius: 13px;
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
                                <li><a class="dropdown-item" href="#">New project...</a></li>
                                <li><a class="dropdown-item" href="#">Settings</a></li>
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





        <main class="px-3 container">


            <!-- END Search Bar -->    

            <!-- START Body -->
            <%
                int totalContract = Integer.parseInt(session.getAttribute("totalContract")+"");
            %>
            <div class="row">
                <div style="margin: 21px;">
                    <h4><%=totalContract%> cars in your deal </h4>
                    <hr class="break-line">
                </div>

                <%
                
                List<Contract> dealList = (List<Contract>)session.getAttribute("dealList");
                for (Contract contract : dealList) {
                                
                %>
                <!-- START Products Display-->
                <div class="col-lg-12">
                    <!-- START product item -->


                    <div class="row mb-2">
                        <div class="col-md-12">
                            <div class="item row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">

                                <div class="col-md-4">
                                    <img style="width: 100%;" src="<%=contract.getCarImg()%>" >
                                </div>

                                <div class="col-md-8 p-4 d-flex flex-column position-static">
                                    <h3 class="mb-0"><%=contract.getCarName()%></h3>
                                    <div class="row">
                                        <div class="col-lg-6">
                                            <div class="description"> <h6>Pick-up:</h6> </div>
                                            <div class="description"><%=contract.getPickUpDateTime()%></div>
                                            <a href="#" class="icon-link gap-1 icon-link-hover">
                                                <%=contract.getSpecificLocation()%>
                                            </a>
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="description"> <h6>Drop-off:</h6> </div>
                                            <div class="description"><%=contract.getReturnDateTime()%></div>
                                            <a href="#" class="icon-link gap-1 icon-link-hover">
                                                <%=contract.getSpecificLocation()%>
                                            </a>
                                        </div>

                                    </div>

                                    <div class="row" style="margin-top: 20px">
                                        <div class="col-md-6">

                                        </div>
                                        <div class="col-md-6">
                                            <p class="item-title">Total price:</p>
                                            <h5><%=contract.getTotalRentPrice()%> </h5>
                                        </div>
                                    </div>
                                    <div class="row" >
                                        <div class="col-md-6">
                                        </div>
                                        <div class="col-md-6">
                                            <a href="canceldeal?contractId=<%=contract.getContractID()%>&carid=<%=contract.getCarId()%>" onclick="return confirm('Do you want to cancel this deal?')" class="btn btn-danger">Cancel</a>
                                        </div>
                                    </div>

                                </div>
                                <hr class="break-hr" style="width: 90%;">
                            </div>
                        </div>
                    </div>
                    <!-- End product item -->



                </div>
                <!-- END Products Display-->
                <%
                    }
                %>
            </div>

            <!-- END Body -->
        </main>





        <script>

            function showSearch() {
                document.querySelector(".search-result").style.display = "none";
                document.querySelector(".search-bar").style.display = "block";
            }

        </script>
    </body>
</html>
