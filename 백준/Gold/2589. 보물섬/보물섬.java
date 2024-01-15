

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static char [][] arr;
	static boolean [][] visited;
	static int [] dx = {0, 1, 0, -1};
	static int [] dy = {1, 0, -1, 0};
	static int maxLength = 0 ;
	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     StringTokenizer st;
	     
	     String [] str = br.readLine().split(" ");
	     
	     int N = Integer.parseInt(str[0]);
	     int M = Integer.parseInt(str[1]);
	     
	     arr = new char[N][M];
	     
	     for(int i = 0 ; i < N ; i++) {
 	    	 String row = br.readLine();
	    	 for(int j = 0 ; j < row.length() ;j++) {
	    		 arr[i][j] = row.charAt(j);
	    	 }
	     }
	     
	     
	     for(int i = 0 ; i < arr.length; i++) {
	    	 for(int j = 0 ; j < arr[0].length;j++) {
	    		 if(arr[i][j] == 'L') {
	    			 //(a,b) -> (c,d)의 최단 경로를 구해야 하기 때문에 매번 초기화
	    			 visited = new boolean[N][M];
	    			 BFS(i,j);
	    		 }
	    	 }
	     }
	     
	     System.out.print(maxLength);
	    
	}
	public static void BFS(int x, int y) {
		Queue<Point2> q = new LinkedList<>();
		q.add(new Point2(x,y,0));
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			Point2 p = q.poll();
			
			for(int i = 0 ; i < 4 ; i++) {
				int nextX = p.x + dx[i];
				int nextY = p.y + dy[i];
				
				if(nextX <0 || nextY <0 || nextX >=arr.length || nextY >=arr[0].length)
					continue;
				if(visited[nextX][nextY]|| arr[nextX][nextY] =='W')
					continue;
				
				maxLength = Math.max(maxLength, p.z+1);
				visited[nextX][nextY] = true;
				q.add(new Point2(nextX, nextY, p.z + 1));
				
			}
		}
		
	}
}
class Point2{
	int x;
	int y;
	int z;
	
	public Point2(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}
