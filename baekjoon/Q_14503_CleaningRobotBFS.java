package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_14503_CleaningRobotBFS {
	static int N, M, r, c, d, count, result;
	static int[][] map;
	static boolean[][] visited;
	static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
	static boolean flag = true;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		for(int i=0 ; i<N ; i++) {
			StringTokenizer st2= new StringTokenizer(br.readLine());
			for(int j=0 ; j<M ; j++) {
				map[i][j] = Integer.parseInt(st2.nextToken());
			}
		}

		result++;
		detect();
		System.out.println(result);
	}
	
	public static void detect() {
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(r,c,d));
		while(flag) {
			Pair node = q.poll();
			switch(d) {
			case 0: // ����
				// ���� ũ�⺸�� ũ�ٸ�
				if(r<0 || c-1<0 || r>=N || c-1>=M) {}
				// ���ʹ���(��)�� û���� ������ ���ٸ� ���ʹ��� �ٶ󺸱�
				else if(map[r][c-1] == 1 || visited[r][c-1]) d = 3;
				// �� ���� ��� û�Ұ� �̹� �Ǿ��ְų� ���� ��쿡��, �ٶ󺸴� ������ ������ ä�� �� ĭ ����(��)
				else if(isCleaned(node)) {
					d = 0;
					if(r-1<0) {}
					// ���� ����(��)�� ���̰ų� û������ ���
					else if(map[r-1][c] == 1 || visited[r-1][c])
						flag = false;
					else
						r = r-1;
				}
				// û�Ұ� �Ǿ� ���� �ʰ�, ���� �ƴ϶�� ���ʹ���(��)���� ����
	            else if(!visited[r][c-1] && map[r][c-1] == 0) {
	            	result ++;					
	            	c = c-1;
					d = 3;				
					visited[r][c] = true;
					q.add(new Pair(r,c,d));
				}
				break;
			case 1: // ����
				// ���� ũ�⺸�� ũ�ٸ�
				if(r-1<0 || c<0 || r-1>=N || c>=M) {}
				// ���ʹ���(��)�� û���� ������ ���ٸ� ���ʹ��� �ٶ󺸱�
				else if(map[r-1][c] == 1 || visited[r-1][c]) d = 0;
				// �� ���� ��� û�Ұ� �̹� �Ǿ��ְų� ���� ��쿡��, �ٶ󺸴� ������ ������ ä�� �� ĭ ����(��)
				else if(isCleaned(node)) {
					d = 1;
					if(c-1<0) {}
					// ���� ����(��)�� ���̰ų� û������ ���
					else if(map[r][c-1] == 1 || visited[r][c-1])
						flag = false;
					else
						c = c-1;
				}
				// û�Ұ� �Ǿ� ���� �ʰ�, ���� �ƴ϶�� ���ʹ���(��)���� ����
				else if(!visited[r-1][c] && map[r-1][c] == 0) {
					result ++;
					r = r-1;
					d = 0;				
					visited[r][c] = true;
					q.add(new Pair(r,c,d));
				}
				break;
			case 2: // ����
				// ���� ũ�⺸�� ũ�ٸ�
				if(r<0 || c+1<0 || r>=N || c+1>=M) {}
				// ���ʹ���(��)�� û���� ������ ���ٸ� ���ʹ��� �ٶ󺸱�
				else if(map[r][c+1] == 1 || visited[r][c+1]) d = 1;
				// �� ���� ��� û�Ұ� �̹� �Ǿ��ְų� ���� ��쿡��, �ٶ󺸴� ������ ������ ä�� �� ĭ ����(��)
				else if(isCleaned(node)) {
					d = 2;
					if(r+1>=N) {}
					// ���� ����(��)�� ���̰ų� û������ ���
					else if(map[r+1][c] == 1 || visited[r+1][c])
						flag = false;					
					else
						r = r+1;
				}
				// û�Ұ� �Ǿ� ���� �ʰ�, ���� �ƴ϶�� ���ʹ���(��)���� ����
				else if(!visited[r][c+1] && map[r][c+1] == 0) {
					result ++;
					c = c+1;
					d = 1;				
					visited[r][c] = true;
					q.add(new Pair(r,c,d));
				}
				break;
			case 3: // ����
				// ���� ũ�⺸�� ũ�ٸ�
				if(r+1<0 || c<0 || r+1>=N || c>=M) {}
				// ���ʹ���(��)�� û���� ������ ���ٸ� ���ʹ��� �ٶ󺸱�
				else if(map[r+1][c] == 1 || visited[r+1][c]) d = 2;
				// �� ���� ��� û�Ұ� �̹� �Ǿ��ְų� ���� ��쿡��, �ٶ󺸴� ������ ������ ä�� �� ĭ ����(��)
				else if(isCleaned(node)) {
					d = 3;
					if(c+1>=M) {}
					// ���� ����(��)�� ���̰ų� û������ ���
					else if(map[r][c+1] == 1 || visited[r][c+1])
						flag = false;					
					else
						c = c+1;
				}
				// û�Ұ� �Ǿ� ���� �ʰ�, ���� �ƴ϶�� ���ʹ���(��)���� ����
				else if(!visited[r+1][c] && map[r+1][c] == 0) {
					result ++;
					r = r+1;
					d = 2;				
					visited[r][c] = true;
					q.add(new Pair(r,c,d));
				}
				break;
			
			}
		}
	}
	
	// û�Ұ� �Ǿ��ְų� ���� ��츦 �˻�
	public static boolean isCleaned(Pair node){
		count = 0;
		for(int i=0 ; i<4 ; i++) {
			int nodeR = node.r+dir[i][0];
            int nodeC = node.c+dir[i][1];
            // ���� ũ�⺸�� Ŭ ��
            if(nodeR<0 || nodeC<0 || nodeR>=N || nodeC>=M) continue;
            else if(map[nodeR][nodeC] ==1 || visited[nodeR][nodeC])
            	count++;
		}
		if(count == 3 || count == 4)
			return true;
		else
			return false;
		
	}
	
	static class Pair {
		private int r, c, d ;
		public Pair(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
		
	}
}
