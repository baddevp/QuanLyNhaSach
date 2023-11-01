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

public class GuiBanHang extends JFrame implements ActionListener {

	public static JPanel contentPane;
	private DefaultTableModel modelKH;
	private JTextField txtMaKH;
	private JTextField txtTenKH;
	private JTextField txtSDT;
	private JDateChooser dtmNgayLapKH;
	private JTextField txtDiaChi;
	private DefaultTableModel modelSP;
	private JTable tblSP;
	private JTextField txtMaHD;
	private JDateChooser textField_1;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_2;
	private JTextField textField_9;

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
		
		JLabel lblTieuDe = new JLabel("LẬP HÓA ĐƠN");
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
		
		JLabel lblMaKH = new JLabel("Mã khách hàng:");
		lblMaKH.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblMaKH.setBounds(10, 11, 163, 29);
		pnlThongTinKhachHang.add(lblMaKH);
		
		txtMaKH = new JTextField();
		txtMaKH.setEditable(false);
		txtMaKH.setColumns(10);
		txtMaKH.setBounds(10, 51, 300, 34);
		pnlThongTinKhachHang.add(txtMaKH);
		
		JLabel lblTenKH = new JLabel("Tên khách hàng :");
		lblTenKH.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblTenKH.setBounds(10, 96, 187, 29);
		pnlThongTinKhachHang.add(lblTenKH);
		
		txtTenKH = new JTextField();
		txtTenKH.setEditable(false);
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(10, 136, 300, 34);
		pnlThongTinKhachHang.add(txtTenKH);
		
		JLabel lblSDT = new JLabel("Số điện thoại :");
		lblSDT.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblSDT.setBounds(10, 181, 163, 29);
		pnlThongTinKhachHang.add(lblSDT);
		
		txtSDT = new JTextField();
		txtSDT.setEditable(false);
		txtSDT.setColumns(10);
		txtSDT.setBounds(10, 224, 300, 34);
		pnlThongTinKhachHang.add(txtSDT);
		
		JLabel lblNgayLap = new JLabel("Ngày lập :");
		lblNgayLap.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblNgayLap.setBounds(498, 11, 163, 29);
		pnlThongTinKhachHang.add(lblNgayLap);
		
		dtmNgayLapKH = new JDateChooser();
		dtmNgayLapKH.setEnabled(false);
		dtmNgayLapKH.setBounds(498, 51, 300, 34);
		pnlThongTinKhachHang.add(dtmNgayLapKH);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setEditable(false);
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(498, 136, 300, 34);
		pnlThongTinKhachHang.add(txtDiaChi);
		
		JLabel lblDiaChi = new JLabel("Địa chỉ :");
		lblDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblDiaChi.setBounds(498, 96, 163, 29);
		pnlThongTinKhachHang.add(lblDiaChi);
		
		JLabel lblDTL = new JLabel("Điểm tích lũy :");
		lblDTL.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblDTL.setBounds(498, 181, 163, 29);
		pnlThongTinKhachHang.add(lblDTL);
		
		JTextField txtDTL = new JTextField();
		txtDTL.setEditable(false);
		txtDTL.setColumns(10);
		txtDTL.setBounds(498, 221, 300, 41);
		pnlThongTinKhachHang.add(txtDTL);
		
		JLabel lblChonKhachHang = new JLabel("Thông tin khách hàng");
		lblChonKhachHang.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblChonKhachHang.setBounds(10, 11, 266, 36);
		pnlChonKhachHang.add(lblChonKhachHang);
		
		JButton btnChonKhachHang = new JButton("Chọn khách hàng");
		btnChonKhachHang.setBackground(new Color(255, 255, 255));
		btnChonKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnChonKhachHang.setBounds(730, 11, 275, 36);
		pnlChonKhachHang.add(btnChonKhachHang);
		
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
		
		JLabel lblNgayLap_1 = new JLabel("Ngày lập :");
		lblNgayLap_1.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblNgayLap_1.setBounds(40, 110, 163, 30);
		pnlThongTinHoaDon.add(lblNgayLap_1);
		
