import java.util.*;
class dijkstra
{
    public void diji(int a[][],int n,int source)
    {
        int s[]=new int[10],d[]=new int[10],i,j,u=0,v=0,min;
        for(i=1;i<=n;i++)
        {
            s[i]=0;
            d[i]=a[source][i];
        }
        s[source]=1;
        for(i=1;i<=n;i++)
        {
            min=9999;
            for(j=1;j<=n;j++)
            {
                if(s[j]==0)
                {
                    if(d[j]<min)
                    {
                        min=d[j];
                        u=j;
                    }
                }
            }
            s[u]=1;
            for(v=1;v<=n;v++)
            {
                if(s[v]==0)
                {
                    if(d[v]>d[u]+a[u][v])
                    {
                        d[v]=d[u]+a[u][v];
                    }
                }
            }
        }
        System.out.println("\nShortest distance source:\n");
        for(i=1;i<=n;i++)
            System.out.println(source+"->"+i+"=\t"+d[i]);        
    }
    public static void main(String[] args)
    {
        dijkstra di=new dijkstra();
        int a[][]=new int[10][10],n,i,j,source;
        System.out.println("\nEnter the number of nodes:\n");
        Scanner scannerobj=new Scanner(System.in);
        n=scannerobj.nextInt();
        System.out.println ("\nEnter the adjacency matrix:\n");
        for(i=1;i<=n;i++)
            for(j=1;j<=n;j++)
                a[i][j]=scannerobj.nextInt();
        System.out.println("Enter the source node:\n");
        source=scannerobj.nextInt();
        di.diji(a,n,source);
    }
}