<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>citizen request</title>
<link rel="stylesheet" href="w3.css">
<script type="text/javascript">
function passcheck()
{
	 if (document.getElementById('pass1').value ==
		    document.getElementById('pass2').value) {
		    return true;
		  } else {
			  window.alert("Password not matched");
		    document.getElementById('pass2').style.color = 'red';
		    document.getElementById('pass1').style.color = 'red';
		 

		  }

}
function validate()
{
	if(document.getElementById('name').value !="")
		{
		
		if(document.getElementById('mob').value !="")
			{
			if(document.getElementById('email').value !="")
			{
				if(document.getElementById('vn').value !="")
				{
					if(document.getElementById('uid').value !="")
					{
						if(document.getElementById('pass2').value !="")
						{
							return true;
						}else
						{
							window.alert("please enter password  ");
							return false;
						}
					}else
					{
						window.alert("please enter user id");
						return false;
					}
				}else
				{
					window.alert("please enter voterId number");
					return false;
				}
			}else
			{
				window.alert("pplease enter email id");
				return false;
			}
			}else
			{
				window.alert("please enter mobile number");
			return false;
			}
		}else
		{
			window.alert("please enter name");
			return false;
		}


}
</script>
<style>
a{
padding:10px 20px;
background-color: green;
text-decoration:none;
color: white;
}
a:hover{
background-color: blue;
}
</style>

</head>
<body>
<h1 STYLE="font-size: 100px" class="w3-center w3-teal">CITIZEN CARDS</h1>e
<center>
<div>
<a href="Home.html" >Home</a>
<a href="login.html" >Login</a>
<a href="#" >AboutUs</a>
<a href="#" >ContactUs</a>
<a href="#" >Help</a>
</div></center>
<center>
<div class="w3-catainer">
<form action="Reg" method="get" onsubmit="return validate()" >
<h3 style="color: green;background-color: yellow;width: 300px;">----REGISTER HERE----</h3>
<table>
<tr><td>Enter name</td><td><input type="text" name=name id=name ></td></tr>
<tr><td>Mobile</td><td><input type="text" name=mob id=mob ></td></tr>
<tr><td>Email</td><td><input type="text" name=email id=email ></td></tr>
<tr><td>DOB</td><td><input type="date" name=dob id=dob ></td></tr>
<tr><td>Blood Group</td><td><input type="text" name=bg  id=bg ></td></tr>
<tr><td>VoterId No</td><td><input type="text" name=vn id=vn ></td></tr>
<tr><td>RationCard No</td><td><input type="text" name=rn id=rn ></td></tr>
<tr><td>Gender</td><td><input type="radio" name=gen value=male id=male >Male <input type="radio" name=gen value=female>Female</td></tr>
<tr><td>Address1</td><td><input type="text" name=vil1 id=vil1 ><br/><input type="text" name=mnd1 id=mnd1 ><br/>
<select name=dis1 >
<option value="warangal">warangal</option>
<option value="khammam">khammam</option>
<option value="rangareddy">rangareddy</option>
<option value="hyderabad">hyderabad</option>
<option value="janagon">janagon</option>
<option value="mahabubabadh">mahabubabadh</option>
<option value="karimnagar">karimnagar</option>
<option value="nalgonda">nalgonda</option>
</select>
<br/><input type="text" name=st1 id=st1 ></td></tr>
<tr><td>Address2</td><td><input type="text" name=vil2 id=vil2 ><br/><input type="text" name=mnd2 id= ><br/><input type="text" name=dis2 id= ><br/><input type="text" name=st2  id= ></td></tr>
<tr><td>UserId</td><td><input type="text" name=uid id=uid ></td></tr>
<tr><td>Password</td><td><input type="password" id=pass1 id=pass1 ></td></tr>
<tr><td>Confirm Password</td><td><input type="password" name=pass id=pass2 onblur="passcheck()" id=pass2 ></td></tr>
<tr><td><input type="submit" class="w3-teal w3-button"></td><td><input type="reset" class="w3-teal w3-button"></td></tr>
</table>
</form>
</div></center>
</body>
</html>