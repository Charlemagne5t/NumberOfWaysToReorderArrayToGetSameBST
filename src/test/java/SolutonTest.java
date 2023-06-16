import org.junit.Assert;
import org.junit.Test;

public class SolutonTest {
    @Test
    public void numOfWaysTest1() {
        int[] nums = {2, 1, 3};
        int output = 1;
        Assert.assertEquals(output, new Solution().numOfWays(nums));
    }

    @Test
    public void numOfWaysTest2() {
        int[] nums = {3, 4, 5, 1, 2};
        int output = 5;
        Assert.assertEquals(output, new Solution().numOfWays(nums));
    }

    @Test
    public void numOfWaysTest3() {
        int[] nums = {1, 2, 3};
        int output = 0;
        Assert.assertEquals(output, new Solution().numOfWays(nums));
    }

}
