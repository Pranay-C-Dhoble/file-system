package car.file.utils;
import java.io.FileOutputStream;
import java.io.*;

import java.io.FileReader;
import java.util.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.opencsv.CSVReader;

public class csv2pdf {
    public static void main(String[] args) throws Exception{

        /* Step -1 : Read input CSV file in Java */
        String inputCSVFile = "src/main/resources/AllCarData.csv";
        CSVReader reader = new CSVReader(new FileReader(inputCSVFile));
        /* Variables to loop through the CSV File */
        String [] nextLine; /* for every line in the file */
        int lnNum = 0; /* line number */
        /* Step-2: Initialize PDF documents - logical objects */
        Document mypdfdata = new Document();
        PdfWriter.getInstance(mypdfdata, new FileOutputStream("src/main/resources/AllCarData.pdf"));
        //getInstance method Creates an instance of a PDF writer.
        mypdfdata.open();
        PdfPTable myfirsttable = new PdfPTable(9);
        PdfPCell tablecell;
        /* Step -3: Loop through CSV file and populate data to PDF table */
        while ((nextLine = reader.readNext()) != null) {
            lnNum++;
            for(int i=0;i<nextLine.length;i++){
                tablecell=new PdfPCell(new Phrase(nextLine[i]));
                myfirsttable.addCell(tablecell);
            }
        }
        System.out.println("Total Number of Records in this CSV file= "+lnNum);
        /* Step -4: Attach table to PDF and close the document */
        mypdfdata.add(myfirsttable);
        mypdfdata.close();
    }
}