package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_1697_HideAndSeek {
	static int subin, younger;
	static int[] time;
	static int[] dir = new int[3];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		subin = Integer.parseInt(st.nextToken());
		younger = Integer.parseInt(st.nextToken());
		time = new int[1000001];
		Arrays.fill(time, -1);
		dir[0] = 1;
		dir[1] = -1;
		
		bfs();
		System.out.println(time[younger]);
	}
	
	public static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(subin);
		time[subin] = 0;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			dir[2] = cur;
			
			for(int i=0 ; i<3 ; i++) {
				int node = cur + dir[i];
				
				if(node<0 || node> 1000000) continue;
				else if(time[node] == -1){
					time[node] = time[cur] + 1;
					q.add(node);
				}
			}
		}
	}
}
