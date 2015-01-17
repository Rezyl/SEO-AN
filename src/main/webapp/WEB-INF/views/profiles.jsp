<%@include file="/WEB-INF/views/taglibImports.jsp" %>

<header>
    <h1>Profily</h1>
    <a class="pure-button pure-button-primary button-large right" href="/pozice">Přidat profil</a>
</header>

<c:if test="${! empty searchResult}">
    <table class="pure-table pure-table-bordered wide">
        <thead>
        <tr>
            <th>Název</th>
            <th>Datum vytvoření</th>
            <th>Počet klíčových slov</th>
            <th>Počet stránek</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${searchResult}" var="item">
            <c:url var="detailURL" value="/profil">
                <c:param name="profileID" value="${item.displayName}"/>
            </c:url>
            <tr>
                <td><c:out value="${item.displayName}"/></td>
                <td></td>
                <td></td>
                <td></td>
                <td><a class="pure-button button-secondary button-small" href="${detailURL}">Detail</a></td>
                <td><a class="pure-button button-error button-small" href="${detailURL}">Odstranit</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>

<c:if test="${empty searchResult}">
    <p class="warning">Žádný profil nebyl nalezen.</p>
</c:if>
