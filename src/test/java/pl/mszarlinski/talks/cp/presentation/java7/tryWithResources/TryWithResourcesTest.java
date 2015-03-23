package pl.mszarlinski.talks.cp.presentation.java7.tryWithResources;

import org.junit.Test;

import java.io.*;

import static pl.mszarlinski.talks.cp.commons.IOTestUtil.getFile;

/**
 * Created by Maciej on 2015-03-13.
 */
public class TryWithResourcesTest {

    @Test
    public void testReadFile() {
        final String path = getFile("/test.txt", this);

        try (FileReader fileReader = new FileReader(path);
             BufferedReaderWithLogging br = new BufferedReaderWithLogging(fileReader)) { // every object must implement AutoCloseable!
            // --------------------------------------------------------------------

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            // --------------------------------------------------------------------
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }


}

class BufferedReaderWithLogging extends BufferedReader {
    public BufferedReaderWithLogging(Reader in) {
        super(in);
    }

    @Override
    public void close() throws IOException {
        System.out.println("##### close!");
        super.close();
    }
}