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
 * JDBC工具类，Druid封装数据库链接释放方法
 * @author wujunyi
 *
 */
public class JDBCUtils {
	
	//DataSource对象
	public static DataSource ds;
	
	static {
	    //1、加载配置文件进入内存内存
		Properties pro=new Properties();
		try {
			pro.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
			//2、获取DataSource对象
			ds=DruidDataSourceFactory.createDataSource(pro);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//返回数据库链接对象的方法getconnection
	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}
	
	//归还连接对象的方法，把资源归还到连接池中
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
	
	//定义一个静态全局方法，用于释放数据库连接资源——3个资源
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
