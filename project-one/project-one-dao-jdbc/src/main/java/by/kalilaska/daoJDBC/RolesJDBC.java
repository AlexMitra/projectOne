package by.kalilaska.daoJDBC;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import by.kalilaska.EntitiesPool;
import by.kalilaska.entities.AccountRoleEntity;

@Repository
public class RolesJDBC {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;	
	
	private NamedParameterJdbcTemplate namedJdbcTemplate;
	
	@Autowired
	public void setNamedJdbcTemplate(NamedParameterJdbcTemplate namedJdbcTemplate) {
		this.namedJdbcTemplate = namedJdbcTemplate;		
	}
	
	//INSERT
	public void insertRole(String role) {		
		String sql = "insert into `Project_one`.`Roles` (`Role`) VALUES (?)";		
		jdbcTemplate.update(sql, role);
	}
	
	//DELETE
	public void deleteAccount(String role){
		String sql = "delete from `Project_one`.`Roles` where `Roles`.`Role`= ? ";
		jdbcTemplate.update(sql, role);		
	}
	
	//SELECT
	public AccountRoleEntity getAccountRoleById(int id) {		
		String sql = "select * from `Project_one`.`Roles` where `Roles`.`Id`=:Id";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("Id", id);

		try {
			//Object obj = namedJdbcTemplate.queryForObject(sql, params, new AccountMapper());
			AccountRoleEntity accountRoleEntity = queryForObject(sql, params);
			System.out.println("obj type: " + accountRoleEntity.getClass().getSimpleName());
			return accountRoleEntity;
		} catch (Exception e) {
			System.out.println("exception within return in getAccountRoleById()");
		}
		return null;
	}
	
	private AccountRoleEntity queryForObject(String sql, MapSqlParameterSource params){
		Object obj = namedJdbcTemplate.queryForObject(sql, params, new AccountRoleMapper());
		return (AccountRoleEntity) obj;
	}
	
	//RowMapper
	private static class AccountRoleMapper implements RowMapper<AccountRoleEntity> {

		public AccountRoleEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
			AccountRoleEntity role = new AccountRoleEntity();
			role.setRoleId(rs.getInt("id"));
			role.setRoleRole(rs.getString("Role"));	
			
			//System.out.println("in AccountRoleMapper\n" + role);
			return role;
		}
	}

}
