var WorkWithAdCategoriesTableElements = {

	selectedAdCategoriesArr : [],

	hideElement : function(id) {
		if (document.getElementById(id)) {
			var element = document.getElementById(id);
			if (element.style.display != "none") {
				element.style.display = "none";
			}
		}
	},

	showElement : function(id) {
		if (document.getElementById(id)) {
			var element = document.getElementById(id);
			if (element.style.display != "block") {
				element.style.display = "block";
			}
		}
	},

	selectCheckbox : function(id) {

		document.getElementById(id).checked = true;
		var i = this.containCheckboxId(id);
		if (i == -1) {
			this.selectedAdCategoriesArr.push(id);
		}
	},

	unselectCheckbox : function(id) {

		document.getElementById(id).checked = false;

		var i = this.containCheckboxId(id);
		if (i >= 0) {
			this.selectedAdCategoriesArr.splice(i, 1);
		}
	},

	switchCheckbox : function(id) {

		if (document.getElementById(id).checked == true) {
			this.unselectCheckbox(id);
		} else {
			this.selectCheckbox(id);
		}
	},

	containCheckboxId : function(id) {
		for (var i = 0; i < this.selectedAdCategoriesArr.length; i++) {
			if (this.selectedAdCategoriesArr[i].toLowerCase() === id.toLowerCase()) {
				return i;
			}
		}
		return -1;
	},

	unselectAllCheckboxes : function() {

		for (var i = 0; this.selectedAdCategoriesArr.length > 0;) {
			document.getElementById(this.selectedAdCategoriesArr[i]).checked = false;
			this.selectedAdCategoriesArr.shift();

		}
		this.switchAdCategoriesTableButtons();
	},

	switchAdCategoriesTableButtons : function() {
		if (this.selectedAdCategoriesArr.length > 0 && adCategoriesEnabledDisabledToggle.categoriesToggle) {
			document.getElementById("unselect-all-adCategories-button").disabled = false;
			document.getElementById("update-adCategory-button").disabled = false;
			document.getElementById("disable-adCategory-button").disabled = false;
		} else if (this.selectedAdCategoriesArr.length <= 0){
			document.getElementById("unselect-all-adCategories-button").disabled = true;
			document.getElementById("update-adCategory-button").disabled = true;
			document.getElementById("disable-adCategory-button").disabled = true;
			document.getElementById("enable-adCategory-button").disabled = true;
			document.getElementById("delete-adCategory-button").disabled = true;
		} else if (this.selectedAdCategoriesArr.length > 0 && adCategoriesEnabledDisabledToggle.categoriesToggle == false){
			document.getElementById("enable-adCategory-button").disabled = false;
			document.getElementById("delete-adCategory-button").disabled = false;
		}
	}
}