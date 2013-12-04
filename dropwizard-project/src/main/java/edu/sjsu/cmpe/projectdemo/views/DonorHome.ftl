<#-- @ftlvariable name="" type="edu.sjsu.cmpe.projectdemo.views.DonorHomeView" -->
<html>
<head>
	<style type="text/css">
	<#include "style.css">
	<#include "normalize.css">
	</style>
</head>

	<body>
	<div id="container" style="width:1200px">
		<div id="requests" style="background-color:#FFD700;height:400px;width:300px;float:left;">
		Blood Requests for the Day! <br> <br>
		<#list bloodRequests as requests>
		<p>
		<br>
		${requests.bloodGroup}
		<br>
		${requests.hospital}
		<br>
		${requests.address},${requests.city},${requests.state}
		
		</input>
		</p>
	    </#list> 
		</div>
	
	
		<div id="camps" style="background-color:#EEEEEE;height:400px;width:300px;float:left;">
		<form style="text-align:left" action="" method="get">
		The following camps are taking place in your city:<br><br><br>
		
		<div id="cl"></div>
		<#list camps as camp>
		
		${camp.eventName}
		<br>
		${camp.venue}, ${camp.city}
		<br>
		${camp.dateOfEvent}
		<br>
		${camp.timeOfEvent}
		<br>
		<br>
		
		</#list>	
		
		
		</form>
		</div>
		
		
		<div id="apt" style="background-color:#FFD700;height:400px;width:200px;float:left;">
		Your Appointments! <br> <br>
		<#list appointment as apt>
		<p>
		<br>
		${apt.clinicName}
		<br>
		${apt.time}
		<br>
		${apt.date}
		
		</input>
		</p>
	    </#list> 
		
		</div>
	</div>
	</body>
</html>