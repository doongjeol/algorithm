package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_7562_MovingOfKnight {
	static int startR, startC, endR, endC, l;
	static int[][] board;
	static int[][] dir = {{-1,-2},{-2,-1},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2}};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int t=0 ; t<testCase ; t++) {
			l = Integer.parseInt(br.readLine());
			board = new int[l][l];
			for(int r=0 ; r<l ; r++) {
				for(int c=0 ; c<l ; c++) {
					board[r][c] = -1;
				}
			}
			StringTokenizer st = new StringTokenizer(br.readLine());
			startR = Integer.parseInt(st.nextToken());
			startC = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			endR = Integer.parseInt(st.nextToken());
			endC = Integer.parseInt(st.nextToken());
			bfs();
			System.out.println(board[endR][endC]);
		}
		
		
	}
	
	public static void bfs() {
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(startR, startC));
		board[startR][startC] = 0;
		
		while(!q.isEmpty()) {
			Pair cur = q.poll();
			
			for(int i=0 ; i<8 ; i++) {
				int nodeR = cur.r + dir[i][0];
				int nodeC = cur.c + dir[i][1];
				
				if(nodeR<0 || nodeR>=l || nodeC<0 || nodeC>=l) continue;
				else if(board[nodeR][nodeC] == -1) {
					board[nodeR][nodeC] = board[cur.r][cur.c] + 1;
					q.add(new Pair(nodeR, nodeC));
				}
				
			}
		}
	}
	public static void write() {
 		for(int i=0 ; i<l ; i++) {
 			for(int j=0 ; j<l ; j++) {
 				System.out.print(board[i][j]+" ");
 			}
 			System.out.println();
 		}
 		System.out.println();
 	}
	public static class Pair {
		int r;
		int c;
		public Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
