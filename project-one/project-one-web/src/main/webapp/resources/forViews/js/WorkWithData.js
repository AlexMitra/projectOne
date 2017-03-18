var workWithData = {
	getAccountsData : function () {
		$.ajax({
					type : "GET",
					url : "http://localhost:8080/project-one-web/personalArea/admin/api/allEnabledAccounts",
					dataType : "json",
					success : function (data) {
						workWithElements.hideElement("personal-info");
						workWithElements.showElement("accounts");
						accountsTable.createAccountsTable(data);
					}
				})
	},

	// getRoles: function(){
	// $.ajax({
	// type: "GET",
	// url:
	// "http://localhost:8080/project-one-web/personalArea/admin/api/allRoles",
	// dataType : "json",
	// success: function(data){
	// searchOptions.addRoles(data);
	// }
	// })
	// },

	getSearchedData : function () {
		if ($('#search-accounts').val().length == 0) {
			this.getSelectedRolesData();
		} else {
			$.ajax({
						type : "GET",
						url : "http://localhost:8080/project-one-web/personalArea/admin/api/matchedEnabledAccounts",
						data : {
							part : $('#search-accounts').val(),
							searchField : searchOptions.getSearchFiled(),
							searchPlace : searchOptions.getSearchPlace(),
							roles : searchOptions.getRoles()
						},
						dataType : "json",
						success : function (data) {
							workWithElements.hideElement("personal-info");
							workWithElements.showElement("accounts");
							accountsTable.createAccountsTableWithEmphasize($('#search-accounts').val(), data);
						}
					})
			return true;
		}

	},

	getSelectedRolesData : function () {
		// alert("selectedRoles: " + searchOptions.getRoles());
		if (searchOptions.getRoles().length == 0) {
			this.getAccountsData();
		} else {
			$.ajax({
						type : "GET",
						url : "http://localhost:8080/project-one-web/personalArea/admin/api/selectedRolesEnabledAccounts",
						data : {
							roles : searchOptions.getRoles()
						},
						dataType : "json",
						success : function (data) {
							// alert("in success selectedRoles: "
							// + searchOptions.getRoles());
							workWithElements.hideElement("personal-info");
							workWithElements.showElement("accounts");
							accountsTable.createAccountsTable(data);
						}
					})
			return true;
		}
	}
}