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
        <th>Detail</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${mapResults.keySet()}" var="key">
        <c:url var="getSearchResultURL" value="/getSearchResults">
            <c:param name="profileID" value="${profile.displayName}"/>
            <c:param name="subject" value="${key}"/>
        </c:url>
        <c:url var="newSearchURL" value="/newSearchKeyword">
            <c:param name="profileID" value="${profile.displayName}"/>
            <c:param name="subject" value="${key}"/>
        </c:url>
        <tr>
            <td>${key}</td>
            <td><a href="${getSearchResultURL}" class="pure-button button-secondary button-small">Detail</a></td>
            <td><a class="pure-button button-success button-large" href="${newSearchURL}">Nové hledání</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
