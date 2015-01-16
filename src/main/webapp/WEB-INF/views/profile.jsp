<%@include file="/WEB-INF/views/taglibImports.jsp" %>

<h1>Detail profilu ${profile.displayName}</h1>

<p>Hledáno na adrese <c:out value="${profile.url}"/></p>

<hr />

<div class="pure-menu pure-menu-open pure-menu-horizontal">
    <ul>
        <li class="pure-menu-selected"><a href="klicova_slova/?profileID=${profile.displayName}">Klíčová slova</a></li>
        <li><a href="#">Stránky</a></li>
        <li><a href="#">Expirace</a></li>
    </ul>
</div>

<hr />
