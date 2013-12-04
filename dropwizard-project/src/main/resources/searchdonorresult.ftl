<#-- @ftlvariable name="" type="edu.sjsu.cmpe.projectdemo.views.SearchDonorResultView" -->

<html>
<body bgcolor="Moccasin">
<br>
<br>
<h1><center>These are the list of donors present in the selected city<center></h1>
<br>
<br>
<div id="dnames" style="background-color:#FFD700;height:200px;width:800px;margin:0 auto;">
		

		<div style="width:800px; margin:0 auto;">	
		<form style="text-align:center" action="" method="post">
		<table>
		<#list donors as donor>
		
		<tr>
		<td>
		${donor.name}
		</td>
		<td>
		<input type="hidden" id="hidden1" name="Email" value = ${donor.email}>
		<input type="submit" value="Send Email">
		</td>
		</tr>
	    </#list>
	    </table>
		</form>
		</div>


</body>
</html>
