package baekjoon.dfs_bfs;
import java.io.*;
import java.util.StringTokenizer;

public class Q_10552_DOM {
    public static int n,m,p;
    public static boolean[] visitedCha;
    public static boolean[] finished;
    public static int[] favoriteCh;
    public static int[] hateCha;
    public static int result;
    public static void solution(int initCha){
        for(int i=0 ; i<n ; i++){
            if(hateCha[i]== initCha)
                dfs(initCha);
        }

    }
    public static void dfs(int curCha){
        visitedCha[curCha] = true;
        int nextCha = curCha;
        System.out.println(curCha);

        for(int i=0 ; i<n ; i++){
            if(hateCha[i]==curCha && !visitedCha[favoriteCh[i]]) {
                nextCha = favoriteCh[i];
                result++;
                dfs(nextCha);
                break;
            }
        }
        for(int i=0 ; i<n ; i++){
            if(hateCha[i] != curCha){
                System.out.println("빠져나가랏");
                return;
            }
        }

        if(visitedCha[nextCha] && !finished[nextCha]) {
            System.out.println(curCha);
            result = -1;
        }

        finished[curCha] = true;
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        visitedCha = new boolean[m + 1];
        finished = new boolean[m + 1];
        favoriteCh = new int[n];
        hateCha = new int[n];

        for(int i=0 ; i<n ; i++){
            st = new StringTokenizer(br.readLine());
            favoriteCh[i] = Integer.parseInt(st.nextToken());
            hateCha[i] = Integer.parseInt(st.nextToken());
        }

        solution(p);
        bw.write(result+"");

        br.close();
        bw.close();
    }
}
