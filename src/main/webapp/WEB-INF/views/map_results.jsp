<%@include file="/WEB-INF/views/taglibImports.jsp" %>

<h2>Mapa</h2>

<hr />

<c:if test="${!empty map}">
    <p>
    <c:forEach items="${map}" var="item">
        <a href="<c:out value="${item}"/>" target="_blank"><c:out value="${item}"/></a><br />
    </c:forEach>
    </p>
</c:if>

<c:if test="${empty map}">
    <p class="error">Nebyly nalezeny žádné podstránky. Tvar zadané URL adresy se musí shodovat s tvarem URL na prohledávaném webu.</p>
</c:if>

