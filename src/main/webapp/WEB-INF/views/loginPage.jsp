<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="taglibImports.jsp"/>

<c:if test="${not empty error}">
    <div class="error">${error}</div>
</c:if>
<c:if test="${not empty msg}">
    <div class="msg">${msg}</div>
</c:if>

<form class="pure-form pure-form-stacked" name='loginForm' action="<c:url value='j_spring_security_check' />" method='POST'>
    <fieldset>
        <legend>Přihlášení uživatele</legend>

        <label for="login">Jméno</label>
        <input  name ="login" id="login" type="text" placeholder="Jméno">

        <label for="password">Heslo</label>
        <input name = "login" id="password" type="password" placeholder="Heslo">

        <button type="submit" class="pure-button pure-button-primary">Přihlásit</button>
    </fieldset>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
