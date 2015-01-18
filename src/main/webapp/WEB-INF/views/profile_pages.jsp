<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<%@include file="/WEB-INF/views/taglibImports.jsp" %>

<ol class="breadcrumb">
    <li><a href="/profily/">Profily</a></li>
    <li class="active">Stranky</li>
</ol>

<header>
    <h1>Stránky ${profile.url}</h1>
    <a class="pure-button pure-button-primary button-large right" href="/profil_stranka/?profileID=${profile.profileID}">Importovat stránky</a>
</header>

<hr />

<%@include file="/WEB-INF/views/profile_navigation.jsp" %>
<c:if test="${! empty mapPages}">
<table class="pure-table wide">
    <thead>
    <tr>
        <th>Datum hledání</th>
        <th>Úroveň</th>
        <th>URL</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${mapPages}" var="page">
        <tr>
            <joda:format var="creationDate" pattern="dd-MM-yyyy HH:mm" value="${page.creationDate}" style="F-"/>
            <td><c:out value="${creationDate}"/></td>
            <td><c:out value="${page.level}"/></td>
            <td><c:out value="${page.url}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</c:if>
<c:if test="${empty mapPages}">
    <p class="warning">Žádné stránky nebyly nalezeny.</p>
</c:if>
