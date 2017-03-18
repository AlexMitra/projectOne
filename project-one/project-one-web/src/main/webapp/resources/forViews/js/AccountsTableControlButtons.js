var accountsTableAddButton = {

	showForm: function(){

		$('#add-account-button').on('show.bs.modal', function (event) {
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