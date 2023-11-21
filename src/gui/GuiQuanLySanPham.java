package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

import com.toedter.calendar.JDateChooser;

import connectDB.ConnectDB;
import dao.DAO_HinhAnh;
import dao.DAO_MauSac;
import dao.DAO_NSX;
import dao.DAO_QuanLyLoaiSach;
import dao.DAO_QuanLyLoaiVPP;
import dao.DAO_QuanLySach;
import dao.DAO_QuanLyVPP;
import entity.HinhAnh;
import entity.LoaiSach;
import entity.LoaiVanPhongPham;
import entity.MauSac;
import entity.NhaSanXuat;
import entity.Sach;
import entity.VanPhongPham;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;

public class GuiQuanLySanPham extends JFrame implements ActionListener, MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JPanel contentPane;
	private JPanel pnlThongTinSach;
	private JPanel pnlThongTinVPP;
	private JTextField txtMaVPP;
	private JTextField txtThuongHieu;
	private JTextField txtTenSach;
	private JTextField txtTenVPP;
	private JButton btnChonAnhVPP;
	private JTextField txtTimTenVPP;
	private JTextField txtTrangThai;
	private JTable tblKH;
	private JTable tblSach;
	private JTable tblVPP;
	private DefaultTableModel modelSach;
	private JTextField txtGiaGocVPP;
	private JTextField txtSoLuongVPP;
	private JTextField txtKhuyenMaiVPP;
	private JTextField txtMoTaVPP;
	private JLabel lblGiaBanVPP;
	private JTextField txtGiaBanVPP;
	private JTextField txtTimMaVPP;
	private JTextField txtXuatXu;
	private JTextField txtMaSach;
	private JTextField txtSoTrang;
	private JTextField txtTacGia;
	private JButton btnChonAnh;
	private JTextField txtGiaGoc;
	private JTextField txtSoLuong;
	private JTextField txtKhuyenMai;
	private JTextField txtMoTa;
	private JLabel lblGiaBan;
	private JTextField txtGiaBan;
	private JTextField txtTimTenSach;
	private JTextField txtTimTacGia;
	private JTextField txtThue;
	private JTextField txtThueVPP;
	private JTextField txtLoaiSach;
	private JTextField txtLoai_VPP;
	private DefaultTableModel modelVPP;
	private JDateChooser dtmNgayNhapSach;
	private JDateChooser dtmNgayNhapVPP;
	private JComboBox cboTinhTrangVPP;
	private JComboBox cboNSX_VPP;
	private JComboBox cboMaMau;
	private JComboBox cboLoai_VPP;
	private JButton btnLuu;
	private JButton btnSua;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnDatLai;
	private JComboBox cboLoaiSach;
	private JComboBox cboNSX;
	private JComboBox cboTimTinhTrangVPP;
	private JButton btnDatLai1;
	private JButton btnXoa1;
	private JButton btnThem1;
	private JButton btnSua1;
	private JButton btnLuu1;
	private DAO_QuanLyVPP vpp_dao;
	private DAO_QuanLySach sach_dao;
	private DAO_QuanLyLoaiSach loaiSach_dao;
	private DAO_QuanLyLoaiVPP loaiVPP_dao;
	private DAO_HinhAnh hinhanh_dao;
	private DAO_MauSac mausac_dao;
	private DAO_NSX NSX_dao;
	private JLabel lblShowAnh;
	private JLabel lblShowAnhVPP;
	private String selectedImagePath;
	private JComboBox cboLoaiBia;
	private JComboBox cboTinhTrang;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiQuanLySanPham frame = new GuiQuanLySanPham();
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
	public GuiQuanLySanPham() {
		setBackground(new Color(255, 204, 102));
		setTitle("FutureZe - Phầm mềm quản lý nhà sách");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); // Toàn màn hình
		this.setSize(1930, 1030);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel pnlTieuDe = new JPanel();
		pnlTieuDe.setBounds(10, 10, 1894, 50);
		pnlTieuDe.setBackground(new Color(255, 255, 255));
		contentPane.add(pnlTieuDe);
		
		// Kiểu chữ
		Font font1 = new Font("Times New Roman", Font.BOLD, 36);
		Font font2 = new Font("Times New Roman", Font.PLAIN, 24);
		
		JLabel lblTieuDe = new JLabel("QUẢN LÝ SẢN PHẨM");
		lblTieuDe.setBackground(new Color(51, 204, 255));
		pnlTieuDe.add(lblTieuDe);
		lblTieuDe.setFont(font1);
		lblTieuDe.setForeground(new Color(0, 204, 204));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 60, 1894, 964);
		contentPane.add(tabbedPane);
		//Tab quản lý sách
		JPanel pnlSach = new JPanel();
		pnlSach.setBackground(new Color(0, 204, 204));
		pnlSach.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tabbedPane.addTab("Sách", null, pnlSach, null);
		tabbedPane.setBackgroundAt(0, new Color(255, 255, 255));
		pnlSach.setLayout(null);
		pnlThongTinSach = new JPanel();
		pnlThongTinSach.setBackground(new Color(255, 255, 255));
		
		pnlThongTinSach.setBorder(BorderFactory.createTitledBorder("Thông tin sách"));
		pnlThongTinSach.setBounds(0, 0, 1627, 380);
		pnlSach.add(pnlThongTinSach);
		pnlThongTinSach.setLayout(null);
		
		JLabel lblMaSach = new JLabel("Mã sách :");
		lblMaSach.setBounds(100, 20, 163, 30);
		pnlThongTinSach.add(lblMaSach);
		lblMaSach.setFont(font2);
		
		JLabel lblSoTrang = new JLabel("Số trang :");
		lblSoTrang.setBounds(425, 20, 187, 29);
		lblSoTrang.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		pnlThongTinSach.add(lblSoTrang);
		
		JLabel lblNgayNhap = new JLabel("Ngày nhập :");
		lblNgayNhap.setBounds(750, 20, 163, 29);
		lblNgayNhap.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		pnlThongTinSach.add(lblNgayNhap);
		
		JLabel lblTenSach = new JLabel("Tên sách :");
		lblTenSach.setBounds(100, 110, 163, 30);
		lblTenSach.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		pnlThongTinSach.add(lblTenSach);
		
		JLabel lblLoaiBia = new JLabel("Loại bìa :");
		lblLoaiBia.setBounds(100, 290, 163, 30);
		lblLoaiBia.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		pnlThongTinSach.add(lblLoaiBia);
		
		JLabel lblNhaSanXuat = new JLabel("Nhà sản xuất :");
		lblNhaSanXuat.setBounds(750, 111, 163, 29);
		lblNhaSanXuat.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		pnlThongTinSach.add(lblNhaSanXuat);
		
		JLabel lblTacGia = new JLabel("Tác giả :");
		lblTacGia.setBounds(100, 200, 103, 30);
		lblTacGia.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		pnlThongTinSach.add(lblTacGia);
		
		txtMaSach = new JTextField();
		txtMaSach.setBounds(100, 55, 250, 35);
		txtMaSach.setEditable(false);
		pnlThongTinSach.add(txtMaSach);
		txtMaSach.setColumns(10);
		
		txtSoTrang = new JTextField();
		txtSoTrang.setBounds(425, 55, 250, 35);
		txtSoTrang.setColumns(10);
		pnlThongTinSach.add(txtSoTrang);
		
		dtmNgayNhapSach = new JDateChooser();
		dtmNgayNhapSach.setBounds(750, 55, 250, 35);
		pnlThongTinSach.add(dtmNgayNhapSach);
		
		txtTacGia = new JTextField();
		txtTacGia.setBounds(100, 235, 250, 35);
		txtTacGia.setColumns(10);
		pnlThongTinSach.add(txtTacGia);
		
		txtTenSach = new JTextField();
		txtTenSach.setBounds(100, 145, 250, 35);
		txtTenSach.setColumns(10);
		pnlThongTinSach.add(txtTenSach);
		
		
		//pnlAnhSach.setBounds(1403, 54, 214, 258);
		JPanel pnlAnhSach = new JPanel();
		pnlAnhSach.setBounds(1403, 0, 214, 258);
		pnlAnhSach.setBackground(new Color(255, 255, 255));
		pnlAnhSach.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlAnhSach.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Ảnh sản phẩm", TitledBorder.CENTER, TitledBorder.TOP, font2, new Color(0, 0, 0)));
		pnlThongTinSach.add(pnlAnhSach);
		pnlAnhSach.setLayout(null);
		
		lblShowAnh = new JLabel("");
		lblShowAnh.setBounds(10, 27, 194, 220);
		pnlAnhSach.add(lblShowAnh);
		
		btnChonAnh = new JButton("");
		btnChonAnh.setBounds(73, 96, 70, 70);
		pnlAnhSach.add(btnChonAnh);
		btnChonAnh.setBackground(new Color(255, 255, 255));
		btnChonAnh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnChonAnh.setIcon(new ImageIcon(GuiQuanLyNhanVien.class.getResource("/image/ChonAnh.png")));
		
		JLabel lblSoLuong = new JLabel("Số lượng :");
		lblSoLuong.setBounds(425, 201, 136, 29);
		lblSoLuong.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		pnlThongTinSach.add(lblSoLuong);
		
		JLabel lblKhuyenMai = new JLabel("Khuyến mãi :");
		lblKhuyenMai.setBounds(750, 200, 147, 29);
		lblKhuyenMai.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		pnlThongTinSach.add(lblKhuyenMai);
		
		JLabel lblGiaGoc = new JLabel("Giá gốc :");
		lblGiaGoc.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblGiaGoc.setBounds(425, 110, 163, 30);
		pnlThongTinSach.add(lblGiaGoc);
		
		txtGiaGoc = new JTextField();
		txtGiaGoc.setColumns(10);
		txtGiaGoc.setBounds(425, 145, 250, 35);
		pnlThongTinSach.add(txtGiaGoc);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(425, 235, 250, 35);
		pnlThongTinSach.add(txtSoLuong);
		
		JLabel lblTinhTrang = new JLabel("Tình trạng :");
		lblTinhTrang.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblTinhTrang.setBounds(425, 290, 136, 29);
		pnlThongTinSach.add(lblTinhTrang);
		
		txtKhuyenMai = new JTextField();
		txtKhuyenMai.setColumns(10);
		txtKhuyenMai.setBounds(750, 235, 250, 35);
		pnlThongTinSach.add(txtKhuyenMai);
		
		JLabel lblMoTa = new JLabel("Mô tả :");
		lblMoTa.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblMoTa.setBounds(750, 290, 136, 29);
		pnlThongTinSach.add(lblMoTa);
		
		txtMoTa = new JTextField();
		txtMoTa.setColumns(10);
		txtMoTa.setBounds(750, 325, 250, 35);
		pnlThongTinSach.add(txtMoTa);
		
		String loaiBia[] = {"Bìa mềm", "Bìa cứng"};
		cboLoaiBia = new JComboBox(loaiBia);
		cboLoaiBia.setBounds(100, 325, 250, 35);
		pnlThongTinSach.add(cboLoaiBia);
		
		String tt[] = {"Còn hàng", "Hết hàng"};
		cboTinhTrang = new JComboBox(tt);
		cboTinhTrang.setBounds(425, 325, 250, 35);
		pnlThongTinSach.add(cboTinhTrang);
		
		lblGiaBan = new JLabel("Giá bán :");
		lblGiaBan.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblGiaBan.setBounds(1075, 17, 94, 36);
		pnlThongTinSach.add(lblGiaBan);
		
		txtGiaBan = new JTextField();
		txtGiaBan.setEditable(false);
		txtGiaBan.setBounds(1075, 55, 250, 35);
		pnlThongTinSach.add(txtGiaBan);
		txtGiaBan.setColumns(10);
		
		JLabel lblThue = new JLabel("Thuế :");
		lblThue.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblThue.setBounds(1075, 104, 94, 36);
		pnlThongTinSach.add(lblThue);
		
		txtThue = new JTextField();
		txtThue.setEditable(false);
		txtThue.setColumns(10);
		txtThue.setBounds(1075, 145, 250, 35);
		pnlThongTinSach.add(txtThue);
		
		JButton btnNhapExcel = new JButton("Nhập Excel");
		btnNhapExcel.setBounds(1075, 321, 200, 35);
		pnlThongTinSach.add(btnNhapExcel);
		btnNhapExcel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnNhapExcel.setBackground(new Color(255, 255, 255));
		btnNhapExcel.hide();
		JButton btnXuatExcel = new JButton("Xuất Excel");
		btnXuatExcel.setBounds(1403, 321, 200, 35);
		pnlThongTinSach.add(btnXuatExcel);
		btnXuatExcel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnXuatExcel.setBackground(new Color(255, 255, 255));
		btnXuatExcel.hide();
		
		JLabel lblLoaiSach = new JLabel("Loại sách :");
		lblLoaiSach.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblLoaiSach.setBounds(1075, 200, 147, 36);
		pnlThongTinSach.add(lblLoaiSach);
		
		txtLoaiSach = new JTextField();
		txtLoaiSach.setVisible(false);
		txtLoaiSach.setColumns(10);
		txtLoaiSach.setBounds(1075, 235, 250, 35);
		pnlThongTinSach.add(txtLoaiSach);
		
		cboLoaiSach = new JComboBox();
		cboLoaiSach.setBounds(1075, 235, 250, 35);
		pnlThongTinSach.add(cboLoaiSach);
		
		cboNSX = new JComboBox();
		cboNSX.setBounds(750, 145, 250, 35);
		pnlThongTinSach.add(cboNSX);
		
		
		
		
		JPanel pnlTacVuCon = new JPanel();
		pnlTacVuCon.setBackground(Color.white);;
		pnlSach.add(pnlTacVuCon);
		pnlTacVuCon.setBounds(0, 390, 1890, 80);
		pnlTacVuCon.setBorder(BorderFactory.createTitledBorder("Tìm kiếm theo : "));
		
		pnlTacVuCon.setLayout(null);
		
		txtTimTenSach = new JTextField("Nhập thông tin cần tìm");
		txtTimTenSach.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTimTenSach.setBounds(220, 26, 200, 35);
		pnlTacVuCon.add(txtTimTenSach);
		txtTimTenSach.setColumns(10);
		
		JLabel lblTimTen = new JLabel("Tên sách :");
		lblTimTen.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblTimTen.setBounds(100, 24, 120, 35);
		pnlTacVuCon.add(lblTimTen);
		
		JLabel lblTimTacGia = new JLabel("Tác giả :");
		lblTimTacGia.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblTimTacGia.setBounds(520, 24, 120, 35);
		pnlTacVuCon.add(lblTimTacGia);
		
		txtTimTacGia = new JTextField("Nhập thông tin cần tìm");
		txtTimTacGia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTimTacGia.setColumns(10);
		txtTimTacGia.setBounds(640, 24, 200, 35);
		pnlTacVuCon.add(txtTimTacGia);
		
		JLabel lblTimTinhTrang = new JLabel("Tình trạng :");
		lblTimTinhTrang.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblTimTinhTrang.setBounds(940, 24, 120, 35);
		pnlTacVuCon.add(lblTimTinhTrang);
		
		JComboBox cboTimTinhTrangSach = new JComboBox();
		cboTimTinhTrangSach.setBounds(1060, 26, 200, 35);
		pnlTacVuCon.add(cboTimTinhTrangSach);
		
		txtTimTenSach.addFocusListener(new FocusListener() {
			@Override
            public void focusGained(FocusEvent e) {
                if (txtTimTenSach.getText().equals("Nhập thông tin cần tìm")) {
                    txtTimTenSach.setText("");
                    txtTimTenSach.setForeground(Color.BLACK); // Đổi màu chữ khi có focus
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtTimTenSach.getText().isEmpty()) {
                    txtTimTenSach.setText("Nhập thông tin cần tìm");
                    txtTimTenSach.setForeground(Color.GRAY); // Đổi màu chữ gợi ý khi mất focus
                }
            }
        });
		txtTimTacGia.addFocusListener(new FocusListener() {
			@Override
            public void focusGained(FocusEvent e) {
                if (txtTimTacGia.getText().equals("Nhập thông tin cần tìm")) {
                	txtTimTacGia.setText("");
                	txtTimTacGia.setForeground(Color.BLACK); // Đổi màu chữ khi có focus
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtTimTacGia.getText().isEmpty()) {
                	txtTimTacGia.setText("Nhập thông tin cần tìm");
                	txtTimTacGia.setForeground(Color.GRAY); // Đổi màu chữ gợi ý khi mất focus
                }
            }
        });
		
		
		JPanel pnlBangSach = new JPanel();
		pnlBangSach.setBounds(0, 480, 1890, 410);
		pnlSach.add(pnlBangSach);
		pnlBangSach.setBorder(BorderFactory.createTitledBorder("Bảng thông tin sách"));
		pnlBangSach.setLayout(null);
		
		

		pnlBangSach.setBackground(Color.white);;
		modelSach = new DefaultTableModel();
		modelSach.addColumn("Mã sách");
		modelSach.addColumn("Tên sách");
		modelSach.addColumn("Tác giả");
		modelSach.addColumn("Ngày nhập");
		modelSach.addColumn("Loại sách");
		modelSach.addColumn("Giá nhập");
		modelSach.addColumn("Số lượng");
		modelSach.addColumn("Thuế");
		modelSach.addColumn("Giá bán");
		modelSach.addColumn("Loại bìa");
		modelSach.addColumn("Số trang");
		modelSach.addColumn("Nhà sản xuất");
		modelSach.addColumn("Khuyến mãi");
		modelSach.addColumn("Mô tả");
		modelSach.addColumn("Tình trạng");
		tblSach = new JTable(modelSach);
		tblSach.setBackground(new Color(153, 204, 255));
		JScrollPane jScrollPane = new JScrollPane(tblSach);
		jScrollPane.setBounds(15, 20, 1869, 380);
		JTableHeader tbHeaderKH = tblSach.getTableHeader();
		tbHeaderKH.setFont(font2);
		tbHeaderKH.setBackground(new Color(51, 204, 204));
		pnlBangSach.setLayout(null);
		tblSach.setFont(font2);
		tblSach.setRowHeight(35);
		pnlBangSach.add(jScrollPane);
		
		txtTrangThai = new JTextField("Không có hoạt động nào gần nhất");
		txtTrangThai.setForeground(Color.red);
		txtTrangThai.setHorizontalAlignment(SwingConstants.CENTER);
		txtTrangThai.setBounds(0, 915, 1894, 20);
		pnlSach.add(txtTrangThai);
		txtTrangThai.setColumns(10);
		
		JPanel pnlChucNang = new JPanel();
		pnlChucNang.setBackground(new Color(255, 255, 255));
		pnlChucNang.setBounds(1637, 0, 250, 380);
		pnlSach.add(pnlChucNang);
		pnlChucNang.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ :"));
		pnlChucNang.setLayout(null);
		
		btnDatLai = new JButton("Đặt lại");
		btnDatLai.setBounds(50, 305, 150, 48);
		pnlChucNang.add(btnDatLai);
		btnDatLai.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnDatLai.setIcon(new ImageIcon(GuiQuanLyNhanVien.class.getResource("/image/TacVu_DatLai.png")));
		btnDatLai.setBackground(Color.WHITE);
		
		btnXoa = new JButton("Xóa");
		btnXoa.setBounds(50, 165, 150, 50);
		pnlChucNang.add(btnXoa);
		btnXoa.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnXoa.setIcon(new ImageIcon(GuiQuanLyNhanVien.class.getResource("/image/TacVu_Xoa1.png")));
		btnXoa.setBackground(Color.WHITE);
		
		btnThem = new JButton("Thêm");
		btnThem.setBounds(50, 25, 150, 50);
		pnlChucNang.add(btnThem);
		btnThem.setFont(font2);
		btnThem.setIcon(new ImageIcon(GuiQuanLyNhanVien.class.getResource("/image/TacVu_Them1.png")));
		btnThem.setBackground(Color.WHITE);
		
		btnSua = new JButton("Sửa");
		btnSua.setBounds(50, 95, 150, 50);
		pnlChucNang.add(btnSua);
		btnSua.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnSua.setIcon(new ImageIcon(GuiQuanLyNhanVien.class.getResource("/image/TacVu_Sua.png")));
		btnSua.setBackground(Color.WHITE);
		
		btnLuu = new JButton("Lưu");
		btnLuu.setBounds(50, 235, 150, 50);
		pnlChucNang.add(btnLuu);
		btnLuu.setEnabled(false);
		btnLuu.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnLuu.setIcon(new ImageIcon(GuiQuanLyNhanVien.class.getResource("/image/TacVu_Luu.png")));
		btnLuu.setBackground(Color.WHITE);

		//Tab quản lý văn phòng phẩm
		JPanel pnlVanPhongPham = new JPanel();
		pnlVanPhongPham.setBackground(new Color(0, 204, 204));
		pnlVanPhongPham.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tabbedPane.addTab("Văn phòng phẩm", null, pnlVanPhongPham, null);
		tabbedPane.setBackgroundAt(0, new Color(255, 255, 255));
		pnlVanPhongPham.setLayout(null);
		pnlThongTinVPP = new JPanel();
		pnlThongTinVPP.setBackground(new Color(255, 255, 255));
		
		pnlThongTinVPP.setBorder(BorderFactory.createTitledBorder("Thông tin văn phòng phẩm"));
		pnlThongTinVPP.setBounds(0, 0, 1627, 380);
		pnlVanPhongPham.add(pnlThongTinVPP);
		pnlThongTinVPP.setLayout(null);
		
		JLabel lblMaVPP = new JLabel("Mã văn phòng phẩm :");
		lblMaVPP.setBounds(100, 20, 226, 30);
		pnlThongTinVPP.add(lblMaVPP);
		lblMaVPP.setFont(font2);
		
		JLabel lblMaMau = new JLabel("Mã màu :");
		lblMaMau.setBounds(425, 20, 187, 29);
		lblMaMau.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		pnlThongTinVPP.add(lblMaMau);
		
		JLabel lblNgayNhapVPP = new JLabel("Ngày nhập :");
		lblNgayNhapVPP.setBounds(750, 20, 163, 29);
		lblNgayNhapVPP.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		pnlThongTinVPP.add(lblNgayNhapVPP);
		
		JLabel lblTenVPP = new JLabel("Tên văn phòng phẩm :");
		lblTenVPP.setBounds(100, 110, 226, 30);
		lblTenVPP.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		pnlThongTinVPP.add(lblTenVPP);
		
		JLabel lblXuatXu = new JLabel("Xuất Xứ :");
		lblXuatXu.setBounds(100, 290, 163, 30);
		lblXuatXu.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		pnlThongTinVPP.add(lblXuatXu);
		
		JLabel lblNhaSanXuatVPP = new JLabel("Nhà sản xuất :");
		lblNhaSanXuatVPP.setBounds(750, 111, 163, 29);
		lblNhaSanXuatVPP.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		pnlThongTinVPP.add(lblNhaSanXuatVPP);
		
		JLabel lblThuongHieu = new JLabel("Thương hiệu :");
		lblThuongHieu.setBounds(100, 200, 195, 30);
		lblThuongHieu.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		pnlThongTinVPP.add(lblThuongHieu);
		
		txtMaVPP = new JTextField();
		txtMaVPP.setBounds(100, 55, 250, 35);
		txtMaVPP.setEditable(false);
		pnlThongTinVPP.add(txtMaVPP);
		txtMaVPP.setColumns(10);
		
		dtmNgayNhapVPP = new JDateChooser();
		dtmNgayNhapVPP.setBounds(750, 55, 250, 35);
		pnlThongTinVPP.add(dtmNgayNhapVPP);
		
		txtThuongHieu = new JTextField();
		txtThuongHieu.setBounds(100, 235, 250, 35);
		txtThuongHieu.setColumns(10);
		pnlThongTinVPP.add(txtThuongHieu);
		
		txtTenVPP = new JTextField();
		txtTenVPP.setBounds(100, 145, 250, 35);
		txtTenVPP.setColumns(10);
		pnlThongTinVPP.add(txtTenVPP);
		
		
		JPanel pnlAnhVPP = new JPanel();
		pnlAnhVPP.setBounds(1403, 11, 214, 258);
		pnlAnhVPP.setBackground(new Color(255, 255, 255));
		pnlAnhVPP.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlAnhVPP.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Ảnh sản phẩm", TitledBorder.CENTER, TitledBorder.TOP, font2, new Color(0, 0, 0)));
		pnlThongTinVPP.add(pnlAnhVPP);
		pnlAnhVPP.setLayout(null);
		
		lblShowAnhVPP = new JLabel("");
		lblShowAnhVPP.setBounds(10, 27, 194, 220);
		pnlAnhVPP.add(lblShowAnhVPP);
		
		btnChonAnhVPP = new JButton("");
		btnChonAnhVPP.setBounds(68, 99, 70, 70);
		pnlAnhVPP.add(btnChonAnhVPP);
		btnChonAnhVPP.setBackground(new Color(255, 255, 255));
		btnChonAnhVPP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnChonAnhVPP.setIcon(new ImageIcon(GuiQuanLyNhanVien.class.getResource("/image/ChonAnh.png")));
		
		JLabel lblSoLuongVPP = new JLabel("Số lượng :");
		lblSoLuongVPP.setBounds(425, 201, 136, 29);
		lblSoLuongVPP.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		pnlThongTinVPP.add(lblSoLuongVPP);
		
		JLabel lblKhuyenMaiVPP = new JLabel("Khuyến mãi :");
		lblKhuyenMaiVPP.setBounds(750, 201, 147, 29);
		lblKhuyenMaiVPP.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		pnlThongTinVPP.add(lblKhuyenMaiVPP);
		
		JLabel lblGiaGocVPP = new JLabel("Giá gốc :");
		lblGiaGocVPP.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblGiaGocVPP.setBounds(425, 110, 163, 30);
		pnlThongTinVPP.add(lblGiaGocVPP);
		
		txtGiaGocVPP = new JTextField();
		txtGiaGocVPP.setColumns(10);
		txtGiaGocVPP.setBounds(425, 145, 250, 35);
		pnlThongTinVPP.add(txtGiaGocVPP);
		
		txtSoLuongVPP = new JTextField();
		txtSoLuongVPP.setColumns(10);
		txtSoLuongVPP.setBounds(425, 235, 250, 35);
		pnlThongTinVPP.add(txtSoLuongVPP);
		
		JLabel lblTinhTrangVPP = new JLabel("Tình trạng :");
		lblTinhTrangVPP.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblTinhTrangVPP.setBounds(425, 290, 136, 29);
		pnlThongTinVPP.add(lblTinhTrangVPP);
		
		txtKhuyenMaiVPP = new JTextField();
		txtKhuyenMaiVPP.setColumns(10);
		txtKhuyenMaiVPP.setBounds(750, 235, 250, 35);
		pnlThongTinVPP.add(txtKhuyenMaiVPP);
		
		JLabel lblMoTaVPP = new JLabel("Mô tả :");
		lblMoTaVPP.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblMoTaVPP.setBounds(750, 290, 136, 29);
		pnlThongTinVPP.add(lblMoTaVPP);
		
		txtMoTaVPP = new JTextField();
		txtMoTaVPP.setColumns(10);
		txtMoTaVPP.setBounds(750, 325, 250, 35);
		pnlThongTinVPP.add(txtMoTaVPP);
		
		cboTinhTrangVPP = new JComboBox(tt);
		cboTinhTrangVPP.setBounds(425, 325, 250, 35);
		pnlThongTinVPP.add(cboTinhTrangVPP);
		
		lblGiaBanVPP = new JLabel("Giá bán :");
		lblGiaBanVPP.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblGiaBanVPP.setBounds(1075, 17, 94, 36);
		pnlThongTinVPP.add(lblGiaBanVPP);
		
		txtGiaBanVPP = new JTextField();
		txtGiaBanVPP.setEditable(false);
		txtGiaBanVPP.setBounds(1075, 55, 250, 35);
		pnlThongTinVPP.add(txtGiaBanVPP);
		txtGiaBanVPP.setColumns(10);
		
		txtXuatXu = new JTextField();
		txtXuatXu.setColumns(10);
		txtXuatXu.setBounds(100, 325, 250, 35);
		pnlThongTinVPP.add(txtXuatXu);
		
		JLabel lblThueVPP = new JLabel("Thuế :");
		lblThueVPP.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblThueVPP.setBounds(1075, 110, 94, 36);
		pnlThongTinVPP.add(lblThueVPP);
		
		txtThueVPP = new JTextField();
		txtThueVPP.setEditable(false);
		txtThueVPP.setColumns(10);
		txtThueVPP.setBounds(1075, 145, 250, 35);
		pnlThongTinVPP.add(txtThueVPP);
		
		JButton btnNhapExcelVPP = new JButton("Nhập Excel");
		btnNhapExcelVPP.setBounds(1075, 325, 200, 35);
		pnlThongTinVPP.add(btnNhapExcelVPP);
		btnNhapExcelVPP.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnNhapExcelVPP.setBackground(new Color(255, 255, 255));
		btnNhapExcelVPP.hide();
		JButton btnXuatExcelVPP = new JButton("Xuất Excel");
		btnXuatExcelVPP.setBounds(1399, 325, 200, 35);
		pnlThongTinVPP.add(btnXuatExcelVPP);
		btnXuatExcelVPP.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnXuatExcelVPP.setBackground(new Color(255, 255, 255));
		btnXuatExcelVPP.hide();
		
		JLabel lblLoaiVPP = new JLabel("Loại văn phòng phẩm :");
		lblLoaiVPP.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblLoaiVPP.setBounds(1075, 194, 250, 36);
		pnlThongTinVPP.add(lblLoaiVPP);
		
		
		
		cboMaMau = new JComboBox();
		cboMaMau.setBounds(425, 55, 250, 35);
		pnlThongTinVPP.add(cboMaMau);
		
		cboNSX_VPP = new JComboBox();
		cboNSX_VPP.setBounds(750, 145, 250, 35);
		pnlThongTinVPP.add(cboNSX_VPP);
		
		cboLoai_VPP = new JComboBox();
		cboLoai_VPP.setBounds(1075, 235, 250, 35);
		pnlThongTinVPP.add(cboLoai_VPP);
		
		txtLoai_VPP = new JTextField();
		txtLoai_VPP.setVisible(false);
		txtLoai_VPP.setColumns(10);
		txtLoai_VPP.setBounds(1075, 235, 250, 35);
		pnlThongTinVPP.add(txtLoai_VPP);
		
		
		JPanel pnlTacVuCon2 = new JPanel();
		pnlTacVuCon2.setBackground(Color.white);;
		pnlVanPhongPham.add(pnlTacVuCon2);
		pnlTacVuCon2.setBounds(0, 390, 1890, 80);
		pnlTacVuCon2.setBorder(BorderFactory.createTitledBorder("Tìm kiếm theo : "));
		
		pnlTacVuCon2.setLayout(null);
		
		txtTimTenVPP = new JTextField("Nhập thông tin cần tìm");
		txtTimTenVPP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTimTenVPP.setBounds(220, 26, 200, 35);
		pnlTacVuCon2.add(txtTimTenVPP);
		txtTimTenVPP.setColumns(10);
		
		JLabel lblTimTenVPP = new JLabel("Tên VPP :");
		lblTimTenVPP.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblTimTenVPP.setBounds(100, 24, 120, 35);
		pnlTacVuCon2.add(lblTimTenVPP);
		
		JLabel lblTimMaVPP = new JLabel("Mã VPP :");
		lblTimMaVPP.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblTimMaVPP.setBounds(520, 24, 120, 35);
		pnlTacVuCon2.add(lblTimMaVPP);
		
		txtTimMaVPP = new JTextField("Nhập thông tin cần tìm");
		txtTimMaVPP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTimMaVPP.setColumns(10);
		txtTimMaVPP.setBounds(640, 24, 200, 35);
		pnlTacVuCon2.add(txtTimMaVPP);
		
		JLabel lblTimTinhTrangVPP = new JLabel("Tình trạng :");
		lblTimTinhTrangVPP.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblTimTinhTrangVPP.setBounds(940, 24, 120, 35);
		pnlTacVuCon2.add(lblTimTinhTrangVPP);
		
		cboTimTinhTrangVPP = new JComboBox();
		cboTimTinhTrangVPP.setBounds(1060, 26, 200, 35);
		pnlTacVuCon2.add(cboTimTinhTrangVPP);
		
		txtTimTenVPP.addFocusListener(new FocusListener() {
			@Override
            public void focusGained(FocusEvent e) {
                if (txtTimTenVPP.getText().equals("Nhập thông tin cần tìm")) {
                    txtTimTenVPP.setText("");
                    txtTimTenVPP.setForeground(Color.BLACK); // Đổi màu chữ khi có focus
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtTimTenVPP.getText().isEmpty()) {
                    txtTimTenVPP.setText("Nhập thông tin cần tìm");
                    txtTimTenVPP.setForeground(Color.GRAY); // Đổi màu chữ gợi ý khi mất focus
                }
            }
        });
		txtTimMaVPP.addFocusListener(new FocusListener() {
			@Override
            public void focusGained(FocusEvent e) {
                if (txtTimMaVPP.getText().equals("Nhập thông tin cần tìm")) {
                	txtTimMaVPP.setText("");
                	txtTimMaVPP.setForeground(Color.BLACK); // Đổi màu chữ khi có focus
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtTimMaVPP.getText().isEmpty()) {
                	txtTimMaVPP.setText("Nhập thông tin cần tìm");
                	txtTimMaVPP.setForeground(Color.GRAY); // Đổi màu chữ gợi ý khi mất focus
                }
            }
        });
		
		
		JPanel pnlBangVPP = new JPanel();
		pnlBangVPP.setBounds(0, 480, 1890, 415);
		pnlVanPhongPham.add(pnlBangVPP);
		pnlBangVPP.setBorder(BorderFactory.createTitledBorder("Bảng thông tin văn phòng phẩm"));
		pnlBangVPP.setLayout(null);
		
		

		pnlBangVPP.setBackground(Color.white);;
		modelVPP = new DefaultTableModel();
		modelVPP = new DefaultTableModel();
		modelVPP.addColumn("Mã VPP");
		modelVPP.addColumn("Tên VPP");
		modelVPP.addColumn("Mã màu");
		modelVPP.addColumn("Ngày nhập");
		modelVPP.addColumn("Loại VPP");
		modelVPP.addColumn("Giá nhập");
		modelVPP.addColumn("Số lượng");
		modelVPP.addColumn("Thuế");
		modelVPP.addColumn("Giá bán");
		modelVPP.addColumn("Xuất Xứ");
		modelVPP.addColumn("Thương hiệu");
		modelVPP.addColumn("Nhà sản xuất");
		modelVPP.addColumn("Khuyến mãi");
		modelVPP.addColumn("Mô tả");
		modelVPP.addColumn("Tình trạng");
		tblVPP = new JTable(modelVPP);
		tblVPP.setBackground(new Color(153, 204, 255));
		JScrollPane jScrollPane1 = new JScrollPane(tblVPP);
		jScrollPane1.setBounds(10, 24, 1869, 380);
		JTableHeader tbHeaderVPP = tblVPP.getTableHeader();
		tbHeaderVPP.setFont(font2);
		tbHeaderVPP.setBackground(new Color(51, 204, 204));
		pnlBangVPP.setLayout(null);
		tblVPP.setFont(font2);
		tblVPP.setRowHeight(35);
		pnlBangVPP.add(jScrollPane1);
		
		txtTrangThai = new JTextField("Không có hoạt động nào gần nhất");
		txtTrangThai.setForeground(Color.red);
		txtTrangThai.setHorizontalAlignment(SwingConstants.CENTER);
		txtTrangThai.setBounds(0, 915, 1894, 20);
		pnlVanPhongPham.add(txtTrangThai);
		txtTrangThai.setColumns(10);
		
		JPanel pnlChucNang1 = new JPanel();
		pnlChucNang1.setBackground(new Color(255, 255, 255));
		pnlChucNang1.setBounds(1637, 0, 250, 380);
		pnlVanPhongPham.add(pnlChucNang1);
		pnlChucNang1.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ :"));
		pnlChucNang1.setLayout(null);
		
		btnDatLai1 = new JButton("Đặt lại");
		btnDatLai1.setBounds(50, 305, 150, 48);
		pnlChucNang1.add(btnDatLai1);
		btnDatLai1.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnDatLai1.setIcon(new ImageIcon(GuiQuanLyNhanVien.class.getResource("/image/TacVu_DatLai.png")));
		btnDatLai1.setBackground(Color.WHITE);
		
		btnXoa1 = new JButton("Xóa");
		btnXoa1.setBounds(50, 165, 150, 50);
		pnlChucNang1.add(btnXoa1);
		btnXoa1.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnXoa1.setIcon(new ImageIcon(GuiQuanLyNhanVien.class.getResource("/image/TacVu_Xoa1.png")));
		btnXoa1.setBackground(Color.WHITE);
		
		btnThem1 = new JButton("Thêm");
		btnThem1.setBounds(50, 25, 150, 50);
		pnlChucNang1.add(btnThem1);
		btnThem1.setFont(font2);
		btnThem1.setIcon(new ImageIcon(GuiQuanLyNhanVien.class.getResource("/image/TacVu_Them1.png")));
		btnThem1.setBackground(Color.WHITE);
		
		btnSua1 = new JButton("Sửa");
		btnSua1.setBounds(50, 95, 150, 50);
		pnlChucNang1.add(btnSua1);
		btnSua1.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnSua1.setIcon(new ImageIcon(GuiQuanLyNhanVien.class.getResource("/image/TacVu_Sua.png")));
		btnSua1.setBackground(Color.WHITE);
		
		btnLuu1 = new JButton("Lưu");
		btnLuu1.setBounds(50, 235, 150, 50);
		pnlChucNang1.add(btnLuu1);
		btnLuu1.setEnabled(false);
		btnLuu1.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnLuu1.setIcon(new ImageIcon(GuiQuanLyNhanVien.class.getResource("/image/TacVu_Luu.png")));
		btnLuu1.setBackground(Color.WHITE);
		
		
		btnChonAnh.addActionListener(this);
		btnChonAnhVPP.addActionListener(this);
		btnThem.addActionListener(this); 
		btnThem1.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXoa1.addActionListener(this);
		btnDatLai.addActionListener(this);
		btnDatLai1.addActionListener(this);
		
		tblSach.addMouseListener(this);
		tblVPP.addMouseListener(this);
	
		//

		try {
			ConnectDB.getInstance().connect();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		//
		vpp_dao = new DAO_QuanLyVPP();
		sach_dao = new DAO_QuanLySach();
		loaiSach_dao = new DAO_QuanLyLoaiSach();
		loaiVPP_dao = new DAO_QuanLyLoaiVPP();
		hinhanh_dao = new DAO_HinhAnh();
		mausac_dao = new DAO_MauSac();
		NSX_dao = new DAO_NSX();
	
		//
		ArrayList<NhaSanXuat> listNSX = NSX_dao.getAllNSX();
		for(NhaSanXuat nsx : listNSX) {
			cboNSX.addItem(nsx.getMaNSX());
			cboNSX_VPP.addItem(nsx.getMaNSX());
		}
		
		ArrayList<LoaiSach> listLS = loaiSach_dao.getALLLoaiSach();
		for(LoaiSach ls : listLS) {
			cboLoaiSach.addItem(ls.getMaLoaiSach());
		}
		cboLoaiSach.setSelectedItem(null);
		
		
		ArrayList<LoaiVanPhongPham> listVPP = loaiVPP_dao.getALLLoaiVPP();
		for(LoaiVanPhongPham ls : listVPP) {
			cboLoai_VPP.addItem(ls.getMaLoaiVPP());
		}
		cboLoai_VPP.setSelectedItem(null);
		
		ArrayList<MauSac> listMS = mausac_dao.getAllMauSac();
		for(MauSac ms : listMS) {
			cboMaMau.addItem(ms.getMaMau());
		}

			cboLoaiSach.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                txtMaSach.setText(generateAndSetMaAnhSach());              
	            }
	        });
		
		
		
	
		
		cboLoai_VPP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtMaVPP.setText(generateAndSetMaAnhVPP());              
            }
        });
		
			
		
		DocDuLieuDatabaseSACH();
		DocDuLieuDatabaseVPP();
		
		txtThue.setText("0.8");
		txtThueVPP.setText("0.8");
		
		// Sách
		txtGiaGoc.getDocument().addDocumentListener((DocumentListener) new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                updateGiaBan();
            }

            public void removeUpdate(DocumentEvent e) {
                updateGiaBan();
            }

            public void changedUpdate(DocumentEvent e) {
                updateGiaBan();
            }

            // Hàm cập nhật giá bán dựa trên giá gốc
            private void updateGiaBan() {
                try {
                    // Lấy giá trị từ ô giá gốc
                    double giaGoc = Double.parseDouble(txtGiaGoc.getText());
                    double tS = Double.parseDouble(txtThueVPP.getText());

                    // Cập nhật giá bán (Ví dụ: giả sử giá bán là một phần của giá gốc)
                    double giaBan = giaGoc * tS;
                    txtGiaBan.setText(String.valueOf(giaBan));
                    
                } catch (NumberFormatException ex) {
                    // Xử lý ngoại lệ nếu giá trị nhập không phải là số
                    txtGiaBan.setText("");
                }
            }
        });
		
		txtGiaGocVPP.getDocument().addDocumentListener((DocumentListener) new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                updateGiaBan();
            }

            public void removeUpdate(DocumentEvent e) {
                updateGiaBan();
            }

            public void changedUpdate(DocumentEvent e) {
                updateGiaBan();
            }

            // Hàm cập nhật giá bán dựa trên giá gốc
            private void updateGiaBan() {
                try {
                    // Lấy giá trị từ ô giá gốc
                    double giaGoc = Double.parseDouble(txtGiaGocVPP.getText());
                    double tS = Double.parseDouble(txtThueVPP.getText());

                    // Cập nhật giá bán (Ví dụ: giả sử giá bán là một phần của giá gốc)
                    double giaBan = giaGoc * tS;
                    txtGiaBanVPP.setText(String.valueOf(giaBan));
                    
                } catch (NumberFormatException ex) {
                    // Xử lý ngoại lệ nếu giá trị nhập không phải là số
                    txtGiaBanVPP.setText("");
                }
            }
        });
		
		txtSoLuong.getDocument().addDocumentListener((DocumentListener) new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                updateGiaBan();
            }

            public void removeUpdate(DocumentEvent e) {
                updateGiaBan();
            }

            public void changedUpdate(DocumentEvent e) {
                updateGiaBan();
            }

            // Hàm cập nhật giá bán dựa trên giá gốc
            private void updateGiaBan() {
                try {
                    // Lấy giá trị từ ô giá gốc
                    double SL = Double.parseDouble(txtSoLuong.getText());
                    
                    if (SL > 0) {
						cboTinhTrang.setSelectedItem("Còn hàng");
					}else {
						cboTinhTrang.setSelectedItem("Hết hàng");
					}
                    
                } catch (NumberFormatException ex) {
                    // Xử lý ngoại lệ nếu giá trị nhập không phải là số
                	cboTinhTrang.setSelectedItem(null);
                }
            }
        });
		
		
		txtSoLuongVPP.getDocument().addDocumentListener((DocumentListener) new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                updateGiaBan();
            }

            public void removeUpdate(DocumentEvent e) {
                updateGiaBan();
            }

            public void changedUpdate(DocumentEvent e) {
                updateGiaBan();
            }

            // Hàm cập nhật giá bán dựa trên giá gốc
            private void updateGiaBan() {
                try {
                    // Lấy giá trị từ ô giá gốc
                    double SL = Double.parseDouble(txtSoLuongVPP.getText());
                    
                    if (SL > 0) {
						cboTinhTrangVPP.setSelectedItem("Còn hàng");
					}else {
						cboTinhTrangVPP.setSelectedItem("Hết hàng");
					}
                    
                } catch (NumberFormatException ex) {
                    // Xử lý ngoại lệ nếu giá trị nhập không phải là số
                	cboTinhTrangVPP.setSelectedItem(null);
                }
            }
        });	
		
		
		txtTimTenSach.addKeyListener((KeyListener) new KeyAdapter() {
		    @Override
		    public void keyReleased(KeyEvent e) {
		        String tuKhoa = txtTimTenSach.getText().trim();
		        timKiemSach(tuKhoa);
		    } 
		}); 
		
		txtTimTacGia.addKeyListener((KeyListener) new KeyAdapter() {
		    @Override
		    public void keyReleased(KeyEvent e) {
		        String tuKhoa = txtTimTacGia.getText().trim();
		        timKiemSachTheoTacGia(tuKhoa);
		    }
		}); 
		
		txtTimMaVPP.addKeyListener((KeyListener) new KeyAdapter() {
		    @Override
		    public void keyReleased(KeyEvent e) {
		        String tuKhoa = txtTimMaVPP.getText().trim();
		        timKiemMaVPP(tuKhoa);
		    }
		}); 
		
		txtTimTenVPP.addKeyListener((KeyListener) new KeyAdapter() {
		    @Override
		    public void keyReleased(KeyEvent e) {
		        String tuKhoa = txtTimTenVPP.getText().trim();
		        timKiemTenVPP(tuKhoa);
		    }
		}); 


	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnChonAnh)) {
			chonAnhSach();
		}
		if (o.equals(btnThem)) {
			themSach();
		}
		if (o.equals(btnXoa)) {
			xoa();
		}
		if (o.equals(btnDatLai)) {
			xoaRong();
		}
		
		//
		
		if (o.equals(btnChonAnhVPP)) {
			chonAnhVPP();
		}
		if (o.equals(btnThem1)) {
			themVPP();
		}
		if (o.equals(btnXoa1)) {
			xoaVPP();
		}
		if (o.equals(btnDatLai1)) {
			xoaRongVPP();
		}
		
	}
	
	
	
	public void DocDuLieuDatabaseSACH() {
		sach_dao = new DAO_QuanLySach();
		//tblCV.setRowHeight(25);
		for(Sach s : sach_dao.getALLSach()) {
			modelSach.addRow(new Object[] {s.getMaSanPham(), s.getTenSanPham(), s.getTacGia(), s.getNgayNhap(), s.getLoaiSach().getMaLoaiSach(),
					s.getGiaGoc(), s.getSoLuong(), s.getThue(), s.getGiaBan(), s.getLoaiBia(), s.getSotrang(),
					s.getNhaSanXuat().getMaNSX(), s.getKhuyenMai(), s.getMoTa(), s.isTrangThai()});
		}
	}
	
	public void DocDuLieuDatabaseVPP() {
		vpp_dao = new DAO_QuanLyVPP();
		//tblCV.setRowHeight(25);
		for(VanPhongPham vpp : vpp_dao.getALLVPP()) {
			modelVPP.addRow(new Object[] {vpp.getMaSanPham(), vpp.getTenSanPham(), vpp.getMaMau().getMaMau(), vpp.getNgayNhap(), 
					vpp.getLoaiVanPhongPham(), vpp.getGiaGoc(), vpp.getSoLuong(), vpp.getThue(), vpp.getGiaBan(), vpp.getXuatXu(),
					vpp.getThuongHieu(),vpp.getNhaSanXuat().getMaNSX(), vpp.getKhuyenMai(), vpp.getMoTa(), vpp.isTrangThai()});
		}
	}
	
	public void xoaRong() {
		txtLoaiSach.setVisible(false);
		cboLoaiSach.setVisible(true);
		lblShowAnh.setIcon(null);
		btnChonAnh.setVisible(true);
		
		txtTenSach.setText("");
		txtSoTrang.setText("");
		txtSoLuong.setText("");
		txtGiaBan.setText("");
		txtGiaGoc.setText("");
		txtKhuyenMai.setText("");
		txtMaSach.setText("");
		txtTacGia.setText("");
		txtMoTa.setText("");
		dtmNgayNhapSach.setEnabled(true);
		dtmNgayNhapSach.setDate(null);
	}
	
	public void xoaRongVPP() {
		txtLoai_VPP.setVisible(false);
		cboLoai_VPP.setVisible(true);
		cboLoai_VPP.setEnabled(true);
		lblShowAnhVPP.setIcon(null);
		btnChonAnhVPP.setVisible(true);
		
		txtTenVPP.setText("");
		txtXuatXu.setText("");
		txtSoLuongVPP.setText("");
		txtGiaBanVPP.setText("");
		txtGiaGocVPP.setText("");
		txtKhuyenMaiVPP.setText("");
		txtMaVPP.setText("");
		txtThuongHieu.setText("");
		txtMoTaVPP.setText("");
		dtmNgayNhapVPP.setEnabled(true);
		dtmNgayNhapVPP.setDate(null);
	}
	
	private void timKiemSach(String tuKhoa) {
	    TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelSach);
	    tblSach.setRowSorter(sorter);

	    if (tuKhoa.isEmpty()) {
	        sorter.setRowFilter(null);
	    } else {
	    	 RowFilter<DefaultTableModel, Object> filter = RowFilter.regexFilter("(?i)" + Pattern.quote(tuKhoa), 1);
		        
		        sorter.setRowFilter(filter);
	    }
	}
	
	private void timKiemSachTheoTacGia(String tuKhoa) {
	    TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelSach);
	    tblSach.setRowSorter(sorter);

	    if (tuKhoa.isEmpty()) {
	        sorter.setRowFilter(null);
	    } else {
	    	 RowFilter<DefaultTableModel, Object> filter = RowFilter.regexFilter("(?i)" + Pattern.quote(tuKhoa), 2);
		        
		        sorter.setRowFilter(filter);
	    }
	}
	
	
	private void timKiemMaVPP(String tuKhoa) {
	    TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelVPP);
	    tblVPP.setRowSorter(sorter);

	    if (tuKhoa.isEmpty()) {
	        sorter.setRowFilter(null);
	    } else {
	    	 RowFilter<DefaultTableModel, Object> filter = RowFilter.regexFilter("(?i)" + Pattern.quote(tuKhoa), 0);
		        
		        sorter.setRowFilter(filter);
	    }
	}
	
	private void timKiemTenVPP(String tuKhoa) {
	    TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelVPP);
	    tblVPP.setRowSorter(sorter);

	    if (tuKhoa.isEmpty()) {
	        sorter.setRowFilter(null);
	    } else {
	    	 RowFilter<DefaultTableModel, Object> filter = RowFilter.regexFilter("(?i)" + Pattern.quote(tuKhoa), 1);
		        
		        sorter.setRowFilter(filter);
	    }
	}
	
	// Chọn ảnh sách
	public void chonAnhSach() {
		//JFileChooser fileChooser = new JFileChooser();  mở thisPC
		
		// Đặt thư mục ban đầu thành D:\\HK5\\PTUD...
		File initialDirectory = new File("D:\\HK5\\PTUD\\CodeQLCH_FutureZE\\QuanLyNhaSach\\src\\image");
	    JFileChooser fileChooser = new JFileChooser(initialDirectory);
		
		//Hiển thị hộp thoại chọn tập tin
        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            selectedImagePath = selectedFile.getAbsolutePath();

            ImageIcon icon = new ImageIcon(selectedImagePath);
            Image img = icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            lblShowAnh.setIcon(new ImageIcon(img));
            lblShowAnh.setIcon(new ImageIcon(img));
			btnChonAnh.setVisible(false); 			
		}		
	}
	
	private String generateAndSetMaAnhSach() {
		String newMaAnh = "SAH0000001";  	 
       	try {        		
       		String maLoaiSach = cboLoaiSach.getSelectedItem().toString();  		
       		String maLS = maLoaiSach.substring(2).trim();
            String loaiMa = "SAH";
            int num = hinhanh_dao.MaSach_VPP(loaiMa);
            num++;        
            String numString = String.format("%04d", num).trim();
            newMaAnh = loaiMa + maLS + numString;

           } catch (Exception e) {
               e.printStackTrace();
           }
		
       return newMaAnh;
   }
	
	private void saveImageToDatabaseSach() {
	      String maAnh = generateAndSetMaAnhSach();
	      String imagePath = lblShowAnh.getIcon() != null ? lblShowAnh.getIcon().toString() : "";
	      
	      // lấy tên ảnh trong pc lưu vào tên ảnh trong csdl
	      File selectedFile = new File(selectedImagePath);
          String tenAnh = selectedFile.getName();

	      if (maAnh.isEmpty() || tenAnh.isEmpty() || imagePath.isEmpty()) {
	          JOptionPane.showMessageDialog(this, "Please fill in all fields and choose an image.", 
	          		                              "Error", JOptionPane.ERROR_MESSAGE);
	          return;
	      }

	      imagePath = selectedImagePath;
	      HinhAnh hinhAnh = new HinhAnh(maAnh, tenAnh, imagePath);
	      hinhanh_dao.themHinhAnh(hinhAnh);
	      JOptionPane.showMessageDialog(this, "Lưu ảnh vào database thành công!");	         
	   }
	
	private void xoaAnhDaLuu() {
	    try {
	        // Lấy mã sách vừa thêm
	        String maSach = txtMaSach.getText();

	        // Lấy mã ảnh từ mã sách
	        String maAnh = sach_dao.getMaAnhByMaSach(maSach);

	        // Kiểm tra nếu mã ảnh không rỗng thì thực hiện xóa
	        if (!maAnh.isEmpty()) {
	            // Lấy thông tin ảnh từ cơ sở dữ liệu
	            HinhAnh hinhAnh = hinhanh_dao.getHinhAnhByMaAnh(maAnh);

	            // Xóa ảnh từ cơ sở dữ liệu
	            hinhanh_dao.xoaIMG(maAnh);

	            // Xóa file ảnh từ đường dẫn trên ổ đĩa
	            if (hinhAnh != null) {
	                String url = hinhAnh.getUrl();
	                File file = new File(url);
	                if (file.exists()) {
	                    file.delete();
	                }
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(this, "Error deleting image: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}
	
	public void themSach() {
	    try {
	        // Get values from the input fields
	        String maS = txtMaSach.getText();
	        String tenS = txtTenSach.getText();
	        String tacGia = txtTacGia.getText();
	        String loaiBia = cboLoaiBia.getSelectedItem().toString();
	        int soTrang = Integer.parseInt(txtSoTrang.getText());
	        double giaGoc = Double.parseDouble(txtGiaGoc.getText());
	        int soLuong = Integer.parseInt(txtSoLuong.getText());
	        String tt = cboTinhTrang.getSelectedItem().toString();
	        boolean tinhTrang;
	        if (tt.equals("Còn hàng") && soLuong > 0) {
	            tinhTrang = true;
	        } else {
	            tinhTrang = false;
	        }

	        String maKM = txtKhuyenMai.getText();
	        String moTa = txtMoTa.getText();
	        String loaiSach = cboLoaiSach.getSelectedItem().toString();
	        String maNSX = cboNSX.getSelectedItem().toString();
	        double giaBan = Double.parseDouble(txtGiaBan.getText());
	        double thue = Double.parseDouble(txtThue.getText());   
	        
	        java.util.Date ngayNhap = dtmNgayNhapSach.getDate();     

	        // Validate required fields
	        if (maS.isEmpty() || tenS.isEmpty()) {
	            JOptionPane.showMessageDialog(this, "Please fill in all required fields.", "Error", JOptionPane.ERROR_MESSAGE);
	            return;
	        }  

	        // lưu ảnh vào csdl HINHANH
	        saveImageToDatabaseSach();

	        String maANh = txtMaSach.getText();
	        HinhAnh maIMG = new HinhAnh(maANh);
	        NhaSanXuat nsx = new  NhaSanXuat(maNSX);
	        
	        LoaiSach ls = new LoaiSach(loaiSach);

	        Sach s = new Sach(maS, tenS, giaGoc, maIMG, moTa, ngayNhap, tinhTrang, soLuong, thue, giaBan, nsx, maKM, soTrang, loaiBia, tacGia, ls);

	        if (sach_dao.addSach(s)) {
	            // Refresh the table with the updated data
	            modelSach.setRowCount(0); // Clear the current rows
	            DocDuLieuDatabaseSACH(); // Reload data from the database
	            JOptionPane.showMessageDialog(this, "Thêm sản phẩm thành công.");
	            //xoaRong();
	        } else {
	        	xoaAnhDaLuu();
	            JOptionPane.showMessageDialog(this, "Thêm sản phẩm không thành công.", "Error", JOptionPane.ERROR_MESSAGE);
	            
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}
	
	
	public void xoa() {
		int row = tblSach.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(this, "Hãy chọn nhân viên cần xoá");
		} else {
			int tl;
			tl = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa nhân viên này không ?", "Cảnh báo",
					JOptionPane.YES_OPTION);
			if (tl == JOptionPane.YES_OPTION) {
				
				//xoá ảnh trong csdl HINHANH
				String maSach = modelSach.getValueAt(row, 0).toString();
				String maAnh = sach_dao.getMaAnhByMaSach(maSach);
				HinhAnh hinhAnh = hinhanh_dao.getHinhAnhByMaAnh(maAnh);
				hinhanh_dao.xoaIMG(maAnh);
				
				//
				int index = tblSach.getSelectedRow();
				sach_dao.deleteSach(modelSach.getValueAt(tblSach.getSelectedRow(), 0).toString());
				modelSach.removeRow(index);
				xoaRong();
			}
		}
	}
	

	
	//VPP-------------------------------------------------------------------------------------------------------------------------
	
	public void chonAnhVPP() {
		//JFileChooser fileChooser = new JFileChooser();  mở thisPC
		
		// Đặt thư mục ban đầu thành D:\\HK5\\PTUD...
		File initialDirectory = new File("D:\\HK5\\PTUD\\CodeQLCH_FutureZE\\QuanLyNhaSach\\src\\image");
	    JFileChooser fileChooser = new JFileChooser(initialDirectory);

        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            selectedImagePath = selectedFile.getAbsolutePath();

            ImageIcon icon = new ImageIcon(selectedImagePath);
            Image img = icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            lblShowAnhVPP.setIcon(new ImageIcon(img));
            lblShowAnhVPP.setIcon(new ImageIcon(img));
			btnChonAnhVPP.setVisible(false); 			
		}		
	}
	
	private String generateAndSetMaAnhVPP() {
		String newMaAnh = "VPP0000001";  	 
       	try {        		
       		String maLoaiVPP = cboLoai_VPP.getSelectedItem().toString();    		
       		String maLS = maLoaiVPP.substring(2).trim();
            String loaiMa = "VPP";
            int num = hinhanh_dao.MaSach_VPP(loaiMa);
            num++;        
            String numString = String.format("%04d", num).trim();
            newMaAnh = loaiMa + maLS + numString;

           } catch (Exception e) {
               e.printStackTrace();
           }
		
       return newMaAnh;
   }
	
	private void saveImageToDatabaseVPP() {
	      String maAnh = generateAndSetMaAnhVPP();
	      String imagePath = lblShowAnhVPP.getIcon() != null ? lblShowAnhVPP.getIcon().toString() : "";
	      
	      // lấy tên ảnh trong pc lưu vào tên ảnh trong csdl
	      File selectedFile = new File(selectedImagePath);
          String tenAnh = selectedFile.getName();

	      if (maAnh.isEmpty() || tenAnh.isEmpty() || imagePath.isEmpty()) {
	          JOptionPane.showMessageDialog(this, "Please fill in all fields and choose an image.", 
	          		                              "Error", JOptionPane.ERROR_MESSAGE);
	          return;
	      }

	      imagePath = selectedImagePath;
	      HinhAnh hinhAnh = new HinhAnh(maAnh, tenAnh, imagePath);
	      hinhanh_dao.themHinhAnh(hinhAnh);
	      JOptionPane.showMessageDialog(this, "Lưu ảnh vào database thành công!");	         
	   }
	
	public void themVPP() {
	    try {
	        // Get values from the input fields
	        String maVPP = txtMaVPP.getText();
	        String tenVPP = txtTenVPP.getText();
	        String thuongHieu = txtThuongHieu.getText();
	        String mauSac = cboMaMau.getSelectedItem().toString();
	        
	        double giaGocVPP = Double.parseDouble(txtGiaGocVPP.getText());
	        int soLuongVPP = Integer.parseInt(txtSoLuongVPP.getText());
	        String ttVPP = cboTinhTrangVPP.getSelectedItem().toString();
	        boolean tinhTrangVPP;
	        if (ttVPP.equals("Còn hàng") && soLuongVPP > 0) {
	            tinhTrangVPP = true;
	        } else {
	            tinhTrangVPP = false;
	        }

	        String maKMvpp = txtKhuyenMaiVPP.getText();
	        String moTaVPP = txtMoTaVPP.getText();
	        String loaiVPP = cboLoai_VPP.getSelectedItem().toString();
	        String maNSXVPP = cboNSX_VPP.getSelectedItem().toString();
	        double giaBanVPP = Double.parseDouble(txtGiaBanVPP.getText());
	        double thueVPP = Double.parseDouble(txtThueVPP.getText());   
	        
	        java.util.Date ngayNhapVPP = dtmNgayNhapVPP.getDate();     

	        // Validate required fields
	        if (maVPP.isEmpty() || tenVPP.isEmpty()) {
	            JOptionPane.showMessageDialog(this, "Please fill in all required fields.", "Error", JOptionPane.ERROR_MESSAGE);
	            return;
	        }  

	        // lưu ảnh vào csdl HINHANH
	        saveImageToDatabaseVPP();

	        String maANhVPP = txtMaVPP.getText();
	        HinhAnh maIMGVPP = new HinhAnh(maANhVPP);
	        NhaSanXuat nsxVPP = new  NhaSanXuat(maNSXVPP);
	        
	        LoaiVanPhongPham lVPP = new LoaiVanPhongPham(loaiVPP);
	        MauSac ms = new MauSac(mauSac);
	        
	        VanPhongPham vpp = new VanPhongPham(maVPP, tenVPP, giaGocVPP, maIMGVPP, moTaVPP, ngayNhapVPP, tinhTrangVPP, soLuongVPP, thueVPP, giaBanVPP, nsxVPP , maKMvpp, thuongHieu, maANhVPP, ms, lVPP);
	        
	        if (vpp_dao.addVPP(vpp)) {
	            // Refresh the table with the updated data
	            modelVPP.setRowCount(0); // Clear the current rows
	            DocDuLieuDatabaseVPP(); // Reload data from the database
	            JOptionPane.showMessageDialog(this, "Thêm sản phẩm thành công.");
	            //xoaRong();
	        } else {
	            JOptionPane.showMessageDialog(this, "Thêm sản phẩm không thành công.", "Error", JOptionPane.ERROR_MESSAGE);
	            hinhanh_dao.xoaIMG(maANhVPP);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}
	
	public void xoaVPP() {
		int row = tblVPP.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(this, "Hãy chọn sản phẩm cần xoá");
		} else {
			int tl;
			tl = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa sản phẩm này không ?", "Cảnh báo",
					JOptionPane.YES_OPTION);
			if (tl == JOptionPane.YES_OPTION) {
				
				//xoá ảnh trong csdl HINHANH
				String maVPP = modelVPP.getValueAt(row, 0).toString();
				String maAnh = vpp_dao.getMaAnhByMa_VPP(maVPP);
				HinhAnh hinhAnh = hinhanh_dao.getHinhAnhByMaAnh(maAnh);
				hinhanh_dao.xoaIMG(maAnh);
				
				//
				int index = tblVPP.getSelectedRow();
				sach_dao.deleteSach(modelVPP.getValueAt(tblVPP.getSelectedRow(), 0).toString());
				modelVPP.removeRow(index);
				xoaRong();
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = tblSach.getSelectedRow();
	    if (row >= 0) {
	    	// sách------------------------------------------------------------------------------------------
	    	
	        // Lấy thông tin nhân viên
	        String maSach = modelSach.getValueAt(row, 0).toString();

	        // Lấy thông tin ảnh từ cơ sở dữ liệu dựa trên mã nhân viên
	        String maAnh = sach_dao.getMaAnhByMaSach(maSach); // Hàm này cần được thêm vào DAO_NhanVien

	        // Lấy thông tin ảnh từ cơ sở dữ liệu dựa trên mã ảnh
	        HinhAnh hinhAnh = hinhanh_dao.getHinhAnhByMaAnh(maAnh); // Hàm này cần được thêm vào DAO_NhanVien

	        // Hiển thị ảnh lên lblShowAnh
	        if (hinhAnh != null) {
	        	
	            ImageIcon icon = new ImageIcon(hinhAnh.getUrl());
	            Image img = icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
	            lblShowAnh.setIcon(new ImageIcon(img));
	        } else {
	            lblShowAnh.setIcon(null); // Nếu không tìm thấy ảnh, xóa ảnh trên lblShowAnh
	        }

	        // 
	        
	        txtMaSach.setText(maSach);
	        txtTenSach.setText(modelSach.getValueAt(row, 1).toString());
	        txtTacGia.setText(modelSach.getValueAt(row, 2).toString());
	        txtGiaBan.setText(modelSach.getValueAt(row, 8).toString());
	        txtGiaGoc.setText(modelSach.getValueAt(row, 5).toString());
	        txtKhuyenMai.setText(modelSach.getValueAt(row, 12).toString());
	        txtMoTa.setText(modelSach.getValueAt(row, 13).toString());
	        txtSoLuong.setText(modelSach.getValueAt(row, 6).toString());
	        txtSoTrang.setText(modelSach.getValueAt(row, 10).toString());
	        txtThue.setText(modelSach.getValueAt(row, 7).toString());
	        
	      
	        String ngayNhap = modelSach.getValueAt(row, 3).toString();
	        java.util.Date date;
            try {
                date = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(ngayNhap);
                dtmNgayNhapSach.setDate(date);

            } catch (java.text.ParseException ex) {
                ex.printStackTrace();
            }
	        

	        dtmNgayNhapSach.setEnabled(false);
	        btnChonAnh.setVisible(false);
	        txtLoaiSach.setVisible(true);
  
	        String maLS = sach_dao.getMaLoaiSachByMaSach(maSach);
	        String maNSX = sach_dao.getMaNSXByMaSach(maSach);
	        String tt = sach_dao.getTrangThaiByMaNV(maSach);

	        // Đưa giới tính vào combobox
	        //cboLoaiSach.setSelectedItem(maLS);
	        cboNSX.setSelectedItem(maNSX);
	        cboTinhTrang.setSelectedItem(tt);
	        cboLoaiSach.setVisible(false);
	        txtLoaiSach.setText(maLS);
	        
	    }  
	        //VPP --------------------------------------------------------------------------------------------
	        
	        int row1 = tblVPP.getSelectedRow();
		    if (row1 >= 0) {

		        String maVPP = modelVPP.getValueAt(row1, 0).toString();

		        // Lấy thông tin ảnh từ cơ sở dữ liệu dựa trên mã nhân viên
		        String maAnhVPP = vpp_dao.getMaAnhByMa_VPP(maVPP); // Hàm này cần được thêm vào DAO_NhanVien

		        // Lấy thông tin ảnh từ cơ sở dữ liệu dựa trên mã ảnh
		        HinhAnh hinhAnhVPP = hinhanh_dao.getHinhAnhByMaAnh(maAnhVPP); // Hàm này cần được thêm vào DAO_NhanVien

		        // Hiển thị ảnh lên lblShowAnh
		        if (hinhAnhVPP != null) {
		        	
		            ImageIcon icon1 = new ImageIcon(hinhAnhVPP.getUrl());
		            Image img1 = icon1.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		            lblShowAnhVPP.setIcon(new ImageIcon(img1));
		        } else {
		            lblShowAnhVPP.setIcon(null); // Nếu không tìm thấy ảnh, xóa ảnh trên lblShowAnh
		        }

		        // 
		        
		        txtMaVPP.setText(maVPP);
		        txtTenVPP.setText(modelVPP.getValueAt(row1, 1).toString());
		        txtThuongHieu.setText(modelVPP.getValueAt(row1, 10).toString());
		        txtGiaBanVPP.setText(modelVPP.getValueAt(row1, 8).toString());
		        txtGiaGocVPP.setText(modelVPP.getValueAt(row1, 5).toString());
		        txtKhuyenMaiVPP.setText(modelVPP.getValueAt(row1, 12).toString());
		        txtMoTaVPP.setText(modelVPP.getValueAt(row1, 13).toString());
		        txtSoLuongVPP.setText(modelVPP.getValueAt(row1, 6).toString());
		        txtXuatXu.setText(modelVPP.getValueAt(row1, 9).toString());
		        txtThueVPP.setText(modelVPP.getValueAt(row1, 7).toString());
		        
		      
		        String ngayNhapVPP = modelVPP.getValueAt(row1, 3).toString();
		        java.util.Date date1;
	            try {
	                date1 = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(ngayNhapVPP);
	                dtmNgayNhapVPP.setDate(date1);

	            } catch (java.text.ParseException ex) {
	                ex.printStackTrace();
	            }
		        

		        dtmNgayNhapVPP.setEnabled(false);
		        btnChonAnhVPP.setVisible(false);
	  
		        String maLVPP = vpp_dao.getMaLoaiVPPByMa_VPP(maVPP);
		        String maNSX_VPP = vpp_dao.getMaNSXByMa_VPP(maVPP);
		        String tt_VPP = vpp_dao.getTrangThaiByMa_VPP(maVPP);
		        String mamau = vpp_dao.getMaLoaiVPPByMaMauSac_VPP(maVPP);

		        // Đưa giới tính vào combobox
		        
		        cboLoai_VPP.setVisible(false);
		        cboMaMau.setSelectedItem(mamau);
		        cboNSX_VPP.setSelectedItem(maNSX_VPP);
		        cboTinhTrangVPP.setSelectedItem(tt_VPP);
		        txtLoai_VPP.setVisible(true);
		        txtLoai_VPP.setText(maLVPP);
		    }
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
