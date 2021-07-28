package baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_1260_DFSandBFS {

   // N : 정점의 개수, M : 간선의 개수, V : 탐색을 시작할 정점의 번호, matrix : 인접행렬, visit : 방문여부
   static int N;
   static int M;
   static int V;
   static int[][] matrix;
   static boolean[] visit;
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      V = Integer.parseInt(st.nextToken());

      // 노드가 1부터 시작이기 때문에 N+1
      matrix = new int[N+1][N+1];
      visit = new boolean[N+1];

      // M개의 경로 입력 & 그래프를 인접행렬로 만들기
      for(int i=0; i<M ; i++) {
         StringTokenizer stPath = new StringTokenizer(br.readLine());
         matrix[Integer.parseInt(stPath.nextToken())][Integer.parseInt(stPath.nextToken())] = 1;
      }
      
      dfs(V);
        System.out.println();

      // 방문 초기화
        for(int i=0 ; i<N+1 ; i++){
          visit[i]=false;
       }
        
        bfs(V);

//      인접행렬 출력해보기
//      System.out.println();
//      for(int i=0; i<N+1 ; i++) {
//         for(int j=0; j<N+1 ; j++) {
//            System.out.print(matrix[i][j]+" ");
//         }
//         System.out.println();
//      }
   }

   // 깊이 탐색 - index : 노드 번호
   public static void dfs(int index) {
      // 방문한 노드를 true로
      visit[index] = true;
      // 방문한 노드 출력
      System.out.print(index + " ");

      // index : 노드, i : 노드와 인접한 노드
      for(int i=0; i<N+1 ; i++) {
         // 노드가 이어져있고 방문한 적이 없다면 다시 탐색
         if(matrix[index][i] == 1 && visit[i] == false) {
            dfs(i);
         }
      }
   }

   // 넓이 탐색
   public static void bfs(int index) {
      Queue<Integer> queue = new LinkedList<Integer>();
      // Queue에 넣기
      queue.offer(V);
      // 방문한 노드를 true로
      visit[index] = true;
      // 방문한 노드 출력
      System.out.print(index + " ");
      
      // 나올 노드
      int k;
      
      // Queue에 없을 때까지 반복
      while(!queue.isEmpty()) {
         // FIFO - 가장 먼저 넣은 노드
         k = queue.poll();
         
         for(int i=0; i<N+1 ; i++) {
            // 노드가 이어져있고 방문한 적이 없다면 인접한 노드인 i를 Queue에 넣음
            if(matrix[index][i] == 1 && visit[i] == false) {
               queue.offer(i);
               visit[i] = true;
               System.out.print(i + " ");
            }
         }
      }
      
   }
      
}