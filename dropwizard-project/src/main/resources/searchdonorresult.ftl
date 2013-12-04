<#-- @ftlvariable name="" type="edu.sjsu.cmpe.projectdemo.views.SearchDonorResultView" -->

<html>
<body bgcolor="Moccasin">
<br>
<br>
<h1><center>These are the list of donors present in the selected city<center></h1>
<br>
<br>
<div id="dnames" style="background-color:#FFD700;height:200px;width:150px;float:center;">
                

                        
                <form action="" method="post">
                
                <#list donors as donor>
                <p>
                <br>
                ${donor.name},        ${donor.email}
                <br>
                
                </p>
         </#list>
                </form>
                </div>

<form action="" method="post">
<p align="center">
<img border="0" src="http://lsjmedia.files.wordpress.com/2012/09/istock_000008933255xsmall.jpeg" width="152" height="152"></p>
<br>
<br>
<table align="center">
<tr><td> <b><font size="5" face="Courier New" color="red">Send E-Mail
  to Donors </font></b> </td></tr>
<br>
<tr></tr>
<tr><td align="right"> <b>Please enter the donor Mail-Id: </b> </td>
        <td> <input type="text" name="Email" size="31"></td>
<td> <input type="Submit" value="Send an Email"></td>
</tr>
</table>
</form>
</body>
</html>