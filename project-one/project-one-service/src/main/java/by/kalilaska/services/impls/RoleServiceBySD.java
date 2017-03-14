package by.kalilaska.services.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.kalilaska.beans.RoleBean;
import by.kalilaska.daoHibernate.repositories.springData.RolesRepositoryData;
import by.kalilaska.entities.forHibernate.RoleEntityHibernate;
import by.kalilaska.services.RoleService;
import by.kalilaska.utilities.EntityToBeanConverter;

@Service
public class RoleServiceBySD implements RoleService {

	@Autowired
	private EntityToBeanConverter entityToBeanConverter;

	@Autowired
	private RolesRepositoryData rolesRepository;

	public RoleServiceBySD() {
		super();

	}

	@Transactional
	@Override
	public RoleEntityHibernate findByRoleStatus(String role) {
		return rolesRepository.findByRoleStatus(role);
	}

	@Transactional
	@Override
	public List<RoleEntityHibernate> findAllRoles() {
		return rolesRepository.findAll();
	}

	@Override
	public List<RoleBean> findAllRoleNames() {

		List<RoleEntityHibernate> roleEntityList = findAllRoles();
		List<RoleBean> roleBeanList = entityToBeanConverter.convertToBeanList(roleEntityList, RoleBean.class);

		return roleBeanList;
	}

}
