<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
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
    <p>Pozice Seznam.cz: ${seznam_position}</p>
    <p>Pozice Google.com: ${google_position}</p>
    <p>Pozice Centrum.cz: ${centrum_position}</p>
</table>