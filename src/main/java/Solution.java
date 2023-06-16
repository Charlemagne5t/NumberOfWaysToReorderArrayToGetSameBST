
import java.util.ArrayList;

import java.util.List;

public class Solution {
    public int numOfWays(int[] nums) {
        int mod = 1_000_000_000 + 7;
        java.math.BigInteger[] factorials = new java.math.BigInteger[nums.length + 1];
        factorials[0] = java.math.BigInteger.ONE;
        factorials[1] = java.math.BigInteger.ONE;
        for (int i = 2; i < nums.length + 1; i++) {
            factorials[i] = factorials[i - 1].multiply(java.math.BigInteger.valueOf(i));
        }
        List<Integer> listOfNums = new ArrayList<>();
        for (int num : nums) {
            listOfNums.add(num);
        }
        return ways(listOfNums, factorials).mod(java.math.BigInteger.valueOf(mod)).intValue() - 1;
    }

    private java.math.BigInteger ways(List<Integer> nums, java.math.BigInteger[] factorials) {
        if (nums.size() <= 2) {
            return java.math.BigInteger.ONE;
        }

        int rootVal = nums.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) < rootVal) {
                left.add(nums.get(i));
            } else right.add(nums.get(i));
        }

        return ways(left, factorials)
                .multiply(ways(right, factorials))
                .multiply(combinations(left.size(), right.size(), factorials));

    }

    private java.math.BigInteger combinations(int leftLength, int rightLength, java.math.BigInteger[] factorials) {

        return factorials[leftLength + rightLength]
                .divide(factorials[leftLength])
                .divide(factorials[rightLength]);
    }

}