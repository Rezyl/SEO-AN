<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>Ověření expirace domény</h1>

<form class="pure-form" action="/expirace_zpracuj" method="get">
    <fieldset>
        <legend>A compact inline form</legend>

        <input type="text" name="url" placeholder="url" value="http://www.auto.cz/" />
        <button type="submit" class="pure-button pure-button-primary">Odeslat</button>
    </fieldset>
</form>