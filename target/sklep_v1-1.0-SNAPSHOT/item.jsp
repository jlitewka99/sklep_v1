<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<%@ page import="com.DAO.*" %>
<%@ page import="com.model.Auction" %>

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

<div class="row justify-content-md-center" style="margin: 0px; padding: 0px; min-height: 50vh;">
    <!-- Pictures -->
    <div class="col-md-5">
        <!-- Top slideshow -->
        <div class="slider-for">
            <c:forEach var="i" begin="1" end="${AUCTION.numberOfPhotos}">
                <div>
                    <img src="https://via.placeholder.com/1500x700?text=${i}">
                </div>
            </c:forEach>
        </div>
        <!-- /Top slideshow -->
        <!-- Bottom slideshow -->
        <div class="slider-nav-item">
            <c:forEach var="i" begin="1" end="${AUCTION.numberOfPhotos}">
                <div>
                    <img src="https://via.placeholder.com/1500x700?text=${i}">
                </div>
            </c:forEach>
        </div>
        <!-- /Bottom slideshow-->
    </div>
    <!-- /Pictures -->
    <div class="col-md-5">
        <p>Sprzedawca: ${AUCTION.user.login} ⭐: ${AUCTION.user.avgRating}/5 (ilość opinii ${AUCTION.user.numberOfRatings})</p>
        <hr>
        <p>od ${AUCTION.startDate} do ${AUCTION.endDate}</p>
        <h1>${AUCTION.title}</h1>
        <p>Cena: ${AUCTION.price}zł</p>
        <a href="buy?id=${AUCTION.auctionID}">
            <button type="button" class="btn btn-success">Kup produkt</button>
        </a>
        <p>${AUCTION.description}</p>
    </div>
</div>


<jsp:include page="fragment/footer.jsp"/>


<!-- JS -->
<!-- jQuery-->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- slick.js -->
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/slick/slick.min.js"></script>
<!-- Bootstrap -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
        crossorigin="anonymous"></script>
<!-- slick.js -->
<script type="text/javascript">
    $(document).ready(function () {
        $('.slider-for').slick({
            slidesToShow: 1,
            slidesToScroll: 1,
            arrows: false,
            autoplay: true,
            autoplaySpeed: 2000,
            // fade: true,
            asNavFor: '.slider-nav-item'
        });
        $('.slider-nav-item').slick({
            slidesToShow: 3,
            slidesToScroll: 1,
            asNavFor: '.slider-for',
            //dots: true,
            arrows: false,
            centerMode: true,
            focusOnSelect: true
        });
    });
</script>
</body>
</html>