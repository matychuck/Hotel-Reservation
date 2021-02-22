package hotelserver.pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import entities.Reservation;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PDFGenerator {
    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
    private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.RED);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
   
    public static void generatePDF(Reservation newReservation, int roomNumber, String filePath) throws Exception {
        System.out.println("PDF generating...");
        Document document=new Document();
        PdfWriter.getInstance(document, new FileOutputStream(filePath+newReservation.getReservationId()+".pdf"));
        document.open();  
        
        Paragraph preface = new Paragraph();
        addEmptyLine(preface, 1);
        preface.add(new Paragraph("Booking Confimation", catFont));
        addEmptyLine(preface, 3);
        document.add(preface);
        
        DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");  
        String dateFromString =  dateFormat.format(newReservation.getDateFrom());  
        String dateToString = dateFormat.format(newReservation.getDateTo());
        
        PdfPTable table = new PdfPTable(2);
        table.addCell("Reservation ID");
        table.addCell(String.valueOf(newReservation.getReservationId()));
        table.addCell("Room number");
        table.addCell(String.valueOf(roomNumber));
        table.addCell("Date from");
        table.addCell(dateFromString);
        table.addCell("Date to");
        table.addCell(dateToString);
        table.addCell("Days amount");
        table.addCell(String.valueOf(newReservation.getDaysAmount()));
        table.addCell("Price");
        table.addCell(String.valueOf(newReservation.getPrice()+" zl"));
        document.add(table);
             
        Paragraph warning = new Paragraph();
        addEmptyLine(warning, 3);
        warning.add(new Paragraph("You must show this document when you arrive at the hotel", redFont));
        addEmptyLine(warning, 1);
        warning.add(new Paragraph("Do not forget it!", smallBold));
        addEmptyLine(warning, 10);
        document.add(warning);
             
        document.add(new Paragraph("Confirmation generated at: "+new Date(), smallBold));
        
        document.close(); 
        System.out.println("PDF generating finished");
    }
      
    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }
}
