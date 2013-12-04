<#-- @ftlvariable name="" type="edu.sjsu.cmpe.projectdemo.views.TimeView" -->
<html>
<head>
<style>
.availablestyle{
background:#00FF00;
}
.unavailablestyle{
background:#FF0000;
border:0;
}
</style>
</head>

	<body>
			<form action="" method="post">
			<h1 align="center">Select Time </h1>
			<div id="apt" style="background-color:#FFFFFF;height:400px;width:700px;float:center;">
			<#list appointment as apt>
		<input type="button" name="time" class="unavailablestyle" value=${apt.time}>
		
		</#list> 
		</div>
	</form>
	</body>
</html>
