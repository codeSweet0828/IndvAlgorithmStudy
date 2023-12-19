

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int []dx = {-1,0,1,1,1,0,-1,-1};
	static int []dy = {1,1,1,0,-1,-1,-1,0};
	static  int[][] map;
	static  boolean[][] visited;
	static int count = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        while (true) {
        	int w = sc.nextInt(); // 지도의 너비
            int h = sc.nextInt(); // 지도의 높이

            if (w == 0 && h == 0) break; // 입력의 마지막 줄인지 확인

            map = new int[h][w]; // 지도 정보를 담을 배열
            visited = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            count = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                	if(!visited[i][j] && map[i][j]==1) {
                		DFS(i,j);
                		count++;
                	}
                }
             }
            System.out.println(count);
          
        }
        
	}
	public static void DFS(int x, int y) {
		Queue<Spot> q =new LinkedList<>();
		q.add(new Spot(x,y));
	    visited[x][y] = true;

		while(!q.isEmpty()) {
			Spot s = q.poll();
			for(int i = 0 ; i < 8 ; i ++) {
				
				int nextX = s.x + dx[i];
				int nextY = s.y + dy[i];
				
				if(nextX <0 || nextY <0 || nextX>=map.length|| nextY>=map[0].length)
					continue;
				if(visited[nextX][nextY] || map[nextX][nextY] == 0)
					continue;
				
				q.add(new Spot(nextX,nextY));
				visited[nextX][nextY]= true;
			}
		}
	}
}
class Spot{
	int x;
	int y;
	
	public Spot(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
