import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * Created by admin on 12.02.2019.
 */
public class PerfectMatchTest {

    private PerfectMatchCalc pmc;

    @Before
    public void prepare() {
        pmc = new PerfectMatchCalc();
    }

    @Test
    public void simpleTest() {
        List<Integer> nums = Arrays.asList(1,3,4,7);
        final Integer total = 10;
        List<Integer> calculatedList = pmc.calculateList(total, nums);
        Integer totalCalculated = calculatedList.stream().mapToInt(i -> i).sum();
        assertEquals(total, totalCalculated);
    }

    @Test
    public void unsortedListTest() {
        List<Integer> nums = Arrays.asList(7,4,3,1);
        Integer total = 10;
        List<Integer> calculatedList = pmc.calculateList(total, nums);
        Integer totalCalculated = calculatedList.stream().mapToInt(i -> i).sum();
        assertEquals(total, totalCalculated);
    }

    @Test
    public void biggerListTest() {
        List<Integer> nums = Arrays.asList(1,2,3,4,5,6,8);
        Integer total = 21;
        List<Integer> calculatedList = pmc.calculateList(total, nums);
        Integer totalCalculated = calculatedList.stream().mapToInt(i -> i).sum();
        assertEquals(total, totalCalculated);
    }

    @Test
    public void maxTotalTest() {
        List<Integer> nums = Arrays.asList(1,3,5,7,9,100);
        Integer total = 125;
        List<Integer> calculatedList = pmc.calculateList(total, nums);
        Integer totalCalculated = calculatedList.stream().mapToInt(i -> i).sum();
        assertEquals(total, totalCalculated);
    }

}