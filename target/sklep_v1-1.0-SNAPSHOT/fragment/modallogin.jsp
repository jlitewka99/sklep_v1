<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="modal fade" id="loginModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form class="modal-content needs-validation" method="post" action="login" novalidate>
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Logowanie</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <label for="loginLogin">Login</label>
                    <input type="text" class="form-control" id="loginLogin" placeholder="Login" required>
                </div>
                <div class="form-group">
                    <label for="passwordLogin">Hasło</label>
                    <input type="password" class="form-control" id="passwordLogin" placeholder="Hasło" required>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-success" data-bs-dismiss="modal" data-bs-toggle="modal" data-bs-target="#registerModal">Rejestracja</button>
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Anuluj</button>
                <button type="submit" class="btn btn-primary">Zaloguj</button>
            </div>
        </form>
    </div>
</div>