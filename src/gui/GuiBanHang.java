package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.KeyEventDispatcher;
import java.awt.LayoutManager;
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
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.toedter.calendar.JDateChooser;

import connectDB.ConnectDB;
import dao.DAO_ChiTietHoaDon;
import dao.DAO_ChucVu;
import dao.DAO_HoaDon;
import dao.DAO_KhachHang;
import dao.DAO_NhanVien;
import dao.DAO_QuanLySach;
import dao.DAO_QuanLyVPP;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.Sach;
import entity.SanPham;
import entity.VanPhongPham;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTabbedPane;
import java.awt.FlowLayout;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import com.itextpdf.text.Rectangle;
import javax.swing.JCheckBox;
import java.awt.Component;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.w3c.dom.UserDataHandler;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.w3c.dom.UserDataHandler;

public class GuiBanHang extends JFrame implements ActionListener, MouseListener {
	DAO_QuanLySach dao_quanLySach = new DAO_QuanLySach();
	DAO_QuanLyVPP dao_quanLyVPP = new DAO_QuanLyVPP();
	DAO_KhachHang dao_khachHang = new DAO_KhachHang();
	public static JPanel contentPane;
	private DefaultTableModel modelKH;
	private JTextField txtTimMaSP;
	private DefaultTableModel modelSP;
	private JTable tblSP;
	private JTextField txtMaHD;
	JTextField txtTenNV;
	private JTextField txtTimSP;
	private Container pnlTimSP;
	private JButton btntim;
	private DefaultTableModel modelChonSP;
	private JTable tblChonSP;
	private Font font1;
	private Font font2;
	private JTextField txtSDTKH;
	private JTextField txtTenKH;
	private JTextField txtDiemTL;
	private JTable table;
	private DefaultTableModel modelSPHD;
	private JTable tblSPHD;
	private JTextField txtTongSP;
	private JTextField txtTienKhachTra;
	private JTextField txtTienKhachDua;
	private JTextField txtTienThua;
	private JButton btnHangCho;
	private JButton btnXoaDong;
	private DAO_KhachHang khachhang_dao;
	private JButton btnTaoDonMoi;
	private JButton btnThanhToan;
	private JButton btnTimKiemKH;
	// private List<Object[]> rows;
	private GuiQuanLyKhachHang guiQLKH;
	private DAO_QuanLySach sach_dao;
	private DAO_QuanLyVPP vpp_dao;
	private DAO_HoaDon hoadon_dao;
	private DAO_NhanVien nhanvien_dao;
	private GuiDangNhap guiDangNhap;
	private GuiTrangChu GuiTrangChu;
	private JDateChooser dtmNgayLap;
	private DAO_ChiTietHoaDon chitiethoadon_dao;
	private JButton btnSuaSL;
	private GuiQuanLyKhachHang guiKhachHang;
	private DAO_QuanLyVPP vanphongpham_dao;
	private JButton btnThanhToanLai;

