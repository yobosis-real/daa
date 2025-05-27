import java.util.*;

public class Horspool {
    static int[] shiftTable(String pattern) {
        int[] table = new int[256];
        int m = pattern.length();
        Arrays.fill(table, m);
        for (int i = 0; i < m - 1; i++) {
            table[pattern.charAt(i)] = m - 1 - i;
        }
        return table;
    }

    static void search(String text, String pattern) {
        int[] table = shiftTable(pattern);
        int n = text.length(), m = pattern.length();
        int i = m - 1;

        while (i < n) {
            int k = 0;
            while (k < m && pattern.charAt(m - 1 - k) == text.charAt(i - k))
                k++;
            if (k == m)
                System.out.println("Pattern found at index " + (i - m + 1));
            i += table[text.charAt(i)];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        System.out.print("Enter pattern: ");
        String pattern = sc.nextLine();
        search(text, pattern);
    }
}