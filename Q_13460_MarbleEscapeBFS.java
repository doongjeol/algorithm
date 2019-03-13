package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_13460_MarbleEscapeBFS {
	static int N, M, redR, redC, blueR, blueC, result;
	static boolean redPass, bluePass, redMeet, blueMeet;
	static char[][] matrix;
	static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
	static Queue<Pair> q;
	static String casei;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		matrix = new char[N][M];
		q = new LinkedList<>();
		for(int i=0 ; i<N ; i++) {
			String temp = br.readLine();
			for(int j=0 ; j<M ; j++) {
				matrix[i][j] = temp.charAt(j);
				if(matrix[i][j] == 'R') {
					redR = i; redC = j;
				} else if(matrix[i][j] == 'B') {
					blueR = i; blueC = j;
				}
			}
		}
//		
//		for(int i=0 ; i<M ; i++) {
//			for(int j=0 ; j<N ; j++) {
//				System.out.print(matrix[i][j]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println(redR+" "+redC);
//		System.out.println(blueR+" "+blueC);
		q.add(new Pair(redR, redC, blueR, blueC, 1));
		result = solve();
		System.out.println(result);
	}
	
	public static int solve() {
		while(!q.isEmpty()) {
			Pair cur = q.poll();
			int nodeRX, nodeRY, nodeBX, nodeBY;
			
			// 10번 이상일 때 continue로 큐를 비우게 해서 while문을 빠져나가도록
			if(cur.count > 10)
				continue;
			
			for(int i=0 ; i<4 ; i++) {
				nodeRX = dir[i][0] + cur.redR;
				nodeRY = dir[i][1] + cur.redC;
				nodeBX = dir[i][0] + cur.blueR;
				nodeBY = dir[i][1] + cur.blueC;
				switch(i) {
				case 0:
					casei = "하";
					break;
				case 1:
					casei="우";
					break;
				case 2:
					casei="상";
					break;
				case 3:
					casei="좌";
					break;
				}
				System.out.println(casei+" : "+nodeRX+"  "+nodeRY+" : "+nodeBX+"  "+nodeBY);
				
				redPass = redMeet = bluePass = blueMeet = false;
				
				// 빨간공 - while문 : 한방향으로 끝까지
				while(nodeRX>=0 && nodeRX<N && nodeRY>=0 && nodeRY<M) {
					// 빨간공과 파란공이 만날경우
					if(nodeRX == nodeBX && nodeRY == nodeBY) {
						// 만났을때 flag를 true로 & 이전방향으로 가게 한다
						blueMeet = true;
						System.out.println("빨간공 기준 파랑이 만났다 "+nodeRX +" "+nodeRY);
						nodeRX -= dir[i][0];
						nodeRY -= dir[i][1];
						break;
						// #을 만나면 이전방향으로
					} else if(matrix[nodeRX][nodeRY] == '#') {
						System.out.println("빨간공 기준 # "+nodeRX +" "+nodeRY);
						nodeRX -= dir[i][0];
						nodeRY -= dir[i][1];
						break;
//						 O를 만나면 redPass flag를 true로
					} else if(matrix[nodeRX][nodeRY] == 'O') {
						redPass = true;
						System.out.println("빨간공 기준 O "+nodeRX +" "+nodeRY);
						break;
					} else {
						System.out.println("빨간공 기준 계속 가시오 "+nodeRX +" "+nodeRY);
						nodeRX += dir[i][0];
						nodeRY += dir[i][1];
					}
				}
				
				// 파란공
				while(nodeBX>= 0 && nodeBX<N && nodeBY>=0 && nodeBY<M) {
					// 파란공과 빨간공이 만날경우
					if(nodeBX == nodeRX && nodeBY == nodeRY) {
						redMeet = true;
						System.out.println("파란공 기준 빨강이 만났다 "+nodeBX +" "+nodeBY);
						nodeBX -= dir[i][0];
						nodeBY -= dir[i][1];
						break;
					} else if(matrix[nodeBX][nodeBY] == '#') {
						System.out.println("파란공 기준 # "+nodeBX +" "+nodeBY);
						nodeBX -= dir[i][0];
						nodeBY -= dir[i][1];
						break;
					} else if(matrix[nodeBX][nodeBY] == 'O') {
						bluePass = true;
						System.out.println("파란공 기준 O "+nodeBX +" "+nodeBY);
						break;
					} else {
						System.out.println("파란공 기준 계속 가시오 "+nodeBX +" "+nodeBY);
						nodeBX += dir[i][0];
						nodeBY += dir[i][1];
					}
				}
				
				// O를 지나갔지만 파란공과 빨간공이 만났을경우
				if(redPass && redMeet)
					continue;
				// O를 지나간경우
				else if(redPass)
					return cur.count;
				
				// 파란공이 지나간경우
				if(bluePass)
					continue;
				
				// 빨간공이 파란공을 만났을 경우 이전의 상태로 돌아감
				if(blueMeet) {
					nodeRX = nodeBX - dir[i][0];
					nodeRY = nodeBY - dir[i][1];
				}
				
				q.add(new Pair(nodeRX,nodeRY,nodeBX,nodeBY,cur.count+1));
				System.out.println(cur.count);
			}
		}
		return -1;
	}
	
	public static class Pair {
		int redR;
		int redC;
		int blueR;
		int blueC;
		int count;
		public Pair(int redR, int redC, int blueR, int blueC, int count) {
			this.redR = redR;
			this.redC = redC;
			this.blueR = blueR;
			this.blueC = blueC;
			this.count = count;
		}
	}
}
