<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="taglibImports.jsp"/>

<header>
    <h1>Správa účtu</h1>
    <a class="pure-button pure-button-primary button-large right" href="/registrationForm/">Přidat nový účet</a>
</header>

<hr />
<p class="error"><c:out value="${error}"/></p>
<form:form cssClass="pure-form pure-form-stacked" action="/zmenitUdaje" commandName="updateUser" method="post">
    <form:input path="login" placeholder="Jméno"/>
    <form:password path="password" placeholder="Heslo"/>
    <button type="submit" class="pure-button pure-button-primary button-large">Změnit</button>
</form:form>