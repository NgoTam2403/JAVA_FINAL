package QLCB;

import java.math.BigDecimal;

public class CanBo {
	private int SoTK;
	private String HoTen;
	private String GT;
	private String DiaChi;
	private double Luong;
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
	public double getLuong() {
		return Luong;
	}
	public void setLuong(double luong) {
		Luong = luong;
	}
	public CanBo() {
		
	}
	public CanBo(int soTK, String hoTen, String gT, String diaChi, double luong) {
		super();
		SoTK = soTK;
		HoTen = hoTen;
		GT = gT;
		DiaChi = diaChi;
		Luong = luong;
	}
	
	
}
