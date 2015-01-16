<%@include file="/WEB-INF/views/taglibImports.jsp" %>

<h1>Detail profilu ${profile.displayName}</h1>

<p>Hledáno na adrese <c:out value="${profile.url}"/></p>

<hr />

<%@include file="/WEB-INF/views/profile_navigation.jsp" %>

<table class="pure-table wide">
    <thead>
    <tr>
        <th>Klíčové slovo</th>
        <th>Datum hledání</th>
        <th></th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${mapResults.keySet()}" var="key">
        <tr>
            <td>${key}</td>
            <td>vypsat datum</td>
            <td><a href="/klicove_slovo/?subject=${key}&amp;profileID=${profile.displayName}" class="pure-button button-secondary button-small">Detail</a></td>
            <td><a class="pure-button button-error button-small" href="">Odstranit</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
