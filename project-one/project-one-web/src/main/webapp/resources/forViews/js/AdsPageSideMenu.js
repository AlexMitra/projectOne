var AdsCategories = {

		checkboxesList: [],

		formSubmit: function(){

			if(this.checkboxesList.length > 0){
				document.getElementById("adsPage-categoriesForm-selected").checked = true;
				document.getElementById("adsPage-categoriesForm-clear").checked = false;
			}else{
				document.getElementById("adsPage-categoriesForm-selected").checked = false;
				document.getElementById("adsPage-categoriesForm-clear").checked = true;
			}

			document.getElementById("adsPage-categoriesForm-submit").click();
		},

		addCheckboxToList: function(checkboxId){

			var position = this.checkboxesList.indexOf(checkboxId);
			if(position < 0){
				this.checkboxesList.push(checkboxId);

			}
			this.formSubmit();
		},

		removeCheckboxFromList: function(checkboxId){
			var position = this.checkboxesList.indexOf(checkboxId);
			if(position >= 0){
				this.checkboxesList.splice(position, 1);
			}

			this.formSubmit();
		},
}
