package baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_5014_StartLink {
	static int total, start, end, up, down;
	static int[] building;
	static int[] dir = new int[2];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		total = Integer.parseInt(st.nextToken());
		building = new int[total+1];
		Arrays.fill(building, -1);
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		up = Integer.parseInt(st.nextToken());
		down = Integer.parseInt(st.nextToken());
		dir[0] = up; dir[1] = -down;
		
		bfs();
		
		if(building[end] == -1)
			System.out.println("use the stairs");
		else
			System.out.println(building[end]);
	}
	
	public static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		building[start] = 0;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int i=0 ; i<2 ; i++) {
				int curMove = cur + dir[i];
				if(curMove<0 || curMove>total) continue;
				else if(building[curMove] == -1){
					q.add(curMove);
					building[curMove] = building[cur] + 1;
				}
			}
			
		}
	}
}
