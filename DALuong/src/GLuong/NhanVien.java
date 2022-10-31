package GLuong;

public class NhanVien extends Person {

	private String DiaChi;
	private double Luong;
	public String getDiaChi() {
		return DiaChi;
	}
	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	public double getLuong() {
		return Luong;
	}
	public void setLuong(double luong) {
		Luong = luong;
	}
	public NhanVien(int maNV, String hoTen, String diaChi, double luong) {
		super(maNV, hoTen);
		DiaChi = diaChi;
		Luong = luong;
	}
	
	
	
	

}
