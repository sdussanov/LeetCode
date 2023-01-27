import java.util.Arrays;

class PlusOne {

    public static void main(String[] args) {
        int[] digits1 = new int[]{1, 2, 3};
        int[] digits2 = new int[]{4, 3, 2, 1};
        int[] digits3 = new int[]{9};
        int[] digits4 = new int[]{5, 5, 9, 9};

        System.out.println(Arrays.toString(plusOne3(digits1)));
        System.out.println(Arrays.toString(plusOne3(digits2)));
        System.out.println(Arrays.toString(plusOne3(digits3)));
        System.out.println(Arrays.toString(plusOne3(digits4)));
    }

    public static int[] plusOne1(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newNumber = new int[digits.length + 1];
        newNumber[0] = 1;
        return newNumber;
    }

    public static int[] plusOne2(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;
        return newNumber;
    }

    public static int[] plusOne3(int[] digits) {
        int head = digits.length - 1;
        while (((digits[head] + 1) / 10) > 0) {
            digits[head--] = 0;
            if (head == -1) {
                return insertAnElementAtAGivenIndex(digits, 0, 1);
            }
        }
        digits[head] += 1;
        return digits;
    }

    public static int[] insertAnElementAtAGivenIndex(final int[] srcArray, int index, int newElement) {
        int[] destArray = new int[srcArray.length + 1];
        int j = 0;
        for (int i = 0; i < destArray.length - 1; i++) {
            if (i == index) {
                destArray[i] = newElement;
            } else {
                destArray[i] = srcArray[j];
                j++;
            }
        }
        return destArray;
    }
}