package baekjoon;

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
			
			// 10�� �̻��� �� continue�� ť�� ���� �ؼ� while���� ������������
			if(cur.count > 10)
				continue;
			
			for(int i=0 ; i<4 ; i++) {
				nodeRX = dir[i][0] + cur.redR;
				nodeRY = dir[i][1] + cur.redC;
				nodeBX = dir[i][0] + cur.blueR;
				nodeBY = dir[i][1] + cur.blueC;
				switch(i) {
				case 0:
					casei = "��";
					break;
				case 1:
					casei="��";
					break;
				case 2:
					casei="��";
					break;
				case 3:
					casei="��";
					break;
				}
				System.out.println(casei+" : "+nodeRX+"  "+nodeRY+" : "+nodeBX+"  "+nodeBY);
				
				redPass = redMeet = bluePass = blueMeet = false;
				
				// ������ - while�� : �ѹ������� ������
				while(nodeRX>=0 && nodeRX<N && nodeRY>=0 && nodeRY<M) {
					// �������� �Ķ����� �������
					if(nodeRX == nodeBX && nodeRY == nodeBY) {
						// �������� flag�� true�� & ������������ ���� �Ѵ�
						blueMeet = true;
						System.out.println("������ ���� �Ķ��� ������ "+nodeRX +" "+nodeRY);
						nodeRX -= dir[i][0];
						nodeRY -= dir[i][1];
						break;
						// #�� ������ ������������
					} else if(matrix[nodeRX][nodeRY] == '#') {
						System.out.println("������ ���� # "+nodeRX +" "+nodeRY);
						nodeRX -= dir[i][0];
						nodeRY -= dir[i][1];
						break;
//						 O�� ������ redPass flag�� true��
					} else if(matrix[nodeRX][nodeRY] == 'O') {
						redPass = true;
						System.out.println("������ ���� O "+nodeRX +" "+nodeRY);
						break;
					} else {
						System.out.println("������ ���� ��� ���ÿ� "+nodeRX +" "+nodeRY);
						nodeRX += dir[i][0];
						nodeRY += dir[i][1];
					}
				}
				
				// �Ķ���
				while(nodeBX>= 0 && nodeBX<N && nodeBY>=0 && nodeBY<M) {
					// �Ķ����� �������� �������
					if(nodeBX == nodeRX && nodeBY == nodeRY) {
						redMeet = true;
						System.out.println("�Ķ��� ���� ������ ������ "+nodeBX +" "+nodeBY);
						nodeBX -= dir[i][0];
						nodeBY -= dir[i][1];
						break;
					} else if(matrix[nodeBX][nodeBY] == '#') {
						System.out.println("�Ķ��� ���� # "+nodeBX +" "+nodeBY);
						nodeBX -= dir[i][0];
						nodeBY -= dir[i][1];
						break;
					} else if(matrix[nodeBX][nodeBY] == 'O') {
						bluePass = true;
						System.out.println("�Ķ��� ���� O "+nodeBX +" "+nodeBY);
						break;
					} else {
						System.out.println("�Ķ��� ���� ��� ���ÿ� "+nodeBX +" "+nodeBY);
						nodeBX += dir[i][0];
						nodeBY += dir[i][1];
					}
				}
				
				// O�� ���������� �Ķ����� �������� ���������
				if(redPass && redMeet)
					continue;
				// O�� ���������
				else if(redPass)
					return cur.count;
				
				// �Ķ����� ���������
				if(bluePass)
					continue;
				
				// �������� �Ķ����� ������ ��� ������ ���·� ���ư�
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
