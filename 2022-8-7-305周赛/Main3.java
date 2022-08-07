public class Main3 {

    public static void main(String[] args) {

        Main3 main3 = new Main3();
        int[] nums = {4,4,4,5,6};
        System.out.println(main3.validPartition(nums));

    }

    public boolean validPartition(int[] nums) {

        int length = nums.length;
        boolean[] dp = new boolean[length+1];
        dp[0] = true;


        for (int i = 1; i < length; i++) {

            if (nums[i] == nums[i-1] && dp[i-1] ||
                i >= 2 && nums[i] == nums[i-1] && nums[i-1] == nums[i-2] && dp[i-2] ||
                i >= 2 && nums[i] - nums[i-1] == 1 && nums[i-1] - nums[i-2]  == 1 && dp[i-2]) {
                dp[i+1] = true;
            }

        }

        return dp[length];
    }
}
