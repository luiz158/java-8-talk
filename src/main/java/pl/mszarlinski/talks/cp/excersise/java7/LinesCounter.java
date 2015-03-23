package pl.mszarlinski.talks.cp.excersise.java7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Maciej on 2015-03-18.
 */
public class LinesCounter {

    public int countLines(final FileReader fileReader) {
        BufferedReader br = new BufferedReader(fileReader);
        int count = 0;
        try {
            while (br.readLine() != null) {
                count++;
            }
            return count;
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
