package by.kalilaska.utilities.impls.dozer;

import java.util.ArrayList;
import java.util.List;

import org.dozer.ConfigurableCustomConverter;

import by.kalilaska.entities.forHibernate.RoleEntityHibernate;

@SuppressWarnings("rawtypes")
public class RoleEntityToRoleStatusConverter implements ConfigurableCustomConverter {

	@Override
	public Object convert(Object existingDestinationFieldValue, Object sourceFieldValue, Class<?> destinationClass,
			Class<?> sourceClass) {
		List<String> destination = new ArrayList<String>();
		List<RoleEntityHibernate> source = (List<RoleEntityHibernate>) sourceFieldValue;

		for (RoleEntityHibernate roleEntity : source) {

			destination.add(roleEntity.getRoleStatus());
		}

		return destination;
	}

	@Override
	public void setParameter(String parameter) {
		// TODO Auto-generated method stub

	}

	public List<String> convertTo(List<RoleEntityHibernate> source, List<String> destination) {
		for (RoleEntityHibernate role : source) {
			destination.add(role.getRoleStatus());
		}

		return destination;
	}

	public List<RoleEntityHibernate> convertFrom(List<String> source, List<RoleEntityHibernate> destination) {
		for (String roleName : source) {
			RoleEntityHibernate roleEntity = new RoleEntityHibernate();
			roleEntity.setRoleStatus(roleName);
			destination.add(roleEntity);
		}

		return destination;
	}

}
