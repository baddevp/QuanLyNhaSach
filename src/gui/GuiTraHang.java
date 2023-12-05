package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

import connectDB.ConnectDB;
import dao.DAO_ChiTietHoaDon;
import dao.DAO_ChiTietHoanTra;
import dao.DAO_HoaDon;
import dao.DAO_HoaDonTraHang;
import dao.DAO_KhachHang;
import dao.DAO_MauSac;
import dao.DAO_NhanVien;
import dao.DAO_QuanLySach;
import dao.DAO_QuanLyVPP;
import entity.ChiTietHoaDon;
import entity.ChiTietHoanTra;
import entity.HoaDon;
import entity.HoaDonHoanTra;
import entity.KhachHang;
import entity.MauSac;
import entity.NhanVien;
import entity.Sach;
import entity.SanPham;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import com.toedter.calendar.JDateChooser;
import java.util.Date;
import java.util.regex.Pattern;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;

public class GuiTraHang extends JFrame implements ActionListener, MouseListener {

	public static JPanel contentPane;
	DAO_HoaDon dao_HoaDon = new DAO_HoaDon();
	DAO_HoaDonTraHang dao_HoaDonHT = new DAO_HoaDonTraHang();
	DAO_NhanVien dao_NhanVien = new DAO_NhanVien();
	DAO_KhachHang dao_KhachHang = new DAO_KhachHang();
	DAO_ChiTietHoaDon dao_CTHD = new DAO_ChiTietHoaDon();
	DAO_ChiTietHoanTra dao_chiTietTra = new DAO_ChiTietHoanTra();
	DAO_ChiTietHoanTra dao_HoanTra = new DAO_ChiTietHoanTra();
	DAO_QuanLySach dao_QLSach = new DAO_QuanLySach();
	DAO_QuanLyVPP dao_QLVPP  = new DAO_QuanLyVPP();
	private JTextField txtTimKiem;
	private DefaultTableModel modelHD;
	private JTable tblHD;
	private JTextField txtTrangThai;
	private ButtonGroup group;
	private DAO_MauSac dao_mausac;
	private Component btnXoaTrang;
	private JButton btnChon;
	private JPanel pnlChonHDTH;
	private JTextField txtTimSP;
	private JTextField txtMaTraHang;
	private JTextField txtTenNVTraHang;
	private JTextField txtSDT;
	private JTextField txtTenKH;
	private JTextField txtDTL;
	private JTextField txtTongSP;
	private JTextField txtTienHoanTra;
	private JPanel pnlLapHoaDonTH;
	private JTextField txtMaHD;
	private JTextField txtTongTien;
	private JTextField txtNhanVienLHD;
	private Component dtmNgayLapTH;
	private JTextField txtNgayLap;

