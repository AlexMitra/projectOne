var searchOptions = {
		byField: "byLogin",
		place: "atFirstLetters",
		
		roles: [],
		
		setSearchField: function (field) {
			this.byField = field;
		},
		
		setSearchPlace: function (p) {
			this.place = p;
		},
		
		getSearchFiled: function () {
			return this.byField;
		},
		
		getSearchPlace: function(){
			return this.place;
		},
		
		addRole: function(role){			
			document.getElementById(role).checked = true;
			this.roles.push(role);
			//workWithData.getSearchedData();
			workWithData.getSelectedRolesData();
		},
		
		removeRole: function(role){			
			document.getElementById(role).checked = false;
			var i = this.containRole(role);
			if(i >= 0){				
				this.roles.splice(i, 1);
			}
			//workWithData.getSearchedData();
			workWithData.getSelectedRolesData();
		},
		
		containRole: function(role){			
			for (var i = 0; i < this.roles.length; i++) {				
		        if (this.roles[i].toLowerCase() === role.toLowerCase()) {		        	
		            return i;		            
		        }
		    }			
		    return -1;
		},
		
//		addRoles: function(arr){			
//			for(var i = 0; i< arr.length; i++){
//				this.roles.push(arr[i]);
//			}
//			alert("before roles: " + this.roles);
//			roleCheckboxes.createRoleCheckboxes(this.roles);			
//		},
		
		getRoles: function(){			
			str = "";
			
			for (var i = 0; i < this.roles.length; i++) {
				str += this.roles[i];
			}
			return str; 
		}
}


var displaySearchOptions = {
	searchOptionOne: null,
		
	searchOptionTwo: null,
	
	setSearchOptionOne: function(element){
		this.searchOptionOne = element;
	},
	
	setSearchOptionTwo: function(element){
		this.searchOptionTwo = element;
	},
		
	DisplaySearchOptionOne: function(){
		this.searchOptionOne.removeAttribute("style");
		workWithElements.hideElement("search-option-2");
	},
	
	DisplaySearchOptionTwo: function(){
		this.searchOptionTwo.removeAttribute("style");
		workWithElements.hideElement("search-option-1");
	}
}


var searcher = {
	searchByLogin: function(){
		document.getElementById("menu-button-1").innerHTML = 'By Login<span class="caret"></span>';
		searchOptions.setSearchField("byLogin");
	},
	
	searchByEmail: function(){
		document.getElementById("menu-button-1").innerHTML = 'By Email<span class="caret"></span>';
		searchOptions.setSearchField("byEmail");
	},
	
	searchAtFirstLetters: function(){
		document.getElementById("menu-button-2").innerHTML = 'At First<span class="caret"></span>';
		searchOptions.setSearchPlace("atFirstLetters");
	},
	
	searchAnywhere: function(){
		document.getElementById("menu-button-2").innerHTML = 'Anywhere<span class="caret"></span>';
		searchOptions.setSearchPlace("anywhere");
	}
}


//var roleCheckboxes = {
//	createRoleCheckboxes: function(roles){
//		alert("in roleCheckboxes: " + roles);
//		str = '';
//		for(var i=0; i < roles.length; i++){
//			str+='<div class="col-lg-4 col-md-4 col-sm-4">';
//			str+='<div class="checkbox">';
//			str+='<label><input type="checkbox">' + roles[i] + '</label>';
//			str+='</div></div>';
//		}
//		alert("str: " + str);
//		document.getElementById("role-checkboxes").innerHTML = str;
//	}
//}


