<#-- @ftlvariable name="" type="edu.sjsu.cmpe.projectdemo.views.ClinicView" -->
<html>
<head>
	<style type="text/css">
	<#include "style.css">
	<#include "foundation.css">
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
        
        <div id="formContainer" style="margin:250px;">
			<form action="" method="post">
			<div id="cl"></div>
			<input type = "hidden" id="hidden1" name = "checkedValue"/>

			
			<script type="text/javascript">
				<#list 0..clinicList?size-1 as i>
				
					var label=document.createElement("label");
					
					var radio=document.createElement("input");
					radio.type="radio";
					radio.name="name";
					radio.value="${clinicList[i].clinicName?html}";
					radio.id = "radioid";
					
					label.appendChild(radio);
					
					var description=document.createTextNode("${clinicList[i].clinicName?html}");
					label.appendChild(description);	
					var description=document.createTextNode("${clinicList[i].clinicAddress?html}");
					label.appendChild(description);
					var lb=document.createElement("br");
					label.appendChild(lb);
					document.getElementById('cl').appendChild(label);
				</#list>
						</script>

			<script>
						
					function testRadio(){						
						var radios = document.getElementsByName ('name');						
						var value;
						var i;
						for (i = 0; i< radios.length ; i++){
							if (radios[i].checked){
							value = radios[i].value;			
							}											
						}
						document.getElementById("hidden1").value = value;
					}				
			</script>
			
			<input class="BDRP_sidebutton" style= "position:relative; width:300px;" type="submit" value="Next" onClick = "testRadio()"/>

	</form>
	</div>
	</body>
</html>

