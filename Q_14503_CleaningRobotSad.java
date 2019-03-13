package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_14503_CleaningRobotSad {
	static int N, M, r, c, d, count, result;
	static int[][] map;
	static boolean[][] visited;
	static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
	static boolean backOK, flag;
	static Queue<Pair> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		q = new LinkedList<>();
		flag = true;
		
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken()); // 청소기의 위치 
		c = Integer.parseInt(st.nextToken()); // 청소기의 위치
		d = Integer.parseInt(st.nextToken()); // 청소기의 방향
		
		for(int i=0 ; i<N ; i++) {
			StringTokenizer st2= new StringTokenizer(br.readLine());
			for(int j=0 ; j<M ; j++) {
				map[i][j] = Integer.parseInt(st2.nextToken());
			}
		}
		
		q.add(new Pair(r,c,d));
		visited[r][c] = true;
		result++;
		detect();
		System.out.println(result);
	}
	
	public static void detect() {
		while(flag) {
			Pair cur = q.poll();
			int nodeR = cur.r;
			int nodeC = cur.c;
			int nodeD = cur.d;
			
			switch(nodeD) {
			
			// 북쪽 : 왼쪽방향(서)
			case 0:
				System.out.println("서");
				left(nodeR, nodeC, nodeD);
				break;
				
			// 동쪽 : 왼쪽방향(북)
			case 1:
				System.out.println("북");
				up(nodeR, nodeC, nodeD);
				break;
				
			// 남쪽 : 왼쪽방향(동)
			case 2:
				System.out.println("동");
				right(nodeR, nodeC, nodeD);
				break;
				
			// 서쪽 : 왼쪽방향(남)
			case 3:
				System.out.println("남");
				down(nodeR, nodeC, nodeD);
				break;
			}
				
		}
	}
	
	public static void up(int nodeR, int nodeC, int nodeD) {
		nodeR += dir[2][0];
		nodeC += dir[2][1];
		nodeD = 0;
		// 맵의 크기보다 큰 경우 continue
		if(nodeR<0 || nodeC<0 || nodeR>=N || nodeC>=M) {}
		// 청소가 되어있지 않고 벽이 아니라면 전진하여 청소
		else if(!visited[nodeR][nodeC] && map[nodeR][nodeC] == 0) {
			visited[nodeR][nodeC] = true;
			result ++;
			q.add(new Pair(nodeR,nodeC,nodeD));
			System.out.println("up 청소가즈아"+nodeR+" "+nodeC);
		}
		// 청소가 되어있고 벽이라면 continue
		else if(isCleaned(nodeR,nodeC,nodeD)==1 && (visited[nodeR][nodeC] || map[nodeR][nodeC] == 1)) {
			nodeR -= dir[2][0];
			nodeC -= dir[2][1];
			q.add(new Pair(nodeR,nodeC,nodeD));
			System.out.println("up 청소 막혀또"+nodeR+" "+nodeC);
		}
		// 삼방이 청소가 되어있고 후진 가능이면 후진
		else if(isCleaned(nodeR,nodeC,nodeD) == 3) {
			nodeR -= 2*dir[2][0];
			nodeC -= 2*dir[2][1];
			q.add(new Pair(nodeR,nodeC,nodeD));
			System.out.println("up 삼방 청소 & 후진가능"+nodeR+" "+nodeC);
		} 
		// 사방이 청소가 되어있고 후진 불가하면 반복문 빠져나오기
		else if(isCleaned(nodeR,nodeC,nodeD) == 4)
			flag = false;
		
	}
	
	public static void right(int nodeR, int nodeC, int nodeD) {
		nodeR += dir[1][0];
		nodeC += dir[1][1];
		nodeD= 1;
	
		if(nodeR<0 || nodeC<0 || nodeR>=N || nodeC>=M) {}
		else if(!visited[nodeR][nodeC] && map[nodeR][nodeC] == 0) {
			visited[nodeR][nodeC] = true;
			result++;
			q.add(new Pair(nodeR,nodeC,nodeD));
			System.out.println("right 청소가즈아"+nodeR+" "+nodeC);
		} else if(isCleaned(nodeR,nodeC,nodeD) == 1 && (visited[nodeR][nodeC] || map[nodeR][nodeC] == 1)) {
			nodeR -= dir[1][0];
			nodeC -= dir[1][1];
			q.add(new Pair(nodeR,nodeC,nodeD));
			System.out.println("right 청소 막혀또"+nodeR+" "+nodeC);
		} else if(isCleaned(nodeR,nodeC,nodeD) == 3) {
			nodeR -= 2*dir[1][0];
			nodeC -= 2*dir[1][1];
			q.add(new Pair(nodeR,nodeC,nodeD));
			System.out.println("right 삼방 청소 & 후진가능"+nodeR+" "+nodeC);
		} else if(isCleaned(nodeR,nodeC,nodeD) == 4)
			flag = false;
	}
	
	public static void down(int nodeR, int nodeC, int nodeD) {
		nodeR += dir[0][0];
		nodeC += dir[0][1];
		nodeD = 2;

		if(nodeR<0 || nodeC<0 || nodeR>=N || nodeC>=M) {}
		else if(!visited[nodeR][nodeC] && map[nodeR][nodeC] == 0) {
			visited[nodeR][nodeC] = true;
			result++;
			q.add(new Pair(nodeR,nodeC,nodeD));
			System.out.println("down 청소가즈아"+nodeR+" "+nodeC);
		} else if(isCleaned(nodeR,nodeC,nodeD) == 1 && (visited[nodeR][nodeC] || map[nodeR][nodeC] == 1)) {
			nodeR -= dir[0][0];
			nodeC -= dir[0][1];
			System.out.println("down 청소 막혀또"+nodeR+" "+nodeC);
			q.add(new Pair(nodeR,nodeC,nodeD));
		} else if(isCleaned(nodeR,nodeC,nodeD) == 3) {
			nodeR -= 2*dir[0][0];
			nodeC -= 2*dir[0][1];
			q.add(new Pair(nodeR,nodeC,nodeD));
			System.out.println("down 삼방 청소 & 후진가능"+nodeR+" "+nodeC);
		} else if(isCleaned(nodeR,nodeC,nodeD) == 4)
			flag = false;
	}
	
	public static void left(int nodeR, int nodeC, int nodeD) {
		nodeR += dir[3][0];
		nodeC += dir[3][1];
		nodeD = 3;
		if(nodeR<0 || nodeC<0 || nodeR>=N || nodeC>=M) {}
		else if(!visited[nodeR][nodeC] && map[nodeR][nodeC] == 0) {
			visited[nodeR][nodeC] = true;
			System.out.println("left 청소가즈아"+nodeR+" "+nodeC);
			result++;
			q.add(new Pair(nodeR,nodeC,nodeD));
		} else if(isCleaned(nodeR,nodeC,nodeD) == 1 && (visited[nodeR][nodeC] || map[nodeR][nodeC] == 1)) {
			nodeR -= dir[3][0];
			nodeC -= dir[3][1];
			System.out.println("left 청소 막혀또"+nodeR+" "+nodeC);
			q.add(new Pair(nodeR,nodeC,nodeD));
		} else if(isCleaned(nodeR, nodeC,nodeD) == 3) {
			System.out.println("left 삼방 청소 & 후진가능"+nodeR+" "+nodeC);
			nodeR -= 2*dir[3][0];
			nodeC -= 2*dir[3][1];
			q.add(new Pair(nodeR,nodeC,nodeD));
		}  else if(isCleaned(nodeR,nodeC,nodeD) == 4) {
			System.out.println("left 사방 청소 & 후진불가능");
			flag = false;
		}
	}
	
	
	// 청소가 되어있거나 벽인 경우를 검색
	public static int isCleaned(int x, int y, int d){
		switch(d) {
		case 0:
			x -= 1;
			break;
		case 1:
			y -= 1;
			break;
		case 2:
			x += 1;
			break;
		case 3:
			y += 1;
			break;
		}
		
		int count = 0;
		backOK = false;
		
		for(int i=0 ; i<4 ; i++) {
			int nodeR = x + dir[i][0];
			int nodeC = y + dir[i][1];
            // 맵의 크기보다 클 때
            if(nodeR<0 || nodeC<0 || nodeR>=N || nodeC>=M) continue;
            else if(map[nodeR][nodeC] ==1 || visited[nodeR][nodeC])
            	++count;
		}
		if(count == 2)
			count = 1;
		return count;
	}
	
	static class Pair {
		int r;
		int c;
		int d;
		public Pair(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
		
	}
}
