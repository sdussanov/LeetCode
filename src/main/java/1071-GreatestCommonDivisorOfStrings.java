class GreatestCommonDivisorOfStrings {

    public static void main(String[] args) {
        String str1 = "ABCABC";
        String str2 = "ABC";
        String str3 = "ABABAB";
        String str4 = "ABAB";

        System.out.println(gcdOfStrings4(str1, str2));
        System.out.println(gcdOfStrings4(str3, str4));
    }

    public static String gcdOfStrings1(String str1, String str2) {
        while (!str1.contains(str2)) {
            str2 = str2.substring(0, str2.length() - 1);
            if (str2.equals("")) {
                return "";
            }
        }
        if ((str2.substring(0, str2.length() / 2).equals(str2.substring(str2.length() / 2)))) {
            return str2.substring(str2.length() / 2);
        }
        return str2;
    }

    public static String gcdOfStrings2(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static String gcdOfStrings3(String str1, String str2) {
        if (str1.length() < str2.length()) {
            return gcdOfStrings3(str2, str1);
        }
        if (!str1.startsWith(str2)) {
            return "";
        }
        if (str2.isEmpty()) {
            return str1;
        }
        return gcdOfStrings3(str1.substring(str2.length()), str2);
    }

    public static String gcdOfStrings4(String str1, String str2) {
        if (str2.length() > str1.length()) {
            return gcdOfStrings4(str2, str1);
        }
        if (str2.equals(str1)) {
            return str1;
        }
        if (str1.startsWith(str2)) {
            return gcdOfStrings4(str1.substring(str2.length()), str2);
        }
        return "";
    }
}

