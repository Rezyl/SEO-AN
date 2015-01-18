<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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





