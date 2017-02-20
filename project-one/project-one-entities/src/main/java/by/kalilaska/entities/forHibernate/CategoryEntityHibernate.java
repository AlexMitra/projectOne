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
public class CategoryEntityHibernate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Category_Id")
	private long id;
	
	@Column(name = "Category_name")
	private String name;
	
	@Column(name = "Category_description")
	private String description;
	
	@Column(name = "Category_enabled")
	private boolean enabled;
	
	@OneToMany(targetEntity = AdEntityHibernate.class,  mappedBy = "adCategory", 
			fetch = FetchType.LAZY)
	private List<AdEntityHibernate> AdsList;

	public CategoryEntityHibernate() {
		super();		
	}

	@Override
	public String toString() {
		return "CategoryEntityHibernate [id=" + id + ", name=" + name + ", description=" + description + ", enabled="
				+ enabled + "]";
	}	

}
