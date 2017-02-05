package by.kalilaska.utilities.impls.dozer;
import org.dozer.DozerConverter;
import by.kalilaska.entities.forHibernate.RoleEntityHibernate;

@SuppressWarnings("rawtypes")
public class RoleEntityToRoleStatusConverter extends DozerConverter<RoleEntityHibernate, String> {

	public RoleEntityToRoleStatusConverter() {
		super(RoleEntityHibernate.class, String.class);
	}

	@Override
	public String convertTo(RoleEntityHibernate source, String destination) {
		String roleStatus = source.getRoleStatus();
		return roleStatus;
	}

	@Override
	public RoleEntityHibernate convertFrom(String source, RoleEntityHibernate destination) {
		RoleEntityHibernate roleEntity = new RoleEntityHibernate();
		roleEntity.setRoleStatus(source);
		return roleEntity;
	}
}
