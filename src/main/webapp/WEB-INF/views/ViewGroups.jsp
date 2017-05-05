<%-- <jsp:include page="adminheader.jsp" /> --%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<script src="js/d3.v3.min.js"></script>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.easing-sooper.js"></script>
<script type="text/javascript" src="js/jquery.sooperfish.js"></script>
<script type="text/javascript" src="js/tree.js"></script>
<script type="text/javascript">
	alert(<%=request.getContextPath()%>)
</script>
<title>View Groups</title>

<style>
body {
	background: #aae;
}

.node {
	cursor: pointer;
}

.node circle { /*fill: #fff;
                stroke: steelblue;*/
	stroke-width: 5px;
}

.node text {
	font: 15px sans-serif;
	fill: #04066D;
}

.link {
	fill: none;
	stroke: #ccc;
	stroke-width: 2px;
}

.tree {
	margin-bottom: 10px;
	overflow: auto;
}
</style>

</head>

<body>

	<!-- load the d3.js library -->
	<div id="main">
		<div id="site_content">
			<div class="content">
				<div class="content_item">

					<div class="content_item">
						<div id="tree"></div>

					</div>
				</div>
			</div>
		</div>


		<script>
			


		</script>
</body>
</html>
<%-- <jsp:include page="adminfooter.jsp" /> --%>
