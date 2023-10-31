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

import com.toedter.calendar.JDateChooser;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class GuiQuanLyNhanVien extends JFrame implements ActionListener {

	public static JPanel contentPane;
	private JTextField txtMaNV;
	private JTextField txtTenNV;
	private JTextField txtCCCD;
	private JTextField txtDiaChi;
	private JTextField txtDTL;
	private JTextField txtEmail;
	private JTextField txtTimKiem;
	private DefaultTableModel modelKH;
	private JTable tblKH;
	private JTextField txtTrangThai;
	private JDateChooser dtmNgaySinh;
	private JDateChooser dtmNgayVaoLam;
	private JButton btnChonAnh;
	private JRadioButton radMaNV;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiQuanLyNhanVien frame = new GuiQuanLyNhanVien();
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
	public GuiQuanLyNhanVien() {
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
		Font font3 = new Font("Times New Roman", Font.PLAIN, 18);
		

		// Màu chữ
		Color color1 = new Color(138, 43, 226); // BlueViolet
		Color color2 = new Color(233, 221, 244);
	
		//Tiêu đề
		JPanel pnlTieuDe = new JPanel();
		pnlTieuDe.setBounds(10, 10, 1894, 60);
		pnlTieuDe.setBackground(new Color(255, 255, 255));
		contentPane.add(pnlTieuDe);
		
		JLabel lblTieuDe = new JLabel("QUẢN LÝ NHÂN VIÊN");
		lblTieuDe.setBackground(new Color(51, 204, 255));
		pnlTieuDe.add(lblTieuDe);
		lblTieuDe.setFont(font1);
		lblTieuDe.setForeground(new Color(0, 204, 204));
		
		JPanel pnlThongTinKH = new JPanel();
		pnlThongTinKH.setBackground(new Color(255, 255, 255));
		
		pnlThongTinKH.setBorder(BorderFactory.createTitledBorder("Thông tin nhân viên"));
		pnlThongTinKH.setBounds(10, 80, 1894, 280);
		contentPane.add(pnlThongTinKH);
		pnlThongTinKH.setLayout(null);
		
		JLabel lblMaNV = new JLabel("Mã nhân viên:");
		lblMaNV.setBounds(50, 35, 163, 30);
		pnlThongTinKH.add(lblMaNV);
		lblMaNV.setFont(font2);
		
		JLabel lblTenNV = new JLabel("Tên nhân viên :");
		lblTenNV.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblTenNV.setBounds(450, 35, 187, 29);
		pnlThongTinKH.add(lblTenNV);
		
		JLabel lblCCCD = new JLabel("CMT/ CCCD :");
		lblCCCD.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblCCCD.setBounds(850, 35, 163, 29);
		pnlThongTinKH.add(lblCCCD);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblEmail.setBounds(50, 130, 163, 30);
		pnlThongTinKH.add(lblEmail);
		
		JLabel lblSDT = new JLabel("Số điện thoại :");
		lblSDT.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblSDT.setBounds(450, 130, 163, 29);
		pnlThongTinKH.add(lblSDT);
		
		JLabel lblNgayVaoLam = new JLabel("Ngày vào làm :");
		lblNgayVaoLam.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblNgayVaoLam.setBounds(850, 130, 163, 29);
		pnlThongTinKH.add(lblNgayVaoLam);
		
		JLabel lblDTL = new JLabel("Địa chỉ :");
		lblDTL.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblDTL.setBounds(50, 235, 81, 29);
		pnlThongTinKH.add(lblDTL);
		
		txtMaNV = new JTextField();
		txtMaNV.setEditable(false);
		txtMaNV.setBounds(50, 80, 300, 35);
		pnlThongTinKH.add(txtMaNV);
		txtMaNV.setColumns(10);
		
		txtTenNV = new JTextField();
		txtTenNV.setColumns(10);
		txtTenNV.setBounds(450, 80, 300, 35);
		pnlThongTinKH.add(txtTenNV);
		
		txtCCCD = new JTextField();
		txtCCCD.setColumns(10);
		txtCCCD.setBounds(850, 80, 300, 35);
		pnlThongTinKH.add(txtCCCD);
		
		dtmNgayVaoLam = new JDateChooser();
		dtmNgayVaoLam.setBounds(850, 175, 300, 35);
		pnlThongTinKH.add(dtmNgayVaoLam);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(450, 175, 300, 35);
		pnlThongTinKH.add(txtDiaChi);
		
		txtDTL = new JTextField();
		txtDTL.setColumns(10);
		txtDTL.setBounds(142, 230, 206, 35);
		pnlThongTinKH.add(txtDTL);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(50, 175, 300, 35);
		pnlThongTinKH.add(txtEmail);
		
		dtmNgaySinh = new JDateChooser();
		dtmNgaySinh.setBounds(1250, 80, 300, 35);
		pnlThongTinKH.add(dtmNgaySinh);

		
		JLabel lblNgySinh = new JLabel("Ngày sinh :");
		lblNgySinh.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblNgySinh.setBounds(1250, 35, 163, 30);
		pnlThongTinKH.add(lblNgySinh);
		
		JPanel pnlAnhNhanVien = new JPanel();
		pnlAnhNhanVien.setBackground(new Color(255, 255, 255));
		pnlAnhNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlAnhNhanVien.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Ảnh nhân viên", TitledBorder.CENTER, TitledBorder.TOP, font2, new Color(0, 0, 0)));
		pnlAnhNhanVien.setBounds(1670, 11, 214, 258);
		pnlThongTinKH.add(pnlAnhNhanVien);
		pnlAnhNhanVien.setLayout(null);
		
		JPanel pnlChuaAnh = new JPanel();
		pnlChuaAnh.setBackground(new Color(255, 255, 255));
		pnlChuaAnh.setBounds(10, 31, 194, 216);
		pnlAnhNhanVien.add(pnlChuaAnh);
		pnlChuaAnh.setLayout(null);
		
		btnChonAnh = new JButton("");
		btnChonAnh.setBackground(new Color(255, 255, 255));
		btnChonAnh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnChonAnh.setBounds(62, 73, 70, 70);
		btnChonAnh.setIcon(new ImageIcon(GuiQuanLyNhanVien.class.getResource("/image/ChonAnh.png")));
		pnlChuaAnh.add(btnChonAnh);
		
		JLabel lblGioiTinh = new JLabel("Giới tính:");
		lblGioiTinh.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblGioiTinh.setBounds(1250, 130, 163, 30);
		pnlThongTinKH.add(lblGioiTinh);
		
		JComboBox cboGioiTinh = new JComboBox();
		cboGioiTinh.setBounds(1250, 175, 300, 35);
		pnlThongTinKH.add(cboGioiTinh);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(596, 230, 154, 35);
		pnlThongTinKH.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(1000, 230, 150, 35);
		pnlThongTinKH.add(comboBox_1);
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setBounds(1400, 230, 150, 35);
		pnlThongTinKH.add(comboBox_1_1);
		
		JLabel lblPhuongXa = new JLabel("Phường / Xã:");
		lblPhuongXa.setBounds(450, 235, 136, 29);
		lblPhuongXa.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		pnlThongTinKH.add(lblPhuongXa);
		
		JLabel lblQuan = new JLabel("Quận/ Huyện :");
		lblQuan.setBounds(850, 235, 147, 29);
		lblQuan.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		pnlThongTinKH.add(lblQuan);
		
		JLabel lblTinh = new JLabel("Tỉnh/ T.Phố :");
		lblTinh.setBounds(1250, 235, 140, 29);
		lblTinh.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		pnlThongTinKH.add(lblTinh);
		
		
		JPanel pnlTacVu = new JPanel();
		pnlTacVu.setBackground(Color.white);
		pnlTacVu.setBounds(10, 370, 1894, 80);
		pnlTacVu.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ:"));
		contentPane.add(pnlTacVu);
		pnlTacVu.setLayout(null);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setBounds(100, 21, 180, 48);
		pnlTacVu.add(btnThem);
		btnThem.setFont(font2);
		btnThem.setIcon(new ImageIcon(GuiQuanLyNhanVien.class.getResource("/image/TacVu_Them1.png")));
		btnThem.setBackground(Color.WHITE);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnSua.setBounds(320, 21, 180, 48);
		pnlTacVu.add(btnSua);
		btnSua.setIcon(new ImageIcon(GuiQuanLyNhanVien.class.getResource("/image/TacVu_Sua.png")));
		btnSua.setBackground(Color.WHITE);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnXoa.setBounds(550, 21, 180, 48);
		pnlTacVu.add(btnXoa);
		btnXoa.setIcon(new ImageIcon(GuiQuanLyNhanVien.class.getResource("/image/TacVu_Xoa1.png")));
		btnXoa.setBackground(Color.WHITE);
		
		JButton btnLuu = new JButton("Lưu");
		btnLuu.setEnabled(false);
		btnLuu.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnLuu.setBounds(780, 21, 180, 48);
		pnlTacVu.add(btnLuu);
		btnLuu.setIcon(new ImageIcon(GuiQuanLyNhanVien.class.getResource("/image/TacVu_Luu.png")));
		btnLuu.setBackground(Color.WHITE);
		
		JButton btnDatLai = new JButton("Đặt lại");
		btnDatLai.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnDatLai.setBounds(1010, 21, 180, 48);
		pnlTacVu.add(btnDatLai);
		btnDatLai.setIcon(new ImageIcon(GuiQuanLyNhanVien.class.getResource("/image/TacVu_DatLai.png")));
		btnDatLai.setBackground(Color.WHITE);
		
		JPanel pnlTacVuCon = new JPanel();
		pnlTacVuCon.setBackground(Color.white);;
		pnlTacVuCon.setBounds(1286, 11, 598, 58);
		pnlTacVuCon.setBorder(BorderFactory.createTitledBorder("Tìm kiếm theo : "));
		pnlTacVu.add(pnlTacVuCon);
		pnlTacVuCon.setLayout(null);
		
		txtTimKiem = new JTextField("Nhập thông tin cần tìm");
		txtTimKiem.setBounds(280, 13, 308, 36);
		pnlTacVuCon.add(txtTimKiem);
		txtTimKiem.setColumns(10);
		
		JRadioButton radSDT = new JRadioButton("Số điện thoại");
		radSDT.setBackground(new Color(255, 255, 255));
		radSDT.setBounds(133, 12, 109, 23);
		pnlTacVuCon.add(radSDT);

		
		JRadioButton radTenNV = new JRadioButton("Tên nhân viên");
		radTenNV.setBackground(new Color(255, 255, 255));
		radTenNV.setBounds(133, 30, 126, 23);
		pnlTacVuCon.add(radTenNV);
		
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
		
		ButtonGroup group = new ButtonGroup();
		group.add(radTenNV);
		group.add(radSDT);
		
		radMaNV = new JRadioButton("Mã nhân viên");
		radMaNV.setBackground(new Color(255, 255, 255));
		radMaNV.setBounds(8, 30, 109, 23);
		pnlTacVuCon.add(radMaNV);
		group.add(radMaNV);
		
		JPanel pnlBangKH = new JPanel();
		pnlBangKH.setBounds(10, 460, 1894, 480);
		contentPane.add(pnlBangKH);
		pnlBangKH.setBorder(BorderFactory.createTitledBorder("Bảng thông tin nhân viên"));
		pnlBangKH.setLayout(null);
		
		

		pnlBangKH.setBackground(Color.white);;
		modelKH = new DefaultTableModel();
		modelKH.addColumn("Mã nhân viên");
		modelKH.addColumn("Tên nhân viên");
		modelKH.addColumn("CCCD");
		modelKH.addColumn("Ngày Sinh");
		modelKH.addColumn("Email");
		modelKH.addColumn("Số điện thoại");
		modelKH.addColumn("Ngày vào làm");
		tblKH = new JTable(modelKH);
		tblKH.setBackground(new Color(153, 204, 255));
		JScrollPane jScrollPane = new JScrollPane(tblKH);
		jScrollPane.setBounds(15, 15, 1869, 450);
		JTableHeader tbHeaderKH = tblKH.getTableHeader();
		tbHeaderKH.setFont(font2);
		tbHeaderKH.setBackground(new Color(51, 204, 204));
		pnlBangKH.setLayout(null);
		tblKH.setFont(font2);
		tblKH.setRowHeight(35);
		pnlBangKH.add(jScrollPane);
		
		txtTrangThai = new JTextField("Không có hoạt động nào gần nhất");
		txtTrangThai.setForeground(Color.red);
		txtTrangThai.setHorizontalAlignment(SwingConstants.CENTER);
		txtTrangThai.setBounds(10, 950, 1894, 20);
		contentPane.add(txtTrangThai);
		txtTrangThai.setColumns(10);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
