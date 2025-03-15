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
        <title>Login Page</title>

        <link rel="icon" href="img/webLogo.jpg" type="image/x-icon" />
        <!-- CSS Bootstrap -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" 
              integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" 
              crossorigin="anonymous">
        <!-- Script Link Bootstrap -->
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>

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
    <body class="d-flex align-items-center py-4 bg-body-tertiary">
        <div class="container">
            <%
                    String userC = request.getAttribute("userC")+"";
                    String passC = request.getAttribute("passC")+"";
                    if(userC.equals("null")) userC="";
                    if(passC.equals("null")) passC="";
            %>

            <main class="form-signin w-100 m-auto">
                <form action="login" method="post">
                    <img class="mb-4" src="img/webLogo.jpg" alt="" width="72" height="57">
                    <h1 class="h3 mb-3 fw-normal">Please sign in</h1>

                    <div class="form-floating input">
                        <input value="<%=userC%>" name="username" type="text" class="form-control" id="floatingInput" placeholder="name@example.com">
                        <label for="floatingInput">Username</label>
                    </div>
                    <div class="form-floating input">
                        <input value="<%=passC%>" name="password" type="password" class="form-control" id="floatingPassword" placeholder="Password">
                        <label for="floatingPassword">Password</label>
                    </div>

                    <!-- Error check Username and Password -->
                    <%
                        String e = request.getAttribute("loi")+"";
                        if(e.equals("null")){
                            e = "";
                        }                                 
                    %>
                    <div style="text-align: left;
                         color: red;
                         margin-left: 5px;">
                        <%=e%>
                    </div>
                    <div class="form-check text-start my-3">
                        <div class="input-footer">
                            <div>
                                <input name="remember" class="form-check-input" type="checkbox" value="remember-me" id="flexCheckDefault">
                                <label class="form-check-label remember" for="flexCheckDefault">
                                    Remember me
                                </label>
                            </div>

                            <div class="forgot">
                                <a href="forgot.jsp">Forgot password?</a>
                            </div>
                        </div>
                    </div>
                    <button class="btn btn-primary w-100 py-2" type="submit">Sign in</button>
                    <p class="mt-5 mb-3 text-body-secondary">Don't have an account? <a href="register.jsp">Register here</a> </p>
                </form>
            </main>

        </div>
    </body>
</html>
