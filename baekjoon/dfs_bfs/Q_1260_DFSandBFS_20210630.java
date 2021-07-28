package baekjoon.dfs_bfs;
import java.io.*;
import java.util.*;

public class Q_1260_DFSandBFS_20210630 {
    public static int n,m,v; // n : 정점의 개수, m : 간선의 개수, v : 탐색을 시작할 정점의 번호
    public static int[][] graph; // 그래프 정보
    public static boolean[] dfsVisited; // 정점 방문 여부 체크
    public static boolean[] bfsVisited; // 정점 방문 여부 체크
    public static List dfsList; // dfs 탐색 결과
    public static List bfsList; // bfs 탐색 결과

    public static void solution(){
        dfs(v);
        bfs(v);
    }

    public static void dfs(int cur){
        dfsVisited[cur] = true; // 현재 정점 방문 처리
        dfsList.add(cur); // 출력하기 위한 결과 넣기

        // 인접행렬로 구현했기 때문에 1번 정점부터 연결되어있는 지를 확인
        for(int i=1 ; i<=n ; i++){
            // 그래프가 연결되어있고 아직 방문하지 않았다면 다음 정점 탐색
            if(graph[cur][i] == 1 && !dfsVisited[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int cur){
        Queue<Integer> q = new LinkedList<>(); // bfs니까 큐로 구현
        q.add(cur); // 큐에 현재 정점 삽입
        bfsVisited[cur] = true; // 현재 정점 방문 처리

        while (!q.isEmpty()) {
            int k = q.poll(); // 큐에서 꺼내기
            bfsList.add(k); // 출력하기 위한 결과 넣기

            // 인접행렬로 구현했기 때문에 1번 정점부터 연결되어있는 지를 확인
            for(int i=1 ; i<=n ; i++) {
                // 그래프가 연결되어있고 아직 방문하지 않았다면 해당 정점을 큐에 삽입
                if (graph[k][i] == 1 && !bfsVisited[i]){
                    q.add(i);
                    bfsVisited[i] = true; // 해당 정점 방문 처리
                }
            }
        }
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        graph = new int[n + 1][n + 1];
        dfsVisited = new boolean[n + 1];
        bfsVisited = new boolean[n + 1];
        dfsList = new ArrayList();
        bfsList = new ArrayList();

        // 인접행렬로 구현
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());
            graph[one][two] = 1;
            graph[two][one] = 1;
        }

        solution();

        // 출력
        for(int i=0 ; i<dfsList.size() ; i++){
            bw.write(dfsList.get(i)+" ");
        }
        bw.write("\n");
        for(int i=0 ; i<bfsList.size() ; i++){
            bw.write(bfsList.get(i)+" ");
        }

        br.close();
        bw.close();
    }
}
