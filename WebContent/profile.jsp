<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>BioBay</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link href="css/default.css" rel="stylesheet" type="text/css" media="screen" />
    <link href='https://fonts.googleapis.com/css?family=Oxygen:400,300,700' rel='stylesheet' type='text/css'>
    <script type="text/javascript" src="jquery-2.2.0.js"></script> 

    <script type="text/javascript">
    </script>
  </head>
<%@ page import="user.Scientist" %>
<%
Scientist scientist =(Scientist)session.getAttribute("user");
String[] s=scientist.searchProfile();        
%>

<body>
  <header>
    <nav id="header-nav" class="navbar navbar-default">
      <div class="container">
        <div class="navbar-header">
          <a href="main.html" class="pull-left visible-md visible-lg">
            <div id="logo-img" alt="Logo image"></div>
          </a>

          <div class="navbar-brand">
            <a href="main.html"><h1>BioBay</h1></a>
          </div>
        </div>
        
        <div id="collapsable-nav" class="collapse navbar-collapse">
           <ul id="nav-list" class="nav navbar-nav navbar-right">
             <li id="phone"><a href="tel:000-000-0000">000-000-0000</a></li>
             <li class="login"><a href="#"> Log In</a></li>
             <li class="account"><a href="#"> My Account</a></li>
             <li class="shopcart"><a href="#"> Shopping Cart (0)</a></li>
           </ul><!-- #nav-list -->
        </div><!-- .collapse .navbar-collapse -->
        <div id="collapsable-nav" class="collapse navbar-collapse">
          <ul id="menu" class="nav navbar-nav navbar-right">
            <li><a href="main.html">Home</a></li>
            <li><a href="profile.html">Profile</a></li>
            <li><a href="href/mission.html">Our Mission</a></li>
            <li><a href="href/resources.html">Resources</a></li>
            <li><a href="href/about.html">About</a></li>
            <li><a href="href/blog.html">Blog</a></li>
          </ul>
        </div>
      </div><!-- .container -->
    </nav><!-- #header-nav -->
</header>

<div id="main-content" class="container">

</div>

<div>   
  <div id="div-profile">
   <ul>
        <li>id:&nbsp<%=s[0]%></li>
        <li>name:&nbsp<%=s[1]%></li>
        <li>title:&nbsp<%=s[2]%></li>
        <li>lab name:&nbsp<%=s[3]%></li>
        <li>bbpoint:&nbsp<%=s[4]%></li>
   </ul>
  </div>
</div>
</body>
</html>
