package by.kalilaska.beans;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class HomePageBean {

	private List<AdBean> Ads;

	private long firstAdId;

	private int slideNumber;

	public HomePageBean() {

	}

	public void insertAdList(List<AdBean> Ads) {
		if (Ads != null || Ads.size() > 0) {
			this.Ads = Ads;
			// firstAdId = Ads.get(0).getAdId();
		}

	}

	public int getNextSlide() {
		return slideNumber++;
	}

	@Override
	public String toString() {
		return "HomePageBean [Ads=" + Ads + ", firstAdId=" + firstAdId + "]";
	}

}
