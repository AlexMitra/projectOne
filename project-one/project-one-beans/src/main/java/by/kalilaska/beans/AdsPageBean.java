package by.kalilaska.beans;

import java.util.ArrayList;
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

	private List<Long> selectedCategorues;

	private List<AdBean> allAds;

	public AdsPageBean() {
		super();
		selectedCategorues = new ArrayList<>();
	}

	public boolean isCategorySelected(long categoryId) {

		if (selectedCategorues == null) {
			return false;
		}

		if (selectedCategorues.contains(categoryId)) {
			return true;
		}
		return false;
	}

	public void addCategoryToSelectedCategories(long categoryId) {
		selectedCategorues.add(categoryId);
		System.out.println(selectedCategorues);
	}

	public void removeCategoryFromSelectedCategories(long categoryId) {
		selectedCategorues.remove(categoryId);
	}

	@Override
	public String toString() {
		return "AdsPageBean [pageNumber=" + pageNumber + ", adsNumberOnPage=" + adsNumberOnPage + ", lastPage="
				+ lastPage + ", allAdCategories=" + allAdCategories + ", selectedCategorues=" + selectedCategorues
				+ "]";
	}

}
