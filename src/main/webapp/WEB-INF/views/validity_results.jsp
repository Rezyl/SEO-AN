<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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