	static NhanVien nv;
	private JTextField txtLyDo;
	private JScrollPane jScrollPaneSPTra;
	private DefaultTableModel modelSPDM;
	private JTable tblSPDM;
	private JTable tblSPTra;
	private DefaultTableModel modelSPTra;
	private JButton btnDoiHD;
	private JButton btnChonTatCa;
	private JButton btnXoaDong;
	private JButton btnTraHang;
	private JButton btnSuaSL;
	private JComboBox cbxPhanLoai;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiTraHang frame = new GuiTraHang(nv);
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
	public GuiTraHang(NhanVien nv) {
		this.nv = nv;
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
		Color color1 = new Color(138, 43, 226);
		Color color2 = new Color(233, 221, 244);

		// Tiêu đề
		JPanel pnlTieuDe = new JPanel();
		pnlTieuDe.setBounds(10, 10, 1891, 60);
		pnlTieuDe.setBackground(new Color(255, 255, 255));
		contentPane.add(pnlTieuDe);

		JLabel lblTieuDe = new JLabel("TRẢ HÀNG");
		lblTieuDe.setBackground(new Color(51, 204, 255));
		pnlTieuDe.add(lblTieuDe);
		lblTieuDe.setFont(font1);
		lblTieuDe.setForeground(new Color(0, 204, 204));
		// Form chon hoa don tra hang
		pnlChonHDTH = new JPanel();
		pnlChonHDTH.setBackground(new Color(255, 255, 255));

		pnlChonHDTH.setBounds(10, 79, 1891, 890);
		contentPane.add(pnlChonHDTH);
		pnlChonHDTH.setLayout(null);

		group = new ButtonGroup();

		txtTimKiem = new JTextField("Nhập thông tin cần tìm");
		txtTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTimKiem.setBounds(370, 24, 800, 40);
		pnlChonHDTH.add(txtTimKiem);
		txtTimKiem.setColumns(10);
		txtTimKiem.addKeyListener((KeyListener) new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String tuKhoa = txtTimKiem.getText().trim();
				timKiemTheoMaHD(tuKhoa);
			}

		});

		modelHD = new DefaultTableModel();
		modelHD.addColumn("Mã hóa đơn");
		modelHD.addColumn("Ngày lập hóa đơn");
		modelHD.addColumn("Tổng tiền");
		modelHD.addColumn("Nhân viên");
		modelHD.addColumn("Khách hàng");
		modelHD.addColumn("Trạng thái");
		tblHD = new JTable(modelHD);
		tblHD.setBackground(new Color(153, 204, 255));
		tblHD.setFont(font2);
		tblHD.setRowHeight(35);
		JTableHeader tbHeaderHD = tblHD.getTableHeader();
		tbHeaderHD.setFont(font2);
		tbHeaderHD.setBackground(new Color(51, 204, 204));
		JScrollPane jScrollPane = new JScrollPane(tblHD);
		jScrollPane.setBounds(20, 81, 1850, 796);
		pnlChonHDTH.add(jScrollPane);

		JLabel lblNewLabel = new JLabel("Chọn hóa đơn hoàn trả :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(59, 25, 268, 33);
		pnlChonHDTH.add(lblNewLabel);

		btnChon = new JButton("Chọn");
		btnChon.setBackground(new Color(51, 204, 204));
		btnChon.setForeground(new Color(255, 255, 255));
		btnChon.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnChon.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Object o = e.getSource();
				if (o.equals(btnChon)) {

				}
			}
		});
		btnChon.setBounds(1270, 24, 250, 40);
		pnlChonHDTH.add(btnChon);
		
		cbxPhanLoai = new JComboBox();
		cbxPhanLoai.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		cbxPhanLoai.setBounds(1620, 24, 250, 40);
		cbxPhanLoai.addItem("Chưa trả");
		cbxPhanLoai.setSelectedIndex(0);
		cbxPhanLoai.addItem("Đã trả");
		cbxPhanLoai.addItem("Tất cả");
		pnlChonHDTH.add(cbxPhanLoai);
		cbxPhanLoai.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String selectedCategory = cbxPhanLoai.getSelectedItem().toString();
				if (selectedCategory.equalsIgnoreCase("Chưa trả")) {
					modelHD.setRowCount(0);
					DocDuLieuDatataabase(selectedCategory);
				} else if (selectedCategory.equalsIgnoreCase("Đã trả")) {
					modelHD.setRowCount(0);
					DocDuLieuDatataabase(selectedCategory);
				} else {
					modelHD.setRowCount(0);
					DocDuLieuDatataabase("Tất cả");
				}
					
			}
		});

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
		;
		;

		// Form tra hang
		pnlLapHoaDonTH = new JPanel();
		pnlLapHoaDonTH.setBackground(new Color(51, 204, 204));
		pnlLapHoaDonTH.setLayout(null);
		pnlLapHoaDonTH.setBounds(10, 80, 1890, 894);
		contentPane.add(pnlLapHoaDonTH);

		JPanel pnlChonKhachHang = new JPanel();
		pnlChonKhachHang.setLayout(null);
		pnlChonKhachHang.setBorder(new EmptyBorder(0, 0, 0, 0));
		pnlChonKhachHang.setBackground(Color.WHITE);
		pnlChonKhachHang.setBounds(0, 0, 963, 249);
		pnlLapHoaDonTH.add(pnlChonKhachHang);

		JPanel pnlTimKiemSP = new JPanel();
		pnlTimKiemSP.setLayout(null);
		pnlTimKiemSP.setBounds(10, 58, 935, 180);
		pnlChonKhachHang.add(pnlTimKiemSP);

		JLabel lblMH = new JLabel("Mã hóa đơn :");
		lblMH.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblMH.setBounds(20, 20, 150, 30);
		pnlTimKiemSP.add(lblMH);

		txtMaHD = new JTextField();
		txtMaHD.setText("");
		txtMaHD.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtMaHD.setEditable(false);
		txtMaHD.setColumns(10);
		txtMaHD.setBounds(170, 20, 250, 34);
		pnlTimKiemSP.add(txtMaHD);

		JLabel lblNgayLapHD = new JLabel("Ngày lập :");
		lblNgayLapHD.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblNgayLapHD.setBounds(20, 70, 102, 30);
		pnlTimKiemSP.add(lblNgayLapHD);

		txtNgayLap = new JTextField();
		txtNgayLap.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtNgayLap.setEnabled(false);
		txtNgayLap.setBounds(170, 70, 250, 35);
		pnlTimKiemSP.add(txtNgayLap);

		JLabel lblTongTien = new JLabel("Tổng tiền :");
		lblTongTien.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblTongTien.setBounds(20, 120, 150, 30);
		pnlTimKiemSP.add(lblTongTien);

		txtTongTien = new JTextField();
		txtTongTien.setText("");
		txtTongTien.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTongTien.setEditable(false);
		txtTongTien.setColumns(10);
		txtTongTien.setBounds(170, 120, 250, 34);
		pnlTimKiemSP.add(txtTongTien);

		JLabel lblNhanVienLap = new JLabel("Nhân viên :");
		lblNhanVienLap.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblNhanVienLap.setBounds(474, 20, 127, 30);
		pnlTimKiemSP.add(lblNhanVienLap);

		txtNhanVienLHD = new JTextField();
		txtNhanVienLHD.setText("");
		txtNhanVienLHD.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtNhanVienLHD.setEditable(false);
		txtNhanVienLHD.setColumns(10);
		txtNhanVienLHD.setBounds(611, 16, 250, 34);
		pnlTimKiemSP.add(txtNhanVienLHD);

		btnDoiHD = new JButton("Đổi hóa đơn");
		btnDoiHD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object o = e.getSource();
				if (o.equals(btnDoiHD)) {
					int input = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn đổi hóa đơn không?",
							"Cảnh báo", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
					if (input == JOptionPane.YES_OPTION) {
						pnlChonHDTH.show();
						pnlLapHoaDonTH.hide();
					}
				}
			}
		});
		btnDoiHD.setForeground(Color.WHITE);
		btnDoiHD.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDoiHD.setBackground(new Color(51, 204, 204));
		btnDoiHD.setBounds(611, 92, 250, 45);
		pnlTimKiemSP.add(btnDoiHD);

		JLabel lblHoaDon = new JLabel("Thông tin hóa đơn :");
		lblHoaDon.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblHoaDon.setBounds(10, 11, 266, 36);
		pnlChonKhachHang.add(lblHoaDon);

		JPanel pnlHoaDonTraHang = new JPanel();
		pnlHoaDonTraHang.setLayout(null);
		pnlHoaDonTraHang.setBackground(Color.WHITE);
		pnlHoaDonTraHang.setBounds(973, 0, 917, 883);
		pnlLapHoaDonTH.add(pnlHoaDonTraHang);

		JPanel pnlThongTinTraHang = new JPanel();
		pnlThongTinTraHang.setLayout(null);
		pnlThongTinTraHang.setBounds(10, 56, 897, 177);
		pnlHoaDonTraHang.add(pnlThongTinTraHang);

		JLabel lblNgayLap = new JLabel("Ngày lập:");
		lblNgayLap.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblNgayLap.setBounds(299, 40, 102, 30);
		pnlThongTinTraHang.add(lblNgayLap);

		JLabel lblMaYCTH = new JLabel("Mã YCTH:");
		lblMaYCTH.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblMaYCTH.setBounds(10, 40, 126, 30);
		pnlThongTinTraHang.add(lblMaYCTH);

		JLabel lblTenNV = new JLabel("Tên NV :");
		lblTenNV.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblTenNV.setBounds(599, 40, 92, 30);
		pnlThongTinTraHang.add(lblTenNV);

		txtMaTraHang = new JTextField();
		txtMaTraHang.setText("");
		txtMaTraHang.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtMaTraHang.setEditable(false);
		txtMaTraHang.setColumns(10);
		txtMaTraHang.setBounds(120, 41, 169, 34);
		pnlThongTinTraHang.add(txtMaTraHang);

		// Thiết lâpj ngày lập hóa đơn trả hàng
		java.util.Date currentDate = new java.util.Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String formattedDate = dateFormat.format(currentDate);

		dtmNgayLapTH = new JDateChooser(currentDate);
		dtmNgayLapTH.setEnabled(false);
		dtmNgayLapTH.setBounds(393, 40, 196, 34);
		pnlThongTinTraHang.add(dtmNgayLapTH);

		txtTenNVTraHang = new JTextField();
		txtTenNVTraHang.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTenNVTraHang.setEditable(false);
		txtTenNVTraHang.setColumns(10);
		txtTenNVTraHang.setBounds(691, 40, 196, 34);
		pnlThongTinTraHang.add(txtTenNVTraHang);

		txtSDT = new JTextField();
		txtSDT.setEditable(false);
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtSDT.setColumns(10);
		txtSDT.setBounds(120, 109, 169, 34);
		pnlThongTinTraHang.add(txtSDT);

		JLabel lblSDTKH = new JLabel("SDT KH:");
		lblSDTKH.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblSDTKH.setBounds(10, 108, 92, 30);
		pnlThongTinTraHang.add(lblSDTKH);

		JLabel lblTenKH = new JLabel("Tên KH:");
		lblTenKH.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblTenKH.setBounds(299, 108, 92, 30);
		pnlThongTinTraHang.add(lblTenKH);

		txtTenKH = new JTextField();
		txtTenKH.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTenKH.setEditable(false);
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(393, 109, 196, 34);
		pnlThongTinTraHang.add(txtTenKH);

		JLabel lblDiemTL = new JLabel("Điểm TL:");
		lblDiemTL.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblDiemTL.setBounds(599, 108, 102, 30);
		pnlThongTinTraHang.add(lblDiemTL);

		txtDTL = new JTextField();
		txtDTL.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtDTL.setEditable(false);
		txtDTL.setColumns(10);
		txtDTL.setBounds(691, 109, 196, 34);
		pnlThongTinTraHang.add(txtDTL);

		btnXoaDong = new JButton("Xóa dòng");
		btnXoaDong.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnXoaDong.setBackground(Color.WHITE);
		btnXoaDong.setBounds(729, 250, 159, 36);
		pnlHoaDonTraHang.add(btnXoaDong);

		JLabel lblThongTinHD = new JLabel("Thông tin trả hàng :");
		lblThongTinHD.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblThongTinHD.setBounds(10, 9, 266, 36);
		pnlHoaDonTraHang.add(lblThongTinHD);

		JPanel pnlBangSPTra = new JPanel();
		pnlBangSPTra.setLayout(null);
		pnlBangSPTra.setBounds(10, 304, 897, 321);
		pnlHoaDonTraHang.add(pnlBangSPTra);

		// Bang san pham tra
		modelSPTra = new DefaultTableModel();
		modelSPTra.addColumn("Mã SP");
		modelSPTra.addColumn("Tên SP");
		modelSPTra.addColumn("Giá bán");
		modelSPTra.addColumn("Số lượng mua");
		modelSPTra.addColumn("Số lượng trả");
		modelSPTra.addColumn("Thành tiền");
		tblSPTra = new JTable(modelSPTra);
		tblSPTra.setBackground(new Color(153, 204, 255));
		tblSPTra.setFont(font2);
		tblSPTra.setRowHeight(30);
		JScrollPane jScrollPaneSPTra = new JScrollPane(tblSPTra);
		jScrollPaneSPTra.setBounds(10, 11, 925, 546);
		JTableHeader tbHeaderSPTra = tblSPTra.getTableHeader();
		tbHeaderSPTra.setFont(font2);
		tbHeaderSPTra.setBackground(new Color(51, 204, 204));
		jScrollPaneSPTra.setBounds(10, 10, 877, 300);
		pnlBangSPTra.add(jScrollPaneSPTra);

		JLabel lblTongSP = new JLabel("Tổng số SP:");
		lblTongSP.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblTongSP.setBounds(20, 630, 199, 30);
		pnlHoaDonTraHang.add(lblTongSP);

		txtTongSP = new JTextField();
		txtTongSP.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTongSP.setEditable(false);
		txtTongSP.setColumns(10);
		txtTongSP.setBounds(250, 630, 273, 30);
		pnlHoaDonTraHang.add(txtTongSP);

		JLabel lblTienKhachTra = new JLabel("Số tiền hoàn trả :");
		lblTienKhachTra.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblTienKhachTra.setBounds(20, 680, 199, 30);
		pnlHoaDonTraHang.add(lblTienKhachTra);

		txtTienHoanTra = new JTextField();
		txtTienHoanTra.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTienHoanTra.setEditable(false);
		txtTienHoanTra.setColumns(10);
		txtTienHoanTra.setBounds(250, 680, 273, 30);
		pnlHoaDonTraHang.add(txtTienHoanTra);

		btnTraHang = new JButton("TRẢ HÀNG");
		btnTraHang.setForeground(Color.WHITE);
		btnTraHang.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnTraHang.setBackground(new Color(51, 204, 204));
		btnTraHang.setBounds(659, 797, 216, 52);
		pnlHoaDonTraHang.add(btnTraHang);

		btnSuaSL = new JButton("Sửa số lượng");
		btnSuaSL.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSuaSL.setBackground(Color.WHITE);
		btnSuaSL.setBounds(549, 250, 170, 36);
		pnlHoaDonTraHang.add(btnSuaSL);

		JLabel lblSnPhmTr = new JLabel("Sản phẩm trả :");
		lblSnPhmTr.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSnPhmTr.setBounds(20, 260, 266, 36);
		pnlHoaDonTraHang.add(lblSnPhmTr);

		JCheckBox chkinHD = new JCheckBox("In hóa đơn");
		chkinHD.setFont(new Font("Tahoma", Font.BOLD, 18));
		chkinHD.setBounds(454, 823, 199, 23);
		pnlHoaDonTraHang.add(chkinHD);

		JLabel lblLyDo = new JLabel("Lý do trả hàng :");
		lblLyDo.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblLyDo.setBounds(20, 730, 199, 30);
		pnlHoaDonTraHang.add(lblLyDo);

		txtLyDo = new JTextField();
		txtLyDo.setText("Tra hang" + formattedDate);

		txtLyDo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtLyDo.setColumns(10);
		txtLyDo.setBounds(250, 730, 273, 30);
		pnlHoaDonTraHang.add(txtLyDo);

		JPanel pnlSanPhamDaMua = new JPanel();
		pnlSanPhamDaMua.setLayout(null);
		pnlSanPhamDaMua.setBackground(Color.WHITE);
		pnlSanPhamDaMua.setBounds(0, 260, 963, 623);
		pnlLapHoaDonTH.add(pnlSanPhamDaMua);

		JPanel pnlSanPham = new JPanel();
		pnlSanPham.setLayout(null);
		pnlSanPham.setBounds(10, 46, 945, 567);
		pnlSanPhamDaMua.add(pnlSanPham);

		// Bang san pham da mua
		modelSPDM = new DefaultTableModel();
		modelSPDM.addColumn("Mã SP");
		modelSPDM.addColumn("Tên SP");
		modelSPDM.addColumn("Giá bán");
		modelSPDM.addColumn("Số lượng");
		modelSPDM.addColumn("Thành tiền");
		tblSPDM = new JTable(modelSPDM);
		tblSPDM.setRowHeight(30);
		tblSPDM.setFont(font2);
		tblSPDM.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int selectedRow = tblSPDM.getSelectedRow();
				// Chọn được sản phẩm cần thêm
				if (selectedRow != -1) {
					String maSP = (String) tblSPDM.getValueAt(selectedRow, 0);
					String tenSP = (String) tblSPDM.getValueAt(selectedRow, 1);
					int soLuong = (int) tblSPDM.getValueAt(selectedRow, 3);
					double giaGoc = (double) tblSPDM.getValueAt(selectedRow, 2);
					int index = timSPTrongBangTra(maSP, tenSP);
					// Sản phẩm này chưa có trong bảng
					
					try {
						String input = JOptionPane.showInputDialog(tblSPDM,
								"Số lượng trả phải bé hơn hoặc bằng " + soLuong + ": ", "Nhập số lượng trả", soLuong);
						int soLuongTra = Integer.parseInt(input);
						if (soLuongTra > soLuong) {
							JOptionPane.showMessageDialog(pnlSanPhamDaMua, "Số lượng trả quá số lượng mua");
						} else if (soLuongTra == 0) {
							return;
						} else {
							chonSPTra(soLuongTra);
							modelSPDM.removeRow(selectedRow);
						}
					} catch (Exception e2) {
						// TODO: handle exception
						System.out.println("Số lượng trả rỗng");
					}
				}

			}

		});
		tblSPDM.setBackground(new Color(153, 204, 255));
		JScrollPane jScrollPaneSPDaMua = new JScrollPane(tblSPDM);
		jScrollPaneSPDaMua.setBounds(10, 11, 925, 546);
		JTableHeader tbHeaderSPDM = tblSPDM.getTableHeader();
		tbHeaderSPDM.setFont(font2);
		tbHeaderSPDM.setBackground(new Color(51, 204, 204));
		pnlSanPham.add(jScrollPaneSPDaMua);

		JLabel lblChonSP = new JLabel("Sản phẩm đã mua :");
		lblChonSP.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblChonSP.setBounds(10, 0, 266, 36);
		pnlSanPhamDaMua.add(lblChonSP);

		txtTimSP = new JTextField();
		txtTimSP.setBounds(204, 6, 500, 32);
		pnlSanPhamDaMua.add(txtTimSP);
		txtTimKiem.setFont(new Font("Times New Roman", Font.BOLD, 24));
		txtTimSP.setColumns(10);
		txtTimSP.addKeyListener((KeyListener) new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String tuKhoa = txtTimSP.getText().trim();
				timKiemTheoMaSP(tuKhoa);
			}

		});

		btnChonTatCa = new JButton("Chọn tất cả");
		btnChonTatCa.setForeground(Color.WHITE);
		btnChonTatCa.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnChonTatCa.setBackground(new Color(51, 204, 204));
		btnChonTatCa.setBounds(737, 6, 205, 32);
		pnlSanPhamDaMua.add(btnChonTatCa);

		pnlLapHoaDonTH.hide();

		try {
			ConnectDB.getInstance().connect();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		DocDuLieuDatataabase("Chưa trả");

		// Bắt sự kiện
		btnChon.addActionListener(this);
		tblHD.addMouseListener(this);
		tblSPDM.addMouseListener(this);
		btnXoaDong.addActionListener(this);
		btnTraHang.addActionListener(this);
		btnSuaSL.addActionListener(this);
		btnChonTatCa.addActionListener(this);

	}

	public void DocDuLieuDatataabase(String tt) {
		dao_HoaDon = new DAO_HoaDon();
		String trangThai = "";
		for (HoaDon hd : dao_HoaDon.getAllHD()) {
			KhachHang kh = dao_KhachHang.getKhachHangTheoMa(hd.getKhachHang().getMaKH());
			trangThai = dao_HoaDonHT.kiemTraTraHang(hd);
			//Lấy tất cả hóa đơn
			if(tt.equalsIgnoreCase("Tất cả")) {
				modelHD.addRow(new Object[] { hd.getMaHoaDon(), hd.getNgayLapHoaDon(), hd.getTongTien(),
						hd.getNhanVien().getMaNV(), kh.getTenKH(), trangThai });
			}
			//Phân loại
			else if(trangThai.equalsIgnoreCase(tt)) {
				modelHD.addRow(new Object[] { hd.getMaHoaDon(), hd.getNgayLapHoaDon(), hd.getTongTien(),
						hd.getNhanVien().getMaNV(), kh.getTenKH(), trangThai });
			}
			
		}
	}

	public String strTrangThai(Boolean tt) {
		if (tt) {
			return "Đã thanh toán";
		}
		return "Chờ thanh toán";
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnChon)) {
			int selectedRow = tblHD.getSelectedRow();
			if (selectedRow != -1) {
				// Nếu có dòng được chọn, chuyển sang màn hình trả hàng, ẩn màn hình chọn hóa
				// đơn
				pnlChonHDTH.hide();
				pnlLapHoaDonTH.show();
				// Chuẩn bị thông tin trả hàng
				// Hóa đơn cũ
				HoaDon hd = dao_HoaDon.getHDTheoMaHD(tblHD.getValueAt(selectedRow, 0).toString());
				txtMaHD.setText(hd.getMaHoaDon());
				txtTongTien.setText(hd.getTongTien() + "");
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				String ngayLap = hd.getNgayLapHoaDon().format(formatter);
				txtNgayLap.setText(ngayLap);
				NhanVien nvLHD = dao_NhanVien.getNhanVienTheoMa2(hd.getNhanVien().getMaNV());
				txtNhanVienLHD.setText(nvLHD.getTenNV());
				// Hóa đơn trả hàng
				txtTenNVTraHang.setText(nv.getTenNV());
				String maTH = generateMaHD();
				txtMaTraHang.setText(maTH);
				String sdtKH = hd.getKhachHang().getSdt();
				txtSDT.setText(sdtKH);
				String tenKH = hd.getKhachHang().getTenKH();
				txtTenKH.setText(tenKH);
				int diemTL = hd.getKhachHang().getDiemTL();
				txtDTL.setText(diemTL + "");
				
				String trangThaiHD = (String) tblHD.getValueAt(selectedRow, 5).toString();
				//Nếu hóa đơn đó lần đầu trả
				if(trangThaiHD.equalsIgnoreCase("Chưa trả")) {
					docChiTietHoaDon(hd.getMaHoaDon(), modelSPDM);
				} 
				//Sản phẩm trả rồi
				else {
					docChiTietTietTraHang(hd.getMaHoaDon(), modelSPTra, modelSPDM);
				}
			
				

			} else {
				// Nếu không có dòng nào được chọn, hiển thị thông báo
				JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn cần trả để chuyển trang trả hàng.",
						"Thông báo", JOptionPane.WARNING_MESSAGE);
			}
		} else if (o.equals(btnXoaDong)) {
			xoaDong();
		} else if (o.equals(btnChonTatCa)) {
			String maHD = txtMaHD.getText().trim();
			chonTatCaSP(maHD, modelSPTra);
			modelSPDM.setRowCount(0);
			tinhTongTienHoanTra();
		}else if (o.equals(btnSuaSL)) {
			thayDoiSoLuong();
		} 
		else if (o.equals(btnTraHang)) {
			int input = JOptionPane.showConfirmDialog(null, "Bạn có cần kiểm tra lại thông tin trả hàng không?",
					"Cảnh báo", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
			if (input == JOptionPane.NO_OPTION) {
				boolean f = themHoaDonTraHang();
				if(f == true) {
					JOptionPane.showMessageDialog(this, "Đơn hàng đã được trả thành công");
					xoaRong();
				}
				pnlChonHDTH.show();
				pnlLapHoaDonTH.hide();
			}
			
				
		}
	}
	//Đọc chi tiết sản phẩm đã trả trước đó
	private void docChiTietTietTraHang(String maHD, DefaultTableModel modelTra, DefaultTableModel modelDM ) {
		// TODO Auto-generated method stub
		//Đọc sản phẩm đã trả trước đó
		String maTH = dao_HoaDonHT.getMaTHTheoMaHD(maHD);
		for (ChiTietHoanTra ct : dao_chiTietTra.getDSTHTheoMaYCHT(maTH)) {
			double giaBan = ct.getSanPham().getGiaBan();
			int soLuong = ct.getSoLuongTra();
			double thanhTien = giaBan * soLuong;
			modelTra.addRow(new Object[] { ct.getSanPham().getMaSanPham(), ct.getSanPham().getTenSanPham(), giaBan,
					"",soLuong, thanhTien });
		}
		//Đọc sản phẩm chưa trả
		for (ChiTietHoaDon ct : dao_CTHD.getDSTheoMaHD(maHD)) {
			double giaBan = ct.getSanPham().getGiaBan();
			int soLuongMua = ct.getSoLuong();
			double thanhTien = giaBan * soLuongMua;
			
			String ma = ct.getSanPham().getMaSanPham();
			String ten = ct.getSanPham().getTenSanPham();
			int index = timSPTrongBangTra(ma, ten);
			//Sản phẩm này chưa trả
			if(index == -1) {
				modelSPDM.addRow(new Object[] { ma, ten, giaBan,
						soLuongMua, thanhTien });
			}
			//Sản phẩm đã trả trước đó
			else {
				modelSPTra.setValueAt(soLuongMua, index, 3);
			}
		}
		
	}

	//Thay đổi số lượng trả
	public void thayDoiSoLuong() {
		int selectedRow = tblSPTra.getSelectedRow();
		if (selectedRow == -1) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng để thay đổi số lượng.", "Thông báo",
					JOptionPane.WARNING_MESSAGE);
			return;
		}
		String maSP = (String) tblSPTra.getValueAt(selectedRow, 0);
		String tenSP = (String) tblSPTra.getValueAt(selectedRow, 1);
		int soLuongTra = (int) tblSPTra.getValueAt(selectedRow, 4);
		double giaGoc = (double) tblSPTra.getValueAt(selectedRow, 2);
		int soLuongMua = (int) tblSPTra.getValueAt(selectedRow, 3);

		String input = JOptionPane.showInputDialog(this, "Nhập số lượng cần trả " + tenSP + "mới :", soLuongMua);
		try {
			if (input != null ) {
				int newQuantity = Integer.parseInt(input);
				if (newQuantity > 0 && (newQuantity <= soLuongMua)) {
					tblSPTra.setValueAt(newQuantity, selectedRow, 4);
					tblSPTra.setValueAt(newQuantity * giaGoc, selectedRow, 5);
					JOptionPane.showMessageDialog(this, "Đã cập nhật số lượng thành công.", "Thông báo",
							JOptionPane.INFORMATION_MESSAGE);
					tinhTongTienHoanTra();
				} else if (newQuantity == 0) {
					xoaDong();
				} else {
					JOptionPane.showMessageDialog(this, "Số lượng trả lớn nhất là "+ soLuongMua + " và không âm.", "Lỗi",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập một số nguyên hợp lệ.", "Lỗi",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	// Chọn tất cả các sản phẩm đã mua 
		public void chonTatCaSP(String maHD, DefaultTableModel model) {
			try {

				for (ChiTietHoaDon ct : dao_CTHD.getDSTheoMaHD(maHD)) {
					String maSP = ct.getSanPham().getMaSanPham();
					String tenSP = ct.getSanPham().getTenSanPham();
					int index = timSPTrongBangTra(maSP, tenSP ); // Tìm xem sản phẩm này đã được chọn trước đó chưa
					//Chưa có trong bảng trả
					if( index == -1 ){
						double giaBan = ct.getSanPham().getGiaBan();
						int soLuong = ct.getSoLuong();
						double thanhTien = giaBan * soLuong;
						model.addRow(new Object[] { maSP, tenSP, giaBan,
								soLuong, 1, thanhTien });
					}
					
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

	//Thêm hóa đơn trả hàng vào CSDL
	public boolean themHoaDonTraHang() {
		String maYCTH = txtMaTraHang.getText().trim();
		LocalDateTime ngayLap = LocalDateTime.now();
		String lyDo = txtLyDo.getText().trim();
		double tienHoanTra = Double.parseDouble(txtTienHoanTra.getText().trim());
		NhanVien nhanVien = nv;
		KhachHang kh = dao_KhachHang.getKhachHangTheoSDT(txtSDT.getText().trim());
		HoaDon hd = dao_HoaDon.getHDTheoMaHD(txtMaHD.getText().trim());

		// Nếu khách hàng trả là khách lẻ
		// Khách lẻ có mã là KH22112023003
		if (kh.getMaKH().equalsIgnoreCase("KH22112023003")) {
			HoaDonHoanTra hdht = new HoaDonHoanTra(maYCTH, ngayLap, lyDo,  tienHoanTra, nhanVien, kh, hd);
			if (dao_HoaDonHT.createHD(hdht)) {
				capNhatSoLuongTonTraHang(hdht);
				System.out.println(hdht.getTongHoanTra());
				themChiTietHoanTra(hdht);
				return true;
			}
		}
		else {
				HoaDonHoanTra hdht = new HoaDonHoanTra(maYCTH, ngayLap, lyDo,  tienHoanTra, nhanVien, kh, hd);
				if (dao_HoaDonHT.createHD(hdht)) {
					String sdtkh = kh.getSdt();
					int diemHienTai = Integer.parseInt(txtDTL.getText());
					int diemTru = (int) tienHoanTra / 100;
					int diemMoi = diemHienTai - diemTru;
					dao_KhachHang.updateDiemTL(diemMoi, sdtkh);
					capNhatSoLuongTonTraHang(hdht);
					themChiTietHoanTra(hdht);
					System.out.println(hdht.getTongHoanTra());
				}
				return true;
			}
		return false;
		}
		
	//Thêm chi tiết hoàn trả
		public void themChiTietHoanTra(HoaDonHoanTra hdht) {
			int soLuongDong = modelSPTra.getRowCount();

			for (int i = 0; i <= soLuongDong; i++) {
				// Kiểm tra xem chỉ số i có hợp lệ không
				if (i < tblSPTra.getRowCount()) {
					String maSP = (String) tblSPTra.getValueAt(i, 0);

					if (isSach(maSP)) {
						int soLuong = (int) tblSPTra.getValueAt(i, 4);
						SanPham sanPham = dao_QLSach.getThongTinSanPhamTheoMa(maSP);
						ChiTietHoanTra ctht = new ChiTietHoanTra(hdht, sanPham, soLuong);
						dao_HoanTra.createCTHT(ctht);
						System.out.println(sanPham.getTenSanPham());

					} else {
						int soLuong = (int) tblSPTra.getValueAt(i, 4);
						SanPham sanPham = dao_QLVPP.getThongTinSanPhamTheoMa(maSP);
						ChiTietHoanTra ctht = new ChiTietHoanTra(hdht, sanPham, soLuong);
						dao_HoanTra.createCTHT(ctht);
						System.out.println(sanPham.getTenSanPham());
					}
				}
			}
		}
		//Cập nhật số lượng tồn khi trả hàng
		public void capNhatSoLuongTonTraHang(HoaDonHoanTra hd) {

			for (int i = 0; i < modelSPTra.getRowCount(); i++) {
				String maSP = (String) modelSPTra.getValueAt(i, 0);
				int soLuong = (int) modelSPTra.getValueAt(i, 3);

				if (isSach(maSP)) {
					dao_QLSach.capNhatSoTraTrongCSDL(maSP, soLuong);
				} else {
					dao_QLVPP.capNhatSoTraTrongCSDL(maSP, soLuong);
				}
				// capNhatSoLuongTonTrongBangSanPham(maSP, soLuong);
			}
		}
		
		//Kiểm tra sản phẩm
		public boolean isVanPhongPham(String maSP) {
			return maSP.startsWith("VPP");
		}

		//Kiểm tra sản phẩm
		public boolean isSach(String maSP) {
			return maSP.startsWith("SAH");
		}



	// Tạo mã yêu cầu trả hàng
	private String generateMaHD() {
		try {
			java.util.Date currentDate = new java.util.Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
			String formattedDate = dateFormat.format(currentDate);

			int sequenceNumber = dao_HoaDonHT.getCurrentSequenceNumber();
			sequenceNumber++;
			String sequencePart = String.format("%03d", sequenceNumber);

			String maNV = nv.getMaNV();
			int index1 = maNV.indexOf("23");
			int index2 = maNV.indexOf(" ", index1);
			if (index1 == -1) {
				return null;
			}
			String subMaNV = maNV.substring(index1 + 2, index1 + 5);
			return "TH" + formattedDate + subMaNV + sequencePart;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	// Đọc tất cả các sản phẩm của hóa đơn đã mua
	public void docChiTietHoaDon(String maHD, DefaultTableModel model) {
		try {
			for (ChiTietHoaDon ct : dao_CTHD.getDSTheoMaHD(maHD)) {
				double giaBan = ct.getSanPham().getGiaBan();
				int soLuong = ct.getSoLuong();
				double thanhTien = giaBan * soLuong;
				modelSPDM.addRow(new Object[] { ct.getSanPham().getMaSanPham(), ct.getSanPham().getTenSanPham(), giaBan,
						soLuong, thanhTien });
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	// Chọn sản phẩm cần trả
	public void chonSPTra(int input) {
		int row = tblSPDM.getSelectedRow();
		// Lấy các giá trị của hàng được chọn
		String maSP = (String) tblSPDM.getValueAt(row, 0);
		String tenSP = (String) tblSPDM.getValueAt(row, 1);
		double giaBan = (double) tblSPDM.getValueAt(row, 2);
		int soLuongMua = (int) tblSPDM.getValueAt(row, 3);
		// Thêm sản phẩm trả vào model sp trả
		modelSPTra.addRow(new Object[] { maSP, tenSP, giaBan, soLuongMua, input, giaBan * input });
		tinhTongTienHoanTra();
	}

//Tính tổng tiền cần thanh toán
	public void tinhTongTienHoanTra() {
		double tongTien = 0;
		int tongSP = 0;

		for (int i = 0; i < modelSPTra.getRowCount(); i++) {
			double thanhTien = (double) modelSPTra.getValueAt(i, 5);
			int soLuong = (int) modelSPTra.getValueAt(i, 4);
			tongTien += thanhTien;
			tongSP += soLuong;
		}

		txtTongSP.setText(String.valueOf(tongSP));
		txtTienHoanTra.setText(String.valueOf(tongTien));
	}

	// Hàm tìm sản phẩm trong hóa đơn
	private int timSPTrongBangTra(String maSP, String tenSP) {
		int rowCount = modelSPTra.getRowCount();

		for (int i = 0; i < rowCount; i++) {
			String maSPHD = (String) modelSPTra.getValueAt(i, 0);
			String tenSPHD = (String) modelSPTra.getValueAt(i, 1);

			if (maSP.equals(maSPHD) && tenSP.equals(tenSPHD)) {
				return i; // Trả về chỉ số nếu sản phẩm đã tồn tại
			}
		}
		return -1; // Trả về -1 nếu sản phẩm không tồn tại
	}

	// Xóa dòng
	public void xoaDong() {
		int row = tblSPTra.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm giữ cần giữ lại.", "Thông báo",
					JOptionPane.WARNING_MESSAGE);
			return;
		} else {
			String maSP = (String) tblSPTra.getValueAt(row, 0);
			String tenSP = (String) tblSPTra.getValueAt(row, 1);
			double giaBan = (double) tblSPTra.getValueAt(row, 2);
			int soLuongMua = (int) tblSPTra.getValueAt(row, 3);
			// Thêm sản phẩm trả vào model sp trả
			modelSPDM.addRow(new Object[] { maSP, tenSP, giaBan, soLuongMua, giaBan * soLuongMua });
			timDongTrongBang(tblSPTra, row); // xóa dòng
			tinhTongTienHoanTra();
		}

	}
	//Hàm xóa dòng
	public void timDongTrongBang(JTable table, int row) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.removeRow(row);
	}
	//Xóa rỗng
	public void xoaRong() {
		txtMaTraHang.setText(generateMaHD());
		txtTimKiem.setText("");
		txtTongSP.setText("");
		txtLyDo.setText("");
		modelSPDM.setRowCount(0);
		modelSPTra.setRowCount(0);
		tinhTongTienHoanTra();
	} 
	//Tìm hóa đơn trả hàng theo mã
	public void timKiemTheoMaHD(String tuKhoa) {
		TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelHD);
		tblHD.setRowSorter(sorter);

		if (tuKhoa.isEmpty()) {
			sorter.setRowFilter(null);
		} else {

			RowFilter<DefaultTableModel, Object> filter = RowFilter.regexFilter("(?i)" + Pattern.quote(tuKhoa), 1, 0);
			sorter.setRowFilter(filter);

		}
	}
	//Tìm sản phẩm theo mã
	private void timKiemTheoMaSP(String tuKhoa) {
		TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelSPDM);
		tblSPDM.setRowSorter(sorter);

		if (tuKhoa.isEmpty()) {
			sorter.setRowFilter(null);
		} else {

			RowFilter<DefaultTableModel, Object> filter = RowFilter.regexFilter("(?i)" + Pattern.quote(tuKhoa), 1, 0);
			sorter.setRowFilter(filter);

		}
	}
}
