import java.util.Arrays;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = new String[]{"flower", "flow", "flight"};
        String[] strs2 = new String[]{"dog", "racecar", "car"};
        String[] strs3 = new String[]{"", "flow", "flight"};

        System.out.println("Ответ: " + longestCommonPrefix3(strs));
        System.out.println("Ответ: " + longestCommonPrefix3(strs2));
        System.out.println("Ответ: " + longestCommonPrefix3(strs3));
    }


    static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < strs[0].length(); i++) {
            System.out.print(strs[0].charAt(i) + " - ");
            System.out.println(strs[strs.length - 1].charAt(i));
            if (strs[0].charAt(i) == strs[strs.length - 1].charAt(i)) {
                sb.append(strs[0].charAt(i));
            } else {
                break;
            }
        }
        return sb.toString();
    }


    static String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        Arrays.sort(strs);
        char[] first = strs[0].toCharArray();
        char[] last = strs[strs.length - 1].toCharArray();

        int i = 0;
        while (i < first.length && i < last.length && first[i] == last[i]) {
            i++;
        }

        return new String(first, 0, i);
    }


    static String longestCommonPrefix3(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

}
