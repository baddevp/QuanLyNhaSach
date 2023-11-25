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
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
import com.toedter.calendar.IDateEditor;

public class GuiThongKeTam extends JFrame implements ActionListener, MouseListener {

	public static JPanel contentPane;
	private DefaultTableModel modelSP;
	private JTable tblTopSP;
	private Font font1;
	private Font font2;
	private JTable tblTopNV;
	private DAO_KhachHang khachhang_dao;
	private JButton btnThongKe;
	private GuiQuanLyKhachHang guiQLKH;
	private DAO_QuanLySach sach_dao;
	private DAO_QuanLyVPP vpp_dao;
	private DAO_HoaDon hoadon_dao;
	private DAO_NhanVien nhanvien_dao;
	private GuiDangNhap guiDangNhap;
	private GuiTrangChu GuiTrangChu;
	private JDateChooser dtmNgayKT;
	private DAO_CTHD chitiethoadon_dao;
	private GuiQuanLyKhachHang guiKhachHang;
	private DAO_QuanLyVPP vanphongpham_dao;
	
	static JTextField tenNV;
	private JTextField txtTongSLHD;
	private JTextField txtTongDoanhThu;
	private JTextField txtSLSPChuaBan;
	private JTextField txtTongSLSPDaBan;
	private JPanel pnlTopNV;
	private DefaultTableModel modelTopNV;
	private DefaultTableModel modelTopSP;
	private List<SanPham> danhSachSP;
    private List<ChiTietHoaDon> danhSachCTHD;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			

