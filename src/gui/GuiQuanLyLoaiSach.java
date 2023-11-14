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
import dao.DAO_QuanLyLoaiSach;
import entity.LoaiSach;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class GuiQuanLyLoaiSach extends JFrame implements ActionListener, MouseListener {

	public static JPanel contentPane;
	private JTextField txtMaLoaiSach;
	private JTextField txtVAT;
	private JTextField txtMoTa;
	private JTextField txtTenLoaiSach;
	private JTextField txtTimKiem;
	private DefaultTableModel modelLoaiSach;
	private JTable tblLS;
	private JTextField txtTrangThai;
	private ButtonGroup group;
	private JButton btnDatLai;
	private JButton btnLuu;
	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnThem;
	private DAO_QuanLyLoaiSach loaiSach_dao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiQuanLyLoaiSach frame = new GuiQuanLyLoaiSach();
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
	public GuiQuanLyLoaiSach() {
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
		pnlTieuDe.setBounds(10, 10, 1890, 60);
		pnlTieuDe.setBackground(new Color(255, 255, 255));
		contentPane.add(pnlTieuDe);
		
		JLabel lblTieuDe = new JLabel("QUẢN LÝ LOẠI SÁCH");
		lblTieuDe.setBackground(new Color(51, 204, 255));
		pnlTieuDe.add(lblTieuDe);
		lblTieuDe.setFont(font1);
		lblTieuDe.setForeground(new Color(0, 204, 204));
		
		JPanel pnlThongTinLoaiSach = new JPanel();
		pnlThongTinLoaiSach.setBackground(new Color(255, 255, 255));
		
		pnlThongTinLoaiSach.setBorder(BorderFactory.createTitledBorder("Thông tin loại sách"));
		pnlThongTinLoaiSach.setBounds(10, 80, 350, 855);
		contentPane.add(pnlThongTinLoaiSach);
		pnlThongTinLoaiSach.setLayout(null);
		
		JLabel lblLoaiSach = new JLabel("Mã loại sách:");
		lblLoaiSach.setBounds(10, 35, 319, 30);
		pnlThongTinLoaiSach.add(lblLoaiSach);
		lblLoaiSach.setFont(font2);
		
		JLabel lblTenLoaiSach = new JLabel("Tên loại sách :");
		lblTenLoaiSach.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblTenLoaiSach.setBounds(10, 175, 187, 30);
		pnlThongTinLoaiSach.add(lblTenLoaiSach);
		
		JLabel lblVAT = new JLabel("VAT :");
		lblVAT.setIgnoreRepaint(true);
		lblVAT.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblVAT.setBounds(10, 495, 163, 30);
		pnlThongTinLoaiSach.add(lblVAT);
		
		JLabel lblMoTa = new JLabel("Mô tả :");
		lblMoTa.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblMoTa.setBounds(10, 315, 163, 30);
		pnlThongTinLoaiSach.add(lblMoTa);
		
		txtMaLoaiSach = new JTextField();
		txtMaLoaiSach.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtMaLoaiSach.setEditable(false);
		txtMaLoaiSach.setBounds(20, 100, 319, 40);
		pnlThongTinLoaiSach.add(txtMaLoaiSach);
		txtMaLoaiSach.setColumns(10);
		
		txtVAT = new JTextField();
		txtVAT.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtVAT.setColumns(10);
		txtVAT.setBounds(20, 560, 319, 40);
		pnlThongTinLoaiSach.add(txtVAT);
		
		txtMoTa = new JTextField();
		txtMoTa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtMoTa.setColumns(10);
		txtMoTa.setBounds(20, 380, 320, 80);
		pnlThongTinLoaiSach.add(txtMoTa);
		
		txtTenLoaiSach = new JTextField();
		txtTenLoaiSach.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTenLoaiSach.setColumns(10);
		txtTenLoaiSach.setBounds(20, 240, 319, 40);
		pnlThongTinLoaiSach.add(txtTenLoaiSach);
		
		JPanel pnlTacVuCon = new JPanel();
		pnlTacVuCon.setBounds(9, 741, 330, 103);
		pnlThongTinLoaiSach.add(pnlTacVuCon);
		pnlTacVuCon.setBackground(Color.white);
		pnlTacVuCon.setBorder(BorderFactory.createTitledBorder("Tìm kiếm theo : "));
		pnlTacVuCon.setLayout(null);
		
		txtTimKiem = new JTextField("Nhập thông tin cần tìm");
		txtTimKiem.setBounds(10, 36, 308, 40);
		pnlTacVuCon.add(txtTimKiem);
		txtTimKiem.setColumns(10);
		
				group = new ButtonGroup();
				
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
		btnThem.setIcon(new ImageIcon(GuiQuanLyLoaiSach.class.getResource("/image/TacVu_Them1.png")));
		btnThem.setBackground(Color.WHITE);
		
		btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnSua.setBounds(410, 21, 180, 48);
		pnlTacVu.add(btnSua);
		btnSua.setIcon(new ImageIcon(GuiQuanLyLoaiSach.class.getResource("/image/TacVu_Sua.png")));
		btnSua.setBackground(Color.WHITE);
		
		btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnXoa.setBounds(680, 21, 180, 48);
		pnlTacVu.add(btnXoa);
		btnXoa.setIcon(new ImageIcon(GuiQuanLyLoaiSach.class.getResource("/image/TacVu_Xoa1.png")));
		btnXoa.setBackground(Color.WHITE);
		
		btnLuu = new JButton("Lưu");
		btnLuu.setEnabled(false);
		btnLuu.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnLuu.setBounds(950, 21, 180, 48);
		pnlTacVu.add(btnLuu);
		btnLuu.setIcon(new ImageIcon(GuiQuanLyLoaiSach.class.getResource("/image/TacVu_Luu.png")));
		btnLuu.setBackground(Color.WHITE);
		
		btnDatLai = new JButton("Đặt lại");
		btnDatLai.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnDatLai.setBounds(1220, 21, 180, 48);
		pnlTacVu.add(btnDatLai);
		btnDatLai.setIcon(new ImageIcon(GuiQuanLyLoaiSach.class.getResource("/image/TacVu_DatLai.png")));
		btnDatLai.setBackground(Color.WHITE);;
		
		
		JPanel pnlBangLoaiSach = new JPanel();
		pnlBangLoaiSach.setBounds(370, 80, 1530, 765);
		contentPane.add(pnlBangLoaiSach);
		pnlBangLoaiSach.setBorder(BorderFactory.createTitledBorder("Bảng thông tin loại sách"));
		pnlBangLoaiSach.setLayout(null);
		
		

		pnlBangLoaiSach.setBackground(Color.white);;
		modelLoaiSach = new DefaultTableModel();
		modelLoaiSach.addColumn("Mã loại sách");
		modelLoaiSach.addColumn("Tên loại sách");
		modelLoaiSach.addColumn("Mô tả");
		modelLoaiSach.addColumn("VAT");
		tblLS = new JTable(modelLoaiSach);
		tblLS.setBackground(new Color(153, 204, 255));
		JScrollPane jScrollPane = new JScrollPane(tblLS);
		jScrollPane.setBounds(20, 20, 1489, 728);
		JTableHeader tbHeaderSach = tblLS.getTableHeader();
		tbHeaderSach.setFont(font2);
		tbHeaderSach.setBackground(new Color(51, 204, 204));
		pnlBangLoaiSach.setLayout(null);
		tblLS.setFont(font2);
		tblLS.setRowHeight(35);
		pnlBangLoaiSach.add(jScrollPane);
		
		txtTrangThai = new JTextField("Không có hoạt động nào gần nhất");
		txtTrangThai.setForeground(Color.red);
		txtTrangThai.setHorizontalAlignment(SwingConstants.CENTER);
		txtTrangThai.setBounds(10, 945, 1894, 20);
		contentPane.add(txtTrangThai);
		txtTrangThai.setColumns(10);
		
		//
		tblLS.addMouseListener(this);
		btnDatLai.addActionListener(this);
		btnLuu.addActionListener(this);
		btnSua.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		
		//
		loaiSach_dao = new DAO_QuanLyLoaiSach();
		try {
			ConnectDB.getInstance().connect();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		//
		DocDuLieuDatabase();
		id();
		
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
			themLS();
		}
		if (o.equals(btnXoa)) {
			xoa();
		}
		if (o.equals(btnSua)) {
			btSua();
		}
		if (o.equals(btnLuu)) {
			updateLS();
		}
	}
	
	public void DocDuLieuDatabase() {
		loaiSach_dao = new DAO_QuanLyLoaiSach();
		//tblCV.setRowHeight(25);
		for(LoaiSach ls : loaiSach_dao.getALLLoaiSach()) {
			modelLoaiSach.addRow(new Object[] {ls.getMaLoaiSach(), ls.getTenLoai(), ls.getMoTa(), ls.getVat()});
		}
	}
	
	// phát sinh mã tự động
	public void id() {
		String newMaLoaiSach = loaiSach_dao.TuPhatSinhMaLoaiSach();
		txtMaLoaiSach.setText(newMaLoaiSach);
	}
	
	public void xoaRong() {
		id();
		txtTimKiem.setText("");
		txtTenLoaiSach.setText("");
		txtMoTa.setText("");
		txtVAT.setText("");
		txtTenLoaiSach.requestFocus();
		txtTenLoaiSach.setEditable(true);
		txtMoTa.setEditable(true);
		txtVAT.setEditable(true);
		btnLuu.setEnabled(false);
		btnSua.setEnabled(true);
	}
	
	private void themLS() {
		String tenCV = txtTenLoaiSach.getText();
		String newMaLoaiSach = loaiSach_dao.TuPhatSinhMaLoaiSach();
		txtMaLoaiSach.setText(newMaLoaiSach);
		String mota = txtMoTa.getText();
		Double vat = Double.parseDouble(txtVAT.getText());
		LoaiSach ls = new LoaiSach(newMaLoaiSach, tenCV, mota, vat);
		if (loaiSach_dao.addLoaiSach(ls)) {
			modelLoaiSach.addRow(new Object[] { ls.getMaLoaiSach(), ls.getTenLoai(), ls.getMoTa(), ls.getVat()});	
			JOptionPane.showMessageDialog(this, "Thêm chức vụ thành công");
			xoaRong();
		}else {
			JOptionPane.showMessageDialog(this, "Không thành công");
		}
	}
	
	public void xoa() {
		int row = tblLS.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(this, "Hãy chọn loại sách cần xoá");
		} else {
			int tl;
			tl = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa loại sách này không ?", "Cảnh báo",
					JOptionPane.YES_OPTION);
			if (tl == JOptionPane.YES_OPTION) {
				int index = tblLS.getSelectedRow();
				loaiSach_dao.deleteLoaiSach(modelLoaiSach.getValueAt(tblLS.getSelectedRow(), 0).toString());
				modelLoaiSach.removeRow(index);
				xoaRong();
			}
		}
	}
	
	private void btSua() {
		int row = tblLS.getSelectedRow();
	    if (row == -1) {
	        JOptionPane.showMessageDialog(this, "Hãy chọn chức vụ cần sửa");
	    } else {
	        txtTenLoaiSach.setEditable(true);
	        txtTenLoaiSach.requestFocus();
	        txtMoTa.setEditable(true);
			txtVAT.setEditable(true);
			btnLuu.setEnabled(false);
	        
	        btnSua.setEnabled(false); // Disable the "Sửa" button
	        btnLuu.setEnabled(true);
	    }
	}
	
	private void updateLS() {
		
		String maLS = txtMaLoaiSach.getText();
	    String tenLS = txtTenLoaiSach.getText();
	    String mota = txtMoTa.getText();
	    double vat = Double.parseDouble(txtVAT.getText());
	    
	    LoaiSach ls = new LoaiSach(maLS, tenLS, mota, vat);

	    // Call the DAO method to update the KhachHang in the database
	    boolean result = loaiSach_dao.updateLoaiSach(ls);

	    // Check the result and show appropriate messages
	    if (result) {
	        JOptionPane.showMessageDialog(this, "Cập nhật thông tin loại sách thành công");
	        // Update the corresponding row in the table
	        int selectedRow = tblLS.getSelectedRow();
	        modelLoaiSach.setValueAt(tenLS, selectedRow, 1);
	        modelLoaiSach.setValueAt(mota, selectedRow, 2);
	        modelLoaiSach.setValueAt(vat, selectedRow, 3);
	        
	        // Reset the form and button states
	        xoaRong();
	        btnSua.setEnabled(true);
	        btnLuu.setEnabled(false);
	    } else {
	        JOptionPane.showMessageDialog(this, "Cập nhật thông tin loại sách không thành công");
	    }
	}
	
	private void timKiem(String tuKhoa) {
	    TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelLoaiSach);
	    tblLS.setRowSorter(sorter);

	    if (tuKhoa.isEmpty()) {
	        sorter.setRowFilter(null);
	    } else {
	        RowFilter<DefaultTableModel, Object> filter = RowFilter.regexFilter("(?i)" + Pattern.quote(tuKhoa), 1, 3);
	        sorter.setRowFilter(filter);
	    }
	}

	

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = 	tblLS.getSelectedRow();
		txtMaLoaiSach.setText(tblLS.getValueAt(row, 0).toString());
		txtTenLoaiSach.setText(tblLS.getValueAt(row, 1).toString());
		txtMoTa.setText(tblLS.getValueAt(row, 2).toString());
		txtVAT.setText(tblLS.getValueAt(row, 3).toString());
		txtMoTa.setEditable(false);
		txtVAT.setEditable(false);
		txtTenLoaiSach.setEditable(false);
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
