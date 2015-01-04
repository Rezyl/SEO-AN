<%@include file="/WEB-INF/views/taglibImports.jsp" %>

<h1>Detail profilu ${profile.displayName}</h1>

<span>Hledáno na adrese <c:out value="${profile.url}"/></span>
<br />

<form action="detailOfProfile" method="get" class="pure-form">
    <input type="hidden" value="${profile.displayName}" name="profileID">
    <span>Zobrazit historii pro slovo:</span>
    <select name="subject">
        <c:forEach items="${mapResults.keySet()}" var="key">
            <c:choose>
                <c:when test="${key == subject}">
                    <option selected>${key}</option>
                </c:when>
                <c:otherwise>
                    <option>${key}</option>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </select>
    <button type="submit" class="pure-button pure-button-primary">Zobrazit</button>
</form>

<br />
<hr />

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
