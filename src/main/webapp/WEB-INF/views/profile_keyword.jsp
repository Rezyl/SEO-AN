<%@include file="/WEB-INF/views/taglibImports.jsp" %>

<h1>Detail klíčového slova</h1>

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
