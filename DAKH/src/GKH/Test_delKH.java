package GKH;

import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Test_delKH {
	static XLKH xl=new XLKH();
	public static void doDelKH() throws SQLException {
		xl.getCon();
		int rowaffect=xl.delKH("Ha Noi", "nu");
		if(rowaffect>0)
		{
			JOptionPane.showMessageDialog(null, "xoa Thanh cong");
		}
		else
		{
			JOptionPane.showMessageDialog(null, "xoa That bai");
		}
	}

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		doDelKH();
		
	}

}
