<#-- @ftlvariable name="" type="edu.sjsu.cmpe.projectdemo.views.RegistrationView" -->
<html>
<head>
 <style type="text/css">
        <#include "foundation.css">
        <#include "normalize.css">
        </style>
</head>
	<body bgcolor="8A2BE2">
		<form action="" method="post" >
		<h1 align="center">Blood Donation </h1>
		<table cellpadding="8" align="center">
    <tr>
         <td align="right"><b>Name:</b></td>
      <td align="left"><input type="text" name="Name" /></td>
    </tr>
    <tr>
    
      <td align="right"><b>Sex:</b></td>
      <td align="left"><input type="radio" name="sex" id="male"  value="male"/>Male
      <input type="radio" name="sex" id="female"  value="female"/>Female</td>
    </tr>
     <tr>
     
      <td align="right"><b>DateOfBirth:</b></td>
      <td align="left"><input type="date" name="DateOfBirth" /></td>
    </tr>
     <tr>
     
      <td align="right"><b>BloodGroup:</b></td>
      <td align="left"><input type="text" name="BloodGroup" /></td>
    </tr>
     <tr>
    
      <td align="right"><b>PhoneNumber</b></td>
      <td align="left"><input type="text" name="PhoneNumber" /></td>
    </tr>
    <tr>
   
      <td align="right"><b>Email:</b></td>
      <td align="left"><input type="email" name="Email" /></td>
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
      <td align="left"><input type="zip" name="ZipCode" /></td>
    </tr>
     
     <tr>
      <td align="right"><b>UserName:</b></td>
      <td align="left"><input type="text" name="UserName" /></td>
    </tr>
    
    <tr>
      <td align="right"><b>Password:</b></td>
      <td align="left"><input type="password" name="Password" /></td>
    </tr>
    
     <tr>
      <td align="right"><b>Re-Enter Password:</b></td>
      <td align="left"><input type="password" name="repassword" /></td>
    </tr>
    
    <tr>
         <td align="left"><input type="submit" value="Register"></td>
    </tr>
    
  </table>
		
		</form>
	</body>
</html>
