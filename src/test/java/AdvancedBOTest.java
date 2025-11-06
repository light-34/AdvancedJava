import org.adv.BO.AdvancedBO;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.collection.IsCollectionWithSize.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.List;

public class AdvancedBOTest {

    @Test
    public void listTest() {
        Integer [] num = {1, 2, 3};
        List<Integer> numList = AdvancedBO.convertArrayToList(num);
        assertThat(numList, hasSize(2));

    }

    @Test
    public void numberListTest() {
        Double [] num = {1.0, 2.3, 3.3, 5.3, 8.9};
        List<Double> numList = AdvancedBO.convertNumberArrayToList(num);
        assertThat(numList, hasSize(5));
    }

}