		JLabel lblMaHD = new JLabel("Mã hóa đơn :");
		lblMaHD.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblMaHD.setBounds(40, 40, 163, 30);
		pnlThongTinHoaDon.add(lblMaHD);
		
		JLabel lblTnNhnVin = new JLabel("Tên nhân viên :");
		lblTnNhnVin.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblTnNhnVin.setBounds(40, 180, 163, 30);
		pnlThongTinHoaDon.add(lblTnNhnVin);
		
		txtMaHD = new JTextField();
		txtMaHD.setEditable(false);
		txtMaHD.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtMaHD.setBounds(295, 40, 426, 30);
		pnlThongTinHoaDon.add(txtMaHD);
		txtMaHD.setColumns(10);
		
		textField_1 = new JDateChooser();
		textField_1.setEnabled(false);

		textField_1.setBounds(295, 110, 426, 30);
		pnlThongTinHoaDon.add(textField_1);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_4.setColumns(10);
		textField_4.setBounds(295, 180, 426, 30);
		pnlThongTinHoaDon.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_5.setColumns(10);
		textField_5.setBounds(295, 250, 426, 30);
		pnlThongTinHoaDon.add(textField_5);
		
		JLabel lblSoLuong = new JLabel("Tổng sản phẩm :");
		lblSoLuong.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblSoLuong.setBounds(40, 250, 163, 30);
		pnlThongTinHoaDon.add(lblSoLuong);
		
		JLabel lblTongTien = new JLabel("Tổng tiền:");
		lblTongTien.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblTongTien.setBounds(40, 320, 163, 30);
		pnlThongTinHoaDon.add(lblTongTien);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(295, 320, 426, 30);
		pnlThongTinHoaDon.add(textField_6);
		
		JLabel lblTongGiam = new JLabel("Tổng giảm :");
		lblTongGiam.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblTongGiam.setBounds(40, 390, 163, 30);
		pnlThongTinHoaDon.add(lblTongGiam);
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBounds(295, 394, 426, 30);
		pnlThongTinHoaDon.add(textField_7);
		
		JLabel lblTongThanhToan = new JLabel("Tổng thanh toán :");
		lblTongThanhToan.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblTongThanhToan.setBounds(40, 460, 197, 30);
		pnlThongTinHoaDon.add(lblTongThanhToan);
		
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		textField_8.setBounds(295, 464, 426, 30);
		pnlThongTinHoaDon.add(textField_8);
		
		JLabel lblTienNhan = new JLabel("Tiền nhận :");
		lblTienNhan.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblTienNhan.setBounds(40, 530, 197, 30);
		pnlThongTinHoaDon.add(lblTienNhan);
		
		JLabel lblTienTraLai = new JLabel("Tiền trả lại :");
		lblTienTraLai.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblTienTraLai.setBounds(40, 600, 197, 30);
		pnlThongTinHoaDon.add(lblTienTraLai);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(295, 529, 426, 30);
		pnlThongTinHoaDon.add(textField_2);
		
		textField_9 = new JTextField();
		textField_9.setEditable(false);
		textField_9.setColumns(10);
		textField_9.setBounds(295, 600, 426, 30);
		pnlThongTinHoaDon.add(textField_9);
		
		JButton btnTaoDonMoi = new JButton("Tạo đơn mới");
		btnTaoDonMoi.setBackground(new Color(255, 255, 255));
		btnTaoDonMoi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnTaoDonMoi.setBounds(40, 743, 275, 36);
		pnlThongTinHoaDon.add(btnTaoDonMoi);
		
		JButton btnThanhToan = new JButton("Thanh toán");
		btnThanhToan.setBackground(new Color(255, 255, 255));
		btnThanhToan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnThanhToan.setBounds(446, 743, 275, 36);
		pnlThongTinHoaDon.add(btnThanhToan);
		
		JCheckBox chkInHoaDon = new JCheckBox("In hóa đơn");
		chkInHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chkInHoaDon.setBounds(558, 707, 163, 30);
		pnlThongTinHoaDon.add(chkInHoaDon);
		
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