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
                <li class="list-group-item d-flex justify-content-between align-items-center">
                    <b>Kupione przedmioty</b>
                </li>
                <li class="list-group-item d-flex justify-content-between align-items-center">
                    Użytkownik ${USER.login}
                </li>
                <li class="list-group-item d-flex justify-content-between align-items-center">
                    Użytkownik ${USER.avgRating}/5 (ilość ocen ${USER.numberOfRatings})
                </li>
            </ul>
        </div>
        <!-- /Categories -->

        <div class="col-md-9">
            <!-- Products -->
            <c:forEach var="tempAuction" items="${AUCTIONS}">
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
                                    <c:choose>
                                        <c:when test="${tempAuction.opinion eq 0}">
                                            <!-- Rate form -->
                                            <form method="post" action="rate">
                                                <input id="productId" name="productId" type="hidden" value="${tempAuction.auctionID}">
                                                <div class="form-check form-check-inline">
                                                    <input class="form-check-input" type="radio" name="rateRadio"
                                                           id="inlineRadio1" value="1">
                                                    <label class="form-check-label" for="inlineRadio1">1</label>
                                                </div>
                                                <div class="form-check form-check-inline">
                                                    <input class="form-check-input" type="radio" name="rateRadio"
                                                           id="inlineRadio2" value="2">
                                                    <label class="form-check-label" for="inlineRadio2">2</label>
                                                </div>
                                                <div class="form-check form-check-inline">
                                                    <input class="form-check-input" type="radio" name="rateRadio"
                                                           id="inlineRadio3" value="3">
                                                    <label class="form-check-label" for="inlineRadio1">3</label>
                                                </div>
                                                <div class="form-check form-check-inline">
                                                    <input class="form-check-input" type="radio" name="rateRadio"
                                                           id="inlineRadio4" value="4">
                                                    <label class="form-check-label" for="inlineRadio1">4</label>
                                                </div>
                                                <div class="form-check form-check-inline">
                                                    <input class="form-check-input" type="radio" name="rateRadio"
                                                           id="inlineRadio5" value="5">
                                                    <label class="form-check-label" for="inlineRadio1">5</label>
                                                </div>
                                                <button type="submit" class="btn btn-primary">Oceń sprzedawcę</button>
                                            </form>
                                            <!-- /Rate form -->
                                        </c:when>
                                        <c:otherwise>
                                            <p>Oceniono na ${tempAuction.opinion}</p>
                                        </c:otherwise>
                                    </c:choose>
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