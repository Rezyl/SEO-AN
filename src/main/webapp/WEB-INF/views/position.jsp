<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form class="pure-form" action="getNumberOfPosition" method="get">
    <fieldset>
        <legend>A compact inline form</legend>

        <input type="text" name="url" placeholder="">
        <input type="text" name="numberOfPage" value="1">
        <input type="hidden" name="key" value=""/>

        <button type="submit" class="pure-button pure-button-primary">Odeslat</button>
    </fieldset>
</form>