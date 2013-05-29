<html>
<head>
<meta name="layout" content="kickstart" />
<title><g:message code="stats.title.label"/></title>
<gvisualization:apiImport/>
</head>
<body>
	
		<gvisualization:barCoreChart elementId="hitsChart" legend="none" colors="${['65c2e8']}" backgroundColor="none"
                                    columns="${[['string', 'Video title'], ['number', 'Hits']]}" data="${hits}"
                                    chartArea="${new Expando('top': 10, 'left': 10, 'width': '400', 'height': '80%')}"
                                    hAxis="${new Expando('textPosition':'out')}"
                                    vAxis="${new Expando('textPosition':'in')}"
                                    bar="${new Expando('groupWidth': 20)}" />
        
        <gvisualization:barCoreChart elementId="playsChart" legend="none" colors="${['65c2e8']}" backgroundColor="none"
                                    columns="${[['string', 'Video title'], ['number', 'Hits']]}" data="${plays}"
                                    chartArea="${new Expando('top': 10, 'left': 10, 'width': '400', 'height': '80%')}"
                                    hAxis="${new Expando('textPosition':'out')}"
                                    vAxis="${new Expando('textPosition':'in')}"
                                    bar="${new Expando('groupWidth': 20)}" />
    
    <div class="row-fluid">
    	<div class="thumbnail span6">
    		<p class="label label-info">Hits</p>
    		<div id="hitsChart" style="height: 350px;"></div>
    	</div>
        <div class="thumbnail span6">
        	<p class="label label-info">Plays</p>
        	<div id="playsChart" style="height: 350px;"></div>
        </div>
	</div>
	
	<p></p>
	
	<div class="row-fluid">
		<div class="thumbnail span12">
			<p class="label label-info">Raw data</p>
			<table class="table table-striped table-condensed">
				<thead>
					<tr>
						<th>Video title</th>
						<th>Plays</th>
						<th>Hits</th>
						<th>Downloads</th>
						<th>Bytes</th>
					</tr>
				</thead>
				<tbody>
					<g:each in="${stats}" var="row">
						<tr>
							<td>${row.value.title}</td>
							<td>${row.value.plays}</td>
							<td>${row.value.hits}</td>
							<td>${row.value.downloads}</td>
							<td>${row.value.bytes}</td>
						</tr>
					</g:each>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>