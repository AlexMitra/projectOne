package by.kalilaska.utilities.impls.dozer;

import java.util.List;

import org.dozer.DozerConverter;

import by.kalilaska.entities.forHibernate.RoleEntityHibernate;

@SuppressWarnings("rawtypes")
public class RoleEntityToRoleStatusConverter2 extends DozerConverter<List<RoleEntityHibernate>, List<String>> {

	public RoleEntityToRoleStatusConverter2(Class<List<RoleEntityHibernate>> prototypeA,
			Class<List<String>> prototypeB) {
		super(prototypeA, prototypeB);
		// TODO Auto-generated constructor stub
	}

	private List<RoleEntityHibernate> roleList;
	private List<String> nameList;

	// public RoleEntityToRoleStatusConverter() {
	// super((List<RoleEntityHibernate>) List.class, (List<String>) List.class);
	// // TODO Auto-generated constructor stub
	// }

	@Override
	public List<String> convertTo(List<RoleEntityHibernate> source, List<String> destination) {
		for (RoleEntityHibernate role : source) {
			destination.add(role.getRoleStatus());
		}

		return destination;
	}

	@Override
	public List<RoleEntityHibernate> convertFrom(List<String> source, List<RoleEntityHibernate> destination) {
		for (String roleName : source) {
			RoleEntityHibernate roleEntity = new RoleEntityHibernate();
			roleEntity.setRoleStatus(roleName);
			destination.add(roleEntity);
		}

		return destination;
	}

}
