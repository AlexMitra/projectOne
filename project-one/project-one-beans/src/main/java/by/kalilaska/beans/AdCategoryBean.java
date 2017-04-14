package by.kalilaska.beans;

import javax.validation.constraints.Pattern;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class AdCategoryBean {
	private long adCategoryId;

	@Pattern(regexp = "^[a-zA-Z_0-9]{2,20}$")
	private String adCategoryName;

	// @Pattern(regexp = "^[a-zA-Z_0-9]{5,100}$")
	private String adCategoryDescription;

	@Pattern(regexp = "^[a-zA-Z_0-9\\.]{5,50}$")
	private String adCategoryI18n;

	private boolean adCategoryEnabled;

	public AdCategoryBean() {
		super();

	}

	@Override
	public String toString() {
		return "AdCategoryBean [adCategoryId=" + adCategoryId + ", adCategoryName=" + adCategoryName
				+ ", adCategoryDescription=" + adCategoryDescription + ", adCategoryI18n=" + adCategoryI18n
				+ ", adCategoryEnabled=" + adCategoryEnabled + "]";
	}

}
