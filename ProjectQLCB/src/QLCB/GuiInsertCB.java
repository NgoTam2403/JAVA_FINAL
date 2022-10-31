package QLCB;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GuiInsertCB extends JFrame {

	private JPanel contentPane;
	private JTextField textSoTK;
	private JTextField textHVT;
	private JTextField textGT;
	private JTextField textDiaChi;
	private JTextField textLuong;
	private static JTable table;
	static QLCB ql= new QLCB();
	/**
	 * Launch the application.
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		Frame F= new GuiInsertCB();
		F.setVisible(true);
		show_data();
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public static void show_data() throws SQLException {
		ql.getCon();
		ResultSet rs= ql.getData();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setNumRows(0);
		ResultSetMetaData meta = (ResultSetMetaData) rs.getMetaData();
		int socot=meta.getColumnCount();
		while(rs.next()) {
			Object[] row= new Object[socot];
			for(int i=0;i<socot;i++)
			{
				row[i]= rs.getObject(i+1);
			}
			model.addRow(row);
		}
		
	}
	public GuiInsertCB() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 738, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 174, 704, 177);
		contentPane.add(scrollPane);
		
		table = new JTable();
//		table.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				DefaultTableModel model = (DefaultTableModel) table.getModel();
//				String textSTK = model.getValueAt(table.getSelectedRow(),0).toString();
//			}
//		});
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"S\u1ED1 t\u00E0i kho\u1EA3n", "H\u1ECD v\u00E0 t\u00EAn", "Gi\u1EDBi t\u00EDnh", "\u0110\u1ECBa ch\u1EC9", "L\u01B0\u01A1ng"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lbSoTK = new JLabel("Số tài khoản");
		lbSoTK.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbSoTK.setBounds(26, 20, 94, 23);
		contentPane.add(lbSoTK);
		
		JLabel lbHVT = new JLabel("Họ và tên");
		lbHVT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbHVT.setBounds(26, 61, 94, 23);
		contentPane.add(lbHVT);
		
		JLabel lbGT = new JLabel("Giới tính");
		lbGT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbGT.setBounds(26, 104, 94, 23);
		contentPane.add(lbGT);
		
		JLabel lbDiaChi = new JLabel("Địa chỉ");
		lbDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbDiaChi.setBounds(331, 20, 94, 23);
		contentPane.add(lbDiaChi);
		
		JLabel lbLuong = new JLabel("Lương");
		lbLuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbLuong.setBounds(331, 61, 94, 23);
		contentPane.add(lbLuong);
		
		
		//button Sửa
		JButton btnSua = new JButton("Sua");
		btnSua.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btnSua.setBounds(500, 100, 80, 20);
		contentPane.add(btnSua);
		
		
		//button them
		JButton btnThem = new JButton("Thêm");
		btnThem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int Sotk= Integer.parseInt(textSoTK.getText());
				String HoVaTen = textHVT.getText();
				String GioiTinh = textGT.getText();
				String DiaChi = textDiaChi.getText();
				double Luong = Double.parseDouble(textLuong.getText());
				CanBo cb= new CanBo(Sotk,HoVaTen,GioiTinh,DiaChi,Luong);
				
				try {
					ql.getCon();
					int rowaffect = ql.insertCB(cb);
					if(rowaffect>0)
					{
						JOptionPane.showMessageDialog(null, "them thanh cong");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "them 0 thanh cong");
					}
					show_data();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
			}
		});
		btnThem.setForeground(Color.BLACK);
		btnThem.setBackground(Color.GREEN);
		btnThem.setBounds(546, 125, 85, 21);
		contentPane.add(btnThem);
		
		textSoTK = new JTextField();
		textSoTK.setBounds(118, 20, 96, 19);
		contentPane.add(textSoTK);
		textSoTK.setColumns(10);
		
		textHVT = new JTextField();
		textHVT.setColumns(10);
		textHVT.setBounds(118, 65, 96, 19);
		contentPane.add(textHVT);
		
		textGT = new JTextField();
		textGT.setColumns(10);
		textGT.setBounds(118, 108, 96, 19);
		contentPane.add(textGT);
		
		textDiaChi = new JTextField();
		textDiaChi.setColumns(10);
		textDiaChi.setBounds(422, 20, 96, 19);
		contentPane.add(textDiaChi);
		
		textLuong = new JTextField();
		textLuong.setColumns(10);
		textLuong.setBounds(422, 65, 96, 19);
		contentPane.add(textLuong);
	}
}

