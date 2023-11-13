package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import connectDB.ConnectDB;
import dao.DAO_ChucVu;
import entity.ChucVu;
import entity.NhanVien;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class GuiQuanLyChucVu extends JFrame implements ActionListener, MouseListener, ListSelectionListener {

	public static JPanel contentPane;
	private JTextField txtMaNSX;
	private JTextField txtTenNSX;
	private JTextField txtTimKiem;
	private DefaultTableModel modelCV;
	private JTable tblCV;
	private JTextField txtTrangThai;
	private ButtonGroup group;
	private JRadioButton radTenChucVu;
	private JRadioButton radMaChucVu;
	private JButton btnThem;
	private JButton btnSua;
	private JButton btnXoa;
	private JButton btnLuu;
	private JButton btnDatLai;
	private DAO_ChucVu chucvu_dao;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiQuanLyChucVu frame = new GuiQuanLyChucVu();
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
	public GuiQuanLyChucVu() {
		this.setTitle("Quản lý chức vụ");
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
		pnlTieuDe.setBounds(10, 10, 1892, 60);
		pnlTieuDe.setBackground(new Color(255, 255, 255));
		contentPane.add(pnlTieuDe);
		
		JLabel lblTieuDe = new JLabel("QUẢN LÝ CHỨC VỤ");
		lblTieuDe.setBackground(new Color(51, 204, 255));
		pnlTieuDe.add(lblTieuDe);
		lblTieuDe.setFont(font1);
		lblTieuDe.setForeground(new Color(0, 204, 204));
		
		JPanel pnlThongTinKH = new JPanel();
		pnlThongTinKH.setBackground(new Color(255, 255, 255));
		
		pnlThongTinKH.setBorder(BorderFactory.createTitledBorder("Thông tin chức vụ"));
		pnlThongTinKH.setBounds(10, 80, 350, 855);
		contentPane.add(pnlThongTinKH);
		pnlThongTinKH.setLayout(null);
		
		JLabel lblMaChucVu = new JLabel("Mã chức vụ:");
		lblMaChucVu.setBounds(10, 35, 319, 30);
		pnlThongTinKH.add(lblMaChucVu);
		lblMaChucVu.setFont(font2);
		
		JLabel lblTenNSX = new JLabel("Tên chức vụ :");
		lblTenNSX.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblTenNSX.setBounds(10, 175, 187, 30);
		pnlThongTinKH.add(lblTenNSX);
		
		txtMaNSX = new JTextField();
		txtMaNSX.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtMaNSX.setEditable(false);
		txtMaNSX.setBounds(20, 100, 319, 40);
		pnlThongTinKH.add(txtMaNSX);
		txtMaNSX.setColumns(10);
		
		txtTenNSX = new JTextField();
		txtTenNSX.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTenNSX.setColumns(10);
		txtTenNSX.setBounds(20, 240, 319, 40);
		pnlThongTinKH.add(txtTenNSX);
		
		JPanel pnlTacVuCon = new JPanel();
		pnlTacVuCon.setBounds(10, 680, 330, 157);
		pnlThongTinKH.add(pnlTacVuCon);
		pnlTacVuCon.setBackground(Color.white);
		pnlTacVuCon.setBorder(BorderFactory.createTitledBorder("Tìm kiếm theo : "));
		pnlTacVuCon.setLayout(null);
		
		txtTimKiem = new JTextField("Nhập thông tin cần tìm");
		txtTimKiem.setBounds(10, 95, 308, 40);
		pnlTacVuCon.add(txtTimKiem);
		txtTimKiem.setColumns(10);
		
				
				radTenChucVu = new JRadioButton("Tên chức vụ");
				radTenChucVu.setBackground(new Color(255, 255, 255));
				radTenChucVu.setBounds(10, 32, 126, 23);
				pnlTacVuCon.add(radTenChucVu);
		
				group = new ButtonGroup();
				group.add(radTenChucVu);
				
				radMaChucVu = new JRadioButton("Mã chức vụ");
				radMaChucVu.setBackground(new Color(255, 255, 255));
				radMaChucVu.setBounds(177, 32, 141, 23);
				pnlTacVuCon.add(radMaChucVu);
				group.add(radMaChucVu);
				
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
				
		
		JPanel pnlTacVu = new JPanel();
		pnlTacVu.setBackground(Color.white);
		pnlTacVu.setBounds(370, 855, 1530, 80);
		pnlTacVu.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ:"));
		contentPane.add(pnlTacVu);
		pnlTacVu.setLayout(null);
		
		btnThem = new JButton("Thêm");
		btnThem.setBounds(140, 21, 180, 48);
		pnlTacVu.add(btnThem);
		btnThem.setFont(font2);
		btnThem.setIcon(new ImageIcon(GuiQuanLyChucVu.class.getResource("/image/TacVu_Them1.png")));
		btnThem.setBackground(Color.WHITE);
		
		btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnSua.setBounds(410, 21, 180, 48);
		pnlTacVu.add(btnSua);
		btnSua.setIcon(new ImageIcon(GuiQuanLyChucVu.class.getResource("/image/TacVu_Sua.png")));
		btnSua.setBackground(Color.WHITE);
		
		btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnXoa.setBounds(680, 21, 180, 48);
		pnlTacVu.add(btnXoa);
		btnXoa.setIcon(new ImageIcon(GuiQuanLyChucVu.class.getResource("/image/TacVu_Xoa1.png")));
		btnXoa.setBackground(Color.WHITE);
		
		btnLuu = new JButton("Lưu");
		btnLuu.setEnabled(false);
		btnLuu.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnLuu.setBounds(950, 21, 180, 48);
		pnlTacVu.add(btnLuu);
		btnLuu.setIcon(new ImageIcon(GuiQuanLyChucVu.class.getResource("/image/TacVu_Luu.png")));
		btnLuu.setBackground(Color.WHITE);
		
		btnDatLai = new JButton("Đặt lại");
		btnDatLai.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnDatLai.setBounds(1220, 21, 180, 48);
		pnlTacVu.add(btnDatLai);
		btnDatLai.setIcon(new ImageIcon(GuiQuanLyChucVu.class.getResource("/image/TacVu_DatLai.png")));
		btnDatLai.setBackground(Color.WHITE);;
		
		
		JPanel pnlBangCV = new JPanel();
		pnlBangCV.setBounds(370, 80, 1530, 765);
		contentPane.add(pnlBangCV);
		pnlBangCV.setBorder(BorderFactory.createTitledBorder("Bảng thông tin chức vụ"));
		pnlBangCV.setLayout(null);
		
		

		pnlBangCV.setBackground(Color.white);;
		modelCV = new DefaultTableModel();
		modelCV.addColumn("Mã chức vụ");
		modelCV.addColumn("Tên chức vụ");

		tblCV = new JTable(modelCV);
		tblCV.setBackground(new Color(153, 204, 255));
		JScrollPane jScrollPane = new JScrollPane(tblCV);
		jScrollPane.setBounds(20, 20, 1489, 728);
		JTableHeader tbHeaderCV = tblCV.getTableHeader();
		tbHeaderCV.setFont(font2);
		tbHeaderCV.setBackground(new Color(51, 204, 204));
		pnlBangCV.setLayout(null);
		tblCV.setFont(font2);
		tblCV.setRowHeight(35);
		pnlBangCV.add(jScrollPane);
		
		txtTrangThai = new JTextField("Không có hoạt động nào gần nhất");
		txtTrangThai.setForeground(Color.red);
		txtTrangThai.setHorizontalAlignment(SwingConstants.CENTER);
		txtTrangThai.setBounds(10, 945, 1894, 20);
		contentPane.add(txtTrangThai);
		txtTrangThai.setColumns(10);
		
		//
		tblCV.addMouseListener(this);
		btnDatLai.addActionListener(this);
		btnLuu.addActionListener(this);
		btnSua.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		
		
		// ket noi sql
		chucvu_dao = new DAO_ChucVu();
		try {
			ConnectDB.getInstance().connect();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		
		
		// xu ly
		DocDuLieuDatabase();
		id();

	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnDatLai)) {
			xoaRong();
		}
		if (o.equals(btnXoa)) {
			xoa();
		}
		if (o.equals(btnThem)) {
			themCV();
		}
		if (o.equals(btnSua)) {
			int row = tblCV.getSelectedRow();
			if(row == -1) {
				JOptionPane.showMessageDialog(this, "Hãy chọn chức vụ cần sửa");
			}
			else {
				txtTenNSX.setEditable(true);
				txtTenNSX.requestFocus();
				btnLuu.setEnabled(true);
			}
		}
	}
	
	// Lấy dữ liệu từ Database
	public void DocDuLieuDatabase() {
		chucvu_dao = new DAO_ChucVu();
		//tblCV.setRowHeight(25);
		for(ChucVu cv : chucvu_dao.getAllCV()) {
			modelCV.addRow(new Object[] {cv.getMaChucVu(), cv.getTenChucVu()});
		}
	}
	
	// Phát sinh mã
	public void id() {
		String newMaChucVu = chucvu_dao.generateNewMaChucVu();
		txtMaNSX.setText(newMaChucVu);
	}
	
	// nút dặt lại
	public void xoaRong() {
		id();
		txtTenNSX.setText("");
		txtTimKiem.setText("");
		txtTenNSX.setEditable(true);
		txtTenNSX.requestFocus();
	}
	
	// nút xoá
	public void xoa() {
		int row = tblCV.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(this, "Hãy chọn chức vụ cần xoá");
		} else {
			int tl;
			tl = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa chức vụ này không ?", "Cảnh báo",
					JOptionPane.YES_OPTION);
			if (tl == JOptionPane.YES_OPTION) {
				int index = tblCV.getSelectedRow();
				chucvu_dao.xoaCV(modelCV.getValueAt(tblCV.getSelectedRow(), 0).toString());
				modelCV.removeRow(index);
				xoaRong();
			}
		}
	}
	
	
	// Nút thêm
	private void themCV() {
		String tenCV = txtTenNSX.getText();
		String newMaChucVu = chucvu_dao.generateNewMaChucVu();
		txtMaNSX.setText(newMaChucVu);
		ChucVu cv = new ChucVu(newMaChucVu, tenCV);
		if (chucvu_dao.createCV(cv)) {
			modelCV.addRow(new Object[] { cv.getMaChucVu(), cv.getTenChucVu()});	
			JOptionPane.showMessageDialog(this, "Thêm chức vụ thành công");
			xoaRong();
		}else {
			JOptionPane.showMessageDialog(this, "Không thành công");
		}
	}
	

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = 	tblCV.getSelectedRow();
		txtMaNSX.setText(tblCV.getValueAt(row, 0).toString());
		txtTenNSX.setText(tblCV.getValueAt(row, 1).toString());
		txtTenNSX.setEditable(false);
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
