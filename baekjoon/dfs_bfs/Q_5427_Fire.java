package baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_5427_Fire {
	static int w, h, fireTime, startR, startC, endR, endC;
	static boolean flag;
	static Queue<Pair> q, fire;
	static char[][] map;
	static int[][] time;
	static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int i=0 ; i<t ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			map = new char[h][w];
			time = new int[h][w];
			q = new LinkedList<>();
			fire = new LinkedList<>();
			
			for(int r=0 ; r<h ; r++) {
				String temp = br.readLine();
				for(int c=0 ; c<w ; c++) {
					map[r][c] = temp.charAt(c);
					if(map[r][c] == '@') {
						startR = r ; startC = c;
						map[r][c] = '.';
					} else if(map[r][c] == '*') {
						fire.add(new Pair(r,c));
//						System.out.println("�Է�: "+r+" "+c);
					}
				}
			}
			flag = false; 
			solve();
			if(!flag)
				System.out.println("IMPOSSIBLE");
			else
				System.out.println(time[endR][endC]);
		}
	}
 	
 	public static void solve() {
 		q.add(new Pair(startR, startC));
 		time[startR][startC] = 1;
 		
 		if(startR == 0 || startC == 0 || startR == h-1 || startC == w-1) {
 			endR = startR ; endC = startC;
 			flag = true;
 		} else {
 		while(!q.isEmpty() || !fire.isEmpty()) { 
 			
			int fireSize = fire.size();
			for(int n=0; n<fireSize ; n++) {
 				Pair fireCur = fire.poll();
 			
	 			for(int i=0 ; i<4 ; i++) {
	 				int nodeR = fireCur.r + dir[i][0];	 				
	 				int nodeC = fireCur.c + dir[i][1];
	 				
//	 				System.out.println("���� fire: "+fireCur.r+" "+fireCur.c);
	 				if(nodeR<0 || nodeR>=h || nodeC<0 || nodeC>=w) continue;
	 				else if(map[nodeR][nodeC] == '#' || map[nodeR][nodeC] == '*') continue;
	 				else if(map[nodeR][nodeC] == '.' || map[nodeR][nodeC] == '@') {
//	 					System.out.println(nodeR+" "+nodeC);
	 					map[nodeR][nodeC] = '*';
	 					fire.add(new Pair(nodeR, nodeC));
	 				}
	 			}
			}
 			
 			int qSize = q.size();
 			for(int n=0 ; n<qSize ; n++) {
 				Pair cur = q.poll();
 				map[cur.r][cur.c] = '.';
	 			for(int i=0 ; i<4 ; i++) {
		 			int nodeR = cur.r + dir[i][0];
		 			int nodeC = cur.c + dir[i][1];
		 			
		 			if(nodeR<0 || nodeR>=h || nodeC<0 || nodeC>=w) continue;
		 			else if(map[nodeR][nodeC] == '#' || map[nodeR][nodeC] == '*') continue;
		 			else if(nodeR == 0 || nodeR == h-1 || nodeC == 0 || nodeC == w-1 ) {
			 			if(map[nodeR][nodeC]=='.'){
		 					flag = true;
		 					time[nodeR][nodeC] = time[cur.r][cur.c] + 1;
		 					endR = nodeR ; endC = nodeC;
		 					return;
						} else continue;
		 			}
		 			else if(map[nodeR][nodeC] == '.' && time[nodeR][nodeC] == 0) {
		 				map[nodeR][nodeC] = '@';
		 				q.add(new Pair(nodeR, nodeC));
		 				time[nodeR][nodeC] = time[cur.r][cur.c] + 1;
		 			}
	 			}
 			}
 		}
 		}
 		
 	}
 	
 	public static void write() {
 		for(int i=0 ; i<h ; i++) {
 			for(int j=0 ; j<w ; j++) {
 				System.out.print(map[i][j]+" ");
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


