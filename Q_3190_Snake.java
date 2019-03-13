package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q_3190_Snake {
	static int n, curX, curY, time, d, tailX, tailY, tailLength;
	static int[][] map;
	static boolean[][] length;
	static boolean flag = true;
	static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
	static List<Pair> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		map = new int[n][n];
		length = new boolean[n][n];
		list = new ArrayList<>();
		
		tailLength = 1;
		
		// 맵 초기화
		for(int i=0 ; i<n ; i++) {
			for(int j=0 ; j<n ; j++)
				map[i][j] = 0;
		}
		
		// 사과
		for(int i=0 ; i<k ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = 1;
		}
		
		int l = Integer.parseInt(br.readLine());
		
		// 방향 변환 정보
		for(int i=0; i<l ; i++ ) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			char c = st.nextToken().charAt(0);
			list.add(new Pair(x,c));
		}
		
		// 뱀이 바라보는 방향 0: 북  1: 동  2: 남  3: 서
		int i = 1;
		int nodeX = curX;
		int nodeY = curY;
		tailX = tailY = 0;
		while(flag) {
			
			if(nodeX<0 || nodeX>=n || nodeY<0 || nodeY>=n) flag = false;
			else {
				go(nodeX, nodeY, i, 0);
				
				for(int j=0 ; j<list.size() ; j++) {
					if(time == list.get(j).x) {
						switch(list.get(j).c) {
						// 왼쪽
						case 'L' :
							nodeX -= dir[i][0]; 
							nodeY -= dir[i][1];
							switch(d) {
							case 0 :
								d = 3;
								i = 0;
								nodeX += dir[i][0];
								nodeY += dir[i][1];
								break;
							case 1 :
								d = 0;
								i = 3;
								nodeX += dir[i][0];
								nodeY += dir[i][1];
								break;
							case 2 :
								d = 1;
								i = 1;
								nodeX += dir[i][0];
								nodeY += dir[i][1];
								break;
							case 3 :
								d = 2;
								i = 2;
								nodeX += dir[i][0];
								nodeY += dir[i][1];
								break;
							}
							break;
							
						// 오른쪽
						case 'D' :
							switch(d) {
							case 0 :
								d = 1;
								i = 1;
								nodeX += dir[i][0];
								nodeY += dir[i][1];
								break;
							case 1 :
								d = 2;
								i = 3;
								nodeX += dir[i][0];
								nodeY += dir[i][1];
								break;
							case 2 :
								d = 3;
								i = 0;
								nodeX += dir[i][0];
								nodeY += dir[i][1];
								break;
							case 3 :
								d = 0;
								i = 2;
								nodeX += dir[i][0];
								nodeY += dir[i][1];
								break;
							}
							break;
							
						}
					}
					
					go(nodeX, nodeY, i, j);
					
					
				}
			}
		}
		
		System.out.println(tailLength);
		System.out.println(time);
	}
	
	public static void go(int nodeX, int nodeY, int i, int j) {
		while(time<list.get(j).x) {
			length[tailX][tailY] = false;
			nodeX += dir[i][0];
			nodeY += dir[i][1];
			if(nodeX<0 || nodeX>=n || nodeY<0 || nodeY>=n) flag = false;
			else if(length[nodeX][nodeY]) 
				flag = false;
			else if(map[nodeX][nodeY] == 1) {
				tailLength ++;
				map[nodeX][nodeY] = 0;
				length[nodeX][nodeY] = true;
				if(tailLength > 3) {
					tailX = nodeX - dir[i][0] - (tailLength - 2);
					tailY = nodeX - dir[i][1] - (tailLength - 2);
				} else {
					tailX = nodeX - dir[i][0];
					tailY = nodeX - dir[i][1];
				}
				length[tailX][tailY] = true;
			} else {
				length[nodeX][nodeY] = true;
				if(tailLength > 1) {
					tailX = nodeX - dir[i][0] - (tailLength - 2);
					tailY = nodeX - dir[i][1] - (tailLength - 2);
				} else {
					tailX = nodeX;
					tailY = nodeX;
				}
			}
			time++;
		}
		
	}
	
	public static class Pair {
		int x;
		char c;
		
		public Pair(int x, char c) {
			this.x = x;
			this.c = c;
		}
		
	}
}
