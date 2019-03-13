package backjoon;

import java.util.Scanner;

public class Q_13460_MarbleEscapeDFSSad {
	static int N,M,redR,redC,blueR,blueC;
	static char[][] map;
	static boolean[][] visited;
	static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
	static boolean modeFlag,returnFlag;
	static int count;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 가로(열)
		M = sc.nextInt(); // 세로(행)
		sc.nextLine();
		map = new char[M][N];
		visited = new boolean[M][N];
		
		for(int i=0 ; i<M ; i++) {
			String temp = sc.nextLine();
			for(int j=0 ; j<N ; j++) {
				map[i][j] = temp.charAt(j);
				if(map[i][j] == 'R') {
					redR = i; redC = j;
				} else if(map[i][j] == 'B') {
					blueR = i; blueC = j;
				}
			}
		}
		
		garo(redR,redC);
		System.out.println(count);
		
	}
	
	public static void sero(int x, int y) {
		visited[x][y] = true;
		
		for(int i=0 ; i<4 ; i++) {
			int nodeX = x + dir[i][0];
			int nodeY = y ;
			if(nodeX<0 || nodeX>=M || nodeY<0 || nodeY>=N) continue;
			if(map[nodeX][nodeY] == 'O') {
				count++;
				System.out.println("sero O");
				break;
			} else if(map[nodeX][nodeY] == '.' && !visited[nodeX][nodeY]) {
				modeFlag = true;
				System.out.println("sero .");
				garo(nodeX,nodeY);
				if(!modeFlag)
					count ++;
			} else if(map[nodeX][nodeY] == '#' || map[nodeX][nodeY] == 'B') {
				modeFlag = false;
				returnFlag = true;
				System.out.println("sero # || B");
				return;
			} else if(returnFlag) {
				System.out.println("sero return");
				garo(nodeX,nodeY);
			}
		}
	}
	
	public static void garo(int x, int y) {
		visited[x][y] = true;
		
		for(int i=0 ; i<4 ; i++) {
			int nodeX = x ;
			int nodeY = y + dir[i][1];
			if(nodeX<0 || nodeX>=M || nodeY<0 || nodeY>=N) continue;
			if(map[nodeX][nodeY] == 'O') {
				count++;
				System.out.println("garo O");
				break;
			} else if(map[nodeX][nodeY] == '.' && !visited[nodeX][nodeY]) {
				modeFlag = true;
				System.out.println("garo .");
				sero(nodeX,nodeY);
				if(!modeFlag)
					count ++;
			} else if(map[nodeX][nodeY] == '#' || map[nodeX][nodeY] == 'B') {
				modeFlag = false;
				returnFlag = true;
				garo(nodeX,nodeY>y?nodeY-1:nodeY+1);
				System.out.println("garo # || B");
			} else if(returnFlag) {
				System.out.println("garo return");
				sero(nodeX,nodeY);
			}
		}
	}
}
