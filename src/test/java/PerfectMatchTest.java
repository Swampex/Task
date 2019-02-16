import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by admin on 12.02.2019.
 */
public class PerfectMatchTest {

    @Test
    public void simpleTest() {
        List<Integer> nums = Arrays.asList(1,3,4,7);
        List<Integer> perfectList = Arrays.asList(3,7);
        Integer total = 10;
        PerfectMatchCalc pmc = new PerfectMatchCalc(total, nums);
        assertEquals(perfectList, pmc.calculateList());
    }

    @Test
    public void unsortedListTest() {
        List<Integer> nums = Arrays.asList(7,4,3,1);
        List<Integer> perfectList = Arrays.asList(3,7);
        Integer total = 10;
        PerfectMatchCalc pmc = new PerfectMatchCalc(total, nums);
        assertEquals(perfectList, pmc.calculateList());
    }

    @Test
    public void biggerListTest() {
        List<Integer> nums = Arrays.asList(1,2,3,4,5,6);
        List<Integer> perfectList = Arrays.asList(1,3,5,6);
        Integer total = 17;
        PerfectMatchCalc pmc = new PerfectMatchCalc(total, nums);
        assertEquals(perfectList, pmc.calculateList());
    }

}