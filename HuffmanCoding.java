import java.util.*;

class HuffmanNode {
    char ch;
    int freq;
    HuffmanNode left, right;
}

class CompareFreq implements Comparator<HuffmanNode> {
    public int compare(HuffmanNode x, HuffmanNode y) {
        return x.freq - y.freq;
    }
}

public class HuffmanCoding {
    static void printCodes(HuffmanNode root, String code) {
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            System.out.println(root.ch + ": " + code);
        printCodes(root.left, code + "0");
        printCodes(root.right, code + "1");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter characters: ");
        String chars = sc.nextLine();
        System.out.print("Enter frequencies: ");
        String[] freqStr = sc.nextLine().split(" ");
        int n = chars.length();

        PriorityQueue<HuffmanNode> q = new PriorityQueue<>(n, new CompareFreq());

        for (int i = 0; i < n; i++) {
            HuffmanNode node = new HuffmanNode();
            node.ch = chars.charAt(i);
            node.freq = Integer.parseInt(freqStr[i]);
            node.left = null;
            node.right = null;
            q.add(node);
        }

        while (q.size() > 1) {
            HuffmanNode x = q.poll();
            HuffmanNode y = q.poll();
            HuffmanNode f = new HuffmanNode();
            f.freq = x.freq + y.freq;
            f.ch = '-';
            f.left = x;
            f.right = y;
            q.add(f);
        }

        HuffmanNode root = q.peek();
        System.out.println("Huffman Codes:");
        printCodes(root, "");
    }
}