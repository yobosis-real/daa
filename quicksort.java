import java.util.*;

class quicksort 
{
    void swap(int a[], int i, int j) 
    {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    int partition(int a[], int l, int h) 
    {
        int pivot = a[l];
        int i = l + 1;
        int j = h;

        while (i <= j) 
        {
            while (a[i] <= pivot)
                i++;
            while (a[j] > pivot)
                j--;
            if (i < j)
                swap(a, i, j);
        }
        swap(a, l, j);
        return j;
    }

    void quick(int a[], int l, int h) 
    {
        if (l < h) 
        {
            int m = partition(a, l, h);
            quick(a, l, m - 1);
            quick(a, m + 1, h);
        }
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        int a1[] = new int[n];

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++)
            a1[i] = sc.nextInt();

        quicksort q = new quicksort();
        q.quick(a1, 0, n - 1);

        System.out.println("Sorted array:");
        for (int i = 0; i < n; i++)
            System.out.print(a1[i] + " ");
    }
}
