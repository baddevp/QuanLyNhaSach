package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.toedter.calendar.JDateChooser;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JTabbedPane;
import java.awt.FlowLayout;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Rectangle;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class GuiTraHang extends JFrame implements ActionListener {

	public static JPanel contentPane;
	private DefaultTableModel modelKH;
	private JTextField txtMAHD;
	private JTextField txtTenKH;
	private JTextField txtSDT;
	private JDateChooser dtmNgayLapHD;
	private JTextField txtTongTien;
	private DefaultTableModel modelSP;
	private JTable tblSP;
	private JTextField txtMaYCTH;
	private JDateChooser dtmTraHang;
	private JTextField txtTenNhanVien;
	private JTextField txtTongSoLuong;
	private JTextField txtTongTienSP;
	private JTextField txtTongGiam;
	private JTextField txtTongThanhToan;

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
		Color color1 = new Color(138, 43, 226); // BlueViolet
		Color color2 = new Color(233, 221, 244);
	
		//Tiêu đề
		JPanel pnlTieuDe = new JPanel();
		pnlTieuDe.setBounds(10, 10, 1890, 60);
		pnlTieuDe.setBackground(new Color(255, 255, 255));
		contentPane.add(pnlTieuDe);
		
		JLabel lblTieuDe = new JLabel("TRẢ HÀNG");
		lblTieuDe.setBackground(new Color(51, 204, 255));
		pnlTieuDe.add(lblTieuDe);
		lblTieuDe.setFont(font1);
		lblTieuDe.setForeground(new Color(0, 204, 204));
		
		JPanel pnlLapHoaDon = new JPanel();
		pnlLapHoaDon.setBounds(10, 80, 1890, 870);
		contentPane.add(pnlLapHoaDon);
		pnlLapHoaDon.setLayout(null);
		
		JPanel pnlChonKhachHang = new JPanel();
		pnlChonKhachHang.setBorder(new EmptyBorder(0, 0, 0, 0));
		pnlChonKhachHang.setBackground(new Color(255, 255, 255));
		pnlChonKhachHang.setBounds(0, 0, 1080, 348);
		pnlLapHoaDon.add(pnlChonKhachHang);
		pnlChonKhachHang.setLayout(null);
		
		JPanel pnlThongTinKhachHang = new JPanel();
		pnlThongTinKhachHang.setBounds(10, 58, 1060, 280);
		pnlChonKhachHang.add(pnlThongTinKhachHang);
		pnlThongTinKhachHang.setLayout(null);
		
		JLabel lblMaHD = new JLabel("Mã hóa đơn :");
		lblMaHD.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblMaHD.setBounds(10, 11, 163, 29);
		pnlThongTinKhachHang.add(lblMaHD);
		
		txtMAHD = new JTextField();
		txtMAHD.setEditable(false);
		txtMAHD.setColumns(10);
		txtMAHD.setBounds(10, 51, 300, 34);
		pnlThongTinKhachHang.add(txtMAHD);
		
		JLabel lblTenKH = new JLabel("Tên khách hàng :");
		lblTenKH.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblTenKH.setBounds(498, 11, 187, 29);
		pnlThongTinKhachHang.add(lblTenKH);
		
		txtTenKH = new JTextField();
		txtTenKH.setEditable(false);
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(498, 51, 300, 34);
		pnlThongTinKhachHang.add(txtTenKH);
		
		JLabel lblSDT = new JLabel("Số điện thoại :");
		lblSDT.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblSDT.setBounds(498, 96, 163, 29);
		pnlThongTinKhachHang.add(lblSDT);
		
		txtSDT = new JTextField();
		txtSDT.setEditable(false);
		txtSDT.setColumns(10);
		txtSDT.setBounds(498, 136, 300, 34);
		pnlThongTinKhachHang.add(txtSDT);
		
		JLabel lblNgayLap = new JLabel("Ngày lập :");
		lblNgayLap.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblNgayLap.setBounds(10, 96, 163, 29);
		pnlThongTinKhachHang.add(lblNgayLap);
		
		dtmNgayLapHD = new JDateChooser();
		dtmNgayLapHD.setEnabled(false);
		dtmNgayLapHD.setBounds(10, 136, 300, 34);
		pnlThongTinKhachHang.add(dtmNgayLapHD);
		
		txtTongTien = new JTextField();
		txtTongTien.setEditable(false);
		txtTongTien.setColumns(10);
		txtTongTien.setBounds(10, 224, 300, 34);
		pnlThongTinKhachHang.add(txtTongTien);
		
		JLabel lblTongTienThanhToan = new JLabel("Tổng tiền :");
		lblTongTienThanhToan.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblTongTienThanhToan.setBounds(10, 181, 163, 29);
		pnlThongTinKhachHang.add(lblTongTienThanhToan);
		
		JLabel lblDTL = new JLabel("Điểm tích lũy :");
		lblDTL.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblDTL.setBounds(498, 181, 163, 29);
		pnlThongTinKhachHang.add(lblDTL);
		
		JTextField txtDTL = new JTextField();
		txtDTL.setEditable(false);
		txtDTL.setColumns(10);
		txtDTL.setBounds(498, 221, 300, 41);
		pnlThongTinKhachHang.add(txtDTL);
		
		JLabel lblChonHoaDon = new JLabel("Thông tin khách hàng");
		lblChonHoaDon.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblChonHoaDon.setBounds(10, 11, 266, 36);
		pnlChonKhachHang.add(lblChonHoaDon);
		
		JButton btnChonHD = new JButton("Chọn hóa đơn");
		btnChonHD.setBackground(new Color(255, 255, 255));
		btnChonHD.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnChonHD.setBounds(730, 11, 275, 36);
		pnlChonKhachHang.add(btnChonHD);
		
		JPanel pnlHoaDon = new JPanel();
		pnlHoaDon.setBackground(new Color(255, 255, 255));
		pnlHoaDon.setBounds(1090, 0, 800, 870);
		pnlLapHoaDon.add(pnlHoaDon);
		pnlHoaDon.setLayout(null);
		
		JLabel lblThongTinHoaDon = new JLabel("Thông tin hóa đơn");
		lblThongTinHoaDon.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblThongTinHoaDon.setBounds(10, 11, 259, 36);
		pnlHoaDon.add(lblThongTinHoaDon);
		
		JButton btnHangCho = new JButton("Xem hàng chờ");
		btnHangCho.setBackground(new Color(255, 255, 255));
		btnHangCho.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnHangCho.setBounds(479, 11, 275, 36);
		pnlHoaDon.add(btnHangCho);
		
		JPanel pnlThongTinHoaDon = new JPanel();
		pnlThongTinHoaDon.setBounds(10, 58, 780, 801);
		pnlHoaDon.add(pnlThongTinHoaDon);
		pnlThongTinHoaDon.setLayout(null);
		
		JLabel lblNgayLapHDTH = new JLabel("Ngày lập :");
		lblNgayLapHDTH.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblNgayLapHDTH.setBounds(40, 110, 163, 30);
		pnlThongTinHoaDon.add(lblNgayLapHDTH);
		
		JLabel lblMaYCTH = new JLabel("Mã yêu cầu trả hàng :");
		lblMaYCTH.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblMaYCTH.setBounds(40, 40, 232, 30);
		pnlThongTinHoaDon.add(lblMaYCTH);
		
		JLabel lblTnNhnVin = new JLabel("Tên nhân viên :");
		lblTnNhnVin.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblTnNhnVin.setBounds(40, 180, 163, 30);
		pnlThongTinHoaDon.add(lblTnNhnVin);
		
		txtMaYCTH = new JTextField();
		txtMaYCTH.setEditable(false);
		txtMaYCTH.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtMaYCTH.setBounds(295, 40, 426, 30);
		pnlThongTinHoaDon.add(txtMaYCTH);
		txtMaYCTH.setColumns(10);
		
		dtmTraHang = new JDateChooser();
		dtmTraHang.setEnabled(false);

		dtmTraHang.setBounds(295, 110, 426, 30);
		pnlThongTinHoaDon.add(dtmTraHang);
		
		txtTenNhanVien = new JTextField();
		txtTenNhanVien.setEditable(false);
		txtTenNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTenNhanVien.setColumns(10);
		txtTenNhanVien.setBounds(295, 180, 426, 30);
		pnlThongTinHoaDon.add(txtTenNhanVien);
		
		txtTongSoLuong = new JTextField();
		txtTongSoLuong.setEditable(false);
		txtTongSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTongSoLuong.setColumns(10);
		txtTongSoLuong.setBounds(295, 250, 426, 30);
		pnlThongTinHoaDon.add(txtTongSoLuong);
		
		JLabel lblSoLuong = new JLabel("Tổng sản phẩm :");
		lblSoLuong.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblSoLuong.setBounds(40, 250, 163, 30);
		pnlThongTinHoaDon.add(lblSoLuong);
		
		JLabel lblTongTien = new JLabel("Tổng tiền:");
		lblTongTien.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblTongTien.setBounds(40, 320, 163, 30);
		pnlThongTinHoaDon.add(lblTongTien);
		
		txtTongTienSP = new JTextField();
		txtTongTienSP.setEditable(false);
		txtTongTienSP.setColumns(10);
		txtTongTienSP.setBounds(295, 320, 426, 30);
		pnlThongTinHoaDon.add(txtTongTienSP);
		
		JLabel lblTongGiam = new JLabel("Tổng giảm :");
		lblTongGiam.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblTongGiam.setBounds(40, 390, 163, 30);
		pnlThongTinHoaDon.add(lblTongGiam);
		
		txtTongGiam = new JTextField();
		txtTongGiam.setEditable(false);
		txtTongGiam.setColumns(10);
		txtTongGiam.setBounds(295, 394, 426, 30);
		pnlThongTinHoaDon.add(txtTongGiam);
		
		JLabel lblTongHoanTra = new JLabel("Tổng hoàn trả :");
		lblTongHoanTra.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblTongHoanTra.setBounds(40, 460, 197, 30);
		pnlThongTinHoaDon.add(lblTongHoanTra);
		
		txtTongThanhToan = new JTextField();
		txtTongThanhToan.setEditable(false);
		txtTongThanhToan.setColumns(10);
		txtTongThanhToan.setBounds(295, 464, 426, 30);
		pnlThongTinHoaDon.add(txtTongThanhToan);
		
		JLabel lblTienNhan = new JLabel("Lý do hoàn trả :");
		lblTienNhan.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblTienNhan.setBounds(40, 530, 197, 30);
		pnlThongTinHoaDon.add(lblTienNhan);
		
		JButton btnHoanTra = new JButton("Trả hàng");
		btnHoanTra.setBackground(new Color(255, 255, 255));
		btnHoanTra.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnHoanTra.setBounds(446, 743, 275, 36);
		pnlThongTinHoaDon.add(btnHoanTra);
		
		JCheckBox chkInHoaDon = new JCheckBox("In hóa đơn");
		chkInHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chkInHoaDon.setBounds(558, 707, 163, 30);
		pnlThongTinHoaDon.add(chkInHoaDon);
		
		JTextPane txpLyDoTraHang = new JTextPane();
		txpLyDoTraHang.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		txpLyDoTraHang.setBounds(294, 530, 427, 105);
		pnlThongTinHoaDon.add(txpLyDoTraHang);
		
		JPanel pnlSanPhamChon = new JPanel();
		pnlSanPhamChon.setBackground(new Color(255, 255, 255));
		pnlSanPhamChon.setBounds(0, 358, 1080, 512);
		pnlLapHoaDon.add(pnlSanPhamChon);
		pnlSanPhamChon.setLayout(null);
		
		JPanel pnlSanPham = new JPanel();
		pnlSanPham.setBounds(10, 58, 1060, 443);
		pnlSanPhamChon.add(pnlSanPham);
		pnlSanPham.setLayout(null);
		
		modelSP = new DefaultTableModel();
		modelSP.addColumn("Mã SP");
		modelSP.addColumn("Tên SP");
		modelSP.addColumn("Loại SP");
		modelSP.addColumn("Giá bán");
		modelSP.addColumn("Khuyến mãi");
		modelSP.addColumn("Thành tiền");
		tblSP = new JTable(modelSP);
		tblSP.setBackground(new Color(153, 204, 255));
		JScrollPane jScrollPane = new JScrollPane(tblSP);
		jScrollPane.setBounds(10, 10 , 1040, 420);
		JTableHeader tbHeaderKH = tblSP.getTableHeader();
		tbHeaderKH.setFont(font2);
		tbHeaderKH.setBackground(new Color(51, 204, 204));
		pnlSanPham.setLayout(null);
		tblSP.setFont(font2);
		tblSP.setRowHeight(35);
		pnlSanPham.add(jScrollPane);
		
		JLabel lblThongTinSP = new JLabel("Thông tin sản phẩm");
		lblThongTinSP.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblThongTinSP.setBounds(10, 11, 339, 36);
		pnlSanPhamChon.add(lblThongTinSP);
		
		JButton btnChonSanPham = new JButton("Chọn sản phẩm");
		btnChonSanPham.setBackground(new Color(255, 255, 255));
		btnChonSanPham.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnChonSanPham.setBounds(730, 11, 275, 36);
		pnlSanPhamChon.add(btnChonSanPham);;

		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
