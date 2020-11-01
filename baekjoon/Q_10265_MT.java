package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q_10265_MT {
	static int num, possible, result;
	static List<Integer> list;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		num = Integer.parseInt(st.nextToken());
		possible = Integer.parseInt(st.nextToken());
		list = new ArrayList();
		for(int i=0 ; i<num+1 ; i++)
			list.add(0);
		visited = new boolean[num+1];
		st = new StringTokenizer(br.readLine());
		for(int r=1 ; r<num+1 ; r++){
			int c = Integer.parseInt(st.nextToken());
			list.set(r, c);
		}
		
		result = 1;
		int temp = 0;
		for(int i=1 ; i<num+1 ; i++){
			temp = result;
			dfs(i, result);
			if(result > possible) {
				result = temp;
			}
			System.out.println(temp+" "+result);
		}
		
//		System.out.println(result);
		
		
	}
	
	public static void dfs(int index, int total){
		visited[index] = true;
		int to = list.get(index);
		
		result += total;
		if(!visited[to]) {
//			System.out.println(index+" �� "+to +" ��: "+total+" ��: ");
			dfs(to, total+1);
		}
		
	}
}

	
