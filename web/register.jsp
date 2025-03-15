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
        <title>Register Page</title>
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
                margin-top: 50px;
            }
        </style>



    </head>
    <body class="d-flex align-items-center py-4 bg-body-tertiary">
        <div class="container">

            <%
            
            String firstname = session.getAttribute("firstname")+"";
            if(firstname.equals("null")) firstname = "";
            String lastname = session.getAttribute("lastname")+"";
            if(lastname.equals("null")) lastname = "";
            String email = session.getAttribute("email")+"";
            if(email.equals("null")) email = "";
            String username = session.getAttribute("username")+"";
            if(username.equals("null")) username = "";
            
            %>

            <main class="form-signin w-100 m-auto">
                <form action="register" method="post">
                    <img class="mb-4" src="img/webLogo.jpg" alt="" width="72" height="57">
                    <h1 class="h3 mb-3 fw-normal">Please sign up</h1>


                    <div class="form-floating input">
                        <input value="<%=firstname%>" required="" name="firstname" type="text" class="form-control" id="firstname" placeholder="name@example.com">
                        <label for="firstname">First name</label>
                    </div>
                    <div class="form-floating input">
                        <input value="<%=lastname%>" required="" name="lastname" type="text" class="form-control" id="lastname" placeholder="name@example.com">
                        <label for="floatingInput">Last name</label>
                    </div>
                    <div class="form-floating input">
                        <input value="<%=email%>" required="" name="email" type="email" class="form-control" id="email" placeholder="name@example.com">
                        <label for="email">Email address</label>
                    </div>
                    <div class="form-floating input">
                        <input value="<%=username%>" required="" name="username" class="form-control" id="username" placeholder="name@example.com">
                        <label for="username">Username</label>
                    </div>
                    <div class="form-floating input">
                        <input required="" name="password" type="password" class="form-control" id="password" placeholder="Password">
                        <label for="password">Password</label>
                    </div>
                    <div class="form-floating input">
                        <input required="" name="confirmpassword" type="password" class="form-control" id="confirmpassword" placeholder="Password">
                        <label for="confirmpassword">Confirm password</label>
                    </div>

                    <%
                    String loi = session.getAttribute("loi")+"";
                    if(loi.equals("null")) loi = "";
                    %>
                    <div style="color: red; text-align: left;">
                        <%=loi%>
                    </div>

                    <button class="btn btn-primary w-100 py-2" type="submit">Sign up</button>


                </form>
            </main>
            <script src="/docs/5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

        </div>
    </body>
</html>
