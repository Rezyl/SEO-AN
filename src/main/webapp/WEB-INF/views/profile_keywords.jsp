<%@include file="/WEB-INF/views/taglibImports.jsp" %>

<ol class="breadcrumb">
    <li><a href="/profily/">Profily</a></li>
    <li class="active">Klíčová slova</li>
</ol>

<header>
    <h1>Klíčová slova ${profile.displayName}</h1>
    <a class="pure-button pure-button-primary button-large right" href="/pozice">Přidat klíčové slovo</a>
</header>

<p>Hledáno na adrese <c:out value="${profile.url}"/></p>

<hr />

<%@include file="/WEB-INF/views/profile_navigation.jsp" %>

<hr />

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
                <td><a href="/klicove_slovo/?subject=${key}&amp;profileID=${profile.profileID}" class="pure-button button-secondary button-small">Detail</a></td>
                <td><a class="pure-button button-error button-small" href="">Odstranit</a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
