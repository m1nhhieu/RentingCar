<%-- 
    Document   : profile
    Created on : May 24, 2024, 1:21:04 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Customer" %>
<%@page import="model.Car" %>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Car Page</title>
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


        <div class="container">
            <main>
                <div class="py-5 text-center" >
                    <img class="d-block mx-auto mb-4" src="img/user.png" alt="" width="72">
                    <h2>Edit product</h2>
                </div>

                <div class="row g-5" style="justify-content: center;">


                    <%
                    
                    
                    Car car = (Car)session.getAttribute("carEditAmin");
                    List<Integer> priceList = (List<Integer>)session.getAttribute("priceList");
                    List<Integer> stationList = (List<Integer>)session.getAttribute("stationList");
            
           
                    %>

                    <div class="col-md-8">
                        <form class="needs-validation" action="caredit" method="post" enctype="multipart/form-data">
                            <div class="row g-3">
                                <div class="col-sm-6">
                                    <label for="carid" class="form-label">Car Id</label>
                                    <input disabled="" value="<%=car.getCarID()%>" name="carid" type="text" class="form-control" id="carid" required>

                                </div>

                                <div class="col-sm-6">
                                    <label for="carname" class="form-label">Car Name</label>
                                    <input  value="<%=car.getName()%>" name="carname" type="text" class="form-control" id="carname" required>

                                </div>
                                <div class="col-sm-6">
                                    <label for="image" class="form-label">Car Image</label>
                                    <input name="image" type="file" class="form-control" id="image">
                                    <img style="margin-top: 10px;" src="<%=car.getImgage()%>" alt="alt"/>
                                </div>


                                <div class="my-3 col-sm-6">
                                    <label for="available" class="form-label">Available</label>
                                    <div class="form-check">
                                        <input <%=car.isAvailable()?"checked":""%> value="1" id="available" name="available" type="radio" class="form-check-input">
                                        <label class="form-check-label" for="available">1</label>
                                    </div>
                                    <div class="form-check">
                                        <input <%=car.isAvailable()==false?"checked":""%> value="0" id="available1" name="available" type="radio" class="form-check-input">
                                        <label class="form-check-label" for="available1">0</label>
                                    </div>
                                </div>
                                <div class="col-12">
                                    <label for="priceid" class="form-label">Price Id</label>
                                    <select name="priceid" class="form-control">
                                        <%
                                         for (Integer integer : priceList) {
                                                   
                                        %>
                                        <option <%=(car.getPriceID()==integer)?"selected":""%> value="<%=integer%>"><%=integer%></option>
                                        
                                        <%
                                         }
                                        %>
                                    </select>
                                </div>

                                <div class="col-12">
                                    <label for="stationid" class="form-label">Station Id</label>
                                    <select name="stationid" class="form-control">
                                        <%
                                         for (Integer integer : stationList) {
                                                   
                                        %>
                                        <option <%=(car.getStationID()==integer)?"selected":""%> value="<%=integer%>"><%=integer%></option>
                                        
                                        <%
                                         }
                                        %>
                                    </select>
                                </div>

                                <div class="col-12">
                                    <label for="numberofseats" class="form-label">Number of Seats</label>
                                    <input value="<%=car.getNumberOfSeats()%>" name="numberofseats" type="number" class="form-control" id="numberofseats" placeholder="5,7,10,...">
                                </div>
                                <div class="col-12">
                                    <label for="numberoflargebags" class="form-label">Number of Large Bags</label>
                                    <input value="<%=car.getLargeBags()%>" name="numberoflargebags" type="number" class="form-control" id="numberoflargebags" placeholder="1,2,3,...">
                                </div>
                                <div class="col-12">
                                    <label for="numberofsmallbags" class="form-label">Number of Small Bags</label>
                                    <input value="<%=car.getSmallBags()%>" name="numberofsmallbags" type="number" class="form-control" id="numberofsmallbags" placeholder="1,2,3,...">
                                </div>


                            </div>

                            <hr class="my-4">
                            <!-- Error check Username and Password -->
                            <%
                                String e = session.getAttribute("loiprofile")+"";
                                if(e.equals("null")) e = "";                   
                            %>
                            <div style="text-align: left;
                                 color: red;
                                 margin-left: 5px;">
                                <%=e%>
                            </div>

                            <button class="w-100 btn btn-primary btn-lg" type="submit">Save</button>
                        </form>
                    </div>
                </div>
            </main>

            <footer class="my-5 pt-5 text-body-secondary text-center text-small">

            </footer>
        </div>

    </body>
</html>
