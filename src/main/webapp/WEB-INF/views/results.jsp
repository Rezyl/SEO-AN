<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>Výsledky</h1>
<table class="pure-table">
    <thead>
    <tr>
        <th>#</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${resultList}" var="r">
        <tr><td><c:out value="${r}"/></td></tr>
    </c:forEach>

    </tbody>
</table>