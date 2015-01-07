<%@include file="/WEB-INF/views/taglibImports.jsp" %>

<h1>Detail profilu ${profile.displayName}</h1>

<p>Hledáno na adrese <c:out value="${profile.url}"/></p>

<hr />

<div class="pure-menu pure-menu-open pure-menu-horizontal">
    <ul>
        <li class="pure-menu-selected"><a href="#">Klíčová slova</a></li>
        <li><a href="#">Stránky</a></li>
        <li><a href="#">Expirace</a></li>
    </ul>
</div>

<hr />

<table class="pure-table">
    <thead>
    <tr>
        <th>Klíčové slovo</th>
        <th>Datum hledání</th>
        <th>Detail</th>
    </tr>
    </thead>
    <tbody>
        <c:forEach items="${mapResults.keySet()}" var="key">
            <tr><td>${key}</td><td>vypsat datum</td><td><a href="?profileID=${profile.displayName}&amp;subject=${key}" class="pure-button button-secondary button-small">Detail</a></td></tr>
        </c:forEach>
    </tbody>
</table>

<hr />

<h1>Detail klíčového slova</h1>

<p>
    Z tohodle bude lepší udělat další podstránku, která se zobrazí při kliknutí na tlačítko detail v předchozí tabulce.
    Nahradil jsem select box tabulkou, protože těch slov může být hodně.
    Bylo by lepší předávat id klíčového slova místo názvu při kliknutí na detail, protože se to pak sere.
</p>

<table class="pure-table">
    <thead>
    <tr>
        <th>Server</th>
        <th>Datum hledání</th>
        <th>Výsledek</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${mapResults.get(subject)}" var="history">
        <tr>
            <td>${history.server.getName()}</td>
            <td>${history.creationDate}</td>
            <td>${history.position}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
