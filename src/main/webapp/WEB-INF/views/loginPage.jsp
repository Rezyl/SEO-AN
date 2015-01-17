<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="taglibImports.jsp"/>

<c:if test="${not empty error}">
    <div class="error">${error}</div>
</c:if>
<c:if test="${not empty msg}">
    <div class="msg">${msg}</div>
</c:if>

<h1>Přihlášení uživatele</h1>

<c:url value='j_spring_security_check' var="login" />
<form class="pure-form pure-form-stacked" name='loginForm' action="${login}" method='POST'>
        <input name="login" id="login" type="text" placeholder="Jméno">
        <input name="password" id="password" type="password" placeholder="Heslo">
        <button type="submit" class="pure-button pure-button-primary button-large">Přihlásit</button>
</form>
