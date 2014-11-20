function plotTreeMap(data,selector) {
	 var sample_data = [
	                    {"value": 100, "name": "alpha"},
	                    {"value": 70, "name": "beta"},
	                    {"value": 40, "name": "gamma"},
	                    {"value": 15, "name": "delta"},
	                    {"value": 5, "name": "epsilon"},
	                    {"value": 1, "name": "zeta"}
	                  ];
	d3plus.viz()
	
    .container(selector)  // container DIV to hold the visualization
    .data(data)  // data to use with the visualization
    .type("tree_map")   // visualization type
    .id("name")         // key for which our data is unique on
    .size("value")      // sizing of blocks
    .draw();
}


