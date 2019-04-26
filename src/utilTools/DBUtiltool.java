package utilTools;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * java项目实战2
 * @author CHENWENLONG
 *
 */
public class DBUtiltool {
	private String dbUrl="jdbc:mysql://localhost:3306/db_book";
	private String dbUserName="root";
	private String dbPassword="123456";
	private String jdbcName="com.mysql.jdbc.Driver";
	/**
	 * 获取数据库连接 
	 * @return 连接
	 * @throws Exception
	 */
	public Connection getCon() throws Exception{
		Class.forName(jdbcName);
		Connection con=DriverManager. getConnection(dbUrl, dbUserName, dbPassword);
		return con;
	}
	/**
	 * 关闭数据库
	 * @param con 连接
	 * @throws Exception
	 */
	public static void closeCon(Connection con) throws Exception{
		if(con!=null){
			con.close();
		}
	}
	public static void main(String[] args) {
		DBUtiltool dbUtiltool=new DBUtiltool();
		try {
			dbUtiltool.getCon();
			System.out.println("数据库连接成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("数据库连接失败");
		}
	}
}
