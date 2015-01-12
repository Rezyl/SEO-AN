<%@include file="/WEB-INF/views/taglibImports.jsp" %>


<jsp:include page="position.jsp"/>

<hr />
<h1>Výsledek</h1>

<p>
    Hledané klíčové slovo <b><c:out value="${keyword}"/></b><br />

    <c:forEach items="${positions}" var="item">
        je ve vyhledávači <b><c:out value="${item.key}"/></b> na pozici <b><c:out value="${item.value}"/></b><br />
    </c:forEach>
</p>
