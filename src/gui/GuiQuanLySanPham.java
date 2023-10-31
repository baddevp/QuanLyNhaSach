package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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

public class GuiQuanLySanPham extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JPanel contentPane;
	private JPanel pnlThongTinSach;
	private JPanel pnlThongTinVPP;
	private JTextField txtMaVPP;
	private JTextField txtMaMau;
	private JTextField txtThuongHieu;
	private JTextField txtTenSach;
	private JButton btnChonAnhVPP;
	private JTextField txtTimTenVPP;
	private JTextField txtTrangThai;
	private JTable tblKH;
	private DefaultTableModel modelSach;
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
	private JTextField txtThue;
	private JTextField txtThueVPP;
	private JTextField txtLoaiSach;
	private JTextField txtLoaiVPP;
	private DefaultTableModel modelVPP;
	private JDateChooser dtmNgayNhapSach;
	private JDateChooser dtmNgayNhapVPP;

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
		
		JPanel pnlAnhSach = new JPanel();
		pnlAnhSach.setBounds(1403, 54, 214, 258);
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
		
		txtNhaSanXuat = new JTextField();
		txtNhaSanXuat.setColumns(10);
		txtNhaSanXuat.setBounds(750, 145, 250, 35);
		pnlThongTinSach.add(txtNhaSanXuat);
		
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
		
		JComboBox cboLoaiBia = new JComboBox();
		cboLoaiBia.setBounds(100, 325, 250, 35);
		pnlThongTinSach.add(cboLoaiBia);
		
		JComboBox cboTinhTrang = new JComboBox();
		cboTinhTrang.setBounds(425, 325, 250, 35);
		pnlThongTinSach.add(cboTinhTrang);
		
		lblGiaBan = new JLabel("Giá bán :");
		lblGiaBan.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblGiaBan.setBounds(1075, 17, 94, 36);
		pnlThongTinSach.add(lblGiaBan);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(1075, 55, 250, 35);
		pnlThongTinSach.add(textField);
		textField.setColumns(10);
		
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
		txtLoaiSach.setColumns(10);
		txtLoaiSach.setBounds(1075, 235, 250, 35);
		pnlThongTinSach.add(txtLoaiSach);
		
		
		
		
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
		tblKH = new JTable(modelSach);
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
		pnlChucNang.setBounds(1637, 0, 250, 380);
		pnlSach.add(pnlChucNang);
		pnlChucNang.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ :"));
		pnlChucNang.setLayout(null);
		
		JButton btnDatLai = new JButton("Đặt lại");
		btnDatLai.setBounds(50, 305, 150, 48);
		pnlChucNang.add(btnDatLai);
		btnDatLai.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnDatLai.setIcon(new ImageIcon(GuiQuanLyNhanVien.class.getResource("/image/TacVu_DatLai.png")));
		btnDatLai.setBackground(Color.WHITE);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setBounds(50, 165, 150, 50);
		pnlChucNang.add(btnXoa);
		btnXoa.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnXoa.setIcon(new ImageIcon(GuiQuanLyNhanVien.class.getResource("/image/TacVu_Xoa1.png")));
		btnXoa.setBackground(Color.WHITE);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setBounds(50, 25, 150, 50);
		pnlChucNang.add(btnThem);
		btnThem.setFont(font2);
		btnThem.setIcon(new ImageIcon(GuiQuanLyNhanVien.class.getResource("/image/TacVu_Them1.png")));
		btnThem.setBackground(Color.WHITE);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setBounds(50, 95, 150, 50);
		pnlChucNang.add(btnSua);
		btnSua.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnSua.setIcon(new ImageIcon(GuiQuanLyNhanVien.class.getResource("/image/TacVu_Sua.png")));
		btnSua.setBackground(Color.WHITE);
		
		JButton btnLuu = new JButton("Lưu");
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
		
		txtMaMau = new JTextField();
		txtMaMau.setBounds(425, 55, 250, 35);
		txtMaMau.setColumns(10);
		pnlThongTinVPP.add(txtMaMau);
		
		dtmNgayNhapVPP = new JDateChooser();
		dtmNgayNhapVPP.setBounds(750, 55, 250, 35);
		pnlThongTinVPP.add(dtmNgayNhapVPP);
		
		txtThuongHieu = new JTextField();
		txtThuongHieu.setBounds(100, 235, 250, 35);
		txtThuongHieu.setColumns(10);
		pnlThongTinVPP.add(txtThuongHieu);
		
		txtTenSach = new JTextField();
		txtTenSach.setBounds(100, 145, 250, 35);
		txtTenSach.setColumns(10);
		pnlThongTinVPP.add(txtTenSach);
		
		JPanel pnlAnhVPP = new JPanel();
		pnlAnhVPP.setBounds(1403, 54, 214, 258);
		pnlAnhVPP.setBackground(new Color(255, 255, 255));
		pnlAnhVPP.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlAnhVPP.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Ảnh sản phẩm", TitledBorder.CENTER, TitledBorder.TOP, font2, new Color(0, 0, 0)));
		pnlThongTinVPP.add(pnlAnhVPP);
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
		
		txtNhaSanXuatVPP = new JTextField();
		txtNhaSanXuatVPP.setColumns(10);
		txtNhaSanXuatVPP.setBounds(750, 145, 250, 35);
		pnlThongTinVPP.add(txtNhaSanXuatVPP);
		
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
		
		JComboBox cboTinhTrangVPP = new JComboBox();
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
		
		JLabel lblThueVPP = new JLabel("Giá bán :");
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
		
		JLabel lblLoaiVPP = new JLabel("Giá bán :");
		lblLoaiVPP.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblLoaiVPP.setBounds(1075, 194, 94, 36);
		pnlThongTinVPP.add(lblLoaiVPP);
		
		txtLoaiVPP = new JTextField();
		txtLoaiVPP.setColumns(10);
		txtLoaiVPP.setBounds(1075, 235, 250, 35);
		pnlThongTinVPP.add(txtLoaiVPP);
		
		
		
		
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
		tblKH = new JTable(modelVPP);
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
		pnlChucNang1.setBounds(1637, 0, 250, 380);
		pnlVanPhongPham.add(pnlChucNang1);
		pnlChucNang1.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ :"));
		pnlChucNang1.setLayout(null);
		
		JButton btnDatLai1 = new JButton("Đặt lại");
		btnDatLai1.setBounds(50, 305, 150, 48);
		pnlChucNang1.add(btnDatLai1);
		btnDatLai1.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnDatLai1.setIcon(new ImageIcon(GuiQuanLyNhanVien.class.getResource("/image/TacVu_DatLai.png")));
		btnDatLai1.setBackground(Color.WHITE);
		
		JButton btnXoa1 = new JButton("Xóa");
		btnXoa1.setBounds(50, 165, 150, 50);
		pnlChucNang1.add(btnXoa1);
		btnXoa1.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnXoa1.setIcon(new ImageIcon(GuiQuanLyNhanVien.class.getResource("/image/TacVu_Xoa1.png")));
		btnXoa1.setBackground(Color.WHITE);
		
		JButton btnThem1 = new JButton("Thêm");
		btnThem1.setBounds(50, 25, 150, 50);
		pnlChucNang1.add(btnThem1);
		btnThem1.setFont(font2);
		btnThem1.setIcon(new ImageIcon(GuiQuanLyNhanVien.class.getResource("/image/TacVu_Them1.png")));
		btnThem1.setBackground(Color.WHITE);
		
		JButton btnSua1 = new JButton("Sửa");
		btnSua1.setBounds(50, 95, 150, 50);
		pnlChucNang1.add(btnSua1);
		btnSua1.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnSua1.setIcon(new ImageIcon(GuiQuanLyNhanVien.class.getResource("/image/TacVu_Sua.png")));
		btnSua1.setBackground(Color.WHITE);
		
		JButton btnLuu1 = new JButton("Lưu");
		btnLuu1.setBounds(50, 235, 150, 50);
		pnlChucNang1.add(btnLuu1);
		btnLuu1.setEnabled(false);
		btnLuu1.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnLuu1.setIcon(new ImageIcon(GuiQuanLyNhanVien.class.getResource("/image/TacVu_Luu.png")));
		btnLuu1.setBackground(Color.WHITE);
		

	}
}
