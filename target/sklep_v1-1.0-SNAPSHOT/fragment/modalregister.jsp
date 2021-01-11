<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="modal fade" id="registerModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form class="modal-content needs-validation" novalidate>
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Rejestracja</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <label for="emailRegister">Adres email</label>
                    <input type="email" class="form-control" id="emailRegister" aria-describedby="emailHelp" placeholder="email@domena.pl" required>
                </div>
                <div class="form-group">
                    <label for="loginRegister">Login</label>
                    <input type="text" class="form-control" id="loginRegister" placeholder="Login" required>
                </div>
                <div class="form-group">
                    <label for="passwordRegister">Hasło</label>
                    <input type="password" class="form-control" id="passwordRegister" placeholder="Hasło" required>
                </div>
                <div class="form-group">
                    <label for="password2Register">Powtórz hasło</label>
                    <input type="password" class="form-control" id="password2Register" placeholder="Powtórz hasło" required>
                </div>
                <div class="form-group">
                    <label for="cityRegister">Miejscowość</label>
                    <input type="text" class="form-control" id="cityRegister" placeholder="Miejscowość" required>
                </div>
                <div class="form-group">
                    <label for="postalcodeRegister">Kod pocztowy</label>
                    <input type="text" class="form-control" id="postalcodeRegister" placeholder="00-000" required>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Anuluj</button>
                <button type="submit" class="btn btn-primary">Zarejestruj</button>
            </div>
        </form>
    </div>
</div>