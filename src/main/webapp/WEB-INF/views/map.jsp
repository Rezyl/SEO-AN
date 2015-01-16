<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>Zjištění pozice</h1>

<form class="pure-form" action="/mapa_zpracuj" method="get">
    <fieldset>
        <input type="text" name="url" placeholder="url" value="${url}" />
        <label>Počet úrovní <input type="text" name="level" value="1" /></label>
        <button type="submit" class="pure-button pure-button-primary">Odeslat</button>
    </fieldset>
</form>