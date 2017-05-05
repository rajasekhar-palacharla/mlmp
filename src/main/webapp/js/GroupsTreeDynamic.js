

function treeify(list, group_idAttr, parent_groupAttr, childrenAttr) {
    if (!group_idAttr) group_idAttr = 'group_id';
    if (!parent_groupAttr) parent_groupAttr = 'parent_group';
    if (!childrenAttr) childrenAttr = 'children';
    var treeList = [];
    var lookup = {};
    list.forEach(function(obj) {
        lookup[obj[group_idAttr]] = obj;
        obj[childrenAttr] = [];
    });
    list.forEach(function(obj) {
        if (obj[parent_groupAttr] != null) {
            lookup[obj[parent_groupAttr]][childrenAttr].push(obj);
        } else {
            treeList.push(obj);
        }
    });
    return treeList;
};

/*var json_data = JSON.stringify(treeify(list));
console.log(json_data);
console.log(JSON.parse(json_data))
$(document).ready(function() {
		$('ul.sf-menu').sooperfish();
		var json_data_obj = JSON.parse(json_data)
		console.log(jQuery.parseJSON(json_data)[1])
		console.log(treeData)
		alert(json_data_obj[1])
		BuildVerticaLTree(json_data_obj[1], "#tree");
	});*/
/*$(document).ready(function() {
	$('ul.sf-menu').sooperfish();
	
	$.getJSON( "groups.html", function( data ) {
		var json_data = JSON.stringify(treeify(data));
		var json_data_obj = JSON.parse(json_data)
//		alert('before displaying')
		console.log(json_data_obj[1])
		BuildVerticaLTree(json_data_obj[1],'#tree')
	});
});*/