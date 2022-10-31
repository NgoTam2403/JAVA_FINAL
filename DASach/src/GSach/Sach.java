package GSach;

public class Sach extends Tailieu{
	private int NamXB;
	private double GiaB;
	public int getNamXB() {
		return NamXB;
	}
	public void setNamXB(int namXB) {
		NamXB = namXB;
	}
	public double getGiaB() {
		return GiaB;
	}
	public void setGiaB(double giaB) {
		GiaB = giaB;
	}
	public Sach() {
		
	}//contructor ngầm định
	public Sach(int namXB, double giaB) {
		super();
		NamXB = namXB;
		GiaB = giaB;
	}
	
	@Override
	public double ThanhTien(double GiaB, int NamXB) {
		// TODO Auto-generated method stub
		double ThanhTien;
		if(NamXB<2015)
		{
			ThanhTien= GiaB*0.85;
			
		}
		else {
			ThanhTien= GiaB*0.95;
		}
		return ThanhTien;
		
	}
	
	}
