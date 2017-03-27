var accountEnabledDisabledToggle = {
		toggleEnabled: function(){
			workWithData.getAccountsData();

			workWithElements.hideElement("disabled-accounts-control-buttons");
			workWithElements.showElement("enabled-accounts-control-buttons");

			workWithElements.unselectAllCheckboxes();
		},

		toggleDisabled: function(){
			workWithData.getAccountsData();

			workWithElements.showElement("disabled-accounts-control-buttons");
			workWithElements.hideElement("enabled-accounts-control-buttons");

			workWithElements.unselectAllCheckboxes();
		}
}