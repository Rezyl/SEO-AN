<%@include file="/WEB-INF/views/taglibImports.jsp" %>

<h1>Mapa webu</h1>

<p>
    <c:if test="${!empty map}">
        <c:forEach items="${map}" var="item">
            <c:out value="${item}"/><br />
        </c:forEach>
    </c:if>

    <c:if test="${empty map}">
        <p>Nebyly nalezeny žádné podstránky. Tvar zadané URL adresy se musí shodovat s tvarem URL na prohledávaném webu.</p>
    </c:if>
</p>
