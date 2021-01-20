<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<script>
    function alert(title, text, type) {
        let html = $("<div class='alert alert-dismissible hide text-center fade in "
            + type
            + "'><strong>" + title + "</strong> <p>"
            + text
            + "</p><button type='button' class='btn-close' data-bs-dismiss='alert' aria-label='Close'></button></div>");
        $('body').append(html);
        setTimeout(function () {
            html.addClass('show');
        }, 0);
    }

    var status = new URLSearchParams(window.location.search).get("status");
    if (status == "loggedin") {
        alert('Zalogowano!', 'Możesz korzystać z pełnej funkcjonalności serwisu.', 'alert-success');
    } else if (status == "loggedout") {
        alert('Wylogowano!', 'Możesz się zalogować ponownie.', 'alert-success');
    } else if (status == "register_error1") {
        alert('Nie udało się zarejestrować', 'Sprawdź poprawność emaila.', 'alert-warning');
    } else if (status == "register_error2") {
        alert('Nie udało się zarejestrować', 'Sprawdź poprawność loginu.', 'alert-warning');
    } else if (status == "register_error3") {
        alert('Nie udało się zarejestrować', 'Podane hasła nie są identyczne', 'alert-warning');
    } else if (status == "register_error4") {
        alert('Nie udało się zarejestrować', 'Za krótkie hasło', 'alert-warning');
    } else if (status == "register_error5") {
        alert('Nie udało się zarejestrować', 'za słabe hasło', 'alert-warning');
    } else if (status == "register_error6") {
        alert('Nie udało się zarejestrować', 'niepoprawny kod pocztowy', 'alert-warning');
    } else if (status == "register_error7") {
        alert('Nie udało się zarejestrować', 'nie wpisano prawidłowego addresu', 'alert-warning');
    } else if (status == "register_error8") {
        alert('Nie udało się zarejestrować', 'Źle podana Miejscowość', 'alert-warning');
    } else if (status == "register_error9") {
        alert('Nie udało się zarejestrować', 'Niestety wprowadziłeś znak którego nie można', 'alert-warning');
    } else if (status == "register_error0") {
        alert('Nie udało się zarejestrować', 'Zajęty login', 'alert-warning');
    } else if (status == "register_error100") {
        alert('Nie udało się zarejestrować', 'Nie ładnie tak kombinować cwaniaczku', 'alert-warning');
    } else if (status == "register_success") {
        alert('Dokonano pomyślnej rejestracji', 'Mojszesz się zalogować', 'alert-warning');
    } else if (status == "auction_error1") {
        alert('Nie udało się wystawić produktu', 'Niepoprawna długość tytułu.', 'alert-warning');
    } else if (status == "auction_error2") {
        alert('Nie udało się wystawić produktu', 'Niepoprawna długość opisu.', 'alert-warning');
    } else if (status == "auction_error3") {
        alert('Nie udało się wystawić produktu', 'Nie odnaleziono zdjęcia produktu.', 'alert-warning');
    } else if (status == "auction_error4") {
        alert('Nie udało się wystawić produktu', 'Nie ma takiej kategori', 'alert-warning');
    } else if (status == "auction_error5") {
        alert('Nie udało się wystawić produktu', 'Niepoprawna data zakończenia aukcji.', 'alert-warning');
    } else if (status == "auction_error6") {
        alert('Nie udało się wystawić produktu', 'Niepoprawna cena produktu.', 'alert-warning');
    } else if (status == "auction_error6") {
        alert('Nie udało się wystawić produktu', 'Niepoprawna cena produktu.', 'alert-warning');
    } else if (status == "login_error0") {
        alert('Nie udało się zalogować', 'Coś podałeś nieprawidłowo.', 'alert-warning');
    } else if (status == "login_error1") {
        alert('Nie udało się zalogować', 'Coś podałeś nieprawidłowo.', 'alert-warning');
    } else if (status == "login_error2") {
        alert('Nie udało się zalogować', 'Coś podałeś nieprawidłowo.', 'alert-warning');
    } else if (status == "login_error3") {
        alert('Nie udało się zalogować', 'Coś podałeś nieprawidłowo.', 'alert-warning');
    } else if (status == "login_error100") {
        alert('Nie udało się zalogować', 'nie ładnie tak kombinować cwaniaczku.', 'alert-warning');
    }
    // register returns error code depending on error in registerValidator
</script>
