import java.util.*;

public class FrequencySort {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        // Input size of the array
        System.out.print("Enter the size of the array: ");
        int n = inp.nextInt();

        // Input the array elements
        System.out.println("Enter the elements of the array: ");
        Integer[] arr = new Integer[n];

        // Map to store frequency and maintain the first appearance order
        Map<Integer, Integer> frequencyMap = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            arr[i] = inp.nextInt();
            frequencyMap.put(arr[i], frequencyMap.getOrDefault(arr[i], 0) + 1);
        }

        // Sort the array based on frequency and appearance
        Arrays.sort(arr, (a, b) -> {
            // Sort by frequency (descending)
            int freqCompare = Integer.compare(frequencyMap.get(b), frequencyMap.get(a));
            // If frequencies are equal, sort by first appearance (stable sort)
            return (freqCompare != 0) ? freqCompare : 1;
        });

        // Print the sorted array
        System.out.println("Sorted array by frequency:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
