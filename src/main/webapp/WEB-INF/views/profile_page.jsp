<%@include file="/WEB-INF/views/taglibImports.jsp" %>

<ol class="breadcrumb">
    <li><a href="/profily/">Profily</a></li>
    <li><a href="/stranky/">Stranky</a></li>
    <li class="active">Stranka</li>
</ol>

<h1>Detail stránky</h1>

<p>Hledáno na adrese <c:out value="${profile.url}"/></p>

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
