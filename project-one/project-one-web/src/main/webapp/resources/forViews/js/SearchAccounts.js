var searchOptions = {
	byField : "byLogin",
	place : "atFirstLetters",

	roles : [],

	setSearchField : function (field) {
		this.byField = field;
	},

	setSearchPlace : function (p) {
		this.place = p;
	},

	getSearchFiled : function () {
		return this.byField;
	},

	getSearchPlace : function () {
		return this.place;
	},

	addRole : function (role) {
		document.getElementById(role).checked = true;
		this.roles.push(role);

		workWithData.getSearchedData();
		// workWithData.getSelectedRolesData();
	},

	removeRole : function (role) {
		document.getElementById(role).checked = false;
		var i = this.containRole(role);
		if (i >= 0) {
			this.roles.splice(i, 1);
		}
		// workWithData.getSearchedData();
		workWithData.getSelectedRolesData();
	},

	containRole : function (role) {
		for (var i = 0; i < this.roles.length; i++) {
			if (this.roles[i].toLowerCase() === role.toLowerCase()) { return i; }
		}
		return -1;
	},

	// addRoles: function(arr){
	// for(var i = 0; i< arr.length; i++){
	// this.roles.push(arr[i]);
	// }
	// alert("before roles: " + this.roles);
	// roleCheckboxes.createRoleCheckboxes(this.roles);
	// },

	getRoles : function () {
		str = "";

		for (var i = 0; i < this.roles.length; i++) {
			str += this.roles[i];
		}
		return str;
	}
}

var displaySearchOptions = {
	searchOptionOne : null,

	searchOptionTwo : null,

	setSearchOptionOne : function (element) {
		this.searchOptionOne = element;
	},

	setSearchOptionTwo : function (element) {
		this.searchOptionTwo = element;
	},

	DisplaySearchOptionOne : function () {
		this.searchOptionOne.removeAttribute("style");
		workWithElements.hideElement("search-option-2");
	},

	DisplaySearchOptionTwo : function () {
		this.searchOptionTwo.removeAttribute("style");
		workWithElements.hideElement("search-option-1");
	}
}

var searcher = {
	searchByLogin : function () {
		document.getElementById("menu-button-1").innerHTML = 'By Login<span class="caret"></span>';
		searchOptions.setSearchField("byLogin");
	},

	searchByEmail : function () {
		document.getElementById("menu-button-1").innerHTML = 'By Email<span class="caret"></span>';
		searchOptions.setSearchField("byEmail");
	},

	searchAtFirstLetters : function () {
		document.getElementById("menu-button-2").innerHTML = 'At First<span class="caret"></span>';
		searchOptions.setSearchPlace("atFirstLetters");
	},

	searchAnywhere : function () {
		document.getElementById("menu-button-2").innerHTML = 'Anywhere<span class="caret"></span>';
		searchOptions.setSearchPlace("anywhere");
	}
}

// var roleCheckboxes = {
// createRoleCheckboxes: function(roles){
// alert("in roleCheckboxes: " + roles);
// str = '';
// for(var i=0; i < roles.length; i++){
// str+='<div class="col-lg-4 col-md-4 col-sm-4">';
// str+='<div class="checkbox">';
// str+='<label><input type="checkbox">' + roles[i] + '</label>';
// str+='</div></div>';
// }
// alert("str: " + str);
// document.getElementById("role-checkboxes").innerHTML = str;
// }
// }

function init () {
	// workWithData.getRoles();

	displaySearchOptions.setSearchOptionOne(document
			.getElementById("search-option-1"));
	displaySearchOptions.setSearchOptionTwo(document
			.getElementById("search-option-2"));
	// searchOptions.getRoles();

	// roleCheckboxes.createRoleCheckboxes(searchOptions.getRoles());
}
window.onload = init;