			public void run() {
				try {
					GuiThongKeTam frame = new GuiThongKeTam();
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
	public GuiThongKeTam() {
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
		
		JLabel lblTieuDe = new JLabel("THỐNG KÊ");
		lblTieuDe.setBackground(new Color(51, 204, 255));
		pnlTieuDe.add(lblTieuDe);
		lblTieuDe.setFont(font1);
		lblTieuDe.setForeground(new Color(0, 204, 204));
		
		JPanel pnlGUIThongKe = new JPanel();
		pnlGUIThongKe.setBounds(10, 80, 1890, 903);
		contentPane.add(pnlGUIThongKe);
		pnlGUIThongKe.setLayout(null);
		
		JPanel pnlChonKhachHang = new JPanel();
		pnlChonKhachHang.setBorder(new EmptyBorder(0, 0, 0, 0));
		pnlChonKhachHang.setBackground(new Color(255, 255, 255));
		pnlChonKhachHang.setBounds(0, 0, 1055, 249);
		pnlGUIThongKe.add(pnlChonKhachHang);
		pnlChonKhachHang.setLayout(null);
		
		JPanel pnlDienThongKe = new JPanel();
		pnlDienThongKe.setBounds(20, 41, 1025, 194);
		pnlChonKhachHang.add(pnlDienThongKe);
		pnlDienThongKe.setLayout(null);
		
		JLabel lblNgayKT = new JLabel("Đến ngày :");
		lblNgayKT.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblNgayKT.setBounds(435, 40, 113, 30);
		pnlDienThongKe.add(lblNgayKT);
		
		JLabel lbnNgayBD = new JLabel("Từ ngày:");
		lbnNgayBD.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lbnNgayBD.setBounds(31, 40, 92, 30);
		pnlDienThongKe.add(lbnNgayBD);
		
		dtmNgayKT = new JDateChooser();
		dtmNgayKT.setBounds(556, 39, 222, 35);
		
			pnlDienThongKe.add(dtmNgayKT);
			
			JLabel lblNam = new JLabel("Năm:");
			lblNam.setFont(new Font("Times New Roman", Font.PLAIN, 24));
			lblNam.setBounds(31, 119, 63, 30);
			pnlDienThongKe.add(lblNam);
			
			btnThongKe = new JButton("THỐNG KÊ");
			btnThongKe.setBounds(808, 39, 171, 35);
			pnlDienThongKe.add(btnThongKe);
			btnThongKe.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnThongKe.setBackground(Color.WHITE);
			
			JDateChooser dtmNgayBD = new JDateChooser((IDateEditor) null);
			dtmNgayBD.setBounds(148, 39, 222, 35);
			pnlDienThongKe.add(dtmNgayBD);
			
			JButton btnQuy1 = new JButton("THỐNG KÊ QUÝ I");
			btnQuy1.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnQuy1.setBackground(Color.WHITE);
			btnQuy1.setBounds(217, 118, 192, 35);
			pnlDienThongKe.add(btnQuy1);
			
			JButton btnQuy2 = new JButton("THỐNG KÊ QUÝ II");
			btnQuy2.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnQuy2.setBackground(Color.WHITE);
			btnQuy2.setBounds(419, 119, 192, 35);
			pnlDienThongKe.add(btnQuy2);
			
			JButton btnQuy3 = new JButton("THỐNG KÊ QUÝ III");
			btnQuy3.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnQuy3.setBackground(Color.WHITE);
			btnQuy3.setBounds(624, 119, 192, 35);
			pnlDienThongKe.add(btnQuy3);
			
			JButton btnQuy4 = new JButton("THỐNG KÊ QUÝ IV");
			btnQuy4.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnQuy4.setBackground(Color.WHITE);
			btnQuy4.setBounds(823, 119, 192, 35);
			pnlDienThongKe.add(btnQuy4);
			
			JComboBox cboNam = new JComboBox();
			cboNam.setBounds(101, 118, 84, 35);
			pnlDienThongKe.add(cboNam);
			btnThongKe.addActionListener(this);
		
		JPanel pnlBangTop = new JPanel();
		pnlBangTop.setBackground(new Color(255, 255, 255));
		pnlBangTop.setBounds(1065, 0, 825, 893);
		pnlGUIThongKe.add(pnlBangTop);
		pnlBangTop.setLayout(null);
		
		//hien thi ngay lap
		java.util.Date currentDate = new java.util.Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String formattedDate = dateFormat.format(currentDate);
		
		JLabel lblThongTinHD = new JLabel("Top sản phẩm bán chạy ");
		lblThongTinHD.setBounds(10, 0, 266, 36);
		pnlBangTop.add(lblThongTinHD);
		lblThongTinHD.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		pnlTopNV = new JPanel();
		pnlTopNV.setLayout(null);
		pnlTopNV.setBounds(10, 561, 803, 321);
		pnlBangTop.add(pnlTopNV);

		//Table San Pham trong hóa đơn
		modelTopNV = new DefaultTableModel();
		modelTopNV.addColumn("STT");
		modelTopNV.addColumn("Mã NV");
		modelTopNV.addColumn("Tên NV");
		modelTopNV.addColumn("Thành tiền");
		tblTopNV = new JTable(modelTopNV);
		tblTopNV.setBackground(new Color(153, 204, 255));
		JScrollPane jScrollPaneNV = new JScrollPane(tblTopNV);
		jScrollPaneNV.setBounds(10, 11 , 783, 300);
		JTableHeader tbHeaderTopNV = tblTopNV.getTableHeader();
		tbHeaderTopNV.setFont(font2);
		tbHeaderTopNV.setBackground(new Color(51, 204, 204));
		pnlTopNV.setLayout(null);
		tblTopNV.setFont(font2);
		tblTopNV.setRowHeight(35);
		pnlTopNV.add(jScrollPaneNV);
		
		
		JPanel pnlTopSP = new JPanel();
		modelTopSP = new DefaultTableModel();
		modelTopSP.addColumn("STT");
		modelTopSP.addColumn("Mã SP");
		modelTopSP.addColumn("Tên SP");
		modelTopSP.addColumn("Số lượng tồn");
		modelTopSP.addColumn("Số lượng bán");
		pnlTopSP.setBounds(10, 39, 803, 483);
		pnlBangTop.add(pnlTopSP);
		pnlTopSP.setLayout(null);
		tblTopSP = new JTable(modelTopSP);
		tblTopSP.setBackground(new Color(153, 204, 255));
		JScrollPane jScrollPaneTopSP = new JScrollPane(tblTopSP);
		jScrollPaneTopSP.setBounds(10, 11 , 783, 460);
		JTableHeader tbHeaderTopSP = tblTopSP.getTableHeader();
		tbHeaderTopSP.setFont(font2);
		tbHeaderTopSP.setBackground(new Color(51, 204, 204));
		pnlTopSP.setLayout(null);
		tblTopSP.setFont(font2);
		tblTopSP.setRowHeight(35);
		pnlTopSP.add(jScrollPaneTopSP);
		
		JLabel lblTopNhnVin = new JLabel("Top nhân viên có doanh số cao nhất");
		lblTopNhnVin.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTopNhnVin.setBounds(10, 522, 347, 36);
		pnlBangTop.add(lblTopNhnVin);
		
		
		tblTopSP.addMouseListener(this);
		
		
		JPanel pnlThongKe = new JPanel();
		pnlThongKe.setBackground(new Color(255, 255, 255));
		pnlThongKe.setBounds(22, 260, 1033, 633);
		pnlGUIThongKe.add(pnlThongKe);
		pnlThongKe.setLayout(null);
		
		JLabel lblTongSLSPDaBan = new JLabel("Tổng số lượng sản phẩm đã bán");
		lblTongSLSPDaBan.setHorizontalAlignment(SwingConstants.CENTER);
		lblTongSLSPDaBan.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTongSLSPDaBan.setBounds(573, 334, 393, 38);
		pnlThongKe.add(lblTongSLSPDaBan);
		
		JLabel lblSLSPChuaBan = new JLabel("Số lượng sản phẩm chưa từng được bán");
		lblSLSPChuaBan.setHorizontalAlignment(SwingConstants.CENTER);
		lblSLSPChuaBan.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSLSPChuaBan.setBounds(74, 334, 393, 38);
		pnlThongKe.add(lblSLSPChuaBan);
		
		JLabel lblTongDoanhThu = new JLabel("Tổng doanh thu");
		lblTongDoanhThu.setHorizontalAlignment(SwingConstants.CENTER);
		lblTongDoanhThu.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTongDoanhThu.setBounds(573, 36, 393, 38);
		pnlThongKe.add(lblTongDoanhThu);
		
		JLabel lblTongSLHD = new JLabel("Tổng số lượng hóa đơn đã xuất");
		lblTongSLHD.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTongSLHD.setHorizontalAlignment(SwingConstants.CENTER);
		lblTongSLHD.setBounds(74, 36, 393, 38);
		pnlThongKe.add(lblTongSLHD);
		
		txtTongDoanhThu = new JTextField();
		txtTongDoanhThu.setEditable(false);
		txtTongDoanhThu.setBackground(new Color(240, 230, 140));
		txtTongDoanhThu.setHorizontalAlignment(SwingConstants.CENTER);
		txtTongDoanhThu.setFont(new Font("Tahoma", Font.BOLD, 25));
		txtTongDoanhThu.setColumns(10);
		txtTongDoanhThu.setBounds(573, 36, 393, 252);
		pnlThongKe.add(txtTongDoanhThu);
		
		txtTongSLHD = new JTextField();
		txtTongSLHD.setEditable(false);
		txtTongSLHD.setBackground(new Color(255, 160, 122));
		txtTongSLHD.setHorizontalAlignment(SwingConstants.CENTER);
		txtTongSLHD.setFont(new Font("Tahoma", Font.BOLD, 25));
		txtTongSLHD.setBounds(74, 36, 393, 252);
		pnlThongKe.add(txtTongSLHD);
		txtTongSLHD.setColumns(10);
		
		txtSLSPChuaBan = new JTextField();
		txtSLSPChuaBan.setEditable(false);
		txtSLSPChuaBan.setBackground(new Color(152, 251, 152));
		txtSLSPChuaBan.setFont(new Font("Tahoma", Font.BOLD, 25));
		txtSLSPChuaBan.setHorizontalAlignment(SwingConstants.CENTER);
		txtSLSPChuaBan.setColumns(10);
		txtSLSPChuaBan.setBounds(74, 333, 393, 252);
		pnlThongKe.add(txtSLSPChuaBan);
		
		txtTongSLSPDaBan = new JTextField();
		txtTongSLSPDaBan.setEditable(false);
		txtTongSLSPDaBan.setBackground(new Color(64, 224, 208));
		txtTongSLSPDaBan.setFont(new Font("Tahoma", Font.BOLD, 25));
		txtTongSLSPDaBan.setHorizontalAlignment(SwingConstants.CENTER);
		txtTongSLSPDaBan.setColumns(10);
		txtTongSLSPDaBan.setBounds(573, 333, 393, 252);
		pnlThongKe.add(txtTongSLSPDaBan);
		
		// ket noi sql
		khachhang_dao = new DAO_KhachHang();
		hoadon_dao = new DAO_HoaDon();
		nhanvien_dao = new DAO_NhanVien();
		chitiethoadon_dao = new DAO_CTHD();
		vanphongpham_dao = new DAO_QuanLyVPP();
		guiKhachHang = new GuiQuanLyKhachHang();
		
		try {
			ConnectDB.getInstance().connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		//hien thi ma 
		tblTopNV.addMouseListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	//
//	public int thongKeSanPhamChuaBan() {
//		Set<String> sanPhamDaBan = new HashSet<>();
//		for(ChiTietHoaDon cthd : danhSachCTHD) {
//			String[] sanPhamTrongCTHD = cthd.getSanPham().getMaSanPham().split(",");
//			for(String maSP : sanPhamTrongCTHD) {
//				sanPhamDaBan.add(Integer.parseInt(maSP.trim()));
//			}
//			
//		}
//	}
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
