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