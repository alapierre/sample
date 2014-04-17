/*
 * Copyright 2011-08-31 the original author or authors.
 */
package pl.com.softproject.utils.sample.io;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
public class ReadLineSample {

    public static void main(String[] args) {

        File file = new File("src/test/resources/test1.txt");

        LineIterator it = null;
        try {
            it = FileUtils.lineIterator(file, "UTF-8");
            while (it.hasNext()) {
                String line = it.nextLine();
                System.out.println(line);
                /// do something with line
            }
        } catch (IOException ex) {
            Logger.getLogger(ReadLineSample.class.getName()).log(Level.SEVERE, "problem z odczyten danych", ex);
        } finally {
            LineIterator.closeQuietly(it);
        }

    }

}
