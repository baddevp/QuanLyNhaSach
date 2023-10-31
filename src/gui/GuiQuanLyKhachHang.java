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

public class GuiQuanLyKhachHang extends JFrame implements ActionListener {

	public static JPanel contentPane;
	private JTextField txtMaKH;
	private JTextField txtTenKH;
	private JTextField txtSDT;
	private JTextField txtNgayLap;
	private JTextField txtDiaChi;
	private JTextField txtDTL;
	private JTextField txtEmail;
	private JTextField txtTimKiem;
	private DefaultTableModel modelKH;
	private JTable tblKH;
	private JTextField txtTrangThai;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiQuanLyKhachHang frame = new GuiQuanLyKhachHang();
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
	public GuiQuanLyKhachHang() {
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
		
		JLabel lblTieuDe = new JLabel("QUẢN LÝ KHÁCH HÀNG");
		lblTieuDe.setBackground(new Color(51, 204, 255));
		pnlTieuDe.add(lblTieuDe);
		lblTieuDe.setFont(font1);
		lblTieuDe.setForeground(new Color(0, 204, 204));
		
		JPanel pnlThongTinKH = new JPanel();
		pnlThongTinKH.setBackground(new Color(255, 255, 255));
		
		pnlThongTinKH.setBorder(BorderFactory.createTitledBorder("Thông tin khách hàng"));
		pnlThongTinKH.setBounds(10, 80, 1894, 280);
		contentPane.add(pnlThongTinKH);
		pnlThongTinKH.setLayout(null);
		
		JLabel lblMaKH = new JLabel("Mã khách hàng:");
		lblMaKH.setBounds(148, 38, 163, 29);
		pnlThongTinKH.add(lblMaKH);
		lblMaKH.setFont(font2);
		
		JLabel lblTenKH = new JLabel("Tên khách hàng :");
		lblTenKH.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblTenKH.setBounds(681, 38, 187, 29);
		pnlThongTinKH.add(lblTenKH);
		
		JLabel lblSDT = new JLabel("Số điện thoại :");
		lblSDT.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblSDT.setBounds(1271, 38, 163, 29);
		pnlThongTinKH.add(lblSDT);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblEmail.setBounds(148, 118, 163, 29);
		pnlThongTinKH.add(lblEmail);
		
		JLabel lblDiaChi = new JLabel("Địa chỉ :");
		lblDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblDiaChi.setBounds(681, 118, 163, 29);
		pnlThongTinKH.add(lblDiaChi);
		
		JLabel lblNgayLap = new JLabel("Ngày lập :");
		lblNgayLap.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblNgayLap.setBounds(1271, 118, 163, 29);
		pnlThongTinKH.add(lblNgayLap);
		
		JLabel lblDTL = new JLabel("Điểm tích lũy :");
		lblDTL.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblDTL.setBounds(148, 224, 163, 29);
		pnlThongTinKH.add(lblDTL);
		
		txtMaKH = new JTextField();
		txtMaKH.setEditable(false);
		txtMaKH.setBounds(148, 78, 442, 34);
		pnlThongTinKH.add(txtMaKH);
		txtMaKH.setColumns(10);
		
		txtTenKH = new JTextField();
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(681, 78, 442, 34);
		pnlThongTinKH.add(txtTenKH);
		
		txtSDT = new JTextField();
		txtSDT.setColumns(10);
		txtSDT.setBounds(1271, 73, 442, 34);
		pnlThongTinKH.add(txtSDT);
		
		txtNgayLap = new JTextField();
		txtNgayLap.setColumns(10);
		txtNgayLap.setBounds(1271, 165, 442, 34);
		pnlThongTinKH.add(txtNgayLap);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(681, 165, 442, 34);
		pnlThongTinKH.add(txtDiaChi);
		
		txtDTL = new JTextField();
		txtDTL.setEditable(false);
		txtDTL.setColumns(10);
		txtDTL.setBounds(305, 218, 285, 41);
		pnlThongTinKH.add(txtDTL);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(148, 158, 442, 41);
		pnlThongTinKH.add(txtEmail);
		
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
		btnThem.setIcon(new ImageIcon(GuiQuanLyKhachHang.class.getResource("/image/TacVu_Them1.png")));
		btnThem.setBackground(Color.WHITE);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnSua.setBounds(320, 21, 180, 48);
		pnlTacVu.add(btnSua);
		btnSua.setIcon(new ImageIcon(GuiQuanLyKhachHang.class.getResource("/image/TacVu_Sua.png")));
		btnSua.setBackground(Color.WHITE);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnXoa.setBounds(550, 21, 180, 48);
		pnlTacVu.add(btnXoa);
		btnXoa.setIcon(new ImageIcon(GuiQuanLyKhachHang.class.getResource("/image/TacVu_Xoa1.png")));
		btnXoa.setBackground(Color.WHITE);
		
		JButton btnLuu = new JButton("Lưu");
		btnLuu.setEnabled(false);
		btnLuu.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnLuu.setBounds(780, 21, 180, 48);
		pnlTacVu.add(btnLuu);
		btnLuu.setIcon(new ImageIcon(GuiQuanLyKhachHang.class.getResource("/image/TacVu_Luu.png")));
		btnLuu.setBackground(Color.WHITE);
		
		JButton btnDatLai = new JButton("Đặt lại");
		btnDatLai.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnDatLai.setBounds(1010, 21, 180, 48);
		pnlTacVu.add(btnDatLai);
		btnDatLai.setIcon(new ImageIcon(GuiQuanLyKhachHang.class.getResource("/image/TacVu_DatLai.png")));
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

		
		JRadioButton radTenKH = new JRadioButton("Tên khách hàng");
		radTenKH.setBackground(new Color(255, 255, 255));
		radTenKH.setBounds(133, 30, 126, 23);
		pnlTacVuCon.add(radTenKH);
		
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
		group.add(radTenKH);
		group.add(radSDT);
		
		JPanel pnlBangKH = new JPanel();
		pnlBangKH.setBounds(10, 460, 1894, 450);
		contentPane.add(pnlBangKH);
		pnlBangKH.setBorder(BorderFactory.createTitledBorder("Bảng thông tin khách hàng"));
		pnlBangKH.setLayout(null);
		
		

		pnlBangKH.setBackground(Color.white);;
		modelKH = new DefaultTableModel();
		modelKH.addColumn("Mã khách hàng");
		modelKH.addColumn("Tên khách hàng");
		modelKH.addColumn("Số điện thoại");
		modelKH.addColumn("Địa chỉ");
		modelKH.addColumn("Email");
		modelKH.addColumn("Ngày lập");
		modelKH.addColumn("Điểm tích lũy");
		tblKH = new JTable(modelKH);
		tblKH.setBackground(new Color(153, 204, 255));
		JScrollPane jScrollPane = new JScrollPane(tblKH);
		jScrollPane.setBounds(22, 28, 1850, 402);
		JTableHeader tbHeaderKH = tblKH.getTableHeader();
		tbHeaderKH.setFont(font2);
		tbHeaderKH.setBackground(new Color(51, 204, 204));
		pnlBangKH.setLayout(null);
		tblKH.setFont(font2);
		tblKH.setRowHeight(35);
		// String row[] = {"KH001","Nguyễn Văn B","0123456789","0","Thường"," "};
		// modelKH.addRow(row);
		pnlBangKH.add(jScrollPane);
		
		txtTrangThai = new JTextField("Không có hoạt động nào gần nhất");
		txtTrangThai.setForeground(Color.red);
		txtTrangThai.setHorizontalAlignment(SwingConstants.CENTER);
		txtTrangThai.setBounds(10, 920, 1894, 20);
		contentPane.add(txtTrangThai);
		txtTrangThai.setColumns(10);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
