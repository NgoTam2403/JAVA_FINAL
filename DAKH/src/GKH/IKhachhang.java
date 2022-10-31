package GKH;

import java.sql.SQLException;

public interface IKhachhang {
	public void getCon() throws SQLException;
	public int delKH(String DiaChi, String GioiTinh) throws SQLException;

}
