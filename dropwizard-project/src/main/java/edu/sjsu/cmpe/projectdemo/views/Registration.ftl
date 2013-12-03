<#-- @ftlvariable name="" type="edu.sjsu.cmpe.projectdemo.views.RegistrationView" -->
<html>
<head>
	<style type="text/css">
	<#include "style.css">
	<#include "normalize.css">
	</style>
<script>
function validatePhone()
{
 if(parseInt(document.forms.Regform.phone.value)!=document.forms.Regform.phone.value)
 {
  alert('Please enter a phone number,numbers only');
  Regform.phone.focus();
  Regform.phone.select();
  return false;
 }
 if(document.forms.Regform.phone.value.length>10 || document.forms.Regform.phone.value.length<10)
 {
  alert('Please enter a valid phone number');
  return false;
 }
 return true;
}

function validateName()
{
 if(document.forms.Regform.name.value==null||document.forms.Regform.name.value=="")
 {
  alert('Please enter your name');
  return false;
 }
 return true;
}

function validateEmail()
{
 var reg_email=/^([a-zA-Z0-9_\.-])+@(([a-zA-Z0-9-])+\.)+([a-zA-Z])+$/;
 var email=document.forms.Regform.email.value;
 if(!reg_email.test(email))
 {
  alert('Please enter a valid email');
  Regform.email.focus();
  Regform.email.select();
  return false;
 }
 return true;
}

function validateBloodGroup()
{
 if(document.forms.Regform.bloodGroup.value==""||document.forms.Regform.bloodGroup.value==null)
 {
  alert('Please enter your blood group');
  return false;
 }
 return true;
}

function isDateSelected()
{
var today=new Date();
var inputDate=new Date(document.forms.Regform.dob.value);
if(inputDate.value=""||(!Date.parse(inputDate))||inputDate>today)
 {
  alert('Please enter a valid date');
  Regform.dob.focus();
  return false;
 }
return true;
}

function validateUsername()
{
 if(document.forms.Regform.username.value.length>30)
 {
  alert('Username has exceeded maximum number(30) of characters');
  return false;
 }
 return true;
}

function validatePassword()
{
 if(document.forms.Regform.password.value!=document.forms.Regform.repassword.value)
 {
  alert('Passwords do not match');
  return false;
 }
 return true;
}

function validateZipCode()
{
 if(document.forms.Regform.zipcode.value==""||document.forms.Regform.zipcode.value==null)
 {
  alert('Please enter your zipcode');
  return false;
 }
 return true;
}
</script>

</head>
	<body bgcolor="8A2BE2">
		<form id="Regform" action="" onsubmit="return (validateZipCode() && validatePassword() && validateUsername() && isDateSelected() && validateEmail() && validateName() && validatePhone() && validateBloodGroup());" method="post" >
		<h1 align="center">Blood Donation </h1>
		<table cellpadding="8" align="center">
    <tr>
         <td align="right"><b>Name:</b></td>
      <td align="left"><input type="text" id="name" name="Name" /></td>
    </tr>
    <tr>
    
      <td align="right"><b>Sex:</b></td>
      <td align="left"><input type="radio" name="sex" id="male"  value="male"/>Male
      <input type="radio" name="sex" id="female"  value="female"/>Female</td>
    </tr>
     <tr>
     
      <td align="right"><b>DateOfBirth:</b></td>
      <td align="left"><input type="date" id="dob" name="DateOfBirth" /></td>
    </tr>
     <tr>
     
      <td align="right"><b>BloodGroup:</b></td>
      <td align="left"><input type="text" id="bloodGroup" name="BloodGroup" /></td>
    </tr>
     <tr>
    
      <td align="right"><b>PhoneNumber</b></td>
      <td align="left"><input type="text" id="phone" name="PhoneNumber" /></td>
    </tr>
    <tr>
   
      <td align="right"><b>Email:</b></td>
      <td align="left"><input type="text" id="email"name="Email" /></td>
    </tr>
     <tr>
     
      <td align="right"><b>Street</b></td>
      <td align="left"><input type="text" name="Street" /></td>
    </tr>
     <tr>
    
      <td align="right"><b>City:</b></td>
      <td align="left"><input type="text" name="City" /></td>
    </tr>
   
    <tr>
      <td align="right"><b>State:</b></td>
      <td align="left"><input type="text" name="State" /></td>
    </tr>
    
   <tr>
      <td align="right"><b>ZipCode:</b></td>
      <td align="left"><input type="zip" id="zipcode" name="ZipCode" /></td>
    </tr>
     
     <tr>
      <td align="right"><b>UserName:</b></td>
      <td align="left"><input type="text" id="username" name="UserName" /></td>
    </tr>
    
    <tr>
      <td align="right"><b>Password:</b></td>
      <td align="left"><input type="password" id="password" name="Password" /></td>
    </tr>
    
     <tr>
      <td align="right"><b>Re-Enter Password:</b></td>
      <td align="left"><input type="password" id="repassword" name="repassword" /></td>
    </tr>
    
    <tr>
         <td align="left"><input type="submit" value="Register"></td>
    </tr>
    
  </table>
		
		</form>
	</body>
</html>
