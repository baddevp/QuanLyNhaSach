package gui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JSlider;
import java.awt.List;
import javax.swing.JFormattedTextField;

import java.awt.BorderLayout;
import java.awt.Choice;
import javax.swing.JPopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.TextField;
import java.awt.Rectangle;
import javax.swing.JLabel;

public class GuiTrangChu extends JFrame {

	private JPanel contentPane;
	private JMenuItem mniTimKiemHDTH;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiTrangChu frame = new GuiTrangChu();
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
	public GuiTrangChu() {
		setBackground(new Color(255, 204, 102));
		setTitle("FutureZe - Phầm mềm quản lý nhà sách");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); // Toàn màn hình
		this.setSize(1930, 1030);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar mnbChucNang = new JMenuBar();
		mnbChucNang.setBorder(null);
		mnbChucNang.setBackground(new Color(255, 255, 255));
		mnbChucNang.setBounds(0, 0, 1550, 100);

		JMenu mnHeThong = new JMenu("Hệ thống");
		mnHeThong.setBorder(new EmptyBorder(20, 20, 20, 20));
		mnHeThong.setIcon(new ImageIcon(GuiTrangChu.class.getResource("/image/TrangChu.png")));
		mnHeThong.setFont(new Font("Dialog", Font.BOLD, 18));
		mnbChucNang.add(mnHeThong);
		
		JMenuItem mniThongTinCaNhan = new JMenuItem("Thông tin cá nhân");
		mniThongTinCaNhan.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnHeThong.add(mniThongTinCaNhan);
		
		JSeparator separator_6 = new JSeparator();
		mnHeThong.add(separator_6);
		
		JMenuItem mniDoiMK = new JMenuItem("Đổi mật khẩu");
		mniDoiMK.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnHeThong.add(mniDoiMK);
		
		JMenuItem mniThoat = new JMenuItem("Thoát");
		mniThoat.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnHeThong.add(mniThoat);
		
		JMenu mnQuanLy = new JMenu("Quản lý");
		mnQuanLy.setBorder(new EmptyBorder(20, 20, 20, 20));
		mnQuanLy.setIcon(new ImageIcon(GuiTrangChu.class.getResource("/image/QuanLy.png")));
		mnQuanLy.setFont(new Font("Dialog", Font.BOLD, 18));
		mnbChucNang.add(mnQuanLy);
		
		JMenuItem mniKhachHang = new JMenuItem("Khách hàng");
		mniKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnQuanLy.add(mniKhachHang);
		
		JSeparator separator_2 = new JSeparator();
		mnQuanLy.add(separator_2);
		
		JMenu mnSanPham = new JMenu("Sản phẩm");
		mnSanPham.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnQuanLy.add(mnSanPham);
		
		JMenuItem mniSach = new JMenuItem("Sách");
		mniSach.setAlignmentX(Component.LEFT_ALIGNMENT);
		mniSach.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnSanPham.add(mniSach);
		
		JSeparator separator = new JSeparator();
		mnSanPham.add(separator);
		
		JMenuItem mniVPP = new JMenuItem("Văn Phòng Phẩm");
		mniVPP.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnSanPham.add(mniVPP);
		
		JMenu mniLoaiSP = new JMenu("Loại Sản Phẩm");
		mniLoaiSP.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnQuanLy.add(mniLoaiSP);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Loại sách");
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mniLoaiSP.add(mntmNewMenuItem_1);
		
		JMenuItem mniLoaiVPP = new JMenuItem("Loại Văn Phòng Phẩm");
		mniLoaiVPP.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mniLoaiSP.add(mniLoaiVPP);
		
		JSeparator separator_1 = new JSeparator();
		mnQuanLy.add(separator_1);
		
		JMenuItem mniNhanVien = new JMenuItem("Nhân viên");
		mniNhanVien.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnQuanLy.add(mniNhanVien);
		
		JMenuItem mniChucVu = new JMenuItem("Chức vụ");
		mniChucVu.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnQuanLy.add(mniChucVu);
		
		JMenuItem mniTaiKhoan = new JMenuItem("Tài khoản");
		mniTaiKhoan.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnQuanLy.add(mniTaiKhoan);
		
		JSeparator separator_3 = new JSeparator();
		mnQuanLy.add(separator_3);
		
		JMenuItem mniNSX = new JMenuItem("Nhà sản xuất");
		mniNSX.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnQuanLy.add(mniNSX);
		
		JMenuItem mniMauSac = new JMenuItem("Màu sắc");
		mniMauSac.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnQuanLy.add(mniMauSac);
		
		JMenu mnXuLy = new JMenu("Xử lý");
		mnXuLy.setBorder(new EmptyBorder(20, 20, 20, 20));
		mnXuLy.setHorizontalAlignment(SwingConstants.CENTER);
		mnXuLy.setIcon(new ImageIcon(GuiTrangChu.class.getResource("/image/BanHang.png")));
		mnXuLy.setFont(new Font("Dialog", Font.BOLD, 18));
		mnbChucNang.add(mnXuLy);
		
		JMenuItem mniBanHang = new JMenuItem("Bán hàng");
		mniBanHang.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnXuLy.add(mniBanHang);
		
		JSeparator separator_7 = new JSeparator();
		mnXuLy.add(separator_7);
		
		JMenuItem mniTraHang = new JMenuItem("Trả hàng");
		mniTraHang.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnXuLy.add(mniTraHang);
		
