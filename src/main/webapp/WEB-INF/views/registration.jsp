<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="taglibImports.jsp"/>

<c:if test="${not empty error}">
    <div class="error">${error}</div>
</c:if>
<c:if test="${not empty msg}">
    <div class="msg">${msg}</div>
</c:if>

<h1>Registrace</h1>

<form class="pure-form pure-form-stacked" name='loginForm' action="<c:url value='j_spring_security_check' />" method='POST'>

        <input name="login" id="login" type="text" placeholder="Jméno">
        <input name="password" id="password" type="password" placeholder="Heslo">
        <button type="submit" class="pure-button pure-button-primary">Registrace</button>

        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
