public class LengthOfLastWord {

    public static void main(String[] args) {
        String s1 = "Hello World";
        String s2 = "   fly me   to   the moon  ";
        String s3 = "s";

        System.out.println(lengthOfLastWord2(s1));
        System.out.println(lengthOfLastWord2(s2));
        System.out.println(lengthOfLastWord2(s3));
    }


    static int lengthOfLastWord1(String s){
        String lastWord = s.trim().substring(s.trim().lastIndexOf(" ")+1);
        return lastWord.length();
    }


    static int lengthOfLastWord2(String s){
        return s.trim().substring(s.trim().lastIndexOf(" ")+1).length();
    }


    public int lengthOfLastWord3(String s) {
        s = s.trim();
        int lastIndex = s.lastIndexOf(" ");
        return s.length() - lastIndex - 1;
    }


    public int lengthOfLastWord4(String s) {
        int len = s.length(), lastLength = 0;
        while (len > 0 && s.charAt(len - 1) == ' ') {
            len--;
        }
        while (len > 0 && s.charAt(len - 1) != ' ') {
            lastLength++;
            len--;
        }
        return lastLength;
    }
}
