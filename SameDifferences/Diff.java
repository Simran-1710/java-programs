import java.util.*;

public class Diff {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = inp.nextInt();

        int[] arr = new int[n];
        HashMap<Integer, Integer> diffCount = new HashMap<>();

        int res = 0;

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = inp.nextInt();
            int diff = arr[i] - i;

            System.out.println("Element: " + arr[i] + ", Index: " + i + ", Difference: " + diff);

            if (diffCount.containsKey(diff)) {
                res += diffCount.get(diff);
            }
            
            diffCount.put(diff, diffCount.getOrDefault(diff, 0) + 1);

            System.out.println("Updated Frequency Map: " + diffCount);
        }

        System.out.println("\nTotal number of valid pairs: " + res);
    }
}
