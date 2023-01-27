class Sqrt {

    public static void main(String[] args) {
        int x1 = 2147395599;
        int x2 = 8;

        System.out.println(mySqrt1(x1));
        System.out.println(mySqrt1(x2));
    }

    public static int mySqrt1(int x) {
        if (x <= 0) return x;
        int left = 1, right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                if (mid + 1 > x / (mid + 1))
                    return mid;
                left = mid + 1;
            }
        }
        return 0;
    }

    public static int mySqrt2(int x) {
        if (x <= 0) return x;
        long left = 1, right = x;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (mid * mid > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return (int) (left - 1);
    }
}