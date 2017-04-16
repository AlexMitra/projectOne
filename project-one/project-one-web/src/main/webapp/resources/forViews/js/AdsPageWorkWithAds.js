var adsPageDisableAd = {

		adId: null,

		baseTitle: null,

		showDialog: function(id){
			this.showTitle(id);

			$('#disable-ad-dialog').on('show.bs.modal', function (event) {
				var button = $(event.relatedTarget)
			})

		},

		showTitle: function(id){
			if(this.baseTitle == null){
				this.baseTitle = document.getElementById("ads-page-disable-ad-dialog-title").innerHTML;
			}

			this.adId = id.replace("disable-ad-", "");

			var adName = document.getElementById("ads-page-ad-" + this.adId).innerHTML;

			var element = document.getElementById("ads-page-disable-ad-dialog-title");
			element.innerHTML = this.baseTitle + adName;
		},

		disableAd: function(){

			adsTableDisableButton.addCSRFHeader();

			var adBeanForCRUD = {}
			adBeanForCRUD["adId"] = this.adId;
			adBeanForCRUD["adEnabled"] = false;

			$.ajax({
				type : "PUT",
				contentType : "application/json",
				url : "http://localhost:8080/project-one-web/personalArea/admin/api/ad/" + this.adId + "/disable",
				data : JSON.stringify(adBeanForCRUD),
				dataType : 'json',
				timeout : 100000,
				success : function(data, textStatus, xhr) {

					document.getElementById("ads-page-disable-ad-dialog-close").click();
					location.reload();

				},
				error : function(xhr, ajaxOptions, thrownError) {

					document.getElementById("ads-page-disable-ad-dialog-close").click();
					location.reload();
				}

			});

		},
}