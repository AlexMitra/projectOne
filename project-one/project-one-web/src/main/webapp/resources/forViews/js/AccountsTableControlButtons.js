var accountsTableAddButton = {

	showForm: function(){
		this.cleanForm();

		$('#add-account-dialog').on('show.bs.modal', function (event) {
		    var button = $(event.relatedTarget)
		})
	},

	addCSRFHeader: function(){
		$(function () {
			var token = $("meta[name='_csrf']").attr("content");
			var header = $("meta[name='_csrf_header']").attr("content");
			$(document).ajaxSend(function(e, xhr, options) {
				xhr.setRequestHeader(header, token);
			});
			});
	},

	addAccount: function () {

		this.addCSRFHeader();

		var accountBeanForCRUD = {}
		accountBeanForCRUD["accountLogin"] = $("#add-account-inputLogin").val();
		accountBeanForCRUD["accountEmail"] = $("#add-account-inputEmail").val();
		accountBeanForCRUD["accountPassword"] = $("#add-account-inputPassword").val();
		accountBeanForCRUD["accountPasswordOnceMore"] = $("#add-account-inputPassword").val();

		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "http://localhost:8080/project-one-web/personalArea/admin/api/account/new",
			data : JSON.stringify(accountBeanForCRUD),
			dataType : 'json',
			timeout : 100000,
			success : function(data, textStatus, xhr) {
				switch (xhr.status) {
		        	case 204:
		        		workWithElements.hideElement("form-for-add-account-alreadyExists-message");
		        		workWithElements.showElement("form-for-add-account-valid-message");
		        		break;
		        	case 409:
		        		workWithElements.hideElement("form-for-add-account-valid-message");
		        		workWithElements.showElement("form-for-add-account-alreadyExists-message");
		        		break;
		        	case 201:
		        		workWithElements.hideElement("form-for-add-account-valid-message");
		        		workWithElements.hideElement("form-for-add-account-alreadyExists-message");
		        		accountsTableAddButton.cleanForm();
		        		document.getElementById("form-for-add-account-close").click();
		        		accountsTable.createAccountsTable(data);
		        		break;
				}
			},
			error : function(xhr, ajaxOptions, thrownError) {

				if(xhr.status == 409){
					workWithElements.hideElement("form-for-add-account-valid-message");
	        		workWithElements.showElement("form-for-add-account-alreadyExists-message");
				}
			}

		});


		this.cleanForm();
	},

	cleanForm: function(){
		document.getElementById("form-for-add-account").reset();
		workWithElements.hideElement("form-for-add-account-valid-message");
		workWithElements.hideElement("form-for-add-account-alreadyExists-message");
	}
}


