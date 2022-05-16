package baekjoon.dijkstra;
import java.io.*;
import java.util.*;

public class Q_1916_LeastExpense {
    public static int n,m;
    public static int from,to;
    public static LinkedList<Edge>[] graph;
    public static int[] expense;
    public static void solution(){
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(expense[o1], expense[o2]);
            }
        });

        boolean[] visited = new boolean[n + 1];
        pq.add(from);
        expense[from] = 0;

        while(!pq.isEmpty()){
            int cur = pq.poll();
            if(visited[cur]) continue;
            visited[cur] = true;
            for(Edge next : graph[cur]){
                if(!visited[next.to] && expense[cur] + next.expense < expense[next.to]){
                    expense[next.to] = expense[cur] + next.expense;
                    pq.add(next.to);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        graph = new LinkedList[n + 1];
        for (int i = 0; i < n+1; i++) {
            graph[i] = new LinkedList<>();
        }

        expense = new int[n + 1];
        Arrays.fill(expense, Integer.MAX_VALUE); // 비용에 일단 최댓값으로 모두 초기화


        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken()); // 시작점
            int t = Integer.parseInt(st.nextToken()); // 도착점
            int e = Integer.parseInt(st.nextToken()); // 비용

            graph[f].add(new Edge(t, e));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        from = Integer.parseInt(st.nextToken());
        to = Integer.parseInt(st.nextToken());

        solution();

        bw.write(expense[to]+"");

        br.close();
        bw.close();
    }

    static class Edge{
        int to;
        int expense;

        public Edge(int to, int expense) {
            this.to = to;
            this.expense = expense;
        }
    }
}