		JSeparator separator_8 = new JSeparator();
		mnXuLy.add(separator_8);
		
		JMenuItem mniInHoaDon = new JMenuItem("In lại hóa đơn");
		mniInHoaDon.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnXuLy.add(mniInHoaDon);
		
		JMenu mnTimKiem = new JMenu("Tìm kiếm");
		mnTimKiem.setBorder(new EmptyBorder(20, 20, 20, 20));
		mnTimKiem.setIcon(new ImageIcon(GuiTrangChu.class.getResource("/image/TimKiem.png")));
		mnTimKiem.setFont(new Font("Dialog", Font.BOLD, 18));
		mnbChucNang.add(mnTimKiem);
		
		JMenuItem mniTimKiemSach = new JMenuItem("Sách");
		mniTimKiemSach.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnTimKiem.add(mniTimKiemSach);
		
		JMenuItem mniTimKiemVPP = new JMenuItem("Văn phòng phẩm");
		mniTimKiemVPP.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnTimKiem.add(mniTimKiemVPP);
		
		JSeparator separator_4 = new JSeparator();
		mnTimKiem.add(separator_4);
		
		JMenuItem mniTimKiemTK = new JMenuItem("Tài khoản");
		mniTimKiemTK.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnTimKiem.add(mniTimKiemTK);
		
		JMenuItem mniTimKiemNV = new JMenuItem("Nhân viên");
		mniTimKiemNV.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnTimKiem.add(mniTimKiemNV);
		
		JSeparator separator_5 = new JSeparator();
		mnTimKiem.add(separator_5);
		
		JMenuItem mniTimKiemKH = new JMenuItem("Khách hàng");
		mniTimKiemKH.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnTimKiem.add(mniTimKiemKH);
		
		JMenuItem mniTimKiemHD = new JMenuItem("Hóa đơn\r\n");
		mniTimKiemHD.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnTimKiem.add(mniTimKiemHD);
		
		mniTimKiemHDTH = new JMenuItem("Hóa đơn\r\n trả hàng");
		mniTimKiemHDTH.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnTimKiem.add(mniTimKiemHDTH);
		
		JMenu mnThongKe = new JMenu("Thống kê");
		mnThongKe.setBorder(new EmptyBorder(20, 20, 20, 20));
		mnThongKe.setIcon(new ImageIcon(GuiTrangChu.class.getResource("/image/ThongKe.png")));
		mnThongKe.setFont(new Font("Dialog", Font.BOLD, 18));
		mnbChucNang.add(mnThongKe);
		
		JMenuItem mniThongKeNV = new JMenuItem("Nhân viên");
		mniThongKeNV.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnThongKe.add(mniThongKeNV);
		
		JMenuItem mniThongKeDT = new JMenuItem("Doanh thu");
		mniThongKeDT.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnThongKe.add(mniThongKeDT);
		
		JMenuItem mniThongKeSP = new JMenuItem("Sản phẩm bán chạy");
		mniThongKeSP.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnThongKe.add(mniThongKeSP);
		
		JMenuItem mniBaoCaoThuChi = new JMenuItem("Báo cáo thu chi trong ngày");
		mniBaoCaoThuChi.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnThongKe.add(mniBaoCaoThuChi);
		
		JMenu mnTroGiup = new JMenu("Trợ giúp");
		mnTroGiup.setBorder(new EmptyBorder(20, 20, 20, 20));
		mnTroGiup.setIcon(new ImageIcon(GuiTrangChu.class.getResource("/image/TroGiup.png")));
		mnTroGiup.setFont(new Font("Dialog", Font.BOLD, 18));
		mnbChucNang.add(mnTroGiup);
		
		JPanel pnlMenu = new JPanel();
		pnlMenu.setBackground(new Color(255, 255, 255));
		pnlMenu.setBounds(0, 0, 1914, 100);
		contentPane.add(pnlMenu);
		pnlMenu.setLayout(null);
		pnlMenu.add(mnbChucNang);
		
		JLabel lblTaiKhoan = new JLabel("New label");
		lblTaiKhoan.setIcon(new ImageIcon(GuiTrangChu.class.getResource("/image/TaiKhoan.png")));
		lblTaiKhoan.setBounds(1578, 11, 46, 32);
		pnlMenu.add(lblTaiKhoan);
		
		textField = new JTextField();
		textField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		textField.setBackground(new Color(255, 255, 255));
		textField.setEditable(false);
		textField.setEnabled(false);
		textField.setBounds(1634, 11, 270, 32);
		pnlMenu.add(textField);
		textField.setColumns(10);
		
		JTabbedPane tabNoiDung = new JTabbedPane();
		tabNoiDung.setTabPlacement(JTabbedPane.BOTTOM);
		tabNoiDung.setBounds(0, 99, 1914, 1000);
		tabNoiDung.setTabLayoutPolicy(HIDE_ON_CLOSE);
		contentPane.add(tabNoiDung);
		
		JPanel pnlTrangChu = new JPanel();
		tabNoiDung.add(pnlTrangChu,BorderLayout.CENTER);
		pnlTrangChu.setLayout(null);
		
		JLabel lblTieuDe = new JLabel("Trang Chủ");
		lblTieuDe.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblTieuDe.setBounds(489, 101, 210, 69);
		pnlTrangChu.add(lblTieuDe);
	}
}
