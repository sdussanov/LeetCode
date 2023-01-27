import java.util.ArrayList;

class RemoveDuplicatesSortedArray {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 2, 3, 4, 4, 5, 6};

        System.out.println(removeDuplicates3(nums));
    }

    public static int removeDuplicates1(int[] nums) {
        ArrayList<Number> dummy = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!dummy.contains(nums[i])) {
                dummy.add(nums[i]);
            }
            for (int j = 0; j < dummy.size(); j++) {
                nums[j] = (int) dummy.get(j);
            }
        }
        return dummy.size();
    }

    public static int removeDuplicates2(int[] nums) {
        ArrayList<Integer> dummy = new ArrayList<>();
        for (int i : nums) if (!dummy.contains(i)) dummy.add(i);
        int i = 0;
        for (int j : dummy) nums[i++] = j;
        return dummy.size();
    }

    public static int removeDuplicates3(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}