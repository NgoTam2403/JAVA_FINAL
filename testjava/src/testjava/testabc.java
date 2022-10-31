package testjava;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;

import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

//import com.mysql.cj.jdbc.result.ResultSetMetaData;

import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class testabc extends JFrame {

	private JPanel pnContent;
	private static JTable table;

	/**
	 * Launch the application.
	 */
//	static Connection conn=null;
//	static ResultSet rs;

 
public static void main(String[] args) {
	  JFrame F= new testabc();
      F.setVisible(true);
//		
//		XLSach XLSach= new XLSach();
//		conn=XLSach.getCon();//gọi tới hàm kết nối
//		rs= XLSach.getSA();
//		DefaultTableModel model= (DefaultTableModel) table.getModel();
//		ResultSetMetaData meta = (ResultSetMetaData) rs.getMetaData();
//		int socot = meta.getColumnCount();
//		while(rs.next())
//		{
//			Object [] rowdata = new Object[socot+1];
//			for(int i=0;i<socot;i++)
//			{
//				rowdata[i]= rs.getObject(i+1);
//				Sach sach= new Sach( );
//				rowdata[4]=sach.ThanhTien(rs.getDouble(4),rs.getInt(3));
//				//rowdata[4]= 
//			}
//			model.addRow(rowdata);		
//		}
//			
//		
	}

	/**
	 * Create the frame.
	 */
	public testabc() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 470);
		pnContent = new JPanel();
		pnContent.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(pnContent);
		pnContent.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel1 = new JPanel();
		pnContent.add(panel1);
		panel1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel pnLeft = new JPanel();
		panel1.add(pnLeft);
		pnLeft.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"2019", "2020", "2021"}));
		comboBox.setBounds(47, 29, 138, 21);
		pnLeft.add(comboBox);
		
		JPanel pnRight = new JPanel();
		panel1.add(pnRight);
		pnRight.setLayout(null);
		
		JButton btnNewButton = new JButton("Xóa");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnNewButton.setBounds(51, 31, 85, 21);
		pnRight.add(btnNewButton);
		
		JScrollPane scrollPaneTable = new JScrollPane();
		pnContent.add(scrollPaneTable);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã số", "Tên sách", "Năm xuất bản", "Giá bán", "Thành tiền"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Integer.class, Double.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPaneTable.setViewportView(table);
		
	}

}

