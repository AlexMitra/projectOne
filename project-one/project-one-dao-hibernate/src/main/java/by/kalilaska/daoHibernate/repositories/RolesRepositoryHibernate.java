package by.kalilaska.daoHibernate.repositories;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import by.kalilaska.dao.forHibernate.RolesRepository;
import by.kalilaska.entities.forHibernate.RoleEntityHibernate;

@Repository
public class RolesRepositoryHibernate implements RolesRepository{	
	
	@PersistenceContext
	private EntityManager manager;
	
	public RolesRepositoryHibernate() {
		super();
	}

	//INSERT
	@Override
	public void insertRole(String role) {
		manager.persist(new RoleEntityHibernate(role));

	}
	
	//DELETE
	@Override
	public void deleteAccount(String role){		
		RoleEntityHibernate roleEntity = getAccountRoleByRoleStatus(role);
		
		if(roleEntity != null){
			manager.remove(roleEntity);
		}
	}
	
	//SELECT
	@Override
	public RoleEntityHibernate getAccountRoleById(int id) {		
		RoleEntityHibernate roleEntity = manager.find(
						RoleEntityHibernate.class, Integer.valueOf(id));

		return roleEntity;
	}	
	
	@Override
	public RoleEntityHibernate getAccountRoleByRoleStatus(String role) {		
		TypedQuery<RoleEntityHibernate> query = 
				manager.createNamedQuery("getAccountRoleByRoleStatus", RoleEntityHibernate.class);
		query.setParameter("role", role);
		RoleEntityHibernate roleEntity = query.getSingleResult();	

		return roleEntity;		
	}

}
