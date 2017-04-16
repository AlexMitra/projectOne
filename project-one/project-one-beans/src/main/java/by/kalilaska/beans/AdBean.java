package by.kalilaska.beans;

import java.text.SimpleDateFormat;
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

	private String adMaker;

	public String getFormatDate() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		return dateFormat.format(adCreationDate);
	}

	@Override
	public String toString() {
		return "AdBean [adId=" + adId + ", adName=" + adName + ", adDescription=" + adDescription + ", adCreationDate="
				+ adCreationDate + ", adEnabled=" + adEnabled + ", adMaker=" + adMaker + "]";
	}

}
