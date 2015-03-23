package pl.mszarlinski.talks.cp.excersise.java7;

import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.spy;
import static pl.mszarlinski.talks.cp.commons.IOTestUtil.getFile;

/**
 * Created by Maciej on 2015-03-18.
 */
public class Ex01_Try {

    private LinesCounter linesCounter = new LinesCounter();

    /**
     * TODO: Rewrite code of LinesCounter using try-with-resources.
     */
    @Test
    public void shouldCloseResource() throws IOException {
        // given
        FileReader fileReader = spy(new FileReader(getFile("/test.txt", this)));
        // when
        linesCounter.countLines(fileReader);
        // then
        verify(fileReader).close();
    }

}
