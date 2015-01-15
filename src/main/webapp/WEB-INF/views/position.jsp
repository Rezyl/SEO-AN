<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>Zjištění pozice</h1>

<form class="pure-form" action="/pozice_zpracuj" method="get">
    <fieldset>
        <legend>A compact inline form</legend>

        <input type="text" name="url" placeholder="url" value="${url}" />
        <input type="text" name="key" placeholder="klíčové slovo" value="${keyword}" />
        <input type="text" name="numberOfPage" value="1" />
        <select name="serverCode">
            <c:forEach items="${search_engines}" var="item">
                <option value="${item.key}">${item.value}</option>
            </c:forEach>
            <option value="ALL">Všechny</option>
        </select>

        <button type="submit" class="pure-button pure-button-primary">Odeslat</button>
    </fieldset>
</form>