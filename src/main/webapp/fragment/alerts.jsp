<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<script>
    function alert(title, text, type) {
        let html = $("<div class='alert alert-dismissible hide fade in " + type + "'><strong>" + title + "</strong> " + text
            + "<button type='button' class='btn-close' data-bs-dismiss='alert' aria-label='Close'></button></div>");
        $('body').append(html);
        setTimeout(function () {
            html.addClass('show');
        }, 0);
    }
    var status = new URLSearchParams(window.location.search).get("status");
    if (status == "loggedin") {
        alert('Zalogowano', 'Zalogowano możesz korzystać z pełnej funkcjonalności serwisu.', 'alert-success');
    } else if (status == "loggedout") {
        alert('Wylogowano', 'Możesz się zalogować ponownie.', 'alert-success');
    } else if (status == "error1") {
        alert('Nie udało się zalogować', 'Sprawdź poprawność emaila i hasła.', 'alert-success');
    }
</script>
