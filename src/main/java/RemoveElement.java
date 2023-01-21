import java.util.Arrays;

public class RemoveElement {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2, 2, 3, 4, 7, 7, 8};
        int k = removeElement3(nums, 2);

        System.out.println("Unique items: " + k);
        System.out.println(Arrays.toString(nums));
    }


    static int removeElement1(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }


    static int removeElement2(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int head = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[head++] = nums[i];
            }
        }
        return head;
    }


    static int removeElement3(int[] nums, int val) {
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
