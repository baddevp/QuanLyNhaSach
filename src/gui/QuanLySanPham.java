package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.toedter.calendar.JDateChooser;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class QuanLySanPham extends JFrame {

	private JPanel contentPane;
	private JPanel pnlThongTinSach;
	private JTextField txtMaVPP;
	private JTextField txtMaMau;
	private JTextField dtmNgayNhapVPP;
	private JTextField txtThuongHieu;
	private JTextField txtTenSach;
	private JButton btnChonAnhVPP;
	private JTextField txtTimTenVPP;
	private JTextField txtTrangThai;
	private JTable tblKH;
	private DefaultTableModel modelKH;
	private JTextField txtGiaGocVPP;
	private JTextField txtSoLuongVPP;
	private JTextField txtNhaSanXuatVPP;
	private JTextField txtKhuyenMaiVPP;
	private JTextField txtMoTaVPP;
	private JLabel lblGiaBanVPP;
	private JTextField txtGiaBanVPP;
	private JTextField txtTimMaVPP;
	private JTextField txtXuatXu;
	private JTextField txtMaSach;
	private JTextField txtSoTrang;
	private JTextField txtCCCD;
	private JTextField txtTacGia;
	private JButton btnChonAnh;
	private JTextField txtGiaGoc;
	private JTextField txtSoLuong;
	private JTextField txtNhaSanXuat;
	private JTextField txtKhuyenMai;
	private JTextField txtMoTa;
	private JLabel lblGiaBan;
	private JTextField textField;
	private JTextField txtTimTenSach;
	private JTextField txtTimTacGia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLySanPham frame = new QuanLySanPham();
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
	public QuanLySanPham() {
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
		pnlTieuDe.setBounds(10, 10, 1894, 60);
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
		tabbedPane.setBounds(10, 81, 1894, 964);
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
		pnlThongTinSach.setBounds(0, 0, 1456, 380);
		pnlSach.add(pnlThongTinSach);
		pnlThongTinSach.setLayout(null);
		
		JLabel lblMaSach = new JLabel("Mã sách :");
		lblMaSach.setBounds(100, 20, 163, 30);
		pnlThongTinSach.add(lblMaSach);
		lblMaSach.setFont(font2);
		
		JLabel lblSoTrang = new JLabel("Số trang :");
		lblSoTrang.setBounds(450, 20, 187, 29);
		lblSoTrang.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		pnlThongTinSach.add(lblSoTrang);
		
		JLabel lblNgayNhap = new JLabel("Ngày nhập :");
		lblNgayNhap.setBounds(800, 20, 163, 29);
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
		lblNhaSanXuat.setBounds(800, 111, 163, 29);
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
		txtSoTrang.setBounds(450, 55, 250, 35);
		txtSoTrang.setColumns(10);
		pnlThongTinSach.add(txtSoTrang);
		
		txtCCCD = new JTextField();
		txtCCCD.setBounds(800, 55, 250, 35);
		txtCCCD.setColumns(10);
		pnlThongTinSach.add(txtCCCD);
		
		txtTacGia = new JTextField();
		txtTacGia.setBounds(100, 235, 250, 35);
		txtTacGia.setColumns(10);
		pnlThongTinSach.add(txtTacGia);
		
		txtTenSach = new JTextField();
		txtTenSach.setBounds(100, 145, 250, 35);
		txtTenSach.setColumns(10);
		pnlThongTinSach.add(txtTenSach);
		
		JPanel pnlAnhSach = new JPanel();
		pnlAnhSach.setBounds(1219, 21, 214, 258);
		pnlAnhSach.setBackground(new Color(255, 255, 255));
		pnlAnhSach.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlAnhSach.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Ảnh sản phẩm", TitledBorder.CENTER, TitledBorder.TOP, font2, new Color(0, 0, 0)));
		pnlThongTinSach.add(pnlAnhSach);
		pnlAnhSach.setLayout(null);
		
		JPanel pnlChuaAnh = new JPanel();
		pnlChuaAnh.setBackground(new Color(255, 255, 255));
		pnlChuaAnh.setBounds(10, 31, 194, 216);
		pnlAnhSach.add(pnlChuaAnh);
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
		
		JLabel lblSoLuong = new JLabel("Số lượng :");
		lblSoLuong.setBounds(450, 201, 136, 29);
		lblSoLuong.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		pnlThongTinSach.add(lblSoLuong);
		
		JLabel lblKhuyenMai = new JLabel("Khuyến mãi :");
		lblKhuyenMai.setBounds(800, 201, 147, 29);
		lblKhuyenMai.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		pnlThongTinSach.add(lblKhuyenMai);
		
		JLabel lblGiaGoc = new JLabel("Giá gốc :");
		lblGiaGoc.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblGiaGoc.setBounds(450, 110, 163, 30);
		pnlThongTinSach.add(lblGiaGoc);
		
		txtGiaGoc = new JTextField();
		txtGiaGoc.setColumns(10);
		txtGiaGoc.setBounds(450, 145, 250, 35);
		pnlThongTinSach.add(txtGiaGoc);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(450, 235, 250, 35);
		pnlThongTinSach.add(txtSoLuong);
		
		JLabel lblTinhTrang = new JLabel("Tình trạng :");
		lblTinhTrang.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblTinhTrang.setBounds(450, 290, 136, 29);
		pnlThongTinSach.add(lblTinhTrang);
		
		txtNhaSanXuat = new JTextField();
		txtNhaSanXuat.setColumns(10);
		txtNhaSanXuat.setBounds(800, 145, 250, 35);
		pnlThongTinSach.add(txtNhaSanXuat);
		
		txtKhuyenMai = new JTextField();
		txtKhuyenMai.setColumns(10);
		txtKhuyenMai.setBounds(800, 235, 250, 35);
		pnlThongTinSach.add(txtKhuyenMai);
		
		JLabel lblMoTa = new JLabel("Mô tả :");
		lblMoTa.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblMoTa.setBounds(800, 290, 136, 29);
		pnlThongTinSach.add(lblMoTa);
		
		txtMoTa = new JTextField();
		txtMoTa.setColumns(10);
		txtMoTa.setBounds(800, 325, 250, 35);
		pnlThongTinSach.add(txtMoTa);
		
		JComboBox cboLoaiBia = new JComboBox();
		cboLoaiBia.setBounds(100, 325, 250, 35);
		pnlThongTinSach.add(cboLoaiBia);
		
		JComboBox cboTinhTrang = new JComboBox();
		cboTinhTrang.setBounds(450, 325, 250, 35);
		pnlThongTinSach.add(cboTinhTrang);
		
		lblGiaBan = new JLabel("Giá bán :");
		lblGiaBan.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblGiaBan.setBounds(1150, 324, 94, 36);
		pnlThongTinSach.add(lblGiaBan);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(1270, 325, 163, 35);
		pnlThongTinSach.add(textField);
		textField.setColumns(10);
		
		
		
		
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
		
		JButton btnNhapExcel = new JButton("Nhập Excel");
		btnNhapExcel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnNhapExcel.setBackground(new Color(255, 255, 255));
		btnNhapExcel.setBounds(1360, 26, 200, 35);
		pnlTacVuCon.add(btnNhapExcel);
		
		JButton btnXuatExcel = new JButton("Xuất Excel");
		btnXuatExcel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnXuatExcel.setBackground(new Color(255, 255, 255));
		btnXuatExcel.setBounds(1660, 26, 200, 35);
		pnlTacVuCon.add(btnXuatExcel);
		
		JComboBox cboTimTinhTrangSach = new JComboBox();
		cboTimTinhTrangSach.setBounds(1060, 26, 200, 35);
		pnlTacVuCon.add(cboTimTinhTrangSach);
		
		txtTimTenSach.addFocusListener(new FocusListener() {
            private AbstractButton txtTimTenSach;

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
		
		
		JPanel pnlBangSach = new JPanel();
		pnlBangSach.setBounds(0, 480, 1890, 435);
		pnlSach.add(pnlBangSach);
		pnlBangSach.setBorder(BorderFactory.createTitledBorder("Bảng thông tin sách"));
		pnlBangSach.setLayout(null);
		
		

		pnlBangSach.setBackground(Color.white);;
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
		jScrollPane.setBounds(15, 20, 1869, 410);
		JTableHeader tbHeaderKH = tblKH.getTableHeader();
		tbHeaderKH.setFont(font2);
		tbHeaderKH.setBackground(new Color(51, 204, 204));
		pnlBangSach.setLayout(null);
		tblKH.setFont(font2);
		tblKH.setRowHeight(35);
		pnlBangSach.add(jScrollPane);
		
		txtTrangThai = new JTextField("Không có hoạt động nào gần nhất");
		txtTrangThai.setForeground(Color.red);
		txtTrangThai.setHorizontalAlignment(SwingConstants.CENTER);
		txtTrangThai.setBounds(0, 915, 1894, 20);
		pnlSach.add(txtTrangThai);
		txtTrangThai.setColumns(10);
		
		JPanel pnlChucNang = new JPanel();
		pnlChucNang.setBackground(new Color(255, 255, 255));
		pnlChucNang.setBounds(1466, 0, 424, 380);
		pnlSach.add(pnlChucNang);
		pnlChucNang.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ :"));
		pnlChucNang.setLayout(null);
		
		JButton btnDatLai = new JButton("Đặt lại");
		btnDatLai.setBounds(101, 305, 224, 48);
		pnlChucNang.add(btnDatLai);
		btnDatLai.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnDatLai.setIcon(new ImageIcon(GuiQuanLyNhanVien.class.getResource("/image/TacVu_DatLai.png")));
		btnDatLai.setBackground(Color.WHITE);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setBounds(101, 165, 224, 50);
		pnlChucNang.add(btnXoa);
		btnXoa.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnXoa.setIcon(new ImageIcon(GuiQuanLyNhanVien.class.getResource("/image/TacVu_Xoa1.png")));
		btnXoa.setBackground(Color.WHITE);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setBounds(100, 25, 224, 50);
		pnlChucNang.add(btnThem);
		btnThem.setFont(font2);
		btnThem.setIcon(new ImageIcon(GuiQuanLyNhanVien.class.getResource("/image/TacVu_Them1.png")));
		btnThem.setBackground(Color.WHITE);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setBounds(101, 95, 224, 50);
		pnlChucNang.add(btnSua);
		btnSua.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnSua.setIcon(new ImageIcon(GuiQuanLyNhanVien.class.getResource("/image/TacVu_Sua.png")));
		btnSua.setBackground(Color.WHITE);
		
		JButton btnLuu = new JButton("Lưu");
		btnLuu.setBounds(101, 235, 224, 50);
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
		pnlThongTinSach = new JPanel();
		pnlThongTinSach.setBackground(new Color(255, 255, 255));
		
		pnlThongTinSach.setBorder(BorderFactory.createTitledBorder("Thông tin văn phòng phẩm"));
		pnlThongTinSach.setBounds(0, 0, 1456, 380);
		pnlVanPhongPham.add(pnlThongTinSach);
		pnlThongTinSach.setLayout(null);
		
		JLabel lblMaVPP = new JLabel("Mã văn phòng phẩm :");
		lblMaVPP.setBounds(100, 20, 226, 30);
		pnlThongTinSach.add(lblMaVPP);
		lblMaVPP.setFont(font2);
		
		JLabel lblMaMau = new JLabel("Mã màu :");
		lblMaMau.setBounds(450, 20, 187, 29);
		lblMaMau.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		pnlThongTinSach.add(lblMaMau);
		
		JLabel lblNgayNhapVPP = new JLabel("Ngày nhập :");
		lblNgayNhapVPP.setBounds(800, 20, 163, 29);
		lblNgayNhapVPP.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		pnlThongTinSach.add(lblNgayNhapVPP);
		
		JLabel lblTenVPP = new JLabel("Tên văn phòng phẩm :");
		lblTenVPP.setBounds(100, 110, 226, 30);
		lblTenVPP.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		pnlThongTinSach.add(lblTenVPP);
		
		JLabel lblXuatXu = new JLabel("Xuất Xứ :");
		lblXuatXu.setBounds(100, 290, 163, 30);
		lblXuatXu.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		pnlThongTinSach.add(lblXuatXu);
		
		JLabel lblNhaSanXuatVPP = new JLabel("Nhà sản xuất :");
		lblNhaSanXuatVPP.setBounds(800, 111, 163, 29);
		lblNhaSanXuatVPP.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		pnlThongTinSach.add(lblNhaSanXuatVPP);
		
		JLabel lblThuongHieu = new JLabel("Thương hiệu :");
		lblThuongHieu.setBounds(100, 200, 195, 30);
		lblThuongHieu.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		pnlThongTinSach.add(lblThuongHieu);
		
		txtMaVPP = new JTextField();
		txtMaVPP.setBounds(100, 55, 250, 35);
		txtMaVPP.setEditable(false);
		pnlThongTinSach.add(txtMaVPP);
		txtMaVPP.setColumns(10);
		
		txtMaMau = new JTextField();
		txtMaMau.setBounds(450, 55, 250, 35);
		txtMaMau.setColumns(10);
		pnlThongTinSach.add(txtMaMau);
		
		dtmNgayNhapVPP = new JTextField();
		dtmNgayNhapVPP.setBounds(800, 55, 250, 35);
		dtmNgayNhapVPP.setColumns(10);
		pnlThongTinSach.add(dtmNgayNhapVPP);
		
		txtThuongHieu = new JTextField();
		txtThuongHieu.setBounds(100, 235, 250, 35);
		txtThuongHieu.setColumns(10);
		pnlThongTinSach.add(txtThuongHieu);
		
		txtTenSach = new JTextField();
		txtTenSach.setBounds(100, 145, 250, 35);
		txtTenSach.setColumns(10);
		pnlThongTinSach.add(txtTenSach);
		
		JPanel pnlAnhVPP = new JPanel();
		pnlAnhVPP.setBounds(1219, 21, 214, 258);
		pnlAnhVPP.setBackground(new Color(255, 255, 255));
		pnlAnhVPP.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlAnhVPP.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Ảnh sản phẩm", TitledBorder.CENTER, TitledBorder.TOP, font2, new Color(0, 0, 0)));
		pnlThongTinSach.add(pnlAnhVPP);
		pnlAnhVPP.setLayout(null);
		
		JPanel pnlChuaAnhVPP = new JPanel();
		pnlChuaAnhVPP.setBackground(new Color(255, 255, 255));
		pnlChuaAnhVPP.setBounds(10, 31, 194, 216);
		pnlAnhVPP.add(pnlChuaAnhVPP);
		pnlChuaAnhVPP.setLayout(null);
		
		btnChonAnhVPP = new JButton("");
		btnChonAnhVPP.setBackground(new Color(255, 255, 255));
		btnChonAnhVPP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnChonAnhVPP.setBounds(62, 73, 70, 70);
		btnChonAnhVPP.setIcon(new ImageIcon(GuiQuanLyNhanVien.class.getResource("/image/ChonAnh.png")));
		pnlChuaAnhVPP.add(btnChonAnhVPP);
		
		JLabel lblSoLuongVPP = new JLabel("Số lượng :");
		lblSoLuongVPP.setBounds(450, 201, 136, 29);
		lblSoLuongVPP.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		pnlThongTinSach.add(lblSoLuongVPP);
		
		JLabel lblKhuyenMaiVPP = new JLabel("Khuyến mãi :");
		lblKhuyenMaiVPP.setBounds(800, 201, 147, 29);
		lblKhuyenMaiVPP.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		pnlThongTinSach.add(lblKhuyenMaiVPP);
		
		JLabel lblGiaGocVPP = new JLabel("Giá gốc :");
		lblGiaGocVPP.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblGiaGocVPP.setBounds(450, 110, 163, 30);
		pnlThongTinSach.add(lblGiaGocVPP);
		
		txtGiaGocVPP = new JTextField();
		txtGiaGocVPP.setColumns(10);
		txtGiaGocVPP.setBounds(450, 145, 250, 35);
		pnlThongTinSach.add(txtGiaGocVPP);
		
		txtSoLuongVPP = new JTextField();
		txtSoLuongVPP.setColumns(10);
		txtSoLuongVPP.setBounds(450, 235, 250, 35);
		pnlThongTinSach.add(txtSoLuongVPP);
		
		JLabel lblTinhTrangVPP = new JLabel("Tình trạng :");
		lblTinhTrangVPP.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblTinhTrangVPP.setBounds(450, 290, 136, 29);
		pnlThongTinSach.add(lblTinhTrangVPP);
		
		txtNhaSanXuatVPP = new JTextField();
		txtNhaSanXuatVPP.setColumns(10);
		txtNhaSanXuatVPP.setBounds(800, 145, 250, 35);
		pnlThongTinSach.add(txtNhaSanXuatVPP);
		
		txtKhuyenMaiVPP = new JTextField();
		txtKhuyenMaiVPP.setColumns(10);
		txtKhuyenMaiVPP.setBounds(800, 235, 250, 35);
		pnlThongTinSach.add(txtKhuyenMaiVPP);
		
		JLabel lblMoTaVPP = new JLabel("Mô tả :");
		lblMoTaVPP.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblMoTaVPP.setBounds(800, 290, 136, 29);
		pnlThongTinSach.add(lblMoTaVPP);
		
		txtMoTaVPP = new JTextField();
		txtMoTaVPP.setColumns(10);
		txtMoTaVPP.setBounds(800, 325, 250, 35);
		pnlThongTinSach.add(txtMoTaVPP);
		
		JComboBox cboTinhTrangVPP = new JComboBox();
		cboTinhTrangVPP.setBounds(450, 325, 250, 35);
		pnlThongTinSach.add(cboTinhTrangVPP);
		
		lblGiaBanVPP = new JLabel("Giá bán :");
		lblGiaBanVPP.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblGiaBanVPP.setBounds(1150, 324, 94, 36);
		pnlThongTinSach.add(lblGiaBanVPP);
		
		txtGiaBanVPP = new JTextField();
		txtGiaBanVPP.setEditable(false);
		txtGiaBanVPP.setBounds(1270, 325, 163, 35);
		pnlThongTinSach.add(txtGiaBanVPP);
		txtGiaBanVPP.setColumns(10);
		
		txtXuatXu = new JTextField();
		txtXuatXu.setColumns(10);
		txtXuatXu.setBounds(100, 325, 250, 35);
		pnlThongTinSach.add(txtXuatXu);
		
		
		
		
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
		
		JButton btnNhapExcelVPP = new JButton("Nhập Excel");
		btnNhapExcelVPP.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnNhapExcelVPP.setBackground(new Color(255, 255, 255));
		btnNhapExcelVPP.setBounds(1360, 26, 200, 35);
		pnlTacVuCon2.add(btnNhapExcelVPP);
		
		JButton btnXuatExcelVPP = new JButton("Xuất Excel");
		btnXuatExcelVPP.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnXuatExcelVPP.setBackground(new Color(255, 255, 255));
		btnXuatExcelVPP.setBounds(1660, 26, 200, 35);
		pnlTacVuCon2.add(btnXuatExcelVPP);
		
		JComboBox cboTimTinhTrangVPP = new JComboBox();
		cboTimTinhTrangVPP.setBounds(1060, 26, 200, 35);
		pnlTacVuCon2.add(cboTimTinhTrangVPP);
		
		txtTimTenVPP.addFocusListener(new FocusListener() {
            private AbstractButton txtTimTenVPP;

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
		
		
		JPanel pnlBangVPP = new JPanel();
		pnlBangVPP.setBounds(0, 480, 1890, 435);
		pnlVanPhongPham.add(pnlBangVPP);
		pnlBangVPP.setBorder(BorderFactory.createTitledBorder("Bảng thông tin văn phòng phẩm"));
		pnlBangVPP.setLayout(null);
		
		

		pnlBangVPP.setBackground(Color.white);;
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
		JScrollPane jScrollPane1 = new JScrollPane(tblKH);
		jScrollPane1.setBounds(15, 20, 1869, 410);
		JTableHeader tbHeaderVPP = tblKH.getTableHeader();
		tbHeaderVPP.setFont(font2);
		tbHeaderVPP.setBackground(new Color(51, 204, 204));
		pnlBangVPP.setLayout(null);
		tblKH.setFont(font2);
		tblKH.setRowHeight(35);
		pnlBangVPP.add(jScrollPane1);
		
		txtTrangThai = new JTextField("Không có hoạt động nào gần nhất");
		txtTrangThai.setForeground(Color.red);
		txtTrangThai.setHorizontalAlignment(SwingConstants.CENTER);
		txtTrangThai.setBounds(0, 915, 1894, 20);
		pnlVanPhongPham.add(txtTrangThai);
		txtTrangThai.setColumns(10);
		
		JPanel pnlChucNang1 = new JPanel();
		pnlChucNang1.setBackground(new Color(255, 255, 255));
		pnlChucNang1.setBounds(1466, 0, 424, 380);
		pnlVanPhongPham.add(pnlChucNang1);
		pnlChucNang1.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ :"));
		pnlChucNang1.setLayout(null);
		
		JButton btnDatLai1 = new JButton("Đặt lại");
		btnDatLai1.setBounds(101, 305, 224, 48);
		pnlChucNang1.add(btnDatLai1);
		btnDatLai1.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnDatLai1.setIcon(new ImageIcon(GuiQuanLyNhanVien.class.getResource("/image/TacVu_DatLai.png")));
		btnDatLai1.setBackground(Color.WHITE);
		
		JButton btnXoa1 = new JButton("Xóa");
		btnXoa1.setBounds(101, 165, 224, 50);
		pnlChucNang1.add(btnXoa1);
		btnXoa1.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnXoa1.setIcon(new ImageIcon(GuiQuanLyNhanVien.class.getResource("/image/TacVu_Xoa1.png")));
		btnXoa1.setBackground(Color.WHITE);
		
		JButton btnThem1 = new JButton("Thêm");
		btnThem1.setBounds(100, 25, 224, 50);
		pnlChucNang1.add(btnThem1);
		btnThem1.setFont(font2);
		btnThem1.setIcon(new ImageIcon(GuiQuanLyNhanVien.class.getResource("/image/TacVu_Them1.png")));
		btnThem1.setBackground(Color.WHITE);
		
		JButton btnSua1 = new JButton("Sửa");
		btnSua1.setBounds(101, 95, 224, 50);
		pnlChucNang1.add(btnSua1);
		btnSua1.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnSua1.setIcon(new ImageIcon(GuiQuanLyNhanVien.class.getResource("/image/TacVu_Sua.png")));
		btnSua1.setBackground(Color.WHITE);
		
		JButton btnLuu1 = new JButton("Lưu");
		btnLuu1.setBounds(101, 235, 224, 50);
		pnlChucNang1.add(btnLuu1);
		btnLuu1.setEnabled(false);
		btnLuu1.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnLuu1.setIcon(new ImageIcon(GuiQuanLyNhanVien.class.getResource("/image/TacVu_Luu.png")));
		btnLuu1.setBackground(Color.WHITE);
		

	}
}
