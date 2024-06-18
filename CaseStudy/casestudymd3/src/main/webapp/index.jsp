<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Web thú cưng</title>
  <link rel="stylesheet" href="static/css/bootstrap.css">
  <script src="static/js/bootstrap.js"></script>
  <link rel="stylesheet" href="static/myCSS/menubar.css">
  <link rel="stylesheet" href="static/myCSS/userCard.css">
  <script src="static/myJS/backgroundImage.js"></script>
  <script src="static/myJS/btnAddToCard.js"></script>
  <script src="static/myJS/btnDisabled.js"></script>
    <style>
        .card {
            z-index: 1;
        }
    </style>
</head>
<body style="overflow-x: hidden">
    <div id="headerID">

    </div>
    <div id="menubarID" style="position: fixed;top:0px; right: 0px; left: 0px; z-index: 10">
      <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
        <div class="container-fluid">
          <a class="navbar-brand" href="/home">My WEB</a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="/home">Home</a>
              </li>
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="/dog">List Dog</a>
              </li>
              <li class="nav-item">
                  <c:if test="${idUser == null}">
                      <a class="nav-link active" aria-current="page" href="/login">Login</a>
                  </c:if>
                  <c:if test="${idUser != null}">
                      <a class="nav-link disabled" aria-current="page" >Login</a>
                  </c:if>
              </li>
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="/user?action=create&check=2">Sign up</a>
              </li>
                <li class="nav-item">
                    <c:if test="${idUser != null}">
                        <form action="/home" method="post">
                            <button class="btn btn-primary" role="button">Đăng Xuất</button>
                        </form>
                    </c:if>
                </li>
            </ul>
            <form class="d-flex" style="float: right" action="/dog?action=nameSearch" method="post">
              <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item dropdown" style="margin-right: 15px">
                  <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownType" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                    Type
                  </a>
                  <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <c:forEach items="${typeList}" var="type">
                      <li><a class="dropdown-item" href="/dog?action=typeSearch&type=${type}">${type}</a></li>
                      <%--                    <li><hr class="dropdown-divider"></li>--%>
                    </c:forEach>
                  </ul>
                </li>
                <li class="nav-item dropdown" style="margin-right: 15px">
                  <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownColor" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                    Color
                  </a>
                  <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <c:forEach items="${colorList}" var="color">
                      <li><a class="dropdown-item" href="/dog?action=colorSearch&color=${color}">${color}</a></li>
                    </c:forEach>
                  </ul>
                </li>
              </ul>
              <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="search" value="${nameSearch}">
              <button class="btn btn-outline-light" type="submit">Search</button>
            </form>
          </div>
        </div>
      </nav>
    </div>
    <div id="contentID">
      <div class="row">
        <img src="static/data/background/dogBG1.jpg" onclick="changeImage()" class="img-fluid" alt="..." id="backgroundimgID">
      </div>
      <div id="listCardID" style=" padding: 20px">
        <div class="row">
          <div class="col-xl-8 col-8">
            <div class="row row-cols-1 row-cols-md-3 g-4">
              <c:forEach items="${dogList}" var="dog">
                <div class="col">
                  <div class="card h-100">
                    <img src="static/data/card/${dog.image}" class="card-img-top" alt="..." height="300px">
                    <div class="card-body">
                      <h5 class="card-title" style="height: 50px">Name: ${dog.name}</h5>
                      <p class="card-text">Type: ${dog.type}</p>
                      <p class="card-text">Color: ${dog.color}</p>
                      <c:if test="${idUser != null && initBookingID == newBookingID}">
                        <a href="/booked-servlet?action=create&bookingID=${newBookingID}&dogBookedID=${dog.getId()}" class="btn btn-primary">Add to card</a>
                      </c:if>
                        <c:if test="${idUser != null && initBookingID == 0}">
                            <a href="#" class="btn btn-primary disabled">Add to card</a>
                        </c:if>
                      <c:if test="${idUser == null}">
                        <a href="#" class="btn btn-primary disabled">Add to card</a>
                      </c:if>
<%--                      <a href="/booked-servlet?action=create&bookingID=10&dogBookedID=${dog.getId()}" class="btn btn-primary">Add to card</a>--%>
                    </div>
                  </div>
                </div>
              </c:forEach>
            </div>
          </div>
          <div class="col-xl-4 col-4" >
            <div class="col">
              <div class="card h-100" >
                <div id="userInforImgID">
                    <c:if test="${idUser == null}">
                        <img src="static/data/user/hoa_hong.jpg" class="card-img-top" alt="...">
                    </c:if>
                    <c:if test="${idUser != null}">
                        <img src="static/data/user/${userLog.image}" class="card-img-top" alt="...">
                    </c:if>
                </div>
                <div class="row" id="userInforTextID">
                  <div class="col-xl-6" id="userInforTextID-text">
                    <div class="card-body">
                      <h5 class="card-title">User Infor</h5>
                      <p class="card-text"><span>Id: </span>${userLog.getId()}</p>
                      <p class="card-text"><span>Name: </span>${userLog.name}</p>
                      <p class="card-text"><span>Money: </span>${userLog.money}</p>
                      <p class="card-text"><span>Role: </span>${userLog.role}</p>
                    </div>
                  </div>
                  <div class="col-xl-6 " id="userInforTextID-Card">
                    <div class="card-body">
                        <c:if test="${idUser != null}">
                            <a href="/booking-servlet?action=create&userLogID=${idUser}"class="btn btn-primary ${isDisabled}">Create card</a>
                        </c:if>
                    </div>
                    <div class="card-body">
                        <c:if test="${idUser != null}">
                            <a href="/booking-servlet?action=delete&bookingID=${newBookingID}" class="btn btn-primary">Delete card</a>
                        </c:if>
                    </div>
                    <div class="card-body">
                        <c:if test="${idUser != null}">
                            <a href="/booking-servlet" class="btn btn-primary">View my card</a>
                        </c:if>
                    </div>
                  </div>
                </div>
                <div class="row">
                  <div style="margin: 10px">
                    <div>
                      <p><span style="font-weight: bolder">ID Booking: ${newBookingID}</span> </p>
                    </div>
                    <table class="table">
                      <thead>
                      <tr>
                        <th scope="col"> Name</th>
                        <th scope="col">Price</th>
                        <th scope="col">Quantity</th>
                        <th scope="col">Total</th>
                        <th scope="col"></th>
                      </tr>
                      </thead>
                        <c:if test="${idUser != null && newBookingID !=null}">
                            <tbody>
                                <c:forEach items="${keySet}" var="key">
                                    <tr>
                                        <td>${dogMap.get(key).name}</td>
                                        <td>${dogMap.get(key).price}</td>
                                        <td>${dogMap.get(key).quantity}</td>
                                        <td>${dogMap.get(key).price * dogMap.get(key).quantity}</td>
                                        <td>
                                            <a class="btn btn-danger" href="/booked-servlet?action=delete&deleteBookedID=${key}&bookingID=${newBookingID}" role="button">Delete</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </c:if>
                    </table>
                  </div>
                </div>
                <div class="row">
                  <div class="card-body">
                      <c:if test="${idUser != null}">
                          <a class="btn btn-primary" href="#" role="button" style="float:right;">Payment</a>
                      </c:if>
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