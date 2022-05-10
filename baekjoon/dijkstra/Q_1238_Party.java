package baekjoon.dijkstra;

import java.io.*;
import java.util.*;

public class Q_1238_Party {
    public static int n,m,x;
    public static LinkedList<Edge>[] graph;
    public static int[] distance;
    public static void solution(){
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(distance[o1], distance[o2]);
            }
        });

        pq.add(1); // 일단 1번부터 시작
        distance[1] = 0;

        while (!pq.isEmpty()){
            int cur = pq.poll();
            for(Edge next : graph[cur]){
                if(distance[cur] + next.time < distance[next.to]){
                    distance[next.to] = distance[cur] + next.time;
                    pq.add(next.to);
                }
            }
        }

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

        graph = new LinkedList[m + 1];
        for (int i = 0; i < m+1; i++) {
            graph[i] = new LinkedList<>();
        }

        distance = new int[m + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            graph[from].add(new Edge(to, time));

        }

        solution();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < distance.length; i++) {
            max = Math.max(max, distance[i]);
        }

        bw.write(max+"");

        br.close();
        bw.close();
    }
}
