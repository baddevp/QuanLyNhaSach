package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.toedter.calendar.JDateChooser;

import connectDB.ConnectDB;
import dao.DAO_ChucVu;
import dao.DAO_HinhAnh;
import dao.DAO_NhanVien;
import entity.ChucVu;
import entity.HinhAnh;
import entity.NhanVien;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class GuiQuanLyNhanVien extends JFrame implements ActionListener, MouseListener {

	public static JPanel contentPane;
	private JTextField txtMaNV;
	private JTextField txtTenNV;
	private JTextField txtCCCD;
	private JTextField txtSDT;
	private JTextField txtTimKiem;
	private DefaultTableModel modelKH;
	private JTable tblKH;
	private JTextField txtTrangThai;
	private JDateChooser dtmNgaySinh;
	private JDateChooser dtmNgayVaoLam;
	private JButton btnChonAnh;
	private JTextField txtDiaChi;
	private JButton btnDatLai;
	private JButton btnLuu;
	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnThem;
	private JComboBox cboChucVu;
	private JComboBox cboGioiTinh;
	private JLabel lblShowAnh;
	private DAO_HinhAnh hinhanh_dao;
	private DAO_NhanVien nhanvien_dao;
	private DAO_ChucVu chucvu_dao;
	private Date date1;
	private String selectedImagePath;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiQuanLyNhanVien frame = new GuiQuanLyNhanVien();
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
	public GuiQuanLyNhanVien() {
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
		Font font3 = new Font("Times New Roman", Font.PLAIN, 18);
		

		// Màu chữ
		Color color1 = new Color(138, 43, 226); // BlueViolet
		Color color2 = new Color(233, 221, 244);
	
		//Tiêu đề
		JPanel pnlTieuDe = new JPanel();
		pnlTieuDe.setBounds(10, 10, 1894, 60);
		pnlTieuDe.setBackground(new Color(255, 255, 255));
		contentPane.add(pnlTieuDe);
		
		JLabel lblTieuDe = new JLabel("QUẢN LÝ NHÂN VIÊN");
		lblTieuDe.setBackground(new Color(51, 204, 255));
		pnlTieuDe.add(lblTieuDe);
		lblTieuDe.setFont(font1);
		lblTieuDe.setForeground(new Color(0, 204, 204));
		
		JPanel pnlThongTinKH = new JPanel();
		pnlThongTinKH.setBackground(new Color(255, 255, 255));
		
		pnlThongTinKH.setBorder(BorderFactory.createTitledBorder("Thông tin nhân viên"));
		pnlThongTinKH.setBounds(10, 80, 1894, 280);
		contentPane.add(pnlThongTinKH);
		pnlThongTinKH.setLayout(null);
		
		JLabel lblMaNV = new JLabel("Mã nhân viên:");
		lblMaNV.setBounds(50, 35, 163, 30);
		pnlThongTinKH.add(lblMaNV);
		lblMaNV.setFont(font2);
		
		JLabel lblTenNV = new JLabel("Tên nhân viên :");
		lblTenNV.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblTenNV.setBounds(450, 35, 187, 29);
		pnlThongTinKH.add(lblTenNV);
		
		JLabel lblCCCD = new JLabel("CMT/ CCCD :");
		lblCCCD.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblCCCD.setBounds(850, 35, 163, 29);
		pnlThongTinKH.add(lblCCCD);
		
		JLabel lblSDT = new JLabel("Số điện thoại :");
		lblSDT.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblSDT.setBounds(450, 130, 163, 29);
		pnlThongTinKH.add(lblSDT);
		
		JLabel lblNgayVaoLam = new JLabel("Ngày vào làm :");
		lblNgayVaoLam.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblNgayVaoLam.setBounds(850, 130, 163, 29);
		pnlThongTinKH.add(lblNgayVaoLam);
		
		JLabel lblGioiTinh = new JLabel("Giới tính:");
		lblGioiTinh.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblGioiTinh.setBounds(50, 130, 102, 29);
		pnlThongTinKH.add(lblGioiTinh);
		
		txtMaNV = new JTextField();
		txtMaNV.setEditable(false);
		txtMaNV.setBounds(50, 80, 300, 35);
		pnlThongTinKH.add(txtMaNV);
		txtMaNV.setColumns(10);
		
		txtTenNV = new JTextField();
		txtTenNV.setColumns(10);
		txtTenNV.setBounds(450, 80, 300, 35);
		pnlThongTinKH.add(txtTenNV);
		
		txtCCCD = new JTextField();
		txtCCCD.setColumns(10);
		txtCCCD.setBounds(850, 80, 300, 35);
		pnlThongTinKH.add(txtCCCD);
		
		dtmNgayVaoLam = new JDateChooser();
		dtmNgayVaoLam.setBounds(850, 175, 300, 35);
		pnlThongTinKH.add(dtmNgayVaoLam);
		
		txtSDT = new JTextField();
		txtSDT.setColumns(10);
		txtSDT.setBounds(450, 175, 300, 35);
		pnlThongTinKH.add(txtSDT);
		
		dtmNgaySinh = new JDateChooser();
		dtmNgaySinh.setBounds(1250, 80, 300, 35);
		pnlThongTinKH.add(dtmNgaySinh);

		
		JLabel lblNgySinh = new JLabel("Ngày sinh :");
		lblNgySinh.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblNgySinh.setBounds(1250, 35, 163, 30);
		pnlThongTinKH.add(lblNgySinh);
		
		JPanel pnlAnhNhanVien = new JPanel();
		pnlAnhNhanVien.setBackground(new Color(255, 255, 255));
		pnlAnhNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlAnhNhanVien.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Ảnh nhân viên", TitledBorder.CENTER, TitledBorder.TOP, font2, new Color(0, 0, 0)));
		pnlAnhNhanVien.setBounds(1603, 11, 214, 258);
		pnlThongTinKH.add(pnlAnhNhanVien);
		pnlAnhNhanVien.setLayout(null);
		
		lblShowAnh = new JLabel("");
		lblShowAnh.setBounds(10, 26, 194, 221);
		pnlAnhNhanVien.add(lblShowAnh);
		
		btnChonAnh = new JButton("");
		btnChonAnh.setBounds(73, 90, 70, 70);
		pnlAnhNhanVien.add(btnChonAnh);
		btnChonAnh.setBackground(new Color(255, 255, 255));
		btnChonAnh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnChonAnh.setIcon(new ImageIcon(GuiQuanLyNhanVien.class.getResource("/image/ChonAnh.png")));
		
		JLabel lblDiaChi = new JLabel("Địa chỉ:");
		lblDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblDiaChi.setBounds(50, 239, 123, 30);
		pnlThongTinKH.add(lblDiaChi);
		
		cboGioiTinh = new JComboBox();
		cboGioiTinh.setBounds(50, 175, 299, 35);
		pnlThongTinKH.add(cboGioiTinh);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(142, 234, 1223, 35);
		pnlThongTinKH.add(txtDiaChi);
		
		cboChucVu = new JComboBox();
		cboChucVu.setBounds(1251, 175, 299, 35);
		pnlThongTinKH.add(cboChucVu);
		
		JLabel lblChcV = new JLabel("Chức vụ :");
		lblChcV.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblChcV.setBounds(1250, 130, 163, 29);
		pnlThongTinKH.add(lblChcV);
		
		
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
		btnThem.setIcon(new ImageIcon(GuiQuanLyNhanVien.class.getResource("/image/TacVu_Them1.png")));
		btnThem.setBackground(Color.WHITE);
		
		btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnSua.setBounds(320, 21, 180, 48);
		pnlTacVu.add(btnSua);
		btnSua.setIcon(new ImageIcon(GuiQuanLyNhanVien.class.getResource("/image/TacVu_Sua.png")));
		btnSua.setBackground(Color.WHITE);
		
		btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnXoa.setBounds(550, 21, 180, 48);
		pnlTacVu.add(btnXoa);
		btnXoa.setIcon(new ImageIcon(GuiQuanLyNhanVien.class.getResource("/image/TacVu_Xoa1.png")));
		btnXoa.setBackground(Color.WHITE);
		
		btnLuu = new JButton("Lưu");
		btnLuu.setEnabled(false);
		btnLuu.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnLuu.setBounds(780, 21, 180, 48);
		pnlTacVu.add(btnLuu);
		btnLuu.setIcon(new ImageIcon(GuiQuanLyNhanVien.class.getResource("/image/TacVu_Luu.png")));
		btnLuu.setBackground(Color.WHITE);
		
		btnDatLai = new JButton("Đặt lại");
		btnDatLai.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnDatLai.setBounds(1010, 21, 180, 48);
		pnlTacVu.add(btnDatLai);
		btnDatLai.setIcon(new ImageIcon(GuiQuanLyNhanVien.class.getResource("/image/TacVu_DatLai.png")));
		btnDatLai.setBackground(Color.WHITE);
		
		JPanel pnlTacVuCon = new JPanel();
		pnlTacVuCon.setBackground(Color.white);;
		pnlTacVuCon.setBounds(1286, 11, 598, 58);
		pnlTacVuCon.setBorder(BorderFactory.createTitledBorder("Tìm kiếm nhân viên : "));
		pnlTacVu.add(pnlTacVuCon);
		pnlTacVuCon.setLayout(null);
		
		txtTimKiem = new JTextField("Nhập thông tin cần tìm");
		txtTimKiem.setBounds(129, 15, 362, 32);
		pnlTacVuCon.add(txtTimKiem);
		txtTimKiem.setColumns(10);
		
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
		
		JPanel pnlBangKH = new JPanel();
		pnlBangKH.setBounds(10, 460, 1894, 480);
		contentPane.add(pnlBangKH);
		pnlBangKH.setBorder(BorderFactory.createTitledBorder("Bảng thông tin nhân viên"));
		pnlBangKH.setLayout(null);
		
		

		pnlBangKH.setBackground(Color.white);;
		modelKH = new DefaultTableModel();
		modelKH.addColumn("Mã nhân viên");
		modelKH.addColumn("Tên nhân viên");
		modelKH.addColumn("CCCD");
		modelKH.addColumn("Ngày Sinh");
		modelKH.addColumn("Số điện thoại");
		modelKH.addColumn("Địa chỉ");
		modelKH.addColumn("Ngày vào làm");
		tblKH = new JTable(modelKH);
		tblKH.setBackground(new Color(153, 204, 255));
		JScrollPane jScrollPane = new JScrollPane(tblKH);
		jScrollPane.setBounds(15, 15, 1869, 450);
		JTableHeader tbHeaderKH = tblKH.getTableHeader();
		tbHeaderKH.setFont(font2);
		tbHeaderKH.setBackground(new Color(51, 204, 204));
		pnlBangKH.setLayout(null);
		tblKH.setFont(font2);
		tblKH.setRowHeight(35);
		pnlBangKH.add(jScrollPane);
		
		txtTrangThai = new JTextField("Không có hoạt động nào gần nhất");
		txtTrangThai.setForeground(Color.red);
		txtTrangThai.setHorizontalAlignment(SwingConstants.CENTER);
		txtTrangThai.setBounds(10, 950, 1894, 20);
		contentPane.add(txtTrangThai);
		txtTrangThai.setColumns(10);
		
		btnDatLai.addActionListener(this);
		btnChonAnh.addActionListener(this);
		btnDatLai.addActionListener(this);
		btnThem.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoa.addActionListener(this);
		tblKH.addMouseListener(this);
		
		
		//
		DefaultComboBoxModel<String> gioiTinhModel = new DefaultComboBoxModel<>();

		// Add items to the model
		gioiTinhModel.addElement("Nam");
		gioiTinhModel.addElement("Nữ");
		
		// Set the model to the JComboBox
		cboGioiTinh.setModel(gioiTinhModel);
		
		// 
		
		try {
			ConnectDB.getInstance().connect();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		hinhanh_dao = new DAO_HinhAnh();
		nhanvien_dao = new DAO_NhanVien();
		chucvu_dao = new DAO_ChucVu();
		
		ArrayList<ChucVu> listTK = chucvu_dao.getAllCV();
		for(ChucVu cv : listTK) {
			cboChucVu.addItem(cv.getMaChucVu());
		}
		
        DocDuLieuDatabase();
		
		// khi chọn xong ngày vào làm thì txtMaNV sẽ hiện thị mã
		dtmNgayVaoLam.addPropertyChangeListener("date", e -> {
            // cập nhật mã lên txtMaNV
            hienThiMaKH();
        });

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnDatLai)) {
			xoaRong();
		}
		if (o.equals(btnChonAnh)) {
			chonAnh();
		}
		if (o.equals(btnThem)) {
			themNV();
		}
		if (o.equals(btnXoa)) {
			xoa();
		}
	}
	
	private void DocDuLieuDatabase() {
		nhanvien_dao = new DAO_NhanVien();
		tblKH.setRowHeight(25);
		for (NhanVien nv : nhanvien_dao.getAllNV()) {
				
			modelKH.addRow(new Object[] {nv.getMaNV(), nv.getTenNV(), nv.getCccd(), nv.getNgaySinh(),
                    nv.getSdt(),nv.getDiaChi(),nv.getNgayVaoLam()});
		}
	}
	
	private String generateMaNhanVien() {
		
		 java.util.Date selectedDate = dtmNgayVaoLam.getDate();

		    if (selectedDate != null) {
		        try {
		            // Format selected date to get the part of the ID
		            SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
		            String datePart = dateFormat.format(selectedDate);

		            // Get the current sequence number from the database
		            int sequenceNumber = nhanvien_dao.getCurrentSequenceNumber();

		            // Increase the sequence number
		            sequenceNumber++;

		            // Format the sequence number with leading zeros
		            String sequencePart = String.format("%03d", sequenceNumber);

		            // Combine date part and sequence part to form the ID
		            return "NV" + datePart + sequencePart;
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }
		    
		    return "";
    }
	
	//hàm hiện thị mã lên txtMaKH
	private void hienThiMaKH() {
	    String maNV = generateMaNhanVien(); // Generate the ID based on the date
	    txtMaNV.setText(maNV);
	}
	
	public void xoaRong() {
		lblShowAnh.setIcon(null);
		btnChonAnh.setVisible(true);
		hienThiMaKH();
		txtTenNV.setText("");
		txtDiaChi.setText("");
		txtCCCD.setText("");
		txtTimKiem.setText("");
		txtSDT.setText("");
		txtTenNV.requestFocus();
	}
	
	// Chọn ảnh
	public void chonAnh() {
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
	private void saveImageToDatabase() {

	      String maAnh = hinhanh_dao.generateNewMaHinhAnh();
	      String tenAnh = hinhanh_dao.generateNewTenHinhAnh();
	      String imagePath = lblShowAnh.getIcon() != null ? lblShowAnh.getIcon().toString() : "";

	      // Validate that required fields are not empty
	      if (maAnh.isEmpty() || tenAnh.isEmpty() || imagePath.isEmpty()) {
	          JOptionPane.showMessageDialog(this, "Please fill in all fields and choose an image.", 
	          		                              "Error", JOptionPane.ERROR_MESSAGE);
	          return;
	      }

	      // Use the image path obtained from choosing the image
	      imagePath = selectedImagePath;

	      // Create an instance of the HinhAnh class with the provided data
	      HinhAnh hinhAnh = new HinhAnh(maAnh, tenAnh, imagePath);

	      // Save the HinhAnh instance to the database
	      hinhanh_dao.themHinhAnh(hinhAnh);

	      // Display a success message
	      JOptionPane.showMessageDialog(this, "Image saved to the database successfully!");
	         
	   }
		
		  private void generateAndSetMaAnh() {
		      // Gọi hàm phát sinh mã từ DAO_HinhAnh
		      String newMaAnh = hinhanh_dao.generateNewMaHinhAnh();
		  } 
		  private void generateTenANh() {
		      // Gọi hàm phát sinh tên từ DAO_HinhAnh
		      String newTenAnh = hinhanh_dao.generateNewTenHinhAnh();
		  }
			
		  
		  public void themNV() {
			    try {
			        // Get values from the input fields
			        String maNV = txtMaNV.getText();
			        String tenNV = txtTenNV.getText();
			        String cccd = txtCCCD.getText();
			        java.util.Date ngaySinh = dtmNgaySinh.getDate();
			        String diaChi = txtDiaChi.getText();
			        String sdt = txtSDT.getText();
			        java.util.Date ngayVaoLam = dtmNgayVaoLam.getDate();
			        boolean gioiTinh = cboGioiTinh.getSelectedItem().equals("Nam"); // Assuming "Nam" is for male
			        String chucVu = cboChucVu.getSelectedItem().toString();
			        String maANh = hinhanh_dao.generateNewMaHinhAnh();
			        ChucVu maCV = new ChucVu(chucVu);
			        HinhAnh maIMG = new HinhAnh(maANh);
			        
			        
			        // Validate required fields
			        if (maNV.isEmpty() || tenNV.isEmpty() || cccd.isEmpty() || ngaySinh == null
			                || diaChi.isEmpty() || sdt.isEmpty() || ngayVaoLam == null || chucVu.isEmpty()) {
			            JOptionPane.showMessageDialog(this, "Please fill in all required fields.", "Error", JOptionPane.ERROR_MESSAGE);
			            return;
			        }
			        
			        // lưu ảnh vào csdl HINHANH
			        saveImageToDatabase();

			        // Create a new NhanVien object
			        NhanVien nhanVien = new NhanVien(maNV, tenNV, ngaySinh, diaChi, ngayVaoLam, sdt, cccd, gioiTinh, maCV, maIMG);

			        // Add the NhanVien to the database
			        if (nhanvien_dao.createNV(nhanVien)) {
			            // Refresh the table with the updated data
			            modelKH.setRowCount(0); // Clear the current rows
			            DocDuLieuDatabase(); // Reload data from the database

			            // Display a success message
			            JOptionPane.showMessageDialog(this, "Employee added successfully.");

			            // Clear input fields
			            xoaRong();
			        } else {
			            JOptionPane.showMessageDialog(this, "Failed to add employee.", "Error", JOptionPane.ERROR_MESSAGE);
			        }
			    } catch (Exception e) {
			        e.printStackTrace();
			        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			    }
			}
		  public void xoa() {
				int row = tblKH.getSelectedRow();
				if(row == -1) {
					JOptionPane.showMessageDialog(this, "Hãy chọn nhân viên cần xoá");
				} else {
					int tl;
					tl = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa nhân viên này không ?", "Cảnh báo",
							JOptionPane.YES_OPTION);
					if (tl == JOptionPane.YES_OPTION) {
						
						//xoá ảnh trong csdl HINHANH
						String maNV = modelKH.getValueAt(row, 0).toString();
						String maAnh = nhanvien_dao.getMaAnhByMaNV(maNV);
						HinhAnh hinhAnh = nhanvien_dao.getHinhAnhByMaAnh(maAnh);
						hinhanh_dao.xoaIMG(maAnh);
						
						//
						int index = tblKH.getSelectedRow();
						nhanvien_dao.xoaNV(modelKH.getValueAt(tblKH.getSelectedRow(), 0).toString());
						modelKH.removeRow(index);
						xoaRong();
					}
				}
			}		  


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = tblKH.getSelectedRow();
	    if (row >= 0) {
	        // Lấy thông tin nhân viên
	        String maNV = modelKH.getValueAt(row, 0).toString();

	        // Lấy thông tin ảnh từ cơ sở dữ liệu dựa trên mã nhân viên
	        String maAnh = nhanvien_dao.getMaAnhByMaNV(maNV); // Hàm này cần được thêm vào DAO_NhanVien

	        // Lấy thông tin ảnh từ cơ sở dữ liệu dựa trên mã ảnh
	        HinhAnh hinhAnh = nhanvien_dao.getHinhAnhByMaAnh(maAnh); // Hàm này cần được thêm vào DAO_NhanVien

	        // Hiển thị ảnh lên lblShowAnh
	        if (hinhAnh != null) {
	        	
	            ImageIcon icon = new ImageIcon(hinhAnh.getUrl());
	            Image img = icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
	            lblShowAnh.setIcon(new ImageIcon(img));
	        } else {
	            lblShowAnh.setIcon(null); // Nếu không tìm thấy ảnh, xóa ảnh trên lblShowAnh
	        }

	        // 
	        
	        txtMaNV.setText(modelKH.getValueAt(row, 0).toString());
	        txtTenNV.setText(modelKH.getValueAt(row, 1).toString());
	        txtCCCD.setText(modelKH.getValueAt(row, 2).toString());
	        txtDiaChi.setText(modelKH.getValueAt(row, 5).toString());
	        txtSDT.setText(modelKH.getValueAt(row, 4).toString());
	        
	        String ngaySinh = modelKH.getValueAt(row, 3).toString();
	        String ngayVaoLam = modelKH.getValueAt(row, 6).toString();
	        
	        java.util.Date date;
            try {
                date = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(ngaySinh);
                date1 = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(ngayVaoLam);
                dtmNgaySinh.setDate(date);
                dtmNgayVaoLam.setDate(date1);
            } catch (java.text.ParseException ex) {
                ex.printStackTrace();
            }
	        
	        //
            
	        dtmNgayVaoLam.setEnabled(false);
	        btnChonAnh.setVisible(false);
	        
	        String gioiTinh = nhanvien_dao.getGioiTinhByMaNV(maNV);
	        String chucvu = nhanvien_dao.getGioiTinhByMaCV(maNV);

	        // Đưa giới tính vào combobox
	        cboGioiTinh.setSelectedItem(gioiTinh);
	        cboChucVu.setSelectedItem(chucvu);
        
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
