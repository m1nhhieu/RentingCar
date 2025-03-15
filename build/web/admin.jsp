<%-- 
    Document   : admin
    Created on : May 28, 2024, 9:07:04 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Customer" %>
<%@page import="model.Car" %>
<%@page import="model.Station" %>
<%@page import="model.Contract" %>
<%@page import="java.util.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
        <link rel="icon" href="img/webLogo.jpg" type="image/x-icon" />
        <!-- CSS Bootstrap -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" 
              integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" 
              crossorigin="anonymous">
        <!-- Script Link Bootstrap -->
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

        <!-- Font awesome -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />

        <style>
            .criteria{
                border: 1px solid #bb9797;
                border-radius: 6px;
                padding: 10px;
                box-shadow: 1px 1px 1px 1px #eeafaf;
            }

            .icon{
                justify-content: left;
                display: flex;
                align-items: center;
                font-size: 30px;

            }

            .content{
                text-align: right;
                padding: 0;
            }

            .content p{
                margin: 0;
            }

            .list2{
                margin-bottom: 22px;
            }

            .products{
                border: 1px solid gray;
                border-radius: 12px;
                box-shadow: 1px 1px 4px gray;
            }

            .edit{
                display: inline-block;
                background-color: yellow;
                padding: 6px 8px;
                border-radius: 4px;
                cursor: pointer;
                box-shadow: 1px 1px 6px gray;
            }

            .remove{
                color: white;
                display: inline-block;
                background-color: red;
                padding: 6px 8px;
                border-radius: 4px;
                cursor: pointer;
                margin-left: 12px;
                box-shadow: 1px 1px 6px gray;
            }

            .edit:hover,.remove:hover,.add:hover{
                opacity: 0.8;
            }

            .add{
                background-color: #c5c511;
                padding: 8px 10px;
                border-radius: 4px;
                color: white;
                cursor: pointer;
                box-shadow: 1px 1px 6px gray;
            }

            .product-img{
                width: 40%;
            }

            .product-img img{
                width: 60%;
            }
            
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
        </style>
    </head>
    <body>
        <div class="row">
            <!-- START HEADER -->

            <header class="p-3 text-bg-dark" style="z-index: 1;
                    position: relative;">
                <div class="container">
                    <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
                        <a href="admin.jsp" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
                            <i style="font-size: 32px" class="bi bi-house-door-fill"></i>
                        </a>

                        <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                            
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

            <!-- START menu -->
            <div class="col-md-2">
                <div class="d-flex flex-column flex-shrink-0 p-3 text-bg-dark" style="    position: absolute;
                     width: 16%;
                     top: 80px;
                     height: 120%;
                     bottom: 0;
                     ">

                    <hr>
                    
                    <%
                    String curlink = session.getAttribute("curlink")+"";
                    if(curlink.equals("null")) curlink="";
                    %>
                    <ul class="nav nav-pills flex-column mb-auto">
                        <li class="nav-item">
                            <a href="adnavlink?curlink=home" class="nav-link text-white home-link <%=curlink.equals("home")?"active":""%>" aria-current="page">
                                <svg class="bi pe-none me-2" width="16" height="16"><use xlink:href="#home"/></svg>
                                Home
                            </a>
                        </li>
                        <li>
                            <a href="adnavlink?curlink=product" class="nav-link text-white product-link <%=curlink.equals("product")?"active":""%>">
                                <svg class="bi pe-none me-2" width="16" height="16"><use xlink:href="#speedometer2"/></svg>
                                Products
                            </a>
                        </li>
                        <li>
                            <a href="adnavlink?curlink=account" class="nav-link text-white account-link <%=curlink.equals("account")?"active":""%>">
                                <svg class="bi pe-none me-2" width="16" height="16"><use xlink:href="#table"/></svg>
                                Accounts
                            </a>
                        </li>
                        
                        <li>
                            <a href="adnavlink?curlink=station" class="nav-link text-white station-link <%=curlink.equals("station")?"active":""%>">
                                <svg class="bi pe-none me-2" width="16" height="16"><use xlink:href="#table"/></svg>
                                Stations
                            </a>
                        </li>
                        
                        <li>
                            <a href="adnavlink?curlink=contract" class="nav-link text-white contract-link <%=curlink.equals("contract")?"active":""%>">
                                <svg class="bi pe-none me-2" width="16" height="16"><use xlink:href="#grid"/></svg>
                                Contracts
                            </a>
                        </li>
                        
                    </ul>
                    <hr>

                </div>
            </div>

            <!-- END menu -->

            <div class="col-md-10" style="padding: 40px;">
                
                <!-- START Home -->
                
                <%
                    String totalCar = session.getAttribute("totalCar") + "";
                    String totalCarBeingHired = session.getAttribute("totalCarBeingHired") + "";
                    String totalCategories = session.getAttribute("totalCategories") + "";
                    String totalsales = session.getAttribute("totalsales") + "";
                    String totaluser = session.getAttribute("totaluser") + "";
                    String totalstation = session.getAttribute("totalstation") + "";

                %>
                
                <div class="home" style="display: <%=curlink.equals("home")?"block":"none"%>;">
                    <div class="row list2">
                        <div class="col-md-2"></div>
                        <div class="col-md-4">
                            <div class="row g-0 criteria">
                                <div class="col-md-4 icon" style="color: green;">
                                    <i class="fa-solid fa-car"></i>
                                </div>
                                <div class="col-md-8">
                                    <div class="card-body content">
                                        <p class="card-text"><small class="text-body-secondary">Total Cars:</small></p>
                                        <h5 class="card-title"><%=totalCar%></h5>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="col-md-4">
                            <div class="row g-0 criteria">
                                <div class="col-md-4 icon" style="color: green;">
                                    <i class="fa-solid fa-money-bill"></i>
                                </div>
                                <div class="col-md-8">
                                    <div class="card-body content">
                                        <p class="card-text"><small class="text-body-secondary">Total sales:</small></p>
                                        <h5 class="card-title"><%=totalsales%>$</h5>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-2"></div>
                    </div>

                    <div class="row list2">
                        <div class="col-md-2"></div>
                        <div class="col-md-4">
                            <div class="row g-0 criteria">
                                <div class="col-md-4 icon" style="color: blue;">
                                    <i class="fa-solid fa-truck-fast"></i>
                                </div>
                                <div class="col-md-8">
                                    <div class="card-body content">
                                        <p class="card-text"><small class="text-body-secondary">Cars being hired:</small></p>
                                        <h5 class="card-title"><%=totalCarBeingHired%></h5>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="col-md-4">
                            <div class="row g-0 criteria">
                                <div class="col-md-4 icon">
                                    <i class="fa-solid fa-layer-group"></i>
                                </div>
                                <div class="col-md-8">
                                    <div class="card-body content">
                                        <p class="card-text"><small class="text-body-secondary">Total Categories:</small></p>
                                        <h5 class="card-title"><%=totalCategories%></h5>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-2"></div>
                    </div>

                    <div class="row list2">
                        <div class="col-md-2"></div>
                        <div class="col-md-4">
                            <div class="row g-0 criteria">
                                <div class="col-md-4 icon" style="color: blue;">
                                    <i class="fa-solid fa-users-line"></i>
                                </div>
                                <div class="col-md-8">
                                    <div class="card-body content">
                                        <p class="card-text"><small class="text-body-secondary">Total Users:</small></p>
                                        <h5 class="card-title"><%=totaluser%></h5>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="col-md-4">
                            <div class="row g-0 criteria">
                                <div class="col-md-4 icon" style="color: green;">
                                    <i class="fa-solid fa-parachute-box"></i>
                                </div>
                                <div class="col-md-8">
                                    <div class="card-body content">
                                        <p class="card-text"><small class="text-body-secondary">Total Stations:</small></p>
                                        <h5 class="card-title"><%=totalstation%></h5>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-2"></div>
                    </div>
                </div>

                <!-- END Home -->

                
                <!-- START products -->
                <div class="product" style="display: <%=curlink.equals("product")?"block":"none"%>;">
                    <div class="container products" >
                        <div>
                            <nav class="navbar navbar-expand-lg bg-body-tertiary">
                                <div class="container-fluid">
                                    <h5 class="navbar-brand" href="#">Manage Products</h5>

                                    <div class="" id="navbarSupportedContent">
                                        <form class="d-flex" role="search" action="adminproductsearch">
                                            <input placeholder="Car name" name="productsearch" class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                                            <button class="btn btn-outline-success" type="submit">Search</button>
                                        </form>
                                    </div>


                                    <div class="">
                                        <div class="d-flex add" role="search">
                                            <a href="addcar.jsp"><i style="color: white;" class="fa-solid fa-plus"></i></a>
                                        </div>
                                    </div>
                                </div>
                            </nav>
                        </div>
                        <table class="table">
                            <thead>
                                <tr>
                                    <th scope="col">Id</th>
                                    <th scope="col">Name</th>
                                    <th scope="col">Image</th>
                                    <th scope="col">Action</th>
                                </tr>
                            </thead>
                            <tbody>

                                <%
                            List<Car> carList = (List<Car>)session.getAttribute("adcList3");
                            for (Car car : carList) {
                
                                %>
                                <!-- START Product item -->
                                <tr>
                                    <th scope="row"><%=car.getCarID()%></th>
                                    <td><%=car.getName()%></td>
                                    <td class="product-img">
                                        <img src="<%=car.getImgage()%>">
                                    </td>
                                    <td>
                                        <div class="edit">
                                            <a href="caredit?carID=<%=car.getCarID()%>"><i style="color: black;" class="fa-solid fa-pen"></i></a>
                                            
                                        </div>
                                        <div class="remove">
                                            <a onclick="return confirm('Do you want to delete carID <%=car.getCarID()%>')" href="removecar?carID=<%=car.getCarID()%>"><i style="color: white;" class="fa-solid fa-trash-can"></i></a>     
                                        </div>
                                    </td>

                                </tr>
                                <!-- END Product item -->
                                <%
                                                    }
                                %>
                                

                            </tbody>
                        </table>
                                
                                <!-- START PAGE -->
                    <%
                    int page1 = Integer.parseInt(session.getAttribute("adpage")+"");
                    int curpage = Integer.parseInt(session.getAttribute("adcurpage")+"");
                    %>
                    <div style="display: flex;
                                justify-content: center;">
                        
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
                            <li class="page-item"><a class="page-link <%=curpage==i?"active":""%>" href="adpage?curpage=<%=i%>"><%=i%></a></li>
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
                        
                    </div>
                    <!-- END PAGE -->
                                
                    </div>
                </div>
                <!-- END products -->
                

                <!-- START accounts -->
                <%
                List<Customer> customerList = (List<Customer>)session.getAttribute("adminCustomer");
        
                %>
                <div class="account" style="display: <%=curlink.equals("account")?"block":"none"%>;">
                    <div class="container products" >
                        <div>
                            <nav class="navbar navbar-expand-lg bg-body-tertiary">
                                <div class="container-fluid">
                                    <h5 class="navbar-brand" href="#">Manage Account</h5>

                                    <div class="" id="navbarSupportedContent">
                                        <form class="d-flex" role="search" action="admincustomersearch">
                                            <input placeholder="Customer name" name="customersearch" class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                                            <button class="btn btn-outline-success" type="submit">Search</button>
                                        </form>
                                    </div>


                                    <div class="">
                                        <div class="d-flex add" role="search">
                                            <a href="addcustomer.jsp"><i style="color: white;" class="fa-solid fa-plus"></i></a>
                                        </div>
                                    </div>
                                </div>
                            </nav>
                        </div>
                        <table class="table">
                            <thead>
                                <tr>
                                    <th scope="col">Id</th>
                                    <th scope="col">Full Name</th>
                                    <th scope="col">Username</th>
                                    <th scope="col">Address</th>
                                    <th scope="col">Phone</th>
                                    <th scope="col">Role</th>
                                    <th scope="col">Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                int i =1;
                                for (Customer customer1 : customerList) {
        
                                %>
                                <!-- START Account item -->
                                <tr>
                                    <th scope="row"><%=i%></th>
                                    <td><%=customer1.getFirstName()+" "+customer1.getLastName()%></td>
                                    <td><%=customer1.getUsername()%></td>
                                    <td><%=customer1.getAddress()%></td>
                                    <td><%=customer1.getPhoneNumber()%></td>
                                    <td><%=customer1.getRole()%></td>
                                    <td>
                                        <div class="edit">
                                            <a href="editcustomer?cusername=<%=customer1.getUsername()%>"><i style="color: black;" class="fa-solid fa-pen"></i></a>
                                            
                                        </div>
                                        <div class="remove">
                                            <a onclick="return confirm('Do you want to delete customer <%=customer1.getUsername()%>')" href="removecustomer?cusername=<%=customer1.getUsername()%>"><i style="color: white;" class="fa-solid fa-trash-can"></i></a>     
                                        </div>
                                    </td>

                                </tr>
                                <!-- END Account item -->
                                <%
                                   i++; }
                                %>
                                
                            </tbody>
                        </table>
                    </div>
                </div>
                <!-- END accounts -->
                
                <!-- START STATIONS -->
                <%
                List<Station> stationList = (List<Station>)session.getAttribute("admin10Station");
                String loiremovestation = session.getAttribute("loiremovestation")+"";
                if(loiremovestation.equals("null")) loiremovestation="";
                %>
                <div class="station" style="display: <%=curlink.equals("station")?"block":"none"%>;">
                    <div class="container products" >
                        <div>
                            <nav class="navbar navbar-expand-lg bg-body-tertiary">
                                <div class="container-fluid">
                                    <h5 class="navbar-brand" href="#">Manage Stations</h5>

                                    <div class="" id="navbarSupportedContent">
                                        <form class="d-flex" role="search" action="stationsearch">
                                            <input placeholder="Station address" name="stationsearch" class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                                            <button class="btn btn-outline-success" type="submit">Search</button>
                                        </form>
                                    </div>


                                    <div class="">
                                        <div class="d-flex add" role="search">
                                            <a href="addstation.jsp"><i style="color: white;" class="fa-solid fa-plus"></i></a>
                                        </div>
                                    </div>
                                </div>
                            </nav>
                            <div style="color: red;"><%=loiremovestation%></div>
                        </div>
                        <table class="table">
                            <thead>
                                <tr>
                                    <th scope="col">Id</th>
                                    <th scope="col">Address</th>
                                    <th scope="col">Car Available</th>
                                    <th scope="col">Pick-up Location</th>
                                    <th scope="col">Country</th>
                                    <th scope="col">City</th>
                                    <th scope="col">Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                
                                for (Station station1 : stationList) {
        
                                %>
                                <!-- START Account item -->
                                <tr>
                                    <th scope="row"><%=station1.getStationID()%></th>
                                    <td><%=station1.getAddress()%></td>
                                    <td><%=station1.getCarAvailable()%></td>
                                    <td><%=station1.getPickupLocation()%></td>
                                    <td><%=station1.getCountry()%></td>
                                    <td><%=station1.getCity()%></td>
                                    <td>
                                        <div class="edit">
                                            <a href="editstation?stationid=<%=station1.getStationID()%>"><i style="color: black;" class="fa-solid fa-pen"></i></a>
                                            
                                        </div>
                                        <div class="remove">
                                            <a onclick="return confirm('Do you want to delete station <%=station1.getStationID()%>')" href="removestation?stationid=<%=station1.getStationID()%>"><i style="color: white;" class="fa-solid fa-trash-can"></i></a>     
                                        </div>
                                    </td>

                                </tr>
                                <!-- END Account item -->
                                <%
                                   i++; }
                                %>
                                
                            </tbody>
                        </table>
                                
                                
                                 <!-- START PAGE -->
                    <%
                    int stapage = Integer.parseInt(session.getAttribute("stapage")+"");
                    int stacurpage = Integer.parseInt(session.getAttribute("stacurpage")+"");
                    %>
                    <div style="display: flex;
                                justify-content: center;">
                        
                        <nav aria-label="Page navigation example">
                        <ul class="pagination">
                            <li class="page-item">
                                <a class="page-link" href="#" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                            
                           <%
                            for (int i1 = 1; i1 <= stapage; i1++) {
                            %>
                            <li class="page-item"><a class="page-link <%=stacurpage==i1?"active":""%>" href="adstapage?stacurpage=<%=i1%>"><%=i1%></a></li>
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
                        
                    </div>
                    <!-- END PAGE -->
                    </div>
                </div>
                <!-- END STATIONS -->
                
                
                <!-- START Contracts -->
                <div class="contract" style="display: <%=curlink.equals("contract")?"block":"none"%>;">
                    <div class="container products" >
                        <div>
                            <nav class="navbar navbar-expand-lg bg-body-tertiary">
                                <div class="container-fluid">
                                    <h5 class="navbar-brand" href="#">Check Contracts</h5>

                                    <div class="" id="navbarSupportedContent">
                                        <form action="admincontractsearch" class="d-flex" role="search">
                                            <input placeholder="Owner" name="contractsearch" class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                                            <button class="btn btn-outline-success" type="submit">Search</button>
                                        </form>
                                    </div>


                                    
                                </div>
                            </nav>
                        </div>
                        <table class="table">
                            <thead>
                                <tr>
                                    <th scope="col">Contract Id</th>
                                    <th scope="col">Username</th>
                                    <th scope="col">Car Id</th>
                                    <th scope="col">Pick-up Date Time</th>
                                    <th scope="col">Drop-off Date Time</th>
                                    <th scope="col">Pick-Up Station Id</th>
                                    <th scope="col">Drop-off Station Id</th>
                                    <th scope="col">Total Pay</th>
                                </tr>
                            </thead>
                            <tbody>

                                <%
                            List<Contract> contractAdminList = 
                                    (List<Contract>)session.getAttribute("contractAdminList");
                                    int total=0;
                            for (Contract contract : contractAdminList) {
                                total+=contract.getTotalRentPrice();
                                %>
                                <!-- START Contract item -->
                                <tr>
                                    <th scope="row"><%=contract.getContractID()%></th>
                                    <td><%=contract.getUsername()%></td>
                                    <td><%=contract.getCarId()%></td>
                                    <td><%=contract.getPickUpDateTime()%></td>
                                    <td><%=contract.getReturnDateTime()%></td>
                                    <td><%=contract.getPickUpLocation()%></td>
                                    <td><%=contract.getReturnLocation()%></td>
                                    <td><%=contract.getTotalRentPrice()%>$</td>

                                </tr>
                                <!-- END Contract item -->
                                <%
                                                    }
                                %>
                                
                                <tr>
                                    <th scope="row" style="color: green;">Total Price:</th>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <th scope="row" style="color: green;"><%=total%>$</th>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <!-- END Contracts -->
            </div>
        </div>

        
    </body>
</html>
