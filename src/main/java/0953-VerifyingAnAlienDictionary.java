import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class VerifyingAnAlienDictionary {

    public static void main(String[] args) {
        String[] words1 = {"hello", "leetcode"};
        String[] words2 = {"word","world","row"};
        String[] words3 = {"apple","app"};

        String order1 = "hlabcdefgijkmnopqrstuvwxyz";
        String order2 = "worldabcefghijkmnpqstuvxyz";
        String order3 = "abcdefghijklmnopqrstuvwxyz";

        System.out.println(isAlienSorted3(words1, order1));
        System.out.println(isAlienSorted3(words2, order2));
        System.out.println(isAlienSorted3(words3, order3));
    }

    public static boolean isAlienSorted1(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        for (int i = 1; i < words.length; i++) {
            String w1 = words[i - 1];
            String w2 = words[i];
            int len = Math.min(w1.length(), w2.length());
            for (int j = 0; j < len; j++) {
                int c1 = map.get(w1.charAt(j));
                int c2 = map.get(w2.charAt(j));
                if (c1 > c2) {
                    return false;
                } else if (c1 < c2) {
                    break;
                } else if (j == len - 1 && w1.length() > w2.length()) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isAlienSorted2(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        Comparator<String> comp = (s1, s2) -> {
            int n = Math.min(s1.length(), s2.length());
            for (int i = 0; i < n; i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    return map.get(s1.charAt(i)) - map.get(s2.charAt(i));
                }
            }
            return s1.length() - s2.length();
        };
        String[] copy = words.clone();
        Arrays.sort(copy, comp);
        for (int i = 0; i < words.length; i++) {
            if (!words[i].equals(copy[i])) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAlienSorted3(String[] words, String order) {
        int[] index = new int[26];
        for (int i = 0; i < order.length(); i++) {
            index[order.charAt(i) - 'a'] = i;
        }
        for (int i = 1; i < words.length; i++) {
            String word1 = words[i - 1];
            String word2 = words[i];
            int length = Math.min(word1.length(), word2.length());
            for (int j = 0; j < length; j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    if (index[word1.charAt(j) - 'a'] > index[word2.charAt(j) - 'a']) {
                        return false;
                    }
                    break;
                }
            }
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return false;
            }
        }
        return true;
    }
}
