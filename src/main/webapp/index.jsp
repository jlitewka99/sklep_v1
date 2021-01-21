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

<!-- Alerts -->
<jsp:include page="fragment/alerts.jsp"/>
<!-- /Alerts -->


<div class="container-fluid">
    <div class="row flex-column-reverse flex-md-row">
        <!-- Categories -->
        <div class="col-md-3">
            <ul class="list-group">
                <c:forEach var="tempCategory" items="${CATEGORIES}">
                    <a style="text-transform: capitalize" href="search?category=${tempCategory.category}">
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
            <div class="row">
                <div class="col-md-8">
                    <!-- Top slideshow -->
                    <section class="slider-for" data-sizes="50vw">
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
                    </section>
                    <!-- /Top slideshow -->
                    <!-- Bottom slideshow -->
                    <section class="slider-nav d-none d-sm-block" data-sizes="50vw">
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
                    </section>
                    <!-- /Bottom slideshow -->

                </div>
                <div class="col-md-4">
                    Kupuj, sprzedawaj, zarabiaj. Już teraz dzieki LitewkaBuy. Zobacz już teraz, wyszukaj i kup - to takie proste! Zerowe marże, niskie ceny, GWARANCJA JAKOŚCI!!!
                </div>
            </div>
            <div class="row">
                <div class="col-md-8">
                    Poznaj oferte naszych sponsorów. Kupuj produkty z reklam, aby wesprzeć rozwój naszej witryny! Kup dziś, a produkt otrzymasz wczoraj!* <br>
                    <small>*Przedstawiona oferta ma charakter informacyjny i nie stanowi oferty handlowej w rozumieniu Art.66 par.1 Kodeksu Cywilnego.</small>
                </div>
                <div class="col-md-4">
                    Lorem ipsum dolor sit amet, consectetur adipisicing elit. Atque culpa dicta dolor, dolorem doloribus
                    enim expedita fugit ipsa laborum laudantium non, nostrum quia, quisquam repudiandae sequi tempore
                    vel. Excepturi, quaerat!
                </div>

            </div>
        </div>
    </div>
</div>

<jsp:include page="fragment/footer.jsp"/>


<!-- JS -->
<!-- slick.js -->
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/slick/slick.min.js"></script>
<!-- Bootstrap -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
        crossorigin="anonymous"></script>
<!-- slick.js slideshow settings -->
<script type="text/javascript">
    $(document).ready(function () {
        $('.slider-for').slick({
            slidesToShow: 1,
            slidesToScroll: 1,
            arrows: false,
            autoplay: true,
            autoplaySpeed: 2000,
            //fade: true,
            asNavFor: '.slider-nav'
        });
        $('.slider-nav').slick({
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
<script>
    (function () {
        'use strict'

        // Fetch all the forms we want to apply custom Bootstrap validation styles to
        var forms = document.querySelectorAll('.needs-validation')

        // Loop over them and prevent submission
        Array.prototype.slice.call(forms)
            .forEach(function (form) {
                form.addEventListener('submit', function (event) {
                    if (!form.checkValidity()) {
                        event.preventDefault()
                        event.stopPropagation()
                    }

                    form.classList.add('was-validated')
                }, false)
            })
    })()
</script>


</body>
</html>