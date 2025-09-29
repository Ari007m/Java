package threadIntro;

public class MultiThreadUsingRunnable {
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            for (int i = 0; i <= 5; i++) {
                System.out.println("Hii");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"Hi Thread");
        Thread t2 = new Thread(() -> {
            for (int i = 0; i <= 5; i++) {
                System.out.println("Hello");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"Hello Thread");

        t1.setPriority(7);

        t1.start();
        System.out.println(t1.getName());
        System.out.println(t1.getPriority());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(t2.isAlive());
        t2.start();
        System.out.println(t2.isAlive());

        t1.join();
        t2.join();

        System.out.println("After All");
    }
}