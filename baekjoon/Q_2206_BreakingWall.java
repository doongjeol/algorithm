package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_2206_BreakingWall {
	static int row,col,startR,startC,endR,endC;
	static int[][] map, time;
	static boolean[][] breakWall;
	static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		map = new int[row][col];
		time = new int[row][col];
		breakWall = new boolean[row][col];
		startR = startC = 0;
		endR = row-1;
		endC = col-1;
		
		for(int r=0 ; r<row ;r++){
			String temp = br.readLine();
			for(int c=0 ; c<col ; c++){
				map[r][c] = temp.charAt(c) - '0';
			}
		}
		bfs();
		
		if(time[row-1][col-1] == 0)
			System.out.println(-1);
		else
			System.out.println(time[row-1][col-1]);
	}
	
	public static void bfs() {
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(startR, startC, false));
		time[startR][startC] = 1;
		
		while(!q.isEmpty()) {
			Pair cur = q.poll();
			if(cur.r == row-1 && cur.c == col-1) return;
			for(int i=0 ; i<4 ; i++){
				int nodeR = cur.r + dir[i][0];
				int nodeC = cur.c + dir[i][1];
				
				if(nodeR<0 || nodeR>=row || nodeC<0 || nodeC>=col) continue;
				// ���� ���� �� ���� && �ѹ��� �Ȱ��� && ���� ���
				else if(!cur.check && time[nodeR][nodeC] == 0 && map[nodeR][nodeC] == 1) {
					time[nodeR][nodeC] = time[cur.r][cur.c] + 1;
					q.add(new Pair(nodeR, nodeC, true));
				// ���� ���� �� �ְ� && �ѹ��� �Ȱ��� && ���� �ƴѰ��
				}else if(cur.check && time[nodeR][nodeC] == 0 && map[nodeR][nodeC] == 0) {
					time[nodeR][nodeC] = time[cur.r][cur.c] + 1;
					q.add(new Pair(nodeR, nodeC, true));
				// ���� ���� �� ���� && ���� �վ��� ��츸 �湮�� ���
				} else if(!cur.check && !breakWall[nodeR][nodeC] && map[nodeR][nodeC] == 0) {
					time[nodeR][nodeC] = time[cur.r][cur.c] + 1;
					q.add(new Pair(nodeR, nodeC, false));
					breakWall[nodeR][nodeC] = true;
				}
			}
		}
	}
	
	public static void write() {
 		for(int i=0 ; i<row ; i++) {
 			for(int j=0 ; j<col ; j++) {
 				System.out.print(map[i][j]+" ");
 			}
 			System.out.println();
 		}
 		System.out.println();
 	}
	
	public static class Pair {
		int r;
		int c;
		boolean check;
		
		public Pair(int r, int c, boolean check) {
			this.r = r;
			this.c = c;
			this.check = check;
		}
		
	}

}
