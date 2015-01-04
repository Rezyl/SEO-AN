<%@include file="/WEB-INF/views/taglibImports.jsp" %>

<h1>Existující profily</h1>

<c:if test="${! empty searchResult}">
    <table class="pure-table-horizontal">
        <tbody>
        <c:forEach items="${searchResult}" var="item">
            <c:url var="detailURL" value="/detailOfProfile">
                <c:param name="profileID" value="${item.displayName}"/>
            </c:url>
            <tr>
                <td><c:out value="${item.displayName}"/></td>
                <td><a class="button-secondary pure-button" href="${detailURL}">Detail</a></td>
                <td><a class="button-secondary pure-button" href="/newSearch">Nové hledání</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>

<c:if test="${empty searchResult}">
    <span>Žádný profil nebyl nalezen !</span>
    <br/>
    <a class="pure-button pure-button-primary" href="/pozice">Nový profil</a>
</c:if>
