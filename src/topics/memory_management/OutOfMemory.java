package topics.memory_management;

import java.util.ArrayList;
import java.util.List;

public class OutOfMemory {

    static void main() {
        gonnaFillUp();
    }

    static void gonnaFillUp() {
        // A list stored in local scope to maintain a strong reference
        // to our data, preventing the Garbage Collector from freeing it.
        List<byte[]> memoryBurner = new ArrayList<>();

        System.out.println("Allocating memory to trigger OOM...");

        while (true) {
            // Allocate 10 Megabytes on every single iteration
            byte[] largeBlock = new byte[10 * 1024 * 1024];
            memoryBurner.add(largeBlock);

            // Print out the total allocated memory milestones
            long freeMemory = Runtime.getRuntime().freeMemory();
            System.out.println("Free Heap Memory remaining: " + (freeMemory / (1024 * 1024)) + " MB");
        }
    }
}
