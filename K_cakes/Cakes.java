import java.util.*;

public class Cakes {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        System.out.print("Enter the number of cake sizes to process: ");
        int testCases = inp.nextInt();

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        System.out.println("Enter the sizes of the cakes:");
        for (int i = 0; i < testCases; i++) {
            int cakeSize = inp.nextInt();
            maxHeap.add(cakeSize);
            System.out.println("Added cake size: " + cakeSize);
        }

        System.out.println("\nInitial Max-Heap: " + maxHeap);

        int leftoverSize = 0;

        while (maxHeap.size() > 1) {
            int largest = maxHeap.poll();
            int secondLargest = maxHeap.poll();
            System.out.println("\nLargest cake size: " + largest);
            System.out.println("Second largest cake size: " + secondLargest);

            int difference = largest - secondLargest;
            if (difference > 0) {
                maxHeap.add(difference);
                System.out.println("Difference (" + largest + " - " + secondLargest + ") added back to the heap: " + difference);
            } else {
                System.out.println("No difference to add back to the heap.");
            }

            System.out.println("Current Max-Heap: " + maxHeap);
        }

        if (!maxHeap.isEmpty()) {
            leftoverSize = maxHeap.poll() - 1;
            System.out.println("\nLeftover size reduced by 1: " + leftoverSize);
        } else {
            System.out.println("\nNo cakes left in the heap.");
        }

        System.out.println("\nFinal leftover size of the cake: " + Math.max(leftoverSize, 0));
    }
}