var workWithData = {
	getAccountsData: function(){
		$.ajax({
			type: "GET",
			url: "http://localhost:8080/project-one-web/personalArea/admin/api/allAccounts",
			dataType : "json",			
			success: function(data){			    
				workWithElements.hideElement("personal-info");
				workWithElements.showElement("accounts");
				accountsTable.createAccountsTable(data);
			}
		})
	},
	
//	getRoles: function(){
//		$.ajax({
//			type: "GET",
//			url: "http://localhost:8080/project-one-web/personalArea/admin/api/allRoles",
//			dataType : "json",			
//			success: function(data){
//				searchOptions.addRoles(data);
//			}
//		})		
//	},
	
	getSearchedData: function(){
		$.ajax({
			type: "GET",
			url: "http://localhost:8080/project-one-web/personalArea/admin/api/matchedAccounts",
			data: ({part: $('#search-accounts').val(), searchField: searchOptions.getSearchFiled(),
				searchPlace: searchOptions.getSearchPlace(), roles: searchOptions.getRoles()}),
			dataType : "json",			
			success: function(data){			    
				workWithElements.hideElement("personal-info");
				workWithElements.showElement("accounts");
				accountsTable.createAccountsTableWithEmphasize($('#search-accounts').val(), data);
			}
		})
		return true;
	},
	
	getSelectedRolesData: function(){
		//alert("selectedRoles: " + searchOptions.getRoles());
		if(searchOptions.getRoles().length == 0){
			this.getAccountsData();
		}else{
			$.ajax({
				type: "GET",
				url: "http://localhost:8080/project-one-web/personalArea/admin/api/selectedRolesAccounts",
				data: ({roles: searchOptions.getRoles()}),
				dataType : "json",			
				success: function(data){
					alert("in success selectedRoles: " + searchOptions.getRoles());
					workWithElements.hideElement("personal-info");
					workWithElements.showElement("accounts");
					accountsTable.createAccountsTable(data);
				}
			})
			return true;
		}		
	}
}


var workWithElements = {
	selectedAccountsCounter: 0,
	selectedAccountsArr: [],
		
	hideElement: function(id){
		if (document.getElementById(id)) {
			var element = document.getElementById(id);
			if (element.style.display != "none") {
				element.style.display = "none";
			}
		}
	},
	
	showElement: function(id){
		if (document.getElementById(id)) {
			var element = document.getElementById(id);
			if (element.style.display != "block") {
				element.style.display = "block";		
			}
		}	
	},
	
	selectCheckbox: function(id){
		document.getElementById(id).checked = true;
		this.selectedAccountsCounter++;	
		this.selectedAccountsArr.push(id);		
	},
	
	unselectCheckbox: function(id){
		document.getElementById(id).checked = false;
		this.selectedAccountsCounter--;
		var i = this.containCheckboxId(id);
		if(i >= 0){				
			this.selectedAccountsArr.splice(i, 1);
		}		
	},
	
	switchCheckbox: function(id){
		if (document.getElementById(id).checked == true){
			this.unselectCheckbox(id);
		}else{
			this.selectCheckbox(id);
		}
	},
	
	containCheckboxId: function(id){			
		for (var i = 0; i < this.selectedAccountsArr.length; i++) {				
	        if (this.selectedAccountsArr[i].toLowerCase() === id.toLowerCase()) {		        	
	            return i;		            
	        }
	    }			
	    return -1;
	},
	
	unselectAllCheckboxes: function(){		
		for (var i = 0; this.selectedAccountsArr.length> 0 ; ) {			
			document.getElementById(this.selectedAccountsArr[i]).checked = false;
			this.selectedAccountsCounter--;							
			this.selectedAccountsArr.shift();
			
		}		
		this.switchAccountsTableButtons();
	},
	
	switchAccountsTableButtons: function(){
		if(this.selectedAccountsCounter > 0){
			document.getElementById("unselect-all-account-button").disabled = false;
			document.getElementById("update-account-button").disabled = false;
			document.getElementById("delete-account-button").disabled = false;
		}else{
			document.getElementById("unselect-all-account-button").disabled = true;
			document.getElementById("update-account-button").disabled = true;
			document.getElementById("delete-account-button").disabled = true;
		}
	}
}


