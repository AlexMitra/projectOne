var adsTable = {
		createAdsTable : function(data) {
		var str = '';

		for (var i in data) {

			str += '<tr id = "ad-'
					+ data[i].adId
					+ '" class="linkrow" onclick="workWithAdsTable.selectAd(this.id)">';

			str += '<td><div class="checkbox"><label><input type="checkbox" id="checkbox-ad-'
					+ data[i].adId
					+ '" onclick = "workWithAdsTable.selectAd(this.id)" unchecked></label></div></td>';
			str += '<td>' + data[i].adId + '</td>';
			str += '<td id="adName-' + data[i].adId + '">' + data[i].adName + '</td>';
			if(data[i].adDescription == null || data[i].adDescription.length == 0){
				str += '<td id="adDescription-' + data[i].adId + '"> - </td>';
			}else if(data[i].adDescription.length > 50){
				str += '<td id="adDescription-' + data[i].adId + '">' + data[i].adDescription.slice(0, 50)  + '...' + '</td>';
			}else{
				str += '<td id="adDescription-' + data[i].adId + '">' + data[i].adDescription + '</td>';
			}

			str += '<td id="adCreationDate-' + data[i].adId + '">' + data[i].formatDate + '</td>';
			str += '<td id="adAuthor-' + data[i].adId + '">' + data[i].adMaker + '</td>';
			str += '<td>' + data[i].adEnabled + '</td>';
			str += '</tr>';
		}
		document.getElementById("ads-data").innerHTML = str;
	}

}

var workWithAdsTable = {
	selectAd : function(id) {
		if (id.search("checkbox-") == -1) {
			id = "checkbox-" + id;
		}
		WorkWithAdsTableElements.switchCheckbox(id);
		WorkWithAdsTableElements.switchAdsTableButtons();
	},

	unselectAll : function() {
		WorkWithAdsTableElements.switchAdsTableButtons();
	}
}