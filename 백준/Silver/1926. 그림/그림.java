

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int [][] arr;
	static boolean [][] visited;
	static int [] dx = {0,1,0,-1};
	static int [] dy = {1,0,-1,0};
	static int MaxArea = 0 ;
	static int totalAreaCnt=0;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		arr = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0 ; i < N ;i++) {
			for(int j= 0; j < M ; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0 ; i < N ;i++) {
			for(int j= 0; j < M ; j++) {
				if(!visited[i][j] && arr[i][j] == 1) {
					BFS( i ,j);
					totalAreaCnt++;
				}
			}
		}
		
		System.out.println(totalAreaCnt);
		System.out.println(MaxArea);
	
	}
	public static void BFS(int x, int y) {
		int count = 1;
		
		Queue<PointSpot> q = new LinkedList<>();
		q.add(new PointSpot(x,y));
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			PointSpot p = q.poll();
			for(int i = 0 ; i < 4 ; i++) {
				int nextX = p.x +dx[i];
				int nextY = p.y +dy[i];
				
				if(nextX < 0 || nextY <0 || nextX>=arr.length || nextY >=arr[0].length)
					continue;
				if(visited[nextX][nextY] || arr[nextX][nextY] == 0)
					continue;
				
				visited[nextX][nextY] = true;
				q.add(new PointSpot(nextX, nextY));
				count++;
			}
		}
		
		MaxArea= Math.max(MaxArea, count);
		
	}

}
class PointSpot{
	int x;
	int y;
	
	public PointSpot(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
