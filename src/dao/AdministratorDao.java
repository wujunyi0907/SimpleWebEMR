package dao;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import domain.Administrator;
import utils.JDBCUtils;

public class AdministratorDao {
	private JdbcTemplate template=new JdbcTemplate(JDBCUtils.ds);
	
	public Administrator login(Administrator loginAdministrator) {
		try {
			String sql="select adid,adname,adpasswd from administrators where adname=? and adpasswd=?";//?ÎªÕ¼Î»·û
			Administrator administrator=template.queryForObject(sql, new BeanPropertyRowMapper<Administrator>(Administrator.class),
					loginAdministrator.getAdname(),loginAdministrator.getAdpasswd());
			return administrator;
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
