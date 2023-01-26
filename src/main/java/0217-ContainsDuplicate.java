import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class ContainsDuplicate {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 1};
        int[] nums2 = new int[]{1, 2, 3, 4};
        int[] nums3 = new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2};

        System.out.println(containsDuplicate3(nums1));
        System.out.println(containsDuplicate3(nums2));
        System.out.println(containsDuplicate3(nums3));
    }

    public static boolean containsDuplicate1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsDuplicate2(int[] nums) {
        Map<Integer, Integer> uniques = new HashMap<>();
        for (int num : nums) {
            if (uniques.containsKey(num)) {
                return true;
            }
            uniques.put(num, uniques.getOrDefault(num, 0) + 1);
        }
        return false;
    }

    public static boolean containsDuplicate3(int[] nums) {
        HashSet<Integer> uniques = new HashSet<>();
        for (int num : nums) {
            if (!uniques.add(num)) {
                return true;
            }
        }
        return false;
    }
}
