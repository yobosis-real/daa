import java.util.*;
class mergesort
{
    void merge(int a[],int l,int h)
    {
        int m;
        if(l<h)
        {
            m=(l+h)/2;        
            merge(a,l,m);
            merge(a,m+1,h);
            simplemerge(a,l,m,h);
        }
    }
    void simplemerge(int a[],int l,int m,int h)
    {
        int i=l,j=m+1,k=l,c[]=new int[1000];
        while((i<=m)&&(j<=h))
        {
            if(a[i]<a[j])
            {
                c[k]=a[i];
                i++;
                k++;
            }
            else
            {
                c[k]=a[j];
                j++;
                k++;
            }
        }
        while(i<=m)
        {
            c[k]=a[i];
            k++;
            i++;
        }
        while(j<=h)
        {
            c[k]=a[j];
            k++;
            j++;
        }
        for(i=l;i<=h;i++)
        {
            a[i]=c[i];
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
        {
            a1[i] = sc.nextInt();
        }

        mergesort m= new mergesort();
        m.merge(a1, 0, n - 1);

        System.out.println("Sorted array:");
        for (int i = 0; i < n; i++)
        {
            System.out.print(a1[i] + " ");
        }
    }
}