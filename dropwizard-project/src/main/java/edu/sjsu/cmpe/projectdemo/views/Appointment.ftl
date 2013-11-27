<#-- @ftlvariable name="" type="edu.sjsu.cmpe.projectdemo.views.AppointmentView" -->
<html>
<head>
	<style type="text/css">
	<#include "foundation.css">
	<#include "normalize.css">
	</style>
</head>
	<body>
			<form action="" method="post">
			<div id="cl"></div>
			<input type = "hidden" id="hidden1" name = "checkedValue"/>
			
			
			<script type="text/javascript">
				<#list 0..appointments?size-1 as i>
					var label=document.createElement("label");
					var radio=document.createElement("input");
					radio.type="radio";
					radio.name="name";
					radio.value="${appointments[i].appointmentSlot?datetime?string.medium}";
					label.appendChild(radio);
					var description=document.createTextNode("${appointments[i].appointmentSlot?datetime?string.medium}");
					label.appendChild(description);
					var lb=document.createElement("br");
					label.appendChild(lb);
					document.getElementById('cl').appendChild(label);
				</#list>
			</script>
			
			<script>
						
					function testRadio(){						
						var radios = document.getElementsByName ('name');						
						var value;
						var i;
						for (i = 0; i< radios.length ; i++){
							if (radios[i].checked){
							value = radios[i].value;			
							}											
						}
						document.getElementById("hidden1").value = value;
					}				
			</script>
			
			<input type="submit" value="Book" onClick = "testRadio()">
	</form>
	</body>
</html>