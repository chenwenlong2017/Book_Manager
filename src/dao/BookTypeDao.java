package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.BookType;
import utilTools.StringUtil;
/**]
 * 图书类别Dao类
 * @author CHENWENLONG
 *
 */
public class BookTypeDao {
	public int add(Connection con,BookType booktype)throws Exception{
		String sql="insert into t_bookType values(null,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,booktype.getBookTypeName());
		pstmt.setString(2,booktype.getBookTypeDesc());
		return pstmt.executeUpdate();
	}
	/**
	 * 查询图书类别集合
	 * @param con
	 * @param bookType
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection con,BookType bookType)throws Exception{
		StringBuffer sb=new StringBuffer("select * from t_bookType");
		if(StringUtil.isNotEmpty(bookType.getBookTypeName())){
			sb.append(" and bookTypeName like '%"+bookType.getBookTypeName()+"%'" );
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
}
