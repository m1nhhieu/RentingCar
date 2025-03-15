<%-- 
    Document   : product
    Created on : May 25, 2024, 10:25:06 AM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Car" %>
<%@page import="java.util.*"%>
<%@page import="model.Customer" %>
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
        %>
        <main class="px-3 container">
            <!-- START Search Bar-->
            <nav class="navbar navbar-expand-lg bg-body-tertiary search-result">
                <div class="container-fluid row">

                    <div class="col-sm-2" >
                        <div><%= pickuplocation %></div>
                        <div><%= pickupdate %>,<%=pickuptime%></div>
                    </div>

                    <div class="col-sm-2">
                        <i class="bi bi-arrow-right"></i>
                    </div>

                    <div class="col-sm-2" >
                        <div><%= pickuplocation %></div>
                        <div><%= dropoffdate %>,<%=dropofftime%></div>
                    </div>

                    <div class="col-sm-6" style="text-align: right;">
                        <button onclick="showSearch()" type="button" class="btn btn-primary">Edit</button>
                    </div>
                </div>
            </nav>


            <main class="form-signin w-100 m-auto search-bar" style="display: none;">
                <main class="form-signin w-100 m-auto">
                    <form class="row" action="search_home" method="post">

                        <!-- Load pickupLocation -->
                        <%
                        List<String> stationList = (List<String>)session.getAttribute("stationList");
                        %>
                        <div class="col-lg-3">
                            <div class="form-floating input">
                                <select name="pickuplocation" class="form-select form-control style-input" id="pickuplocation" aria-label="Default select example">
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
                                <input name="pickupdate" type="date" class="form-control style-input" id="pickupdate"  value=<%=pickupdate%>>
                                <label for="pickupdate">Pick-up date</label>
                            </div>
                        </div>
                        <div class="col-lg-2">
                            <div class="form-floating input">
                                <select name="pickuptime" class="form-select form-control style-input" id="pickuptime" aria-label="Default select example">
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
                                <input name="dropoffdate" type="date" class="form-control style-input" id="dropoffdate"  value=<%=dropoffdate%>>
                                <label for="dropoffdate">Drop-off date</label>
                            </div>
                        </div>

                        <div class="col-lg-2">
                            <div class="form-floating input">
                                <select name="dropofftime" class="form-select form-control style-input" id="dropofftime" aria-label="Default select example">
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
            </main>
            <% 
                String loip = session.getAttribute("loip")+"";
               if(loip.equals("null")) loip = "";
            %>
            <div style="color: red; text-align: left; margin-left: 5px;">
                <%=loip%>
            </div>

            <!-- END Search Bar -->    

            <!-- START Body -->

            <div class="row">

                <!-- START Filter-->
                <div class="col-lg-6">
                    <%
                
                    String[] categoriesFilter = (String[])session.getAttribute("categoriesFilter");
                    String reviewScoreFilter = session.getAttribute("reviewScoreFilter")+"";
                    String depositFilter = session.getAttribute("depositFilter")+"";
                    String sortByPrice = session.getAttribute("sortByPrice")+"";

                    if(reviewScoreFilter==null) reviewScoreFilter="";
                    if(depositFilter==null) depositFilter="";
                    if(sortByPrice==null) sortByPrice="";
                
                    %>
                    <div class="container">
                        <main>
                            <div class="row g-5" style="justify-content: center;">
                                <div class="col-md-8" style="margin-top: 80px;">

                                </div>
                                <div class="col-md-8 filter">
                                    <form class="needs-validation" action="filter" method="post">

                                        <div>
                                            <h4>Filter </h4>
                                            <hr class="break-line">
                                        </div>

                                        <!-- START Load categories -->
                                        <%
                                        List<Integer> iList = ( List<Integer>)session.getAttribute("iList");
                                        %>
                                        <div>
                                            <h6>Categories </h6>
                                            <%
                                                for (Integer integer : iList) {
                                                int i = 0;
                                                if(categoriesFilter!=null){
                                                for (String string : categoriesFilter) {
                                                    if(string.equals(integer+"")) i++;
                                                }
                                                }
                                                if(i!=0){
                                            %>
                                            <div class="form-check">
                                                <input checked="" name="categories" class="form-check-input" type="checkbox" value="<%=integer%>" id="categories<%=integer%>">
                                                <label class="form-check-label" for="categories<%=integer%>">
                                                    <%=integer%> Seats
                                                </label>
                                            </div>

                                            <% } else {   
                                            %>
                                            <div class="form-check">
                                                <input name="categories" class="form-check-input" type="checkbox" value="<%=integer%>" id="categories<%=integer%>">
                                                <label class="form-check-label" for="categories<%=integer%>">
                                                    <%=integer%> Seats
                                                </label>
                                            </div>

                                            <%
                                            } 
                                               } 
                                            %>

                                        </div>

                                        <hr class="my-4">

                                        <div>
                                            <h6>Review Scores </h6>
                                            <div class="form-check">
                                                <input <%=reviewScoreFilter.equals("9")?"checked":""%> name="score" class="form-check-input" type="radio" value="9" id="score9">
                                                <label class="form-check-label" for="score9">
                                                    Excellent: 9+
                                                </label>
                                            </div>
                                            <div class="form-check">
                                                <input <%=reviewScoreFilter.equals("8")?"checked":""%> name="score" class="form-check-input" type="radio" value="8" id="score8">
                                                <label class="form-check-label" for="score8">
                                                    Very good: 8+
                                                </label>
                                            </div>
                                            <div class="form-check">
                                                <input <%=reviewScoreFilter.equals("7")?"checked":""%> name="score" class="form-check-input" type="radio" value="7" id="score7">
                                                <label class="form-check-label" for="score7">
                                                    Good: 7+
                                                </label>
                                            </div>
                                        </div>

                                        <hr class="my-4">

                                        <div>
                                            <h6>Deposit required at pick-up </h6>
                                            <div class="form-check">
                                                <input <%=depositFilter.equals("0-250")?"checked":""%> name="deposit" class="form-check-input" type="radio" value="0-250" id="deposit1">
                                                <label class="form-check-label" for="deposit1">
                                                    0 - $250
                                                </label>
                                            </div>
                                            <div class="form-check">
                                                <input <%=depositFilter.equals("250-500")?"checked":""%> name="deposit" class="form-check-input" type="radio" value="250-500" id="deposit2">
                                                <label class="form-check-label" for="deposit2">
                                                    $250 - $500
                                                </label>
                                            </div>
                                            <div class="form-check">
                                                <input <%=depositFilter.equals("500")?"checked":""%> name="deposit" class="form-check-input" type="radio" value="500" id="deposit3">
                                                <label class="form-check-label" for="deposit3">
                                                    $500+
                                                </label>
                                            </div>
                                        </div>

                                        <hr class="my-4">

                                        <div>
                                            <h6>Sort by price </h6>
                                            <div class="form-check">
                                                <input <%=sortByPrice.equals("low")?"checked":""%> name="sort" class="form-check-input" type="radio" value="low" id="sort1">
                                                <label class="form-check-label" for="sort1">
                                                    Low to High 
                                                </label>
                                            </div>
                                            <div class="form-check">
                                                <input <%=sortByPrice.equals("high")?"checked":""%> name="sort" class="form-check-input" type="radio" value="high" id="sort2">
                                                <label class="form-check-label" for="sort2">
                                                    High to Low
                                                </label>
                                            </div>
                                        </div>

                                        <hr class="my-4">
                                        <%
                                        String sql = session.getAttribute("sql")+"";
                                        %>

                                        <button class="w-100 btn btn-primary btn-lg" type="submit">Apply</button>
                                    </form>
                                </div>
                            </div>
                        </main>


                    </div>
                </div>
                <!-- END Filter-->

                <!-- START Products Display-->

                <%
                List<Car> cList3 = (List<Car>)session.getAttribute("cList3");
                int diff = Integer.parseInt(session.getAttribute("diff")+"");
                int totalCar = Integer.parseInt(session.getAttribute("totalCarProduct")+"");
                %>
                <%  String addcarid = session.getAttribute("addcarid")+"";
                    String cartLoi = session.getAttribute("cartLoi")+"";
                    if(cartLoi.equals("null")) cartLoi="";
                %>
                <div class="col-lg-6">
                    <div style="margin: 21px;">
                        <h4><%=totalCar%> cars available  </h4>
                        <hr class="break-line">
                    </div>

                    <!-- START PAGE -->
                    <%
                    int page1 = Integer.parseInt(session.getAttribute("page")+"");
                    int curpage = Integer.parseInt(session.getAttribute("curpage")+"");
                    %>
                    <nav aria-label="Page navigation example">
                        <ul class="pagination">
                            <li class="page-item">
                                <a class="page-link" href="#" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                            <%
                            for (int i = 1; i <= page1; i++) {
                            %>
                            <li class="page-item"><a class="page-link <%=curpage==i?"active":""%>" href="page?curpage=<%=i%>"><%=i%></a></li>
                            <%
                                }
                            %>
                            <li class="page-item">
                                <a class="page-link" href="#" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </ul>
                    </nav>
                    <!-- END PAGE -->
                    
                    
                    <!-- START product item -->
                    <%
                    for (Car car : cList3) {
                    %>

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
                                            <p class="item-title">Price for <%=diff%> days:</p>
                                            <h5>$<%=car.getDailyprice()*diff%> </h5>
                                        </div>
                                    </div>
                                    <div class="row" >
                                        <div class="col-md-6">
                                            <a href="addtocart?cid=<%=car.getCarID()%>" class="btn btn-warning">Add to card</a>
                                        </div>
                                        <div class="col-md-6">
                                            <a href="detail?cid=<%=car.getCarID()%>" class="btn btn-warning">View deal</a>
                                        </div>
                                    </div>

                                </div>
                                <hr class="break-hr" style="width: 90%;">
                                <div class="review row" style="margin-left: 0px;">
                                    <div class="col-md-2 review-score" style="width: 52px;">
                                        <%=car.getReviewScore()%>
                                        <%
                                        float score = car.getReviewScore();
                                        String mark = "";
                                        if(score>=7 && score <8) mark = "Good";
                                        if(score>=8 && score <9) mark = "Very Good";
                                        if(score>=9) mark = "Excellent";
                                        %>
                                    </div>
                                    <div class="col-md-4">
                                        <div style="font-weight: bold;"> <%=mark%> </div>
                                        <div style="opacity: 0.8;"> <%=car.getReviewer()%> Reviews</div>
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
                <!-- END Products Display-->
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
