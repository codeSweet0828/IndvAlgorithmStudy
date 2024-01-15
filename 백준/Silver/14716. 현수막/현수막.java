

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int [][]arr;
	static boolean [][] visited;
	static int [] dx = {0,1,0,-1,-1,1,1,-1};
	static int [] dy = {1,0,-1,0,1,1,-1,-1};
	static int count = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int M = Integer.parseInt(input[0]);
		int N = Integer.parseInt(input[1]);
		
		arr = new int[M][N];
		visited= new boolean[M][N];

		for(int i = 0 ; i < arr.length ;i ++) {
			String[] row = br.readLine().split(" ");
			for(int j =0; j< row.length ; j++) {
				arr[i][j] = Integer.parseInt(row[j]);
			}
		}
		
		for(int i = 0 ; i < arr.length ;i ++) {
			for(int j =0; j< arr[0].length ; j++) {
				if(!visited[i][j] && arr[i][j] == 1) {
					BFS(i,j);
					count++;
				}
			}
		}
		System.out.println(count);
	}
	public static void BFS(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x,y));
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for(int i = 0 ; i < 8 ; i++) {
				int nextX = p.x + dx[i];
				int nextY = p.y + dy[i];
				
				if(nextX < 0 || nextY < 0 || nextX>=arr.length || nextY >=arr[0].length) 
					continue;
				if(visited[nextX][nextY] || arr[nextX][nextY] == 0)
					continue;
				
				visited[nextX][nextY] = true;
				q.add(new Point(nextX, nextY));
				
			}
		}
	}
	
}
 class Point{
	int x;
	int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
