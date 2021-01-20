<%@ page import="com.model.Auction" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    pageContext.setAttribute("categoryList", Auction.getCategoryList());
%>
<div class="modal fade" id="addAuctionModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form class="modal-content needs-validation" id="newAuction" method="post" action="addauction" novalidate>
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Wystaw przedmiot</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <label for="auctionTitle">Nazwa przedmiotu</label>
                    <input type="text" class="form-control" id="auctionTitle" name="auctionTitle"
                           placeholder="Na przykład chleb" required>
                </div>
                <div class="form-group">
                    <label for="auctionDescription">Opis przedmiotu</label>
                    <textarea class="form-control rounded-0" id="auctionDescription" name="auctionDescription" rows="7"
                              placeholder="Na przykład smaczny" required></textarea>
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
                    <input type="number" step="0.01" class="form-control" id="auctionPrice" name="auctionPrice"
                           placeholder="Cena" required>
                </div>
                <div class="form-group">
                    <label for="auctionStartDate">Data zakończenia</label>
                    <input class="form-control" type="date" id="auctionStartDate" name="auctionStartDate" required>
                </div>
                <div class="form-group">
                    <label for="auctionNumberOfPhotos" class="form-label">Wybierz ilość zdjęć które chcesz dodać</label>
                    <select class="form-select" id="auctionNumberOfPhotos" name="auctionNumberOfPhotos" required>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                    </select>
                    <div class="invalid-feedback">
                        Wybierz odpowiednią liczbę zdjęć!
                    </div>
                </div>
                <div class="form-group" id="photo1">
                    <input type="file" class="form-control" id="auctionPhoto1" name="auctionPhoto1" aria-label="file example" required>
                    <div class="invalid-feedback">Example invalid form file feedback</div>
                </div>
                <div class="form-group" id="photo2">
                    <input type="file" class="form-control" id="auctionPhoto2" name="auctionPhoto2" aria-label="file example" required>
                    <div class="invalid-feedback">Example invalid form file feedback</div>
                </div>
                <div class="form-group" id="photo3">
                    <input type="file" class="form-control" id="auctionPhoto3" name="auctionPhoto3" aria-label="file example" required>
                    <div class="invalid-feedback">Example invalid form file feedback</div>
                </div>
                <script>
                    $(document).ready(function() {
                        $("#photo2").css("display", "none");
                        $('#auctionPhoto2').prop('required',false);
                        $("#photo3").css("display", "none");
                        $('#auctionPhoto3').prop('required',false);
                        $('#auctionNumberOfPhotos').on('change', function () {
                           //console.log(this.value);
                            if(this.value == "1"){
                                $("#photo2").css("display", "none");
                                $('#auctionPhoto2').prop('required',false);
                                $("#photo3").css("display", "none");
                                $('#auctionPhoto3').prop('required',false);
                            }else if(this.value == "2"){
                                $("#photo2").css("display", "block");
                                $('#auctionPhoto2').prop('required',true);
                                $("#photo3").css("display", "none");
                                $('#auctionPhoto3').prop('required',false);
                            }else{
                                $("#photo2").css("display", "block");
                                $('#auctionPhoto2').prop('required',true);
                                $("#photo3").css("display", "block");
                                $('#auctionPhoto3').prop('required',true);
                            }
                        });
                    });
                </script>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Anuluj</button>
                <button type="submit" class="btn btn-primary">Dodaj aukcję</button>
            </div>
        </form>
    </div>
</div>