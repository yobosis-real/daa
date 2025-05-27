import java.util.Scanner;

public class TopologicalOrdering {
    static int[][] graph;
    static boolean[] visited;
    static int[] stack;
    static int vertex, index;

    public static void topologicalSort(int vertexCount) {
        visited = new boolean[vertexCount];
        stack = new int[vertexCount];
        index = vertexCount - 1;

        for (int i = 0; i < vertexCount; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }

        System.out.print("Topological Order: ");
        for (int i = 0; i < vertexCount; i++) {
            System.out.print(stack[i] + " ");
        }
    }

    public static void dfs(int v) {
        visited[v] = true;

        for (int i = 0; i < vertex; i++) {
            if (graph[v][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }

        stack[index--] = v;
    }

    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        System.out.print("Enter no. of vertices: ");
        vertex = obj.nextInt();
        graph = new int[vertex][vertex];

        System.out.print("Enter number of edges: ");
        int edges = obj.nextInt();

        for (int i = 0; i < edges; i++) {
            int from = obj.nextInt();
            int to = obj.nextInt();
            graph[from][to] = 1;
        }

        topologicalSort(vertex);
        obj.close();
    }
}