package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_9019_DSLR {
	static int a,b;
	static char[] dir = {'D','S','L','R'};
	static String[] visited ;	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		
		for(int t=0 ; t<testcase ; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			visited = new String[10001];
			bfs();
			System.out.println(visited[b]);
		}
		
		
	}
	
	public static void bfs() {
		int number = a;
		Queue<Integer> q = new LinkedList<>();
		q.add(number);
		visited[number] = "";
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int i=0 ; i<4 ; i++) {
				switch(i) {
				case 0 :
					number = 2*cur;
					if(number > 9999)
						number = number % 10000 ;
//					System.out.println("����: "+cur+" D "+number);
					break;
				case 1 :
					number = cur - 1;
					if(number == -1)
						number = 9999;
//					System.out.println("����: "+cur+" S "+number);
					break;
				case 2 :
					int d1 = cur/1000;
					int d2 = cur/100%10;
					int d3 = cur/10%10;
					int d4 = cur%10;
					
					number = d2*1000 + d3*100 + d4*10 + d1;
					
//					System.out.println("����: "+cur+" L "+number);
					break;
				case 3 :
					d1 = cur/1000;
					d2 = cur/100%10;
					d3 = cur/10%10;
					d4 = cur%10;
					
					number = d4*1000 + d1*100 + d2*10 + d3;
					break;
//					System.out.println("����: "+cur+" R "+number);
				}
				
				if(number == b) {
					visited[number] = visited[cur] + dir[i];
					return;
				} else if(visited[number] == null) {
					visited[number] = visited[cur] + dir[i];
//					System.out.println("����: "+cur +" ����: "+ visited[number] +" number: "+ number);
					q.add(number);
				}
				
			}
		}
	}
	
}
