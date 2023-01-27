import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class TwoSum {

    public static void main(String[] args) {
        int[] nums1 = new int[]{2, 7, 11, 15};
        int[] nums2 = new int[]{3, 2, 4};
        int[] nums3 = new int[]{3, 3};
        int[] nums4 = new int[]{1, 1, 1, 1};

        System.out.println(Arrays.toString(twoSum2(nums1, 9)));
        System.out.println(Arrays.toString(twoSum2(nums2, 6)));
        System.out.println(Arrays.toString(twoSum1(nums3, 6)));
        System.out.println(Arrays.toString(twoSum1(nums4, 2)));
    }

    public static int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    public static int[] twoSum2(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }
}