<!DOCTYPE HTML>
<html>
<%@page import="java.io.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<title>Cat Composer Web App</title>
<meta name="description" content="website description" />
<meta name="keywords" content="website keywords, website keywords" />
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<!-- modernizr enables HTML5 elements and feature detects -->
<script type="text/javascript" src="js/modernizr-1.5.min.js"></script>
</head>

<body>
	<div id="main">
		<div id="site_content">
			<div class="content">
				<h1>Login</h1>
				<div class="content_item">
					<form:form method="POST" action="verifyuser.html"
						modelAttribute="login">
						<div class="form_settings">
							<table style="margin:25px 0px 0px 0px;">
								<tr>
									<td><form:label path="username">Email Id:</form:label></td>
									<td><form:input path="username" /></td>
									<td style="background: #ffffff"><form:errors
											path="username" cssClass="error" style="color:red;" /></td>
								</tr>
								<tr>
									<td><form:label path="password">Password:</form:label></td>
									<td><form:password path="password" /></td>
									<td style="background: #ffffff"><form:errors
											path="password" cssClass="error" style="color:red;" /></td>
								</tr>
								<tr>
									<td colspan="2"><input class="submit" type="submit"
										name="login_submitted" value="Login" /></td>
								</tr>
								<caption align="bottom">
									<a href="forget.html">Forgot Password</a>
								</caption>
								<c:if test="${!empty fail}">
									<caption align="bottom" style="color: red;">${fail}</caption>
								</c:if>
								
							</table>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
	<!-- javascript at the bottom for fast page loading -->
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/jquery.easing-sooper.js"></script>
	<script type="text/javascript" src="js/jquery.sooperfish.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('ul.sf-menu').sooperfish();
		});
	</script>
</body>
</html>
