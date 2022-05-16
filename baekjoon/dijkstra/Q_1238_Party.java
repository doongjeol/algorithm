package baekjoon.dijkstra;

import java.io.*;
import java.util.*;

public class Q_1238_Party {
    public static int n,m,x;
    public static LinkedList<Edge>[] graph;
    public static int solution(int start, int end){

        boolean[] visited = new boolean[n + 1];
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(o -> distance[o]));
        pq.add(start); // 일단 1번부터 시작

        while (!pq.isEmpty()){
            int cur = pq.poll();
            if(cur == end) return distance[end];
            if(visited[cur]) continue;
            visited[cur] = true;
            for(Edge next : graph[cur]){
                if(!visited[next.to] && distance[cur] + next.time < distance[next.to]){
                    distance[next.to] = distance[cur] + next.time;
                    pq.add(next.to);
                }
            }
        }

        return distance[end];
    }

    public static class Edge {
        int to;
        int time;

        public Edge(int to, int time) {
            this.to = to;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        graph = new LinkedList[n + 1];
        for (int i = 0; i < n+1; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            graph[from].add(new Edge(to, time));

        }

        int max = Integer.MIN_VALUE;

        for (int i = 1; i < n+1; i++) {
            int toX = solution(i, x);
            int toI = solution(x, i);
            max = Math.max(max, toX + toI);
        }

        bw.write(max+"");

        br.close();
        bw.close();
    }
}