import java.util.ArrayList;
import java.util.Arrays;

class PalindromeNumber {

    public static void main(String[] args) {
        int x1 = 0;
        int x2 = -121;
        int x3 = 10;

        System.out.println(isPalindrome4(x1));
        System.out.println(isPalindrome4(x2));
        System.out.println(isPalindrome4(x3));
    }

    public static boolean isPalindrome1(int x) {
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

    public static boolean isPalindrome2(int x) {
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

    public static boolean isPalindrome3(int x) {
        String original = Integer.toString(x);
        String reverse = new StringBuilder(original).reverse().toString();
        return original.equals(reverse);
    }

    public static boolean isPalindrome4(int x) {
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