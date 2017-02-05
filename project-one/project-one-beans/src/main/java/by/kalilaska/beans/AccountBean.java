package by.kalilaska.beans;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;


@Component
@Getter
@Setter
public class AccountBean {	

	private long accountId;

	private String accountLogin;

	private String accountEmail;

	private String accountPassword;	

	private String accountRole;

	public AccountBean() {
	
	}

	@Override
	public String toString() {
		return "AccountBean [accountId=" + accountId + ", accountLogin=" + accountLogin + ", accountEmail="
				+ accountEmail + ", accountPassword=" + accountPassword + ", accountRole=" + accountRole + "]";
	}	

}
