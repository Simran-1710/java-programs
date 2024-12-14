import java.util.*;

public class Registration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of usernames to register: ");
        int t;
        while (true) {
            t = scanner.nextInt();
            if (t > 0) break;
            System.out.print("Please enter a positive number: ");
        }
        scanner.nextLine(); // Consume the leftover newline character

        Map<String, Integer> usernameRegistry = new HashMap<>();

        while (t-- > 0) {
            String username = scanner.nextLine();

            if (!usernameRegistry.containsKey(username)) {
                // Username is unique
                System.out.println("OK");
                usernameRegistry.put(username, 0); // Initialize the counter for this username
            } else {
                // Username exists; generate a unique one
                int suffix = usernameRegistry.get(username) + 1;
                usernameRegistry.put(username, suffix); // Update counter for the base username

                String uniqueUsername = username + suffix;
                System.out.println(uniqueUsername);
                usernameRegistry.put(uniqueUsername, 0); // Add the unique username to the registry
            }
        }

        scanner.close();
    }
}
