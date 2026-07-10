package topics.thread_test;

import java.util.concurrent.atomic.AtomicInteger;

public class CounterBenchmark {

    private static final int THREADS = 10;
    private static final int INCREMENTS = 1_000_000;

    // ------------------- Synchronized Counter -------------------
    static class SyncCounter {
        private int count = 0;

        public synchronized void increment() {
            count++;
        }

        public int getCount() {
            return count;
        }
    }

    // ------------------- Atomic Counter -------------------
    static class AtomicCounter {
        private final AtomicInteger count = new AtomicInteger(0);

        public void increment() {
            count.incrementAndGet();
        }

        public int getCount() {
            return count.get();
        }
    }

    static void main() throws InterruptedException {

        benchmarkSynchronized();
        System.out.println("--------------------------------");
        benchmarkAtomic();
    }

    private static void benchmarkSynchronized() throws InterruptedException {

        SyncCounter counter = new SyncCounter();

        Thread[] threads = new Thread[THREADS];

        long start = System.nanoTime();

        for (int i = 0; i < THREADS; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < INCREMENTS; j++) {
                    counter.increment();
                }
            });
        }

        for (Thread t : threads)
            t.start();

        for (Thread t : threads)
            t.join();

        long end = System.nanoTime();

        System.out.println("Synchronized Counter");
        System.out.println("Final Count : " + counter.getCount());
        System.out.println("Time (ns)   : " + (end - start));
        System.out.println("Time (ms)   : " + ((end - start) / 1_000_000.0));
    }

    private static void benchmarkAtomic() throws InterruptedException {

        AtomicCounter counter = new AtomicCounter();

        Thread[] threads = new Thread[THREADS];

        long start = System.nanoTime();

        for (int i = 0; i < THREADS; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < INCREMENTS; j++) {
                    counter.increment();
                }
            });
        }

        for (Thread t : threads)
            t.start();

        for (Thread t : threads)
            t.join();

        long end = System.nanoTime();

        System.out.println("Atomic Counter");
        System.out.println("Final Count : " + counter.getCount());
        System.out.println("Time (ns)   : " + (end - start));
        System.out.println("Time (ms)   : " + ((end - start) / 1_000_000.0));
    }
}