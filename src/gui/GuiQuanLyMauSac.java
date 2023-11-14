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
import dao.DAO_MauSac;
import entity.KhachHang;
import entity.MauSac;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class GuiQuanLyMauSac extends JFrame implements ActionListener, MouseListener{

	public static JPanel contentPane;
	private JTextField txtMaMauSac;
	private JTextField txtTimKiem;
	private DefaultTableModel modelMS;
	private JTable tblMS;
	private JTextField txtTrangThai;
	private ButtonGroup group;
	private JRadioButton radTenMau;
	private JRadioButton radMaMau;
	private JPanel pnlTacVuCon;
	private JTextField txtTenMau;
	private JLabel lblTenMau;
	private JButton btnThem;
	private JButton btnSua;
	private JButton btnXoa;
	private JButton btnLuu;
	private JButton btnDatLai;
	private DAO_MauSac dao_mausac;
	private Component btnXoaTrang;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiQuanLyMauSac frame = new GuiQuanLyMauSac();
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
	public GuiQuanLyMauSac() {
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

		JLabel lblTieuDe = new JLabel("QUẢN LÝ MÀU SẮC");
		lblTieuDe.setBackground(new Color(51, 204, 255));
		pnlTieuDe.add(lblTieuDe);
		lblTieuDe.setFont(font1);
		lblTieuDe.setForeground(new Color(0, 204, 204));

		JPanel pnlThongTinKH = new JPanel();
		pnlThongTinKH.setBackground(new Color(255, 255, 255));

		pnlThongTinKH.setBorder(BorderFactory.createTitledBorder("Thông tin màu sắc"));
		pnlThongTinKH.setBounds(10, 80, 350, 855);
		contentPane.add(pnlThongTinKH);
		pnlThongTinKH.setLayout(null);

		JLabel lblMaMau = new JLabel("Mã màu sắc:");
		lblMaMau.setBounds(10, 35, 319, 30);
		pnlThongTinKH.add(lblMaMau);
		lblMaMau.setFont(font2);

		lblTenMau = new JLabel("Tên màu sắc :");
		lblTenMau.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblTenMau.setBounds(10, 175, 187, 30);
		pnlThongTinKH.add(lblTenMau);

		txtMaMauSac = new JTextField();
		txtMaMauSac.setFont(new Font("Tahoma", Font.PLAIN, 18));
//		txtMaMauSac.setEditable(false);
		txtMaMauSac.setBounds(20, 100, 319, 40);
		pnlThongTinKH.add(txtMaMauSac);
		txtMaMauSac.setColumns(10);

		txtTenMau = new JTextField();
		txtTenMau.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTenMau.setColumns(10);
		txtTenMau.setBounds(20, 240, 319, 40);
		pnlThongTinKH.add(txtTenMau);

		pnlTacVuCon = new JPanel();
		pnlTacVuCon.setBounds(10, 680, 330, 157);
		pnlThongTinKH.add(pnlTacVuCon);
		pnlTacVuCon.setBackground(Color.white);
		pnlTacVuCon.setBorder(BorderFactory.createTitledBorder("Tìm kiếm theo : "));
		pnlTacVuCon.setLayout(null);

		txtTimKiem = new JTextField("Nhập thông tin cần tìm");
		txtTimKiem.setBounds(10, 95, 308, 40);
		pnlTacVuCon.add(txtTimKiem);
		txtTimKiem.setColumns(10);

		radMaMau = new JRadioButton("Mã màu");
		radMaMau.setBackground(new Color(255, 255, 255));
		radMaMau.setBounds(10, 34, 109, 23);
		pnlTacVuCon.add(radMaMau);

		radTenMau = new JRadioButton("Tên màu");
		radTenMau.setBackground(new Color(255, 255, 255));
		radTenMau.setBounds(10, 60, 126, 23);
		pnlTacVuCon.add(radTenMau);
		
		group = new ButtonGroup();
		group.add(radMaMau);
		group.add(radTenMau);
		
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
		btnThem.setIcon(new ImageIcon(GuiQuanLyMauSac.class.getResource("/image/TacVu_Them1.png")));
		btnThem.setBackground(Color.WHITE);

		btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnSua.setBounds(410, 21, 180, 48);
		pnlTacVu.add(btnSua);
		btnSua.setIcon(new ImageIcon(GuiQuanLyMauSac.class.getResource("/image/TacVu_Sua.png")));
		btnSua.setBackground(Color.WHITE);

		btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnXoa.setBounds(680, 21, 180, 48);
		pnlTacVu.add(btnXoa);
		btnXoa.setIcon(new ImageIcon(GuiQuanLyMauSac.class.getResource("/image/TacVu_Xoa1.png")));
		btnXoa.setBackground(Color.WHITE);

		btnLuu = new JButton("Lưu");
		btnLuu.setEnabled(false);
		btnLuu.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnLuu.setBounds(950, 21, 180, 48);
		pnlTacVu.add(btnLuu);
		btnLuu.setIcon(new ImageIcon(GuiQuanLyMauSac.class.getResource("/image/TacVu_Luu.png")));
		btnLuu.setBackground(Color.WHITE);

		btnDatLai = new JButton("Đặt lại");
		btnDatLai.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnDatLai.setBounds(1220, 21, 180, 48);
		pnlTacVu.add(btnDatLai);
		btnDatLai.setIcon(new ImageIcon(GuiQuanLyMauSac.class.getResource("/image/TacVu_DatLai.png")));
		btnDatLai.setBackground(Color.WHITE);
		;

		JPanel pnlBangMS = new JPanel();
		pnlBangMS.setBounds(370, 80, 1531, 765);
		contentPane.add(pnlBangMS);
		pnlBangMS.setBorder(BorderFactory.createTitledBorder("Bảng thông tin màu sắc"));
		pnlBangMS.setLayout(null);

		pnlBangMS.setBackground(Color.white);
		;
		modelMS = new DefaultTableModel();
		modelMS.addColumn("Mã màu sắc");
		modelMS.addColumn("Tên màu sắc");

		tblMS = new JTable(modelMS);
		tblMS.setBackground(new Color(153, 204, 255));
		JScrollPane jScrollPane = new JScrollPane(tblMS);
		jScrollPane.setBounds(10, 29, 1499, 720);
		JTableHeader tbHeaderMS = tblMS.getTableHeader();
		tbHeaderMS.setFont(font2);
		tbHeaderMS.setBackground(new Color(51, 204, 204));
		pnlBangMS.setLayout(null);
		tblMS.setFont(font2);
		tblMS.setRowHeight(35);
		pnlBangMS.add(jScrollPane);

		txtTrangThai = new JTextField("Không có hoạt động nào gần nhất");
		txtTrangThai.setForeground(Color.red);
		txtTrangThai.setHorizontalAlignment(SwingConstants.CENTER);
		txtTrangThai.setBounds(10, 945, 1894, 20);
		contentPane.add(txtTrangThai);
		txtTrangThai.setColumns(10);
		
		//
		tblMS.addMouseListener(this);
		btnDatLai.addActionListener(this);
		btnLuu.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoa.addActionListener(this);
		btnThem.addActionListener(this);
		
		//
		dao_mausac = new DAO_MauSac();
		try {
			ConnectDB.getInstance().connect();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		//
		loadData(dao_mausac.getAllMauSac());
		dongMoNhapLieu(false);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnDatLai)) {
			xoaRong();
		}
		if (o.equals(btnThem)) {
			if (btnThem.getText().equals("Thêm")) {
				moNutThem();
			} else {
				tblMS.addMouseListener(this);
				dongMoNhapLieu(false);
				btnThem.setText("Thêm");
				btnSua.setEnabled(true);
				btnXoa.setEnabled(true);
				btnXoaTrang.setEnabled(false);
				btnLuu.setEnabled(false);
				txtMaMauSac.setText("");
				xoaRong();
				loadData(dao_mausac.getAllMauSac());
			}
		}
		if (o.equals(btnXoa)) {
			xoa();
		}if (o.equals(btnSua)) {
			if (btnSua.getText().equals("Sửa")) {
				int hangDuocChon = tblMS.getSelectedRow();
				if (hangDuocChon > -1) {
					dongMoNhapLieu(true);
					btnSua.setText("Hủy");
					btnThem.setEnabled(false);
					btnXoa.setEnabled(false);
					btnXoaTrang.setEnabled(true);
					btnLuu.setEnabled(true);
				} else {
					JOptionPane.showMessageDialog(this,
							"Vui lòng chọn 1 hàng trong bảng danh sách khách hàng, trước khi sửa!");
				}
			} else {
				dongMoNhapLieu(false);
				btnSua.setText("Sửa");
				btnThem.setEnabled(true);
				btnXoa.setEnabled(true);
				btnXoaTrang.setEnabled(false);
				btnLuu.setEnabled(false);
				txtMaMauSac.setText("");
				xoaRong();
			}
		}if (o.equals(btnLuu)) {
			if (btnThem.getText().equals("Hủy")) {
				themMauSac();
			}
			if (btnSua.getText().equals("Hủy")) {
				if (validData()) {
					String maMau = txtMaMauSac.getText().trim();
					String tenMau = txtTenMau.getText().trim();

					if (dao_mausac.updateMauSac(new MauSac(maMau, tenMau))) {
						loadData(dao_mausac.getAllMauSac());
						JOptionPane.showMessageDialog(this, "Sửa thông tin màu sắc thành công");
						dongMoNhapLieu(false);
						btnSua.setText("Sửa");
						btnThem.setEnabled(true);
						btnXoa.setEnabled(true);
						btnXoaTrang.setEnabled(false);
						btnLuu.setEnabled(false);
					}
				}
			}
		} 

	}
	
	public void moNutThem() {
		dongMoNhapLieu(true);
		btnLuu.setEnabled(true);
		btnSua.setEnabled(false);
		btnXoa.setEnabled(false);
		btnDatLai.setEnabled(true);
		btnThem.setText("Hủy");
		tblMS.removeMouseListener(this);
		xoaRong();
	}
	public void themMauSac() {
		if (validData()) {
			String maMS = txtMaMauSac.getText().trim();
			String tenMau = txtTenMau.getText().trim();
			
			if (dao_mausac.createMS(new MauSac(maMS, tenMau))) {
				loadData(dao_mausac.getAllMauSac());
				JOptionPane.showMessageDialog(this, "Thêm màu sắc mới thành công");	
				btnThem.setText("Thêm");
				xoaRong();
				btnSua.setEnabled(true);
				btnXoa.setEnabled(true);
				btnDatLai.setEnabled(false);
				btnLuu.setEnabled(false);
				txtMaMauSac.setText("");
				tblMS.addMouseListener(this);
				dongMoNhapLieu(false);
			}
		}
	}
	private void loadData(ArrayList<MauSac> ms) {
		modelMS.setRowCount(0);
		for (int i = 0; i < ms.size(); i++) {
			String maMau = ms.get(i).getMaMau();
			String tenMau = ms.get(i).getTenMau();
			String row[] = { maMau, tenMau};
			modelMS.addRow(row);
		}
	}
	private void dongMoNhapLieu(Boolean b) {
		txtMaMauSac.setEditable(false);
		txtTenMau.setEditable(b);
	}
	public void xoaRong() {
		txtMaMauSac.setText("");
		txtTimKiem.setText("");
		txtTenMau.setText("");
		txtTenMau.setEditable(true);
		txtMaMauSac.setEditable(true);
		txtMaMauSac.requestFocus();
	}
	public void xoa() {
		int row = tblMS.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(this, "Hãy chọn màu sắc cần xoá");
		} else {
			int tl;
			tl = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa màu sắc này không ?", "Cảnh báo",
					JOptionPane.YES_OPTION);
			if (tl == JOptionPane.YES_OPTION) {
				int index = tblMS.getSelectedRow();
				dao_mausac.xoaMS(modelMS.getValueAt(tblMS.getSelectedRow(), 0).toString());
				modelMS.removeRow(index);
				xoaRong();
			}
		}
	}
	private boolean validData() {
		String tenMau  = txtTenMau.getText().trim();
		if (tenMau.length() == 0) {
			showMessage(txtTenMau, "Nhập tên màu sắc!");
			return false;
		}
		if (!tenMau.matches(
				"^([A-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪỬỮỰỲỴÝỶỸa-záàảãạăắằẳẵặâấầẩẫậéèẻẽẹêếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịúùủũụưứừửữựýỳỷỹỵđ\\d]*\\s?)+$")) {
			showMessage(txtTenMau, "Tên màu sắc bao gồm chữ cái, chữ số tiếng Việt, không bao gồm ký tự đặc biệt!");
			return false;
		}
		
		return true;
	}
	private void showMessage(JTextField txt, String message) {
		txt.setText("");
		JOptionPane.showMessageDialog(this, message);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = 	tblMS.getSelectedRow();
		txtMaMauSac.setText(tblMS.getValueAt(row, 0).toString());
		txtTenMau.setText(tblMS.getValueAt(row, 1).toString());
		txtTenMau.setEditable(false);
		txtMaMauSac.setEditable(false);
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
