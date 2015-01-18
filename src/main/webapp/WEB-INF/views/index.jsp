<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>Zjištění stavu indexu</h1>

<hr />

<form class="pure-form pure-form-aligned" action="/index_zpracuj" method="get">

    <div class="pure-control-group">
        <label for="domain">Název domény</label>
        <input type="text" name="domain" placeholder="doména.cz" value="${url}" class="input460" required="required" />
    </div>
    <div class="pure-controls">
        <button type="submit" class="pure-button pure-button-primary">Odeslat</button>
    </div>
</form>