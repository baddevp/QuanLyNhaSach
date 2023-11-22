package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.KeyEventDispatcher;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
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
import dao.DAO_CTHD;
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
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTabbedPane;
import java.awt.FlowLayout;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Rectangle;
import javax.swing.JCheckBox;
import java.awt.Component;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class GuiThongKe extends JFrame implements ActionListener, MouseListener {

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
	//private List<Object[]> rows;
	private GuiQuanLyKhachHang guiQLKH;
	private DAO_QuanLySach sach_dao;
	private DAO_QuanLyVPP vpp_dao;
	private DAO_HoaDon hoadon_dao;
	private DAO_NhanVien nhanvien_dao;
	private GuiDangNhap guiDangNhap;
	private GuiTrangChu GuiTrangChu;
	private JDateChooser dtmNgayLap;
	private DAO_CTHD chitiethoadon_dao;
	private JButton btnSuaSL;
	private GuiQuanLyKhachHang guiKhachHang;
	
	static JTextField tenNV;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			

			public void run() {
				try {
					GuiThongKe frame = new GuiThongKe();
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
	public GuiThongKe() {
		this.tenNV = tenNV;
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
	
		//Tiêu đề
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
		
		//hien thi ngay lap
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
		btnTimKiemKH.setIcon(new ImageIcon(GuiThongKe.class.getResource("/image/TimKiem.png")));
		btnTimKiemKH.setBounds(275, 109, 40, 30);
		pnlThongTinHoaDon.add(btnTimKiemKH);
		btnTimKiemKH.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnTimKiemKH.setBackground(Color.WHITE);
		
		
		
		btnXoaDong = new JButton("Xóa dòng");
		btnXoaDong.setIcon(new ImageIcon(GuiThongKe.class.getResource("/image/TacVu_Xoa.png")));
		btnXoaDong.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnXoaDong.setBackground(Color.WHITE);
		btnXoaDong.setBounds(729, 250, 159, 36);
		pnlHoaDon.add(btnXoaDong);
		
		btnHangCho = new JButton("Hàng chờ");
		btnHangCho.setIcon(new ImageIcon(GuiThongKe.class.getResource("/image/TacVu_HangCho.png")));
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
		
//		JScrollPane jScrollPane_TTHD = new JScrollPane((Component) null);
//		jScrollPane_TTHD.setBounds(10, 10, 875, 299);
//		pnlTbTTHoaDon.add(jScrollPane_TTHD);
		
		//Table San Pham trong hóa đơn
		modelSPHD = new DefaultTableModel();
		modelSPHD.addColumn("Mã SP");
		modelSPHD.addColumn("Tên SP");
		modelSPHD.addColumn("Giá bán");
		modelSPHD.addColumn("Số lượng");
		modelSPHD.addColumn("Thành tiền");
		tblSPHD = new JTable(modelSPHD);
		tblSPHD.setBackground(new Color(153, 204, 255));
		JScrollPane jScrollPane_TTHD = new JScrollPane(tblSPHD);
		jScrollPane_TTHD.setBounds(10, 10 , 877, 300);
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
		btnThanhToan.setBounds(659, 797, 216, 52);
		pnlHoaDon.add(btnThanhToan);
		
		txtTienThua = new JTextField();
		txtTienThua.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTienThua.setEditable(false);
		txtTienThua.setColumns(10);
		txtTienThua.setBounds(183, 820, 273, 30);
		pnlHoaDon.add(txtTienThua);
		
		btnTaoDonMoi = new JButton("Tạo Đơn Mới");
		btnTaoDonMoi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnTaoDonMoi.setBackground(Color.WHITE);
		btnTaoDonMoi.setBounds(659, 718, 216, 52);
		pnlHoaDon.add(btnTaoDonMoi);
		
		btnSuaSL = new JButton("Sửa số lượng");
		btnSuaSL.setIcon(new ImageIcon(GuiThongKe.class.getResource("/image/TacVu_Sua.png")));
		
		btnSuaSL.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSuaSL.setBackground(Color.WHITE);
		btnSuaSL.setBounds(549, 250, 170, 36);
		pnlHoaDon.add(btnSuaSL);
		
		JPanel pnlSanPhamChon = new JPanel();
		pnlSanPhamChon.setBackground(new Color(255, 255, 255));
		pnlSanPhamChon.setBounds(0, 260, 963, 633);
		pnlLapHoaDon.add(pnlSanPhamChon);
		pnlSanPhamChon.setLayout(null);
		
		JPanel pnlSanPham = new JPanel();
		pnlSanPham.setBounds(10, 46, 945, 576);
		pnlSanPhamChon.add(pnlSanPham);
		pnlSanPham.setLayout(null);
		
		//table San Pham chọn
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
		jScrollPaneSP.setBounds(10, 11 , 925, 554);
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
		chitiethoadon_dao = new DAO_CTHD();
		guiKhachHang = new GuiQuanLyKhachHang();
		
		try {
			ConnectDB.getInstance().connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//Dua sql len bang
		DocDuLieuDatabaseSach();
		DocDuLieuDatabaseVPP();
		//hien thi ma 
		hienThiThongTin();
		
		btnTaoDonMoi.addActionListener(this);
		btnThanhToan.addActionListener(this);
		btnTimKiemKH.addActionListener(this);
		btnHangCho.addActionListener(this);
		btnXoaDong.addActionListener(this);
		btnSuaSL.addActionListener(this);
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
		        tinhTienThua(Double.valueOf(tienKhachDua));
		    }
		    
		}); 
		//
		//rows = new ArrayList<>();
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
		if(o.equals(btnTimKiemKH)) 
			timKH();
		if(o.equals(btnXoaDong)) 
			xoaDong();
		if(o.equals(btnThanhToan)) {
			themHD();
		}
		if(o.equals(btnSuaSL)) 
			thayDoiSoLuong();
		
	}
	//
	private void DocDuLieuDatabaseSach() {
		sach_dao = new DAO_QuanLySach();
		for(Sach s : sach_dao.getALLSach()) {
			modelSP.addRow(new Object[] {s.getMaSanPham(), s.getTenSanPham(), s.getLoaiSach().getTenLoai(), s.getLoaiBia(), s.getSoLuong(), s.getThue(), s.getGiaBan()});
		}
	}
	//
	private void DocDuLieuDatabaseVPP() {
		vpp_dao = new DAO_QuanLyVPP();
		for(VanPhongPham v : vpp_dao.getALLVPP()) {
			modelSP.addRow(new Object[] {v.getMaSanPham(), v.getTenSanPham(), v.getLoaiVanPhongPham().getTenLoaiVPP(), v.getMaMau().getTenMau(), v.getSoLuong(), v.getThue(), v.getGiaBan()});
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
		List<KhachHang> list = khachhang_dao.getKhachHangTheoSDT(sdtKH);
		if(sdtKH.equals(""))
			JOptionPane.showMessageDialog(this, "Vui lòng nhập số điện thoại khách hàng cần tìm.");
		else if (list != null && list.size() > 0) {
			KhachHang kh = list.get(0);
			txtTenKH.setText(kh.getTenKH());
			txtDiemTL.setText(String.valueOf(kh.getDiemTL()));
		}
		else {
			int tl;
			tl = JOptionPane.showConfirmDialog(this, "Khách hàng này không có sẳn. Bạn có muốn thêm khách hàng này không?", "Thông báo",
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

	    // Tìm kiếm hàng có mã sản phẩm và tên sản phẩm giống hàng được chọn trong bảng tblSPHD
	    int index = timSPTrongHD(maSP, tenSP);

	    if (index != -1) {
	        // Nếu hàng đã tồn tại thì tăng số lượng
	        int soLuong = (int) modelSPHD.getValueAt(index, 3);
	        soLuong++;
	        modelSPHD.setValueAt(soLuong, index, 3);
	        modelSPHD.setValueAt(giaGoc * soLuong, index, 4);
	    } else {
	        // Nếu hàng chưa tồn tại, thêm hàng mới
	        modelSPHD.addRow(new Object[]{maSP, tenSP, giaGoc, 1, giaGoc});
	    }
	    
	    tinhTongGiaGoc();
	}
	//
	public void tinhTienThua(double tienKhachDua) {
		double tongGiaGoc = 0;
	    for (int i = 0; i < modelSPHD.getRowCount(); i++) {
	        tongGiaGoc += (double) modelSPHD.getValueAt(i, 4);
	    }
	    double tienThoi = 0;
	    if(tienKhachDua < tongGiaGoc)
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

	//
	private String generateMaHD() {
		try {
			java.util.Date currentDate = new java.util.Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
	        String formattedDate = dateFormat.format(currentDate);
	        
	        int sequenceNumber = hoadon_dao.getCurrentSequenceNumber();
	        sequenceNumber++;
	        String sequencePart = String.format("%03d", sequenceNumber);
	        
	        String maNV = tenNV.getText();
	        int index1 = maNV.indexOf("23");
	        int index2 = maNV.indexOf(" ", index1);
	        if (index1 == -1) {
	            return null;
	          }
			//HD20112023002001
	        String subMaNV = maNV.substring(index1 + 2, index1 + 5);
	        return "HD" + formattedDate + subMaNV + sequencePart;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	//
//	private String generateMaHD() {
//        
//		String newMaHD = "HD20112023002001";  	 
//       	try {        		
//       		java.util.Date currentDate = new java.util.Date();
//    		SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
//            String formattedDate = dateFormat.format(currentDate);
//            
//       		int nextInvoiceNumbber = hoadon_dao.getNextInvoiceNumber(formattedDate);
//       		
//            String loaiMa = "HD";
////            int num = hoadon_dao.getmaHDtudong(loaiMa);
////            num++;        
////            String numString = String.format("%04d", num).trim();
//            
//            String maNV = "NV14112023002";
//	        int index1 = maNV.indexOf("23");
//	        int index2 = maNV.indexOf(" ", index1);
//	        if (index1 == -1) {
//	            return null;
//	          }
//			//HD20112023002001
//	        String subMaNV = maNV.substring(index1 + 2, index1 + 5);
//            
//            newMaHD = loaiMa + formattedDate + subMaNV + nextInvoiceNumbber;
//
//           } catch (Exception e) {
//               e.printStackTrace();
//           }
//		
//       return newMaHD;
//   }
	//
	//
	private void hienThiThongTin() {
	    String maHD = generateMaHD(); 
	    txtMaHD.setText(maHD);
	    
	    String maNV = tenNV.getText();
	    //String maNV = "NV14112023002";
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
	        JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng để xóa.", "Thông báo", JOptionPane.WARNING_MESSAGE);
	        return;
	    }
		timDongTrongBang(tblSPHD, row);
		tinhTongGiaGoc();
	}
	//
	public void themHD() {
		String maHD = generateMaHD();
		java.util.Date ngayLap = dtmNgayLap.getDate();
		double tienNhan = Double.parseDouble(txtTienKhachDua.getText());
		double tongTien = Double.parseDouble(txtTienKhachTra.getText());
		String nv = tenNV.getText();
		NhanVien maNV = new NhanVien(nv);
		String sdtkh = txtSDTKH.getText();
		boolean trangThai = true;
		
		//
		if(sdtkh.isEmpty()) {
			guiKhachHang = new GuiQuanLyKhachHang();
			String maKL = guiKhachHang.txtMaKH.getText();
			String tenKL = "Khách lẻ";
			String diaChi = "Không";
			String sdtKL = "Không";
		    int diemTLKL = 0;
		    String emailKL = "Không";
		    
		    java.util.Date ngayLapUtil = new java.util.Date();
		    java.sql.Date ngayLapKL = new java.sql.Date(ngayLapUtil.getTime());
			
		    KhachHang khle = new KhachHang(maKL, tenKL, diaChi, sdtKL, diemTLKL, ngayLapKL, emailKL);
		    KhachHang kle = new KhachHang(maKL);
		    if (khachhang_dao.createKH(khle)) {
		    	HoaDon hd = new HoaDon(maHD, ngayLap, tienNhan, tongTien, maNV, kle, trangThai);
				if(hoadon_dao.createHD(hd)) {
					JOptionPane.showMessageDialog(this, "Bạn đã thanh toán thành công");
					themCTHD(hd);
					
				}
		    }
			
		}
		//
		ArrayList<KhachHang> list = khachhang_dao.getKhachHangTheoSDT(sdtkh);
		
		for(KhachHang kh : list) {
			String k = kh.getMaKH();
			KhachHang maKH = new KhachHang(k);
			
			
			//
			int diemCu = kh.getDiemTL();
			int diemMoi = (int)tongTien / 100;
			int diemCongMoi = diemCu + diemMoi;
			khachhang_dao.updateDiemTL(diemCongMoi, sdtkh);
			//
			HoaDon hd = new HoaDon(maHD, ngayLap, tienNhan, tongTien, maNV, maKH, trangThai);
			if(hoadon_dao.createHD(hd)) {
				JOptionPane.showMessageDialog(this, "Bạn đã thanh toán thành công");
				themCTHD(hd);
				
			}
		}
		
	}
	//
	public void themCTHD(HoaDon hd) {
	    int soLuongDong = modelSPHD.getRowCount();

	    for (int i = 0; i <= soLuongDong; i++) {
	        // Kiểm tra xem chỉ số i có hợp lệ không
	        if (i < tblSPHD.getRowCount()) {
	            String maSP = (String) tblSPHD.getValueAt(i, 0);
	            SanPham sanPham = new SanPham(maSP);

	            if (isSach(maSP)) {
	           
	                    int soLuong = (int) tblSPHD.getValueAt(i, 3);
	                    ChiTietHoaDon cthd = new ChiTietHoaDon(hd, sanPham, soLuong);
	                    chitiethoadon_dao.createCTHD(cthd);

	            } else {
	                    int soLuong = (int) tblSPHD.getValueAt(i, 3);
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
	        JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng để thay đổi số lượng.", "Thông báo", JOptionPane.WARNING_MESSAGE);
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
	                JOptionPane.showMessageDialog(this, "Đã cập nhật số lượng thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
	                tinhTongGiaGoc();
	            } else if (newQuantity == 0) {
	            	xoaDong();
	            } else {
	                JOptionPane.showMessageDialog(this, "Số lượng phải là một số không âm.", "Lỗi", JOptionPane.ERROR_MESSAGE);
	            }
	        }
	    } catch (NumberFormatException ex) {
	        JOptionPane.showMessageDialog(this, "Vui lòng nhập một số nguyên hợp lệ.", "Lỗi", JOptionPane.ERROR_MESSAGE);
	    }
	}
	//
	public void tinhTongGiaGoc() {
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

	//
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
