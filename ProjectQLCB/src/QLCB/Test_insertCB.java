package QLCB;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Test_insertCB {

	public static void doInsertCB() throws SQLException {
		
		
		CanBo cb= new CanBo(2002,"Le E","nu","Thanh Hoa",200000);
		QLCB ql= new QLCB();
		ql.getCon();
		int rowaffect =ql.insertCB(cb);
		if(rowaffect>0)
		{
			  JOptionPane.showMessageDialog(null, "them thanh cong");
			
		}
		else
		{
			  JOptionPane.showMessageDialog(null, "them that bai");
		}
		
	}
	
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		doInsertCB();
		Scanner in = new Scanner(System.in);

		int i = in.nextInt();
		String s = in.next();
		
		

	}

}
