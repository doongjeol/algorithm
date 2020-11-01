package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q_16235_TreeInvestTech {
	static int n,m,k;
	static int[][] nut;
	static List<Integer>[][] tree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k= Integer.parseInt(st.nextToken());
		tree = new ArrayList[n][n];
		
		for(int i=0 ; i<n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0 ; j<n ; j++) {
				nut[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0 ; i<n ; i++) {
			for(int j=0 ; j<n ; j++) {
				tree[i][j].add(0);
			}
		}
		
		for(int i=0 ; i<m ; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int age = Integer.parseInt(st.nextToken());
			
			tree[r][c].add(age);
		}
	}
	
	public static void spring() {
		for(int i=0 ; i<n ; i++) {
			for(int j=0 ; j<n ; j++) {
				if(tree[i][j].get(0) != 0 ) {
					nut[i][j] --;
					tree[i][j].set(0, tree[i][j].get(0)+1);
				}
			}
		}
	}
}
