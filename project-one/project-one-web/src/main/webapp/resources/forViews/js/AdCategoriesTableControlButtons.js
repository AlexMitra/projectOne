var adCategoriesTableAddButton = {

	showDialog: function(){
		this.cleanForm();

		$('#add-adCategory-dialog').on('show.bs.modal', function (event) {
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

	addAdCategory: function () {

		this.addCSRFHeader();

		var adCategoryBeanForCRUD = {}
		adCategoryBeanForCRUD["adCategoryName"] = $("#add-adCategory-inputAdCategoryName").val();
		adCategoryBeanForCRUD["adCategoryDescription"] = $("#add-adCategory-inputAdCategoryDescription").val();
		adCategoryBeanForCRUD["adCategoryI18n"] = "adsPage.ads.categories." + $("#add-adCategory-inputAdCategoryName").val();
		adCategoryBeanForCRUD["adCategoryEnabled"] = true;

		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "http://localhost:8080/project-one-web/personalArea/admin/api/ad_category/new",
			data : JSON.stringify(adCategoryBeanForCRUD),
			dataType : 'json',
			timeout : 100000,
			success : function(data, textStatus, xhr) {
				switch (xhr.status) {
		        	case 204:
		        		workWithElements.hideElement("form-for-add-adCategory-alreadyExists-message");
		        		workWithElements.showElement("form-for-add-adCategory-valid-message");
		        		break;
		        	case 409:
		        		workWithElements.hideElement("form-for-add-adCategory-valid-message");
		        		workWithElements.showElement("form-for-add-adCategory-alreadyExists-message");
		        		break;
		        	case 201:
		        		workWithElements.hideElement("form-for-add-adCategory-valid-message");
		        		workWithElements.hideElement("form-for-add-adCategory-alreadyExists-message");
		        		adCategoriesTableAddButton.cleanForm();
		        		document.getElementById("form-for-add-adCategory-close").click();
		        		adCategoriesTable.createAdCategoriesTable(data);
		        		break;
				}
			},
			error : function(xhr, ajaxOptions, thrownError) {

				if(xhr.status == 409){
					workWithElements.hideElement("form-for-add-adCategory-valid-message");
	        		workWithElements.showElement("form-for-add-adCategory-alreadyExists-message");
				}
			}

		});


		this.cleanForm();
	},

	cleanForm: function(){
		document.getElementById("form-for-add-adCategory").reset();
		workWithElements.hideElement("form-for-add-adCategory-valid-message");
		workWithElements.hideElement("form-for-add-adCategory-alreadyExists-message");
	}
}


var adCategoriesTableEditButton = {

		checkboxId: null,

		adCategoryId: null,

		adCategoryName: null,

		adCategoryI18n: null,

		adCategoryDescription: null,

		baseTitle: null,

		showDialog: function(){
			this.showTitle();
			this.formData();

			$('#edit-adCategory-dialog').on('show.bs.modal', function (event) {
			    var button = $(event.relatedTarget)
			})
		},

		showTitle: function(){
			if(this.baseTitle == null){
				this.baseTitle = document.getElementById("edit-adCategory-dialog-title").innerHTML;
			}

			if(WorkWithAdCategoriesTableElements.selectedAdCategoriesArr.length > 0){

				this.checkboxId = WorkWithAdCategoriesTableElements.selectedAdCategoriesArr[0];
				this.adCategoryId = this.checkboxId.replace("checkbox-adCategory-", "");

				this.adCategoryName = document.getElementById("adCategoryName-" + this.adCategoryId).innerHTML;

				var element = document.getElementById("edit-adCategory-dialog-title");
				element.innerHTML = this.baseTitle + " " + this.adCategoryName;
			}
		},

		formData: function(){
			this.cleanForm();
			document.getElementById("form-for-edit-adCategory")
			.setAttribute("action", "http://localhost:8080/project-one-web/personalArea/admin/api/ad_category/" + this.adCategoryId);

			document.getElementById("edit-adCategory-inputAdCategoryName")
			.setAttribute("value", this.adCategoryName);

			this.adCategoryI18n = document.getElementById("adCategoryI18n-" + this.adCategoryId).innerHTML;
			this.adCategoryDescription = document.getElementById("adCategoryDescription-" + this.adCategoryId).innerHTML;

			document.getElementById("edit-adCategory-inputAdCategoryI18n")
			.setAttribute("value", this.adCategoryI18n);

			document.getElementById("edit-adCategory-inputAdCategoryDescription").defaultValue = this.adCategoryDescription;



		},

		editAdCategory: function () {

			adCategoriesTableAddButton.addCSRFHeader();

			var adCategoryBeanForCRUD = {}
			adCategoryBeanForCRUD["adCategoryId"] = this.adCategoryId;
			adCategoryBeanForCRUD["adCategoryName"] = $("#edit-adCategory-inputAdCategoryName").val();
			adCategoryBeanForCRUD["adCategoryDescription"] = $("#edit-adCategory-inputAdCategoryDescription").val();
			adCategoryBeanForCRUD["adCategoryI18n"] = $("#edit-adCategory-inputAdCategoryI18n").val();

			$.ajax({
				type : "PUT",
				contentType : "application/json",
				url : "http://localhost:8080/project-one-web/personalArea/admin/api/ad_category/" + this.adCategoryId,
				data : JSON.stringify(adCategoryBeanForCRUD),
				dataType : 'json',
				timeout : 100000,
				success : function(data, textStatus, xhr) {

					switch (xhr.status) {
			        	case 204:
			        		adCategoriesTableEditButton.cleanForm();
			        		workWithElements.showElement("form-for-edit-adCategory-valid-message");
			        		break;
			        	case 409:
			        		alert("exist message");
			        		adCategoriesTableEditButton.cleanForm();
			        		workWithElements.showElement("form-for-edit-adCategory-alreadyExists-message");
			        		break;
			        	case 200:
			        		adCategoriesTableEditButton.cleanForm();
			        		document.getElementById("form-for-edit-adCategory-close").click();

			        		WorkWithAdCategoriesTableElements.unselectAllCheckboxes();
			        		WorkWithAdCategoriesTableElements.switchAdCategoriesTableButtons();
			        		adCategoriesTable.createAdCategoriesTable(data);
			        		break;
					}
				},
				error : function(xhr, ajaxOptions, thrownError) {

					if(xhr.status == 409){
						alert("exist message");
						adCategoriesTableEditButton.cleanForm();
						WorkWithAdCategoriesTableElements.showElement("form-for-edit-adCategory-alreadyExists-message");

					}else if(xhr.status == 500){
						adCategoriesTableEditButton.cleanForm();
						WorkWithAdCategoriesTableElements.showElement("form-for-edit-adCategory-InternalServerError-message");
					}else{
						adCategoriesTableEditButton.cleanForm();
						document.getElementById("form-for-edit-adCategory-close").click();
						accountsTable.createAccountsTable(data);
					}

				}

			});

		},

		cleanForm: function(){
			document.getElementById("form-for-edit-adCategory").reset();
			workWithElements.hideElement("form-for-edit-adCategory-alreadyExists-message");
    		workWithElements.hideElement("form-for-edit-adCategory-valid-message");
    		//workWithElements.hideElement("form-for-edit-adCategory-InternalServerError-message");
		}
}

var adCategoriesTableDisableButton = {

	checkboxId: null,

	adCategoryId: null,

	baseTitle: null,

	showDialog: function(){
		this.showTitle();

		$('#disable-adCategory-dialog').on('show.bs.modal', function (event) {
			var button = $(event.relatedTarget)
		})

	},

	showTitle: function(){
		if(this.baseTitle == null){
			this.baseTitle = document.getElementById("disable-adCategory-dialog-title").innerHTML;
		}

		if(WorkWithAdCategoriesTableElements.selectedAdCategoriesArr.length > 0){

			this.checkboxId = WorkWithAdCategoriesTableElements.selectedAdCategoriesArr[0];
			this.adCategoryId = this.checkboxId.replace("checkbox-adCategory-", "");

			var adCategoryName = document.getElementById("adCategoryName-" + this.adCategoryId).innerHTML;

			var element = document.getElementById("disable-adCategory-dialog-title");
			element.innerHTML = this.baseTitle + adCategoryName;
		}
	},

	disableAdCategory: function(){

		adCategoriesTableAddButton.addCSRFHeader();

		var adCategoryBeanForCRUD = {}
		adCategoryBeanForCRUD["adCategoryId"] = this.adCategoryId;
		adCategoryBeanForCRUD["adCategoryEnabled"] = false;

		$.ajax({
			type : "PUT",
			contentType : "application/json",
			url : "http://localhost:8080/project-one-web/personalArea/admin/api/ad_category/" + this.adCategoryId + "/disable",
			data : JSON.stringify(adCategoryBeanForCRUD),
			dataType : 'json',
			timeout : 100000,
			success : function(data, textStatus, xhr) {

				document.getElementById("disable-adCategory-dialog-close").click();
				WorkWithAdCategoriesTableElements.unselectAllCheckboxes();
				WorkWithAdCategoriesTableElements.switchAdCategoriesTableButtons();
				workWithData.getAdCategoriesData();
			},
			error : function(xhr, ajaxOptions, thrownError) {

				document.getElementById("disable-adCategory-dialog-close").click();
				WorkWithAdCategoriesTableElements.unselectAllCheckboxes();
				WorkWithAdCategoriesTableElements.switchAdCategoriesTableButtons();
				workWithData.getAdCategoriesData();
			}

		});

	},


}


var adCategoriesTableEnableButton = {

		checkboxId: null,

		adCategoryId: null,

		baseTitle: null,

		showDialog: function(){
			this.showTitle();

			$('#enable-adCategory-dialog').on('show.bs.modal', function (event) {
				var button = $(event.relatedTarget)
			})

		},

		showTitle: function(){
			if(this.baseTitle == null){
				this.baseTitle = document.getElementById("enable-adCategory-dialog-title").innerHTML;
			}

			if(WorkWithAdCategoriesTableElements.selectedAdCategoriesArr.length > 0){

				this.checkboxId = WorkWithAdCategoriesTableElements.selectedAdCategoriesArr[0];
				this.adCategoryId = this.checkboxId.replace("checkbox-adCategory-", "");

				var adCategoryName = document.getElementById("adCategoryName-" + this.adCategoryId).innerHTML;

				var element = document.getElementById("enable-adCategory-dialog-title");
				element.innerHTML = this.baseTitle + adCategoryName;
			}
		},

		enableAdCategory: function(){

			adCategoriesTableAddButton.addCSRFHeader();

			var adCategoryBeanForCRUD = {}
			adCategoryBeanForCRUD["adCategoryId"] = this.adCategoryId;
			adCategoryBeanForCRUD["adCategoryEnabled"] = true;

			$.ajax({
				type : "PUT",
				contentType : "application/json",
				url : "http://localhost:8080/project-one-web/personalArea/admin/api/ad_category/" + this.adCategoryId + "/enable",
				data : JSON.stringify(adCategoryBeanForCRUD),
				dataType : 'json',
				timeout : 100000,
				success : function(data, textStatus, xhr) {

					document.getElementById("enable-adCategory-dialog-close").click();
					WorkWithAdCategoriesTableElements.unselectAllCheckboxes();
					WorkWithAdCategoriesTableElements.switchAdCategoriesTableButtons();
					workWithData.getAdCategoriesData();
				},
				error : function(xhr, ajaxOptions, thrownError) {

					document.getElementById("enable-adCategory-dialog-close").click();
					WorkWithAdCategoriesTableElements.unselectAllCheckboxes();
					WorkWithAdCategoriesTableElements.switchAdCategoriesTableButtons();
					workWithData.getAdCategoriesData();
				}

			});

		},

}


var adCategoriesTableDeleteButton = {

		checkboxId: null,

		adCategoryId: null,

		baseTitle: null,

		showDialog: function(){
			this.showTitle();

			$('#delete-adCategory-dialog').on('show.bs.modal', function (event) {
				var button = $(event.relatedTarget)
			})

		},

		showTitle: function(){
			if(this.baseTitle == null){
				this.baseTitle = document.getElementById("delete-adCategory-dialog-title").innerHTML;
			}

			if(WorkWithAdCategoriesTableElements.selectedAdCategoriesArr.length > 0){

				this.checkboxId = WorkWithAdCategoriesTableElements.selectedAdCategoriesArr[0];
				this.adCategoryId = this.checkboxId.replace("checkbox-adCategory-", "");

				var adCategoryName = document.getElementById("adCategoryName-" + this.adCategoryId).innerHTML;

				var element = document.getElementById("delete-adCategory-dialog-title");
				element.innerHTML = this.baseTitle + adCategoryName;
			}
		},

		deleteAdCategory: function(){
			$.ajax({
				type : "DELETE",
				contentType : "application/json",
				url : "http://localhost:8080/project-one-web/personalArea/admin/api/ad_category/" + this.adCategoryId,
				dataType : 'json',
				timeout : 100000,
				success : function(data, textStatus, xhr) {
					document.getElementById("delete-adCategory-dialog-close").click();
					WorkWithAdCategoriesTableElements.unselectAllCheckboxes();
					WorkWithAdCategoriesTableElements.switchAdCategoriesTableButtons();
					workWithData.getAdCategoriesData();
				},
				error : function(xhr, ajaxOptions, thrownError) {
					document.getElementById("delete-adCategory-dialog-close").click();
					WorkWithAdCategoriesTableElements.unselectAllCheckboxes();
					WorkWithAdCategoriesTableElements.switchAdCategoriesTableButtons();
					workWithData.getAdCategoriesData();
				}

			});

		},
}