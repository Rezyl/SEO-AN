<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="taglibImports.jsp"/>


<h1>Registrace</h1>

    <form:form cssClass="pure-form pure-form-stacked" action="submitRegistration" commandName="newUser" method="post">
        <form:input path="login" placeholder="Jméno"/>
        <span><c:out value="${err}"/></span>
        <form:password path="password" placeholder="Heslo"/>
        <button type="submit" class="pure-button pure-button-primary">Registrace</button>
    </form:form>