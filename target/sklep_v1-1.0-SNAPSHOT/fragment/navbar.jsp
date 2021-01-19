<%@ page import="com.AdditionalComponents.Cookies" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
    request.setAttribute("request", request);
    request.setAttribute("response", response);
%>
<nav class="navbar navbar-expand-lg navbar-dark bg-custom-1">
    <div class="container-fluid p-3">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/index">LitewkaBuy</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
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
                <c:choose>
                    <c:when test="${Cookies.isLoggedIn(request,response)}">
                        <li class="nav-item dropdown pe-5">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                               data-bs-toggle="dropdown" aria-expanded="false">
                                Konto
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="#">Ustawienia</a></li>
                                <li><a class="dropdown-item" href="#" data-bs-toggle="modal" data-bs-target="#addAuctionModal"
                                       role="button" aria-expanded="false">Nowa aukcja</a></li>
                                <li><a class="dropdown-item" href="#">Sprzedane</a></li>
                                <li><a class="dropdown-item" href="#">Kupione</a></li>
                                <li>
                                    <hr class="dropdown-divider">
                                </li>
                                <li><a class="dropdown-item" href="logout">Wyloguj</a></li>
                            </ul>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="nav-item pe-5">
                            <a class="nav-link" href="#" data-bs-toggle="modal" data-bs-target="#loginModal"
                               role="button" aria-expanded="false">
                                Zaloguj
                            </a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </div>
</nav>
<jsp:include page="modallogin.jsp" />
<jsp:include page="modalnewauction.jsp" />
<jsp:include page="modalregister.jsp" />