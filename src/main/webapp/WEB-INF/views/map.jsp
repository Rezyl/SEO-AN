<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>Mapa webu</h1>

<hr />

<form class="pure-form pure-form-aligned" action="/mapa_zpracuj" method="get">

    <div class="pure-control-group">
        <label for="url">URL</label>
        <input type="text" name="url" placeholder="http://" value="${url}" class="input460" required="required" />
    </div>
    <div class="pure-control-group">
        <label for="key">Počet úrovní</label>
        <input type="text" name="level" value="1" required="required" />
    </div>
    <div class="pure-control-group">
        <label for="saveToDB">Uložit do profilu</label>
        <input type="checkbox" name="saveToDB" checked />
    </div>
    <div class="pure-controls">
        <button type="submit" class="pure-button pure-button-primary">Odeslat</button>
    </div>
</form>
