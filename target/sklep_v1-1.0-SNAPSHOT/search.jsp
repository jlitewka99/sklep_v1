<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>

    <%@ include file="fragment/head.jsp" %>

    <!-- Page title -->
    <title>LitewkaBuy</title>
</head>
<body>
<!-- NavBar -->
<jsp:include page="fragment/navbar.jsp"/>
<!-- /NavBar -->

<!-- Searchbar -->
<jsp:include page="fragment/searchbar.jsp"/>
<!-- /Searchbar -->


<div class="container-fluid" style="min-height: 70vh;">
    <div class="row">
        <!-- Categories -->
        <div class="col-md-3">
            <ul class="list-group">
                <c:forEach var="tempCategory" items="${CATEGORIES}">
                <c:choose>
                <c:when test="${searchtext != null}">
                <a style="text-transform: capitalize"
                   href="search?category=${tempCategory.category}&searchtext=${searchtext}">
                    </c:when>
                    <c:otherwise>
                    <a style="text-transform: capitalize" href="search?category=${tempCategory.category}">
                        </c:otherwise>
                        </c:choose>
                        <li class="list-group-item d-flex justify-content-between align-items-center">
                                ${fn:toLowerCase(tempCategory.category)}
                            <span class="badge bg-primary rounded-pill">${tempCategory.count}</span>
                        </li>
                    </a>
                    </c:forEach>
            </ul>
        </div>
        <!-- /Categories -->

        <div class="col-md-9">
            <!-- Products -->
            <c:forEach var="tempAuction" items="${AUCTIONS}">
                <a href="auction?id=${tempAuction.auctionID}">
                    <div class="row">
                        <div class="card mb-3">
                            <div class="row g-0">
                                <div class="col-md-2">
                                    <img src="https://via.placeholder.com/150x9000?text=1"
                                         style="width: 100%; max-height: 200px; object-fit: cover;" alt="img">
                                </div>
                                <div class="col-md-8">
                                    <div class="card-body">
                                        <h5 class="card-title">${tempAuction.title}</h5>
                                        <p class="card-text">
                                                ${tempAuction.description}
                                        </p>
                                        <p class="card-text"><small
                                                class="text-muted">Cena ${tempAuction.price}zł</small>
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </a>
            </c:forEach>
            <!-- /Products -->
        </div>
    </div>
</div>


<!-- Footer -->
<jsp:include page="fragment/footer.jsp"/>
<!-- /Footer -->

<!-- JS -->
<!-- jQuery-->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
        crossorigin="anonymous"></script>

</body>
</html>