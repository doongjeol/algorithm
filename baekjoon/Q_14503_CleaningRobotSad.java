package baekjoon;

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
		r = Integer.parseInt(st.nextToken()); // û�ұ��� ��ġ 
		c = Integer.parseInt(st.nextToken()); // û�ұ��� ��ġ
		d = Integer.parseInt(st.nextToken()); // û�ұ��� ����
		
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
			
			// ���� : ���ʹ���(��)
			case 0:
				System.out.println("��");
				left(nodeR, nodeC, nodeD);
				break;
				
			// ���� : ���ʹ���(��)
			case 1:
				System.out.println("��");
				up(nodeR, nodeC, nodeD);
				break;
				
			// ���� : ���ʹ���(��)
			case 2:
				System.out.println("��");
				right(nodeR, nodeC, nodeD);
				break;
				
			// ���� : ���ʹ���(��)
			case 3:
				System.out.println("��");
				down(nodeR, nodeC, nodeD);
				break;
			}
				
		}
	}
	
	public static void up(int nodeR, int nodeC, int nodeD) {
		nodeR += dir[2][0];
		nodeC += dir[2][1];
		nodeD = 0;
		// ���� ũ�⺸�� ū ��� continue
		if(nodeR<0 || nodeC<0 || nodeR>=N || nodeC>=M) {}
		// û�Ұ� �Ǿ����� �ʰ� ���� �ƴ϶�� �����Ͽ� û��
		else if(!visited[nodeR][nodeC] && map[nodeR][nodeC] == 0) {
			visited[nodeR][nodeC] = true;
			result ++;
			q.add(new Pair(nodeR,nodeC,nodeD));
			System.out.println("up û�Ұ����"+nodeR+" "+nodeC);
		}
		// û�Ұ� �Ǿ��ְ� ���̶�� continue
		else if(isCleaned(nodeR,nodeC,nodeD)==1 && (visited[nodeR][nodeC] || map[nodeR][nodeC] == 1)) {
			nodeR -= dir[2][0];
			nodeC -= dir[2][1];
			q.add(new Pair(nodeR,nodeC,nodeD));
			System.out.println("up û�� ������"+nodeR+" "+nodeC);
		}
		// ����� û�Ұ� �Ǿ��ְ� ���� �����̸� ����
		else if(isCleaned(nodeR,nodeC,nodeD) == 3) {
			nodeR -= 2*dir[2][0];
			nodeC -= 2*dir[2][1];
			q.add(new Pair(nodeR,nodeC,nodeD));
			System.out.println("up ��� û�� & ��������"+nodeR+" "+nodeC);
		} 
		// ����� û�Ұ� �Ǿ��ְ� ���� �Ұ��ϸ� �ݺ��� ����������
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
			System.out.println("right û�Ұ����"+nodeR+" "+nodeC);
		} else if(isCleaned(nodeR,nodeC,nodeD) == 1 && (visited[nodeR][nodeC] || map[nodeR][nodeC] == 1)) {
			nodeR -= dir[1][0];
			nodeC -= dir[1][1];
			q.add(new Pair(nodeR,nodeC,nodeD));
			System.out.println("right û�� ������"+nodeR+" "+nodeC);
		} else if(isCleaned(nodeR,nodeC,nodeD) == 3) {
			nodeR -= 2*dir[1][0];
			nodeC -= 2*dir[1][1];
			q.add(new Pair(nodeR,nodeC,nodeD));
			System.out.println("right ��� û�� & ��������"+nodeR+" "+nodeC);
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
			System.out.println("down û�Ұ����"+nodeR+" "+nodeC);
		} else if(isCleaned(nodeR,nodeC,nodeD) == 1 && (visited[nodeR][nodeC] || map[nodeR][nodeC] == 1)) {
			nodeR -= dir[0][0];
			nodeC -= dir[0][1];
			System.out.println("down û�� ������"+nodeR+" "+nodeC);
			q.add(new Pair(nodeR,nodeC,nodeD));
		} else if(isCleaned(nodeR,nodeC,nodeD) == 3) {
			nodeR -= 2*dir[0][0];
			nodeC -= 2*dir[0][1];
			q.add(new Pair(nodeR,nodeC,nodeD));
			System.out.println("down ��� û�� & ��������"+nodeR+" "+nodeC);
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
			System.out.println("left û�Ұ����"+nodeR+" "+nodeC);
			result++;
			q.add(new Pair(nodeR,nodeC,nodeD));
		} else if(isCleaned(nodeR,nodeC,nodeD) == 1 && (visited[nodeR][nodeC] || map[nodeR][nodeC] == 1)) {
			nodeR -= dir[3][0];
			nodeC -= dir[3][1];
			System.out.println("left û�� ������"+nodeR+" "+nodeC);
			q.add(new Pair(nodeR,nodeC,nodeD));
		} else if(isCleaned(nodeR, nodeC,nodeD) == 3) {
			System.out.println("left ��� û�� & ��������"+nodeR+" "+nodeC);
			nodeR -= 2*dir[3][0];
			nodeC -= 2*dir[3][1];
			q.add(new Pair(nodeR,nodeC,nodeD));
		}  else if(isCleaned(nodeR,nodeC,nodeD) == 4) {
			System.out.println("left ��� û�� & �����Ұ���");
			flag = false;
		}
	}
	
	
	// û�Ұ� �Ǿ��ְų� ���� ��츦 �˻�
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
            // ���� ũ�⺸�� Ŭ ��
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
