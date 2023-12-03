package gui;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class a {
    public static void generateInvoice(String customerName, String itemName, double itemPrice, int quantity, String filePath) {
        Document document = new Document();

        try {
            // Sử dụng font 'Helvetica' thay vì 'Arial Unicode MS'
            com.itextpdf.text.Font font = new com.itextpdf.text.Font(BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED));

            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();

            // Thêm thông tin hóa đơn
            document.add(new Paragraph("HÓA ĐƠN", font));
            document.add(new Paragraph("Ngày: " + getCurrentDate(), font));
            document.add(new Paragraph("Khách hàng: " + customerName, font));
            document.add(new Paragraph("-------------------------------", font));

            // Thêm chi tiết hóa đơn
            document.add(new Paragraph("Sản phẩm: " + itemName, font));
            document.add(new Paragraph("Đơn giá: " + itemPrice, font));
            document.add(new Paragraph("Số lượng: " + quantity, font));
            document.add(new Paragraph("Thành tiền: " + calculateTotal(itemPrice, quantity), font));
            document.add(new Paragraph("-------------------------------", font));

            // Thêm tổng cộng
            document.add(new Paragraph("Tổng cộng: " + calculateTotal(itemPrice, quantity), font));

        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        } finally {
            if (document != null) {
                document.close();
            }
        }
    }

    private static String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return dateFormat.format(new Date());
    }

    private static double calculateTotal(double price, int quantity) {
        return price * quantity;
    }

    public static void main(String[] args) {
        // Gọi hàm generateInvoice để tạo và xuất file PDF hóa đơn
        String customerName = "Khách hàng A";
        String itemName = "Sản phẩm XYZ";
        double itemPrice = 50.0;
        int quantity = 2;
        String filePath = "D:\\a.pdf";

        generateInvoice(customerName, itemName, itemPrice, quantity, filePath);
        System.out.println("File PDF hóa đơn đã được tạo tại: " + filePath);
    }
}
