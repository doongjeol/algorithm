package programmers.dijkstra;
import java.io.*;
import java.util.ArrayList;

public class Q_12978_Baedal {
    public static int solution(int N, int[][] road, int K) {
        int answer = 0;
        ArrayList<Edge>[] graph = makeList(N,road);
        boolean[] visited = new boolean[N + 1];
        dfs(graph,1,visited,K,0);

        return answer;
    }

    public static ArrayList[] makeList(int N, int[][] road){
        // 인접 리스트
        ArrayList<Edge>[] graph = new ArrayList[N+1];
        // 인접 리스트로 구성한 그래프에 ArrayList를 넣어주면서 초기화
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        for (int i = 0; i < road.length; i++) {
            int a = road[i][0];
            int b = road[i][1];
            int c = road[i][2];

            graph[a].add(new Edge(b,c));
        }

        return graph;
    }
    public static void dfs(ArrayList<Edge>[] graph, int cur, boolean[] visited, int K, int curDistance){
        visited[cur] = true;
        System.out.println(cur);

        for(Edge next : graph[cur]){
            if(next.to > 0 && !visited[next.to] && curDistance <=K){
                dfs(graph,next.to , visited, K, curDistance + next.distance);
            }
        }
//        for (int i = 1; i < graph.length; i++) {
//            if (graph[cur].to > 0 && !visited[i] && curDistance <= K) {
//                dfs(graph, i, visited, K,curDistance + graph[cur][i]);
//
//        }
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

//        int N = 5;

//        int[][] road =  {
//                {1,2,1},
//                {2,3,3},
//                {5,2,2},
//                {1,4,2},
//                {5,3,1},
//                {5,4,2}
//        };
//        int K = 3;

        int N = 6;
        int[][] road = {
                {1,2,1},
                {1,3,2},
                {2,3,2},
                {3,4,3},
                {3,5,2},
                {3,5,3},
                {5,6,1}
        };
        int K = 4;

        solution(N, road, K);

        br.close();
        bw.close();
    }
}
