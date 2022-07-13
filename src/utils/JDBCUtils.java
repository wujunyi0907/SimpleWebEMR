package utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;



/**
 * JDBC�����࣬Druid��װ���ݿ������ͷŷ���
 * @author wujunyi
 *
 */
public class JDBCUtils {
	
	//DataSource����
	public static DataSource ds;
	
	static {
	    //1�����������ļ������ڴ��ڴ�
		Properties pro=new Properties();
		try {
			pro.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
			//2����ȡDataSource����
			ds=DruidDataSourceFactory.createDataSource(pro);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//�������ݿ����Ӷ���ķ���getconnection
	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}
	
	//�黹���Ӷ���ķ���������Դ�黹�����ӳ���
	public static void close(Statement stmt,Connection conn) {
		if(stmt!=null)
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if(conn!=null)
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}		
	}
	
	//����һ����̬ȫ�ַ����������ͷ����ݿ�������Դ����3����Դ
	public static void close(ResultSet rs,Statement stmt,Connection conn) {
		if(rs!=null)
			try {
				rs.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		if(stmt!=null)
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if(conn!=null)
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}		
	}

}
