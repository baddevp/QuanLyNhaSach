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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

import connectDB.ConnectDB;
import dao.DAO_KhachHang;
import entity.KhachHang;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class GuiQuanLyKhachHang extends JFrame implements ActionListener, MouseListener{

	public static JPanel contentPane;
	private JTextField txtMaKH;
	private JTextField txtTenKH;
	JTextField txtSDT;
	private JTextField txtNgayLap;
	private JTextField txtDiaChi;
	private JTextField txtDTL;
	private JTextField txtEmail;
	private JTextField txtTimKiem;
	private DefaultTableModel modelKH;
	private JTable tblKH;
	private JTextField txtTrangThai;
	private DAO_KhachHang khachhang_dao;
	private JButton btnDatLai;
	private JButton btnLuu;
	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnThem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiQuanLyKhachHang frame = new GuiQuanLyKhachHang();
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
	public GuiQuanLyKhachHang() {
		this.setTitle("Quản lý khách hàng");
		this.setSize(1930, 1030);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); // Toàn màn hình
		this.setLocationRelativeTo(null);
		//this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(51, 204, 204));
		// Kiểu chữ
		Font font1 = new Font("Times New Roman", Font.BOLD, 36);
		Font font2 = new Font("Times New Roman", Font.PLAIN, 24);
		Font font3 = new Font("Times New Roman", Font.PLAIN, 18);
		

		// Màu chữ
		Color color1 = new Color(138, 43, 226); // BlueViolet
		Color color2 = new Color(233, 221, 244);
	
		//Tiêu đề
		JPanel pnlTieuDe = new JPanel();
		pnlTieuDe.setBounds(10, 10, 1894, 60);
		pnlTieuDe.setBackground(new Color(255, 255, 255));
		contentPane.add(pnlTieuDe);
		
		JLabel lblTieuDe = new JLabel("QUẢN LÝ KHÁCH HÀNG");
		lblTieuDe.setBackground(new Color(51, 204, 255));
		pnlTieuDe.add(lblTieuDe);
		lblTieuDe.setFont(font1);
		lblTieuDe.setForeground(new Color(0, 204, 204));
		
		JPanel pnlThongTinKH = new JPanel();
		pnlThongTinKH.setBackground(new Color(255, 255, 255));
		
		pnlThongTinKH.setBorder(BorderFactory.createTitledBorder("Thông tin khách hàng"));
		pnlThongTinKH.setBounds(10, 80, 1894, 280);
		contentPane.add(pnlThongTinKH);
		pnlThongTinKH.setLayout(null);
		
		JLabel lblMaKH = new JLabel("Mã khách hàng:");
		lblMaKH.setBounds(148, 38, 163, 29);
		pnlThongTinKH.add(lblMaKH);
		lblMaKH.setFont(font2);
		
		JLabel lblTenKH = new JLabel("Tên khách hàng :");
		lblTenKH.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblTenKH.setBounds(681, 38, 187, 29);
		pnlThongTinKH.add(lblTenKH);
		
		JLabel lblSDT = new JLabel("Số điện thoại :");
		lblSDT.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblSDT.setBounds(1271, 38, 163, 29);
		pnlThongTinKH.add(lblSDT);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblEmail.setBounds(148, 118, 163, 29);
		pnlThongTinKH.add(lblEmail);
		
		JLabel lblDiaChi = new JLabel("Địa chỉ :");
		lblDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblDiaChi.setBounds(681, 118, 163, 29);
		pnlThongTinKH.add(lblDiaChi);
		
		JLabel lblNgayLap = new JLabel("Ngày lập :");
		lblNgayLap.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblNgayLap.setBounds(1271, 118, 163, 29);
		pnlThongTinKH.add(lblNgayLap);
		
		JLabel lblDTL = new JLabel("Điểm tích lũy :");
		lblDTL.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblDTL.setBounds(148, 224, 163, 29);
		pnlThongTinKH.add(lblDTL);
		
		txtMaKH = new JTextField();
		txtMaKH.setEditable(false);
		txtMaKH.setBounds(148, 78, 442, 34);
		pnlThongTinKH.add(txtMaKH);
		txtMaKH.setColumns(10);
		
		txtTenKH = new JTextField();
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(681, 78, 442, 34);
		pnlThongTinKH.add(txtTenKH);
		
		txtSDT = new JTextField();
		txtSDT.setColumns(10);
		txtSDT.setBounds(1271, 73, 442, 34);
		pnlThongTinKH.add(txtSDT);
		
		//Hiển thị ngày hiện hành trên txtNgayLap
		java.util.Date currentDate = new java.util.Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormat.format(currentDate);
        
		txtNgayLap = new JTextField(formattedDate);
		txtNgayLap.setEditable(false);
		txtNgayLap.setColumns(10);
		txtNgayLap.setBounds(1271, 165, 442, 34);
		pnlThongTinKH.add(txtNgayLap);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(681, 165, 442, 34);
		pnlThongTinKH.add(txtDiaChi);
		
		txtDTL = new JTextField();
		txtDTL.setEditable(false);
		txtDTL.setColumns(10);
		txtDTL.setBounds(305, 218, 285, 41);
		pnlThongTinKH.add(txtDTL);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(148, 158, 442, 41);
		pnlThongTinKH.add(txtEmail);
		
		JPanel pnlTacVu = new JPanel();
		pnlTacVu.setBackground(Color.white);
		pnlTacVu.setBounds(10, 370, 1894, 80);
		pnlTacVu.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ:"));
		contentPane.add(pnlTacVu);
		pnlTacVu.setLayout(null);
		
		btnThem = new JButton("Thêm");
		btnThem.setBounds(100, 21, 180, 48);
		pnlTacVu.add(btnThem);
		btnThem.setFont(font2);
		btnThem.setIcon(new ImageIcon(GuiQuanLyKhachHang.class.getResource("/image/TacVu_Them1.png")));
		btnThem.setBackground(Color.WHITE);
		
		btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnSua.setBounds(320, 21, 180, 48);
		pnlTacVu.add(btnSua);
		btnSua.setIcon(new ImageIcon(GuiQuanLyKhachHang.class.getResource("/image/TacVu_Sua.png")));
		btnSua.setBackground(Color.WHITE);
		
		btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnXoa.setBounds(550, 21, 180, 48);
		pnlTacVu.add(btnXoa);
		btnXoa.setIcon(new ImageIcon(GuiQuanLyKhachHang.class.getResource("/image/TacVu_Xoa1.png")));
		btnXoa.setBackground(Color.WHITE);
		
		btnLuu = new JButton("Lưu");
		btnLuu.setEnabled(false);
		btnLuu.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnLuu.setBounds(780, 21, 180, 48);
		pnlTacVu.add(btnLuu);
		btnLuu.setIcon(new ImageIcon(GuiQuanLyKhachHang.class.getResource("/image/TacVu_Luu.png")));
		btnLuu.setBackground(Color.WHITE);
		
		btnDatLai = new JButton("Đặt lại");
		btnDatLai.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnDatLai.setBounds(1010, 21, 180, 48);
		pnlTacVu.add(btnDatLai);
		btnDatLai.setIcon(new ImageIcon(GuiQuanLyKhachHang.class.getResource("/image/TacVu_DatLai.png")));
		btnDatLai.setBackground(Color.WHITE);
		
		JPanel pnlTacVuCon = new JPanel();
		pnlTacVuCon.setBackground(Color.white);;
		pnlTacVuCon.setBounds(1286, 11, 598, 58);
		pnlTacVuCon.setBorder(BorderFactory.createTitledBorder("Tìm kiếm theo : "));
		pnlTacVu.add(pnlTacVuCon);
		pnlTacVuCon.setLayout(null);
		
		txtTimKiem = new JTextField("Nhập thông tin cần tìm");
		txtTimKiem.setBounds(280, 13, 308, 36);
		pnlTacVuCon.add(txtTimKiem);
		txtTimKiem.setColumns(10);
		
		JRadioButton radSDT = new JRadioButton("Số điện thoại");
		radSDT.setBackground(new Color(255, 255, 255));
		radSDT.setBounds(133, 12, 109, 23);
		pnlTacVuCon.add(radSDT);

		
		JRadioButton radTenKH = new JRadioButton("Tên khách hàng");
		radTenKH.setBackground(new Color(255, 255, 255));
		radTenKH.setBounds(133, 30, 126, 23);
		pnlTacVuCon.add(radTenKH);
		
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
		
		ButtonGroup group = new ButtonGroup();
		group.add(radTenKH);
		group.add(radSDT);
		
		JPanel pnlBangKH = new JPanel();
		pnlBangKH.setBounds(10, 460, 1894, 480);
		contentPane.add(pnlBangKH);
		pnlBangKH.setBorder(BorderFactory.createTitledBorder("Bảng thông tin khách hàng"));
		pnlBangKH.setLayout(null);
		
		

		pnlBangKH.setBackground(Color.white);
		modelKH = new DefaultTableModel();
		modelKH.addColumn("Mã khách hàng");
		modelKH.addColumn("Tên khách hàng");
		modelKH.addColumn("Số điện thoại");
		modelKH.addColumn("Địa chỉ");
		modelKH.addColumn("Email");
		modelKH.addColumn("Ngày lập");
		modelKH.addColumn("Điểm tích lũy");
		tblKH = new JTable(modelKH);
		tblKH.setBackground(new Color(153, 204, 255));
		JScrollPane jScrollPane = new JScrollPane(tblKH);
		jScrollPane.setBounds(10, 20, 1865, 445);
		JTableHeader tbHeaderKH = tblKH.getTableHeader();
		tbHeaderKH.setFont(font2);
		tbHeaderKH.setBackground(new Color(51, 204, 204));
		pnlBangKH.setLayout(null);
		tblKH.setFont(font2);
		tblKH.setRowHeight(35);
		pnlBangKH.add(jScrollPane);
		
		txtTrangThai = new JTextField("Không có hoạt động nào gần nhất");
		txtTrangThai.setEditable(false);
		txtTrangThai.setForeground(Color.red);
		txtTrangThai.setHorizontalAlignment(SwingConstants.CENTER);
		txtTrangThai.setBounds(10, 950, 1894, 20);
		contentPane.add(txtTrangThai);
		txtTrangThai.setColumns(10);
		
		//
		tblKH.addMouseListener(this);
		btnDatLai.addActionListener(this);
		btnLuu.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoa.addActionListener(this);
		btnThem.addActionListener(this);
		
		
		//kết nối 
		khachhang_dao = new DAO_KhachHang();
		try {
			ConnectDB.getInstance().connect();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		// xử lí
		DocDuLieuDatabase();
		txtDTL.setText("0");
		
		hienThiMaKH();
		
		txtTimKiem.addKeyListener((KeyListener) new KeyAdapter() {
		    @Override
		    public void keyReleased(KeyEvent e) {
		        String tuKhoa = txtTimKiem.getText().trim();
		        timKiem(tuKhoa);
		    }
		}); 

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnDatLai)) {
			xoaRong();
		}
		if (o.equals(btnThem)) {
			themKH();
		}
		if (o.equals(btnXoa)) {
			xoa();
		}
		if (o.equals(btnSua)) {
			btSua();
		}
		if (o.equals(btnLuu)) {
			updateKH();
		}
	}
	
	private void DocDuLieuDatabase() {
		khachhang_dao = new DAO_KhachHang();
		for (KhachHang kh : khachhang_dao.getAllKH()) {
			modelKH.addRow(new Object[] {kh.getMaKH(), kh.getTenKH(), kh.getSdt(), kh.getDiaChi(), kh.getEmail(),
					                     kh.getNgayLap(), kh.getDiemTL()});
		}
	}
	
	public void xoaRong() {
		txtDiaChi.setText("");
		txtDTL.setText("");
		//txtTrangThai.setText("");
		txtEmail.setText("");
		txtNgayLap.setText("");
		txtTenKH.setText("");
		txtTimKiem.setText("");
		txtSDT.setText("");
		txtDTL.setText("0");
		java.util.Date currentDate = new java.util.Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormat.format(currentDate);
        txtNgayLap.setText(formattedDate);
        hienThiMaKH();
        txtDiaChi.setEditable(true);
		txtTenKH.setEditable(true);
		txtEmail.setEditable(true);
		txtSDT.setEditable(true);
		
		btnSua.setEnabled(true);
        btnLuu.setEnabled(false);
		
	}
	
	// hàm phát sinh mã tự động
	private String generateMaKH() {
	    try {
	        // Format selected date to get the part of the ID
	        java.util.Date currentDate = new java.util.Date();
	        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
	        String formattedDate = dateFormat.format(currentDate);

	        // Get the current sequence number from the database
	        int sequenceNumber = khachhang_dao.getCurrentSequenceNumber();

	        // Increase the sequence number
	        sequenceNumber++;

	        // Format the sequence number with leading zeros
	        String sequencePart = String.format("%03d", sequenceNumber);

	        // Combine date part and sequence part to form the ID
	        return "KH" + formattedDate + sequencePart;
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return "";
	}
	
	//hàm hiện thị mã lên txtMaKH
	private void hienThiMaKH() {
	    String maKH = generateMaKH(); // Generate the ID based on the date
	    txtMaKH.setText(maKH);
	}

	private void themKH() {
	    String maKH = txtMaKH.getText();
	    String tenKH = txtTenKH.getText();
	    String diaChi = txtDiaChi.getText();
	    String sdt = txtSDT.getText();
	    int diemTL = Integer.parseInt(txtDTL.getText());
	    String email = txtEmail.getText();

	    // Lấy ngày hiện tại
	    java.util.Date ngayLapUtil = new java.util.Date();
	    java.sql.Date ngayLap = new java.sql.Date(ngayLapUtil.getTime());

	    // Kiểm tra các trường dữ liệu không được để trống
	    if (tenKH.isEmpty() || sdt.isEmpty() || diaChi.isEmpty() || email.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");
	        return;
	    }

	    // Tạo đối tượng KhachHang
	    KhachHang kh = new KhachHang(maKH, tenKH, diaChi, sdt, diemTL, ngayLap, email);

	    // Thực hiện thêm vào database
	    if (khachhang_dao.createKH(kh)) {
	        modelKH.addRow(new Object[]{kh.getMaKH(), kh.getTenKH(), kh.getSdt(), kh.getDiaChi(), kh.getEmail(),
	                kh.getNgayLap(), kh.getDiemTL()});
	        JOptionPane.showMessageDialog(this, "Thêm khách hàng thành công");
	        txtTrangThai.setText("Thêm khách hàng " + tenKH + " thành công");
	        xoaRong();
	    } else {
	        JOptionPane.showMessageDialog(this, "Không thành công");
	        txtTrangThai.setText("Thêm khách hàng không thành công");
	    }
	}
	
	//
	public void xoa() {
		int row = tblKH.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(this, "Hãy chọn màu sắc cần xoá");
		} else {
			int tl;
			tl = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa màu sắc này không ?", "Cảnh báo",
					JOptionPane.YES_OPTION);
			if (tl == JOptionPane.YES_OPTION) {
				int index = tblKH.getSelectedRow();
				khachhang_dao.xoaKH(modelKH.getValueAt(tblKH.getSelectedRow(), 0).toString());
				modelKH.removeRow(index);
				txtTrangThai.setText("Xóa khách hàng thành công");
				xoaRong();
			}
		}
	}
	
	private void btSua() {
		int row = tblKH.getSelectedRow();
	    if (row == -1) {
	        JOptionPane.showMessageDialog(this, "Hãy chọn chức vụ cần sửa");
	    } else {
	        txtTenKH.requestFocus();
	        btnSua.setEnabled(false); // Disable the "Sửa" button
	        btnLuu.setEnabled(true);
	        
	        txtDiaChi.setEditable(true);
			txtTenKH.setEditable(true);
			txtEmail.setEditable(true);
			txtSDT.setEditable(true);
	    }
	}
	
	private void updateKH() {
	    // Get the updated information from the GUI components
	    String maKH = txtMaKH.getText();
	    String tenKH = txtTenKH.getText();
	    String diaChi = txtDiaChi.getText();
	    String sdt = txtSDT.getText();
	    int diemTL = Integer.parseInt(txtDTL.getText());
	    String email = txtEmail.getText();
	    
	    java.util.Date ngayLapUtil = new java.util.Date();
	    java.sql.Date ngayLap = new java.sql.Date(ngayLapUtil.getTime());

	    // Create a new KhachHang object with the updated information
	    KhachHang kh = new KhachHang(maKH, tenKH, diaChi, sdt, diemTL, ngayLap, email); 

	    // Call the DAO method to update the KhachHang in the database
	    boolean result = khachhang_dao.updateKH(kh);

	    // Check the result and show appropriate messages
	    if (result) {
	        JOptionPane.showMessageDialog(this, "Cập nhật thông tin khách hàng thành công");
	        // Update the corresponding row in the table
	        int selectedRow = tblKH.getSelectedRow();
	        modelKH.setValueAt(tenKH, selectedRow, 1);
	        modelKH.setValueAt(sdt, selectedRow, 2);
	        modelKH.setValueAt(diaChi, selectedRow, 3);
	        modelKH.setValueAt(email, selectedRow, 4);
	        modelKH.setValueAt(diemTL, selectedRow, 6);
	        modelKH.setValueAt(ngayLap, selectedRow, 5);

	        // Reset the form and button states
	        xoaRong();
	        btnSua.setEnabled(true);
	        btnLuu.setEnabled(false);
	    } else {
	        JOptionPane.showMessageDialog(this, "Cập nhật thông tin khách hàng không thành công");
	        txtTrangThai.setText("Cập nhật thông tin khách hàng không thành công");
	    }
	}
	
	private void timKiem(String tuKhoa) {
	    TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelKH);
	    tblKH.setRowSorter(sorter);

	    if (tuKhoa.isEmpty()) {
	        sorter.setRowFilter(null);
	    } else {
	        RowFilter<DefaultTableModel, Object> filter = RowFilter.regexFilter("(?i)" + Pattern.quote(tuKhoa), 2, 1);
	        // 2 corresponds to the column index of "Số điện thoại"
	        // 1 corresponds to the column index of "Tên khách hàng"
	        sorter.setRowFilter(filter);
	    }
	}
	
	

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = 	tblKH.getSelectedRow();
		txtMaKH.setText(tblKH.getValueAt(row, 0).toString());
		txtTenKH.setText(tblKH.getValueAt(row, 1).toString());
		txtSDT.setText(tblKH.getValueAt(row, 2).toString());
		txtEmail.setText(tblKH.getValueAt(row, 4).toString());
		txtDiaChi.setText(tblKH.getValueAt(row, 3).toString());
		txtNgayLap.setText(tblKH.getValueAt(row, 5).toString());
		txtDTL.setText(tblKH.getValueAt(row, 6).toString());
		
		txtDiaChi.setEditable(false);
		txtTenKH.setEditable(false);
		txtEmail.setEditable(false);
		txtSDT.setEditable(false);
		
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
