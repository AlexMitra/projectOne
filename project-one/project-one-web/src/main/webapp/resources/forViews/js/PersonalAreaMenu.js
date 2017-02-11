var searchOptions = {
		byField: "byLogin",
		place: "atFirstLetters",
		
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
	
	getSearchedData: function(){
		$.ajax({
			type: "GET",
			url: "http://localhost:8080/project-one-web/personalArea/admin/api/matchedAccounts",
			data: ({part: $('#search-accounts').val(), searchField: searchOptions.getSearchFiled(),
				searchPlace: searchOptions.getSearchPlace()}),
			dataType : "json",			
			success: function(data){			    
				workWithElements.hideElement("personal-info");
				workWithElements.showElement("accounts");
				accountsTable.createAccountsTableWithEmphasize($('#search-accounts').val(), data);
			}
		})
	}
}


var workWithElements = {
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
	}
}


var accountsTable = {
	createAccountsTable: function(data){
		var str = '';
		var n;
		for(var i in data){
			//alert("typeof i: " + typeof i);
			n = +i + 1;
			str += '<tr>';
			str += '<td>' + n + '</td>';
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
			this.createAccountsTable(data);
		}else{
			var str = '';
			var n;
			for(var i in data){
				n = +i + 1;
				str += '<tr>';
				str += '<td>' + n + '</td>';
				str += '<td>' + data[i].accountId + '</td>';
				if(searchOptions.getSearchFiled()==='byLogin'){					

					str += column.createColumn(data[i].accountLogin, part);
					str += '<td>' + data[i].accountEmail + '</td>';
				}else if(searchOptions.getSearchFiled()==='byEmail'){
					str += '<td>' + data[i].accountLogin + '</td>';				
					str += column.createColumn(data[i].accountEmail, part);
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


function init(){
	displaySearchOptions.setSearchOptionOne(document.getElementById("search-option-1"));
	displaySearchOptions.setSearchOptionTwo(document.getElementById("search-option-2"));
}
window.onload = init;

