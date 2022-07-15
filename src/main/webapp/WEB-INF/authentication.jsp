<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <style>
            .gradient-custom {
                /* fallback for old browsers */
                background: #6a11cb;

                /* Chrome 10-25, Safari 5.1-6 */
                background: -webkit-linear-gradient(to right, rgba(106, 17, 203, 1), rgba(37, 117, 252, 1));

                /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
                background: linear-gradient(to right, rgba(106, 17, 203, 1), rgba(37, 117, 252, 1))
            }
            
            .float-right {
                float: right;
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
        <title>Login</title>
    </head>
    <body>
        <section class="vh-120 gradient-custom">
          <div class="container py-5 h-100">
              <c:if test="${submitted != null}">
                <div class="alert alert-success alert-dismissible" role="alert">
                    <h4 class="alert-heading" style="display: inline-block;" >${successMsg}</h4>
                    <div class="float-right" style="display: inline"><button><a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a></button></div>
                  <p>${submitted}</p>
                </div>
              </c:if>
              
              <c:if test="${logout != null}">
                <div class="alert alert-success alert-dismissible" role="alert">
                    <div class="float-right" style="display: inline"><button><a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a></button></div>
                  <p>${logout}</p>
                </div>
              </c:if>
              
              <c:if test="${message != null}">
                <div class="alert alert-warning alert-dismissible" role="alert">
                    <div class="float-right" style="display: inline"><button><a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a></button></div>
                  <p>${message}</p>
                </div>
              </c:if>
            <h1 class="my-10 display-5 fw-bold ls-tight" style="color: hsl(218, 81%, 95%)">
               Welcome to HOME nVentory . . .<br />
               <span style="color: hsl(218, 81%, 75%)">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Your ultimate solution to inventory management</span>
            </h1>
            <div class="row d-flex justify-content-center align-items-center h-100">
              <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                <div class="card bg-dark text-white" style="border-radius: 1rem;">
                  <div class="card-body p-5 text-center">
                    <div class="mb-md-6 mt-md-1 pb-4">

                    <form action="login" method="post">
                      <h2 class="fw-bold mb-2 text-uppercase">Login</h2>
                      <p class="text-white-50 mb-5">Please enter your login and password!</p>

                      <div class="form-outline form-white mb-4">
                        <input type="email" id="typeEmailX" name="email" class="form-control form-control-lg" />
                        <label class="form-label" for="typeEmailX">Email</label>
                      </div>

                      <div class="form-outline form-white mb-4">
                        <input type="password" id="typePasswordX" name="password" class="form-control form-control-lg" />
                        <label class="form-label" for="typePasswordX">Password</label>
                      </div>

                      <p class="small mb-5 pb-lg-2"><a class="text-white-50" href="#!">Forgot password?</a></p>

                      <button class="btn btn-outline-light btn-lg px-5" type="submit">Login</button>
                    </form>

                    </div>

                    <div>
                      <p class="mb-0">Don't have an account? <a href="register" class="text-white-50 fw-bold">Register</a>
                      </p>
                    </div>
                  </div>
                  </div>
                </div>
              </div>
            </div>
        </section>
    </body>
</html>