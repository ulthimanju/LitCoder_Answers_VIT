import java.util.*;

public class MaximizeRobbery {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] parts = input.trim().split("\\s+");
        int n = parts.length;
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(parts[i]);
        }

        System.out.println(maxRobAmount(arr));
    }

    static int maxRobAmount(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;
        if (n == 1) return arr[0];
        
        int[] dp = new int[n];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);
        
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(arr[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[n - 1];
    }
}
