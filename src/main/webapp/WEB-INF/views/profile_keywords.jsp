<%@include file="/WEB-INF/views/taglibImports.jsp" %>

<ol class="breadcrumb">
    <li><a href="/profily/">Profily</a></li>
    <li class="active">Klíčová slova</li>
</ol>

<header>
    <h1>Klíčová slova ${profile.url}</h1>
    <a class="pure-button pure-button-primary button-large right" href="/profil_klicove_slovo/?profileID=${profile.profileID}">Přidat klíčové slovo</a>
</header>

<hr />

<%@include file="/WEB-INF/views/profile_navigation.jsp" %>
<c:if test="${! empty mapResults}">
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
            <c:url var="deleteURL" value="/odstranitKlicoveSlovo">
                <c:param name="profileID" value="${profile.profileID}"/>
                <c:param name="keyWord" value="${key}"/>
            </c:url>
            <tr>
                <td>${key}</td>
                <joda:format var="lastSearch" pattern="dd-MM-yyyy HH:mm" value="${lastSearchDate}" style="F-"/>
                <td><c:out value="${lastSearch}"/></td>
                <td><a href="/klicove_slovo/?subject=${key}&amp;profileID=${profile.profileID}" class="pure-button button-secondary button-small">Detail</a></td>
                <td><a class="pure-button button-error button-small" href="${deleteURL}">Odstranit</a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</c:if>

<c:if test="${empty mapResults}">
    <p class="warning">Žádná klíčová slova nebyla nalezena.</p>
</c:if>
