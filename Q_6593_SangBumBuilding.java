package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_6593_SangBumBuilding {
	static int l,r,c, startL, startR, startC, endL, endR, endC;
	static char[][][] building;
	static int[][][] visited;
	static int[][] dir = {{1,0,0},{0,1,0},{0,0,1},{-1,0,0},{0,-1,0},{0,0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			l = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			building = new char[l][r][c];
			visited = new int[l][r][c];
			for(int i=0 ; i<l ; i++) {
				for(int j=0 ; j<r ; j++) {
					String temp = br.readLine();
					for(int k=0 ; k<c ; k++) {
						building[i][j][k] = temp.charAt(k);
						visited[i][j][k] = -1;
						if(building[i][j][k] == 'S') { 
							startL = i; startR = j; startC = k;
						} else if(building[i][j][k] == 'E') {
							endL = i; endR = j; endC = k;
						}
					}
				}
				br.readLine();
			}
//			if(l<1 || r<1 || c<1 || l>30 || r>30 || c>30) continue;
			if(l==0 && r==0 && c==0) break;
			else {
				bfs();
				if(visited[endL][endR][endC] == -1) 
					System.out.println("Trapped!");
				else
					System.out.println("Escaped in " + visited[endL][endR][endC] + " minute(s).");
			}
		}
		
		
	}
	
	public static void bfs() {
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(startL, startR, startC));
		visited[startL][startR][startC] = 0;
		
		while(!q.isEmpty()) {
			Pair cur = q.poll();
			for(int i=0 ; i<6 ; i++) {
				int nodeL = cur.l + dir[i][0];
				int nodeR = cur.r + dir[i][1];
				int nodeC = cur.c + dir[i][2];

				if(nodeL<0 || nodeL>=l || nodeR<0 || nodeR>=r || nodeC<0 || nodeC>=c) continue;
				else if(building[nodeL][nodeR][nodeC] == '.' && visited[nodeL][nodeR][nodeC] == -1) {
					q.add(new Pair(nodeL, nodeR, nodeC));
					visited[nodeL][nodeR][nodeC] = visited[cur.l][cur.r][cur.c] + 1;
				} else if( building[nodeL][nodeR][nodeC] == 'E' ) {
					visited[nodeL][nodeR][nodeC] = visited[cur.l][cur.r][cur.c] + 1;
					break;
				}
					
			}
			
		}
		
	}
	
	public static class Pair{
		int l;
		int r;
		int c;		public Pair(int l, int r, int c) {
			this.l = l;
			this.r = r;
			this.c = c;
		}
		
	}
}
