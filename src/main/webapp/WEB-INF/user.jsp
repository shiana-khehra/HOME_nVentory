<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
        <style>
            .background-radial-gradient {
              background-color: linear-gradient(to right, rgba(106, 17, 203, 1), rgba(37, 117, 252, 1));
              background-image: linear-gradient(to right, rgba(106, 17, 203, 1), rgba(37, 117, 252, 1));
            }
            
            .nav-item {
                text-decoration: underline;
                margin-right: 25px;
            }
            
            .nav-item:hover {
                background-color: grey;
            }
            
            #radius-shape-1 {
              height: 220px;
              width: 220px;
              top: -60px;
              left: -130px;
              background: radial-gradient(#44006b, #ad1fff);
              overflow: hidden;
            }

            #radius-shape-2 {
              border-radius: 38% 62% 63% 37% / 70% 33% 67% 30%;
              bottom: -60px;
              right: -110px;
              width: 300px;
              height: 300px;
              background: radial-gradient(#44006b, #ad1fff);
              overflow: hidden;
            }
        </style>
        <title>User Home Page</title>
    </head>
    <body>
        <section class="vh-100 background-radial-gradient overflow-hidden">
            <div class="container px-3 py-5 px-md-5 text-center text-lg-start my-1">
            <div class="mb-4">
                <nav class="navbar navbar-expand-sm bg-dark py-4 " style="border-radius: 1rem; z-index: 10">
                   <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                      <a class="nav-link" href="inventory" style="color: white; size: 3">Manage inventory</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" href="user?edit" style="color: white; size: 3">Edit account</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" href="login?deactivate" style="color: white; size: 3">Deactivate account</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" href="login?logout" style="color: white; size: 3">Logout</a>
                    </li>
                   </ul>
                </nav>
            </div>
                <div class="row gx-lg-5 align-items-center mb-5">
                    
                  <div class="col-lg-15 mb-5 mb-lg-0" style="z-index: 10">
                    <h1 class="my-5 display-5 fw-bold ls-tight" style="color: hsl(218, 81%, 95%)">
                      Welcome back ! <br />
                      <span style="color: hsl(218, 81%, 75%)">${firstname} ${lastname}</span>
                    </h1>
                    <p class="mb-4 opacity-70" style="color: hsl(218, 81%, 85%)">
                      Experience the world of most efficient and easy-to-use
                      inventory management application to keep track of your household
                      items for insurance purposes. No more hustle to remember your daily needs.
                    </p>
                  </div>

                  <div class="col-lg-6 mb-5 mb-lg-0 position-relative">
                    <div id="radius-shape-1" class="position-absolute rounded-circle shadow-5-strong"></div>
                    <div id="radius-shape-2" class="position-absolute shadow-5-strong"></div>
                  </div>
                </div>
              </div>
        </section>
    </body>
</html>