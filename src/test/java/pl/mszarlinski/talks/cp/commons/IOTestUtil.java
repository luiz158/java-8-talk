package pl.mszarlinski.talks.cp.commons;

/**
 * Created by Maciej on 2015-03-18.
 */
public class IOTestUtil {

    public static String getFile(final String fileName, final Object test) {
        return test.getClass().getResource(fileName).getFile();
    }
}
