package filehandling.writer.converttopdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import filehandling.writer.IFileWriter;

import java.io.FileOutputStream;
import java.util.List;

public class PdfConverter implements IFileWriter {
    @Override
    public void write(List data, String outputPath) {
        System.out.println(data.size() +" "+ outputPath);
        Document pdfDoc =  new Document();
        try{
            PdfWriter pdfWriter = PdfWriter.getInstance(pdfDoc,new FileOutputStream(outputPath));
            String nextLine;
            pdfDoc.open();
            PdfPTable table = new PdfPTable(7);
            String tablecell;
            table.addCell("Index");
            table.addCell("squareFeet");
            table.addCell("bedrooms");
            table.addCell("bathrooms");
            table.addCell("neighbourhood");
            table.addCell("year");
            table.addCell("price");
            int index = 1;
            for (Object datum : data) {
                nextLine = datum.toString();
                String[] nextLineArray = nextLine.split(",");
                table.addCell(String.valueOf(index++));
                for (int j = 0; j < nextLineArray.length; j++) {
                    tablecell = nextLineArray[j];
                    table.addCell(tablecell);
                }
            }
            System.out.println("Size of table : "+ table.size());
            pdfDoc.add(table);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("File converted to pdf.");
            pdfDoc.close();
        }
    }
}
