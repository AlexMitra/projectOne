package by.kalilaska.beans;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class AdsPageBean {

	private int pageNumber = 0;

	private int adsNumberOnPage = 18;

	private boolean lastPage = false;

	private List<AdCategoryBean> allAdCategories;

	private List<AdBean> allAds;

	public AdsPageBean() {
		super();
		// TODO Auto-generated constructor stub
	}

}
