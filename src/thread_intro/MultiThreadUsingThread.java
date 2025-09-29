package thread_intro;

class Hii extends Thread{

    public void run() {
        for(int i=0;i<=20;i++){
            System.out.println("This is Hii");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Hello extends Thread{

    public void run() {
        for(int i=0;i<=20;i++){
            System.out.println("This is Hello");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class MultiThreadUsingThread {
    public static void main(String[] args) {

        Hii hi = new Hii();
        Hello hello = new Hello();

        hi.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        hello.start();
    }
}
