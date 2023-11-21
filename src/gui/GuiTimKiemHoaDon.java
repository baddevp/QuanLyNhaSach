package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import java.awt.ScrollPane;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import connectDB.ConnectDB;
import dao.DAO_HoaDon;
import entity.HoaDon;

public class GuiTimKiemHoaDon extends JFrame implements ActionListener {

	public static JPanel contentPane;
	private JTextField txtNhap;
	
	private JTable table;
	private DefaultTableModel modelHD;
	private JTable tblHD;
	private DAO_HoaDon hoadon_dao;
	private JComboBox cmbLoc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiTimKiemHoaDon frame = new GuiTimKiemHoaDon();
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
	public GuiTimKiemHoaDon() {
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
		pnlTieuDe.setBounds(15, 15, 1889, 60);
		pnlTieuDe.setBackground(new Color(255, 255, 255));
		contentPane.add(pnlTieuDe);
		
		JLabel lblTieuDe = new JLabel("TÌM KIẾM HÓA ĐƠN");
		lblTieuDe.setBackground(new Color(51, 204, 255));
		pnlTieuDe.add(lblTieuDe);
		lblTieuDe.setFont(font1);
		lblTieuDe.setForeground(new Color(0, 204, 204));;
		
		JPanel pnlChucNang = new JPanel();
		pnlChucNang.setBounds(15, 90, 1889, 90);
		contentPane.add(pnlChucNang);
		pnlChucNang.setBackground(Color.white);
		pnlChucNang.setBorder(BorderFactory.createTitledBorder("Tìm kiếm: "));
		pnlChucNang.setLayout(null);
		
		txtNhap = new JTextField("Nhập thông tin cần tìm");
		txtNhap.setBounds(348, 22, 1026, 48);
		txtNhap.setFont(font2);
		pnlChucNang.add(txtNhap);
		txtNhap.setColumns(10);
				
				txtNhap.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtNhap.getText().equals("Nhập thông tin cần tìm")) {
                    txtNhap.setText("");
                    txtNhap.setForeground(Color.BLACK); // Đổi màu chữ khi có focus
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtNhap.getText().isEmpty()) {
                    txtNhap.setText("Nhập thông tin cần tìm");
                    txtNhap.setForeground(Color.GRAY); // Đổi màu chữ gợi ý khi mất focus
                }
            }
        });
						
		JLabel lblNhap = new JLabel("Thông tin hóa đơn :");
		lblNhap.setBounds(80, 27, 258, 36);
		lblNhap.setFont(font2);
		pnlChucNang.add(lblNhap);
		
		cmbLoc = new JComboBox<>(new String[] {"Tất cả", "Đã thanh toán", "Chờ thanh toán"});
		cmbLoc.setBounds(1580, 22, 258, 46);
		pnlChucNang.add(cmbLoc);
		
		
		JLabel lblLoc = new JLabel("Lọc theo :");
		lblLoc.setBounds(1436, 22, 124, 48);
		lblLoc.setFont(font2);
		pnlChucNang.add(lblLoc);
		
		//Thể hiện danh sách tìm kiếm được
		JPanel pnlBangHD = new JPanel();
		pnlBangHD.setBounds(15, 191, 1889, 770);
		contentPane.add(pnlBangHD);
		pnlBangHD.setBorder(BorderFactory.createTitledBorder("Danh sách hóa đơn"));
		pnlBangHD.setLayout(null);
		
		
		pnlBangHD.setBackground(Color.white);
		modelHD = new DefaultTableModel();
		modelHD.addColumn("Mã hóa đơn");
		modelHD.addColumn("Ngày lập hóa đơn");
		modelHD.addColumn("Tiền nhận");
		modelHD.addColumn("Tổng tiền");
		modelHD.addColumn("Mã NV");
		modelHD.addColumn("Mã KH");
		modelHD.addColumn("Trạng thái");
		tblHD = new JTable(modelHD);
		JTableHeader tbHeaderHD = tblHD.getTableHeader();
		tbHeaderHD.setFont(font2);
		tbHeaderHD.setBackground(new Color(51, 204, 204));
		tblHD.setRowHeight(35);
		tblHD.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		tblHD.setBackground(new Color(153, 204, 255));
		tblHD.setBounds(815, 110, 1863, 0);
		pnlBangHD.setLayout(null);
		JScrollPane scrollPane = new JScrollPane(tblHD);
		scrollPane.setBounds(10, 24, 1869, 736);
		pnlBangHD.add(scrollPane);
		
		try {
			ConnectDB.getInstance().connect();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		hoadon_dao = new DAO_HoaDon();
		DocDuLieuDatataabase();
		
		txtNhap.addKeyListener((KeyListener) new KeyAdapter() {
		    @Override
		    public void keyReleased(KeyEvent e) {
		        String tuKhoa = txtNhap.getText().trim();
		        timKiem(tuKhoa);
		    }
		}); 
		
		cmbLoc.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            locTheoTrangThai();
	        }
	    });
		 cmbLoc.setSelectedItem("Tất cả");

		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	//
	public String strTrangThai(Boolean tt) {
		if (tt) {
			return "Đã thanh toán";
		}
		return "Chờ thanh toán";
	}
	//
	public void DocDuLieuDatataabase() {
		hoadon_dao = new DAO_HoaDon();
		for(HoaDon hd : hoadon_dao.getAllHD()) {
			modelHD.addRow(new Object[] {hd.getMaHoaDon(), hd.getNgayLapHoaDon(), hd.getTienNhan(), hd.getTongTien(), hd.getNhanVien().getTenNV(), hd.getKhachHang().getMaKH(), strTrangThai(hd.isTrangThai())});
		}
	}
	//
	private void timKiem(String tuKhoa) {
	    TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelHD);
	    tblHD.setRowSorter(sorter);

	    if (tuKhoa.isEmpty()) {
	        sorter.setRowFilter(null);
	    } else {
	        RowFilter<DefaultTableModel, Object> filter = RowFilter.regexFilter("(?i)" + Pattern.quote(tuKhoa), 0, 0);
	        sorter.setRowFilter(filter);
	    }
	}
	//
	private void locTheoTrangThai() {
	    TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelHD);
	    tblHD.setRowSorter(sorter);

	    // Lấy trạng thái được chọn từ JComboBox
	    String trangThaiChon = cmbLoc.getSelectedItem().toString();

	    // Kiểm tra và áp dụng điều kiện lọc
	    if (trangThaiChon.equals("Tất cả")) {
	        sorter.setRowFilter(null); // Hiển thị tất cả
	    } else {
	        // Lọc theo trạng thái đã thanh toán hoặc chưa thanh toán
	        boolean daThanhToan = trangThaiChon.equals("Đã thanh toán");
	        RowFilter<Object, Object> filter = new RowFilter<Object, Object>() {
	            @Override
	            public boolean include(Entry<? extends Object, ? extends Object> entry) {
	                String trangThaiCuaDong = entry.getStringValue(6); // Chỉ số 6 là cột trạng thái
	                return (daThanhToan && trangThaiCuaDong.equalsIgnoreCase("Đã thanh toán"))
	                        || (!daThanhToan && trangThaiCuaDong.equalsIgnoreCase("Chờ thanh toán"));
	            }
	        };
	        sorter.setRowFilter(filter);
	    }
	}
}
