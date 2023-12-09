package gui;

import com.itextpdf.text.*;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.Font;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class a extends JFrame {

    private PdfPTable tableProducts;
	private PdfPTable tableTien;

	public a() throws DocumentException, IOException {
    	
        initializeFonts();
        createGUI();
    }

    private void initializeFonts() {
        try {
        	String fontPath = "src/font/DejaVuSans.ttf";
        	 

        	BaseFont baseFont = BaseFont.createFont(fontPath, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);

        	com.itextpdf.text.Font fontTieuDe = new com.itextpdf.text.Font(baseFont, 15, Font.BOLD);
        	com.itextpdf.text.Font fontHead = new com.itextpdf.text.Font(baseFont, 12, Font.BOLD);
        	com.itextpdf.text.Font font = new com.itextpdf.text.Font(baseFont, 12, Font.PLAIN);
        	
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createGUI() throws DocumentException, IOException {
        setTitle("Hóa Đơn");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Phần trên là thông tin cửa hàng
        String fontPath = "src/font/DejaVuSans.ttf";
        

    	BaseFont baseFont = BaseFont.createFont(fontPath, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);

    	com.itextpdf.text.Font fontTieuDe = new com.itextpdf.text.Font(baseFont, 15, Font.BOLD);
    	com.itextpdf.text.Font fontHead = new com.itextpdf.text.Font(baseFont, 12, Font.BOLD);
    	com.itextpdf.text.Font font = new com.itextpdf.text.Font(baseFont, 12, Font.PLAIN);
    	
        Paragraph storeInfo = new Paragraph();
        storeInfo.add(new Paragraph("Tên Cửa Hàng: Cửa Hàng ABC", font));
        storeInfo.add(new Paragraph("Nhân Viên: Người Bán", font));
        storeInfo.add(new Paragraph("Ngày Thanh Toán: " + getCurrentDate(), font));
        storeInfo.setAlignment(Element.ALIGN_LEFT);

        // Bảng sản phẩm
        createProductTable();

        // Phần dưới là thông tin thanh toán
        
        Paragraph paymentInfo = new Paragraph();
        paymentInfo.add(new Paragraph("Tổng Tiền: 1000000", font));
        paymentInfo.add(new Paragraph("Khấu Trừ: 100000", font));
        paymentInfo.add(new Paragraph("Thành Tiền: 900000", font));
        paymentInfo.add(new Paragraph("Tiền Thối: 100000", font));
        paymentInfo.setAlignment(Element.ALIGN_LEFT);

        // Tạo document và thêm các phần vào document
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("hoadon.pdf"));
            document.open();

            document.add(storeInfo);
            document.add(Chunk.NEWLINE); // Để tạo khoảng cách giữa các phần
            document.add(tableProducts);
            document.add(Chunk.NEWLINE);
            document.add(tableTien);
            document.add(Chunk.NEWLINE);
            document.add(paymentInfo);

        } catch (DocumentException | java.io.IOException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }

        add(mainPanel);
        setVisible(true);
    }

 // ... (các phần khác của class)

    private void createProductTable() throws DocumentException, IOException {
        String fontPath = "src/font/DejaVuSans.ttf";

        BaseFont baseFont = BaseFont.createFont(fontPath, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);

        com.itextpdf.text.Font fontTieuDe = new com.itextpdf.text.Font(baseFont, 15, Font.BOLD);
        com.itextpdf.text.Font fontHead = new com.itextpdf.text.Font(baseFont, 12, Font.BOLD);
        com.itextpdf.text.Font font = new com.itextpdf.text.Font(baseFont, 12, Font.PLAIN);

        tableProducts = new PdfPTable(3);
        tableProducts.setWidthPercentage(100);

        PdfPCell cellProductName = new PdfPCell(new Paragraph("Sản Phẩm", fontHead));
        PdfPCell cellQuantity = new PdfPCell(new Paragraph("Số Lượng", fontHead));
        PdfPCell cellPrice = new PdfPCell(new Paragraph("Đơn Giá", fontHead));

        // Chừa lại đường viền cho từng ô trong hàng header
        cellProductName.setBorder(Rectangle.BOTTOM);
        cellQuantity.setBorder(Rectangle.BOTTOM);
        cellPrice.setBorder(Rectangle.BOTTOM);

        tableProducts.addCell(cellProductName);
        tableProducts.addCell(cellQuantity);
        tableProducts.addCell(cellPrice);

        // Thêm dữ liệu sản phẩm (chỉ để minh họa, bạn cần thay thế bằng dữ liệu thực tế)
        String[] products = {"Sách A", "Sách B", "Sách C"};
        int[] quantities = {2, 1, 3};
        double[] prices = {100000, 150000, 200000};

        for (int i = 0; i < products.length; i++) {
            PdfPCell cellProduct = new PdfPCell(new Paragraph(products[i], font));
            PdfPCell cellQuantityValue = new PdfPCell(new Paragraph(String.valueOf(quantities[i]), font));
            PdfPCell cellPriceValue = new PdfPCell(new Paragraph(String.valueOf(prices[i]), font));

            // Loại bỏ đường viền cho từng ô trong dòng (trừ hàng header)
            cellProduct.setBorder(PdfPCell.NO_BORDER);
            cellQuantityValue.setBorder(PdfPCell.NO_BORDER);
            cellPriceValue.setBorder(PdfPCell.NO_BORDER);

            tableProducts.addCell(cellProduct);
            tableProducts.addCell(cellQuantityValue);
            tableProducts.addCell(cellPriceValue);
        }
        
        tableTien = new PdfPTable(3);
        tableTien.setWidthPercentage(100);
        
        PdfPCell a = new PdfPCell(new Paragraph("Tổng tiền", fontHead));
        PdfPCell b = new PdfPCell(new Paragraph("", fontHead));
        PdfPCell c = new PdfPCell(new Paragraph("100000", fontHead));
        
        a.setBorder(PdfPCell.NO_BORDER);
        b.setBorder(PdfPCell.NO_BORDER);
        c.setBorder(PdfPCell.NO_BORDER);

        tableTien.addCell(a);
        tableTien.addCell(b);
        tableTien.addCell(c);
        
        
    }
    // ... (các phần khác của class)


    private String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(new Date());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
			try {
				new a();
			} catch (DocumentException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
    }
}
