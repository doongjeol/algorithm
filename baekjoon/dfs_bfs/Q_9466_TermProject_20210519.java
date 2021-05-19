package baekjoon.dfs_bfs;
import java.io.*;
import java.util.StringTokenizer;

public class Q_9466_TermProject_20210519 {
    static int n; // 학생의 수
    static int[] map ; // 학생들 번호의 집합
    static boolean[] visited; // 노드 방문 여부
    static boolean[] finished; // 노드 탐색의 마지막 여부
    static int result; // 팀이 이루어지는 횟수

    public static void solution() {
        for (int index = 1; index <= n; index++) {
            if(!visited[index])
                dfs(index);
        }
    }

    public static void dfs(int cur){
        // 방문 처리
        visited[cur] = true;
        // 다음에 방문할 노드
        int next = map[cur];

        // 다음 노드를 아직 방문하지 않았다면 방문 수행
        if(!visited[next]){
            dfs(next);
        }

        // cur이 갖고 있는 값을 방문하였는데 노트 끝이 아니라면 cycle
        if(visited[next] && !finished[next]){
            // cycle 내의 학생 수 더해주기
            for(int temp = next ; temp != cur ; temp = map[temp])
                result++;
            // 자기 자신
            result ++;
        }

        finished[cur] = true;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for(int i=0 ; i<t ; i++) {
            n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            map = new int[n + 1];
            visited = new boolean[n + 1];
            finished = new boolean[n + 1];
            result = 0;
            for (int j = 1; j <= n; j++) {
                map[j] = Integer.parseInt(st.nextToken());
            }
            solution();
            System.out.println(n - result); // 팀에 속하지 못한 학생 수

        }


        br.close();
        bw.close();
    }
}
