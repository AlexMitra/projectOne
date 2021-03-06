var accountEnabledDisabledToggle = {
		accountsToggle: true,

		toggleEnabled: function(){
			this.accountsToggle = true;
			workWithData.getAccountsData();

			workWithElements.hideElement("disabled-accounts-control-buttons");
			workWithElements.showElement("enabled-accounts-control-buttons");

			workWithElements.unselectAllCheckboxes();
		},

		toggleDisabled: function(){
			this.accountsToggle = false;
			workWithData.getAccountsData();

			workWithElements.showElement("disabled-accounts-control-buttons");
			workWithElements.hideElement("enabled-accounts-control-buttons");

			workWithElements.unselectAllCheckboxes();
		}
}


var adCategoriesEnabledDisabledToggle = {
		categoriesToggle: true,

		toggleEnabled: function(){
			this.categoriesToggle = true;
			workWithData.getAdCategoriesData();

			workWithElements.hideElement("disabled-adCategories-control-buttons");
			workWithElements.showElement("enabled-adCategories-control-buttons");

			WorkWithAdCategoriesTableElements.unselectAllCheckboxes();
		},

		toggleDisabled: function(){
			this.categoriesToggle = false;
			workWithData.getAdCategoriesData();

			workWithElements.showElement("disabled-adCategories-control-buttons");
			workWithElements.hideElement("enabled-adCategories-control-buttons");

			WorkWithAdCategoriesTableElements.unselectAllCheckboxes();
		}
}


var adsEnabledDisabledToggle = {
		adsToggle: true,

		toggleEnabled: function(){
			this.adsToggle = true;
			workWithData.getAdsData();

			workWithElements.hideElement("disabled-ads-control-buttons");
			workWithElements.showElement("enabled-ads-control-buttons");

			WorkWithAdsTableElements.unselectAllCheckboxes();
		},

		toggleDisabled: function(){
			this.adsToggle = false;
			workWithData.getAdsData();

			workWithElements.showElement("disabled-ads-control-buttons");
			workWithElements.hideElement("enabled-ads-control-buttons");

			WorkWithAdsTableElements.unselectAllCheckboxes();
		}
}