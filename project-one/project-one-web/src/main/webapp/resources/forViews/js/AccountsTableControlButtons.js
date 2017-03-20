var accountsTableAddButton = {

	showForm: function(){

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
	}
}

var accountsTableDisableButton = {

	checkboxId: null,

	accountId: null,

	showDialog: function(){
		this.showTitle();

		$('#disable-account-dialog').on('show.bs.modal', function (event) {
			var button = $(event.relatedTarget)
		})

	},

	showTitle: function(){

		if(workWithElements.selectedAccountsArr.length > 0){

			this.checkboxId = workWithElements.selectedAccountsArr[0];
			this.accountId = this.checkboxId.replace("checkbox-account-", "");

			var accountLogin = document.getElementById("accountLogin-" + this.accountId).innerHTML;

			var element = document.getElementById("disable-account-dialog-title");
			element.innerHTML = element.innerHTML + accountLogin;
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