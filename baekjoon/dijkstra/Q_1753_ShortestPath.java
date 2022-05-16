package baekjoon.dijkstra;
import java.io.*;
import java.util.*;

public class Q_1753_ShortestPath {
    public static int v,e,k;
    public static LinkedList<Edge>[] graph;
    public static int[] distance;
    public static void solution(){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(o -> distance[o]));

        boolean[] visited = new boolean[v+1];
        pq.add(k);
        distance[k] = 0;

        while(!pq.isEmpty()){
            int cur = pq.poll();
            if(visited[cur]) continue;
            visited[cur] = true;
            for(Edge next : graph[cur]){
                if(!visited[next.to] && distance[cur] + next.weight < distance[next.to]){
                    distance[next.to] = distance[cur] + next.weight;
                    pq.add(next.to);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());

        graph = new LinkedList[v+1];
        for (int i = 0; i < v + 1; i++) {
            graph[i] = new LinkedList<>();
        }
        distance = new int[v+1];
        Arrays.fill(distance,Integer.MAX_VALUE);

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[from].add(new Edge(to, weight));

        }

        solution();
        for (int i = 1; i < v+1; i++) {
            if(distance[i] == Integer.MAX_VALUE){
                bw.write("INF\n");
            } else {
                bw.write(distance[i] + "\n");
            }
        }

        br.close();
        bw.close();
    }

    static class Edge{
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}
