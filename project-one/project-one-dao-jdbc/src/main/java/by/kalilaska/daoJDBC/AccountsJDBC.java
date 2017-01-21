package by.kalilaska.daoJDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import by.kalilaska.entities.impls.AccountEntity;
import by.kalilaska.utils.SqlRequestUpdater;


@Repository
public class AccountsJDBC {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;	
	
	private NamedParameterJdbcTemplate namedJdbcTemplate;
	
	@Autowired
	public void setNamedJdbcTemplate(NamedParameterJdbcTemplate namedJdbcTemplate) {
		this.namedJdbcTemplate = namedJdbcTemplate;		
	}
	
	//INSERT
	public void insertAccount(String login, String email, String password) {		
		String sql = "insert into accounts (`Login`, `Email`, `Password`) VALUES (?, ?, ?)";		
		jdbcTemplate.update(sql, new Object[]{login, email, password});
	}
	
	//INSERT WITH RETURN
	public AccountEntity insertAccountWithReturn(String login, String email, String password) {		
		String sql = "insert into accounts (`Login`, `Email`, `Password`) VALUES (?, ?, ?)";		
		jdbcTemplate.update(sql, new Object[]{login, email, password});
		
		return getAccountByLogin(login);
	}
	
	//DELETE
	public void deleteAccount(String login){
		String sql = "delete from accounts where accounts.Login= ? ";
		jdbcTemplate.update(sql, login);
		//deleteAccount(account.getAccountLogin());
	}
	
	//SELECT
	public AccountEntity getAccountByLogin(String login) {		
		String sql = "select * from accounts where accounts.Login=:login";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("login", login);		

		try {
			//Object obj = namedJdbcTemplate.queryForObject(sql, params, new AccountMapper());
			AccountEntity accountEntity = queryForObject(sql, params);
			System.out.println("obj type: " + accountEntity.getClass().getSimpleName());
			return accountEntity;
		} catch (Exception e) {
			System.out.println("exception within return in getAccountByLogin()");
		}

		return null;
	}
	
	public AccountEntity getAccountByEmail(String email) {		
		String sql = "select * from accounts where accounts.Email=:Email";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("Email", email);

		try {
			//Object obj = namedJdbcTemplate.queryForObject(sql, params, new AccountMapper());
			AccountEntity accountEntity = queryForObject(sql, params);
			System.out.println("obj type: " + accountEntity.getClass().getSimpleName());
			return accountEntity;
		} catch (Exception e) {
			System.out.println("exception within return in getAccountByEmail()");
		}

		return null;
	}
	
	public AccountEntity getAccountById(long id) {
		String sql = "select * from accounts where accounts.Id=:Id";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("Id", id);

		try {
			//Object obj = namedJdbcTemplate.queryForObject(sql, params, new AccountMapper());
			AccountEntity accountEntity = queryForObject(sql, params);
			System.out.println("obj type: " + accountEntity.getClass().getSimpleName());
			return accountEntity;
		} catch (Exception e) {
			System.out.println("exception within return in getAccountById()");
		}

		return null;
	}
	
	public AccountEntity getAccount(String login, String email, String password) {		
		String sql = "select * from accounts where accounts.`Login`=:login and "
				+ "accounts.`Email`=:email and accounts.`Password`=:password";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("login", login);
		params.addValue("email", email);
		params.addValue("password", password);

		try {
			//Object obj = namedJdbcTemplate.queryForObject(sql, params, new AccountMapper());
			AccountEntity accountEntity = queryForObject(sql, params);
			System.out.println("obj type: " + accountEntity.getClass().getSimpleName());
			return accountEntity;
		} catch (Exception e) {
			System.out.println("exception within return in getAccountByLogin()");
		}

		return null;
	}
	
	private AccountEntity queryForObject(String sql, MapSqlParameterSource params){
		Object obj = namedJdbcTemplate.queryForObject(sql, params, new AccountMapper());
		return (AccountEntity) obj;
	}
	
	//TEST METHOD
	public List<AccountEntity> getAccountsByLoginAndEmail(String login, String email) {
		//login = "'" + login + "'";
		//email = "'" + email + "'";
		//System.out.println("login: " + login);
		//System.out.println("email: " + email);
		//System.out.println("login name of type: " + login.getClass().getSimpleName());
		String sql = "select * from accounts where accounts.`Login`=:login or"
				+ " accounts.`Email`=:email";
		//System.out.println(SqlRequestUpdater.getCompleteSql(sql, login, email));
		//String sql2 = "select * from accounts where accounts.`Login`='Megathrone' or"
		//		+ " accounts.`Email`='Optimus@tut.by'";
		//MapSqlParameterSource params = new MapSqlParameterSource();
		//params.addValue("login", login);
		//params.addValue("Email", email);

		try {
			Object obj = namedJdbcTemplate.query(
					SqlRequestUpdater.getCompleteSql(sql, login, email), new AccountMapper());
			//obj type: ArrayList
			System.out.println("in getAccountsByLoginAndEmail obj type: " + obj.getClass().getSimpleName());
			return (List<AccountEntity>) obj;
		} catch (Exception e) {
			System.out.println("exception within return in getAccountsByLoginAndEmail()");
		}

		return null;
	}
	
	public List<AccountEntity> getAllAccounts() {		
		String sql = "select * from accounts";

		try {			
			Object obj = namedJdbcTemplate.query(sql, new AccountMapper());
			//obj type: ArrayList
			System.out.println("obj type: " + obj.getClass().getSimpleName());
			return (List<AccountEntity>) obj;
		} catch (Exception e) {
			System.out.println("exception within return in getAllAccounts()");
		}

		return null;
	}	

	
	//RowMapper
	private static class AccountMapper implements RowMapper<AccountEntity> {

		public AccountEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
			AccountEntity account = new AccountEntity();
			account.setAccountId(rs.getLong("id"));
			account.setAccountLogin(rs.getString("Login"));
			account.setAccountEmail(rs.getString("email"));
			account.setAccountPassword(rs.getString("password"));	
			
			return account;
		}
	}
	

	
	/*public void insertAccount() {		
	String sql = "insert into project_one.accounts (`Login`, `Password`, `Email`) VALUES ('2bla bla', 'bla', 'bla@bla')";		
	jdbcTemplate.update(sql);
	}*/
	
	/*public void deleteAccount(String accountLogin){
	String sql = "delete from project_one.accounts where accounts.Login= ? ";
	jdbcTemplate.update(sql, accountLogin);
	}*/
	
	/*public AccountBean getAccountByLogin(String login) {		
		String sql = "select * from accounts where accounts.Login=:login";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("login", login);

		try {
			Object obj = namedJdbcTemplate.queryForObject(sql, params, new AccountMapper());
			System.out.println("obj type: " + obj.getClass().getSimpleName());
			return (AccountBean) obj;
		} catch (Exception e) {
			System.out.println("exception within return in getAccountByLogin()");
		}

		return null;
	}
	
	public List<AccountBean> getAccountsByLogin(String login) {		
		String sql = "select * from accounts where accounts.Login=:login";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("login", login);

		try {
			Object obj = namedJdbcTemplate.query(sql, params, new AccountMapper());
			//obj type: ArrayList
			System.out.println("obj type: " + obj.getClass().getSimpleName());
			return (List<AccountBean>) obj;
		} catch (Exception e) {
			System.out.println("exception within return in getAccounts ByLogin()");
		}

		return null;
	}*/

}
