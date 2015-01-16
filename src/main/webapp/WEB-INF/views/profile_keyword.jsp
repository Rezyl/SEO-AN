<%@include file="/WEB-INF/views/taglibImports.jsp" %>

<h1>Detail klíčového slova</h1>

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


    <div>
        <canvas id="canvas" style="width: 100%;"></canvas>
    </div>

<script src="./../../resources/js/chart.js"></script>

<script>
    var randomScalingFactor = function(){ return Math.round(Math.random()*100)};
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
        window.myLine = new Chart(ctx).Line(lineChartData, {
            responsive: true
        });
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
            <td>${history.creationDate}</td>
            <td>${history.position}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
