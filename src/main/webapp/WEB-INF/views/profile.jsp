<%@include file="/WEB-INF/views/taglibImports.jsp" %>

<ol class="breadcrumb">
    <li><a href="/profily/">Profily</a></li>
    <li class="active"><c:out value="${profile.url}"/></li>
</ol>

<h1>Detail profilu ${profile.url}</h1>

<hr />

<%@include file="/WEB-INF/views/profile_navigation.jsp" %>
