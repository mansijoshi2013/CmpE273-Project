<#-- @ftlvariable name="" type="edu.sjsu.cmpe.projectdemo.views.SurveyView" -->
<html>
	<head>
		<style type="text/css">
	<#include "foundation.css">
	<#include "normalize.css">
	</style>
	<script>
	function formSubmit()
	{
		window.location.href="../login/donor/clinics";
	}
	</script>
	</head>
	
	<body>
		<form id="donorForm" method="post">
		<h4>Donor History Questionnaire</h4>
<table >
<tr>
  <td>Are You</td>
  <td>Yes</td>
  <td>No</td>
</tr>

<tr>
  <td>Feeling healthy and well today?</td>
  <td><input type="radio" name="option1" value="Yes" ></td>
  <td><input type="radio" name="option1" value="Yes" ></td>
</tr>

<tr>
  <td>Currently taking an antibiotic?</td>
  <td><input type="radio" name="option2" value="Yes" ></td>
  <td><input type="radio" name="option2" value="Yes" ></td>
</tr>

<tr>
  <td>Currently taking any other medication for an infection?</td>
  <td><input type="radio" name="option3" value="Yes" ></td>
  <td><input type="radio" name="option3" value="Yes" ></td>
</tr>

<tr>
  <td>Are you now taking or have you ever taken any medications on the Medication Deferral List?</td>
  <td><input type="radio" name="option4" value="Yes" /></td>
  <td><input type="radio" name="option4" value="Yes" /></td>
</tr>

<tr>
  <td>Have you read the educational materials? </td>
  <td><input type="radio" name="option5" value="Yes" /></td>
  <td><input type="radio" name="option5" value="Yes" /></td>
</tr>

<tr></tr>
<tr></tr>
<tr></tr>
<tr></tr>
<tr></tr>
<tr></tr>
<tr>
  <td>In the past 48 hours</td>
  <td>Yes</td>
  <td>No</td>
</tr>

<tr>
  <td>Have you taken aspirin or anything that has aspirin in it?</td>
  <td><input type="radio" name="option6" value="Yes" /></td>
  <td><input type="radio" name="option6" value="Yes" /></td>
</tr>

<tr></tr>
<tr></tr>
<tr></tr>
<tr></tr>
<tr></tr>
<tr></tr>
<tr>
  <td>In the past 6 weeks</td>
  <td>Yes</td>
  <td>No</td>
  <td>I am a Male</td>
</tr>

<tr>
  <td>Female donors: Have you been pregnant or are you pregnant now? (Males: check "I am male.")</td>
  <td><input type="radio" name="option7" value="Yes" /></td>
  <td><input type="radio" name="option7" value="Yes" /></td>
  <td><input type="radio" name="option7" value="Yes" /></td>
</tr>

<tr></tr>
<tr></tr>
<tr></tr>
<tr></tr>
<tr></tr>


<tr>
  <td>In the past 8 weeks have you</td>
  <td>Yes</td>
  <td>No</td>
</tr>
<tr>
  <td>Donated blood, platelets or plasma?</td>
  <td><input type="radio" name="option8" value="Yes" /></td>
  <td><input type="radio" name="option8" value="Yes" /></td>
</tr>

<tr>
  <td>Had any vaccinations or other shots?</td>
  <td><input type="radio" name="option9" value="Yes" /></td>
  <td><input type="radio" name="option9" value="Yes" /></td>
</tr>



</table>
		<input type="button" onclick="formSubmit()" value="Submit form">
		</form>
	</body>
</html>
