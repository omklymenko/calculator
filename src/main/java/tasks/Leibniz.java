package tasks;

public class Leibniz {

    private static double total = 0;

    static synchronized void updateSum(double value) {
        total += value;
    }

    public static void main(String[] arg) throws InterruptedException {
        int n = 15000;

        Thread positiveThread = new Thread(new Runnable() {
            public void run() {
                for(int i = 0; i <= n; i = i + 2){
                    updateSum(1.0/(2.0*i + 1.0));
                }
            }
        });

        Thread negativeThread = new Thread(new Runnable() {
            public void run() {
                for(int i = 1; i <= n; i = i + 2){
                    updateSum(-1.0/(2.0*i + 1.0));
                }
            }
        });

        positiveThread.start();
        negativeThread.start();
        positiveThread.join();
        negativeThread.join();

        System.out.println(total);
    }
}
