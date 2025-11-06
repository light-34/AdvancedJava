import org.adv.apacheePOI.ApacheePOIDemo;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.collection.IsCollectionWithSize.*;
import static org.hamcrest.MatcherAssert.*;
public class ApacheePOIDemoTest {
    ApacheePOIDemo apacheePOIDemo = new ApacheePOIDemo();
    @Test
    public void testCreateWorkbook() {

        String expected = "it is written successfully";
        assertEquals(expected, apacheePOIDemo.createWorkbook());
    }

    @Test
    public void testOpenWorkbook() {
        String expected = "openworkbook.xlsx file open successfully";
        assertEquals(expected, apacheePOIDemo.openWorkbook());
    }
}
