var workWithData = {

	hideAdminAreaElements : function(){
		workWithElements.hideElement("personal-info");
		workWithElements.hideElement("accounts");
		workWithElements.hideElement("adCategories");
	},

	getAccountsData : function () {

		if(document.getElementById("accounts-enabled-disabled-toggle").checked == true){
			var url = "http://localhost:8080/project-one-web/personalArea/admin/api/allEnabledAccounts";
		}else{
			var url = "http://localhost:8080/project-one-web/personalArea/admin/api/allDisabledAccounts";
		}

		$.ajax({
					type : "GET",
					url : url,
					dataType : "json",
					success : function (data) {
						workWithData.hideAdminAreaElements();
						workWithElements.showElement("accounts");
						accountsTable.createAccountsTable(data);
					}
				})
	},

	getAdCategoriesData : function () {

		if(document.getElementById("adCategories-enabled-disabled-toggle").checked == true){
			var url = "http://localhost:8080/project-one-web/personalArea/admin/api/ad_categories/enabled";
		}else{
			var url = "http://localhost:8080/project-one-web/personalArea/admin/api/ad_categories/disabled";
		}

		$.ajax({
					type : "GET",
					url : url,
					dataType : "json",
					success : function (data) {
						workWithData.hideAdminAreaElements();
						workWithElements.showElement("adCategories");
						adCategoriesTable.createAdCategoriesTable(data);
					}
				})
	},


	getSearchedData : function () {
		if ($('#search-accounts').val().length == 0) {
			this.getSelectedRolesData();
		} else {

			if(document.getElementById("accounts-enabled-disabled-toggle").checked == true){
				var url = "http://localhost:8080/project-one-web/personalArea/admin/api/matchedEnabledAccounts";
			}else{
				var url = "http://localhost:8080/project-one-web/personalArea/admin/api/matchedDisabledAccounts";
			}

			$.ajax({
						type : "GET",
						url : url,
						data : {
							part : $('#search-accounts').val(),
							searchField : searchOptions.getSearchFiled(),
							searchPlace : searchOptions.getSearchPlace(),
							roles : searchOptions.getRoles()
						},
						dataType : "json",
						success : function (data) {
							workWithData.hideAdminAreaElements();
							workWithElements.showElement("accounts");
							accountsTable.createAccountsTableWithEmphasize($('#search-accounts').val(), data);
						}
					})
			return true;
		}

	},

	getSelectedRolesData : function () {
		if (searchOptions.getRoles().length == 0) {
			this.getAccountsData();
		} else {

			if(document.getElementById("accounts-enabled-disabled-toggle").checked == true){
				var url = "http://localhost:8080/project-one-web/personalArea/admin/api/selectedRolesEnabledAccounts";
			}else{
				var url = "http://localhost:8080/project-one-web/personalArea/admin/api/selectedRolesDisabledAccounts";
			}

			$.ajax({
						type : "GET",
						url : url,
						data : {
							roles : searchOptions.getRoles()
						},
						dataType : "json",
						success : function (data) {
							workWithData.hideAdminAreaElements();
							workWithElements.showElement("accounts");
							accountsTable.createAccountsTable(data);
						}
					})
			return true;
		}
	}
}