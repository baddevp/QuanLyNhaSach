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
import dao.DAO_ChucVu;
import dao.DAO_HoaDon;
import dao.DAO_KhachHang;
import dao.DAO_NhanVien;
import dao.DAO_QuanLySach;
import dao.DAO_QuanLyVPP;
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

public class GuiBanHang extends JFrame implements ActionListener, MouseListener {

	public static JPanel contentPane;
	private DefaultTableModel modelKH;
	private JTextField txtTimMaSP;
	private DefaultTableModel modelSP;
	private JTable tblSP;
	private JTextField txtMaHD;
	private JTextField txtNgayLap;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiBanHang frame = new GuiBanHang();
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
	public GuiBanHang() {
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
		lblNgayLap.setBounds(278, 40, 102, 30);
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
		txtMaHD.setBounds(100, 41, 156, 30);
		pnlThongTinHoaDon.add(txtMaHD);
		txtMaHD.setColumns(10);
		
		//hien thi ngay lap
		java.util.Date currentDate = new java.util.Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String formattedDate = dateFormat.format(currentDate);
        
		txtNgayLap = new JTextField(formattedDate);
		txtNgayLap.setEditable(false);
		txtNgayLap.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtNgayLap.setBounds(391, 40, 187, 30);
		pnlThongTinHoaDon.add(txtNgayLap);
		
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
		
//		JScrollPane jScrollPane_TTHD = new JScrollPane((Component) null);
//		jScrollPane_TTHD.setBounds(10, 10, 875, 299);
//		pnlTbTTHoaDon.add(jScrollPane_TTHD);
		
		//Table San Pham trong hóa đơn
		modelSPHD = new DefaultTableModel();
		modelSPHD.addColumn("Mã SP");
		modelSPHD.addColumn("Tên SP");
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
		tblSPHD.addMouseListener(this);
		tblSP.addMouseListener(this);
	
//		txtTimMaSP.addFocusListener(new FocusListener() {
//            @Override
//            public void focusGained(FocusEvent e) {
//                if (txtTimMaSP.getText().equals("Nhập thông tin cần tìm")) {
//                	txtTimMaSP.setText("");
//                	txtTimMaSP.setForeground(Color.BLACK); // Đổi màu chữ khi có focus
//                }
//            }
//
//            @Override
//            public void focusLost(FocusEvent e) {
//                if (txtTimMaSP.getText().isEmpty()) {
//                	txtTimMaSP.setText("Nhập thông tin cần tìm");
//                	txtTimMaSP.setForeground(Color.GRAY); // Đổi màu chữ gợi ý khi mất focus
//                }
//            }
//            
//        });
		
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
	        int soLuong = (int) modelSPHD.getValueAt(index, 2);
	        soLuong++;
	        modelSPHD.setValueAt(soLuong, index, 2);
	        modelSPHD.setValueAt(giaGoc * soLuong, index, 3);
	    } else {
	        // Nếu hàng chưa tồn tại, thêm hàng mới
	        modelSPHD.addRow(new Object[]{maSP, tenSP, 1, giaGoc});
	    }
	    
	    tinhTongGiaGoc();
	}
	//
	public void tinhTongGiaGoc() {
	    double tongGiaGoc = 0;
	    for (int i = 0; i < modelSPHD.getRowCount(); i++) {
	        tongGiaGoc += (double) modelSPHD.getValueAt(i, 3);
	    }
	    int tongSoSanPham = 0;
	    for (int i = 0; i < modelSPHD.getRowCount(); i++) {
	    	tongSoSanPham += (int) modelSPHD.getValueAt(i, 2);
	    }
	    txtTongSP.setText(String.valueOf(tongSoSanPham));
	    txtTienKhachTra.setText(String.valueOf(tongGiaGoc));
	    
//	    String tienKhachDuastr = txtTienKhachDua.getText();
//	    txtTienThua.setText(tienKhachDuastr);
//	    double tienKhachDua = Double.parseDouble(tienKhachDuastr);
//	    double tienThoi;
//	    if(tienKhachDua > tongGiaGoc) {
//	    	tienThoi = tienKhachDua - tongGiaGoc;
//	    	txtTienThua.setText(String.valueOf(tienThoi));
//	    }
//	    else
//	    	JOptionPane.showMessageDialog(this, "Tiền khách đưa ít hơn thành tiền");
	    	
	    
	}
	public void tinhTienThua(double tienKhachDua) {
		double tongGiaGoc = 0;
	    for (int i = 0; i < modelSPHD.getRowCount(); i++) {
	        tongGiaGoc += (double) modelSPHD.getValueAt(i, 3);
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
	        
	        return "HD" + formattedDate + sequencePart;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	//
	private void hienThiThongTin() {
	    String maHD = generateMaHD(); 
	    txtMaHD.setText(maHD);
	}
	// Xoa dòng
	public void timDongTrongBang(JTable table, int row) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.removeRow(row);
	}
	public void xoaDong() {
		int row = tblSPHD.getSelectedRow();
		timDongTrongBang(tblSPHD, row);
		tinhTongGiaGoc();
	}
	//
	private static void thayDoiSoLuong(JTable table, int row, Object value) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setValueAt(value, row, 2);
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
