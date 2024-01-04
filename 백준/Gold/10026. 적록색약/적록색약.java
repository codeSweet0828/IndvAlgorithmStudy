

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static char[][] arr;
    static boolean [][] visited;
    static boolean [][] visited2;
    static int [] dx = {0,1,0,-1};
    static int [] dy = {1,0,-1,0};
    static int normalArea = 0 ;
    static int abNormalArea = 0 ;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(bf.readLine());
        arr = new char[num][num];
        visited = new boolean[num][num];
        visited2 = new boolean[num][num];
        
        for (int i = 0; i < num; i++) {
            String row = bf.readLine();
            for (int j = 0; j < row.length(); j++) {
                arr[i][j] = row.charAt(j);
            }
        }

        for (int i = 0; i < num; i++) {
        	 for (int j = 0; j < num; j++) {
        		 if(!visited[i][j]) {
        			 normalArea++;
        			 BFS(i,j, false, arr[i][j]);
        		 }
        		 if(!visited2[i][j]) {
        			 abNormalArea++;
        			 BFS(i,j, true, arr[i][j]);
        		 }
        	 }
        }
        
        System.out.print(normalArea+" "+abNormalArea);
    }

	public static void BFS(int x, int y, boolean abNormal, char value) {
		Queue<Point> q = new LinkedList();
		q.add(new Point(x,y));
		visited[x][y] = true;
	
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for(int i = 0; i < 4 ; i++) {
				int nextX = p.x + dx[i];
				int nextY = p.y + dy[i];
				
				if(nextX < 0 || nextY <0 || nextX>=arr.length || nextY >=arr[0].length)
					continue;
			
				if(!abNormal) {
					if(!visited[nextX][nextY] &&value== arr[nextX][nextY]) {
						visited[nextX][nextY] = true;
						q.add(new Point(nextX, nextY));
					}	
				}else {
					if (!visited2[nextX][nextY] ) {
					    if ((value == 'G' || value == 'R') && (arr[nextX][nextY] == 'G' || arr[nextX][nextY] == 'R')) {
					        visited2[nextX][nextY] = true;
					        q.add(new Point(nextX, nextY));
					    } else if (value == 'B' && arr[nextX][nextY] == 'B') {
					        visited2[nextX][nextY] = true;
					        q.add(new Point(nextX, nextY));
					    }
					}
				}
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