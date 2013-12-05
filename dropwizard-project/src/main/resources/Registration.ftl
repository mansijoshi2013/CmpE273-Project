<#-- @ftlvariable name="" type="edu.sjsu.cmpe.projectdemo.views.RegistrationView" -->
<html>
<head>
<title>Registrationr</title>
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
	
	<body >
<div id="bgNode"class="bgNode" style="height: 505px; margin-top: 14;">
<div id="SITE_HEADER" width="1080" height="200" x="0" y="0" scale="1" angle="0" styleid="hc3" style="visibility: visible; width: 980px; min-height: 200px; position: absolute;margin-left: 140px;">
            <div style="position: absolute; width: 1080px; height: 200px; left: -150px; ">
               
            </div>
        
        <div style="width: 980px; margin-left: 0px;"><div skinpart="bg" class="wysiwyg_viewer_skins_screenwidthcontainer_DefaultScreenhc3-bg">
        </div>
        <div >
            <div id="WPht6"  width="440" height="170" x="555" y="55" scale="1" angle="0" state=""  style="visibility: visible; left: 455px; ; min-width: 440px; min-height: 170px; position: absolute; background-color: rgba(234, 229, 229, 0.61);">
               
                    <div class="header_bg">
    
                        <img alt="" src="/assets/background.png" style="margin-top: 0px; width: 440px; height: 170px; background-color: rgba(234, 229, 229, 0.611765);">
                    </div>
                
            </div>

    <div id="WPht4" width="345" height="155" x="0" y="58" scale="1" angle="0" state="" style="visibility: visible; left: 0px; top: 8px; min-width: 345px; min-height: 155px; position: absolute;">
        <a href="#" target="_self" style="cursor: pointer;">
                <img  alt="" src="/assets/banner2.jpg" style="margin-top: -2px;margin-left: -30px;width: 959px;height: 225px;">
                </a>
    </div>
	</div>
</div>
        
  		<div width="385" height="165" x="580" y="60" scale="1" angle="0" style="visibility: visible; left: 580px; top: 60px; width: 385px; min-height: 165px; position: absolute;">
        </div>
        </div>
        
        <div id = "formArea" style="margin-top: 210px;">
		<form id="Regform" action="" onsubmit="return (validateZipCode() && validatePassword() && validateUsername() && isDateSelected() && validateEmail() && validateName() && validatePhone() && validateBloodGroup());" method="post" >
		<h1 align="center">Blood Donation </h1>
		<table cellpadding="8" style="margin-left: 400px;">
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
         <td align="left"><input class="BDRP_sidebutton" style = "position:relative; width: 175px; margin-top: 15px;left: 175px;;
height: 30px;" type="submit" value="Register"></td>
    </tr>
    <tr>
         <td align="left"><input class="BDRP_sidebutton" style = "position:relative; width: 175px; margin-top: 15px;left: 175px;;
height: 30px;" onclick="history.back();" type="button" value="Back"></td>
    </tr>
  </table>
		
		</form>
		</div>
		</div>
	</body>
</html>
