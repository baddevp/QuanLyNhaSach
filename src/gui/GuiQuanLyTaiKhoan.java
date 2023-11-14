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
import javax.swing.JPasswordField;
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

public class GuiQuanLyTaiKhoan extends JFrame implements ActionListener {

	public static JPanel contentPane;
	private JTextField txtMaTaiKhoan;
	private JTextField txtTimKiem;
	private DefaultTableModel modelTK;
	private JTable tblTK;
	private JTextField txtTrangThai;
	private ButtonGroup group;
	private JButton btnThem;
	private JButton btnSua;
	private JButton btnXoa;
	private JButton btnLuu;
	private JButton btnDatLai;
	private JPasswordField txtMatKhau;
	private JComboBox cboPhanQuyen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiQuanLyTaiKhoan frame = new GuiQuanLyTaiKhoan();
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
	public GuiQuanLyTaiKhoan() {
		this.setTitle("Quản lý chức vụ");
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
		pnlTieuDe.setBounds(10, 10, 1891, 60);
		pnlTieuDe.setBackground(new Color(255, 255, 255));
		contentPane.add(pnlTieuDe);
		
		JLabel lblTieuDe = new JLabel("QUẢN LÝ TÀI KHOẢN");
		lblTieuDe.setBackground(new Color(51, 204, 255));
		pnlTieuDe.add(lblTieuDe);
		lblTieuDe.setFont(font1);
		lblTieuDe.setForeground(new Color(0, 204, 204));
		
		JPanel pnlThongTinKH = new JPanel();
		pnlThongTinKH.setBackground(new Color(255, 255, 255));
		
		pnlThongTinKH.setBorder(BorderFactory.createTitledBorder("Thông tin tài khoản"));
		pnlThongTinKH.setBounds(10, 80, 350, 855);
		contentPane.add(pnlThongTinKH);
		pnlThongTinKH.setLayout(null);
		
		JLabel lblChonNhanVien = new JLabel("Chọn nhân viên:");
		lblChonNhanVien.setBounds(10, 35, 319, 30);
		pnlThongTinKH.add(lblChonNhanVien);
		lblChonNhanVien.setFont(font2);
		
		JLabel lblMaChucVu = new JLabel("Mã tài khoản:");
		lblMaChucVu.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblMaChucVu.setBounds(10, 175, 187, 30);
		pnlThongTinKH.add(lblMaChucVu);
		
		txtMaTaiKhoan = new JTextField();
		txtMaTaiKhoan.setEditable(false);
		txtMaTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtMaTaiKhoan.setColumns(10);
		txtMaTaiKhoan.setBounds(20, 240, 319, 40);
		pnlThongTinKH.add(txtMaTaiKhoan);
		
		JPanel pnlTacVuCon = new JPanel();
		pnlTacVuCon.setBounds(9, 736, 330, 108);
		pnlThongTinKH.add(pnlTacVuCon);
		pnlTacVuCon.setBackground(Color.white);
		pnlTacVuCon.setBorder(BorderFactory.createTitledBorder("Tìm kiếm theo : "));
		pnlTacVuCon.setLayout(null);
		
		txtTimKiem = new JTextField("Nhập thông tin cần tìm");
		txtTimKiem.setBounds(10, 40, 308, 40);
		pnlTacVuCon.add(txtTimKiem);
		txtTimKiem.setColumns(10);
		
				group = new ButtonGroup();
				
				JComboBox comboBox = new JComboBox();
				comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
				comboBox.setBounds(20, 100, 319, 40);
				pnlThongTinKH.add(comboBox);
				
				JLabel lblMtKhu = new JLabel("Mật khẩu  :");
				lblMtKhu.setFont(new Font("Times New Roman", Font.PLAIN, 24));
				lblMtKhu.setBounds(10, 315, 187, 30);
				pnlThongTinKH.add(lblMtKhu);
				
				txtMatKhau = new JPasswordField();
				txtMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 18));
				txtMatKhau.setEditable(false);
				txtMatKhau.setBounds(20, 380, 319, 40);
				pnlThongTinKH.add(txtMatKhau);
				txtMatKhau.setColumns(10);
				
				JLabel lblPhanQuyen = new JLabel("Phân quyền :");
				lblPhanQuyen.setFont(new Font("Times New Roman", Font.PLAIN, 24));
				lblPhanQuyen.setBounds(10, 455, 187, 30);
				pnlThongTinKH.add(lblPhanQuyen);
				
				cboPhanQuyen = new JComboBox();
				cboPhanQuyen.setFont(new Font("Tahoma", Font.PLAIN, 18));
				cboPhanQuyen.setBounds(20, 520, 319, 40);
				pnlThongTinKH.add(cboPhanQuyen);
				
				txtTimKiem.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtTimKiem.getText().equals("Nhập thông tin cần tìm")) {
                    txtTimKiem.setText("");
                    txtTimKiem.setForeground(Color.BLACK); // Đổi màu chữ khi có focus
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtTimKiem.getText().isEmpty()) {
                    txtTimKiem.setText("Nhập thông tin cần tìm");
                    txtTimKiem.setForeground(Color.GRAY); // Đổi màu chữ gợi ý khi mất focus
                }
            }
        });
				
		
		JPanel pnlTacVu = new JPanel();
		pnlTacVu.setBackground(Color.white);
		pnlTacVu.setBounds(370, 855, 1530, 80);
		pnlTacVu.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ:"));
		contentPane.add(pnlTacVu);
		pnlTacVu.setLayout(null);
		
		btnThem = new JButton("Thêm");
		btnThem.setBounds(140, 21, 180, 48);
		pnlTacVu.add(btnThem);
		btnThem.setFont(font2);
		btnThem.setIcon(new ImageIcon(GuiQuanLyTaiKhoan.class.getResource("/image/TacVu_Them1.png")));
		btnThem.setBackground(Color.WHITE);
		
		btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnSua.setBounds(410, 21, 180, 48);
		pnlTacVu.add(btnSua);
		btnSua.setIcon(new ImageIcon(GuiQuanLyTaiKhoan.class.getResource("/image/TacVu_Sua.png")));
		btnSua.setBackground(Color.WHITE);
		
		btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnXoa.setBounds(680, 21, 180, 48);
		pnlTacVu.add(btnXoa);
		btnXoa.setIcon(new ImageIcon(GuiQuanLyTaiKhoan.class.getResource("/image/TacVu_Xoa1.png")));
		btnXoa.setBackground(Color.WHITE);
		
		btnLuu = new JButton("Lưu");
		btnLuu.setEnabled(false);
		btnLuu.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnLuu.setBounds(950, 21, 180, 48);
		pnlTacVu.add(btnLuu);
		btnLuu.setIcon(new ImageIcon(GuiQuanLyTaiKhoan.class.getResource("/image/TacVu_Luu.png")));
		btnLuu.setBackground(Color.WHITE);
		
		btnDatLai = new JButton("Đặt lại");
		btnDatLai.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnDatLai.setBounds(1220, 21, 180, 48);
		pnlTacVu.add(btnDatLai);
		btnDatLai.setIcon(new ImageIcon(GuiQuanLyTaiKhoan.class.getResource("/image/TacVu_DatLai.png")));
		btnDatLai.setBackground(Color.WHITE);;
		
		
		JPanel pnlBangTK = new JPanel();
		pnlBangTK.setBounds(370, 80, 1531, 765);
		contentPane.add(pnlBangTK);
		pnlBangTK.setBorder(BorderFactory.createTitledBorder("Bảng thông tin tài khoản"));
		pnlBangTK.setLayout(null);
		
		

		pnlBangTK.setBackground(Color.white);;
		modelTK = new DefaultTableModel();
		modelTK.addColumn("Mã tài khoản");
		modelTK.addColumn("Mật khẩu");
		modelTK.addColumn("Phân quyền");

		tblTK = new JTable(modelTK);
		tblTK.setBackground(new Color(153, 204, 255));
		JScrollPane jScrollPane = new JScrollPane(tblTK);
		jScrollPane.setBounds(20, 20, 1495, 725);
		JTableHeader tbHeaderTK = tblTK.getTableHeader();
		tbHeaderTK.setFont(font2);
		tbHeaderTK.setBackground(new Color(51, 204, 204));
		pnlBangTK.setLayout(null);
		tblTK.setFont(font2);
		tblTK.setRowHeight(35);
		// String row[] = {"KH001","Nguyễn Văn B","0123456789","0","Thường"," "};
		// modelKH.addRow(row);
		pnlBangTK.add(jScrollPane);
		
		txtTrangThai = new JTextField("Không có hoạt động nào gần nhất");
		txtTrangThai.setForeground(Color.red);
		txtTrangThai.setHorizontalAlignment(SwingConstants.CENTER);
		txtTrangThai.setBounds(20, 945, 1884, 20);
		contentPane.add(txtTrangThai);
		txtTrangThai.setColumns(10);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
