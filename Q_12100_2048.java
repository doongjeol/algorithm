package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_12100_2048 {
	static int n,max;
	static int[][] matrix;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		matrix = new int[n][n];
		
		for(int i=0 ; i<n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0 ; j<n ; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(find(0));
		
		
	}
	
	public static void out(int[][] matrix) {
		for(int i=0 ; i<n ; i++) {
			for(int j=0 ; j<n ; j++) 
				System.out.print(matrix[i][j]+" ");
			System.out.println();
		}
	}
	
	public static int[][] up(int[][] matrix) {
		//0 밀기
		for (int j=0; j<n; j++) {
			for(int i=0 ; i+1<n ; i++) {
				if (matrix[i][j] == 0 && matrix[i+1][j] != 0) {
					matrix[i][j] = matrix[i+1][j];
					matrix[i+1][j] = 0;
					i = -1;
				}
			}
		}
		
		for(int i=0 ; i+1<n ; i++) {
			for(int j=0 ; j<n ; j++) {
				if(matrix[i][j] == matrix[i+1][j]) {
					matrix[i][j] = 2*matrix[i][j];
					matrix[i+1][j] = 0;
				} else if(matrix[0][j] == 0) {
					while(matrix[0][j] != 0) {
						matrix[i][j] = matrix[i+1][j];
						matrix[i+1][j] = 0;
					}
				}
			}
		}
		
		//0 밀기
		for (int j=0; j<n; j++) {
			for(int i=0 ; i+1<n ; i++) {
				if (matrix[i][j] == 0 && matrix[i+1][j] != 0) {
					matrix[i][j] = matrix[i+1][j];
					matrix[i+1][j] = 0;
					i = -1;
				}
			}
		}
		
		return matrix;
	}
	
	public static int[][] down(int[][] matrix) {
		//0 밀기
		for (int j=0; j<n; j++) {
			for(int i=n-1 ; i>0 ; i--) {
	            if (matrix[i][j] == 0 && matrix[i-1][j] != 0) {
	            	matrix[i][j] = matrix[i-1][j];
	            	matrix[i-1][j] = 0;
	                i = n;
	            }
	        }
        }
				
		for(int i=n-1 ; i>0 ; i--) {
			for(int j=0 ; j<n ; j++) {
				if(matrix[i][j] == matrix[i-1][j]) {
					matrix[i][j] = 2*matrix[i][j];
					matrix[i-1][j] = 0;
				} else if(matrix[n-1][j] == 0) {
					while(matrix[n-1][j] != 0) {
						matrix[i][j] = matrix[i-1][j];
						matrix[i-1][j] = 0;
					}
				}
			}
		}
		
		//0 밀기
		for (int j=0; j<n; j++) {
			for(int i=n-1 ; i>0 ; i--) {
	            if (matrix[i][j] == 0 && matrix[i-1][j] != 0) {
	            	matrix[i][j] = matrix[i-1][j];
	            	matrix[i-1][j] = 0;
	                i = n;
	            }
	        }
        }
		        
		
		return matrix;
	}
	
	public static int[][] left(int[][] matrix) {
		//0 밀기
		for(int i=0 ; i<n ; i++) {
			for (int j=0; j+1<n; j++) {
				if (matrix[i][j] == 0 && matrix[i][j+1] != 0) {
					matrix[i][j] = matrix[i][j+1];
					matrix[i][j+1] = 0;
					j = -1;
				}
			}
		}
		
		for(int i=0 ; i<n ; i++) {
			for(int j=0 ; j+1<n ; j++) {
				if(matrix[i][j] == matrix[i][j+1]) {
					matrix[i][j] = 2*matrix[i][j];
					matrix[i][j+1] = 0;
				} 
			}
		}
		
		//0 밀기
		for(int i=0 ; i<n ; i++) {
	        for (int j=0; j+1<n; j++) {
	            if (matrix[i][j] == 0 && matrix[i][j+1] != 0) {
	            	matrix[i][j] = matrix[i][j+1];
	            	matrix[i][j+1] = 0;
	                j = -1;
	            }
	        }
        }
		
		return matrix;
	}
	
	public static int[][] right(int[][] matrix) {
		//0 밀기
		for(int i=0 ; i<n ; i++) {
			for (int j=n-1; j>0; j--) {
				if (matrix[i][j] == 0 && matrix[i][j-1] != 0) {
					matrix[i][j] = matrix[i][j-1];
					matrix[i][j-1] = 0;
					j = n;
				}
			}
		}
		
		// 같은 숫자 합치기
		for(int i=0 ; i<n ; i++) {
			for(int j=n-1 ; j>0 ; j--) {
				if(matrix[i][j] == matrix[i][j-1]) {
					matrix[i][j] = 2*matrix[i][j];
					matrix[i][j-1] = 0;
				} 
			}
		}
		
		//0 밀기
		for(int i=0 ; i<n ; i++) {
	        for (int j=n-1; j>0; j--) {
	            if (matrix[i][j] == 0 && matrix[i][j-1] != 0) {
	            	matrix[i][j] = matrix[i][j-1];
	            	matrix[i][j-1] = 0;
	                j = n;
	            }
	        }
        }
        
		return matrix;
	}
	
	public static int find(int depth) {
		int max = 0;
		if (depth == 5) {
	        // 최대값 찾기
	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < n; j++)
	                max = Math.max(max, matrix[i][j]);
	        }
	        return max;
        }
		
		int[][] temp = new int[n][n];
	        
        // 현재상태 저장
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) 
                temp[i][j] = matrix[i][j];
        }
	        
        // d : 방향
        // 0:왼쪽, 1:오른쪽, 2:위쪽, 3:아래쪽
        for (int d = 0; d < 4; d++) {
        	switch(d){
        	case 0:
        		left(matrix);
        		break;
        	case 1:
        		right(matrix);
        		break;
        	case 2:
        		up(matrix);
        		break;
        	case 3:
        		down(matrix);
        		break;
        	}
        			
        	max = Math.max(max, find(depth+1));
        	
        	// 이전상태 세팅
        	for (int i = 0; i < n; i++) {
        		for (int j = 0; j < n; j++) {
        			matrix[i][j] = temp[i][j];
        		}
        	}
        }
        
        return max;
	    
	}
	
}
