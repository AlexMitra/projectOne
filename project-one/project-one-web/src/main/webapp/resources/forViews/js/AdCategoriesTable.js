var adCategoriesTable = {
		createAdCategoriesTable : function(data) {
		var str = '';

		for (var i in data) {

			str += '<tr id = "adCategory-'
					+ data[i].adCategoryId
					+ '" class="linkrow" onclick="workWithAdCategoriesTable.selectAdCategory(this.id)">';

			str += '<td><div class="checkbox"><label><input type="checkbox" id="checkbox-adCategory-'
					+ data[i].adCategoryId
					+ '" onclick = "workWithAdCategoriesTable.selectAdCategory(this.id)" unchecked></label></div></td>';
			str += '<td>' + data[i].adCategoryId + '</td>';
			str += '<td id="adCategoryName-' + data[i].adCategoryId + '">' + data[i].adCategoryName + '</td>';
			if(data[i].adCategoryDescription == null || data[i].adCategoryDescription.length == 0){
				str += '<td id="adCategoryDescription-' + data[i].adCategoryId + '"> - </td>';
			}else{
				str += '<td id="adCategoryDescription-' + data[i].adCategoryId + '">' + data[i].adCategoryDescription + '</td>';
			}


			str += '<td id="adCategoryI18n-' + data[i].adCategoryId + '">' + data[i].adCategoryI18n + '</td>';
			str += '<td>' + data[i].adCategoryEnabled + '</td>';
			str += '</tr>';
		}
		document.getElementById("adCategories-data").innerHTML = str;
	}

}

var workWithAdCategoriesTable = {
	selectAdCategory : function(id) {
		if (id.search("checkbox-") == -1) {
			id = "checkbox-" + id;
		}
		WorkWithAdCategoriesTableElements.switchCheckbox(id);
		WorkWithAdCategoriesTableElements.switchAdCategoriesTableButtons();
	},

	unselectAll : function() {
		WorkWithAdCategoriesTableElements.switchAdCategoriesTableButtons();
	}
}