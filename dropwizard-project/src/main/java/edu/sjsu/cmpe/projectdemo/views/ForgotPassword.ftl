<#-- @ftlvariable name="" type="edu.sjsu.cmpe.projectdemo.views.ForgotPasswordView" -->
<html>
<head>
<script>
function validateEmail()
{
 var reg_email=/^([a-zA-Z0-9_\.-])+@(([a-zA-Z0-9-])+\.)+([a-zA-Z])+$/;
 var email=document.forms.myForm.email.value;
 if(!reg_email.test(email))
 {
  alert('Please enter a valid email');
  myForm.email.focus();
  myForm.email.select();
  return false;
 }
 return true;
}
</script>
</head>

<body>
<form id="myForm" style="text-align:center" action="" onsubmit="return validateEmail();" method="post">
Please enter your email:
<input type="text" id="email"name="Email" />
<br>
<br>
<input type="submit" value="Send Email">
</body>
</head>
