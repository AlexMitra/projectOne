package by.kalilaska.entities.forHibernate;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Categories")
@Getter
@Setter
public class AdCategoryEntityHibernate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Category_Id")
	private long adCategoryId;

	@Column(name = "Category_name")
	private String adCategoryName;

	@Column(name = "Category_description")
	private String adCategoryDescription;

	@Column(name = "Category_enabled")
	private boolean adCategoryEnabled;

	@OneToMany(targetEntity = AdEntityHibernate.class, mappedBy = "adCategory", fetch = FetchType.LAZY)
	private List<AdEntityHibernate> AdsList;

	public AdCategoryEntityHibernate() {
		super();
	}

	@Override
	public String toString() {
		return "AdCategoryEntityHibernate [adCategoryId=" + adCategoryId + ", adCategoryName=" + adCategoryName
				+ ", adCategoryDescription=" + adCategoryDescription + ", adCategoryEnabled=" + adCategoryEnabled + "]";
	}

}
