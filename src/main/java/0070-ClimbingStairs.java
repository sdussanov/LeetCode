class ClimbingStairs {

    public static void main(String[] args) {
        int stairs1 = 10;
        int stairs2 = 45;

        System.out.println(climbStairs2(stairs1));
        System.out.println(climbStairs2(stairs2));
    }

    public static int climbStairs1(int stairs) {
        if (stairs == 1) {
            return 1;
        }
        int[] dp = new int[stairs + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= stairs; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[stairs];
    }

    public static int climbStairs2(int stairs) {
        int first  = 1;
        int second  = 1;
        for (int i = stairs - 1; i > 0; i--) {
            int temp = first;
            first = first + second;
            second = temp;
        }
        return first;
    }
}