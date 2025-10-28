import java.util.*;

public class LetterTilePossibilities {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String tiles = sc.next();
        System.out.println(numTilePossibilities(tiles));
    }

    public static int numTilePossibilities(String tiles) {
        char[] chars = tiles.toCharArray();
        Arrays.sort(chars); // helps handle duplicates
        boolean[] used = new boolean[chars.length];
        return backtrack(chars, used);
    }

    private static int backtrack(char[] chars, boolean[] used) {
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            // skip used tiles
            if (used[i]) continue;

            // skip duplicates (if previous identical char wasn’t used)
            if (i > 0 && chars[i] == chars[i - 1] && !used[i - 1]) continue;

            // choose tile i
            used[i] = true;
            count += 1; // count this sequence
            count += backtrack(chars, used);
            used[i] = false; // backtrack
        }
        return count;
    }
}
