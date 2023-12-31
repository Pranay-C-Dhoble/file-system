package file_handling.writer.convert_to_pdf;

import file_handling.writer.IFileWriter;
import org.apache.pdfbox.pdmodel.PDDocument;


import java.util.List;

public class CsvToPDFConverter implements IFileWriter {
    @Override
    public void write(List data, String outputPath) {
        try {
            //how to write in pdf file from list
            PDDocument doc = new PDDocument();
            doc.save(outputPath);
            doc.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