var accountsTableEditButton = {

		checkboxId: null,

		accountId: null,

		accountLogin: null,

		accountEmail: null,

		accountRoles: [],

		baseTitle: null,

		showForm: function(){
			this.showTitle();
			this.formData();

			$('#edit-account-dialog').on('show.bs.modal', function (event) {
			    var button = $(event.relatedTarget)
			})
		},

		showTitle: function(){
			if(this.baseTitle == null){
				this.baseTitle = document.getElementById("edit-account-dialog-title").innerHTML;
			}

			if(workWithElements.selectedAccountsArr.length > 0){

				this.checkboxId = workWithElements.selectedAccountsArr[0];
				this.accountId = this.checkboxId.replace("checkbox-account-", "");

				this.accountLogin = document.getElementById("accountLogin-" + this.accountId).innerHTML;

				var element = document.getElementById("edit-account-dialog-title");
				element.innerHTML = this.baseTitle + " " + this.accountLogin;
			}
		},

		formData: function(){
			this.cleanForm();
			document.getElementById("form-for-edit-account")
			.setAttribute("action", "http://localhost:8080/project-one-web/personalArea/admin/api/account/" + this.accountId + "/edit");

			document.getElementById("edit-account-inputLogin")
			.setAttribute("value", this.accountLogin);

			this.accountEmail = document.getElementById("accountEmail-" + this.accountId).innerHTML;
			this.accountRoles = document.getElementById("accountRoles-" + this.accountId).innerHTML.split(", ");

			document.getElementById("edit-account-inputEmail")
			.setAttribute("value", this.accountEmail);

			this.addRoleMarkers(this.accountRoles);

		},

		addRoleMarkers: function(roles){
			var roleMarkers = "";
			for(var i=0; i< roles.length; i++){
				roleMarkers += '<font class="role-list-marker">' + roles[i] + '<a id="roleMarker-' + roles[i] + '" href="#" onclick="accountsTableEditButton.removeRoleMarker(this.id)"><i class="fa fa-times" aria-hidden="true"></i></a></font> ';
			}
			document.getElementById("edit-account-form-role-list").innerHTML = roleMarkers;
		},

		addRoleToList: function(roleId){

			roleId = roleId.replace("li-", "");
			var position = this.accountRoles.indexOf(roleId);
			if(position < 0){
				this.accountRoles.push(roleId);
				this.refreshRoleMarkers();
			}

		},

		removeRoleMarker: function(markerId){

			markerId = markerId.replace("roleMarker-", "");
			var position = this.accountRoles.indexOf(markerId);
			if(position >= 0){
				this.accountRoles.splice(position, 1);
			}
			this.refreshRoleMarkers();
		},

		refreshRoleMarkers: function(){
			document.getElementById("edit-account-form-role-list").innerHTML = "";
			this.addRoleMarkers(this.accountRoles);
		},

		rolesValidationBefore: function(){

			if(this.accountRoles.length==0){
				document.getElementById("edit-account-form-role-list").innerHTML = "";
				document.getElementById("edit-account-form-role-list").innerHTML = '<font class="error-text-color">Account must have at least one role</font>';
			}

			if(this.accountRoles.length>0){
				this.editAccount();
			}
		},

		editAccount: function () {

			accountsTableAddButton.addCSRFHeader();

			var accountBeanForCRUD = {}
			accountBeanForCRUD["id"] = this.accountId;
			accountBeanForCRUD["accountLogin"] = $("#edit-account-inputLogin").val();
			accountBeanForCRUD["accountEmail"] = $("#edit-account-inputEmail").val();
			accountBeanForCRUD["accountPassword"] = $("#edit-account-inputPassword").val();
			accountBeanForCRUD["authorities"] = this.accountRoles;

			$.ajax({
				type : "PUT",
				contentType : "application/json",
				url : "http://localhost:8080/project-one-web/personalArea/admin/api/account/" + this.accountId + "/edit",
				data : JSON.stringify(accountBeanForCRUD),
				dataType : 'json',
				timeout : 100000,
				success : function(data, textStatus, xhr) {

					switch (xhr.status) {
			        	case 204:
			        		accountsTableEditButton.cleanForm();
			        		workWithElements.showElement("form-for-edit-account-loginEmail-valid-message");
			        		break;
			        	case 206:
			        		accountsTableEditButton.cleanForm();
			        		workWithElements.showElement("form-for-edit-account-pass-valid-message");
			        		break;
			        	case 409:
			        		accountsTableEditButton.cleanForm();
			        		workWithElements.showElement("form-for-edit-account-alreadyExists-message");
			        		break;
			        	case 201:
			        		workWithElements.hideElement("form-for-edit-account-alreadyExists-message");
			        		workWithElements.hideElement("form-for-edit-account-pass-valid-message");
			        		workWithElements.hideElement("form-for-edit-account-loginEmail-valid-message");

			        		accountsTableEditButton.cleanForm();
			        		document.getElementById("form-for-edit-account-close").click();

			        		workWithElements.unselectAllCheckboxes();
							workWithElements.switchAccountsTableButtons();
			        		accountsTable.createAccountsTable(data);
			        		break;
					}
				},
				error : function(xhr, ajaxOptions, thrownError) {

					if(xhr.status == 409){
						accountsTableEditButton.cleanForm();
		        		workWithElements.showElement("form-for-edit-account-alreadyExists-message");

					}else if(xhr.status == 206){
						accountsTableEditButton.cleanForm();
		        		workWithElements.showElement("form-for-edit-account-pass-valid-message");
					}else if(xhr.status == 500){
						accountsTableEditButton.cleanForm();
						workWithElements.showElement("form-for-edit-account-InternalServerError-message");
					}else{
						accountsTableEditButton.cleanForm();
						document.getElementById("form-for-edit-account-close").click();
						accountsTable.createAccountsTable(data);
					}

				}

			});

		},

		cleanForm: function(){
			document.getElementById("form-for-edit-account").reset();
			workWithElements.hideElement("form-for-edit-account-alreadyExists-message");
    		workWithElements.hideElement("form-for-edit-account-loginEmail-valid-message");
    		workWithElements.hideElement("form-for-edit-account-pass-valid-message");
    		workWithElements.hideElement("form-for-edit-account-InternalServerError-message");
		}
}

