<%@include file="/WEB-INF/views/taglibImports.jsp" %>


<jsp:include page="position.jsp"/>

<hr />
<h1>Výsledek</h1>
<c:choose>
    <c:when test="${position == 0}">
        <span>Vaše hledané slovo - ${subject} nebylo nalezeno. Zkuste zvýšit počet stranek na kterých se má hledat.</span>
    </c:when>
    <c:otherwise>
        <span>Vaše hledané slovo - ${subject} se nachází na ${position} pozici.</span>
    </c:otherwise>
</c:choose>

