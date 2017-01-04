package by.kalilaska.daoJDBC;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import by.kalilaska.entities.AccountToRoleEntity;

@Repository
public class AccountsToRolesJDBC {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private NamedParameterJdbcTemplate namedJdbcTemplate;
	
	@Autowired
	public void setNamedJdbcTemplate(NamedParameterJdbcTemplate namedJdbcTemplate) {
		this.namedJdbcTemplate = namedJdbcTemplate;		
	}
	
	//INSERT
	public void insertRole(int roleId, long accoundId) {		
		String sql = "insert into `Project_one`.`Accounts_to_roles`"
				+ " (`FK_Role_id`, `FK_Account_id`) VALUES (?, ?)";		
		jdbcTemplate.update(sql, new Object[]{roleId, accoundId});
	}
	
	//DELETE
	public void deleteAccount(int accountId){
		String sql = "delete from `Project_one`.`Accounts_to_roles` where"
				+ " `Accounts_to_roles`.`FK_Account_id`= ? ";
		jdbcTemplate.update(sql, accountId);		
	}
	
	//SELECT
	public AccountToRoleEntity getAccountToRoleByAccountId(long accoundId) {		
		/*String sql = "select * from `Project_one`.`Accounts_to_roles` where"
				+ " `Accounts_to_roles`.`FK_Account_id`=:AccountId";*/
		
		String sql = "select * from Project_one.Accounts_to_roles where"
				+ " Accounts_to_roles.FK_Account_id=:AccountId";
		//String sql = "select * from accounts where accounts.Login=:login";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("AccountId", accoundId);

		try {
			//Object obj = namedJdbcTemplate.queryForObject(sql, params, new AccountMapper());
			AccountToRoleEntity accountToRoleEntity = queryForObject(sql, params);
			System.out.println("obj type: " + accountToRoleEntity.getClass().getSimpleName());
			return accountToRoleEntity;
		} catch (Exception e) {
			System.out.println("exception within return in getAccountToRoleByAccountId()");
		}
		return null;
	}
	
	private AccountToRoleEntity queryForObject(String sql, MapSqlParameterSource params){
		Object obj = namedJdbcTemplate.queryForObject(sql, params, new AccountToRoleMapper());
		return (AccountToRoleEntity) obj;
	}
	
	//RowMapper
	private static class AccountToRoleMapper implements RowMapper<AccountToRoleEntity> {

		public AccountToRoleEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
			AccountToRoleEntity accountToRole = new AccountToRoleEntity();
			accountToRole.setId(rs.getLong("id"));
			accountToRole.setFkRoleId(rs.getInt("FK_Role_id"));
			accountToRole.setFkAccountId(rs.getLong("FK_Account_id"));
			
			//System.out.println("in AccountToRoleMapper\n" + accountToRole);
			return accountToRole;
		}
	}

}
