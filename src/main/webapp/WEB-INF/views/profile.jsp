<%@include file="/WEB-INF/views/taglibImports.jsp" %>

<h1>Detail profilu ${profile.displayName}</h1>

<p>Hledáno na adrese <c:out value="${profile.url}"/></p>

<hr />

<%@include file="/WEB-INF/views/profile_navigation.jsp" %>
