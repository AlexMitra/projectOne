package by.kalilaska.services.impls;

import java.util.List;

import org.springframework.stereotype.Service;

import by.kalilaska.daoHibernate.repositories.springData.RolesRepositoryData;
import by.kalilaska.entities.forHibernate.RoleEntityHibernate;
import by.kalilaska.services.RoleService;

@Service
public class RoleServiceBySD implements RoleService {

	private RolesRepositoryData rolesRepository;

	public RoleServiceBySD() {
		super();

	}

	@Override
	public List<RoleEntityHibernate> findAllRoles() {
		return rolesRepository.findAll();
	}

}
