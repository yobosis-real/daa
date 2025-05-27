import java.util.*;

class floyds
{
    public int min(int a, int b)
    {
        return(a<b?a:b);
    }
    public void floy(int a[][],int n)
    {
        int i,j,k;
        for(k=1;k<=n;k++)
        {
            for(i=1;i<=n;i++)
            {
                for(j=1;j<=n;j++)
                {
                    a[i][j]=min(a[i][j],a[i][k]+a[j][k]);
                }
            }
        }
        System.out.println("shortest path matrix:");
        for(i=1;i<=n;i++)
        {
            for(j=1;j<=n;j++)
            {
                System.out.print(a[i][j]+"\t");
            }
            System.out.println();
        }
    }
    void main()
    {
        int a[][]=new int[10][10],i,j,n;
        float start,end;
        floyds f=new floyds();
        System.out.println("\nEnter the no of nodes in a graph:\n");
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        System.out.println("\n\nEnter the cost adjacency matrix:\n");
        for(i=1;i<=n;++i)
        for(j=1;j<=n;++j)
            a[i][j]=sc.nextInt();
        System.out.println("\nThe all pair shortest path matrix is:\n");
        f.floy(a,n);
    }
}