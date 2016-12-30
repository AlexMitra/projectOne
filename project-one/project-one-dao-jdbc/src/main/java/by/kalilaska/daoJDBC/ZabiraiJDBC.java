package by.kalilaska.daoJDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import by.kalilaska.entities.Account;


@Repository
public class ZabiraiJDBC {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	private NamedParameterJdbcTemplate namedJdbcTemplate;

	/*public ZabiraiJDBC(NamedParameterJdbcTemplate namedJdbcTemplate) {
		super();
		this.namedJdbcTemplate = namedJdbcTemplate;
		System.out.println("namedJdbcTemplate:" + namedJdbcTemplate);
	}*/
	
	
	
	public ZabiraiJDBC() {
		// TODO Auto-generated constructor stub		
	}

	@Autowired
	public void setNamedJdbcTemplate(NamedParameterJdbcTemplate namedJdbcTemplate) {
		this.namedJdbcTemplate = namedJdbcTemplate;
		System.out.println("namedJdbcTemplate:" + namedJdbcTemplate);
	}

	public void insertAccount() {		
		String sql = "insert into project_one.accounts (`Login`, `Password`, `Email`) VALUES ('2bla bla', 'bla', 'bla@bla')";		
		jdbcTemplate.update(sql);
		
		//System.out.println(jdbcTemplate);
		//System.out.println("hello");
	}
	
	public void insertAccount(Account account) {		
		String sql = "insert into project_one.accounts (`Login`, `Password`, `Email`) VALUES (?, ?, ?)";		
		jdbcTemplate.update(sql, new Object[]
				{account.getAccountLogin(), account.getAccountPassword(),
						account.getAccountEmail()});
	}
	
	public void deleteAccount(String accountLogin){
		String sql = "delete from project_one.accounts where accounts.Login= ? ";
		jdbcTemplate.update(sql, accountLogin);
	}
	
	public void deleteAccount(Account account){
		deleteAccount(account.getAccountLogin());
	}
	
	
	public Account getAccountByLogin(String login) {		
		String sql = "select * from accounts where accounts.Login=:login";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("login", login);

		try {
			Object obj = namedJdbcTemplate.queryForObject(sql, params, new AccountMapper());
			System.out.println("obj type: " + obj.getClass().getSimpleName());
			return (Account) obj;
		} catch (Exception e) {
			System.out.println("exception within return in getAccountByLogin()");
		}

		return null;
	}
	
	public List<Account> getAccountsByLogin(String login) {		
		String sql = "select * from accounts where accounts.Login=:login";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("login", login);

		try {
			Object obj = namedJdbcTemplate.query(sql, params, new AccountMapper());
			//obj type: ArrayList
			System.out.println("obj type: " + obj.getClass().getSimpleName());
			return (List<Account>) obj;
		} catch (Exception e) {
			System.out.println("exception within return in getAccounts ByLogin()");
		}

		return null;
	}
	
	public List<Account> getAllAccounts() {		
		String sql = "select * from accounts";		

		try {
			Object obj = namedJdbcTemplate.query(sql, new AccountMapper());
			//obj type: ArrayList
			System.out.println("obj type: " + obj.getClass().getSimpleName());
			return (List<Account>) obj;
		} catch (Exception e) {
			System.out.println("exception within return in getAllAccounts()");
		}

		return null;
	}
	
	//RowMapper
	private static class AccountMapper implements RowMapper<Account> {

		public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
			Account account = new Account();
			account.setId(rs.getInt("id"));
			account.setAccountLogin(rs.getString("Login"));
			account.setAccountEmail(rs.getString("email"));
			account.setAccountPassword(rs.getString("password"));
			
			System.out.println("in AccountMapper\n" + account);
			return account;

		}
	}
	


}
