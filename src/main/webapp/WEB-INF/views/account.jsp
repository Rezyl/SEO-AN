<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="taglibImports.jsp"/>

<header>
    <h1>Správa účtu</h1>
    <a class="pure-button pure-button-primary button-large right" href="/registrationForm/">Přidat nový účet</a>
</header>

<hr />

<form class="pure-form pure-form-stacked" action="${login}" method='POST'>
    <input name="login" id="login" type="text" placeholder="Jméno" value="${login}">
    <input name="password" id="password" type="password" placeholder="Heslo" value="${password}">
    <button type="submit" class="pure-button pure-button-primary button-large">Změnit</button>
</form>