var accountsTable = {
	createAccountsTable : function(data) {
		var str = '';
		// var n;
		var link = 'getbootstrap.com/';
		for ( var i in data) {
			// alert("typeof i: " + typeof i);
			// n = +i + 1;
			str += '<tr id = "account-'
					+ data[i].accountId
					+ '" class="linkrow" onclick="workWithAccountsTable.selectAccount(this.id)">';
			// str += '<td>' + n + '</td>';
			str += '<td><div class="checkbox"><label><input type="checkbox" id="checkbox-account-'
					+ data[i].accountId
					+ '" onclick = "workWithAccountsTable.selectAccount(this.id)" unchecked></label></div></td>';
			str += '<td>' + data[i].accountId + '</td>';
			str += '<td>' + data[i].accountLogin + '</td>';
			str += '<td>' + data[i].accountEmail + '</td>';
			str += '<td>' + data[i].accountPassword + '</td>';
			//str += '<td>' + data[i].accountRoles + '</td>';
			str += '<td>' + this.getRoles(data[i].accountRoles) + '</td>';
			str += '</tr>';
		}
		document.getElementById("accounts-data").innerHTML = str;
	},

	getRoles : function(roleList) {
		if (roleList.length == 1) {
			return roleList[0];
		}
		if (roleList.length > 1) {
			var roles = "";
			for (var i = 0; i < roleList.length; i++) {
				if (i > 0) {
					roles += ", ";
				}
				roles += roleList[i];

			}
			return roles;
		}
	},

	createAccountsTableWithEmphasize : function(part, data) {
		if (part.length == 0) {
			workWithData.getSelectedRolesData(data);
		} else {
			var str = '';
			// var n;
			for ( var i in data) {
				// n = +i + 1;
				str += '<tr id = "account-'
						+ data[i].accountId
						+ '" class="linkrow" onclick="workWithAccountsTable.selectAccount(this.id)">';
				// str += '<td>' + n + '</td>';
				str += '<td><div class="checkbox"><label><input type="checkbox" id="checkbox-account-'
						+ data[i].accountId
						+ '" onclick = "workWithAccountsTable.selectAccount(this.id)" unchecked></label></div></td>';
				str += '<td>' + data[i].accountId + '</td>';
				if (searchOptions.getSearchFiled() === 'byLogin') {
					str += column.createColumn(data[i].accountLogin, part);
				} else {
					str += '<td>' + data[i].accountLogin + '</td>';
				}

				if (searchOptions.getSearchFiled() === 'byEmail') {
					str += column.createColumn(data[i].accountEmail, part);
				} else {
					str += '<td>' + data[i].accountEmail + '</td>';
				}

				str += '<td>' + data[i].accountPassword + '</td>';
				//str += '<td>' + data[i].accountRole + '</td>';
				str += '<td>' + this.getRoles(data[i].accountRoles) + '</td>';
				str += '</tr>';
			}
			document.getElementById("accounts-data").innerHTML = str;
		}
	}
}

var column = {
	createColumn : function(column, part) {
		var str = '';
		var toUpperCase = false;
		if (column.charAt(0) >= 65 && column.charAt(0) <= 90) {
			toUpperCase = true;
		}
		var columnForCompare = column.toLowerCase();
		var partForCompare = part.toLowerCase();

		if (searchOptions.getSearchPlace() === 'atFirstLetters') {
			str += this.createColumnWithMatchInBegin(partForCompare,
					columnForCompare);
		} else if (searchOptions.getSearchPlace() === "anywhere") {
			str += this.createColumnWithMatchInMiddle(partForCompare,
					columnForCompare);
		} else {
			str += '<td>' + column + '</td>';
		}

		return str;
	},

	createColumnWithMatchInBegin : function(part, data) {
		var anotherPart = data.substring(part.length);
		return '<td>' + '<strong>' + part.charAt(0).toUpperCase()
				+ part.substring(1) + '</strong>' + anotherPart + '</td>';
	},

	createColumnWithMatchInMiddle : function(part, data) {
		var position = data.indexOf(part);
		if (position == 0) {
			data = data.replace(new RegExp(part, 'g'), '<strong>' + part
					+ '</strong>');
			data = '<strong>' + data.charAt(8).toUpperCase()
					+ data.substring(9);

		} else {
			data = data.replace(new RegExp(part, 'g'), '<strong>' + part
					+ '</strong>');
			data = data.charAt(0).toUpperCase() + data.substring(1);
		}
		return '<td>' + data + '</td>';
	}
}

var workWithAccountsTable = {
	selectAccount : function(id) {
		if (id.search("checkbox-") == -1) {
			id = "checkbox-" + id;
		}
		workWithElements.switchCheckbox(id);
		workWithElements.switchAccountsTableButtons();
	},

	unselectAll : function() {
		workWithElements.selectedAccountsCounter = 0;
		workWithElements.switchAccountsTableButtons();
	}
}