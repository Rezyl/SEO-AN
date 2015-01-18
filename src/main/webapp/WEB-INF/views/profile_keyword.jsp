<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<%@include file="/WEB-INF/views/taglibImports.jsp" %>

<ol class="breadcrumb">
    <li><a href="/profily/">Profily</a></li>
    <li><a href="/profil?profileID=${profile.profileID}"><c:out value="${profile.url}"/></a></li>
    <li><a href="/klicova_slova/?profileID=${profile.profileID}">Klíčová slova</a></li>
    <li class="active"><c:out value="${subject}"/></li>
</ol>

<h1>Detail klíčového slova <c:out value="${subject}"/></h1>

<p>Hledáno na adrese <c:out value="${profile.url}"/></p>

<hr />


<canvas id="canvas" style="width: 100%;"></canvas>

<script src="./../../resources/js/chart.min.js"></script>
<script>

    var lineChartData = {
        labels : [
            <c:forEach items="${mapResults.get(subject)}" var="history">"${history.creationDate}",</c:forEach>
        ],
        datasets : [
            {
                label: "My First dataset",
                fillColor : "rgba(220,220,220,0.2)",
                strokeColor : "rgba(220,220,220,1)",
                pointColor : "rgba(220,220,220,1)",
                pointStrokeColor : "#fff",
                pointHighlightFill : "#fff",
                pointHighlightStroke : "rgba(220,220,220,1)",
                data : [
                    <c:forEach items="${mapResults.get(subject)}" var="history">${history.position},</c:forEach>
                ]
            }
        ]

    }

    window.onload = function(){
        var ctx = document.getElementById("canvas").getContext("2d");
        var myLineChar = new Chart(ctx).Line(lineChartData, {
            responsive: true
        });
        <c:forEach items="${mapResults.get(subject)}" var="history">
        myLineChar.addData([${history.position}], "${history.creationDate}");
        </c:forEach>
        window.myLine = myLineChar;
    }

</script>


<table class="pure-table wide">
    <thead>
    <tr>
        <th>Server</th>
        <th>Datum hledání</th>
        <th>Výsledek</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${mapResults.get(subject)}" var="history">
        <tr>
            <td>${history.server.getName()}</td>
            <joda:format var="creationDate" pattern="dd-MM-yyyy HH:mm" value="${history.creationDate}" style="F-"/>
            <td><c:out value="${creationDate}"/></td>
            <td>${history.position}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
