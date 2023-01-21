public class SearchInsertPosition {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 4, 7, 7, 8};
        int k = searchInsertPosition3(nums, 5);

        System.out.println("Position: " + k);
    }


    static int searchInsertPosition1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
            if (nums[i] > target) {
                return i;
            }
        }
        return nums.length;
    }


    static int searchInsertPosition2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }


    static int searchInsertPosition3(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) return i;
        }
        return nums.length;
    }

}

