// ************** Generate the tree diagram	 *****************
function BuildVerticaLTree(treeData, treeContainerDom) {
	var margin = {
		top : 40,
		right : 20,
		bottom : 20,
		left : 20
	};
	var width = 1000 - margin.right - margin.left;
	var height = 1000 - margin.top - margin.bottom;

	var i = 0, duration = 750;
	var tree = d3.layout.tree().size([ height, width ]);
	var diagonal = d3.svg.diagonal().projection(function(d) {
		return [ d.x, d.y ];
	});
	var svg = d3.select(treeContainerDom).append("svg").attr("width",
			width + margin.right + margin.left).attr("height",
			height + margin.top + margin.bottom).append("g").attr("transform",
			"translate(" + margin.left + "," + margin.top + ")");
	root = treeData;
	console.info('treedata is-->')
	console.info(treeData)
	update(root);
	function update(source) {
		// Compute the new tree layout.
		var nodes = tree.nodes(root).reverse(), links = tree.links(nodes);
		// Normalize for fixed-depth.
		nodes.forEach(function(d) {
			d.y = d.depth * 100;
		});
		// Declare the nodesâ¦
		var node = svg.selectAll("g.node").data(nodes, function(d) {
			return d.id || (d.id = ++i);
		});
		// Enter the nodes.
		var nodeEnter = node.enter().append("g").attr("class", "node").attr(
				"transform", function(d) {
					return "translate(" + source.x0 + "," + source.y0 + ")";
				}).on("click", nodeclick);
		nodeEnter.append("image").attr("xlink:href", function(d) {
			return d.icon;
		}).attr("x", "-12px").attr("y", "-12px").attr("width", "80px").attr(
				"height", "80px");

		nodeEnter.append("text").attr("y", function(d) {
			return d.children || d._children ? -18 : -18;
		}).attr("dx", "2em").attr("dy", "8em").attr("text-anchor", "middle")
				.text(function(d) {
					return d.name;
				}).style("fill-opacity", 1e-6);
		// Transition nodes to their new position.
		// horizontal tree
		var nodeUpdate = node.transition().duration(duration).attr("transform",
				function(d) {
					return "translate(" + d.x + "," + d.y + ")";
				});
		nodeUpdate.select("image").attr("xlink:href", function(d) {
			return d.icon;
		}).attr("x", "-12px").attr("y", "-12px").attr("width", "80px").attr(
				"height", "80px");
		/*
		 * nodeUpdate.select("circle") .attr("r", 10) .style("fill", function
		 * (d) { return d._children ? "lightsteelblue" : "#fff"; });
		 */
		nodeUpdate.select("text").attr("dx", "2em").attr("dy", "7em").attr(
				"text-anchor", "middle").style("fill-opacity", 1);

		// Transition exiting nodes to the parent's new position.
		var nodeExit = node.exit().transition().duration(duration).attr(
				"transform", function(d) {
					return "translate(" + source.x + "," + source.y + ")";
				}).remove();
		/*
		 * nodeExit.select("circle") .attr("r", 1e-6);
		 */
		nodeExit.select("text").style("fill-opacity", 1e-6);
		// Update the linksâ¦
		// Declare the linksâ¦
		var link = svg.selectAll("path.link").data(links, function(d) {
			return d.target.id;
		});
		// Enter the links.
		link.enter().insert("path", "g").attr("class", "link")

		.attr("d", function(d) {
			var o = {
				x : source.x0,
				y : source.y0
			};
			return diagonal({
				source : o,
				target : o
			});
		});
		// Transition links to their new position.
		link.transition().duration(duration).attr("d", diagonal);

		// Transition exiting nodes to the parent's new position.
		link.exit().transition().duration(duration).attr("d", function(d) {
			var o = {
				x : source.x,
				y : source.y
			};
			return diagonal({
				source : o,
				target : o
			});
		}).remove();

		// Stash the old positions for transition.
		nodes.forEach(function(d) {
			d.x0 = d.x;
			d.y0 = d.y;
		});
	}

	// Toggle children on click.
	function nodeclick(d) {
		if (d.children) {
			d._children = d.children;
			d.children = null;
		} else {
			d.children = d._children;
			d._children = null;
		}
		update(d);
	}
}

var treeData = {
	"name" : "BU Head",
	"icon" : "img/malory.png",
	"children" : [ {
		"name" : "Technical Manager",
		"icon" : "img/sterling.png",

		"children" : [ {
			"name" : "Cat Team Lead",
			"icon" : "img/figgs.png",
			"children" : [ {
				"name" : "Java Developer",
				"icon" : "img/lana.png",
				"children" : []
			}, {
				"name" : "Dotnet Lead",
				"icon" : "img/pam.png",
				"children" : []
			} ]

		}, {
			"name" : "OEM Team Lead",
			"icon" : "img/woodhouse.png",
			"children" : []
		} ]
	}, {
		"name" : "Reporting Manager",
		"icon" : "img/cheryl.png",
		"children" : []
	} ]
};

$(document).ready(function() {
	$('ul.sf-menu').sooperfish();
	BuildVerticaLTree(treeData, "#tree");
});

/*$.ajax({
//	 dataType: "json",
    url: "JsonServlet",
    context: document.body,
    success: function(data){
    	console.info('printing data')
      alert(data.msg)
      BuildVerticaLTree(data,'#tree')
    }
});*/


/*$.getJSON( "JsonServlet", function( data ) {
	alert('before displaying')
	BuildVerticaLTree(data,'#tree')
});*/
				

