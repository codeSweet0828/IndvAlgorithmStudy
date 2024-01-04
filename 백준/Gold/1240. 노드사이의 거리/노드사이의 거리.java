

import java.util.Scanner;

public class Main {
	static int [][] arr;
	static boolean []visited;
	static int INF = Integer.MAX_VALUE/4;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		arr = new int[N+1][N+1];
		visited = new boolean[N+1];
		int M = sc.nextInt();
		for(int i= 0; i < arr.length ; i++) {
			for(int j = 0; j < arr.length ; j++) {
				arr[i][j] = INF;
			}
		}
		for(int i = 1 ; i < N ; i++) {
			int node1 = sc.nextInt();
			int node2 = sc.nextInt();
			int distance = sc.nextInt();
			arr[node1][node2] = distance;
			arr[node2][node1] = distance;
		}
		floyd();
		
		for(int i = 0 ; i < M ;i++) {
			int fstNode = sc.nextInt();
			int secNode = sc.nextInt();
			System.out.println(arr[fstNode][secNode]);
		}
		
	}
	public static void floyd() {
		for(int k = 0 ; k < arr.length ; k++) {
			for(int i =0 ; i < arr.length; i++) {
				for(int j =0; j < arr.length ; j++) {
					if(arr[i][k] >0 && arr[k][j] > 0) {
						arr[i][j] = Math.min(arr[i][j], arr[i][k]+arr[k][j]);
					}
				}
			}
		}
	}
}

