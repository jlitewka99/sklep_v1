<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    Cookie[] theCookies = request.getCookies(); // get cookies array

    String cookieId = "0";
    if (theCookies != null) // check if any cookie exist
    {
        for (Cookie tempCookie : theCookies)
        {
            if ("sessionCookie".equals(tempCookie.getName())) // if user id cookie exist
            {
                cookieId = tempCookie.getValue();
            }else
            {
                Cookie sessionCookie = new Cookie("sessionCookie", "1");

                sessionCookie.setMaxAge(60 * 60 * 24 * 365);
                response.addCookie(sessionCookie);
            }
        }
    }else
    {
        Cookie sessionCookie = new Cookie("sessionCookie", "1");

        sessionCookie.setMaxAge(60 * 60 * 24 * 365);
        response.addCookie(sessionCookie);
    }
%>
<nav class="navbar navbar-expand-lg navbar-dark bg-custom-1">
    <div class="container-fluid p-3">
        <a class="navbar-brand" href="#">LitewkaBuy</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Link</a>
                </li>
            </ul>
            <ul class="navbar-nav  mb-2 mb-lg-0">
                <li class="nav-item dropdown pe-5">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Konto
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="#">Ustawienia</a></li>
                        <li><a class="dropdown-item" href="#">Nowa aukcja</a></li>
                        <li><a class="dropdown-item" href="#">Sprzedane</a></li>
                        <li><a class="dropdown-item" href="#">Kupione</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="#">Wyloguj</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>