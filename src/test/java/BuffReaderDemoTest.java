import org.adv.bufferedreader.BufferedReaderDemo;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

public class BuffReaderDemoTest {
    @Test
    void readTest() {
        String expected = "Hello - " +
                "Merhaba - " +
                "Merxaba - " +
                "Zdrastvite - " +
                "Privet - " +
                "Ola - ";
        assertEquals(expected, BufferedReaderDemo.readFileContentV1(new File("src/test/java/hello.txt")));
    }
}
