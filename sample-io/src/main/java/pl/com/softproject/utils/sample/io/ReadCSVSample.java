/*
 * Copyright 2011-08-31 the original author or authors.
 */
package pl.com.softproject.utils.sample.io;

import com.csvreader.CsvReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
public class ReadCSVSample {

    public static void main(String[] args) {

        try {
            CsvReader products = new CsvReader("src/test/resources/products.csv", ',', Charset.forName("UTF-8"));

            products.readHeaders();

            while (products.readRecord()) {
                String productID = products.get("ProductID");
                String productName = products.get("ProductName");
                String supplierID = products.get("SupplierID");
                String categoryID = products.get("CategoryID");
                String quantityPerUnit = products.get("QuantityPerUnit");
                String unitPrice = products.get("UnitPrice");
                String unitsInStock = products.get("UnitsInStock");
                String unitsOnOrder = products.get("UnitsOnOrder");
                String reorderLevel = products.get("ReorderLevel");
                String discontinued = products.get("Discontinued");

                // perform program logic here
                System.out.println(productID + ":" + productName);
            }

            products.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadCSVSample.class.getName()).log(Level.SEVERE, "błąd otwarcia pliku", ex);
        } catch (IOException ex) {
            Logger.getLogger(ReadCSVSample.class.getName()).log(Level.SEVERE, "błąd odczytu z pliku", ex);
        }

    }

}
