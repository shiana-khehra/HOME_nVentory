<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <style>
            .background-radial-gradient {
              background-color: linear-gradient(to right, rgba(106, 17, 203, 1), rgba(37, 117, 252, 1));
              background-image: linear-gradient(to right, rgba(106, 17, 203, 1), rgba(37, 117, 252, 1));
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
        <title>Register</title>
    </head>
    <body>
        <section class="background-radial-gradient overflow-hidden">
            <div class="container px-3 py-5 px-md-5 text-center text-lg-start my-5">
                <div class="row gx-lg-5 align-items-center mb-5">
                    
                  <div class="col-lg-6 mb-5 mb-lg-0" style="z-index: 10">
                    <h1 class="my-5 display-5 fw-bold ls-tight" style="color: hsl(218, 81%, 95%)">
                      The best solution <br />
                      <span style="color: hsl(218, 81%, 75%)">for your home inventory</span>
                    </h1>
                    <p class="mb-4 opacity-70" style="color: hsl(218, 81%, 85%)">
                      Sign in to experience the world of most efficient and easy-to-use
                      inventory management application to keep track of your household
                      items for insurance purposes. No more hustle to remember your daily needs.
                    </p>
                  </div>

                  <div class="col-lg-6 mb-5 mb-lg-0 position-relative">
                    <div id="radius-shape-1" class="position-absolute rounded-circle shadow-5-strong"></div>
                    <div id="radius-shape-2" class="position-absolute shadow-5-strong"></div>

                    <div class="card bg-dark text-white"  style="border-radius: 1rem;">
                      <div class="card-body px-4 py-5 px-md-5">
                        <form action="register" method="post">
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

                          <!-- Email input -->
                          <div class="form-outline mb-4">
                            <input type="email" id="form3Example3" name="email" class="form-control" required />
                            <label class="form-label" for="form3Example3">Email address</label>
                          </div>

                          <!-- Password input -->
                          <div class="form-outline mb-5">
                            <input type="password" id="form3Example4" name="passwd" class="form-control" required />
                            <label class="form-label" for="form3Example4">Password</label>
                          </div>

                          <!-- Submit button -->
                          <div class="text-center">
                            <button type="submit" class="btn btn-outline-light btn-block btn-lg px-5 mb-5 text">
                              Sign up
                            </button>
                          </div>
                        </form>
                          
                      <div class="text-center">
                          <p class="mb-0">Already have an account? <a href="login" class="text-white-50 fw-bold">Log in</a>
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
