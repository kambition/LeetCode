import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {

        Main1 main1 = new Main1();
        int[] nums = {0,1,4,6,7,10};
        int diff = 3;
        System.out.println(main1.arithmeticTriplets(nums,diff));
    }

    public int arithmeticTriplets(int[] nums, int diff) {

        int length = nums.length;
        int res = 0;

        if (nums == null || length == 0) {
            return res;
        }

        for (int i = 0; i < length; i++) {

            // 双指针
            int left = i + 1, right = length - 1;

            while (left < right) {
                if (nums[left] - nums[i] == diff && nums[right] - nums[left] == diff) {
                    res++;
                    left++;
                    right--;
                } else if (nums[left] - nums[i] == diff) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }
}
