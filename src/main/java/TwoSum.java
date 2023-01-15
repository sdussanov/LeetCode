import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {

        int[] numsA = new int[]{2, 7, 11, 15};
        int[] numsB = new int[]{3, 2, 4};
        int[] numsC = new int[]{3, 3};
        int[] numsD = new int[]{1, 1, 1, 1};

        System.out.println(Arrays.toString(twoSum2(numsA, 9)));
        System.out.println(Arrays.toString(twoSum2(numsB, 6)));
        System.out.println(Arrays.toString(twoSum1(numsC, 6)));
        System.out.println(Arrays.toString(twoSum1(numsD, 2)));
    }


    static int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }


    static int[] twoSum2(int[] nums, int target) {
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

