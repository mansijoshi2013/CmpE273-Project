<#-- @ftlvariable name="" type="edu.sjsu.cmpe.projectdemo.views.ClinicView" -->
<html>
<head>
	
</head>
	<body>
			<form action="" method="post">
			<div id="cl"></div>
			<input type = "hidden" id="hidden1" name = "checkedValue"/>

			
			<script type="text/javascript">
				<#list 0..sample?size-1 as i>
				
					var label=document.createElement("label");
					
					var radio=document.createElement("input");
					radio.type="radio";
					radio.name="name";
					radio.value="${sample[i].clinicName?html}";
					radio.id = "radioid";
					
					label.appendChild(radio);
					
					var description=document.createTextNode("${sample[i].clinicName?html}");
					label.appendChild(description);	
					var description=document.createTextNode("${sample[i].clinicAddress?html}");
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
			
			<input type="submit" value="Next" onClick = "testRadio()"/>

	</form>
	</body>
</html>

