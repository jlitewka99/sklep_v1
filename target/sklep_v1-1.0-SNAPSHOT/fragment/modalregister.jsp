<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="modal fade" id="registerModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form class="modal-content needs-validation" method="post" action="register" novalidate>
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Rejestracja</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <label for="emailRegister">Adres email</label>
                    <input type="email" class="form-control" id="emailRegister" name="emailRegister" aria-describedby="emailHelp" placeholder="email@domena.pl" required>
                </div>
                <div class="form-group">
                    <label for="loginRegister">Login</label>
                    <input type="text" class="form-control" id="loginRegister" name="loginRegister" placeholder="Login" required>
                </div>
                <div class="form-group">
                    <label for="passwordRegister">Hasło</label>
                    <input type="password" class="form-control" id="passwordRegister" name="passwordRegister" placeholder="Hasło" required>
                </div>
                <div class="form-group">
                    <label for="password2Register">Powtórz hasło</label>
                    <input type="password" class="form-control" id="password2Register" name="password2Register" placeholder="Powtórz hasło" required>
                </div>
                <div class="form-group">
                    <label for="cityRegister">Miejscowość</label>
                    <input type="text" class="form-control" id="cityRegister" name="cityRegister" placeholder="Miejscowość" required>
                </div>
                <div class="form-group">
                    <label for="streetRegister">Ulica i numer domu</label>
                    <input type="text" class="form-control" id="streetRegister" name="streetRegister" placeholder="Miejscowość 13b/3" required>
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