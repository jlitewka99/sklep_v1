<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.Sklep.jsp.Auction" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

    <%@ include file="fragment/head.jspf" %>

    <!-- Page title -->
    <title>LitewkaBuy</title>
</head>
<body>
<!-- NavBar -->
<jsp:include page="fragment/navbar.jsp" />
<!-- /NavBar -->

<!-- Searchbar -->
<jsp:include page="fragment/searchbar.jsp" />
<!-- /Searchbar -->


<div class="container-fluid">
    <div class="row">
        <!-- Categories -->
        <div class="col-md-2">
            <ul class="list-group">
                <li class="list-group-item d-flex justify-content-between align-items-center">
                    Cras justo odio
                    <span class="badge bg-primary rounded-pill">14</span>
                </li>
                <li class="list-group-item d-flex justify-content-between align-items-center">
                    Dapibus ac facilisis in
                    <span class="badge bg-primary rounded-pill">2</span>
                </li>
                <li class="list-group-item d-flex justify-content-between align-items-center">
                    Morbi leo risus
                    <span class="badge bg-primary rounded-pill">1</span>
                </li>
            </ul>
        </div>
        <!-- /Categories -->

        <div class="col-md-10">
            <!-- Products -->
            <c:forEach var="tempAuction" items="${AUCTIONS}">
            <div class="row">
                <div class="card mb-3">
                    <div class="row g-0">
                        <div class="col-md-2">
                            <img src="https://via.placeholder.com/150x9000?text=1" style="width: 100%; max-height: 200px; object-fit: cover;" alt="...">
                        </div>
                        <div class="col-md-8">
                            <div class="card-body">
                                <h5 class="card-title">${tempAuction.title}</h5>
                                <p class="card-text">
                                    ${tempAuction.description}
                                </p>
                                <p class="card-text"><small class="text-muted">Cena ${tempAuction.price}zł</small></p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            </c:forEach>
            <!-- /Products -->
        </div>
    </div>
</div>

<nav aria-label="...">
    <ul class="pagination justify-content-center">
        <li class="page-item">
            <a class="page-link" href="#" tabindex="-1" aria-disabled="true">Previous</a>
        </li>
        <li class="page-item"><a class="page-link" href="#">1</a></li>
        <li class="page-item active" aria-current="page">
            <a class="page-link" href="#">2</a>
        </li>
        <li class="page-item"><a class="page-link" href="#">3</a></li>
        <li class="page-item">
            <a class="page-link" href="#">Next</a>
        </li>
    </ul>
</nav>

<!-- Footer -->
<jsp:include page="fragment/footer.jspf" />
<!-- /Footer -->

<!-- JS -->
<!-- jQuery-->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>

</body>
</html>