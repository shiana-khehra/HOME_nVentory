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
                margin-right: 294px;
            }
            
            body{
              margin-top:20px;
              background-color: linear-gradient(to right, rgba(106, 17, 203, 1), rgba(37, 117, 252, 1));
              background-image: linear-gradient(to right, rgba(106, 17, 203, 1), rgba(37, 117, 252, 1));
            }
        </style>
        <title>User inventory</title>
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
                      <a class="nav-link" href="user?home" style="color: white; size: 3">Home page</a>
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
            
        <div class="row flex-lg-nowrap">
          <div class="col">
            <div class="row flex-lg-nowrap">
              <div class="col mb-3">
                <div class="e-panel card bg-dark text-white" style="border-radius: 1rem;">
                  <div class="card-body text-white">
                    <div class="card-title mb-6"> 
                        <h2 class="fw-bold mb-6 text-uppercase" style="display: inline">Your inventory items</h2>
                        <div class="col-12 col-lg-3 mb-6" style="display: inline; float: right">
                            <div class="text-center px-xl-3 mb-6">
                              <button class="btn btn-outline-light btn-block mb-6" type="button" data-toggle="modal" data-target="#user-form-modal">Add new item</button>
                            </div>
                        </div>
                    </div>
                    <div class="e-table">
                      <div class="table-responsive table-lg mt-4">
                        <table class="table table-bordered text-white">
                          <thead>
                            <tr>
                              <th>Item_id</th>
                              <th>Category</th>
                              <th class="max-width">Item Name</th>
                              <th class="sortable">Price</th>
                              <th>Owner</th>
                              <th>Actions</th>
                            </tr>
                          </thead>
                          <tbody>
                            <c:forEach var="item" items="${items}">
                                <tr>
                                    <td>${item.item_id}</td>
                                    <td>${item.category}</td>
                                    <td>${item.item_name}</td>
                                    <td>${item.price}</td>
                                    <td>${item.owner}</td>
                                    <td class="text-center align-middle">
                                        <div class="btn-group align-top">
                                            <a href="inventory?action=editButton&id=${item.item_id}">Edit</a> &nbsp;&nbsp;&nbsp;
                                            <a href="inventory?action=deleteButton&id=${item.item_id}"><i class="fa fa-trash"></i></a>
                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>
                          </tbody>
                        </table>
                      </div>
                      <div class="d-flex justify-content-center text-black">
                        <ul class="pagination mt-3 mb-0">
                          <li class="disabled page-item"><a href="#" class="page-link">???</a></li>
                          <li class="active page-item"><a href="#" class="page-link">1</a></li>
                          <li class="page-item"><a href="#" class="page-link">2</a></li>
                          <li class="page-item"><a href="#" class="page-link">3</a></li>
                          <li class="page-item"><a href="#" class="page-link">4</a></li>
                          <li class="page-item"><a href="#" class="page-link">5</a></li>
                          <li class="page-item"><a href="#" class="page-link">???</a></li>
                          <li class="page-item"><a href="#" class="page-link">??</a></li>
                        </ul>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>

            <!-- Item Form Modal -->
            <div class="modal fade" role="dialog" tabindex="-1" id="user-form-modal">
              <div class="modal-dialog modal-lg" role="document">
                <div class="modal-content bg-dark text-white">
                  <div class="modal-header">
                    <h5 class="modal-title">New Item</h5>
                    <button type="button" class="close" data-dismiss="modal">
                      <span aria-hidden="true">??</span>
                    </button>
                  </div>
                  <div class="modal-body">
                    <div class="py-1">
                        <form class="form" method="post" action="inventory">
                        <input type="hidden" name="action" value="add">
                        <div class="row">
                          <div class="col">
                            <div class="row">
                              <div class="col">
                                <div class="form-group">
                                  <label>Item name</label>
                                  <input class="form-control" type="text" name="name" required>
                                </div>
                              </div>
                              <div class="col">
                                <div class="form-group">
                                  <label>Category</label> <br>
                                  <select class="form-control" name="category" id="category" required>
                                        <c:forEach var="category" items="${categories}">
                                            <option value="${category.category_name}">${category.category_name}</option>
                                        </c:forEach>
                                  </select>
                                </div>
                              </div>
                            </div>
                          </div>
                        </div>
                        <div class="row">
                          <div class="col-12 col-sm-6 mb-3">
                            
                            <div class="row">
                              <div class="col">
                                <div class="form-group">
                                  <label>Price</label>
                                  <input class="form-control" type="number" min="0" name="price" id="price" required>
                                </div>
                              </div>
                            </div>
                          </div>
                        </div>
                        <div class="row">
                          <div class="col d-flex justify-content-end">
                            <button class="btn btn btn-outline-light" type="submit">Add</button>
                          </div>
                        </div>
                      </form>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
       </div>
    </body>
</html>