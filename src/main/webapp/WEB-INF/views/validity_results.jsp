<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="validity.jsp"/>

<hr />
<h1>Výsledek</h1>

<p>Html validita<c:out value="${html_validity}"/></p>
<p>Css validita<c:out value="${css_validity}"/></p>
