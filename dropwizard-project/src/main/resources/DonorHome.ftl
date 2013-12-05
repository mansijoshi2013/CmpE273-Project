<#-- @ftlvariable name="" type="edu.sjsu.cmpe.projectdemo.views.DonorHomeView" -->
<html>
<head>
<title> Donor Home </title>
	<style type="text/css">
	<#include "style.css">
	<#include "normalize.css">
	</style>
</head>

	<body>
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
        <br>
        
	<div id="container" style="width: 100%;padding: 76px 10px 10px;margin-left: 70px;margin-top: 150px;">
		<div id="requests" style="background-color: #EEEEEE;height:400px;width:300px;float:left;">
		Blood Requests for the Day! <br> <br>
		<#list bloodRequests as requests>
		<p style = "color: black;">
		<br>
		${requests.bloodGroup}
		<br>
		${requests.hospital}
		<br>
		${requests.address},${requests.city},${requests.state}
		
		</input>
		</p>
	    </#list> 
		</div>
	
	
		<div id="camps" style="background-color:#EEEEEE;height:400px;width:300px;float:left;">
		<form style="text-align:left" action="" method="get">
		The following camps are taking place in your city:<br><br><br>
		
		<div id="cl"></div>
		<#list camps as camp>
		
		${camp.eventName}
		<br>
		${camp.venue}, ${camp.city}
		<br>
		${camp.dateOfEvent}
		<br>
		${camp.timeOfEvent}
		<br>
		<br>
		
		</#list>	
		
		
		</form>
		</div>
		
		
		<div id="apt" style="background-color: #EEEEEE;;height:400px;width:400px;float:left;">
		<form action="" method="post">
		<input type="submit" class="BDRP_sidebutton" style = "position:relative; width: 275px; 
height: 30px;" name="username" value="Book an Appointment now!!" >
		<br>
		<br>
		Your Appointments! <br> <br>
		<#list appointment as apt>
		<p style = "color: black;">
		<br>
		${apt.clinicName}
		<br>
		${apt.time}
		<br>
		${apt.date}
		
		</input>
		</p>
	    </#list> 
		</form>
		</div>
	</div>
</div>
	</body>
</html>
