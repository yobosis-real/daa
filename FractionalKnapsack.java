import java.util.*;

class Item {
    int weight, profit;
    double ratio;

    public Item(int weight, int profit) {
        this.weight = weight;
        this.profit = profit;
        this.ratio = (double) profit / weight;
    }
}

public class FractionalKnapsack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter weight and profit of item " + (i + 1) + ": ");
            int w = sc.nextInt();
            int p = sc.nextInt();
            items[i] = new Item(w, p);
        }

        System.out.print("Enter knapsack capacity: ");
        int capacity = sc.nextInt();

        Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));

        double totalProfit = 0;
        for (Item item : items) {
            if (capacity >= item.weight) {
                totalProfit += item.profit;
                capacity -= item.weight;
            } else {
                totalProfit += item.ratio * capacity;
                break;
            }
        }

        System.out.println("Maximum profit (fractional): " + totalProfit);
    }
}