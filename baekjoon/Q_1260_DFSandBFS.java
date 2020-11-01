package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_1260_DFSandBFS {
   
   // N : ������ ����, M : ������ ����, V : Ž���� ������ ������ ��ȣ, matrix : �������, visit : �湮����
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
      
      // ��尡 1���� �����̱� ������ N+1
      matrix = new int[N+1][N+1];
      visit = new boolean[N+1];
      
      // M���� ��� �Է� & �׷����� ������ķ� �����
      for(int i=0; i<M ; i++) {
         StringTokenizer stPath = new StringTokenizer(br.readLine());
         matrix[Integer.parseInt(stPath.nextToken())][Integer.parseInt(stPath.nextToken())] = 1;
      }
      
      dfs(V);
        System.out.println();
        
      // �湮 �ʱ�ȭ
        for(int i=0 ; i<N+1 ; i++){
          visit[i]=false;
       }
        
        bfs(V);

//      ������� ����غ���
//      System.out.println();
//      for(int i=0; i<N+1 ; i++) {
//         for(int j=0; j<N+1 ; j++) {
//            System.out.print(matrix[i][j]+" ");
//         }
//         System.out.println();
//      }
   }
   
   // ���� Ž�� - index : ��� ��ȣ
   public static void dfs(int index) {
      // �湮�� ��带 true��
      visit[index] = true;
      // �湮�� ��� ���
      System.out.print(index + " ");
      
      // index : ���, i : ���� ������ ���
      for(int i=0; i<N+1 ; i++) {
         // ��尡 �̾����ְ� �湮�� ���� ���ٸ� �ٽ� Ž��
         if(matrix[index][i] == 1 && visit[i] == false) {
            dfs(i);
         }
      }
   }
   
   // ���� Ž��
   public static void bfs(int index) {
      Queue<Integer> queue = new LinkedList<Integer>();
      // Queue�� �ֱ�
      queue.offer(V);
      // �湮�� ��带 true��
      visit[index] = true;
      // �湮�� ��� ���
      System.out.print(index + " ");
      
      // ���� ���
      int k;
      
      // Queue�� ���� ������ �ݺ�
      while(!queue.isEmpty()) {
         // FIFO - ���� ���� ���� ��� 
         k = queue.poll();
         
         for(int i=0; i<N+1 ; i++) {
            // ��尡 �̾����ְ� �湮�� ���� ���ٸ� ������ ����� i�� Queue�� ����
            if(matrix[index][i] == 1 && visit[i] == false) {
               queue.offer(i);
               visit[i] = true;
               System.out.print(i + " ");
            }
         }
      }
      
   }
      
}