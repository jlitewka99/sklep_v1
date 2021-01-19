<%@ page import="com.Sklep.jsp.Auction" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    pageContext.setAttribute("categoryList", Auction.getCategoryList());
%>
<div class="modal fade" id="addAuctionModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form class="modal-content needs-validation" method="post" action="addAuction" novalidate>
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Wystaw przedmiot</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <label for="auctionTitle">Nazwa przedmiotu</label>
                    <input type="text" class="form-control" id="auctionTitle" name="auctionTitle" placeholder="Na przykład chleb" required>
                </div>
                <div class="form-group">
                    <label for="auctionDescription">Opis przedmiotu</label>
                    <textarea class="form-control rounded-0" id="auctionDescription" name="auctionDescription" rows="7" placeholder="Na przykład smaczny" required></textarea>
                </div>
                <div class="form-group">
                    <label for="auctionCategory" class="form-label">Kategoria</label>
                    <select class="form-select" id="auctionCategory" name="auctionCategory" required>
                        <c:forEach var="tempCategory" items="${categoryList}">
                        <option value="${tempCategory}">${tempCategory}</option>
                        </c:forEach>
                    </select>
                    <div class="invalid-feedback">
                        Wybierz odpowiednią kategorię.
                    </div>
                </div>
                <div class="form-group">
                    <label for="auctionPrice">Cena</label>
                    <input type="number" step="0.01" class="form-control" id="auctionPrice" name="auctionPrice" placeholder="Cena" required>
                </div>
                <div class="form-group">
                    <label for="auctionStartDate">Data zakończenia</label>
                    <input class="form-control" type="date" value="2011-08-19T13:45:00" id="auctionStartDate" name="auctionStartDate" required>
                </div>
                <div class="form-group">
                    <label for="streetRegister">Ulica i numer domu</label>
                    <input type="text" class="form-control" id="streetRegister" name="streetRegister" placeholder="Ulica 13b/3" required>
                </div>
                <div class="form-group">
                    <label for="postCodeRegister">Kod pocztowy</label>
                    <input type="text" class="form-control" id="postCodeRegister" name="postCodeRegister" placeholder="00-000" required>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Anuluj</button>
                <button type="submit" class="btn btn-primary">Zarejestruj</button>
            </div>
        </form>
    </div>
</div>