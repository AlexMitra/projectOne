package by.kalilaska.entities.forHibernate;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Ads")
@Getter
@Setter
public class AdEntityHibernate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Ad_Id")
	private long id;
	
	@Column(name = "Ad_name")
	private String name;
	
	@Column(name = "Ad_description")
	private String description;
	
	@Column(name = "Ad_creation_date", columnDefinition = "DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creattionDate;
	
	@Column(name = "Ad_enabled")
	private boolean enabled;
	
	@ManyToOne
	@JoinTable(name = "Ads_to_categories",
		joinColumns = @JoinColumn(name = "Ads_to_categories_FK_Ad_id", 
		referencedColumnName = "Ad_Id"), 
		inverseJoinColumns = @JoinColumn(name = "Ads_to_categories_FK_Category_id", 
		referencedColumnName = "Category_Id"))
	private AdCategoryEntityHibernate adCategory;
	
	@ManyToOne
	@JoinTable(name = "Ads_to_аccounts", 
		joinColumns = @JoinColumn(name = "Ads_to_аccounts_FK_Ad_id", 
		referencedColumnName = "Ad_Id"), 
		inverseJoinColumns = @JoinColumn(name = "Ads_to_аccounts_FK_Account_id", 
		referencedColumnName = "Account_Id"))
	private AccountEntityHibernate adMaker;

	public AdEntityHibernate() {
		super();		
	}

	@Override
	public String toString() {
		return "AdEntityHibernate [id=" + id + ", name=" + name + ", description=" + description + ", creattionDate="
				+ creattionDate + ", enabled=" + enabled + "]";
	}

}
