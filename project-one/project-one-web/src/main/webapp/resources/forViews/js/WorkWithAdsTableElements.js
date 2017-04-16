var WorkWithAdsTableElements = {

	selectedAdsArr : [],

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
			this.selectedAdsArr.push(id);
		}
	},

	unselectCheckbox : function(id) {

		document.getElementById(id).checked = false;

		var i = this.containCheckboxId(id);
		if (i >= 0) {
			this.selectedAdsArr.splice(i, 1);
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
		for (var i = 0; i < this.selectedAdsArr.length; i++) {
			if (this.selectedAdsArr[i].toLowerCase() === id.toLowerCase()) {
				return i;
			}
		}
		return -1;
	},

	unselectAllCheckboxes : function() {

		for (var i = 0; this.selectedAdsArr.length > 0;) {
			document.getElementById(this.selectedAdsArr[i]).checked = false;
			this.selectedAdsArr.shift();

		}
		this.switchAdsTableButtons();
	},

	switchAdsTableButtons : function() {
		if (this.selectedAdsArr.length > 0 && adsEnabledDisabledToggle.adsToggle) {
			document.getElementById("unselect-all-ads-button").disabled = false;
			document.getElementById("update-ad-button").disabled = false;
			document.getElementById("disable-ad-button").disabled = false;
		} else if (this.selectedAdsArr.length <= 0){
			document.getElementById("unselect-all-ads-button").disabled = true;
			document.getElementById("update-ad-button").disabled = true;
			document.getElementById("disable-ad-button").disabled = true;
			document.getElementById("enable-ad-button").disabled = true;
			document.getElementById("delete-ad-button").disabled = true;
		} else if (this.selectedAdsArr.length > 0 && adsEnabledDisabledToggle.categoriesToggle == false){
			document.getElementById("enable-ad-button").disabled = false;
			document.getElementById("delete-ad-button").disabled = false;
		}
	}
}