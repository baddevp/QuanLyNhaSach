package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import com.toedter.calendar.JDateChooser;

import dao.DAO_ChiTietHoaDon;
import dao.DAO_HoaDon;
import dao.DAO_QuanLySach;
import dao.DAO_QuanLyVPP;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.Sach;
import entity.VanPhongPham;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import java.awt.Dimension;

public class GuiThongKeDoanhThu extends JFrame implements ActionListener {
	public static JPanel pnlBorder;
	private JButton btnTongHoaDon;
	private JButton btnTheoSanPham;
	private JButton btnTheoLoaiSanPham;
	private Color color3;
	private Color color1;
	private JComboBox<String> cmbLuaChon;
	private ChartPanel chartPanel;
	private DecimalFormat df = new DecimalFormat("#,##0đ");
	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyy");
	private DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd/MM/yyyHH:mm");
	DAO_QuanLySach dao_QuanLySach = new DAO_QuanLySach();
	DAO_QuanLyVPP dao_quanLyVPP = new DAO_QuanLyVPP();
	private DAO_HoaDon dao_HoaDon = new DAO_HoaDon();
	private ArrayList<HoaDon> dsHoaDonDaThanhToan = dao_HoaDon.getHoaDonDaThanhToan();
	private DAO_ChiTietHoaDon dao_CTHD = new DAO_ChiTietHoaDon();
	private LocalDate ngayBatDau = LocalDate.now();
	private LocalDate ngayKetThuc = LocalDate.now();
	private JTable tblThongKe;
	private Box bThongKeTongQuat;
	private JLabel lblTongDoanhThu;
	private JLabel lblTongSo;
	private JLabel lblCaoNhat;
	private JLabel lblThapNhat;
	private JTextField txtTongDoanhThu;
	private JTextField txtTongSo;
	private JTextField txtCaoNhat;
	private JTextField txtThapNhat;
	private JButton btnBaoCao;
	private JButton btnXacNhan;
	private JDateChooser dchLuaChonThoiGian;
	private JLabel lblNhapLuaChon;

	public GuiThongKeDoanhThu() {
		this.setTitle("Thống kê doanh thu");
		this.setSize(1920, 1040);
		this.setLocationRelativeTo(null);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.createUI();
	}

