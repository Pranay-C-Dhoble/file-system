package filehandling.writer.converttopdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.*;

public class PdfDemo {
    public static void main(String[] args) {
        File Inputfile = new File("src/main/resources/Data/housing_price_dataset.csv");
        File Outputfile = new File("src/main/resources/Data/housing_price_dataset.pdf");
        try{
            Document pdfDoc =  new Document();
            PdfWriter pdfWriter = PdfWriter.getInstance(pdfDoc,new FileOutputStream(Outputfile));
            pdfDoc.open();
            pdfDoc.setMarginMirroring(true);
            pdfDoc.setMargins(36,36,36,36);
            pdfDoc.topMargin();

            BaseFont baseFont = BaseFont.createFont(BaseFont.COURIER,BaseFont.CP1252,BaseFont.EMBEDDED);
            Font myfont = new Font();

            Font bold_font = new Font();
            bold_font.setStyle(Font.BOLD);
            bold_font.setSize(9);

            pdfDoc.add(new Paragraph("\n"));

            if (Inputfile.exists()){
                FileInputStream fis = new FileInputStream(Inputfile);
                DataInputStream dis = new DataInputStream(fis);
                InputStreamReader Isr = new InputStreamReader(dis);
                BufferedReader breader = new BufferedReader(Isr);
                String line;
                while((line=breader.readLine()) != null){
                    Paragraph paragraph = new Paragraph(line+"\n",myfont);
                    paragraph.setAlignment(Element.ALIGN_JUSTIFIED);
                    pdfDoc.add(paragraph);
                }
                System.out.println("File converted to pdf.");
            }else {
                System.out.println("File dose not exist");
            }
            pdfDoc.close();
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}