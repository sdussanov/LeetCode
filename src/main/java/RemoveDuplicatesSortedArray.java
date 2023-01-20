import java.util.ArrayList;

public class RemoveDuplicatesSortedArray {
    public static void main(String[] args) {



    }


    static int removeDuplicates(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i : nums) if(!list.contains(i)) list.add(i);
        int i = 0;
        for(int j : list) nums[i++] = j;
        return list.size();
    }
}
