package GSach;

import java.sql.*;

public class XLSach {
	Connection conn= null;
	
	public Connection getCon() throws SQLException
	{
		String url= "jdbc:mysql://localhost:3306/dlsach";
		String user = "root";
		String password = "24032002";
		
		conn = DriverManager.getConnection(url,user,password);
		
		return conn;
	}
	
	public ResultSet getSA() throws SQLException {
		String query = "Select *from tbSach";//khai báo câu lệnh truy vấn
		Statement stm = conn.prepareStatement(query);//khởi tạo đối tượng từ 1 csdl từ câu truy vấn bởi phương thức statement..
		ResultSet rs = stm.executeQuery(query);//trả về kết quả truy vấn
		
		return rs;
		
	}
	public int deleteSA(int NamXB) throws SQLException
	{
		String query= "delete from tbSach where NamXB = "+NamXB;
		Statement stm = conn.prepareStatement(query);
		int rowaffect = stm.executeUpdate(query);
		
//		String query= "delete from tbSach where NamXB = ? ";
//		PreparedStatement stm = conn.prepareStatement(query);
//		stm.setInt(1, NamXB);
//		int rowaffect = stm.executeUpdate(query);
		
		return rowaffect;
	}

}
