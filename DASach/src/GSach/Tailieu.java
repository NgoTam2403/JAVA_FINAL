package GSach;

public abstract class Tailieu {
	private int MaS;
	private String TenS;
	public int getMaS() {
		return MaS;
	}
	public void setMaS(int maS) {
		MaS = maS;
	}
	public String getTenS() {
		return TenS;
	}
	public void setTenS(String tenS) {
		TenS = tenS;
	}
	public Tailieu()
	{
		
	};
	public Tailieu(int maS, String tenS) {
		super();
		MaS = maS;
		TenS = tenS;
	}
	public abstract double ThanhTien(double GiaB, int NamXB);
	
}
