public class ClimbingStairs {

    public static void main(String[] args) {

        int stairs = 1;

        System.out.println(climbStairs(stairs));
    }


    static int climbStairs(int stairs) {
        int one = 1;
        int two = 1;
        int temp;

        for (int i = stairs - 1; i > 0; i--) {
            temp = one;
            one = one + two;
            two = temp;
        }
        return one;
    }

}
