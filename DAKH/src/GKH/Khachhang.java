package GKH;

public class Khachhang {
	private int SoTK;
	private String HoTen;
	private String GT;
	private String DiaChi;
	private double SoDu;
	public int getSoTK() {
		return SoTK;
	}
	public void setSoTK(int soTK) {
		SoTK = soTK;
	}
	public String getHoTen() {
		return HoTen;
	}
	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}
	public String getGT() {
		return GT;
	}
	public void setGT(String gT) {
		GT = gT;
	}
	public String getDiaChi() {
		return DiaChi;
	}
	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	public double getSoDu() {
		return SoDu;
	}
	public void setSoDu(double soDu) {
		SoDu = soDu;
	}
	public Khachhang()
	{
		
	}
	public Khachhang(int soTK, String hoTen, String gT, String diaChi, double soDu) {
		super();
		SoTK = soTK;
		HoTen = hoTen;
		GT = gT;
		DiaChi = diaChi;
		SoDu = soDu;
	}
	
}
