package GLuong;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GUI_updateNV extends JFrame {

	private JPanel contentPane;
	private JTextField textMaNV;
	private JTextField textHoten;
	private JTextField textDiaChi;
	private JTextField textLuong;
	private JTextField textField;
	private static JTable table;

	/**
	 * Launch the application.
	 */
	int MaNV;
	String HoTen;
	String DiaChi;
	double Luong;
//	static NhanVien nv= new NhanVien(MaNV,HoTen,DiaChi,Luong);
	Connection conn=null;
	static XLLuong xl= new XLLuong();
	public static void show_data() throws SQLException {
		xl.getCon();
		ResultSet rs= xl.getNVbyMa();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setNumRows(0);
		ResultSetMetaData meta = (ResultSetMetaData) rs.getMetaData();
		int socot = meta.getColumnCount();
		while(rs.next())
		{
			Object[] row = new Object[socot];
			for(int i=0;i<socot;i++)
			{
				row[i]= rs.getObject(i+1);
			}
			model.addRow(row);
		}
	}
	public static void main(String[] args) throws SQLException {
		Frame F=new GUI_updateNV();
		F.setVisible(true);
		show_data();
	}

	/**
	 * Create the frame.
	 */
	public GUI_updateNV() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 729, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textMaNV = new JTextField();
		textMaNV.setBackground(Color.PINK);
		textMaNV.setEnabled(false);
		textMaNV.setBounds(116, 25, 184, 27);
		contentPane.add(textMaNV);
		textMaNV.setColumns(10);
		
		JLabel lbMaNV = new JLabel("M?? Nh??n vi??n");
		lbMaNV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbMaNV.setBounds(10, 23, 119, 27);
		contentPane.add(lbMaNV);
		
		textHoten = new JTextField();
		textHoten.setColumns(10);
		textHoten.setBounds(116, 75, 184, 27);
		contentPane.add(textHoten);
		
		textDiaChi = new JTextField();
		textDiaChi.setColumns(10);
		textDiaChi.setBounds(116, 128, 184, 27);
		contentPane.add(textDiaChi);
		
		textLuong = new JTextField();
		textLuong.setColumns(10);
		textLuong.setBounds(116, 181, 184, 27);
		contentPane.add(textLuong);
		
		JLabel lbHoTen = new JLabel("H??? t??n");
		lbHoTen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbHoTen.setBounds(10, 73, 65, 27);
		contentPane.add(lbHoTen);
		
		JLabel lbDiaChi = new JLabel("?????a ch???");
		lbDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbDiaChi.setBounds(10, 126, 65, 27);
		contentPane.add(lbDiaChi);
		
		JLabel lbLuong = new JLabel("L????ng");
		lbLuong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbLuong.setBounds(10, 179, 65, 27);
		contentPane.add(lbLuong);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(445, 25, 184, 27);
		contentPane.add(textField);
		
		JLabel lbTimKiem = new JLabel("T??m ki???m");
		lbTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbTimKiem.setBounds(369, 25, 79, 27);
		contentPane.add(lbTimKiem);
		
		JButton btnTimKiem = new JButton("T??m ki???m");
		btnTimKiem.setBounds(500, 71, 85, 35);
		contentPane.add(btnTimKiem);
		
		JButton btnCapNhat = new JButton("C???p nh???t");
		btnCapNhat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					xl.getCon();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
				
				try {
					int MaNV= Integer.parseInt(textMaNV.getText());
					String HoTen = textHoten.getText();
					String DiaChi = textDiaChi.getText();
					double Luong = Double.parseDouble(textLuong.getText());
					int rowaffect = xl.updateNV(MaNV, HoTen, DiaChi, Luong);
					if(rowaffect>0)
					{
						JOptionPane.showMessageDialog(null, "update thanh cong");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "update that bai");
					}
					
					show_data();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
			});
		btnCapNhat.setBounds(469, 159, 116, 46);
		contentPane.add(btnCapNhat);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 249, 695, 162);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				String MaNV = table.getValueAt(table.getSelectedRow(), 0).toString();
				String HoTen = table.getValueAt(table.getSelectedRow(), 1).toString();
				String DiaChi = table.getValueAt(table.getSelectedRow(), 2).toString();
				String Luong = table.getValueAt(table.getSelectedRow(), 3).toString();
				
				textMaNV.setText(MaNV);
				textHoten.setText(HoTen);
				textDiaChi.setText(DiaChi);
				textLuong.setText(Luong);
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 nh\u00E2n vi\u00EAn", "H\u1ECD T\u00EAn", "\u0110\u1ECBa ch\u1EC9", "L\u01B0\u01A1ng"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, String.class, String.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
	}
}

