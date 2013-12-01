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
			<h1 align="center">Make Appointment </h1>
			<table cellpadding="8" align="center">
    <tr>
   
        		   <td align="right"><b>Select Date:</b></td>
     	 			<td align="left"><input type="date" min="2013-11-30" name="date"/></td>
     	 			<td align="left"><input type="button" onClick ="nextPage()" value="Continue"></td>
    			</tr>
   
	  </table>
	</form>
	</body>
</html>
