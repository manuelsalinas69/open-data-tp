function plotTreeMap(data,selector) {
	 var sample_data = [
	                    {"value": 100, "name": "alpha","group":"g1"},
	                    {"value": 70, "name": "beta","group":"g1"},
	                    {"value": 40, "name": "gamma","group":"g2"},
	                    {"value": 15, "name": "delta","group":"g3"},
	                    {"value": 5, "name": "epsilon","group":"g3"},
	                    {"value": 1, "name": "zeta","group":"g2"}
	                  ];
	d3plus.viz()
	
    .container(selector)  // container DIV to hold the visualization
    .data(data)  // data to use with the visualization
    .type("tree_map")   // visualization type
    .id("name")         // key for which our data is unique on
    .size("value")      // sizing of blocks
    //.attr("onclick","alert('hola')")
    .draw();
}

function plotTreeMapGroup(data,selector) {
	 var sample_data = [
	                    {"value": 100, "name": "alpha","group":"g1"},
	                    {"value": 70, "name": "beta","group":"g1"},
	                    {"value": 40, "name": "gamma","group":"g2"},
	                    {"value": 15, "name": "delta","group":"g3"},
	                    {"value": 5, "name": "epsilon","group":"g3"},
	                    {"value": 1, "name": "zeta","group":"g2"}
	                  ];
	d3plus.viz()
	
   .container(selector)  // container DIV to hold the visualization
   .data(data)  // data to use with the visualization
   .type("tree_map")   // visualization type
   .id(["group","name"])         // key for which our data is unique on
   .size("value")      // sizing of blocks
   //.attr("onclick","alert('hola')")
   .draw();
}



