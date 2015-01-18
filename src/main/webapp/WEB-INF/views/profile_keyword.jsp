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

    function createEmptyGraph() {
        var data = {
            labels: [],
            datasets: [
                {
                    label: "Dataset",
                    fillColor: "rgba(220,220,220,0.5)",
                    strokeColor: "rgba(220,220,220,0.8)",
                    highlightFill: "rgba(220,220,220,0.75)",
                    highlightStroke: "rgba(220,220,220,1)",
                    data: []
                }
            ]
        };

        return data
    }

    var data = createEmptyGraph();

    var ctx = document.getElementById("canvas").getContext("2d");

    // centrum
    var lineChar = new Chart(ctx).Line(data, {
        responsive: true
    });
    <c:forEach items="${mapResults.get(subject)}" var="history">
        <joda:format var="creationDate" pattern="dd-MM-yyyy HH:mm" value="${history.creationDate}" style="F-"/>

            lineChar.addData([${history.position}], "${creationDate}");

    </c:forEach>


    window.onload = function() {
        window.myLine = lineChar;
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
