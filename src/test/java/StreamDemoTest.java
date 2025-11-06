import org.adv.stream.StreamDemo;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class StreamDemoTest {
    List<String> days = Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday");

    @Test
    public void startWith() {
        List<String> result = StreamDemo.startsWith(days, "F");

        List<String> expected = Arrays.asList("Friday");
        assertEquals(expected, result );

    }
}
