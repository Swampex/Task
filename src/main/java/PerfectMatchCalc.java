import java.util.*;

/**
 * Created by admin on 12.02.2019.
 */
public class PerfectMatchCalc {

    private List<Integer> nums;
    private int total;
    private Map<Integer, List<Integer>> perfectMatch = new HashMap<Integer, List<Integer>>();

    PerfectMatchCalc() {
    }

    public List<Integer> calculateList(int total, List nums) {
        this.nums = nums;
        this.total = total;
        Collections.sort(nums);
        for (int i=0; i<nums.size(); i++) {
            getCombinationForIndex(i);
        }
        printPerfectMatch();
        return getListWithMaxSum();
    }

    private void getCombinationForIndex(Integer index) {
        int sum=nums.get(index);
        List<Integer> perfectNumbers = new ArrayList<Integer>(Arrays.asList(nums.get(index)));
        for (int i=index+1; i<nums.size(); i++) {
            for (int gap=i; gap<nums.size(); gap++) {
                if (sum+nums.get(gap)>total) {
                    if (sum==nums.get(index)) {
                        perfectNumbers.add(nums.get(gap));
                        perfectMatch.put(nums.get(gap), perfectNumbers);
                        perfectNumbers = new ArrayList<Integer>(Arrays.asList(nums.get(index)));
                        sum=nums.get(index);
                    }
                    perfectMatch.put(sum, perfectNumbers);
                    perfectNumbers = new ArrayList<Integer>(Arrays.asList(nums.get(index)));
                    sum=nums.get(index);
                }
                else {
                    sum += nums.get(gap);
                    perfectNumbers.add(nums.get(gap));
                    if (i==this.nums.size()-1) {
                        perfectMatch.put(sum, perfectNumbers);
                        perfectNumbers = new ArrayList<Integer>(Arrays.asList(nums.get(index)));
                        sum=nums.get(index);
                    }
                }
            }
        }
    }

    private void printPerfectMatch() {
        Set<Integer> keys = perfectMatch.keySet();
        for (Integer key : keys) {
            System.out.println(key + ": " + Arrays.toString(perfectMatch.get(key).toArray()));
        }
    }

    private List getListWithMaxSum() {
        Integer maxSum = Collections.max(perfectMatch.keySet());
        return perfectMatch.get(maxSum);
    }

}
