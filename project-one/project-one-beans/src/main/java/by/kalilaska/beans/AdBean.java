package by.kalilaska.beans;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Component
public class AdBean {

	private long adId;

	private String adName;

	private String adDescription;

	private Date adCreationDate;

	private boolean adEnabled;

	@Override
	public String toString() {
		return "AdBean [adId=" + adId + ", adName=" + adName + ", adDescription=" + adDescription + ", adCreationDate="
				+ adCreationDate + ", adEnabled=" + adEnabled + "]";
	}

	// private AdCategoryBean adCategory;
	//
	//
	// private AccountBean adMaker;

}