	private void createUI() {
		// Kiểu chữ
		Font font1 = new Font("Times New Roman", Font.BOLD, 36);
		Font font2 = new Font("Times New Roman", Font.PLAIN, 24);
		Font font3 = new Font("Times New Roman", Font.BOLD, 24);

		// Màu chữ
		color1 = new Color(51, 204, 204);
		Color color2 = Color.white;
		color3 = new Color(255, 153, 51);

		pnlBorder = new JPanel();
		pnlBorder.setBackground(new Color(204, 204, 204));
		pnlBorder.setLayout(null);

		// Lựa chọn thời gian thống kê
		JPanel pnlThoiGian = new JPanel();
		pnlThoiGian.setLayout(null);
		pnlThoiGian.setBackground(Color.WHITE);
		pnlThoiGian.setBounds(20, 20, 350, 560);

		JPanel pnlTittleThoiGian = new JPanel();
		pnlTittleThoiGian.setBackground(new Color(51, 204, 204));
		pnlTittleThoiGian.setBorder(new EmptyBorder(10, 0, 0, 0));
		pnlTittleThoiGian.setBounds(0, 0, 350, 60);
		JLabel lblTittleThoiGian = new JLabel("THỜI GIAN THỐNG KÊ");
		lblTittleThoiGian.setFont(font3);
		lblTittleThoiGian.setForeground(Color.WHITE);
		pnlTittleThoiGian.add(lblTittleThoiGian);

		JPanel pnlLuaChonThoiGian = new JPanel();
		pnlLuaChonThoiGian.setLayout(null);
		pnlLuaChonThoiGian.setBounds(0, 60, 350, 500);
		pnlLuaChonThoiGian.setBackground(Color.WHITE);

		JLabel lblLuaChon = new JLabel("Lựa chọn:");
		lblLuaChon.setBounds(50, 60, 250, 45);
		lblLuaChon.setFont(font2);
		lblNhapLuaChon = new JLabel("Chọn ngày:");
		lblNhapLuaChon.setBounds(50, 200, 250, 45);
		lblNhapLuaChon.setFont(font2);

		cmbLuaChon = new JComboBox<String>();
		cmbLuaChon.setBounds(50, 105, 250, 45);
		cmbLuaChon.addItem("Theo ngày");
		cmbLuaChon.addItem("Theo tháng");
		cmbLuaChon.addItem("Theo năm");
		cmbLuaChon.setFont(font2);
		dchLuaChonThoiGian = new JDateChooser();
		dchLuaChonThoiGian.setBounds(50, 245, 250, 45);
		dchLuaChonThoiGian.setFont(font2);
		dchLuaChonThoiGian.setDateFormatString("dd/MM/yyy");
		dchLuaChonThoiGian.setDate(new Date());
		btnXacNhan = new JButton("Xác nhận");
		btnXacNhan.setBounds(100, 365, 150, 45);
		btnXacNhan.setFont(font3);
		btnXacNhan.setBackground(color1);
		btnXacNhan.setForeground(Color.WHITE);

		pnlLuaChonThoiGian.add(lblLuaChon);
		pnlLuaChonThoiGian.add(cmbLuaChon);
		pnlLuaChonThoiGian.add(lblNhapLuaChon);
		pnlLuaChonThoiGian.add(dchLuaChonThoiGian);
		pnlLuaChonThoiGian.add(btnXacNhan);

		pnlThoiGian.add(pnlTittleThoiGian);
		pnlThoiGian.add(pnlLuaChonThoiGian);

		// Chọn mục thống kê
		JPanel pnlMucThonKe = new JPanel();
		pnlMucThonKe.setLayout(null);
		pnlMucThonKe.setBackground(Color.WHITE);
		pnlMucThonKe.setBounds(20, 600, 350, 318);

		JPanel pnlTittleMucThongKe = new JPanel();
		pnlTittleMucThongKe.setBackground(new Color(51, 204, 204));
		pnlTittleMucThongKe.setBorder(new EmptyBorder(10, 0, 0, 0));
		pnlTittleMucThongKe.setBounds(0, 0, 350, 60);
		JLabel lblTittleMucThongKe = new JLabel("MỤC THỐNG KÊ");
		lblTittleMucThongKe.setFont(font3);
		lblTittleMucThongKe.setForeground(Color.WHITE);
		pnlTittleMucThongKe.add(lblTittleMucThongKe);

		JPanel pnlChonMucThongKe = new JPanel();
		pnlChonMucThongKe.setBounds(0, 60, 350, 255);
		pnlChonMucThongKe.setBackground(Color.WHITE);
		pnlChonMucThongKe.setLayout(null);
		btnTongHoaDon = new JButton("Tổng hóa đơn");
		btnTongHoaDon.setBounds(50, 30, 250, 50);
		btnTongHoaDon.setFont(font3);
		btnTongHoaDon.setBackground(color3);
		btnTongHoaDon.setForeground(Color.WHITE);
		btnTheoSanPham = new JButton("Theo sản phẩm");
		btnTheoSanPham.setFont(font3);
		btnTheoSanPham.setBounds(50, 100, 250, 50);
		btnTheoSanPham.setBackground(Color.WHITE);
		btnTheoSanPham.setForeground(color1);
		btnTheoLoaiSanPham = new JButton("Theo  loại sản phẩm");
		btnTheoLoaiSanPham.setFont(font3);
		btnTheoLoaiSanPham.setBounds(50, 180, 250, 50);
		btnTheoLoaiSanPham.setBackground(Color.WHITE);
		btnTheoLoaiSanPham.setForeground(color1);
		pnlChonMucThongKe.add(btnTongHoaDon);
		pnlChonMucThongKe.add(btnTheoSanPham);
		pnlChonMucThongKe.add(btnTheoLoaiSanPham);

		pnlMucThonKe.add(pnlTittleMucThongKe);
		pnlMucThonKe.add(pnlChonMucThongKe);

		JPanel pnlThongKeTongQuat = new JPanel();
		pnlThongKeTongQuat.setBounds(1510, 20, 390, 560);
		pnlThongKeTongQuat.setBackground(Color.WHITE);
		pnlThongKeTongQuat.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(color1),
				"THỐNG KÊ TỔNG QUÁT", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, font3, color1));
		
		JPanel pnlTable = new JPanel();
		pnlTable.setLayout(new BorderLayout());
		pnlTable.setBounds(390, 600, 1510, 318);
		pnlTable.setBackground(Color.WHITE);
		pnlTable.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(color1), "BẢNG THỐNG KÊ",
				TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, font3, color1));
		tblThongKe = new JTable();
		JTableHeader tbhThongKe = tblThongKe.getTableHeader();
		tbhThongKe.setFont(font2);
		tblThongKe.setFont(font2);
		tblThongKe.setRowHeight(35);
		tblThongKe.setDefaultEditor(Object.class, null);
		// tblThongKe.setAutoCreateRowSorter(true);
		JScrollPane scr = new JScrollPane(tblThongKe, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		pnlTable.add(scr);

		JPanel pnlNDThongKeTongQuat = new JPanel();
		pnlNDThongKeTongQuat.setLayout(new BorderLayout());
		pnlNDThongKeTongQuat.setBorder(new EmptyBorder(50, 10, 50, 10));
		pnlNDThongKeTongQuat.setBackground(Color.WHITE);

		bThongKeTongQuat = Box.createVerticalBox();
		Box bLblTongDoanhThu = Box.createHorizontalBox();
		Box bTxtTongDoanhThu = Box.createHorizontalBox();
		Box bLblTongSo = Box.createHorizontalBox();
		Box bTxtTongSo = Box.createHorizontalBox();
		Box bLblCaoNhat = Box.createHorizontalBox();
		Box bTxtCaoNhat = Box.createHorizontalBox();
		Box bLblThapNhat = Box.createHorizontalBox();
		Box bTxtThapNhat = Box.createHorizontalBox();
		Box bBaoCao = Box.createHorizontalBox();

		lblTongDoanhThu = new JLabel("Tổng doanh thu:");
		lblTongDoanhThu.setFont(font2);
		lblTongSo = new JLabel("Tổng số hóa đơn:");
		lblTongSo.setFont(font2);
		lblCaoNhat = new JLabel("Hóa đơn tiền cao nhất:");
		lblCaoNhat.setFont(font2);
		lblThapNhat = new JLabel("Hóa đơn tiền thấp nhất:");
		lblThapNhat.setPreferredSize(new Dimension(300, 30));
		lblThapNhat.setFont(font2);

		lblTongDoanhThu.setPreferredSize(new Dimension(300, 29));
		lblTongSo.setPreferredSize(lblThapNhat.getPreferredSize());
		lblCaoNhat.setPreferredSize(new Dimension(300, 29));

		txtTongDoanhThu = new JTextField(14);
		txtTongDoanhThu.setFont(font2);
		txtTongDoanhThu.setBackground(color2);
		txtTongDoanhThu.setEditable(false);

		txtTongSo = new JTextField(14);
		txtTongSo.setFont(font2);
		txtTongSo.setFont(font2);
		txtTongSo.setBackground(color2);
		txtTongSo.setEditable(false);

		txtCaoNhat = new JTextField(14);
		txtCaoNhat.setFont(font2);
		txtCaoNhat.setFont(font2);
		txtCaoNhat.setBackground(color2);
		txtCaoNhat.setEditable(false);

		txtThapNhat = new JTextField(14);
		txtThapNhat.setFont(font2);
		txtThapNhat.setFont(font2);
		txtThapNhat.setBackground(color2);
		txtThapNhat.setEditable(false);

		btnBaoCao = new JButton("Báo cáo");
		btnBaoCao.setBackground(color1);
		btnBaoCao.setForeground(Color.WHITE);
		btnBaoCao.setFont(font3);

		bLblTongDoanhThu.add(lblTongDoanhThu);
		bLblTongDoanhThu.add(Box.createVerticalStrut(0));
		bTxtTongDoanhThu.add(txtTongDoanhThu);
		bLblTongSo.add(lblTongSo);
		bLblTongSo.add(Box.createVerticalStrut(0));
		bTxtTongSo.add(txtTongSo);
		bLblCaoNhat.add(lblCaoNhat);
		bLblCaoNhat.add(Box.createVerticalStrut(0));
		bTxtCaoNhat.add(txtCaoNhat);
		bLblThapNhat.add(lblThapNhat);
		bLblThapNhat.add(Box.createVerticalStrut(0));
		bTxtThapNhat.add(txtThapNhat);
		bBaoCao.add(btnBaoCao);

		bThongKeTongQuat.add(bLblTongDoanhThu);
		bThongKeTongQuat.add(Box.createVerticalStrut(3));
		bThongKeTongQuat.add(bTxtTongDoanhThu);
		bThongKeTongQuat.add(Box.createVerticalStrut(20));
		bThongKeTongQuat.add(bLblTongSo);
		bThongKeTongQuat.add(Box.createVerticalStrut(3));
		bThongKeTongQuat.add(bTxtTongSo);
		bThongKeTongQuat.add(Box.createVerticalStrut(20));
		bThongKeTongQuat.add(bLblCaoNhat);
		bThongKeTongQuat.add(Box.createVerticalStrut(3));
		bThongKeTongQuat.add(bTxtCaoNhat);
		bThongKeTongQuat.add(Box.createVerticalStrut(20));
		bThongKeTongQuat.add(bLblThapNhat);
		bThongKeTongQuat.add(Box.createVerticalStrut(3));
		bThongKeTongQuat.add(bTxtThapNhat);
		bThongKeTongQuat.add(Box.createVerticalStrut(20));
		bThongKeTongQuat.add(bBaoCao);

		pnlNDThongKeTongQuat.add(bThongKeTongQuat);
		pnlThongKeTongQuat.add(pnlNDThongKeTongQuat);

		try {
			chartPanel = new ChartPanel(createChart(null, "", "", ""));
		} catch (NumberFormatException | ParseException e) {
			e.printStackTrace();
		}
		chartPanel.setBounds(390, 20, 1100, 560);

		pnlBorder.add(pnlThoiGian);
		pnlBorder.add(pnlMucThonKe);
		pnlBorder.add(chartPanel);
		pnlBorder.add(pnlThongKeTongQuat);
		pnlBorder.add(pnlTable);
		getContentPane().add(pnlBorder);

		showData();

		cmbLuaChon.addActionListener(this);
		btnTongHoaDon.addActionListener(this);
		btnTheoSanPham.addActionListener(this);
		btnTheoLoaiSanPham.addActionListener(this);
		btnBaoCao.addActionListener(this);
		btnXacNhan.addActionListener(this);
	}

	/**
	 * Sắp xếp danh sách thống kê doanh thu hóa đơn theo thứ tự tăng dần của ngày
	 * lập
	 * 
	 * @param dsTKDoanhThuHoaDon
	 * @return danh sách thống kế danh thu hóa đơn đã sắp xếp theo thứ tự tăng dần
	 *         của ngày lập
	 */
	private ArrayList<ArrayList<String>> sapXepTKHoaDonTangTheoNgayLap(
			ArrayList<ArrayList<String>> dsTKDoanhThuHoaDon) {
		ArrayList<ArrayList<String>> ketQua = new ArrayList<ArrayList<String>>();
		int soPhanTu = dsTKDoanhThuHoaDon.size();
		if (soPhanTu > 0)
			for (int i = 0; i < soPhanTu; i++) {

				// 1 là vị trí của ngày lập trong dsTKDoanhThuHoaDon
				LocalDate ngayLapNhoNhat = LocalDate.parse(dsTKDoanhThuHoaDon.get(0).get(1), dtf);
				int rowNhoNhat = 0;
				for (int j = 0; j < dsTKDoanhThuHoaDon.size(); j++) {
					LocalDate ngayLap = LocalDate.parse(dsTKDoanhThuHoaDon.get(j).get(1), dtf);
					if (ngayLapNhoNhat.isAfter(ngayLap)) {
						ngayLapNhoNhat = ngayLap;
						rowNhoNhat = j;
					}
				}
				ketQua.add(dsTKDoanhThuHoaDon.get(rowNhoNhat));
				dsTKDoanhThuHoaDon.remove(rowNhoNhat);
			}
		return ketQua;
	}
	

	private ArrayList<ArrayList<String>> getTKDoanhThuHoaDon(ArrayList<HoaDon> dsHoaDonDaThanhToan) {
		ArrayList<ArrayList<String>> ketQua = new ArrayList<ArrayList<String>>();
		for (int i = 0; i < dsHoaDonDaThanhToan.size(); i++) {
			
			LocalDate ngayLap = dsHoaDonDaThanhToan.get(i).getNgayLapHoaDon().toLocalDate();
			if (ngayLap.compareTo(ngayBatDau) >= 0 && ngayLap.compareTo(ngayKetThuc) <= 0) {
				ArrayList<String> row = new ArrayList<String>();
				row.add(dsHoaDonDaThanhToan.get(i).getMaHoaDon());
				row.add(dtf.format(dsHoaDonDaThanhToan.get(i).getNgayLapHoaDon().toLocalDate()));
				row.add(dsHoaDonDaThanhToan.get(i).getKhachHang().getTenKH());
				row.add(dsHoaDonDaThanhToan.get(i).getKhachHang().getSdt());
				row.add(dsHoaDonDaThanhToan.get(i).getNhanVien().getTenNV());
				row.add(df.format(dsHoaDonDaThanhToan.get(i).getTongTien()));
				ketQua.add(row);
			}
		}
		return sapXepTKHoaDonTangTheoNgayLap(ketQua);
	}
	
	private ArrayList<ArrayList<String>> getTKDoanhThuHoaDonTheoGio(ArrayList<HoaDon> dsHoaDonDaThanhToan) {
		ArrayList<ArrayList<String>> ketQua = new ArrayList<ArrayList<String>>();
		for (int i = 0; i < dsHoaDonDaThanhToan.size(); i++) {
			
			LocalDate ngayLap = dsHoaDonDaThanhToan.get(i).getNgayLapHoaDon().toLocalDate();
			if (ngayLap.compareTo(ngayBatDau) >= 0 && ngayLap.compareTo(ngayKetThuc) <= 0) {
				ArrayList<String> row = new ArrayList<String>();
				row.add(dsHoaDonDaThanhToan.get(i).getMaHoaDon());
				row.add(dtf.format(dsHoaDonDaThanhToan.get(i).getNgayLapHoaDon().toLocalDate()));
				row.add(dsHoaDonDaThanhToan.get(i).getKhachHang().getTenKH());
				row.add(dsHoaDonDaThanhToan.get(i).getKhachHang().getSdt());
				row.add(dsHoaDonDaThanhToan.get(i).getNhanVien().getTenNV());
				row.add(df.format(dsHoaDonDaThanhToan.get(i).getTongTien()));
				ketQua.add(row);
			}
		}
		return sapXepTKHoaDonTangTheoNgayLap(ketQua);
	}
	private ArrayList<ArrayList<String>> gopDuLieuTrungSoLuongVaDoanhThu(ArrayList<ArrayList<String>> dsTK, int viTriDoanhThu, int viTriSoLuong)
			throws NumberFormatException, ParseException {
		for (int i = 0; i < dsTK.size() - 1; i++) {
			double doanhThu = Double.parseDouble(df.parse(dsTK.get(i).get(viTriDoanhThu).toString()).toString());
			int soLuong = Integer.parseInt(dsTK.get(i).get(viTriSoLuong).toString());
			for (int j = i + 1; j < dsTK.size(); j++) {

				// Kiểm tra nếu bị trùng thì cộng dồn doanh thu và xóa phần tử trùng
				// 0 là vị trí mã phòng/dịch vụ trong dsTK
				if (dsTK.get(i).get(0).equals(dsTK.get(j).get(0))) {
					doanhThu += Double.parseDouble(df.parse(dsTK.get(j).get(viTriDoanhThu).toString()).toString());
					soLuong += Integer.parseInt(dsTK.get(j).get(viTriSoLuong).toString());
					dsTK.remove(j);
					j--;
				}
			}
			dsTK.get(i).set(viTriDoanhThu, df.format(doanhThu));
			dsTK.get(i).set(viTriSoLuong, soLuong + "");
		}
		return dsTK;
	}

	/**
	 * Sắp xếp danh sách thống kê doanh thu theo phòng/dịch vụ tăng dần theo mã
	 * phòng/dịch vụ.
	 * 
	 * @param dsTK: ds thống kê theo phòng/dịch vụ
	 * @return
	 */
	private ArrayList<ArrayList<String>> sapXepTKTangTheoMa(ArrayList<ArrayList<String>> dsTK) {
		ArrayList<ArrayList<String>> ketQua = new ArrayList<ArrayList<String>>();
		int soPhanTu = dsTK.size();
		if (soPhanTu > 0)
			for (int i = 0; i < soPhanTu; i++) {
				String maNhoNhat = dsTK.get(0).get(0);
				int rowNhoNhat = 0;
				for (int j = 0; j < dsTK.size(); j++) {
					String ma = dsTK.get(j).get(0);
					if (maNhoNhat.compareTo(ma) > 0) {
						maNhoNhat = ma;
						rowNhoNhat = j;
					}
				}
				ketQua.add(dsTK.get(rowNhoNhat));
				dsTK.remove(rowNhoNhat);
			}
		return ketQua;
	}

	/**
	 * Lấy danh sách thống kê doanh thu theo phòng trong khoảng thời gian từ ngày
	 * bắt đầu đến ngày kết thúc
	 * 
	 * @param dsHoaDonDaThanhToan
	 * @return danh sách thống kê doanh thu theo phòng
	 * @throws NumberFormatException
	 * @throws ParseException
	 */
	private ArrayList<ArrayList<String>> getTKDoanhThuSanPham(ArrayList<HoaDon> dsHoaDonDaThanhToan)
			throws NumberFormatException, ParseException {
		ArrayList<ArrayList<String>> ketQua = new ArrayList<ArrayList<String>>();
		for (int i = 0; i < dsHoaDonDaThanhToan.size(); i++) {
			ArrayList<ChiTietHoaDon> ds = dao_CTHD
					.getDSTheoMaHD(dsHoaDonDaThanhToan.get(i).getMaHoaDon());
			LocalDate ngayLap = dsHoaDonDaThanhToan.get(i).getNgayLapHoaDon().toLocalDate();
			if (ngayLap.compareTo(ngayBatDau) >= 0 && ngayLap.compareTo(ngayKetThuc) <= 0) {
				for (int j = 0; j < ds.size(); j++) {
					ArrayList<String> row = new ArrayList<String>();
					row.add(ds.get(j).getSanPham().getMaSanPham());
					row.add(ds.get(j).getSanPham().getTenSanPham());
					row.add(ds.get(j).getSoLuong()+ "");
					double tienBanDuoc = (ds.get(j).getSoLuong()) * (ds.get(j).getSanPham().getGiaBan());
					row.add(df.format(tienBanDuoc));
					ketQua.add(row);
				}
			}
		}
		
		
		return sapXepTKTangTheoMa(gopDuLieuTrungSoLuongVaDoanhThu(ketQua, 3, 2));
	}

	/**
	 * Lấy danh sách thống kê số lượng sản phẩm đã bán được.
	 * 
	 * @param dsHoaDonDaThanhToan
	 * @return danh sách thống kê số lượng sản phẩm bán
	 * @throws NumberFormatException
	 * @throws ParseException
	 */
	private ArrayList<ArrayList<String>> getTKSoLuongBanCuaLoaiSanPham(ArrayList<HoaDon> dsHoaDonDaThanhToan)
			throws NumberFormatException, ParseException {
		ArrayList<ArrayList<String>> ketQua = new ArrayList<ArrayList<String>>();
		for (int i = 0; i < dsHoaDonDaThanhToan.size(); i++) {
		
			ArrayList<ChiTietHoaDon> ds = dao_CTHD
					.getDSTheoMaHD(dsHoaDonDaThanhToan.get(i).getMaHoaDon());
			LocalDate ngayLap = dsHoaDonDaThanhToan.get(i).getNgayLapHoaDon().toLocalDate();
			if (ngayLap.compareTo(ngayBatDau) >= 0 && ngayLap.compareTo(ngayKetThuc) <= 0) {
				for (int j = 0; j < ds.size(); j++) {
					ArrayList<String> row = new ArrayList<String>();
					String maSP = ds.get(j).getSanPham().getMaSanPham();
					if(isSach(maSP)) {
						Sach s = dao_QuanLySach.getSachTheoMa(maSP);
						row.add(s.getLoaiSach().getMaLoaiSach());
						row.add(s.getLoaiSach().getTenLoai());
					}else {
						VanPhongPham s = dao_quanLyVPP.getVPPTheoMa(maSP);
						row.add(s.getLoaiVanPhongPham().getMaLoaiVPP());
						row.add(s.getLoaiVanPhongPham().getTenLoaiVPP());
					}
					row.add(ds.get(j).getSoLuong()+ "");
					double tienBanDuoc = (ds.get(j).getSoLuong()) * (ds.get(j).getSanPham().getGiaBan());
					row.add(df.format(tienBanDuoc));
					ketQua.add(row);
				}
			}
		}
		return sapXepTKTangTheoMa(gopDuLieuTrungSoLuongVaDoanhThu(ketQua, 3, 2));
	}

	/**
	 * Tạo mới một model
	 * 
	 * @param columns: các tên cột muốn tạo trong model
	 * @return model đã tạo với tên cột truyền vào tương ứng
	 */
	private DefaultTableModel taoModel(String columns[]) {
		DefaultTableModel model = new DefaultTableModel();
		for (int i = 0; i < columns.length; i++) {
			model.addColumn(columns[i]);
		}
		return model;
	}

	/**
	 * Load dữ liệu từ danh sách đưa vào lên model
	 * 
	 * @param column ds các tên cột
	 * @param ds
	 * @return model đã load dữ liệu
	 */
	private DefaultTableModel loadDataModel(String columns[], ArrayList<ArrayList<String>> ds) {
		DefaultTableModel model = taoModel(columns);
		for (int i = 0; i < ds.size(); i++) {
			ds.get(i).add(0, (i + 1) + "");
			model.addRow(ds.get(i).toArray());
		}
		return model;
	}

	private void setDataTable(DefaultTableModel model) {
		tblThongKe.setModel(model);
		if (model.getRowCount() == 0) {
			JOptionPane.showMessageDialog(null, "Chưa có dữ liệu!");
		}
	}

	private JFreeChart createChart(CategoryDataset dataset, String title, String categoryAxisLabel,
			String valueAxisLable) throws NumberFormatException, ParseException {
		JFreeChart barChart = ChartFactory.createBarChart(title, categoryAxisLabel, valueAxisLable, dataset,
				PlotOrientation.VERTICAL, false, false, false);
		return barChart;
	}

	/**
	 * Tạo dữ liệu cho biểu đồ hiển thị theo giờ làm việc của quán cho trường hợp
	 * thống kê doanh thu theo ngày.
	 * 
	 * @param dsTKDoanhThuHoaDon
	 * @return dữ liệu của biểu đồ thống kê doanh thu hóa đơn theo ngày.
	 * @throws NumberFormatException
	 * @throws ParseException
	 */
	private CategoryDataset createDatasetDoanhThuHoaDonTheoGio(ArrayList<ArrayList<String>> dsTKDoanhThuHoaDon)
			throws NumberFormatException, ParseException {
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		// Giờ làm việc là từ 8->24h
		// Tuy nhiên vào lúc 8h mới mở của kinh doanh chưa có hóa đơn nào ngay móc 8h
		// nên chỉ hiển thị biểu đồ từ 9h->24h
		for (int i = 6; i <= 21; i++) {
			double tongDoanhThuGio = 0;
			for (int j = 0; j < dsTKDoanhThuHoaDon.size(); j++) {
				HoaDon hd = dao_HoaDon
						.getHDTheoMaHD(dsTKDoanhThuHoaDon.get(j).get(0));
				LocalTime gioMua = hd.getNgayLapHoaDon().toLocalTime();
				LocalTime gioDau = LocalTime.of(i - 1, 0,0 );
				LocalTime gioCuoi;
				if (i == 21) {
					gioCuoi = LocalTime.of(i - 1, 59, 59);
				} else {
					gioCuoi = LocalTime.of(i, 0);
				}
				if (gioMua.compareTo(gioDau) > 0 && gioMua.compareTo(gioCuoi) <= 0) {
					tongDoanhThuGio += Double.parseDouble(df.parse(dsTKDoanhThuHoaDon.get(j).get(5)).toString());
				}
			}
			dataset.addValue(tongDoanhThuGio, "Doanh thu hóa đơn", i + "");
		}
		return dataset;
	}

	/**
	 * Tạo dữ liệu biểu đồ thống kê doanh thu hóa đơn của từng ngày trong tháng cho
	 * trường hợp thống kê doanh thu theo tháng
	 * 
	 * @param dsTKDoanhThuHoaDon
	 * @return dữ liệu biểu đồ thống kê doanh thu hóa đơn của từng ngày trong tháng
	 * @throws NumberFormatException
	 * @throws ParseException
	 */
	private CategoryDataset createDatasetDoanhThuHoaDonTheoNgay(ArrayList<ArrayList<String>> dsTKDoanhThuHoaDon)
			throws NumberFormatException, ParseException, UnsupportedOperationException {
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		LocalDate temp = ngayBatDau;
		while (temp.compareTo(ngayKetThuc) <= 0) {
			double tongDoanhThuNgay = 0;
			for (int i = 0; i < dsTKDoanhThuHoaDon.size(); i++) {
				if (dtf.format(temp).equals(dsTKDoanhThuHoaDon.get(i).get(1))) {
					tongDoanhThuNgay += Double.parseDouble(df.parse(dsTKDoanhThuHoaDon.get(i).get(5)).toString());
				}
			}
			dataset.addValue(tongDoanhThuNgay, "Doanh thu hóa đơn", temp.getDayOfMonth() + "");
			temp = temp.plusDays(1);
		}
		return dataset;
	}

	/**
	 * Tạo dữ liệu biểu đồ thống kê doanh thu hóa đơn của từng tháng trong năm cho
	 * trường hợp thống kê doanh thu hóa đơn theo năm.
	 * 
	 * @param dsTKDoanhThuHoaDon
	 * @return dữ liệu biểu đồ thống kê doanh thu hóa đơn của từng tháng trong năm
	 * @throws NumberFormatException
	 * @throws ParseException
	 */
	private CategoryDataset createDatasetDoanhThuHoaDonTheoThang(ArrayList<ArrayList<String>> dsTKDoanhThuHoaDon)
			throws NumberFormatException, ParseException, UnsupportedOperationException {
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		LocalDate temp = ngayBatDau;
		while (temp.compareTo(ngayKetThuc) <= 0) {
			double tongDoanhThuThang = 0;
			for (int i = 0; i < dsTKDoanhThuHoaDon.size(); i++) {
				LocalDate ngayLap = LocalDate.parse(dsTKDoanhThuHoaDon.get(i).get(1), dtf);
				if (temp.getMonthValue() == ngayLap.getMonthValue() && temp.getYear() == ngayLap.getYear()) {
					tongDoanhThuThang += Double.parseDouble(df.parse(dsTKDoanhThuHoaDon.get(i).get(5)).toString());
				}
			}
			dataset.addValue(tongDoanhThuThang, "Doanh thu hóa đơn", temp.getMonthValue() + "");
			temp = temp.plusMonths(1);
		}
		return dataset;
	}

	/**
	 * Lấy ra 10 phòng/dịch cụ có doanh thu cao nhất
	 * 
	 * @param dsTK:          danh sách thống kê doanh thu theo phòng/dịch vụ
	 * @param viTriDoanhThu: vị trí cột doanh thu trong dsTK
	 * @return 10 phòng/dịch vụ nếu dsTK.size()>=10, ngước lại số phòng/dịch vụ trả
	 *         về = dsTK.size()
	 * @throws NumberFormatException
	 * @throws ParseException
	 */
	private ArrayList<ArrayList<String>> getMuoiDoanhThuCaoNhat(ArrayList<ArrayList<String>> dsTK, int viTriDoanhThu)
			throws NumberFormatException, ParseException {
		ArrayList<ArrayList<String>> ketQua = new ArrayList<ArrayList<String>>();
		int soLuong = 0;
		int soPhanTu = dsTK.size();
		if (soPhanTu > 0)
			while (soLuong < 10 && soLuong < soPhanTu) {
				double tienCaoNhat = Double.parseDouble(df.parse(dsTK.get(0).get(viTriDoanhThu)).toString());
				int rowCaoNhat = 0;
				for (int i = 0; i < dsTK.size(); i++) {
					double doanhThu = Double.parseDouble(df.parse(dsTK.get(i).get(viTriDoanhThu)).toString());
					if (tienCaoNhat < doanhThu) {
						tienCaoNhat = doanhThu;
						rowCaoNhat = i;
					}
				}
				ketQua.add(dsTK.get(rowCaoNhat));
				dsTK.remove(rowCaoNhat);
				soLuong++;
			}
		return ketQua;
	}

	/**
	 * Tạo dữ liệu biểu đồ thống kê doanh thu theo phòng
	 * 
	 * @param dsTKDoanhThuPhong
	 * @return dữ liệu biểu đồ thống kê doanh thu theo phòng gồm 10 phòng có doanh
	 *         thu cao nhất
	 * @throws NumberFormatException
	 * @throws ParseException
	 */
	private CategoryDataset createDatasetDoanhThuLoaiSanPham(ArrayList<ArrayList<String>> dsTK)
			throws NumberFormatException, ParseException {
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		ArrayList<ArrayList<String>> dsMuoiDoanhThuCaoNhat = getMuoiDoanhThuCaoNhat(dsTK, 3);
		for (int i = 0; i < dsMuoiDoanhThuCaoNhat.size(); i++) {
			double doanhThuPhong = Double.parseDouble(df.parse(dsMuoiDoanhThuCaoNhat.get(i).get(3)).toString());
			dataset.addValue(doanhThuPhong, "Doanh thu loại sản phẩm", dsMuoiDoanhThuCaoNhat.get(i).get(0));
		}
		return dataset;
	}

	private CategoryDataset createDatasetDoanhThuTheoLoaiSanPham(ArrayList<ArrayList<String>> dsTKDoanhThuDichVu)
			throws NumberFormatException, ParseException {
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		ArrayList<ArrayList<String>> dsMuoiDoanhThuCaoNhat = getMuoiDoanhThuCaoNhat(dsTKDoanhThuDichVu, 3);
		for (int i = 0; i < dsMuoiDoanhThuCaoNhat.size(); i++) {
			double doanhThuDV = Double.parseDouble(df.parse(dsMuoiDoanhThuCaoNhat.get(i).get(3)).toString());
			dataset.addValue(doanhThuDV, "Doanh thu loại sản phẩm", dsMuoiDoanhThuCaoNhat.get(i).get(0));
		}
		return dataset;
	}

	private void setDataChartDoanhThuHoaDon() throws NumberFormatException, ParseException {
		if (cmbLuaChon.getSelectedItem().equals("Theo ngày")) {
			chartPanel
					.setChart(createChart(createDatasetDoanhThuHoaDonTheoGio(getTKDoanhThuHoaDonTheoGio(dsHoaDonDaThanhToan)),
							"BIỂU ĐỒ DOANH THU HÓA ĐƠN TRONG NGÀY", "Giờ", "Doanh thu hóa đơn"));
		} else {
			if (cmbLuaChon.getSelectedItem().equals("Theo tháng")) {
				chartPanel.setChart(
						createChart(createDatasetDoanhThuHoaDonTheoNgay(getTKDoanhThuHoaDon(dsHoaDonDaThanhToan)),
								"BIỂU ĐỒ DOANH THU HÓA ĐƠN TRONG THÁNG", "Ngày", "Doanh thu hóa đơn"));
			} else {
				chartPanel.setChart(
						createChart(createDatasetDoanhThuHoaDonTheoThang(getTKDoanhThuHoaDon(dsHoaDonDaThanhToan)),
								"BIỂU ĐỒ DOANH THU HÓA ĐƠN TRONG NĂM", "Tháng", "Doanh thu hóa đơn"));
			}
		}
	}

	private void setDataChartDoanhThuTheoSanPham() throws NumberFormatException, ParseException {
		if (cmbLuaChon.getSelectedItem().equals("Theo ngày")) {
			chartPanel.setChart(createChart(createDatasetDoanhThuLoaiSanPham(getTKDoanhThuSanPham(dsHoaDonDaThanhToan)),
					"BIỂU ĐỒ TOP 10 SẢN PHẨM CÓ DOANH THU CAO NHẤT THEO NGÀY", "Sản phẩm", "Doanh thu sản phẩm"));
		} else {
			if (cmbLuaChon.getSelectedItem().equals("Theo tháng")) {
				chartPanel.setChart(createChart(createDatasetDoanhThuLoaiSanPham(getTKDoanhThuSanPham(dsHoaDonDaThanhToan)),
						"BIỂU ĐỒ TOP 10 SẢN PHẨM CÓ DOANH THU CAO NHẤT THEO THÁNG", "Sản phẩm", "Doanh thu sản phẩm"));
			} else {
				chartPanel.setChart(createChart(createDatasetDoanhThuLoaiSanPham(getTKDoanhThuSanPham(dsHoaDonDaThanhToan)),
						"BIỂU ĐỒ TOP 10 SẢN PHẨM CÓ DOANH THU CAO NHẤT THEO NĂM", "Sản phẩm", "Doanh thu sản phẩm"));
			}
		}
		
	}

	private void setDataChartDoanhThuTheoLoaiSanPham() throws NumberFormatException, ParseException {
		if (cmbLuaChon.getSelectedItem().equals("Theo ngày")) {
			chartPanel.setChart(createChart(createDatasetDoanhThuTheoLoaiSanPham(getTKSoLuongBanCuaLoaiSanPham(dsHoaDonDaThanhToan)),
					"BIỂU ĐỒ TOP 10 LOẠI SẢN PHẨM CÓ LƯỢT BÁN CAO NHẤT THEO NGÀY", "Sản phẩm", "Số lượng bán"));
		} else {
			if (cmbLuaChon.getSelectedItem().equals("Theo tháng")) {
				chartPanel.setChart(createChart(createDatasetDoanhThuTheoLoaiSanPham(getTKSoLuongBanCuaLoaiSanPham(dsHoaDonDaThanhToan)),
						"BIỂU ĐỒ TOP 10 LOẠI SẢN PHẨM CÓ LƯỢT BÁN CAO NHẤT THEO THÁNG", "Sản phẩm", "Số lượng bán"));
			} else {
				chartPanel.setChart(createChart(createDatasetDoanhThuTheoLoaiSanPham(getTKSoLuongBanCuaLoaiSanPham(dsHoaDonDaThanhToan)),
						"BIỂU ĐỒ TOP 10 LOẠI SẢN PHẨM CÓ LƯỢT BÁN CAO NHẤT THEO NĂM", "Sản phẩm", "Số lượng bán"));
			}
		}
		
	}

	/**
	 * Cập nhật dữ liệu phần thống kê tổng quát cho cả 3 trường hợp thống kê doanh
	 * thu hóa đơn/phòng/dịch vụ
	 * 
	 * @param model
	 * @param viTriDoanhThu: vị trí cột doanh thu trong model
	 * @param textLabel      nội dung của các label hiển thị trong thống kê tổng
	 *                       quát
	 * @throws NumberFormatException
	 * @throws ParseException
	 */
	@SuppressWarnings("deprecation")
	private void setDataThongKeTongQuat(DefaultTableModel model, int viTriDoanhThu, String textLabel[])
			throws NumberFormatException, ParseException {
		if (model.getRowCount() == 0) {
			bThongKeTongQuat.hide();
		} else {
			double tongDoanhThu = 0;
			double tienCaoNhat = Double.parseDouble(df.parse(model.getValueAt(0, viTriDoanhThu).toString()).toString());
			double tienThapNhat = Double
					.parseDouble(df.parse(model.getValueAt(0, viTriDoanhThu).toString()).toString());
			int rowCaoNhat = 0;
			int rowThapNhat = 0;
			for (int i = 0; i < model.getRowCount(); i++) {
				double tienThanhToan = Double
						.parseDouble(df.parse(model.getValueAt(i, viTriDoanhThu).toString()).toString());
				tongDoanhThu += tienThanhToan;
				if (tienCaoNhat < tienThanhToan) {
					tienCaoNhat = tienThanhToan;
					rowCaoNhat = i;
				}
				if (tienThapNhat > tienThanhToan) {
					tienThapNhat = tienThanhToan;
					rowThapNhat = i;
				}
			}
			lblTongDoanhThu.setText(textLabel[0]);
			lblTongSo.setText(textLabel[1]);
			lblCaoNhat.setText(textLabel[2]);
			lblThapNhat.setText(textLabel[3]);

			txtTongDoanhThu.setText(df.format(tongDoanhThu));
			txtTongSo.setText(model.getRowCount() + "");
			txtCaoNhat.setText(model.getValueAt(rowCaoNhat, 1).toString());
			txtThapNhat.setText(model.getValueAt(rowThapNhat, 1).toString());

			bThongKeTongQuat.show();
		}
	}

	private void setAllData() {
		if (btnTongHoaDon.getBackground().equals(color3)) {
			String colums[] = { "STT", "Mã hóa đơn", "Ngày lập", "Khách hàng", "SĐT khách", "Nhân viên",
					"Tiền thanh toán" };
			String textLabel[] = { "Tổng doanh thu:", "Tổng số hóa đơn:", "Hóa đơn tiền cao nhất",
					"Hóa đơn tiền thấp nhất" };
			DefaultTableModel model = loadDataModel(colums, getTKDoanhThuHoaDon(dsHoaDonDaThanhToan));
			setDataTable(model);
			try {
				setDataThongKeTongQuat(model, 6, textLabel);
				setDataChartDoanhThuHoaDon();
			} catch (NumberFormatException | ParseException e) {
				e.printStackTrace();
			}
		} else {
			if (btnTheoSanPham.getBackground().equals(color3)) {
				String colums[] = { "STT", "Mã sản phẩm", "Tên sản phẩm", "Số lượng bán", "Tổng tiền" };
				String textLabel[] = { "Tổng doanh thu sản phẩm:", "Tổng số sản phẩm:", "Doanh thu cao nhất:",
						"Doanh thu thấp nhất:" };
				DefaultTableModel model;
				try {
					model = loadDataModel(colums, getTKDoanhThuSanPham(dsHoaDonDaThanhToan));
					setDataTable(model);
					setDataThongKeTongQuat(model, 4, textLabel);
					setDataChartDoanhThuTheoSanPham();
				} catch (NumberFormatException | ParseException e) {
					e.printStackTrace();
				}
			} else {
				if (btnTheoLoaiSanPham.getBackground().equals(color3)) {
					String colums[] = { "STT", "Mã loại sản phẩm", "Tên loại", "Số lượng", "Doanh thu" };
					String textLabel[] = { "Tổng doanh thu:", "Tổng số loại sản phẩm:", "Doanh thu cao nhất:",
							"Doanh thu thấp nhất:" };
					DefaultTableModel model;
					try {
						model = loadDataModel(colums, getTKSoLuongBanCuaLoaiSanPham(dsHoaDonDaThanhToan));
						setDataTable(model);
						setDataThongKeTongQuat(model, 4, textLabel);
						setDataChartDoanhThuTheoLoaiSanPham();
					} catch (NumberFormatException | ParseException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	private void setMauButton(JButton btn) {
		btn.setBackground(color3);
		btn.setForeground(Color.WHITE);
		if (!btn.equals(btnTongHoaDon)) {
			btnTongHoaDon.setBackground(Color.WHITE);
			btnTongHoaDon.setForeground(color1);
		}
		if (!btn.equals(btnTheoSanPham)) {
			btnTheoSanPham.setBackground(Color.WHITE);
			btnTheoSanPham.setForeground(color1);
		}
		if (!btn.equals(btnTheoLoaiSanPham)) {
			btnTheoLoaiSanPham.setBackground(Color.WHITE);
			btnTheoLoaiSanPham.setForeground(color1);
		}
	}

	private void showData() {
		LocalDate ngayLuaChon = dchLuaChonThoiGian.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate ngayHienTai = LocalDate.now();
		if (cmbLuaChon.getSelectedItem().equals("Theo ngày")) {
			ngayBatDau = ngayKetThuc = ngayLuaChon;
			setAllData();
		} else {
			if (cmbLuaChon.getSelectedItem().equals("Theo tháng")) {

				// Nếu người dùng chọn tháng hiện tại thì chỉ get tới ngày hiện tại, ngược lại
				// thì get hết các ngày của tháng được chọn
				if (ngayLuaChon.getMonthValue() == ngayHienTai.getMonthValue()
						&& ngayLuaChon.getYear() == ngayHienTai.getYear()) {
					ngayBatDau = LocalDate.of(ngayLuaChon.getYear(), ngayLuaChon.getMonthValue(), 1);
					ngayKetThuc = ngayHienTai;
				} else {
					ngayBatDau = LocalDate.of(ngayLuaChon.getYear(), ngayLuaChon.getMonthValue(), 1);
					ngayKetThuc = LocalDate.of(ngayLuaChon.getYear(), ngayLuaChon.getMonthValue(),
							ngayLuaChon.lengthOfMonth());
				}
				setAllData();
			} else {
				if (ngayLuaChon.getYear() == ngayHienTai.getYear()) {
					ngayBatDau = LocalDate.of(ngayLuaChon.getYear(), ngayLuaChon.getMonthValue(), 1);
					ngayKetThuc = ngayHienTai;
				} else {
					ngayBatDau = LocalDate.of(ngayLuaChon.getYear(), 1, 1);
					ngayKetThuc = LocalDate.of(ngayLuaChon.getYear(), 12, 31);
				}
				setAllData();
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(cmbLuaChon)) {
			if (cmbLuaChon.getSelectedItem().equals("Theo ngày")) {
				lblNhapLuaChon.setText("Chọn ngày:");
				dchLuaChonThoiGian.setDate(null);
				dchLuaChonThoiGian.setDateFormatString("dd/MM/yyyy");
			}
			if (cmbLuaChon.getSelectedItem().equals("Theo tháng")) {
				lblNhapLuaChon.setText("Chọn tháng:");
				dchLuaChonThoiGian.setDate(null);
				dchLuaChonThoiGian.setDateFormatString("MM/yyyy");
			}
			if (cmbLuaChon.getSelectedItem().equals("Theo năm")) {
				lblNhapLuaChon.setText("Chọn năm:");
				dchLuaChonThoiGian.setDate(null);
				dchLuaChonThoiGian.setDateFormatString("yyyy");
			}
		}
		if (o.equals(btnXacNhan)) {
			if (dchLuaChonThoiGian.getDate() == null) {
				if (cmbLuaChon.getSelectedItem().equals("Theo ngày")) {
					JOptionPane.showMessageDialog(this, "Bạn chưa chọn ngày thống kê!", "Lỗi",
							JOptionPane.ERROR_MESSAGE);
				} else {
					if (cmbLuaChon.getSelectedItem().equals("Theo tháng")) {
						JOptionPane.showMessageDialog(this, "Bạn chưa chọn tháng thống kê!", "Lỗi",
								JOptionPane.ERROR_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(this, "Bạn chưa chọn năm thống kê!", "Lỗi",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			} else {
				showData();
			}
		}
		if (o.equals(btnTongHoaDon)) {
			setMauButton(btnTongHoaDon);
			showData();
		}
		if (o.equals(btnTheoSanPham)) {
			setMauButton(btnTheoSanPham);
			showData();
		}
		if (o.equals(btnTheoLoaiSanPham)) {
			setMauButton(btnTheoLoaiSanPham);
			showData();
		}
		if (o.equals(btnBaoCao)) {
			if (btnTongHoaDon.getBackground().equals(color3)) {
				try {
					ArrayList<ArrayList<String>> dsLoad = getTKDoanhThuHoaDon(dsHoaDonDaThanhToan);
					JasperReport jasperReport = JasperCompileManager.compileReport("report/ThongKeHoaDon.jrxml");
					ArrayList<Map<String, String>> ds = new ArrayList<Map<String, String>>();
					Map<String, String> map = new HashMap<String, String>();
					map.put("ngayBatDau", dtf.format(ngayBatDau));
					map.put("ngayKetThuc", dtf.format(ngayKetThuc));
					double tongDoanhThu = 0;
					for (int i = 0; i < dsLoad.size(); i++) {
						if (i != 0) {
							map = new HashMap<String, String>();
						}
						map.put("stt", (i + 1) + "");
						map.put("maHD", dsLoad.get(i).get(0));
						map.put("ngayLap", dsLoad.get(i).get(1));
						map.put("khachHang", dsLoad.get(i).get(2));
						map.put("sdt", dsLoad.get(i).get(3));
						map.put("nhanVien", dsLoad.get(i).get(4));
						map.put("chietKhau", dsLoad.get(i).get(5));
						map.put("tienThanhToan", dsLoad.get(i).get(6));
						ds.add(map);
						try {
							tongDoanhThu += Double.parseDouble(df.parse(dsLoad.get(i).get(6).toString()).toString());
						} catch (NumberFormatException | ParseException e1) {
							e1.printStackTrace();
						}
					}
					map.put("tongDoanhThu", df.format(tongDoanhThu));
					map.put("ngayLapTK", dtf.format(LocalDate.now()));
					JRDataSource dataSource = new JRBeanCollectionDataSource(ds);
					JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource);
					JasperViewer.viewReport(jasperPrint, false);
				} catch (JRException e2) {
					e2.printStackTrace();
				}
			}
			if (btnTheoSanPham.getBackground().equals(color3)) {
				try {
					JasperReport jasperReport = JasperCompileManager.compileReport("report/ThongKeDoanhThuPhong.jrxml");
					ArrayList<Map<String, String>> ds = new ArrayList<Map<String, String>>();
					Map<String, String> map = new HashMap<String, String>();
					ArrayList<ArrayList<String>> dsLoad;
					try {
						dsLoad = getTKDoanhThuSanPham(dsHoaDonDaThanhToan);
						map.put("ngayBatDau", dtf.format(ngayBatDau));
						map.put("ngayKetThuc", dtf.format(ngayKetThuc));
						double tongDoanhThuPhong = 0;
						for (int i = 0; i < dsLoad.size(); i++) {
							if (i != 0) {
								map = new HashMap<String, String>();
							}
							map.put("stt", (i + 1) + "");
							map.put("maPhong", dsLoad.get(i).get(0));
							map.put("tenPhong", dsLoad.get(i).get(1));
							map.put("viTri", dsLoad.get(i).get(2));
							map.put("loaiPhong", dsLoad.get(i).get(3));
							map.put("doanhThu", dsLoad.get(i).get(4));
							ds.add(map);
							tongDoanhThuPhong += Double
									.parseDouble(df.parse(dsLoad.get(i).get(4).toString()).toString());
						}
						map.put("tongDoanhThuPhong", df.format(tongDoanhThuPhong));
						map.put("ngayLapTK", dtf.format(LocalDate.now()));
					} catch (NumberFormatException | ParseException e1) {
						e1.printStackTrace();
					}
					JRDataSource dataSource = new JRBeanCollectionDataSource(ds);
					JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource);
					JasperViewer.viewReport(jasperPrint, false);
				} catch (JRException e1) {
					e1.printStackTrace();
				}
			}
			if (btnTheoLoaiSanPham.getBackground().equals(color3)) {
				try {
					JasperReport jasperReport = JasperCompileManager
							.compileReport("report/ThongKeDoanhThuDichVu.jrxml");
					ArrayList<Map<String, String>> ds = new ArrayList<Map<String, String>>();
					Map<String, String> map = new HashMap<String, String>();
					ArrayList<ArrayList<String>> dsLoad;
					try {
						dsLoad = getTKSoLuongBanCuaLoaiSanPham(dsHoaDonDaThanhToan);
						map.put("ngayBatDau", dtf.format(ngayBatDau));
						map.put("ngayKetThuc", dtf.format(ngayKetThuc));
						double tongDoanhThuDV = 0;
						for (int i = 0; i < dsLoad.size(); i++) {
							if (i != 0) {
								map = new HashMap<String, String>();
							}
							map.put("stt", (i + 1) + "");
							map.put("maDV", dsLoad.get(i).get(0));
							map.put("tenDV", dsLoad.get(i).get(1));
							map.put("donVi", dsLoad.get(i).get(2));
							map.put("loaiDV", dsLoad.get(i).get(3));
							map.put("doanhThu", dsLoad.get(i).get(4));
							ds.add(map);
							tongDoanhThuDV += Double.parseDouble(df.parse(dsLoad.get(i).get(4).toString()).toString());
						}
						map.put("tongDoanhThuDV", df.format(tongDoanhThuDV));
						map.put("ngayLapTK", dtf.format(LocalDate.now()));
					} catch (NumberFormatException | ParseException e1) {
						e1.printStackTrace();
					}
					JRDataSource dataSource = new JRBeanCollectionDataSource(ds);
					JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource);
					JasperViewer.viewReport(jasperPrint, false);
				} catch (JRException e1) {
					e1.printStackTrace();
				}

			}

		}
	}
	//Kiểm tra văn phòng phẩm
	public boolean isVanPhongPham(String maSP) {
		return maSP.startsWith("VPP");
	}

	//Kiểm tra sách
	public boolean isSach(String maSP) {
		return maSP.startsWith("SAH");
	}
}
