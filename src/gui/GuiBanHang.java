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
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;

public class GuiBanHang extends JFrame implements ActionListener {

	private JPanel contentPane;
	private DefaultTableModel modelKH;

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
		pnlTieuDe.setBounds(15, 15, 1889, 60);
		pnlTieuDe.setBackground(new Color(255, 255, 255));
		contentPane.add(pnlTieuDe);
		
		JLabel lblTieuDe = new JLabel("LẬP HÓA ĐƠN");
		lblTieuDe.setBackground(new Color(51, 204, 255));
		pnlTieuDe.add(lblTieuDe);
		lblTieuDe.setFont(font1);
		lblTieuDe.setForeground(new Color(0, 204, 204));;

		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
