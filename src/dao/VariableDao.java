package dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import domain.Variable;
import utils.JDBCUtils;

public class VariableDao {
	private JdbcTemplate template=new JdbcTemplate(JDBCUtils.ds);
	//查询数据库variable中所有数据，返回一个list集合
	public List<Variable> findAllVariable() {
		String sql="select varid,vartype,varcode,varname,showname from variable where enable=1";
		List<Variable> variables=template.query(sql,new BeanPropertyRowMapper<Variable>(Variable.class));
		return variables;
	}
	
	public void addVariable(Variable variable) {
		String sql="insert into variable (vartype,varcode,varname,showname) values(?,?,?,?)";
		template.update(sql,variable.getVartype(),variable.getVarcode(),variable.getVarname(),variable.getShowname());
	}
	
	//根据variable删除数据库中对应用户数据
	public void deleteByVarid(int varid) {
		String sql="update variable set enable=0 where varid=?";
		template.update(sql, varid);
	}
	
	//根据variable查询对应用户信息
	public Variable findVariableById(int varid) {
		String sql="select varid,vartype,varcode,varname,showname from variable where enable=1 and varid=?";
		Variable variable=template.queryForObject(sql, new BeanPropertyRowMapper<Variable>(Variable.class),varid);
		return variable;
	}
	
	
	//更新用户信息,参数为浏览器端传来的对象
	public void updateVariable(Variable variable) {
		String sql="update variable set vartype=?,varcode=?,varname=?,showname=? where varid=?";
		template.update(sql, variable.getVartype(),variable.getVarcode(),variable.getVarname(),variable.getShowname(),variable.getVarid());
	}
	
	//删除选中的用户
	public void delSelectedVariable(String[] varids) {
		for(String e:varids) {
			int varid=Integer.parseInt(e);
			deleteByVarid(varid);
		}
	}
	
	//重载，实现根据用户输入条件查询
			public int findTotalCount(String varname) {
				try {
					String sql="select count(*) from variable where true and enable=1";
					if(varname!=null && !"".equals(varname))
						sql += " and varname like '%"+varname+"%' or varcode like '%"+varname+"%'";
					int totalCount=template.queryForObject(sql,Integer.class);
					return totalCount;
				} catch (DataAccessException e) {
					e.printStackTrace();
					return 0;
				}
			}

			//重载，根据用户查询条件进行分页查询
			public List<Variable> findVariableByPage(int rows,int start,String varname){
				try {
					String sql="select varid,vartype,varcode,varname,showname from variable where true and enable=1 ";
					if(varname!=null && !"".equals(varname))
						sql += " and varname like '%"+varname+"%' or varcode like '%"+varname+"%' limit ? offset ?";
					else
						sql += " limit ? offset ?";
					List<Variable> variables=template.query(sql, new BeanPropertyRowMapper<Variable>(Variable.class),rows,start);
					return variables;
				} catch (DataAccessException e) {
					e.printStackTrace();
					return null;
				}
			}
			
			//根据中药编号查询视频集合，参数v_id（中药编号），返回Variable的List集合
			public List<Variable> findVariableListByMid(String varmid){
				try {
					String sql="select varid,vartype,varcode,varname,showname from tb_variable where v_mid=?";
					List<Variable> variables=template.query(sql, new BeanPropertyRowMapper<Variable>(Variable.class),varmid);
					return variables;
				} catch (DataAccessException e) {
					e.printStackTrace();
					return null;
				}
			}
}
