<#-- @ftlvariable name="" type="edu.sjsu.cmpe.projectdemo.views.AdminRequestView" -->
<html>
<head>
	<style type="text/css">
	<#include "style.css">
	<#include "normalize.css">
	</style>
</head>

	<body bgcolor="EEEEE">
	<div id="bgNode"class="bgNode" style="height: 505px;">
	<form id="RequestForm" action="" method="post" onsubmit="return">
	<h1 align="center">Blood Request Form</h1>
	
	<table cellpadding="8" style="margin-left: 469px;">
		
    <tr>
      <td align="right"><b>Blood Group:</b></td>
      <td align="left"><input type="text" id="bloodGroup" name="BloodGroup" /></td>
    </tr>

    <tr>
      <td align="right"><b>Hospital:</b></td>
      <td align="left"><input type="text" id="hospital" name="Hospital" /></td>
    </tr>
    
    <tr>
      <td align="right"><b>Address:</b></td>
      <td align="left"><input type="text" id="address" name="Address" /></td>
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
      <td align="right"><b>Zip Code:</b></td>
      <td align="left"><input type="zip" id="zipCode" name="ZipCode" /></td>
    </tr> 
    
    <tr>
      <td align="right"><b>Time of Request:</b></td>
      <td align="left"><input type="text" id="timeOfRequest" name="TimeOfRequest" /></td>
    </tr>
  
    <tr>
      <td align="right"><b>Phone Number</b></td>
      <td align="left"><input type="text" id="phone" name="PhoneNumber" /></td>
    </tr>
    
    <tr>
         <td align="left"><input class="BDRP_sidebutton" style = "position:relative; width: 175px; margin-top: 15px;left: 175px;;
height: 30px;" type="submit" value="Submit Request"></td>
    </tr>
    
  </table>
		
		</form>
		</div>
	</body>
</html>
