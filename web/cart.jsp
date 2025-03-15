<%-- 
    Document   : cart
    Created on : May 28, 2024, 5:52:34 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Car" %>
<%@page import="java.util.*"%>
<%@page import="model.Customer"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart Page</title>

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
    <body class="bg-body-tertiary">
        
        
        <div class="container">
            <header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
                <a href="home.jsp" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
                    <i style="margin-right: 10px;
                       font-size: 24px;" class="bi bi-arrow-90deg-left"></i>
                    <span class="fs-4">Back to home</span>
                </a>                
            </header>
        </div>
        
        
        <div class="dropdown position-fixed bottom-0 end-0 mb-3 me-3 bd-mode-toggle">
            <button class="btn btn-bd-primary py-2 dropdown-toggle d-flex align-items-center"
                    id="bd-theme"
                    type="button"
                    aria-expanded="false"
                    data-bs-toggle="dropdown"
                    aria-label="Toggle theme (auto)">
                <svg class="bi my-1 theme-icon-active" width="1em" height="1em"><use href="#circle-half"></use></svg>
                <span class="visually-hidden" id="bd-theme-text">Toggle theme</span>
            </button>
            <ul class="dropdown-menu dropdown-menu-end shadow" aria-labelledby="bd-theme-text">
                <li>
                    <button type="button" class="dropdown-item d-flex align-items-center" data-bs-theme-value="light" aria-pressed="false">
                        <svg class="bi me-2 opacity-50" width="1em" height="1em"><use href="#sun-fill"></use></svg>
                        Light
                        <svg class="bi ms-auto d-none" width="1em" height="1em"><use href="#check2"></use></svg>
                    </button>
                </li>
                <li>
                    <button type="button" class="dropdown-item d-flex align-items-center" data-bs-theme-value="dark" aria-pressed="false">
                        <svg class="bi me-2 opacity-50" width="1em" height="1em"><use href="#moon-stars-fill"></use></svg>
                        Dark
                        <svg class="bi ms-auto d-none" width="1em" height="1em"><use href="#check2"></use></svg>
                    </button>
                </li>
                <li>
                    <button type="button" class="dropdown-item d-flex align-items-center active" data-bs-theme-value="auto" aria-pressed="true">
                        <svg class="bi me-2 opacity-50" width="1em" height="1em"><use href="#circle-half"></use></svg>
                        Auto
                        <svg class="bi ms-auto d-none" width="1em" height="1em"><use href="#check2"></use></svg>
                    </button>
                </li>
            </ul>
        </div>


        <div class="container">
            <main>
                <div class="py-5 text-center">
<!--                    <div><i class="bi bi-cart3"></i></div>-->
                    <img class="d-block mx-auto mb-4" src="img/webLogo.jpg" alt="" width="72" height="57">
                    <h2>Your cart</h2>
                </div>
                <%
                List<Car> carCartList = (List<Car>)session.getAttribute("carCartList");
                %>
                <div class="row g-5">
                    <div class="col-md-5 col-lg-4 order-md-last">
                        
                        <%
                         String totalCart = session.getAttribute("totalCart")+"";
                        %>
                        
                        <h4 class="d-flex justify-content-between align-items-center mb-3">
                            <span class="text-primary">Your cart</span>
                            <span class="badge bg-primary rounded-pill"><%=totalCart%></span>
                        </h4>
                        <ul class="list-group mb-3">
                            <%
                            int total = 0;
                            for (Car car : carCartList) {
                            total+=car.getDailyprice()*car.getTotalDayRent();
                            %>
                            <li class="list-group-item d-flex justify-content-between lh-sm">
                                <div>
                                    <h6 class="my-0"><%=car.getName()%></h6>
                                    <small class="text-body-secondary">Price for <%=car.getTotalDayRent()%> days</small>
                                </div>
                                <span class="text-body-secondary">$<%=car.getDailyprice()*car.getTotalDayRent()%></span>
                            </li>
                            <%
                                }
                            %>
                            
                            <li class="list-group-item d-flex justify-content-between">
                                <span>Total (USD)</span>
                                <strong>$<%=total%></strong>
                            </li>
                        </ul>

                            <form class="card p-2" action="bookingall" method="post">
                            <div class="input-group">
                                <button class="w-100 btn btn-primary btn-lg" type="submit">Booking</button>
                            </div>
                        </form>
                    </div>
                    <div class="col-md-7 col-lg-8">
                        <h4 class="mb-3">All items</h4>
                        <hr class="break-line">
                        <%
                        
                        for (Car car : carCartList) {

                        
                        %>
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
                                        <a href="#" class="icon-link gap-1 icon-link-hover">
                                            <%=car.getPickuplocation()%>
                                        </a>
                                        <div class="row" style="margin-top: 20px">
                                            <div class="col-md-6">

                                            </div>
                                            <div class="col-md-6">
                                                <p class="item-title">Price for <%=car.getTotalDayRent()%> days:</p>
                                                <h5>$<%=car.getDailyprice()*car.getTotalDayRent()%></h5>
                                            </div>
                                        </div>
                                        <div class="row" >
                                            <div class="col-md-6">
                                                <a href="removecart?cid=<%=car.getCarID()%>" class="btn btn-danger">Remove</a>
                                            </div>
                                            <div class="col-md-6">
                                                <a href="detailcart?cid=<%=car.getCarID()%>" class="btn btn-warning">View detail</a>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>
                        <!-- End product item -->
                        
                        <%
                        }
                        %>
                        
                        
                    </div>
                </div>
            </main>

            <footer class="my-5 pt-5 text-body-secondary text-center text-small">

            </footer>
        </div>
    </body>
</html>
