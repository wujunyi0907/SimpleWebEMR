package utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo {

	public static void main(String[] args) throws SQLException {
		Connection conn=JDBCUtils.getConnection();
		Statement stmt=conn.createStatement();
		String sql="select * from administrators where adid=1";
		boolean flag=stmt.execute(sql);
		System.out.println(flag);
		JDBCUtils.close(stmt, conn);

	}
}
