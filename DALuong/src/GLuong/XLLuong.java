package GLuong;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class XLLuong {

//	private static final String MaNV;
	Connection conn=null;
	public void getCon() throws SQLException {
		conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/dlluong","root", "24032002");
		System.out.println("ok");
	}
	public ResultSet getNVbyMa() throws SQLException {
		String query="select *from tbNhanvien";
		PreparedStatement stm = conn.prepareStatement(query);
		ResultSet data= stm.executeQuery(query);
		return data;	
	}
	public int updateNV(int MaNV,String HoTen,String DiaChi,double Luong) throws SQLException
	{
		String query = "update tbNhanvien set HoTen='"+HoTen+"',DiaChi='"+DiaChi+"',Luong="+Luong+" where  MaNV ="+MaNV;
		System.out.println(query);
		PreparedStatement stm = conn.prepareStatement(query);
		int rowaffect= stm.executeUpdate(query);
		
		return rowaffect;
	}
	
	public ResultSet TimKiemNV(int MaNV) throws SQLException
	{
		String query="select *from tbNhanvien where MaNV="+MaNV;
		PreparedStatement stm = conn.prepareStatement(query);
		ResultSet data_search = stm.executeQuery(query);
		
		return data_search;		
	}
}
