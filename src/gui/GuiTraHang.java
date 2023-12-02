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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
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

import connectDB.ConnectDB;
import dao.DAO_HoaDon;
import dao.DAO_KhachHang;
import dao.DAO_MauSac;
import dao.DAO_NhanVien;
import entity.HoaDon;
import entity.KhachHang;
import entity.MauSac;
import entity.NhanVien;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import com.toedter.calendar.JDateChooser;
import java.util.Date;
import javax.swing.JCheckBox;

public class GuiTraHang extends JFrame implements ActionListener, MouseListener {

	public static JPanel contentPane;
	DAO_HoaDon dao_HoaDon = new DAO_HoaDon();
	DAO_NhanVien dao_NhanVien = new DAO_NhanVien();
	DAO_KhachHang dao_KhachHang = new DAO_KhachHang();
	private JTextField txtTimKiem;
	private DefaultTableModel modelHD;
	private JTable tblHD;
	private JTextField txtTrangThai;
	private ButtonGroup group;
	private DAO_MauSac dao_mausac;
	private Component btnXoaTrang;
	private JButton btnChon;
	private JPanel pnlChonHDTH;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JPanel pnlLapHoaDonTH;
	private JTextField txtMaHD;
	private JTextField txtTongTien;
	private JTextField txtNhanVienLHD;
	private Component dtmNgayLap;
	private JTextField txtNgayLap;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiTraHang frame = new GuiTraHang();
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
	public GuiTraHang() {
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
		txtTimKiem.setBounds(376, 24, 875, 40);
		pnlChonHDTH.add(txtTimKiem);
		txtTimKiem.setColumns(10);



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
		btnChon.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Object o = e.getSource();
				if (o.equals(btnChon)) {
					
				}
			}
		});
		btnChon.setBounds(1444, 24, 302, 43);
		pnlChonHDTH.add(btnChon);
		
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

		JButton btnDoiHD = new JButton("Đổi hóa đơn");
		btnDoiHD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object o = e.getSource();
				if (o.equals(btnDoiHD)) {
					pnlChonHDTH.show();
					pnlLapHoaDonTH.hide();
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

		JPanel pnlHoaDon = new JPanel();
		pnlHoaDon.setLayout(null);
		pnlHoaDon.setBackground(Color.WHITE);
		pnlHoaDon.setBounds(973, 0, 917, 883);
		pnlLapHoaDonTH.add(pnlHoaDon);

		JPanel pnlThongTinHoaDon = new JPanel();
		pnlThongTinHoaDon.setLayout(null);
		pnlThongTinHoaDon.setBounds(10, 56, 897, 177);
		pnlHoaDon.add(pnlThongTinHoaDon);

		JLabel lblNgayLap = new JLabel("Ngày lập:");
		lblNgayLap.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblNgayLap.setBounds(299, 40, 102, 30);
		pnlThongTinHoaDon.add(lblNgayLap);

		JLabel lblMaYCTH = new JLabel("Mã YCTH:");
		lblMaYCTH.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblMaYCTH.setBounds(10, 40, 126, 30);
		pnlThongTinHoaDon.add(lblMaYCTH);

		JLabel lblTenNV = new JLabel("Tên NV :");
		lblTenNV.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblTenNV.setBounds(599, 40, 92, 30);
		pnlThongTinHoaDon.add(lblTenNV);

		textField_1 = new JTextField();
		textField_1.setText("");
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(120, 41, 169, 34);
		pnlThongTinHoaDon.add(textField_1);

		dtmNgayLap = new JDateChooser((Date) null);
		dtmNgayLap.setEnabled(false);
		dtmNgayLap.setBounds(393, 40, 196, 34);
		pnlThongTinHoaDon.add(dtmNgayLap);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(691, 40, 196, 34);
		pnlThongTinHoaDon.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_3.setColumns(10);
		textField_3.setBounds(120, 109, 169, 34);
		pnlThongTinHoaDon.add(textField_3);

		JLabel lblSDTKH = new JLabel("SDT KH:");
		lblSDTKH.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblSDTKH.setBounds(10, 108, 92, 30);
		pnlThongTinHoaDon.add(lblSDTKH);

		JLabel lblTenKH = new JLabel("Tên KH:");
		lblTenKH.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblTenKH.setBounds(299, 108, 92, 30);
		pnlThongTinHoaDon.add(lblTenKH);

		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(393, 109, 196, 34);
		pnlThongTinHoaDon.add(textField_4);

		JLabel lblDiemTL = new JLabel("Điểm TL:");
		lblDiemTL.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblDiemTL.setBounds(599, 108, 102, 30);
		pnlThongTinHoaDon.add(lblDiemTL);

		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(691, 109, 196, 34);
		pnlThongTinHoaDon.add(textField_5);

		JButton btnXoaDong = new JButton("Xóa dòng");
		btnXoaDong.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnXoaDong.setBackground(Color.WHITE);
		btnXoaDong.setBounds(729, 250, 159, 36);
		pnlHoaDon.add(btnXoaDong);

		JLabel lblThongTinHD = new JLabel("Thông tin trả hàng :");
		lblThongTinHD.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblThongTinHD.setBounds(10, 9, 266, 36);
		pnlHoaDon.add(lblThongTinHD);

		JPanel pnlTbTTHoaDon = new JPanel();
		pnlTbTTHoaDon.setLayout(null);
		pnlTbTTHoaDon.setBounds(10, 304, 897, 321);
		pnlHoaDon.add(pnlTbTTHoaDon);

		JScrollPane jScrollPane_TTHD = new JScrollPane((Component) null);
		jScrollPane_TTHD.setBounds(10, 10, 877, 300);
		pnlTbTTHoaDon.add(jScrollPane_TTHD);

		JLabel lblTongSP = new JLabel("Tổng số SP:");
		lblTongSP.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblTongSP.setBounds(20, 666, 199, 30);
		pnlHoaDon.add(lblTongSP);

		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(250, 667, 273, 30);
		pnlHoaDon.add(textField_6);

		JLabel lblTienKhachTra = new JLabel("Số tiền phải trả :");
		lblTienKhachTra.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblTienKhachTra.setBounds(20, 718, 199, 30);
		pnlHoaDon.add(lblTienKhachTra);

		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBounds(250, 719, 273, 30);
		pnlHoaDon.add(textField_7);

		JButton btnThanhToan = new JButton("TRẢ HÀNG");
		btnThanhToan.setForeground(Color.WHITE);
		btnThanhToan.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnThanhToan.setBackground(new Color(51, 204, 204));
		btnThanhToan.setBounds(659, 797, 216, 52);
		pnlHoaDon.add(btnThanhToan);

		JButton btnSuaSL = new JButton("Số lượng trả");
		btnSuaSL.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSuaSL.setBackground(Color.WHITE);
		btnSuaSL.setBounds(549, 250, 170, 36);
		pnlHoaDon.add(btnSuaSL);

		JLabel lblSnPhmTr = new JLabel("Sản phẩm trả :");
		lblSnPhmTr.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSnPhmTr.setBounds(20, 260, 266, 36);
		pnlHoaDon.add(lblSnPhmTr);

		JCheckBox chkinHD = new JCheckBox("In hóa đơn");
		chkinHD.setFont(new Font("Tahoma", Font.BOLD, 18));
		chkinHD.setBounds(454, 823, 199, 23);
		pnlHoaDon.add(chkinHD);

		JPanel pnlSanPhamChon = new JPanel();
		pnlSanPhamChon.setLayout(null);
		pnlSanPhamChon.setBackground(Color.WHITE);
		pnlSanPhamChon.setBounds(0, 260, 963, 623);
		pnlLapHoaDonTH.add(pnlSanPhamChon);

		JPanel pnlSanPham = new JPanel();
		pnlSanPham.setLayout(null);
		pnlSanPham.setBounds(10, 46, 945, 567);
		pnlSanPhamChon.add(pnlSanPham);

		JScrollPane jScrollPaneSP = new JScrollPane((Component) null);
		jScrollPaneSP.setBounds(10, 11, 925, 546);
		pnlSanPham.add(jScrollPaneSP);

		JLabel lblChonSP = new JLabel("Sản phẩm đã mua :");
		lblChonSP.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblChonSP.setBounds(10, 0, 266, 36);
		pnlSanPhamChon.add(lblChonSP);

		textField = new JTextField();
		textField.setBounds(286, 6, 521, 32);
		pnlSanPhamChon.add(textField);
		textField.setColumns(10);

		pnlLapHoaDonTH.hide();
		
		try {
			ConnectDB.getInstance().connect();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		DocDuLieuDatataabase();
		
		
		//Bắt sự kiện
		btnChon.addActionListener(this);
//		tblHD.addMouseListener(this);
	}

	public void DocDuLieuDatataabase() {
		dao_HoaDon = new DAO_HoaDon();
		
		for (HoaDon hd : dao_HoaDon.getAllHD()) {
			KhachHang kh = dao_KhachHang.getKhachHangTheoMa(hd.getKhachHang().getMaKH());
			modelHD.addRow(new Object[] { hd.getMaHoaDon(), hd.getNgayLapHoaDon(), hd.getTongTien(),
					hd.getNhanVien().getMaNV(), kh.getTenKH(), strTrangThai(hd.isTrangThai()) });
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
		if(o.equals(btnChon)) {
			int selectedRow = tblHD.getSelectedRow();
            if (selectedRow != -1) {
                // Nếu có dòng được chọn, chuyển sang màn hình trả hàng, ẩn màn hình chọn hóa đơn
            	pnlChonHDTH.hide();
				pnlLapHoaDonTH.show();
				//Lấy dữ liệu hóa đơn điền vào thông tin hóa đơn trả hàng
				HoaDon hd = dao_HoaDon.getHDTheoMaHD(tblHD.getValueAt(selectedRow, 0).toString());
				txtMaHD.setText(hd.getMaHoaDon());
				txtTongTien.setText(hd.getTongTien() + "");
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				String ngayLap = hd.getNgayLapHoaDon().format(formatter);
				txtNgayLap.setText(ngayLap);
				NhanVien nv = dao_NhanVien.getNhanVienTheoMa2(hd.getNhanVien().getMaNV());
				txtNhanVienLHD.setText(nv.getTenNV());
            } else {
                // Nếu không có dòng nào được chọn, hiển thị thông báo
                JOptionPane.showMessageDialog(null, "Vui lòng chọn hóa đơn cần trả để chuyển trang trả hàng.",
                        "Thông báo", JOptionPane.WARNING_MESSAGE);
            }
        }
		}
	}

