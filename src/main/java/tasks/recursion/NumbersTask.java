package tasks.recursion;

public class NumbersTask {

    private static int count;

    private static int recursion(int n) {

        System.out.println(n);

        if (n == 0) {
            return 0;
        }
        return recursion(n - 1);
    }

    private static int recursionReverse(int n) {

        System.out.println(n - count);

        count--;
        if (count < 0) {
            return 0;
        }
        return recursionReverse(n);
    }

    public static void main(String[] args) {
        recursion(5);

        System.out.println("***************");

        count = 5;
        recursionReverse(5);
    }
}
