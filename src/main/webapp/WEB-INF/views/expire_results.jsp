<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="expire.jsp"/>

<hr />

<h2>Datum expirace</h2>

<c:if test="${expiration != 'Nezjištěno'}">
    <p class="success"><c:out value="${expiration}"/></p>
</c:if>

<c:if test="${expiration == 'Nezjištěno'}">
    <p class="error"><c:out value="${expiration}"/></p>
</c:if>





