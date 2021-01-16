<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<%@ page import="com.databaseRelated.*" %>
<%@ page import="com.Sklep.jsp.Auction" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="fragment/head.jspf" %>
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

<%
    Auction auction = (Auction)request.getAttribute("AUCTION");
%>

<div class="row justify-content-md-center" style="margin: 0px; padding: 0px;">
    <!-- Pictures -->
    <div class="col-md-5">
        <!-- Top slideshow -->
        <div class="slider-for">
            <div>
                <img src="https://via.placeholder.com/1500x700?text=1">
            </div>
            <div>
                <img src="https://via.placeholder.com/1500x700?text=2">
            </div>
            <div>
                <img src="https://via.placeholder.com/1500x700?text=3">
            </div>
            <div>
                <img src="https://via.placeholder.com/1500x700?text=4">
            </div>
            <div>
                <img src="https://via.placeholder.com/1500x700?text=5">
            </div>
        </div>
        <!-- /Top slideshow -->
        <!-- Bottom slideshow -->
        <div class="slider-nav-item">
            <div>
                <img src="https://via.placeholder.com/1500x700?text=1">
            </div>
            <div>
                <img src="https://via.placeholder.com/1500x700?text=2">
            </div>
            <div>
                <img src="https://via.placeholder.com/1500x700?text=3">
            </div>
            <div>
                <img src="https://via.placeholder.com/1500x700?text=4">
            </div>
            <div>
                <img src="https://via.placeholder.com/1500x700?text=5">
            </div>
        </div>
        <!-- /Bottom slideshow-->
    </div>
    <!-- /Pictures -->
    <div class="col-md-5">
        <h1><%=auction.getTitle()%></h1>
        <p><%=auction.getDescription()%> <%=auction.getUser().getLogin()%></p>
    </div>
</div>


<jsp:include page="fragment/footer.jspf"/>


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