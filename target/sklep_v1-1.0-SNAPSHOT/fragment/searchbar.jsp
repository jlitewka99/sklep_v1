<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="container-fluid pb-3">
    <div class="row d-flex justify-content-center p-2 bg-custom-2">
        <div class="col-md-8">
            <form action="search" method="GET" class="input-group md-form form-sm form-2 pl-0">
                <c:choose>
                    <c:when test="${searchtext != null}">
                        <input class="form-control my-0 py-1 amber-border"
                               style="background-color: #2e2d2d; color: white" name="searchtext" type="text"
                               value="${searchtext}" aria-label="Search">
                    </c:when>
                    <c:otherwise>
                        <input class="form-control my-0 py-1 amber-border"
                               style="background-color: #2e2d2d; color: white" name="searchtext" type="text"
                               placeholder="Wyszukiwarka" aria-label="Search">
                    </c:otherwise>
                </c:choose>

                <div class="input-group-append">
                    <input type="submit" class="input-group-text" value="Wyszukaj"
                           style="background-color: #2e2d2d; color: white; border: black;" id="basic-text1">
                </div>
            </form>
        </div>
    </div>
</div>