var accountsTable = {
	createAccountsTable: function(data){
		var str = '';
		//var n;
		var link = 'getbootstrap.com/';
		for(var i in data){
			//alert("typeof i: " + typeof i);
			//n = +i + 1;
			str += '<tr id = "account-' + data[i].accountId + '" class="linkrow" onclick="workWithAccountsTable.selectAccount(this.id)">';
			//str += '<td>' + n + '</td>';			
			str += '<td><div class="checkbox"><label><input type="checkbox" id="checkbox-account-'
				+ data[i].accountId + '" onclick = "workWithAccountsTable.selectAccount(this.id)" unchecked></label></div></td>';
			str += '<td>' + data[i].accountId + '</td>';
			str += '<td>' + data[i].accountLogin + '</td>';
			str += '<td>' + data[i].accountEmail + '</td>';
			str += '<td>' + data[i].accountPassword + '</td>';
			str += '<td>' + data[i].accountRole + '</td>';
			str +='</tr>';
		}	
		document.getElementById("accounts-data").innerHTML = str;
	},
	
	createAccountsTableWithEmphasize: function(part, data){
		if(part.length == 0){
			workWithData.getSelectedRolesData(data);
		}else{
			var str = '';
			//var n;
			for(var i in data){
				//n = +i + 1;
				str += '<tr id = "account-' + data[i].accountId + '" class="linkrow" onclick="workWithAccountsTable.selectAccount(this.id)">';
				//str += '<td>' + n + '</td>';
				str += '<td><div class="checkbox"><label><input type="checkbox" id="checkbox-account-'
					+ data[i].accountId + '" onclick = "workWithAccountsTable.selectAccount(this.id)" unchecked></label></div></td>';
				str += '<td>' + data[i].accountId + '</td>';
				if(searchOptions.getSearchFiled()==='byLogin'){
					str += column.createColumn(data[i].accountLogin, part);					
				}else{
					str += '<td>' + data[i].accountLogin + '</td>';
				}
				
				if(searchOptions.getSearchFiled()==='byEmail'){					
					str += column.createColumn(data[i].accountEmail, part);
				}else{
					str += '<td>' + data[i].accountEmail + '</td>';
				}
				
				str += '<td>' + data[i].accountPassword + '</td>';
				str += '<td>' + data[i].accountRole + '</td>';
				str +='</tr>';
			}	
			document.getElementById("accounts-data").innerHTML = str;
		}
	}
}


var column = {
	createColumn: function(column, part){
		var str = '';
		var toUpperCase = false;
		if(column.charAt(0) >= 65 && column.charAt(0) <= 90){
			toUpperCase = true;
		}
		var columnForCompare = column.toLowerCase();
		var partForCompare = part.toLowerCase();
		
		if(searchOptions.getSearchPlace()==='atFirstLetters'){					
			str += this.createColumnWithMatchInBegin(partForCompare, columnForCompare);
		}else if(searchOptions.getSearchPlace()==="anywhere"){
			str += this.createColumnWithMatchInMiddle(partForCompare, columnForCompare);
		}else{
			str += '<td>' + column + '</td>';
		}
		
		return str;
	},
	
	createColumnWithMatchInBegin: function(part, data){
		var anotherPart = data.substring(part.length);
		return '<td>' + '<strong>' + part.charAt(0).toUpperCase() + part.substring(1) + '</strong>' + anotherPart + '</td>';
	},
	
	createColumnWithMatchInMiddle: function(part, data){
		var position = data.indexOf(part);
		if(position == 0){						
			data = data.replace(new RegExp(part, 'g'), '<strong>' + part + '</strong>');
			data = '<strong>' + data.charAt(8).toUpperCase() + data.substring(9);
			
		}else{
			data = data.replace(new RegExp(part, 'g'), '<strong>' + part + '</strong>');
			data = data.charAt(0).toUpperCase() + data.substring(1);
		}					
		return '<td>' + data + '</td>';
	}
}

var workWithAccountsTable = {
	selectAccount: function(id){
		if(id.search("checkbox-") == -1){
			id = "checkbox-" + id;				
		}
		workWithElements.switchCheckbox(id);
		workWithElements.switchAccountsTableButtons();
	},
	
	unselectAll: function(){
		workWithElements.selectedAccountsCounter = 0;
		workWithElements.switchAccountsTableButtons();
	}
}


function init(){
	//workWithData.getRoles();
	
	displaySearchOptions.setSearchOptionOne(document.getElementById("search-option-1"));
	displaySearchOptions.setSearchOptionTwo(document.getElementById("search-option-2"));
	//searchOptions.getRoles();	
	
	
	
	//roleCheckboxes.createRoleCheckboxes(searchOptions.getRoles());
}
window.onload = init;

