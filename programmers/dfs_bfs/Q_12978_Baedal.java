package programmers.dfs_bfs;

import java.io.*;
import java.util.*;

public class Q_12978_Baedal {
    public static LinkedList<Edge>[] graph;
    public static int[] distance;
    public static HashSet<Integer> result = new HashSet<>();
    public static int solution(int N, int[][] road, int K) {
        ArrayList<Edge>[] graph = makeList(N,road);
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(distance[o1], distance[o2]);
            }
        });

        boolean[] visited = new boolean[N + 1];
        distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[1] = 0;
        pq.add(1);
        result.add(1);

        while(!pq.isEmpty()){
            int cur = pq.poll();
            if(visited[cur]) continue;
            visited[cur] = true;
            for(Edge next : graph[cur]){
                if(visited[next.to]) continue;
                if(distance[cur] + next.distance > K) continue;
                if(distance[cur] + next.distance < distance[next.to]){
                    distance[next.to] = distance[cur] + next.distance;
                    pq.add(next.to);
                    result.add(next.to);
                }
            }
        }

        return result.size();
    }

    public static ArrayList[] makeList(int N, int[][] road){
        // 인접 리스트
        ArrayList<Edge>[] graph = new ArrayList[N + 1];
        // 인접 리스트로 구성한 그래프에 ArrayList를 넣어주면서 초기화
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        for (int i = 0; i < road.length; i++) {
            int a = road[i][0]; // 시작점
            int b = road[i][1]; // 도착점
            int c = road[i][2]; // 비용

            graph[a].add(new Edge(b,c));
            graph[b].add(new Edge(a,c));
        }

        return graph;
    }

    public static class Edge {
        int to;
        int distance;

        public Edge(int to, int distance) {
            this.to = to;
            this.distance = distance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = 5;

        int[][] road =  {
                {1,2,1},
                {2,3,3},
                {5,2,2},
                {1,4,2},
                {5,3,1},
                {5,4,2}
        };
        int K = 3;

//        int N = 6;
//        int[][] road = {
//                {1,2,1},
//                {1,3,2},
//                {2,3,2},
//                {3,4,3},
//                {3,5,2},
//                {3,5,3},
//                {5,6,1}
//        };
//        int K = 4;

        int result = solution(N, road, K);
        bw.write(result+"");

        br.close();
        bw.close();
    }
}
