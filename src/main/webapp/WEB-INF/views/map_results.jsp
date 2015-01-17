<%@include file="/WEB-INF/views/taglibImports.jsp" %>

<jsp:include page="map.jsp"/>

<hr />

<h2>Výsledek</h2>

<hr />

<p>
    <c:if test="${!empty map}">
        <c:forEach items="${map}" var="item">
            <a href="<c:out value="${item}"/>" target="_blank"><c:out value="${item}"/></a><br />
        </c:forEach>
    </c:if>

    <c:if test="${empty map}">
        <p class="error">Nebyly nalezeny žádné podstránky. Tvar zadané URL adresy se musí shodovat s tvarem URL na prohledávaném webu.</p>
    </c:if>
</p>
