import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    private static final Map<String, Integer> ROMAN_TO_INT = new HashMap<String, Integer>() {{
        put("I", 1);
        put("IV", 4);
        put("V", 5);
        put("IX", 9);
        put("X", 10);
        put("XL", 40);
        put("L", 50);
        put("XC", 90);
        put("C", 100);
        put("CD", 400);
        put("D", 500);
        put("CM", 900);
        put("M", 1000);
    }};

    public static void main(String[] args) {
        String str0 = "VI";
        String str1 = "LIX";
        String str2 = "LVIII";
        String str3 = "MCMXCIV";

        System.out.println(romanToInt5(str0));
        System.out.println(romanToInt5(str1));
        System.out.println(romanToInt5(str2));
        System.out.println(romanToInt5(str3));

    }


    static int romanToInt1(String s) {
        char[] charArray = s.toCharArray();
        int result = 0;
        int number;
        int j;

        for (int i = 0; i < charArray.length; i++) {
            j = i + 1;
            switch (charArray[i]) {
                case 'I':
                    if (j < charArray.length && charArray[j] == 'V' || j < charArray.length && charArray[j] == 'X') {
                        number = -1;
                    } else {
                        number = 1;
                    }
                    break;
                case 'V':
                    number = 5;
                    break;
                case 'X':
                    if (j < charArray.length && charArray[j] == 'L' || j < charArray.length && charArray[j] == 'C') {
                        number = -10;
                    } else {
                        number = 10;
                    }
                    break;
                case 'L':
                    number = 50;
                    break;
                case 'C':
                    if (j < charArray.length && charArray[j] == 'D' || j < charArray.length && charArray[j] == 'M') {
                        number = -100;
                    } else {
                        number = 100;
                    }
                    break;
                case 'D':
                    number = 500;
                    break;
                case 'M':
                    number = 1000;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + s);
            }
            result += number;
        }
        return result;
    }


    static int romanToInt2(String s) {
        int result = 0;
        int number;
        int j;

        for (int i = 0; i < s.length(); i++) {
            j = i + 1;
            switch (s.charAt(i)) {
                case 'I':
                    if (j < s.length() && s.charAt(j) == 'V' || j < s.length() && s.charAt(j) == 'X') {
                        number = -1;
                    } else {
                        number = 1;
                    }
                    break;
                case 'V':
                    number = 5;
                    break;
                case 'X':
                    if (j < s.length() && s.charAt(j) == 'L' || j < s.length() && s.charAt(j) == 'C') {
                        number = -10;
                    } else {
                        number = 10;
                    }
                    break;
                case 'L':
                    number = 50;
                    break;
                case 'C':
                    if (j < s.length() && s.charAt(j) == 'D' || j < s.length() && s.charAt(j) == 'M') {
                        number = -100;
                    } else {
                        number = 100;
                    }
                    break;
                case 'D':
                    number = 500;
                    break;
                case 'M':
                    number = 1000;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + s);
            }
            result += number;
        }
        return result;
    }


    static int romanToInt3(String s) {

        int result = 0, number = 0, prev = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            switch (s.charAt(i)) {
                case 'M' -> number = 1000;
                case 'D' -> number = 500;
                case 'C' -> number = 100;
                case 'L' -> number = 50;
                case 'X' -> number = 10;
                case 'V' -> number = 5;
                case 'I' -> number = 1;
            }
            if (number < prev) {
                result -= number;
            } else {
                result += number;
            }
            prev = number;
        }
        return result;
    }


    static int romanToInt4(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int s1 = value(s.charAt(i));
            if (i + 1 < s.length()) {
                int s2 = value(s.charAt(i + 1));
                if (s1 >= s2) {
                    result = result + s1;
                } else {
                    result = result + s2 - s1;
                    i++;
                }
            } else {
                result = result + s1;
                i++;
            }
        }
        return result;
    }


    static int value(char r) {
        if (r == 'I')
            return 1;
        if (r == 'V')
            return 5;
        if (r == 'X')
            return 10;
        if (r == 'L')
            return 50;
        if (r == 'C')
            return 100;
        if (r == 'D')
            return 500;
        if (r == 'M')
            return 1000;
        return -1;
    }


    static int romanToInt5(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i + 1 < s.length() && ROMAN_TO_INT.containsKey(s.substring(i, i + 2))) {
                result += ROMAN_TO_INT.get(s.substring(i, i + 2));
                i++;
            } else {
                result += ROMAN_TO_INT.get(s.substring(i, i + 1));
            }
        }
        return result;
    }

}

