package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connectDB.ConnectDB;
import dao.DAO_DangNhap;
import dao.DAO_NhanVien;
import dao.DAO_TaiKhoan;
import entity.NhanVien;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;

public class GuiDangNhap extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5304173256114139897L;
	private JPanel contentPane;
	JTextField txtTenDN;
	private JTextField txtQuenMK;
	private JTextField txtThongBao;
	private JPasswordField txtMK;
	private JTextField txtTDNDMK;
	private JTextField txtEmailDK;
	private JTextField txtVeDN;
	private JTextField txtThongBao2;
	private JButton btnDangNhap;
	private JButton btnThoat;
	private JLabel lblMatKhau;
	private JLabel lblDangNhap;
	private JLabel AnhDangNhap;
	private JButton btnXacNhan;
	private JLabel lblEmailDK;
	private Component lblTDNDMK;
	private JLabel lblDMK;
	private JPanel pnlRight;
	private JLabel AnhDoiMK;
	private JLabel lblTenDN;
	private JRadioButton radHienMK;
	private GuiTrangChu guiTrangChu;
	private DAO_NhanVien nhanvien_dao;
	private GuiBanHang guiBanHang;
	private DAO_TaiKhoan taikhoan_dao;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiDangNhap frame = new GuiDangNhap();
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
	public GuiDangNhap() {
		setBackground(new Color(255, 204, 102));
		setTitle("FutureZe - Phầm mềm quản lý nhà sách");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 562);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		try {
			ConnectDB.getInstance().connect();
		} catch (Exception e) {
			e.printStackTrace();
		}

		setContentPane(contentPane);
		contentPane.setLayout(null);
		/*Giao diên đăng nhập*/
		//Thiết lập ảnh bên phải
		pnlRight = new JPanel();
		pnlRight.setBackground(new Color(255, 255, 255));
		pnlRight.setBounds(10, 11, 399, 501);
		pnlRight.setLayout(null);	
		contentPane.add(pnlRight);
		
		lblDMK = new JLabel("ĐỔI MẬT KHẨU");
		lblDMK.setForeground(new Color(102, 204, 0));
		lblDMK.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblDMK.setHorizontalAlignment(SwingConstants.CENTER);
		lblDMK.setBounds(76, 25, 246, 67);
		pnlRight.add(lblDMK);
		
		lblTDNDMK = new JLabel("Tên đăng nhập :");
		lblTDNDMK.setForeground(new Color(102, 204, 0));
		lblTDNDMK.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTDNDMK.setBounds(40, 122, 144, 27);
		pnlRight.add(lblTDNDMK);
		
		txtTDNDMK = new JTextField();
		txtTDNDMK.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTDNDMK.setBounds(40, 160, 314, 36);
		pnlRight.add(txtTDNDMK);
		txtTDNDMK.setColumns(10);
		
		lblEmailDK = new JLabel("Email đăng ký :");
		lblEmailDK.setForeground(new Color(102, 204, 0));
		lblEmailDK.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEmailDK.setBounds(40, 221, 144, 27);
		pnlRight.add(lblEmailDK);
		
		txtEmailDK = new JTextField();
		txtEmailDK.setForeground(new Color(102, 204, 0));
		txtEmailDK.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtEmailDK.setColumns(10);
		txtEmailDK.setBounds(40, 259, 314, 36);
		pnlRight.add(txtEmailDK);
		
		btnXacNhan = new JButton("Xác nhận");
		btnXacNhan.setForeground(new Color(102, 204, 0));
		btnXacNhan.setBackground(new Color(255, 255, 255));
		btnXacNhan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnXacNhan.setBounds(137, 329, 125, 36);
		pnlRight.add(btnXacNhan);
		
		AnhDangNhap = new JLabel("AnhDangNhap");
		AnhDangNhap.setIcon(new ImageIcon(GuiDangNhap.class.getResource("/image/DangNhap.png")));
		AnhDangNhap.setBounds(0, 0, 399, 501);
		pnlRight.add(AnhDangNhap);
		//Thiết kê form nhập liệu
		JPanel pnlLeft = new JPanel();
		pnlLeft.setBackground(new Color(255, 255, 255));
		pnlLeft.setBounds(425, 11, 389, 501);
		contentPane.add(pnlLeft);
		pnlLeft.setLayout(null);
		
		lblDangNhap = new JLabel("ĐĂNG NHẬP");
		lblDangNhap.setForeground(new Color(153, 51, 0));
		lblDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblDangNhap.setBounds(118, 28, 217, 47);
		pnlLeft.add(lblDangNhap);
		
		lblTenDN = new JLabel("Tên đăng nhập :");
		lblTenDN.setForeground(new Color(153, 51, 0));
		lblTenDN.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTenDN.setBounds(52, 86, 132, 29);
		pnlLeft.add(lblTenDN);
		
		txtTenDN = new JTextField("NV14112023002");
		txtTenDN.setForeground(new Color(153, 51, 0));
		txtTenDN.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTenDN.setBounds(52, 135, 292, 37);
		pnlLeft.add(txtTenDN);
		txtTenDN.setColumns(10);
		
		lblMatKhau = new JLabel("Mật khẩu :");
		lblMatKhau.setForeground(new Color(153, 51, 0));
		lblMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMatKhau.setBounds(52, 197, 132, 29);
		pnlLeft.add(lblMatKhau);
		
		btnDangNhap = new JButton("Đăng nhập");
		btnDangNhap.setBackground(new Color(255, 255, 255));
		btnDangNhap.setForeground(new Color(153, 51, 0));
		btnDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDangNhap.setBounds(52, 309, 132, 37);
		pnlLeft.add(btnDangNhap);
		
		btnThoat = new JButton("Thoát");
		btnThoat.setBackground(new Color(255, 255, 255));
		btnThoat.setForeground(new Color(153, 51, 0));
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnThoat.setBounds(212, 309, 132, 37);
		pnlLeft.add(btnThoat);
		
		txtQuenMK = new JTextField();
		txtQuenMK.setEditable(false);
		txtQuenMK.setBackground(new Color(255, 255, 255));
		txtQuenMK.setForeground(new Color(51, 0, 255));
		txtQuenMK.setHorizontalAlignment(SwingConstants.CENTER);
		txtQuenMK.setText("Quên mật khẩu?");
		txtQuenMK.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtQuenMK.setBounds(106, 371, 192, 29);
		pnlLeft.add(txtQuenMK);
		txtQuenMK.setColumns(10);
		txtQuenMK.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtQuenMK.setFocusable(false);
		txtQuenMK.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				txtQuenMK.setForeground(Color.red);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				txtQuenMK.setForeground(new Color(30, 144, 255));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				thietLapGiaoDien(false);
				txtTDNDMK.setText(txtTenDN.getText());
				txtTDNDMK.setForeground(new Color(102, 204, 0));
				
			}
		});
		
		txtThongBao = new JTextField();
		txtThongBao.setHorizontalAlignment(SwingConstants.CENTER);
		txtThongBao.setBackground(new Color(255, 255, 255));
		txtThongBao.setEditable(false);
		txtThongBao.setForeground(new Color(255, 0, 0));
		txtThongBao.setBounds(63, 442, 292, 20);
		pnlLeft.add(txtThongBao);
		txtThongBao.setColumns(10);
		txtThongBao.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		txtMK = new JPasswordField("123456");
		txtMK.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtMK.setForeground(new Color(153, 51, 0));
		txtMK.setBounds(52, 237, 292, 37);
		pnlLeft.add(txtMK);
		
		radHienMK = new JRadioButton("");
		radHienMK.setBackground(new Color(255, 255, 255));
		radHienMK.setBounds(350, 237, 30, 37);
		radHienMK.setIcon(new ImageIcon(GuiDangNhap.class.getResource("/image/AnMK.png")));
		pnlLeft.add(radHienMK);
		radHienMK.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (radHienMK.isSelected()) {
					radHienMK.setIcon(new ImageIcon(GuiDangNhap.class.getResource("/image/HienMK.png")));
					txtMK.setEchoChar((char) 0);
					txtMK.setEchoChar((char) 0);
				} else if (radHienMK.isSelected() == false) {
					radHienMK.setIcon(new ImageIcon(GuiDangNhap.class.getResource("/image/AnMK.png")));
					txtMK.setEchoChar('*');
					txtMK.setEchoChar('*');
				}

			}
		});
		/*Giao diện đổi mật khẩu*/
		AnhDoiMK = new JLabel("AnhDoiMK");
		AnhDoiMK.setIcon(new ImageIcon(GuiDangNhap.class.getResource("/image/DoiMatKhau.png")));
		AnhDoiMK.setBounds(0, 0, 389, 501);
		pnlLeft.add(AnhDoiMK);
		
		txtVeDN = new JTextField();
		txtVeDN.setEditable(false);
		txtVeDN.setBackground(new Color(255, 255, 255));
		txtVeDN.setForeground(new Color(51, 0, 255));
		txtVeDN.setHorizontalAlignment(SwingConstants.CENTER);
		txtVeDN.setText("Về đăng nhập?");
		txtVeDN.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtVeDN.setBounds(97, 392, 192, 29);
		pnlRight.add(txtVeDN);
		txtVeDN.setColumns(10);
		txtVeDN.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtVeDN.setFocusable(false);
		txtVeDN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				txtVeDN.setForeground(Color.red);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				txtVeDN.setForeground(new Color(30, 144, 255));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				thietLapGiaoDien(true);
				
				
			}
		});
		
		txtThongBao2 = new JTextField();
		txtThongBao2.setBackground(new Color(255, 255, 255));
		txtThongBao2.setEditable(false);
		txtThongBao2.setForeground(new Color(255, 0, 0));
		txtThongBao2.setBounds(63, 442, 292, 20);
		pnlRight.add(txtThongBao2);
		txtThongBao2.setColumns(10);
		txtThongBao2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		thietLapGiaoDien(true);
		
		nhanvien_dao = new DAO_NhanVien();
		taikhoan_dao = new DAO_TaiKhoan();
		
		btnDangNhap.addActionListener(this);
		btnThoat.addActionListener(this);
		btnXacNhan.addActionListener(this);
		
	}

	protected void thietLapGiaoDien(boolean b) {
		// TODO Auto-generated method stub
		if (b == true) {
			//Ẩn giao diện đổi mật khẩu
			AnhDoiMK.hide();
			txtTDNDMK.hide();
			lblTDNDMK.hide();
			lblEmailDK.hide();
			txtEmailDK.hide();
			txtThongBao2.hide();
			txtVeDN.hide();
			lblDMK.hide();
			btnXacNhan.hide();
			
			AnhDangNhap.show();
			radHienMK.show();
			lblDangNhap.show();
			lblTenDN.show();
			txtMK.show();
			lblMatKhau.show();
			txtThongBao.show();
			txtTenDN.show();
			btnDangNhap.show();
			btnThoat.show();
			txtThongBao.show();
			txtQuenMK.show();
			contentPane.setBackground(new Color(204, 204, 153));
		}
		else {
			//Ẩn giao diện đăng nhập
			AnhDoiMK.show();
			txtTDNDMK.show();
			lblTDNDMK.show();
			lblEmailDK.show();
			txtEmailDK.show();
			txtThongBao2.show();
			txtVeDN.show();
			lblDMK.show();;
			btnXacNhan.show();
			
			AnhDangNhap.hide();
			radHienMK.hide();
			lblDangNhap.hide();
			lblTenDN.hide();
			txtMK.hide();
			lblMatKhau.hide();
			txtThongBao.hide();
			txtTenDN.hide();
			btnDangNhap.hide();
			btnThoat.hide();
			txtThongBao.hide();
			txtQuenMK.hide();
			contentPane.setBackground(new Color(51,255,204));
		}
		return;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o == btnThoat) {
			System.exit(0);
		} 
		if(o == btnDangNhap) {
			login();
		}
		if(o == btnXacNhan) {
			quenMK();
		}
	}
	public void login() {
		String user = txtTenDN.getText().trim();
		String pass = txtMK.getText().trim();
		if(pass.isEmpty()) {
			txtThongBao.setText("Vui lòng nhập mật khẩu");
			return;
		} else if(user.isEmpty()) {
			txtThongBao.setText("Vui lòng nhập mã tài khoản");
			return;
		} 
		boolean checkLogin = new DAO_DangNhap().checkLogin(user, pass);
		if(!checkLogin) {
			txtThongBao.setText("Tên đăng nhập hoặc mật khẩu không chính xác!");
			return;
		}
		setVisible(false);
		guiTrangChu = new GuiTrangChu(txtTenDN, txtMK);
		guiTrangChu.setVisible(true);
		nhanvien_dao = new DAO_NhanVien();
		ArrayList<NhanVien> listNV = nhanvien_dao.getNhanVienTheoMa(user);
		
		for(NhanVien nv : listNV) {
			guiTrangChu.txtTenTK.setText(nv.getTenNV());
		}
		
		
	}
	// Hàm kiểm tra và xử lý quên mật khẩu
    public boolean quenMatKhau(String email) {
        // Kiểm tra xem email có tồn tại trong cơ sở dữ liệu hay không
        if (nhanvien_dao.kiemTraEmailTonTai(email)) {
            // Tạo mật khẩu mới ngẫu nhiên
            String matKhauMoi = taoMatKhauNgauNhien();

            // Cập nhật mật khẩu mới vào cơ sở dữ liệu
            String maTK = txtTenDN.getText();
            taikhoan_dao.capNhatMatKhau(matKhauMoi, maTK);

            // Gửi email chứa mật khẩu mới
            guiEmail(email, matKhauMoi);

            return true;
        } else {
            // Nếu email không tồn tại trong cơ sở dữ liệu
            return false;
        }
    }

    // Hàm tạo mật khẩu ngẫu nhiên
    private String taoMatKhauNgauNhien() {
        // Định nghĩa các ký tự có thể xuất hiện trong mật khẩu mới
        String kyTu = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+";

        // Sử dụng lớp Random để chọn ngẫu nhiên từ ký tự trên
        StringBuilder matKhauMoi = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            int index = random.nextInt(kyTu.length());
            matKhauMoi.append(kyTu.charAt(index));
        }

        return matKhauMoi.toString();
    }

    // Hàm gửi email chứa mật khẩu mới
    private void guiEmail(String email, String matKhauMoi) {
        final String username = "qlhsfutureze@gmail.com"; // Địa chỉ email của bạn
        final String password = "qlhs12345";  // Mật khẩu email của bạn

        // Cấu hình thông tin email
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // Tạo phiên làm việc với máy chủ email
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            // Tạo đối tượng Message
            Message message = new MimeMessage(session);

            // Thiết lập địa chỉ email người gửi
            message.setFrom(new InternetAddress(username));

            // Thiết lập địa chỉ email người nhận
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(email));

            // Thiết lập tiêu đề email
            message.setSubject("Reset Password");

            // Thiết lập nội dung email
            message.setText("Your new password is: " + matKhauMoi);

            // Gửi email
            Transport.send(message);

            System.out.println("Email sent successfully!");

        } catch (MessagingException e) {
        	e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    
//    private void guiEmail(String email, String matKhauMoi) {
//        // Cấu hình thông tin xác thực OAuth 2.0
//        String clientId = "YOUR_CLIENT_ID";
//        String clientSecret = "YOUR_CLIENT_SECRET";
//        String refreshToken = "YOUR_REFRESH_TOKEN";
//
//        Properties props = new Properties();
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.host", "smtp.gmail.com");
//        props.put("mail.smtp.port", "587");
//        props.put("mail.smtp.auth.mechanisms", "XOAUTH2");
//
//        Session session = Session.getInstance(props);
//
//        try {
//            // Tạo đối tượng Message
//            Message message = new MimeMessage(session);
//
//            // Thiết lập địa chỉ email người gửi
//            message.setFrom(new InternetAddress("your-email@gmail.com"));
//
//            // Thiết lập địa chỉ email người nhận
//            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
//
//            // Thiết lập tiêu đề email
//            message.setSubject("Reset Password");
//
//            // Thiết lập nội dung email
//            message.setText("Your new password is: " + matKhauMoi);
//
//            // Gửi email
//            Transport transport = session.getTransport("smtp");
//            transport.connect("smtp.gmail.com", 587, "your-email@gmail.com", "oauth2_token");
//            transport.sendMessage(message, message.getAllRecipients());
//            transport.close();
//
//            System.out.println("Email sent successfully!");
//
//        } catch (MessagingException e) {
//            throw new RuntimeException(e);
//        }
//    }

    
    public void quenMK() {
    	String email = txtEmailDK.getText();
    	String matKhauMoi = taoMatKhauNgauNhien();
    	if(quenMatKhau("nguyencaotri26092003@gmail.com")) {
    		guiEmail("nguyencaotri26092003@gmail.com", matKhauMoi);
    	}
    	
    }
}
