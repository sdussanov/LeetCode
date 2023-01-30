import java.util.Arrays;

class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int[] nums1 = new int[]{2, 3, 4, 5};
        int[] nums2 = new int[]{-1, 1, 0, -3, 3};

        System.out.println(Arrays.toString(productExceptSelf2(nums1)));
        System.out.println(Arrays.toString(productExceptSelf2(nums2)));
    }

    public static int[] productExceptSelf1(int[] nums) {
        int[] result = new int[nums.length];
        int product = 1;
        int countZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                countZero++;
            } else {
                product *= nums[i];
            }
        }
        if (countZero > 1) {
            return result;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                result[i] = product;
            } else if (countZero == 1) {
                result[i] = 0;
            } else {
                result[i] = product / nums[i];
            }
        }
        return result;
    }

    public static int[] productExceptSelf2(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        int rightProduct = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= rightProduct;
            rightProduct *= nums[i];
        }
        return result;
    }
}