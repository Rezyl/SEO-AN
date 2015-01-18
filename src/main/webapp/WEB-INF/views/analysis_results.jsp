<%@include file="/WEB-INF/views/taglibImports.jsp" %>

<jsp:include page="analysis.jsp"/>

<hr />

<h1>Výsledek</h1>

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

<hr />

<h2>Stav indexu</h2>

<c:if test="${index_google != 'Nezjištěno'}">
    <p class="success">Google.com: <c:out value="${index_google}"/></p>
</c:if>

<c:if test="${index_google == 'Nezjištěno'}">
    <p class="error">Google.com: <c:out value="${index_google}"/></p>
</c:if>

<c:if test="${index_seznam != 'Nezjištěno'}">
    <p class="success">Seznam.cz: <c:out value="${index_seznam}"/></p>
</c:if>

<c:if test="${index_seznam == 'Nezjištěno'}">
    <p class="error">Seznam.cz: <c:out value="${index_seznam}"/></p>
</c:if>

<hr />

<h2>Validita</h2>

<c:if test="${html_validity == 'Validní'}">
    <p class="success">
</c:if>

<c:if test="${html_validity != 'Validní'}">
    <p class="error">
</c:if>

Html validita: <c:out value="${html_validity}"/></p>

<c:if test="${css_validity == 'Validní'}">
    <p class="success">
</c:if>

<c:if test="${css_validity != 'Validní'}">
    <p class="error">
</c:if>

Css validita: <c:out value="${css_validity}"/></p>

<hr />

<h2>Mapa</h2>

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
