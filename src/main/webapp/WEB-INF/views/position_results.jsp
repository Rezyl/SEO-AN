<%@include file="/WEB-INF/views/taglibImports.jsp" %>

<h1>Pozice ve vyhledávačích</h1>

<p>
    Hledané klíčové slovo <b><c:out value="${keyword}"/></b>
</p>

<c:forEach items="${positions}" var="item">
    <c:if test="${item.value >= 0}">
        <p class="success">je ve vyhledávači <b><c:out value="${item.key}"/></b> na pozici <b><c:out value="${item.value}"/></b> pro zadanou adresu</p>
    </c:if>
    <c:if test="${item.value < 0}">
        <p class="error">nebylo nalezeno ve vyhledávači <b><c:out value="${item.key}"/></b> pro zadanou adresu</p>
    </c:if>
</c:forEach>

