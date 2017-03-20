package by.kalilaska.beans;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class AdCategoryBean {
	private long adCategoryId;

	private String adCategoryName;

	private boolean adCategoryEnabled;

	public AdCategoryBean() {
		super();

	}

	@Override
	public String toString() {
		return "AdCategoryBean [adCategoryId=" + adCategoryId + ", adCategoryName=" + adCategoryName
				+ ", adCategoryEnabled=" + adCategoryEnabled + "]";
	}

}
