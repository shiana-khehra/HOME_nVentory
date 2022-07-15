<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

            .headStyle {
                color: white;
                margin-right: 164px;
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
        <title>User account</title>
    </head>
    <body>
        <section class="background-radial-gradient overflow-hidden">
            <div class="container px-3 py-5 px-md-5 text-lg-start my-1">
                <c:if test="${message != null}">
                <div class="alert alert-success alert-dismissible" role="alert">
                    <div class="float-right" style="display: inline"><button><a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a></button></div>
                  <p>${message}</p>
                </div>
                </c:if>
                
                <c:if test="${warn != null}">
                <div class="alert alert-warning alert-dismissible" role="alert">
                    <div class="float-right" style="display: inline"><button><a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a></button></div>
                  <p>${warn}</p>
                </div>
                </c:if>
            <div class="mb-4">
                <nav class="navbar navbar-expand-sm bg-dark py-4 " style="border-radius: 1rem; z-index: 10">
                   <ul class="navbar-nav ml-auto">
                    <li class="headStyle">
                      <h5 class="nav-link">Name: ${firstname} ${lastname}</h5>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" href="user?home" style="color: white; size: 3">Home page</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" href="inventory" style="color: white; size: 3">Manage inventory</a>
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
                <div class="row d-flex justify-content-center align-items-center mb-5">
  
                  <div class="col-12 col-md-8 col-lg-6 col-xl-8" style="z-index: 10">
                  </div>

                  <div class="col-lg-6 mb-5 mb-lg-0">
                    <div id="radius-shape-1" class="position-absolute rounded-circle shadow-5-strong"></div>
                    <div id="radius-shape-2" class="position-absolute shadow-5-strong"></div>

                    <div class="card bg-dark text-white pos" style="border-radius: 1rem;">
                      <div class="card-body px-5 py-5 px-md-5">
                        <form action="user" method="post">
                            <h2 class="fw-bold mb-4 text-uppercase">Edit account details</h2>

                          <!-- Email input -->
                          <div class="form-outline mb-4">
                            <input type="email" id="form3Example3" name="email" class="form-control" required />
                            <label class="form-label" for="form3Example3">Email address (already registered in account)</label>
                          </div>

                          <!-- Password input -->
                          <div class="form-outline mb-4">
                            <input type="password" id="form3Example4" name="passwd" class="form-control" required />
                            <label class="form-label" for="form3Example4">Password</label>
                          </div>

                          <!-- 2 column grid layout with text inputs for the first and last names -->
                          <div class="row">
                            <div class="col-md-6 mb-4">
                              <div class="form-outline">
                                <input type="text" id="form3Example1" name="fname" class="form-control" required />
                                <label class="form-label" for="form3Example1">First name</label>
                              </div>
                            </div>
                            <div class="col-md-6 mb-4">
                              <div class="form-outline">
                                <input type="text" id="form3Example2" name="lname" class="form-control" required />
                                <label class="form-label" for="form3Example2">Last name</label>
                              </div>
                            </div>
                          </div>
                          
                          <!-- Submit button -->
                          <div class="text-center">
                            <button type="submit" class="btn btn-outline-light btn-block btn-lg px-5 mb-5 text">
                              Submit
                            </button>
                          </div>
                        </form>   
                    </div>
                    </div>
                  </div>
                </div>
              </div>
        </section>
    </body>
</html>