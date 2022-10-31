package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class test extends JFrame {

	private JPanel contentPane;
	private JTable tableContent;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Connection conn = null;
        try {
            // db parameters
            String url       = "jdbc:mysql://localhost:3306/music";
            String user      = "root";
            String password  = "24032002";

            // create a connection to the database
            conn = DriverManager.getConnection(url, user, password);
            // more processing here
            // ...
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try{
                if(conn != null)
                {
                    System.out.println("connect");
                    conn.close();
                }

            }catch(SQLException ex)
            {
                System.out.println(ex.getMessage());
            }
        }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test frame = new test();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 517, 300);//s2 tham số đầu là vị trí
		contentPane = new JPanel();
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel pnContent = new JPanel();
		contentPane.add(pnContent);
		pnContent.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel pnRight = new JPanel();
		pnContent.add(pnRight);
		pnRight.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"2019", "2020", "2021"}));
		comboBox.setBounds(33, 40, 136, 21);
		pnRight.add(comboBox);
		
		JPanel pnLeft = new JPanel();
		pnContent.add(pnLeft);
		pnLeft.setLayout(null);
		
		JButton btknXoa = new JButton("Xóa");
		btknXoa.setBounds(96, 31, 96, 38);
		pnLeft.add(btknXoa);
		
		JPanel pnTable = new JPanel();
		contentPane.add(pnTable);
		pnTable.setLayout(null);
		
		tableContent = new JTable();
		tableContent.setFillsViewportHeight(true);
		tableContent.setBounds(10, 5, 473, 111);
		tableContent.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 s\u00E1ch", "T\u00EAn s\u00E1ch", "N\u0103m xu\u1EA5t b\u1EA3n", "Gi\u00E1 b\u00E1n", "Th\u00E0nh ti\u1EC1n"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Integer.class, Double.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		pnTable.add(tableContent);
	}
}
