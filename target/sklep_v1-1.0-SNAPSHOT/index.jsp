<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>

    <%@ include file="fragment/head.jspf" %>

    <!-- Page title -->
    <title>LitewkaBuy</title>
</head>
<body>
    <!-- NavBar -->
    <jsp:include page="fragment/navbar.jspf" />
    <!-- /NavBar -->

    <!-- Searchbar -->
    <jsp:include page="fragment/searchbar.jspf" />
    <!-- /Searchbar -->

    <div class="container-fluid">
        <div class="row flex-column-reverse flex-md-row">
            <!-- Categories -->
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
                        Lorem ipsum dolor sit amet, consectetur adipisicing elit. Consectetur inventore natus perspiciatis ut. Adipisci architecto asperiores assumenda consequuntur corporis distinctio eaque iusto molestias nisi vitae! Nihil pariatur quibusdam rem vero?
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-8">
                        Lorem ipsum dolor sit amet, consectetur adipisicing elit. Architecto atque commodi dicta, dolores eligendi enim laborum natus nostrum rem rerum, saepe ut voluptate voluptatem? Dicta enim minima molestiae veniam veritatis?
                    </div>
                    <div class="col-md-4">
                        Lorem ipsum dolor sit amet, consectetur adipisicing elit. Atque culpa dicta dolor, dolorem doloribus enim expedita fugit ipsa laborum laudantium non, nostrum quia, quisquam repudiandae sequi tempore vel. Excepturi, quaerat!
                    </div>

                </div>
            </div>
        </div>
    </div>

    <jsp:include page="fragment/footer.jspf" />


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