<#-- @ftlvariable name="" type="edu.sjsu.cmpe.projectdemo.views.PasswordResetView" -->
<html>
<head>
<title>Password Reset</title>
<script>
function validatePassword()
{
 if(document.forms.myForm.password.value!=document.forms.myForm.repassword.value)
 {
  alert('Passwords do not match');
  return false;
 }
 return true;
}
</script>
</head>

<body>
<form id="myForm" style="text-align:center" action="" onsubmit="return validatePassword();" method="post">

Password: <input type="password" id="Password" name="Password" />
<br>
Re-enter Password: <input type="password" id="repassword"name="repassword" />
<br>
<input type="submit" value="Reset password">
</body>
</head>
