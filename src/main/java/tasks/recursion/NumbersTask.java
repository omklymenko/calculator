package tasks.recursion;

public class NumbersTask {

    private static int recursion(int n) {

        System.out.println(n);

        if (n == 0) {
            return 0;
        }
        return recursion(n - 1);
    }

    public static void main(String[] args) {
        recursion(5);
    }
}
