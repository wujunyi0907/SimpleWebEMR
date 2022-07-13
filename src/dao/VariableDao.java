package dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import domain.Variable;
import utils.JDBCUtils;

public class VariableDao {
	private JdbcTemplate template=new JdbcTemplate(JDBCUtils.ds);
	//��ѯ���ݿ�variable���������ݣ�����һ��list����
	public List<Variable> findAllVariable() {
		String sql="select varid,vartype,varcode,varname,showname from variable where enable=1";
		List<Variable> variables=template.query(sql,new BeanPropertyRowMapper<Variable>(Variable.class));
		return variables;
	}
	
	public void addVariable(Variable variable) {
		String sql="insert into variable (vartype,varcode,varname,showname) values(?,?,?,?)";
		template.update(sql,variable.getVartype(),variable.getVarcode(),variable.getVarname(),variable.getShowname());
	}
	
	//����variableɾ�����ݿ��ж�Ӧ�û�����
	public void deleteByVarid(int varid) {
		String sql="update variable set enable=0 where varid=?";
		template.update(sql, varid);
	}
	
	//����variable��ѯ��Ӧ�û���Ϣ
	public Variable findVariableById(int varid) {
		String sql="select varid,vartype,varcode,varname,showname from variable where enable=1 and varid=?";
		Variable variable=template.queryForObject(sql, new BeanPropertyRowMapper<Variable>(Variable.class),varid);
		return variable;
	}
	
	
	//�����û���Ϣ,����Ϊ������˴����Ķ���
	public void updateVariable(Variable variable) {
		String sql="update variable set vartype=?,varcode=?,varname=?,showname=? where varid=?";
		template.update(sql, variable.getVartype(),variable.getVarcode(),variable.getVarname(),variable.getShowname(),variable.getVarid());
	}
	
	//ɾ��ѡ�е��û�
	public void delSelectedVariable(String[] varids) {
		for(String e:varids) {
			int varid=Integer.parseInt(e);
			deleteByVarid(varid);
		}
	}
	
	//���أ�ʵ�ָ����û�����������ѯ
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

			//���أ������û���ѯ�������з�ҳ��ѯ
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
			
			//������ҩ��Ų�ѯ��Ƶ���ϣ�����v_id����ҩ��ţ�������Variable��List����
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
