<%-- 
    Document   : login.jsp
    Created on : May 24, 2024, 10:27:44 AM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change Password Page</title>


        <!-- CSS Bootstrap -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" 
              integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" 
              crossorigin="anonymous">
        <!-- Script Link Bootstrap -->
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>


        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

        <style>
            form{
                text-align: center;
            }

            .input{
                margin: 12px 0;
            }

            .input-footer{
                display: flex;
                justify-content: space-between;
            }

            .forgot,.remember{
                cursor: pointer;
            }

            .forgot:hover{
                opacity: 0.8;
            }

            form{
                margin-top: 90px;
            }
        </style>



    </head>
    <body class=" align-items-center bg-body-tertiary">
        <div class="container">
                <header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
                    <a href="home.jsp" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
                        <i style="margin-right: 10px;
                           font-size: 24px;" class="bi bi-arrow-90deg-left"></i>
                        <span class="fs-4">Back to home</span>
                    </a>                
                </header>

            <main class="form-signin w-100 m-auto">
                <form action="changepass" method="post">
                    <div><i class="bi bi-shield-fill-check" style="font-size: 65px;
                            color: #0067ff;"></i></div>
                    <h1 class="h3 mb-3 fw-normal">Change your password</h1>

                    <div class="form-floating input">
                        <input name="oldpassword" type="password" class="form-control" id="floatingInput" placeholder="name@example.com">
                        <label for="floatingInput">Old password</label>
                    </div>
                    <div class="form-floating input">
                        <input name="newpassword" type="password" class="form-control" id="floatingPassword" placeholder="Password">
                        <label for="floatingPassword">New password</label>
                    </div>
                    <div class="form-floating input">
                        <input name="confirmpassword" type="password" class="form-control" id="floatingPassword" placeholder="Password">
                        <label for="floatingPassword">Confirm password</label>
                    </div>
                    <!-- Error check Username and Password -->
                    <%
                        String e = request.getAttribute("loi")+"";
                        if(e.equals("null")){
                            e = "";
                        } 
                        String success = request.getAttribute("success")+"";
                        

                    %>
                    <div style="text-align: left;
                         color: red;
                         margin-left: 5px;">
                        <%=e%>
                    </div>
                    <%
                    if(success.equals("null")==false){
                    %>
                    <div style="text-align: left;
                         color: #90d426;
                         margin-left: 5px;">
                        <i style="margin-right: 5px;" class="bi bi-check-circle"></i><%=success%>
                    </div>
                    <%
                     }
                    %>
                    <div class="form-check text-start my-3">

                    </div>
                    <button class="btn btn-primary w-100 py-2" type="submit">Save</button>

                </form>
            </main>

        </div>
    </body>
</html>
