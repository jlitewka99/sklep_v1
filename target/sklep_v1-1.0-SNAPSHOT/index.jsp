<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- slick.js CSS -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/lib/slick/slick.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/lib/slick/slick-theme.css">
    <!-- Custom CSS -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/lib/css/style.css">
    <!-- Page title -->
    <title>LitewkaBuy</title>
</head>
<body>
    <!-- NavBar -->
    <jsp:include page="fragment/navbar.jspf" />

    <div class="container-fluid">
        <div class="row flex-column-reverse flex-md-row">
            <div class="col-md-3">
                <div class="list-group">
                    <a href="#" class="list-group-item list-group-item-action">Kategoria 1</a>
                    <a href="#" class="list-group-item list-group-item-action">Kategoria 2</a>
                    <a href="#" class="list-group-item list-group-item-action">Kategoria 3</a>
                    <a href="#" class="list-group-item list-group-item-action">Kategoria 4</a>
                    <a href="#" class="list-group-item list-group-item-action">Kategoria 5</a>
                    <a href="#" class="list-group-item list-group-item-action">Kategoria 1</a>
                    <a href="#" class="list-group-item list-group-item-action">Kategoria 2</a>
                    <a href="#" class="list-group-item list-group-item-action">Kategoria 3</a>
                    <a href="#" class="list-group-item list-group-item-action">Kategoria 4</a>
                    <a href="#" class="list-group-item list-group-item-action">Kategoria 5</a>
                    <a href="#" class="list-group-item list-group-item-action">Kategoria 1</a>
                    <a href="#" class="list-group-item list-group-item-action">Kategoria 2</a>
                    <a href="#" class="list-group-item list-group-item-action">Kategoria 3</a>
                    <a href="#" class="list-group-item list-group-item-action">Kategoria 4</a>
                    <a href="#" class="list-group-item list-group-item-action">Kategoria 5</a>
                </div>
            </div>
            <div class="col-md-9">
                <div class="row">
                    <div class="col-md-8">
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

                    </div>
                    <div class="col-md-4">
                        Tutaj sie cos da
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-8 bg-primary">
                        Tu coś będzie
                    </div>
                    <div class="col-md-4 bg-info">
                        Tutaj też
                    </div>

                </div>
            </div>
        </div>
    </div>




    <!-- JS -->
    <!-- jQuery-->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <!-- slick.js -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/lib/slick/slick.min.js"></script>
    <!-- Bootstrap -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
    <!-- slick.js slideshow settings -->
    <script type="text/javascript">
        $(document).ready(function(){
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


</body>
</html>