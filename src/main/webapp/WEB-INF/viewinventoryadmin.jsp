<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
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
            
            .headStyle {
                color: white;
                margin-right: 254px;
            }
            
            body{
              margin-top:20px;
              background-color: linear-gradient(to right, rgba(106, 17, 203, 1), rgba(37, 117, 252, 1));
              background-image: linear-gradient(to right, rgba(106, 17, 203, 1), rgba(37, 117, 252, 1));
            }
        </style>
        <title>User's inventory</title>
    </head>
    <body>
        <div class="container">
            <c:if test="${msg != null}">
                <div class="alert alert-success alert-dismissible" role="alert">
                    <div class="float-right" style="display: inline"><button><a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a></button></div>
                  <p>${msg}</p>
                </div>
            </c:if>
            <div class="mb-4">
                <nav class="navbar navbar-expand-sm bg-dark py-4 " style="border-radius: 1rem; z-index: 10">
                   <ul class="navbar-nav ml-auto">
                    <li class="headStyle">
                      <h5 class="nav-link">Name: ${firstname} ${lastname}</h5>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" href="manageuser" style="color: white; size: 3">Manage users</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" href="roles" style="color: white; size: 3">Manage roles</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" href="category" style="color: white; size: 3">Manage categories</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" href="login?logout" style="color: white; size: 3">Logout</a>
                    </li>
                   </ul>
                </nav>
            </div>
            
        <div class="row flex-lg-nowrap">
          <div class="col">
            <div class="row flex-lg-nowrap">
              <div class="col mb-3">
                <div class="e-panel card bg-dark text-white" style="border-radius: 1rem;">
                  <div class="card-body text-white">
                    <div class="card-title mb-6"> 
                        <h2 class="fw-bold mb-6 text-uppercase" style="display: inline">User's Inventory</h2>
                        <div class="col-12 col-lg-3 mb-6" style="display: inline; float: right">
                            <form class="d-flex" method="post" action="manageuser">
                               <input type="hidden" name="action" value="admininventory">
                               <input class="form-control me-2" type="text" placeholder="Search" name="search" aria-label="Search"> &nbsp;&nbsp;&nbsp;
                               <button class="btn btn-outline-light" type="submit">Search</button>
                            </form>
                        </div>
                    </div>
                    <div class="e-table">
                      <div class="table-responsive table-lg mt-4">
                        <table class="table table-bordered text-white">
                          <thead>
                            <tr>
                              <th>Item name</th>
                              <th>Owner</th>
                            </tr>
                          </thead>
                          <tbody>
                            <c:forEach var="admininven" items="${admininvens}">
                                <tr>
                                    <td>${admininven.item_name}</td>
                                    <td>${admininven.owner}</td>
                                </tr>
                            </c:forEach>
                          </tbody>
                        </table>
                      </div>
                      <div class="d-flex justify-content-center text-black" style="display: inline;">
                        <ul class="pagination mt-3 mb-0">
                          <li class="disabled page-item"><a href="#" class="page-link">‹</a></li>
                          <li class="active page-item"><a href="#" class="page-link">1</a></li>
                          <li class="page-item"><a href="#" class="page-link">2</a></li>
                          <li class="page-item"><a href="#" class="page-link">3</a></li>
                          <li class="page-item"><a href="#" class="page-link">4</a></li>
                          <li class="page-item"><a href="#" class="page-link">5</a></li>
                          <li class="page-item"><a href="#" class="page-link">›</a></li>
                          <li class="page-item"><a href="#" class="page-link">»</a></li>
                        </ul>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
    </body>
</html>
