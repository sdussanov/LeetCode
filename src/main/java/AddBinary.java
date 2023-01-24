public class AddBinary {

    public static void main(String[] args) {
        String a1 = "11";
        String b1 = "1";
        String a2 = "1010";
        String b2 = "1011";

        System.out.println(addBinary(a1, b1));
        System.out.println(addBinary(a2, b2));
    }


    static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }

}
