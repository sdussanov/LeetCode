import java.util.ArrayList;
import java.util.Arrays;

public class PalindromeNumber {

    public static void main(String[] args) {

        int x = 0;
        int y = -121;
        int z = 10;

        System.out.println(isPalindrome4(x));
        System.out.println(isPalindrome4(y));
        System.out.println(isPalindrome4(z));

    }


    static boolean isPalindrome1(int x) {
        String stringValue = Integer.toString(x);
        char[] charArray = stringValue.toCharArray();
        System.out.println(Arrays.toString(charArray));
        int j = charArray.length - 1;
        for (char c : charArray) {
            if (c == charArray[j]) {
                j--;
            } else {
                return false;
            }
        }
        return true;
    }


    static boolean isPalindrome2(int x) {
        if (x >= 0) {
            ArrayList<Integer> stack = new ArrayList<>();
            while (x > 0) {
                stack.add(x % 10);
                x = x / 10;
            }

            int j = stack.size() - 1;
            for (int c : stack) {
                if (c == stack.get(j)) {
                    j--;
                } else {
                    return false;
                }
            }
            return true;
        }
        return false;
    }


    static boolean isPalindrome3(int x) {
        String original = Integer.toString(x);
        String reverse = new StringBuilder(original).reverse().toString();
        return original.equals(reverse);
    }


    static boolean isPalindrome4(int x) {
        if (x >= 0) {
            int originalNumber = x;
            int reverse = 0;
            while (x != 0) {
                int lastDigit = x % 10;
                reverse = (reverse * 10) + lastDigit;
                x /= 10;
            }
            return originalNumber == reverse;
        }
        return false;
    }
}
