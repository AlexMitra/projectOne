var workWithElements = {
	//selectedAccountsCounter : 0,
	selectedAccountsArr : [],

	// logout : function() {
	// var form = document.getElementById("my-logout-form");
	// document.getElementById("my-logout-form-button").addEventListener(
	// "click", function() {
	// form.submit();
	// })
	// },

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
			//this.selectedAccountsCounter++;
			this.selectedAccountsArr.push(id);
		}
	},

	unselectCheckbox : function(id) {

		document.getElementById(id).checked = false;
		//this.selectedAccountsCounter--;
		var i = this.containCheckboxId(id);
		if (i >= 0) {
			this.selectedAccountsArr.splice(i, 1);
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
		for (var i = 0; i < this.selectedAccountsArr.length; i++) {
			if (this.selectedAccountsArr[i].toLowerCase() === id.toLowerCase()) {
				return i;
			}
		}
		return -1;
	},

	unselectAllCheckboxes : function() {

		for (var i = 0; this.selectedAccountsArr.length > 0;) {
			document.getElementById(this.selectedAccountsArr[i]).checked = false;
			//this.selectedAccountsCounter--;
			this.selectedAccountsArr.shift();

		}
		this.switchAccountsTableButtons();
	},

	switchAccountsTableButtons : function() {
		if (this.selectedAccountsArr.length > 0 && accountEnabledDisabledToggle.accountsToggle) {
			document.getElementById("unselect-all-account-button").disabled = false;
			document.getElementById("update-account-button").disabled = false;
			document.getElementById("disable-account-button").disabled = false;
		} else if (this.selectedAccountsArr.length <= 0){
			document.getElementById("unselect-all-account-button").disabled = true;
			document.getElementById("update-account-button").disabled = true;
			document.getElementById("disable-account-button").disabled = true;
			document.getElementById("enable-account-button").disabled = true;
			document.getElementById("delete-account-button").disabled = true;
		} else if (this.selectedAccountsArr.length > 0 && accountEnabledDisabledToggle.accountsToggle== false){
			document.getElementById("enable-account-button").disabled = false;
			document.getElementById("delete-account-button").disabled = false;
		}
	}
}