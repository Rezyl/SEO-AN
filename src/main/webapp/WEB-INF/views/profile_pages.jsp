<%@include file="/WEB-INF/views/taglibImports.jsp" %>

<h1>Detail profilu ${profile.displayName}</h1>

<p>Hledáno na adrese <c:out value="${profile.url}"/></p>

<hr />

<div class="pure-menu pure-menu-open pure-menu-horizontal">
    <ul>
        <li class="pure-menu-selected"><a href="klicova_slova/?profileID=${profile.displayName}">Klíčová slova</a></li>
        <li><a href="#">Stránky</a></li>
        <li><a href="#">Expirace</a></li>
    </ul>
</div>

<hr />

<table class="pure-table wide">
    <thead>
    <tr>
        <th>Klíčové slovo</th>
        <th>Datum hledání</th>
        <th>Detail</th>
    </tr>
    </thead>
    <tbody>
        <c:forEach items="${mapResults.keySet()}" var="key">
            <tr>
                <td>${key}</td>
                <td>vypsat datum</td>
                <td><a href="/klicove_slovo/?subject=${key}&amp;profileID=${profile.displayName}" class="pure-button button-secondary button-small">Detail</a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
