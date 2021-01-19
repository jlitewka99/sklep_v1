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
    } else if (status == "register_error1") { // register returns error code depending on error in registerValidator
        alert('Nie udało się zarejestrować', 'Sprawdź poprawność emaila.', 'alert-warning');
    } else if (status == "register_error2") { // register returns error code depending on error in registerValidator
        alert('Nie udało się zarejestrować', 'Sprawdź poprawność loginu.', 'alert-warning');
    } else if (status == "register_error3") { // register returns error code depending on error in registerValidator
        alert('Nie udało się zarejestrować', 'Podane hasła nie są identyczne', 'alert-warning');
    } else if (status == "register_error4") { // register returns error code depending on error in registerValidator
        alert('Nie udało się zarejestrować', 'Za krótkie hasło', 'alert-warning');
    } else if (status == "register_error5") { // register returns error code depending on error in registerValidator
        alert('Nie udało się zarejestrować', 'za słabe hasło', 'alert-warning');
    } else if (status == "register_error6") { // register returns error code depending on error in registerValidator
        alert('Nie udało się zarejestrować', 'niepoprawny kod pocztowy', 'alert-warning');
    } else if (status == "register_error7") { // register returns error code depending on error in registerValidator
        alert('Nie udało się zarejestrować', 'nie wpisano prawidłowego addresu', 'alert-warning');
    } else if (status == "register_error0") { // register returns error code depending on error in registerValidator
        alert('Nie udało się zarejestrować', 'zajęty login', 'alert-warning');
    } else if (status == "auction_error1") { // register returns error code depending on error in registerValidator
        alert('Nie udało się wystawić produktu', 'niepoprawna długość tytułu.', 'alert-warning');
    } else if (status == "auction_error2") { // register returns error code depending on error in registerValidator
        alert('Nie udało się wystawić produktu', 'niepoprawna długość opisu.', 'alert-warning');
    } else if (status == "auction_error3") { // register returns error code depending on error in registerValidator
        alert('Nie udało się wystawić produktu', 'Nie odnaleziono zdjęcia produktu.', 'alert-warning');
    } else if (status == "auction_error4") { // register returns error code depending on error in registerValidator
        alert('Nie udało się wystawić produktu', 'Nie ma takiej kategori', 'alert-warning');
    }else if (status == "auction_error5") { // register returns error code depending on error in registerValidator
        alert('Nie udało się wystawić produktu', 'Nie poprawna data zakończenia aukcji.', 'alert-warning');
    } else if (status == "auction_error6") { // register returns error code depending on error in registerValidator
        alert('Nie udało się wystawić produktu', 'Niepoprawna cena produktu.', 'alert-warning');
    }
</script>
