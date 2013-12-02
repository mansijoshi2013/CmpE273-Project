<#-- @ftlvariable name="" type="edu.sjsu.cmpe.projectdemo.views.AppointmentView" -->
<html>
<head>
	<script>
		function nextPage()
		{
			window.location.href="../appointments/time";
		}
	</script>
</head>

	<body>
			<form action="" method="post">
			<table cellpadding="8" align="left">
    			<tr>
        		   <td><b>Your Appointment has been Confirmed!!</b></td>
        		</tr>
        		<tr>
     	 			<td><b>Date: </b></td>
     	 		</tr>
     	 		<tr>	
     	 			<td><b>Time: </b></td>
     	 		</tr>	
     	 			<td align="left"><input type="button" onClick="nextPage()" value="Home"></td>
    			
   
	  </table>
	</form>
	</body>
</html>