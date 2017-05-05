<!DOCTYPE HTML>
<html>
<head>
<title>mlmp</title>
<meta name="description" content="website description" />
<meta name="keywords" content="website keywords, website keywords" />
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<!-- modernizr enables HTML5 elements and feature detects -->
<script type="text/javascript" src="js/modernizr-1.5.min.js"></script>
</head>
<body>
	<%
		String role = (String) session.getAttribute("userrole");
		if (role != null) {
	%>
	<div id="main">
		<header>
			<div id="logo">
				<div id="logo_text">
					<!-- class="logo_colour", allows you to change the colour of the text -->
					<h1>
						<a href="index.html">mlmp<span class="logo_colour">
								Web App</span></a>
					</h1>
				</div>
				<!-- <form method="post" action="#" id="search">
					<input class="search" type="text" name="search_field"
						value="search....."
						onclick="javascript: document.forms['search'].search_field.value=''" />
					<input name="search" type="image"
						style="float: right; border: 0; margin: 20px 0 0 0;"
						src="images/search.png" alt="search" title="search" />
				</form> -->
			</div>

			<nav>
				<ul class="sf-menu" id="nav">
					<li><a href="ccnewusers.html">CC New Users</a></li>
					<!-- <li><a href="ccregactiveusers.html">CC Registered Users</a></li> -->
					<%-- <%
						if (role.equals("Admin")) {
					%> --%>
					<!-- <li><a href="#">CSV Information</a>
						<ul>
							<li><a href="addcsv.html">Add</a></li>
							<li><a href="csvinf.html">View</a></li>
						</ul></li> -->
					<!-- <li><a href="#">Web/OEM User's</a>
						<ul>
							<li><a href="add.html">Add</a></li>
							<li><a href="webusers.html">View</a></li>
						</ul></li> -->
					<li><a href="#">Group's</a>
						<ul>
							<li><a href="addgroup.html">Add</a></li>
							<li><a href="groups.html">View</a></li>
						</ul></li>
					<%-- <%
						}
					%> --%>
					<li><a href="#">Reports</a>
					    <ul>
							<li><a href="newureport.html">New Users</a></li>
							<li><a href="registerureport.html">Register Users</a></li>
						</ul>
					</li>
					<li><a href="logout.html">Logout</a></li>
				</ul>
			</nav>
		</header>
	</div>
	<%
		}else {
			response.sendRedirect("login.html");
		}
	%>
</body>
</html>