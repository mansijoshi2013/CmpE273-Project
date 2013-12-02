<#-- @ftlvariable name="" type="edu.sjsu.cmpe.projectdemo.views.DonorHomeView" -->
<html>
<head>
	
</head>

	<body>
	<div id="container" style="width:500px">
		<div id="requests" style="background-color:#FFD700;height:200px;width:100px;float:left;">
		<p> Blood Requests 
		</div>
	
	
		<div id="camps" style="background-color:#EEEEEE;height:700px;width:300px;float:left;">
		<form style="text-align:left" action="" method="get">
		The following camps are taking place in your city:<br><br><br>
		
		<div id="cl"></div>
		<script type="text/javascript">
		<#list 0..camps?size-1 as i>
		
			var label=document.createElement("label");
			var description=document.createTextNode("${camps[i].eventName?html}");
			label.appendChild(description);	
			var lb=document.createElement("br");
			label.appendChild(lb);
			var description=document.createTextNode("${camps[i].venue?html}");
			label.appendChild(description);
			var lb=document.createElement("br");
			label.appendChild(lb);
			var description=document.createTextNode("${camps[i].city?html}");
			label.appendChild(description);
			var lb=document.createElement("br");
			label.appendChild(lb);			
			var description=document.createTextNode("${camps[i].dateOfEvent?html}");
			label.appendChild(description);	
			var lb=document.createElement("br");
			label.appendChild(lb);
			var description=document.createTextNode("${camps[i].timeOfEvent?html}");
			label.appendChild(description);	
			var lb=document.createElement("br");
			label.appendChild(lb);
			
			var lb=document.createElement("br");
			label.appendChild(lb);
			
			document.getElementById('cl').appendChild(label);
		</#list>	
		</script>
		
		</form>
		</div>
		
		
		<div id="appointments" style="background-color:#FFD700;height:200px;width:100px;float:left;">
		<p>Appointments
		</div>
	</div>
	</body>
</html>