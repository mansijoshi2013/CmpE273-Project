<#-- @ftlvariable name="" type="edu.sjsu.cmpe.projectdemo.views.SearchDonorResultView" -->

<html>
<head>
<title>Search Donor</title>
<script>
function submitter(btn) {
    var Email = btn.parentElement.parentElement.id;
    var donorForm = document.forms["donorForm"];
    donorForm.elements["Email"].value = Email;
    donorForm.submit();
}
</script>
</head>

<body bgcolor="Moccasin">
<br>
<br>
<h1><center>These are the donors present in the selected city<center></h1>
<br>
<br>
<div id="dnames" style="background-color:#FFD700;height:200px;width:800px;margin:0 auto;">

		

		<div style="width:800px; margin:0 auto;">	
		<form style="text-align:center" id="donorForm" action="" method="post">
		<input type="hidden" name="Email" />
		<table>
		<#list donors as donor>
		
		<tr id = ${donor.email}>
		<td>
		${donor.name}
		</td>
		<td>
		<input type="button" value="Send Email" onclick="submitter(this)" />
		</td>
		</tr>
	    </#list>
	    </table>
		</form>
		</div>


</body>
</html>
