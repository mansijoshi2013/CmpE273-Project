<#-- @ftlvariable name="" type="edu.sjsu.cmpe.projectdemo.views.AdminCampView" -->
<html>
<head>
	<style type="text/css">
	<#include "style.css">
	<#include "normalize.css">
	</style>
</head>

	<body >
	<div id="bgNode"class="bgNode" style="height: 505px; margin-left: -68;
margin-top: 14;">
	<form id="RequestForm" action="" method="post" onsubmit="return">
	<h1 align="center">Blood Request Form</h1>
	
	<table cellpadding="8" style="margin-left: 350px;">
		
    <tr>
      <td align="right"><b>Event Name:</b></td>
      <td align="left"><input type="text" id="eventName" name="EventName" /></td>
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
      <td align="right"><b>Date of Event (mm/dd/yyyy format):</b></td>
      <td align="left"><input type="text" id="dateOfEvent" name="DateOfEvent" /></td>
    </tr>
    
    <tr>
      <td align="right"><b>Time of Event (Eg 10 am to 6 pm):</b></td>
      <td align="left"><input type="text" id="timeOfEvent" name="TimeOfEvent" /></td>
    </tr>

    
    <tr>
         <td align="left"><input  class="BDRP_sidebutton" style = "position:relative; width: 225px; margin-top: 15px;left: 175px;;
height: 30px;" type="submit" value="Submit Blood Donation Camp"></td>
    </tr>
    
  </table>
		
		</form>
		</div>
	</body>
</html>
