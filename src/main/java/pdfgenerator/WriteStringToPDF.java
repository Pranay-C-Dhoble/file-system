package pdfgenerator;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

public class WriteStringToPDF {

    public static void main(String[] args) {
        String textToWrite = "Hello, this is a sample text for the PDF document.";

        try {
            // Create a new PDF document
            PDDocument document = new PDDocument();

            // Create a new page
            PDPage page = new PDPage();
            document.addPage(page);

            // Create a content stream for the page
            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            // Set font and font size
            contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD), 12);

            // Set starting position for the text
            float startX = 50;
            float startY = page.getMediaBox().getHeight() - 50; //getMediaBox() returns the page size
            //getHeigh() returns the height of the page

            // Write the text to the page
            contentStream.beginText();
            contentStream.newLineAtOffset(startX, startY);
            contentStream.showText(textToWrite);
            contentStream.endText();

            // Close the content stream
            contentStream.close();

            // Save the document to a file
            document.save("src/main/resources/HelloWorld.pdf");

            // Close the document
            document.close();

            System.out.println("PDF created successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
