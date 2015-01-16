<%@include file="/WEB-INF/views/taglibImports.jsp" %>

<h1>Mapa webu</h1>

<p>
    <c:forEach items="${map}" var="item">
        <c:out value="${item}"/><br />
    </c:forEach>
</p>
