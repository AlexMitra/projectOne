$(document).ready(function() {
	$('#allAccounts').click(function(){
		$.ajax({
			type: "GET",
			url: "http://localhost:8080/project-one-web/personalArea/admin/api/allAccounts",
			dataType : "json",			
			success: function(data){			    
				hideElement("personal-info");
			    showElement("accounts");
			    createAccountsData(data);
			}
		})
    });	  
});

function hideElement(id){
	if (document.getElementById(id)) {
		var element = document.getElementById(id);
		if (element.style.display != "none") {
			element.style.display = "none";
		}
	}	
}

function showElement(id){
	if (document.getElementById(id)) {
		var element = document.getElementById(id);
		if (element.style.display != "block") {
			element.style.display = "block";		
		}
	}	
}

function createAccountsData(data){	
	var str = '';
	for(var i in data){		
		str += '<tr>';
		str += '<td>' + data[i].accountId + '</td>';
		str += '<td>' + data[i].accountLogin + '</td>';
		str += '<td>' + data[i].accountEmail + '</td>';
		str += '<td>' + data[i].accountPassword + '</td>';
		str += '<td>' + data[i].accountRole + '</td>';
		str +='</tr>';
	}	
	document.getElementById("accounts-data").innerHTML = str;
}