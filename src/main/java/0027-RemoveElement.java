import java.util.Arrays;

class RemoveElement {

    public static void main(String[] args) {
        int[] nums1 = new int[]{3, 2, 2, 3};
        int[] nums2 = new int[]{0, 1, 2, 2, 3, 0, 4, 2};

        System.out.println(removeElement3(nums1, 2));
        System.out.println(Arrays.toString(nums1));
        System.out.println(removeElement3(nums2, 2));
        System.out.println(Arrays.toString(nums2));
    }

    public static int removeElement1(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public static int removeElement2(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int head = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[head++] = nums[i];
            }
        }
        return head;
    }

    public static int removeElement3(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                n--;
            } else {
                i++;
            }
        }
        return n;
    }
}