	static NhanVien nhanVien;
	private JTextField txtThongBao;
	private JButton btnSuDungDiemTL;
	private boolean isMode = true;
	private int diemBanDau;
	private PdfPTable tableTien;
	private PdfPTable tableTienKhach;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					GuiBanHang frame = new GuiBanHang(nhanVien);
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
	public GuiBanHang(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
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
		font1 = new Font("Times New Roman", Font.BOLD, 36);
		font2 = new Font("Times New Roman", Font.PLAIN, 24);

		// Màu chữ
		Color color1 = new Color(138, 43, 226); // BlueViolet
		Color color2 = new Color(233, 221, 244);

		// Tiêu đề
		JPanel pnlTieuDe = new JPanel();
		pnlTieuDe.setBounds(10, 10, 1890, 60);
		pnlTieuDe.setBackground(new Color(255, 255, 255));
		contentPane.add(pnlTieuDe);

		JLabel lblTieuDe = new JLabel("LẬP HÓA ĐƠN");
		lblTieuDe.setBackground(new Color(51, 204, 255));
		pnlTieuDe.add(lblTieuDe);
		lblTieuDe.setFont(font1);
		lblTieuDe.setForeground(new Color(0, 204, 204));

		JPanel pnlLapHoaDon = new JPanel();
		pnlLapHoaDon.setBounds(10, 80, 1890, 903);
		contentPane.add(pnlLapHoaDon);
		pnlLapHoaDon.setLayout(null);

		JPanel pnlChonKhachHang = new JPanel();
		pnlChonKhachHang.setBorder(new EmptyBorder(0, 0, 0, 0));
		pnlChonKhachHang.setBackground(new Color(255, 255, 255));
		pnlChonKhachHang.setBounds(0, 0, 963, 249);
		pnlLapHoaDon.add(pnlChonKhachHang);
		pnlChonKhachHang.setLayout(null);

		JPanel pnlTimKiemSP = new JPanel();
		pnlTimKiemSP.setBounds(10, 58, 935, 177);
		pnlChonKhachHang.add(pnlTimKiemSP);
		pnlTimKiemSP.setLayout(null);

		JLabel lblMaSP = new JLabel("Mã hoặc tên sản phẩm:");
		lblMaSP.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblMaSP.setBounds(64, 69, 233, 29);
		pnlTimKiemSP.add(lblMaSP);

		txtTimMaSP = new JTextField();
		txtTimMaSP.setColumns(10);
		txtTimMaSP.setBounds(307, 70, 521, 34);
		pnlTimKiemSP.add(txtTimMaSP);

		JLabel lblTimKiemSP = new JLabel("Tìm kiếm sản phẩm:");
		lblTimKiemSP.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTimKiemSP.setBounds(10, 11, 266, 36);
		pnlChonKhachHang.add(lblTimKiemSP);

		JPanel pnlHoaDon = new JPanel();
		pnlHoaDon.setBackground(new Color(255, 255, 255));
		pnlHoaDon.setBounds(973, 0, 917, 893);
		pnlLapHoaDon.add(pnlHoaDon);
		pnlHoaDon.setLayout(null);

		JPanel pnlThongTinHoaDon = new JPanel();
		pnlThongTinHoaDon.setBounds(10, 56, 897, 177);
		pnlHoaDon.add(pnlThongTinHoaDon);
		pnlThongTinHoaDon.setLayout(null);

		JLabel lblNgayLap = new JLabel("Ngày lập :");
		lblNgayLap.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblNgayLap.setBounds(325, 40, 102, 30);
		pnlThongTinHoaDon.add(lblNgayLap);

		JLabel lblMaHD = new JLabel("Mã HD:");
		lblMaHD.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblMaHD.setBounds(10, 40, 80, 30);
		pnlThongTinHoaDon.add(lblMaHD);

		JLabel lblTenNV = new JLabel("Tên NV :");
		lblTenNV.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblTenNV.setBounds(605, 40, 92, 30);
		pnlThongTinHoaDon.add(lblTenNV);

		txtMaHD = new JTextField();
		txtMaHD.setEditable(false);
		txtMaHD.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtMaHD.setBounds(100, 41, 195, 30);
		pnlThongTinHoaDon.add(txtMaHD);
		txtMaHD.setColumns(10);

		// hien thi ngay lap
		java.util.Date currentDate = new java.util.Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String formattedDate = dateFormat.format(currentDate);

		dtmNgayLap = new JDateChooser(currentDate);
		dtmNgayLap.setBounds(437, 40, 144, 35);
		dtmNgayLap.setEnabled(false);

		pnlThongTinHoaDon.add(dtmNgayLap);

		txtTenNV = new JTextField();
		txtTenNV.setEditable(false);
		txtTenNV.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTenNV.setColumns(10);
		txtTenNV.setBounds(703, 40, 184, 30);
		pnlThongTinHoaDon.add(txtTenNV);

		txtSDTKH = new JTextField();
		txtSDTKH.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtSDTKH.setColumns(10);
		txtSDTKH.setBounds(111, 109, 156, 30);
		pnlThongTinHoaDon.add(txtSDTKH);

		JLabel lblSDTKH = new JLabel("SDT KH:");
		lblSDTKH.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblSDTKH.setBounds(10, 108, 92, 30);
		pnlThongTinHoaDon.add(lblSDTKH);

		JLabel lblTenKH = new JLabel("Tên KH:");
		lblTenKH.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblTenKH.setBounds(345, 108, 92, 30);
		pnlThongTinHoaDon.add(lblTenKH);

		txtTenKH = new JTextField();
		txtTenKH.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTenKH.setEditable(false);
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(447, 109, 205, 30);
		pnlThongTinHoaDon.add(txtTenKH);

		JLabel lblDiemTL = new JLabel("Điểm TL :");
		lblDiemTL.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblDiemTL.setBounds(676, 108, 102, 30);
		pnlThongTinHoaDon.add(lblDiemTL);

		txtDiemTL = new JTextField();
		txtDiemTL.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtDiemTL.setEditable(false);
		txtDiemTL.setColumns(10);
		txtDiemTL.setBounds(785, 109, 102, 30);
		pnlThongTinHoaDon.add(txtDiemTL);

		btnTimKiemKH = new JButton("");
		btnTimKiemKH.setIcon(new ImageIcon(GuiBanHang.class.getResource("/image/TimKiem.png")));
		btnTimKiemKH.setBounds(275, 109, 40, 30);
		pnlThongTinHoaDon.add(btnTimKiemKH);
		btnTimKiemKH.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnTimKiemKH.setBackground(Color.WHITE);

		btnXoaDong = new JButton("Xóa dòng");
		btnXoaDong.setIcon(new ImageIcon(GuiBanHang.class.getResource("/image/TacVu_Xoa.png")));
		btnXoaDong.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnXoaDong.setBackground(Color.WHITE);
		btnXoaDong.setBounds(729, 250, 159, 36);
		pnlHoaDon.add(btnXoaDong);

		btnHangCho = new JButton("Hàng chờ");
		btnHangCho.setIcon(new ImageIcon(GuiBanHang.class.getResource("/image/TacVu_HangCho.png")));
		btnHangCho.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnHangCho.setBackground(Color.WHITE);
		btnHangCho.setBounds(729, 11, 159, 36);
		pnlHoaDon.add(btnHangCho);

		JLabel lblThongTinHD = new JLabel("Thông tin hóa đơn:");
		lblThongTinHD.setBounds(10, 9, 266, 36);
		pnlHoaDon.add(lblThongTinHD);
		lblThongTinHD.setFont(new Font("Tahoma", Font.BOLD, 18));

		JPanel pnlTbTTHoaDon = new JPanel();
		pnlTbTTHoaDon.setLayout(null);
		pnlTbTTHoaDon.setBounds(10, 304, 897, 321);
		pnlHoaDon.add(pnlTbTTHoaDon);


		// Table San Pham trong hóa đơn
		modelSPHD = new DefaultTableModel();
		modelSPHD.addColumn("Mã SP");
		modelSPHD.addColumn("Tên SP");
		modelSPHD.addColumn("Giá bán");
		modelSPHD.addColumn("Số lượng");
		modelSPHD.addColumn("Thành tiền");
		tblSPHD = new JTable(modelSPHD);
		tblSPHD.setBackground(new Color(153, 204, 255));
		JScrollPane jScrollPane_TTHD = new JScrollPane(tblSPHD);
		jScrollPane_TTHD.setBounds(10, 10, 877, 300);
		JTableHeader tbHeaderSPHD = tblSPHD.getTableHeader();
		tbHeaderSPHD.setFont(font2);
		tbHeaderSPHD.setBackground(new Color(51, 204, 204));
		pnlTbTTHoaDon.setLayout(null);
		tblSPHD.setFont(font2);
		tblSPHD.setRowHeight(35);
		pnlTbTTHoaDon.add(jScrollPane_TTHD);

		JLabel lblTongSP = new JLabel("Tổng số SP:");
		lblTongSP.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblTongSP.setBounds(20, 666, 114, 30);
		pnlHoaDon.add(lblTongSP);

		txtTongSP = new JTextField();
		txtTongSP.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTongSP.setEditable(false);
		txtTongSP.setColumns(10);
		txtTongSP.setBounds(183, 667, 273, 30);
		pnlHoaDon.add(txtTongSP);

		JLabel lblTienKhachTra = new JLabel("Khách phải trả:");
		lblTienKhachTra.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblTienKhachTra.setBounds(20, 718, 153, 30);
		pnlHoaDon.add(lblTienKhachTra);

		txtTienKhachTra = new JTextField();
		txtTienKhachTra.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTienKhachTra.setEditable(false);
		txtTienKhachTra.setColumns(10);
		txtTienKhachTra.setBounds(183, 719, 273, 30);
		pnlHoaDon.add(txtTienKhachTra);

		JLabel lblTienKhachDua = new JLabel("Tiền khách đưa:");
		lblTienKhachDua.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblTienKhachDua.setBounds(20, 770, 164, 30);
		pnlHoaDon.add(lblTienKhachDua);

		JLabel lblTienThua = new JLabel("Tiền thừa:");
		lblTienThua.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblTienThua.setBounds(20, 819, 114, 30);
		pnlHoaDon.add(lblTienThua);

		txtTienKhachDua = new JTextField();
		txtTienKhachDua.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTienKhachDua.setColumns(10);
		txtTienKhachDua.setBounds(183, 771, 273, 30);
		pnlHoaDon.add(txtTienKhachDua);

		btnThanhToan = new JButton("THANH TOÁN");
		btnThanhToan.setForeground(Color.WHITE);
		btnThanhToan.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnThanhToan.setBackground(new Color(51, 204, 204));
		btnThanhToan.setBounds(691, 797, 216, 52);
		pnlHoaDon.add(btnThanhToan);

		btnThanhToanLai = new JButton("THANH TOÁN LẠI");
		btnThanhToanLai.setForeground(Color.WHITE);
		btnThanhToanLai.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnThanhToanLai.setBackground(new Color(51, 204, 204));
		btnThanhToanLai.setBounds(691, 797, 216, 52);
		pnlHoaDon.add(btnThanhToanLai);
		btnThanhToanLai.setVisible(false);

		txtTienThua = new JTextField();
		txtTienThua.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTienThua.setEditable(false);
		txtTienThua.setColumns(10);
		txtTienThua.setBounds(183, 820, 273, 30);
		pnlHoaDon.add(txtTienThua);

		btnTaoDonMoi = new JButton("Tạo Đơn Mới");
		btnTaoDonMoi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnTaoDonMoi.setBackground(Color.WHITE);
		btnTaoDonMoi.setBounds(691, 718, 216, 52);
		pnlHoaDon.add(btnTaoDonMoi);

		btnSuaSL = new JButton("Sửa số lượng");
		btnSuaSL.setIcon(new ImageIcon(GuiBanHang.class.getResource("/image/TacVu_Sua.png")));

		btnSuaSL.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSuaSL.setBackground(Color.WHITE);
		btnSuaSL.setBounds(549, 250, 170, 36);
		pnlHoaDon.add(btnSuaSL);

		btnSuDungDiemTL = new JButton("Sử dụng điểm");
		btnSuDungDiemTL.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSuDungDiemTL.setBackground(Color.WHITE);
		btnSuDungDiemTL.setBounds(466, 667, 146, 30);
		pnlHoaDon.add(btnSuDungDiemTL);

		txtThongBao = new JTextField("");
		txtThongBao.setEditable(false);
		txtThongBao.setHorizontalAlignment(SwingConstants.LEFT);
		txtThongBao.setForeground(Color.RED);
		txtThongBao.setColumns(10);
		txtThongBao.setBounds(466, 727, 215, 20);
		txtThongBao.setBorder(null);
		txtThongBao.setBackground(new Color(255, 255, 255));
		pnlHoaDon.add(txtThongBao);

		JPanel pnlSanPhamChon = new JPanel();
		pnlSanPhamChon.setBackground(new Color(255, 255, 255));
		pnlSanPhamChon.setBounds(0, 260, 963, 633);
		pnlLapHoaDon.add(pnlSanPhamChon);
		pnlSanPhamChon.setLayout(null);

		JPanel pnlSanPham = new JPanel();
		pnlSanPham.setBounds(10, 46, 945, 576);
		pnlSanPhamChon.add(pnlSanPham);
		pnlSanPham.setLayout(null);

		// table San Pham chọn
		modelSP = new DefaultTableModel();
		modelSP.addColumn("Mã SP");
		modelSP.addColumn("Tên SP");
		modelSP.addColumn("Loại SP");
		modelSP.addColumn("Loại bìa");
//		modelSP.addColumn("Màu sắc");
		modelSP.addColumn("Số lượng tồn");
		modelSP.addColumn("Thuế");
		modelSP.addColumn("Giá bán");
		tblSP = new JTable(modelSP);
		tblSP.setBackground(new Color(153, 204, 255));
		JScrollPane jScrollPaneSP = new JScrollPane(tblSP);
		jScrollPaneSP.setBounds(10, 11, 925, 554);
		JTableHeader tbHeaderKH = tblSP.getTableHeader();
		tbHeaderKH.setFont(font2);
		tbHeaderKH.setBackground(new Color(51, 204, 204));
		pnlSanPham.setLayout(null);
		tblSP.setFont(font2);
		tblSP.setRowHeight(35);
		pnlSanPham.add(jScrollPaneSP);

		JLabel lblChonSP = new JLabel("Chọn sản phẩm tại đây:");
		lblChonSP.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblChonSP.setBounds(10, 11, 266, 36);
		pnlSanPhamChon.add(lblChonSP);

		// ket noi sql
		khachhang_dao = new DAO_KhachHang();
		hoadon_dao = new DAO_HoaDon();
		nhanvien_dao = new DAO_NhanVien();
		chitiethoadon_dao = new DAO_ChiTietHoaDon();
		vanphongpham_dao = new DAO_QuanLyVPP();
		guiKhachHang = new GuiQuanLyKhachHang();

		try {
			ConnectDB.getInstance().connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Dua sql len bang
		DocDuLieuDatabaseSach();
		DocDuLieuDatabaseVPP();
		// hien thi ma
		hienThiThongTin();

		btnTaoDonMoi.addActionListener(this);
		btnThanhToan.addActionListener(this);
		btnTimKiemKH.addActionListener(this);
		btnHangCho.addActionListener(this);
		btnXoaDong.addActionListener(this);
		btnSuaSL.addActionListener(this);
		btnSuDungDiemTL.addActionListener(this);
		btnThanhToanLai.addActionListener(this);
		tblSPHD.addMouseListener(this);
		tblSP.addMouseListener(this);

		txtTimMaSP.addKeyListener((KeyListener) new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String tuKhoa = txtTimMaSP.getText().trim();
				timKiemTheoMaSP(tuKhoa);
			}

		});
		txtTienKhachDua.addKeyListener((KeyListener) new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String tienKhachDua = txtTienKhachDua.getText().trim();
				if (tienKhachDua.isEmpty())
					return;
				else
					tinhTienThua(Double.valueOf(tienKhachDua));
			}

		});
		//
		// rows = new ArrayList<>();
		tblSP.addMouseListener((MouseListener) new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tblSP.getSelectedRow();
				if (row >= 0) {
					chonSP();
				}
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnTimKiemKH))
			timKH();
		if (o.equals(btnXoaDong))
			xoaDong();
		if (o.equals(btnThanhToan)) {
			boolean trangThai = true;
			themHD(trangThai);
			xuLyThanhToan();
		}
		if (o.equals(btnTaoDonMoi)) {
			boolean trangThai = false;
			themHD(trangThai);
			JOptionPane.showMessageDialog(this, "Hóa đơn vẫn chưa được thanh toán xong!");

		}
		if (o.equals(btnSuaSL))
			thayDoiSoLuong();
		if (o.equals(btnHangCho))
			hienThiDanhSachHangCho();
		if (o.equals(btnThanhToanLai)) {
			updateHD();
			xuLyThanhToan();
		}
		if (o.equals(btnSuDungDiemTL)) {
			suDungDiemTL();
		}
	}

	//
	private void DocDuLieuDatabaseSach() {
		sach_dao = new DAO_QuanLySach();
		for (Sach s : sach_dao.getALLSach()) {
			modelSP.addRow(new Object[] { s.getMaSanPham(), s.getTenSanPham(), s.getLoaiSach().getTenLoai(),
					s.getLoaiBia(), s.getSoLuong(), s.getThue(), s.getGiaBan() });
		}
	}

	//
	private void DocDuLieuDatabaseVPP() {
		vpp_dao = new DAO_QuanLyVPP();
		for (VanPhongPham v : vpp_dao.getALLVPP()) {
			modelSP.addRow(new Object[] { v.getMaSanPham(), v.getTenSanPham(), v.getLoaiVanPhongPham().getTenLoaiVPP(),
					v.getMaMau().getTenMau(), v.getSoLuong(), v.getThue(), v.getGiaBan() });
		}
	}

	//
	private void timKiemTheoMaSP(String tuKhoa) {
		TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelSP);
		tblSP.setRowSorter(sorter);

		if (tuKhoa.isEmpty()) {
			sorter.setRowFilter(null);
		} else {

			RowFilter<DefaultTableModel, Object> filter = RowFilter.regexFilter("(?i)" + Pattern.quote(tuKhoa), 1, 0);
			sorter.setRowFilter(filter);

		}
	}

	//
	public void timKH() {
		String sdtKH = txtSDTKH.getText();
		List<KhachHang> list = khachhang_dao.getDSKhachHangTheoSDT(sdtKH);
		if (sdtKH.equals(""))
			JOptionPane.showMessageDialog(this, "Vui lòng nhập số điện thoại khách hàng cần tìm.");
		else if (list != null && list.size() > 0) {
			KhachHang kh = list.get(0);
			txtTenKH.setText(kh.getTenKH());
			txtDiemTL.setText(String.valueOf(kh.getDiemTL()));
		} else {
			int tl;
			tl = JOptionPane.showConfirmDialog(this,
					"Khách hàng này không có sẳn. Bạn có muốn thêm khách hàng này không?", "Thông báo",
					JOptionPane.YES_OPTION);
			if (tl == JOptionPane.YES_OPTION) {
				guiQLKH = new GuiQuanLyKhachHang();
				guiQLKH.txtSDT.setText(sdtKH);
				guiQLKH.setVisible(true);
			} else {
				txtSDTKH.setText("");
				txtTenKH.setText("");
				txtDiemTL.setText(String.valueOf(""));
			}
		}

	}

	//
	public void chonSP() {
		int row = tblSP.getSelectedRow();

		// Kiểm tra xem hàng được chọn có tồn tại hay không
		if (row < 0) {
			return;
		}

		// Lấy các giá trị của hàng được chọn
		String maSP = (String) tblSP.getValueAt(row, 0);
		String tenSP = (String) tblSP.getValueAt(row, 1);
		double giaGoc = (double) tblSP.getValueAt(row, 6);
		int slSP = (int) tblSP.getValueAt(row, 4);

		// Tìm kiếm hàng có mã sản phẩm và tên sản phẩm giống hàng được chọn trong bảng
		// tblSPHD
		int index = timSPTrongHD(maSP, tenSP);

		if (index != -1) {
			// Nếu hàng đã tồn tại thì tăng số lượng
			int soLuong = (int) modelSPHD.getValueAt(index, 3);
			soLuong++;
			slSP--;
			modelSPHD.setValueAt(soLuong, index, 3);
			modelSPHD.setValueAt(giaGoc * soLuong, index, 4);

			// Giảm số lượng trong bảng tblSP
			if (slSP > 0) {
				modelSP.setValueAt(slSP, row, 4);
			}
		} else {
			// Nếu hàng chưa tồn tại, thêm hàng mới
			modelSPHD.addRow(new Object[] { maSP, tenSP, giaGoc, 1, giaGoc });

			// Giảm số lượng trong bảng tblSP
			if (slSP > 0) {
				modelSP.setValueAt(slSP - 1, row, 4);
			}
		}

		tinhTongTienThanhToan();
	}

	//
	public void tinhTienThua(double tienKhachDua) {
		double tongGiaGoc = Double.parseDouble(txtTienKhachTra.getText());
		double tienThoi = 0;
		String tienKhach = txtTienKhachDua.getText();
		if (tienKhach.isEmpty()) {
			txtTienThua.setText(String.valueOf("0"));
		}
		if (tienKhachDua < tongGiaGoc)
			txtTienThua.setText("Phải nhập lớn hơn tổng tiền");
		else {
			tienThoi = tienKhachDua - tongGiaGoc;
			txtTienThua.setText(String.valueOf(tienThoi));
		}

	}

	// Hàm tìm sản phẩm trong hóa đơn
	private int timSPTrongHD(String maSP, String tenSP) {
		int rowCount = modelSPHD.getRowCount();

		for (int i = 0; i < rowCount; i++) {
			String maSPHD = (String) modelSPHD.getValueAt(i, 0);
			String tenSPHD = (String) modelSPHD.getValueAt(i, 1);

			if (maSP.equals(maSPHD) && tenSP.equals(tenSPHD)) {
				return i; // Trả về chỉ số nếu sản phẩm đã tồn tại
			}
		}

		return -1; // Trả về -1 nếu sản phẩm không tồn tại
	}

	// chính
	public String generateMaHD() {
		try {
			java.util.Date currentDate = new java.util.Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
			String formattedDate = dateFormat.format(currentDate);

			// Hóa đơn đầu tiên trong ngày
			boolean f = soSanhNgay();

			if (f == true) {
				String maNV = nhanVien.getMaNV().trim();
				// NV14112023002
				String subMaNV = maNV.substring(10, 13);

				int sequenceNumber = 1;
				String sequencePart = String.format("%03d", sequenceNumber).trim();
				return "HD" + formattedDate + subMaNV + sequencePart;
			}
			// Hóa đơn trong ngày
			else {
				String maNV = nhanVien.getMaNV();
				// NV14112023002
				String subMaNV = maNV.substring(10, 13);
				int sequenceNumber = hoadon_dao.getCurrentSequenceNumber(nhanVien);
				sequenceNumber++;
				String sequencePart = String.format("%03d", sequenceNumber).trim();
				return "HD" + formattedDate + subMaNV + sequencePart;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/*
	 * Kiểm tra ngày mới hay ngày cũ
	 * 
	 * @return true: ngày mới
	 * 
	 * @return false: ngày cũ
	 */
	private boolean soSanhNgay() {
		java.util.Date ngayHienTai = new java.util.Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
		String ngayHT = dateFormat.format(ngayHienTai);
		String HDCu = hoadon_dao.layNgayHoaDonTruoc();
		//Hóa đơn đầu tiên
		if (HDCu == null) {
			return true;
		}

		

		// 01 01 2023
		// So sánh năm
		String cu1 = HDCu.substring(4, 7);
		String moi1 = ngayHT.substring(4, 7);
		int namCu = Integer.parseInt(cu1);
		int namMoi = Integer.parseInt(moi1);
		if (namCu < namMoi)
			return true;
		// So sánh tháng
		String cu2 = HDCu.substring(2, 4);

		String moi2 = ngayHT.substring(2, 4);

		int thangCu = Integer.parseInt(cu2);

		int thangMoi = Integer.parseInt(moi2);

		if (thangCu < thangMoi)
			return true;
		// So sánh ngày
		String cu3 = HDCu.substring(0, 2);
		String moi3 = ngayHT.substring(0, 2);
		int ngayCu = Integer.parseInt(cu3);
		int ngayMoi = Integer.parseInt(moi3);
		if (ngayCu < ngayMoi)
			return true;

		return false;
	}

	//
	public void hienThiThongTin() {
		String maHD = generateMaHD();
		txtMaHD.setText(maHD);

		String maNV = nhanVien.getMaNV();
		// String maNV = "NV14112023002";
		ArrayList<NhanVien> list = nhanvien_dao.getNhanVienTheoMa(maNV);
		for (NhanVien nv : list) {
			txtTenNV.setText(nv.getTenNV());
		}

	}

	// Xoa dòng
	public void timDongTrongBang(JTable table, int row) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.removeRow(row);
	}

	public void xoaDong() {
		int row = tblSPHD.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng để xóa.", "Thông báo",
					JOptionPane.WARNING_MESSAGE);
			return;
		}
		timDongTrongBang(tblSPHD, row);
		tinhTongTienThanhToan();
	}

	//
	public void themHD(boolean trangThai) {
		// Chưa nhập tiền khách đưa thì set mặc định bằng tổng phải trả
		if (txtTienKhachDua.getText().trim().isEmpty()) {
			setTienKhachDua();
		}
		String maHD = generateMaHD();
		LocalDateTime ngayLap = LocalDateTime.now();
		LocalDateTime ngayLapKL = LocalDateTime.now();
		double tienNhan = Double.parseDouble(txtTienKhachDua.getText().trim());
		double tongTien = Double.parseDouble(txtTienKhachTra.getText());
		NhanVien nv = nhanvien_dao.getNhanVienTheoMa2(nhanVien.getMaNV().trim());
		String sdtkh = txtSDTKH.getText();

		// Nếu txt SDT rỗng thì set mặc định là khách lẻ
		if(sdtkh.isEmpty()) {
			guiKhachHang = new GuiQuanLyKhachHang();
			String maKL = guiKhachHang.txtMaKH.getText();
			String tenKL = "Khách lẻ";
			String diaChi = "Không";
			String sdtKL = "Không";
		    int diemTLKL = 0;
		    String emailKL = "Không";
		    
		    KhachHang khle = new KhachHang(maKL, tenKL, diaChi, sdtKL, diemTLKL, ngayLapKL, emailKL);
		    KhachHang kle = new KhachHang(maKL);
		    if (khachhang_dao.createKH(khle)) {
		    	HoaDon hd = new HoaDon(maHD, ngayLap, tienNhan, tongTien, nv, kle, trangThai);
				if(hoadon_dao.createHD(hd)) {
					capNhatSoLuongTon(hd);
					themCTHD(hd);
					xoaRong();
				}
		    }	
		} else {
			ArrayList<KhachHang> list = khachhang_dao.getDSKhachHangTheoSDT(sdtkh);

			for (KhachHang kh : list) {
				String k = kh.getMaKH();
				KhachHang maKH = new KhachHang(k);

				if(trangThai == true) {
					int diemCu = Integer.parseInt(txtDiemTL.getText());
					int diemMoi = (int) tongTien / 100;
					int diemCongMoi = diemCu + diemMoi;
					khachhang_dao.updateDiemTL(diemCongMoi, sdtkh);
				}

				double tongTienMoi = Double.parseDouble(txtTienKhachTra.getText());
				HoaDon hd = new HoaDon(maHD, ngayLap, tienNhan, tongTienMoi, nv, maKH, trangThai);
				if (hoadon_dao.createHD(hd)) {
					capNhatSoLuongTon(hd);
					themCTHD(hd);
					xoaRong();
				}
			}
		}

	}

	// Thêm chi tiết hóa đơn
	public void themCTHD(HoaDon hd) {
		int soLuongDong = modelSPHD.getRowCount();

		for (int i = 0; i <= soLuongDong; i++) {
			// Kiểm tra xem chỉ số i có hợp lệ không
			if (i < tblSPHD.getRowCount()) {
				String maSP = (String) tblSPHD.getValueAt(i, 0);

				if (isSach(maSP)) {
					int soLuong = (int) tblSPHD.getValueAt(i, 3);
					SanPham sanPham = dao_quanLySach.getThongTinSanPhamTheoMa(maSP);
					ChiTietHoaDon cthd = new ChiTietHoaDon(hd, sanPham, soLuong);
					chitiethoadon_dao.createCTHD(cthd);

				} else {
					int soLuong = (int) tblSPHD.getValueAt(i, 3);
					SanPham sanPham = dao_quanLyVPP.getThongTinSanPhamTheoMa(maSP);
					ChiTietHoaDon cthd = new ChiTietHoaDon(hd, sanPham, soLuong);
					chitiethoadon_dao.createCTHD(cthd);
				}
			}
		}
	}

	//
	public boolean isVanPhongPham(String maSP) {
		return maSP.startsWith("VPP");
	}

	//
	public boolean isSach(String maSP) {
		return maSP.startsWith("SAH");
	}

	//
	public void thayDoiSoLuong() {
		int selectedRow = tblSPHD.getSelectedRow();
		if (selectedRow == -1) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng để thay đổi số lượng.", "Thông báo",
					JOptionPane.WARNING_MESSAGE);
			return;
		}
		String maSP = (String) tblSPHD.getValueAt(selectedRow, 0);
		String tenSP = (String) tblSPHD.getValueAt(selectedRow, 1);
		int soLuongHienTai = (int) tblSPHD.getValueAt(selectedRow, 3);
		double giaGoc = (double) tblSPHD.getValueAt(selectedRow, 2);

		String input = JOptionPane.showInputDialog(this, "Nhập số lượng mới cho " + tenSP + ":", soLuongHienTai);
		try {
			if (input != null) {
				int newQuantity = Integer.parseInt(input);
				if (newQuantity > 0) {
					tblSPHD.setValueAt(newQuantity, selectedRow, 3);
					tblSPHD.setValueAt(newQuantity * giaGoc, selectedRow, 4);
					JOptionPane.showMessageDialog(this, "Đã cập nhật số lượng thành công.", "Thông báo",
							JOptionPane.INFORMATION_MESSAGE);
					tinhTongTienThanhToan();
				} else if (newQuantity == 0) {
					xoaDong();
				} else {
					JOptionPane.showMessageDialog(this, "Số lượng phải là một số không âm.", "Lỗi",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập một số nguyên hợp lệ.", "Lỗi",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	// Tính tổng tiền cần thanh toán
	public void tinhTongTienThanhToan() {
		double tongGiaGoc = 0;
		int tongSoSanPham = 0;

		for (int i = 0; i < modelSPHD.getRowCount(); i++) {
			int soLuong = (int) modelSPHD.getValueAt(i, 3);
			double giaGoc = (double) modelSPHD.getValueAt(i, 2);

			tongGiaGoc += soLuong * giaGoc;
			tongSoSanPham += soLuong;
		}

		txtTongSP.setText(String.valueOf(tongSoSanPham));
		txtTienKhachTra.setText(String.valueOf(tongGiaGoc));
	}

	// Set tiền khách đưa nếu ô nhập tiền rỗng
	public void setTienKhachDua() {
		double tongTien = 0;

		for (int i = 0; i < modelSPHD.getRowCount(); i++) {
			int soLuong = (int) modelSPHD.getValueAt(i, 3);
			double giaGoc = (double) modelSPHD.getValueAt(i, 2);
			tongTien += soLuong * giaGoc;
		}
		txtTienKhachDua.setText(String.valueOf(tongTien));
	}

	//
	public void capNhatSoLuongTon(HoaDon hd) {
		DefaultTableModel modelSPHD = (DefaultTableModel) tblSPHD.getModel();

		for (int i = 0; i < modelSPHD.getRowCount(); i++) {
			String maSP = (String) modelSPHD.getValueAt(i, 0);
			int soLuong = (int) modelSPHD.getValueAt(i, 3);

			if (isSach(maSP)) {
				sach_dao.capNhatSoLuongTonTrongCSDL(maSP, soLuong);
			} else {
				vanphongpham_dao.capNhatSoLuongTonTrongCSDL(maSP, soLuong);
			}
			// capNhatSoLuongTonTrongBangSanPham(maSP, soLuong);
		}
	}

	//
	public void capNhatSoLuongTonTrongBangSanPham(String maSP, int soLuong) {
		DefaultTableModel modelSP = (DefaultTableModel) tblSP.getModel();

		// Tìm dòng chứa sản phẩm có mã maSP trong bảng sản phẩm
		for (int i = 0; i < modelSP.getRowCount(); i++) {
			if (maSP.equals((String) modelSP.getValueAt(i, 0))) {
				int soLuongTonHienTai = (int) modelSP.getValueAt(i, 4);
				int soLuongTonMoi = soLuongTonHienTai - soLuong;

				// Cập nhật số lượng tồn trong bảng sản phẩm hiển thị
				modelSP.setValueAt(soLuongTonMoi, i, 4);
				break;
			}
		}
	}

	//
	public void xoaRong() {
		txtMaHD.setText(generateMaHD());
		txtDiemTL.setText("");
		txtTenKH.setText("");
		txtSDTKH.setText("");
		txtTimMaSP.setText("");
		txtTongSP.setText("");
		txtTienKhachDua.setText("");
		txtTienKhachTra.setText("");
		txtTienThua.setText("");
		modelSPHD.setRowCount(0);
		txtThongBao.setText("");

		hienThiThongTin();
	}

	//
	public void hienThiDanhSachHangCho() {
		JFrame frameHC = new JFrame("Danh sách hóa đơn đang chờ");
		frameHC.setBounds(100, 100, 546, 354);
		frameHC.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameHC.setVisible(true);
		frameHC.setLocationRelativeTo(null);

		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frameHC.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel pnlTieuDe = new JPanel();
		pnlTieuDe.setBackground(Color.WHITE);
		contentPane.add(pnlTieuDe, BorderLayout.NORTH);

		JLabel lblHoaDonCho = new JLabel("HÓA ĐƠN CHỜ");
		lblHoaDonCho.setForeground(new Color(0, 204, 204));
		lblHoaDonCho.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblHoaDonCho.setBackground(new Color(51, 204, 255));
		pnlTieuDe.add(lblHoaDonCho);

		JPanel pnlHangCho = new JPanel();
		pnlHangCho.setBackground(Color.WHITE);
		contentPane.add(pnlHangCho, BorderLayout.CENTER);
		pnlHangCho.setLayout(new GridLayout(0, 3, 10, 10));

		List<HoaDon> dshd = hoadon_dao.layDanhSachHoaDonCho();
		for (HoaDon hd : dshd) {
			JButton btnChonHDCho = new JButton(hd.getMaHoaDon());
			btnChonHDCho.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					dienTTVaoHoaDon(hd.getMaHoaDon());
					dienVaoSPChon(hd.getMaHoaDon());
					frameHC.setVisible(false);
					btnThanhToan.setVisible(false);
					btnThanhToan.setEnabled(false);
					btnThanhToanLai.setVisible(true);

				}
			});
			pnlHangCho.add(btnChonHDCho);
		}

		JScrollPane scHDC = new JScrollPane(pnlHangCho);
		contentPane.add(scHDC, BorderLayout.CENTER);
	}

	//
	public void dienTTVaoHoaDon(String maHD) {
		List<HoaDon> dshd = hoadon_dao.layDanhSachHoaDonCho();
		for (HoaDon hd : dshd) {
			List<HoaDon> dshdtim = hoadon_dao.getTheoMaHD(maHD);
			for (HoaDon h : dshdtim) {
				txtMaHD.setText(maHD);

				txtSDTKH.setText(h.getKhachHang().getSdt());
				txtTenKH.setText(h.getKhachHang().getTenKH());
				txtDiemTL.setText(String.valueOf(h.getKhachHang().getDiemTL()));

			}
		}
	}

	//
	public void dienVaoSPChon(String maHD) {
		modelSPHD.setRowCount(0);

		List<ChiTietHoaDon> dshdtim = chitiethoadon_dao.getDSTheoMaHD(maHD);
		double tongTien = 0;
		int tongSoLuong = 0;

		for (ChiTietHoaDon cthd : dshdtim) {
			List<Sach> dssach = sach_dao.getArrSachTheoMa(cthd.getSanPham().getMaSanPham());
			List<VanPhongPham> dsvpp = vpp_dao.getArrVPPTheoMa(cthd.getSanPham().getMaSanPham());

			int soLuong = cthd.getSoLuong();
			double giaBan = 0;

			if (isSach(cthd.getSanPham().getMaSanPham())) {
				for (Sach s : dssach) {
					giaBan = s.getGiaBan();
					modelSPHD.addRow(new Object[] { cthd.getSanPham().getMaSanPham(), s.getTenSanPham(), giaBan,
							soLuong, (giaBan * soLuong) });
				}
			} else {
				for (VanPhongPham v : dsvpp) {
					giaBan = v.getGiaBan();
					modelSPHD.addRow(new Object[] { cthd.getSanPham().getMaSanPham(), v.getTenSanPham(), giaBan,
							soLuong, (giaBan * soLuong) });
				}
			}

			tongSoLuong += soLuong;
			tongTien += (giaBan * soLuong);
		}
		txtTongSP.setText(String.valueOf(tongSoLuong));
		txtTienKhachTra.setText(String.valueOf(tongTien));
	}

	public void themHDCho(String maHD) {
		LocalDateTime ngayLap = LocalDateTime.now();
		LocalDateTime ngayLapKL = LocalDateTime.now();
		String tienKhachDuaText = txtTienKhachDua.getText().trim();
		double tienNhan = Double.parseDouble(tienKhachDuaText);
		double tongTien = Double.parseDouble(txtTienKhachTra.getText());
		String sdtkh = txtSDTKH.getText();
		boolean trangThai = true;

		//
		if (tienKhachDuaText.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Khong dc trong");
			return;
		}
		if (sdtkh.isEmpty()) {
			guiKhachHang = new GuiQuanLyKhachHang();
			String maKL = guiKhachHang.txtMaKH.getText();
			String tenKL = "Khách lẻ";
			String diaChi = "Không";
			String sdtKL = "Không";
			int diemTLKL = 0;
			String emailKL = "Không";

			KhachHang khle = new KhachHang(maKL, tenKL, diaChi, sdtKL, diemTLKL, ngayLapKL, emailKL);
			KhachHang kle = new KhachHang(maKL);
			if (khachhang_dao.createKH(khle)) {
				HoaDon hd = new HoaDon(maHD, ngayLap, tienNhan, tongTien, nhanVien, kle, trangThai);
				if (hoadon_dao.createHD(hd)) {
					capNhatSoLuongTon(hd);
					themCTHD(hd);
					xoaRong();
				}
			}
		}
		ArrayList<KhachHang> list = khachhang_dao.getDSKhachHangTheoSDT(sdtkh);

		for (KhachHang kh : list) {
			String k = kh.getMaKH();
			KhachHang maKH = new KhachHang(k);

			//
//			int diemCu = kh.getDiemTL();
//			int diemMoi = (int) tongTien / 100;
//			int diemCongMoi = diemCu + diemMoi;
			//khachhang_dao.updateDiemTL(diemCongMoi, sdtkh);
			//
			HoaDon hd = new HoaDon(maHD, ngayLap, tienNhan, tongTien, nhanVien, maKH, trangThai);
			if (hoadon_dao.createHD(hd)) {
				capNhatSoLuongTon(hd);
				themCTHD(hd);
				xoaRong();
			}
		}
	}

	public void updateHD() {
		String maHD = txtMaHD.getText();

		hoadon_dao.xoaHDCho(maHD);
		chitiethoadon_dao.xoaSPTrongCTHD(maHD);
		themHDCho(maHD);
		xoaRong();
	}

	public void suDungDiemTL() {

		String sdtkh = txtSDTKH.getText();
		String tongTienStr = txtTienKhachTra.getText();
		double tongTien = Double.parseDouble(txtTienKhachTra.getText());
		ArrayList<KhachHang> list = khachhang_dao.getDSKhachHangTheoSDT(sdtkh);

		if (sdtkh.isEmpty()) {
			txtThongBao.setText("*Phải chọn khách hàng để sử dụng");
		}

		if (tongTienStr.isEmpty()) {
			txtThongBao.setText("*Vui lòng chọn sản phẩm");
		}
		for (KhachHang kh : list) {
			String k = kh.getMaKH();

			// neu su dung diem tich luy
			int diemCu = kh.getDiemTL();
			int diemChan = lamTronSo(diemCu);
			if (diemCu == 0) {
				txtThongBao.setText("*Điểm tích lũy bằng 0 nên không thể sử dụng");
			}
			diemBanDau = diemCu;
			if (isMode) {

				double tongTienMoi;
				tongTienMoi = tongTien - diemChan;
				txtTienKhachTra.setText(String.valueOf(tongTienMoi));
				txtThongBao.setText("*Đã sử dụng điểm tích lũy");
				diemBanDau = diemCu - diemChan;
				txtDiemTL.setText(String.valueOf(diemBanDau));
				
				// khachhang_dao.updateDiemTL(0, sdtkh);
			} else {

				double tongGiaGoc = 0;
				int tongSoSanPham = 0;

				for (int i = 0; i < modelSPHD.getRowCount(); i++) {
					int soLuong = (int) modelSPHD.getValueAt(i, 3);
					double giaGoc = (double) modelSPHD.getValueAt(i, 2);

					tongGiaGoc += soLuong * giaGoc;
					tongSoSanPham += soLuong;
					diemBanDau = diemCu;

				}

				txtTienKhachTra.setText(String.valueOf(tongGiaGoc));
				txtThongBao.setText("");
				txtDiemTL.setText(String.valueOf(diemBanDau));
				txtTienKhachDua.setText("");
				// khachhang_dao.updateDiemTL(diemBanDau, sdtkh);
			}

			isMode = !isMode;
			updateButtonText();
		}
	}
	//
	public int lamTronSo(int number) {
        int roundedValue = (number / 1000) * 1000;  
        return roundedValue;
    }
	//
	public void updateButtonText() {
		btnSuDungDiemTL.setText(isMode ? "Sử dụng điểm" : "Trở lại");
	}
	//
	public void xuLyThanhToan() {
        // Lấy thông tin từ tblSPHD, tên nhân viên và ngày thanh toán
        String tenNhanVien = txtTenNV.getText();
        Date ngayThanhToan = dtmNgayLap.getDate();

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss - dd/MM/yyyy");
        String ngayThanhToanFormatted = sdf.format(ngayThanhToan);

     

        // Tạo đối tượng Document
        Document document = new Document();
        
        try {
        	String fontPath = "src/font/DejaVuSans.ttf";
        	
        	if (!Files.exists(Paths.get(fontPath))) {
                System.err.println("Font file not found. Check the fontPath: " + fontPath);
                return;
            }

        	BaseFont baseFont = BaseFont.createFont(fontPath, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);

        	com.itextpdf.text.Font fontTieuDe = new com.itextpdf.text.Font(baseFont, 15, Font.BOLD);
        	com.itextpdf.text.Font fontHead = new com.itextpdf.text.Font(baseFont, 12, Font.BOLD);
        	com.itextpdf.text.Font font = new com.itextpdf.text.Font(baseFont, 12, Font.PLAIN);
        	
            // Đặt tên file PDF và tạo đối tượng PdfWriter
        	String maHD = txtMaHD.getText();
            String fileName = "HoaDon_" + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + ".pdf";
            PdfWriter.getInstance(document, new FileOutputStream(fileName));

            // Mở document để bắt đầu viết
            document.open();

            // Thêm thông tin hóa đơn vào document
            Paragraph paragraph2 = new Paragraph("CÔNG TY CP SÁCH GIÁO DỤC TẠI TP. HCM", font);
            Paragraph paragraph3 = new Paragraph("HIỆU SÁCH TƯ NHÂN FUTUREZE", fontHead);
            Paragraph paragraph4 = new Paragraph("Nhóm 14", font);
            Paragraph paragraph5 = new Paragraph("HÓA ĐƠN THANH TOÁN", fontTieuDe);

            // Đặt căn giữa cho đối tượng Paragraph
            paragraph3.setAlignment(Element.ALIGN_CENTER);
            paragraph2.setAlignment(Element.ALIGN_CENTER);
            paragraph4.setAlignment(Element.ALIGN_CENTER);
            paragraph5.setAlignment(Element.ALIGN_CENTER);

            // Thêm đối tượng Paragraph vào tài liệu
            document.add(paragraph2);
            document.add(paragraph3);
            document.add(paragraph4);
            document.add(paragraph5);
            document.add(new Paragraph("\n"));
            
            document.add(new Paragraph("Mã hóa đơn: " + maHD, font));
            document.add(new Paragraph("Ngày Thanh Toán: " + ngayThanhToanFormatted, font));
            document.add(new Paragraph("Thu Ngân: " + tenNhanVien, font));
            document.add(new Paragraph("\n"));
            // Tạo bảng cho sản phẩm trong hóa đơn
            PdfPTable table = new PdfPTable(3);
            table.setWidthPercentage(100);

            // Thêm font cho header của bảng
            PdfPCell cellHeadTenSP = new PdfPCell(new Paragraph("Tên Sản Phẩm", fontHead));
            PdfPCell cellHeadGia = new PdfPCell(new Paragraph("Giá", fontHead));
            PdfPCell cellHeadSoLuong = new PdfPCell(new Paragraph("Số Lượng", fontHead));

            // Thêm header vào bảng
            table.addCell(cellHeadTenSP);
            table.addCell(cellHeadGia);
            table.addCell(cellHeadSoLuong);

            // Lấy thông tin sản phẩm từ tblSPHD và thêm vào bảng
            for (int i = 0; i < tblSPHD.getRowCount(); i++) {
                PdfPCell cellSP = new PdfPCell(new Paragraph(tblSPHD.getValueAt(i, 1).toString(), font));
                PdfPCell cellSL = new PdfPCell(new Paragraph(tblSPHD.getValueAt(i, 2).toString(), font));
                PdfPCell cellGia = new PdfPCell(new Paragraph(tblSPHD.getValueAt(i, 3).toString(), font));

                // Loại bỏ đường viền cho từng ô trong dòng (trừ hàng header)
                cellSP.setBorder(PdfPCell.NO_BORDER);
                cellSL.setBorder(PdfPCell.NO_BORDER);
                cellGia.setBorder(PdfPCell.NO_BORDER);

                table.addCell(cellSP);
                table.addCell(cellSL);
                table.addCell(cellGia);
            }

            
            //
            double tongGiaGoc = 0;
    	    int tongSoSanPham = 0;

    	    for (int i = 0; i < modelSPHD.getRowCount(); i++) {
    	        int soLuong = (int) modelSPHD.getValueAt(i, 3);
    	        double giaGoc = (double) modelSPHD.getValueAt(i, 2);

    	        tongGiaGoc += soLuong * giaGoc;
    	        tongSoSanPham += soLuong;
    	    }
    	    
//    	    txtTongSP.setText(String.valueOf(tongSoSanPham));
//    	    txtTienKhachTra.setText(String.valueOf(tongGiaGoc));
    	    
            
    	    tableTien = new PdfPTable(3);
            tableTien.setWidthPercentage(100);
            
            PdfPCell kt = new PdfPCell(new Paragraph("", fontHead));;
    	    kt.setBorder(Rectangle.BOTTOM);
            
            tableTien.addCell(kt);
            tableTien.addCell(kt);
            tableTien.addCell(kt);
            
            Locale localeVN = new Locale("vi", "VN");
            NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(localeVN);
            String strTongTien = currencyFormat.format(tongGiaGoc);
            
            PdfPCell tongTien = new PdfPCell(new Paragraph("Tổng tiền", fontHead));
            kt = new PdfPCell(new Paragraph("", fontHead));
            PdfPCell tongTienValue = new PdfPCell(new Paragraph(strTongTien, font));
            
            double dbtongTien = Double.parseDouble(txtTienKhachTra.getText());
            double dbtongTienCK = tongGiaGoc - dbtongTien;
            String strTongTienTT = currencyFormat.format(dbtongTien);
            String strTongTienCK = currencyFormat.format(dbtongTienCK);
            PdfPCell tongTienCK = new PdfPCell(new Paragraph("Tổng tiền chiết khấu", fontHead));
            kt = new PdfPCell(new Paragraph("", fontHead));
            PdfPCell tongTienCKValue = new PdfPCell(new Paragraph(strTongTienCK, font));
            
            PdfPCell tongTienKT = new PdfPCell(new Paragraph("Tổng số thanh toán", fontHead));
            kt = new PdfPCell(new Paragraph("", fontHead));
            PdfPCell tongTienKTValue = new PdfPCell(new Paragraph(strTongTienTT, font));
            
            tongTien.setBorder(PdfPCell.NO_BORDER);
            kt.setBorder(PdfPCell.NO_BORDER);
            tongTienValue.setBorder(PdfPCell.NO_BORDER);
            
            tongTienCK.setBorder(PdfPCell.NO_BORDER);
            kt.setBorder(PdfPCell.NO_BORDER);
            tongTienCKValue.setBorder(PdfPCell.NO_BORDER);
            
            tongTienKT.setBorder(PdfPCell.NO_BORDER);
            kt.setBorder(PdfPCell.NO_BORDER);
            tongTienKTValue.setBorder(PdfPCell.NO_BORDER);

            tableTien.addCell(tongTien);
            tableTien.addCell(kt);
            tableTien.addCell(tongTienValue);
            
            tableTien.addCell(tongTienCK);
            tableTien.addCell(kt);
            tableTien.addCell(tongTienCKValue);
            
            tableTien.addCell(tongTienKT);
            tableTien.addCell(kt);
            tableTien.addCell(tongTienKTValue);
            
            tableTienKhach = new PdfPTable(3);
            tableTienKhach.setWidthPercentage(100);
            
            double dbtienKD = Double.parseDouble(txtTienKhachDua.getText());
            String strTienKD = currencyFormat.format(dbtienKD);
            
            PdfPCell tienKD = new PdfPCell(new Paragraph("Tiền khách đưa", fontHead));
            kt = new PdfPCell(new Paragraph("", fontHead));
            PdfPCell tienKDValue = new PdfPCell(new Paragraph(strTienKD, font));
            
            double dbtienThua = Double.parseDouble(txtTienThua.getText());
            String strTienThua = currencyFormat.format(dbtienThua);
            PdfPCell tienThua = new PdfPCell(new Paragraph("Tiền trả lại", fontHead));
            kt = new PdfPCell(new Paragraph("", fontHead));
            PdfPCell tienThuaValue = new PdfPCell(new Paragraph(strTienThua, font));
            
            tienKD.setBorder(PdfPCell.NO_BORDER);
            kt.setBorder(PdfPCell.NO_BORDER);
            tienKDValue.setBorder(PdfPCell.NO_BORDER);
            
            tienThua.setBorder(PdfPCell.NO_BORDER);
            kt.setBorder(PdfPCell.NO_BORDER);
            tienThuaValue.setBorder(PdfPCell.NO_BORDER);
            
            tableTienKhach.addCell(tienKD);
            tableTienKhach.addCell(kt);
            tableTienKhach.addCell(tienKDValue);
            
            tableTienKhach.addCell(tienThua);
            tableTienKhach.addCell(kt);
            tableTienKhach.addCell(tienThuaValue);
            
            kt.setBorder(Rectangle.BOTTOM);
            
            tableTienKhach.addCell(kt);
            tableTienKhach.addCell(kt);
            tableTienKhach.addCell(kt);
            
            // Thêm bảng vào document
            document.add(table);
            document.add(new Paragraph("\n"));
            document.add(tableTien);
            document.add(new Paragraph("\n"));
            document.add(tableTienKhach);
            document.add(new Paragraph("\n"));
            //
            Paragraph prTH = new Paragraph("Khách hàng đã mua chỉ đổi trả lại trong vòng 3 ngày", font);
            Paragraph prTHtt = new Paragraph("(có kèm theo hóa đơn)", font);
            Paragraph prCamOn = new Paragraph("XIN CẢM ƠN QUÝ KHÁCH & HẸN GẶP LẠI", font);

            // Đặt căn giữa cho đối tượng Paragraph
            prTH.setAlignment(Element.ALIGN_CENTER);
            prTHtt.setAlignment(Element.ALIGN_CENTER);
            prCamOn.setAlignment(Element.ALIGN_CENTER);

            // Thêm đối tượng Paragraph vào tài liệu
            document.add(prTH);
            document.add(prTHtt);
            document.add(prCamOn);
            
            // Đóng document
            document.close();

            // Hiển thị thông báo thành công
            JOptionPane.showMessageDialog(this, "Hóa đơn đã được xuất thành công.");

        } catch (DocumentException | IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Có lỗi xảy ra khi xuất hóa đơn.");
        }
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
}
