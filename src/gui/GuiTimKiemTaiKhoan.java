package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;

public class GuiTimKiemTaiKhoan extends JFrame implements ActionListener {

	public static JPanel contentPane;
	private JTextField txtNhap;
	private DefaultTableModel modelKH;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiTimKiemTaiKhoan frame = new GuiTimKiemTaiKhoan();
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
	public GuiTimKiemTaiKhoan() {
		this.setTitle("Quản lý khách hàng");
		this.setSize(1930, 1030);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); // Toàn màn hình
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(51, 204, 204));
		
		// Kiểu chữ
		Font font1 = new Font("Times New Roman", Font.BOLD, 36);
		Font font2 = new Font("Times New Roman", Font.PLAIN, 24);
		
		// Màu chữ
		Color color1 = new Color(138, 43, 226); // BlueViolet
		Color color2 = new Color(233, 221, 244);
	
		//Tiêu đề
		JPanel pnlTieuDe = new JPanel();
		pnlTieuDe.setBounds(15, 15, 1889, 60);
		pnlTieuDe.setBackground(new Color(255, 255, 255));
		contentPane.add(pnlTieuDe);
		
		JLabel lblTieuDe = new JLabel("TÌM KIẾM TÀI KHOẢN");
		lblTieuDe.setBackground(new Color(51, 204, 255));
		pnlTieuDe.add(lblTieuDe);
		lblTieuDe.setFont(font1);
		lblTieuDe.setForeground(new Color(0, 204, 204));;
		
		JPanel pnlChucNang = new JPanel();
		pnlChucNang.setBounds(15, 90, 1889, 90);
		contentPane.add(pnlChucNang);
		pnlChucNang.setBackground(Color.white);
		pnlChucNang.setBorder(BorderFactory.createTitledBorder("Tìm kiếm: "));
		pnlChucNang.setLayout(null);
		
		txtNhap = new JTextField("Nhập thông tin cần tìm");
		txtNhap.setBounds(348, 22, 1026, 48);
		txtNhap.setFont(font2);
		pnlChucNang.add(txtNhap);
		txtNhap.setColumns(10);
				
				txtNhap.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtNhap.getText().equals("Nhập thông tin cần tìm")) {
                    txtNhap.setText("");
                    txtNhap.setForeground(Color.BLACK); // Đổi màu chữ khi có focus
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtNhap.getText().isEmpty()) {
                    txtNhap.setText("Nhập thông tin cần tìm");
                    txtNhap.setForeground(Color.GRAY); // Đổi màu chữ gợi ý khi mất focus
                }
            }
        });
						
		JLabel lblNhap = new JLabel("Thông tin nhân viên :");
		lblNhap.setBounds(80, 27, 258, 36);
		lblNhap.setFont(font2);
		pnlChucNang.add(lblNhap);
		//Danh sách các thuộc tính của khách hàng
		JComboBox cmbLoc = new JComboBox();
		cmbLoc.setBounds(1580, 22, 258, 46);
		pnlChucNang.add(cmbLoc);
		
		JLabel lblLoc = new JLabel("Lọc theo :");
		lblLoc.setBounds(1436, 22, 124, 48);
		lblLoc.setFont(font2);
		pnlChucNang.add(lblLoc);
		
		//Thể hiện danh sách tìm kiếm được
		JPanel pnlBangTK = new JPanel();
		pnlBangTK.setBounds(15, 195, 1889, 770);
		contentPane.add(pnlBangTK);
		pnlBangTK.setBorder(BorderFactory.createTitledBorder("Danh sách tài khoản nhân viên"));
		pnlBangTK.setLayout(null);

		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
