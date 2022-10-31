package GLuong;

public class Person {
	private  int MaNV;
	private String HoTen;
	
	public int getMaNV() {
		return MaNV;
	}
	public void setMaNV(int maNV) {
		MaNV = maNV;
	}
	public String getHoTen() {
		return HoTen;
	}
	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}
	
	public Person(int maNV, String hoTen) {
		super();
		MaNV = maNV;
		HoTen = hoTen;
		
	}
	
	

}
