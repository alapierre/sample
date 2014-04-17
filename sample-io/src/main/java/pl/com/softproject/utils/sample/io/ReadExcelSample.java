/*
 * Copyright 2011-08-31 the original author or authors.
 */
package pl.com.softproject.utils.sample.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
public class ReadExcelSample {

    public static void main(String[] args)  {

        FileInputStream file = null;
        try {
            file = new FileInputStream(new File("C:\\test.xls"));
            HSSFWorkbook workbook = new HSSFWorkbook(file);
            HSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadExcelSample.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReadExcelSample.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                file.close();
            } catch (IOException ex) {
                Logger.getLogger(ReadExcelSample.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
