<#-- @ftlvariable name="" type="edu.sjsu.cmpe.projectdemo.views.DonorCampsView" -->
<html>
	
	<body>
	
		<form style="text-align:center" action="" method="get">
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
			document.getElementById('cl').appendChild(label);
		</#list>	
		</script>
		<input type="submit" value="Home">
		
		</form>
	</body>
</html>
