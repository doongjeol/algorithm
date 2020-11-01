package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2018-11-16-�� 
public class Q_1012_OrganicCabage {
	
	static int M, N, K;
	static int[][] carbage;
	static boolean[][] visited;
	static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0 ; i<T ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); // ������ ����
			N = Integer.parseInt(st.nextToken()); // ������ ����
			K = Integer.parseInt(st.nextToken()); // ���߰� �ɾ��� �ִ� ��ġ�� ����
			carbage = new int[N][M];
			visited = new boolean[N][M];
			int count = 0;
			
			// ���� �Է�
			for(int j=0 ; j<K ; j++) {
				StringTokenizer stK = new StringTokenizer(br.readLine());
				int mK = Integer.parseInt(stK.nextToken());
				int nK = Integer.parseInt(stK.nextToken());
				carbage[nK][mK] = 1;
			}
			
			for(int r=0 ; r<N ; r++) {
				for(int c=0 ; c<M ; c++) {
					if(carbage[r][c] == 1 && !visited[r][c]) {
						dfs(r,c);
						count++;
					}
				}
			}
			
			System.out.println(count);
		}
	}
	
	public static void dfs(int indexR, int indexC) {
		visited[indexR][indexC] = true;
		
		for(int i=0 ; i<4 ; i++) {
			int nodeR = indexR + dir[i][0];
			int nodeC = indexC + dir[i][1];
			
			if(nodeR<0 || nodeR>=N || nodeC<0 || nodeC>=M) continue;
			else if(carbage[nodeR][nodeC] == 1 && !visited[nodeR][nodeC])
				dfs(nodeR, nodeC);
		}
		
	}
	
	public static void write() {
 		for(int i=0 ; i<N ; i++) {
 			for(int j=0 ; j<M ; j++) {
 				System.out.print(carbage[i][j]+" ");
 			}
 			System.out.println();
 		}
 		System.out.println();
 	}
}
