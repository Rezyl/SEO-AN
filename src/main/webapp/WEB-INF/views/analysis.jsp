<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>Celková analýza</h1>

<hr />

<form class="pure-form pure-form-aligned" action="/analyza_zpracuj" method="get">

    <fieldset>
        <legend>Zjištění pozice</legend>

        <div class="pure-control-group">
            <label for="url">URL</label>
            <input type="text" name="url" placeholder="http://" value="${url}" class="input460" required="required" />
        </div>
        <div class="pure-control-group">
            <label for="key">Klíčové slovo</label>
            <input type="text" name="key" placeholder="klíčové slovo" value="${keyword}" required="required" />
        </div>
        <div class="pure-control-group">
            <label for="numberOfPage">Omezení stránek</label>
            <input type="text" name="numberOfPage" value="1" class="input60" required="required" />
        </div>
        <div class="pure-control-group">
            <label for="serverCode">Vyhledávače</label>
            <select name="serverCode">
                <c:forEach items="${search_engines}" var="item">
                    <option value="${item.key}">${item.value}</option>
                </c:forEach>
                <option value="ALL" selected="selected">Vše</option>
            </select>
        </div>
    </fieldset>

    <fieldset>
        <legend>Mapa webu</legend>

        <div class="pure-control-group">
            <label for="key">Počet úrovní</label>
            <input type="text" name="level" value="1" required="required" />
        </div>
    </fieldset>

    <div class="pure-controls">
        <button type="submit" class="pure-button pure-button-primary">Odeslat</button>
    </div>
</form>