var accountsTableDisableButton = {

	checkboxId: null,

	accountId: null,

	baseTitle: null,

	showDialog: function(){
		this.showTitle();

		$('#disable-account-dialog').on('show.bs.modal', function (event) {
			var button = $(event.relatedTarget)
		})

	},

	showTitle: function(){
		if(this.baseTitle == null){
			this.baseTitle = document.getElementById("disable-account-dialog-title").innerHTML;
		}

		if(workWithElements.selectedAccountsArr.length > 0){

			this.checkboxId = workWithElements.selectedAccountsArr[0];
			this.accountId = this.checkboxId.replace("checkbox-account-", "");

			var accountLogin = document.getElementById("accountLogin-" + this.accountId).innerHTML;

			var element = document.getElementById("disable-account-dialog-title");
			element.innerHTML = this.baseTitle + accountLogin;
		}
	},

	disableAccount: function(){

		accountsTableAddButton.addCSRFHeader();

		var accountBeanForCRUD = {}
		accountBeanForCRUD["id"] = this.accountId;

		$.ajax({
			type : "PUT",
			contentType : "application/json",
			url : "http://localhost:8080/project-one-web/personalArea/admin/api/account/disable",
			data : JSON.stringify(accountBeanForCRUD),
			dataType : 'json',
			timeout : 100000,
			success : function(data, textStatus, xhr) {

				document.getElementById("disable-account-dialog-close").click();
				workWithElements.unselectAllCheckboxes();
				workWithElements.switchAccountsTableButtons();
				workWithData.getAccountsData();
			},
			error : function(xhr, ajaxOptions, thrownError) {

				document.getElementById("disable-account-dialog-close").click();
				workWithElements.unselectAllCheckboxes();
				workWithElements.switchAccountsTableButtons();
				workWithData.getAccountsData();
			}

		});

	},


}


var accountsTableEnableButton = {

		checkboxId: null,

		accountId: null,

		baseTitle: null,

		showDialog: function(){
			this.showTitle();

			$('#enable-account-dialog').on('show.bs.modal', function (event) {
				var button = $(event.relatedTarget)
			})

		},

		showTitle: function(){
			if(this.baseTitle == null){
				this.baseTitle = document.getElementById("enable-account-dialog-title").innerHTML;
			}

			if(workWithElements.selectedAccountsArr.length > 0){

				this.checkboxId = workWithElements.selectedAccountsArr[0];
				this.accountId = this.checkboxId.replace("checkbox-account-", "");

				var accountLogin = document.getElementById("accountLogin-" + this.accountId).innerHTML;

				var element = document.getElementById("enable-account-dialog-title");
				element.innerHTML = this.baseTitle + accountLogin;
			}
		},

		enableAccount: function(){

			$.ajax({
				type : "PUT",
				contentType : "application/json",
				url : "http://localhost:8080/project-one-web/personalArea/admin/api/account/" + this.accountId + "/enable",
				dataType : 'json',
				timeout : 100000,
				success : function(data, textStatus, xhr) {

					document.getElementById("enable-account-dialog-close").click();
					workWithElements.unselectAllCheckboxes();
					workWithElements.switchAccountsTableButtons();
					workWithData.getAccountsData();
				},
				error : function(xhr, ajaxOptions, thrownError) {

					document.getElementById("enable-account-dialog-close").click();
					workWithElements.unselectAllCheckboxes();
					workWithElements.switchAccountsTableButtons();
					workWithData.getAccountsData();
				}

			});

		},

}


var accountsTableDeleteButton = {

		checkboxId: null,

		accountId: null,

		baseTitle: null,

		showDialog: function(){
			this.showTitle();

			$('#delete-account-dialog').on('show.bs.modal', function (event) {
				var button = $(event.relatedTarget)
			})

		},

		showTitle: function(){
			if(this.baseTitle == null){
				this.baseTitle = document.getElementById("delete-account-dialog-title").innerHTML;
			}

			if(workWithElements.selectedAccountsArr.length > 0){

				this.checkboxId = workWithElements.selectedAccountsArr[0];
				this.accountId = this.checkboxId.replace("checkbox-account-", "");

				var accountLogin = document.getElementById("accountLogin-" + this.accountId).innerHTML;

				var element = document.getElementById("delete-account-dialog-title");
				element.innerHTML = this.baseTitle + accountLogin;
			}
		},

		deleteAccount: function(){
			$.ajax({
				type : "DELETE",
				contentType : "application/json",
				url : "http://localhost:8080/project-one-web/personalArea/admin/api/account/" + this.accountId + "/delete",
				dataType : 'json',
				timeout : 100000,
				success : function(data, textStatus, xhr) {
					document.getElementById("delete-account-dialog-close").click();
					workWithElements.unselectAllCheckboxes();
					workWithElements.switchAccountsTableButtons();
					workWithData.getAccountsData();
				},
				error : function(xhr, ajaxOptions, thrownError) {
					document.getElementById("delete-account-dialog-close").click();
					workWithElements.unselectAllCheckboxes();
					workWithElements.switchAccountsTableButtons();
					workWithData.getAccountsData();
				}

			});

		},
}