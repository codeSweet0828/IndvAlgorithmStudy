

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int [][][] arr;
	static boolean [][][] visited;
	static Queue<Point3> q = new LinkedList<>();
	
    static int[][] directions = {{-1, 0, 0}, {1, 0, 0}, {0, -1, 0}, {0, 1, 0}, {0, 0, -1}, {0, 0, 1}};
	static int M, N, H;
    static int days = 0;
    static int cntZero = 0;
    static int cntMinusOne = 0;
    public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		M = sc.nextInt();
		N = sc.nextInt();
		H = sc.nextInt();

		arr = new int[N][M][H];
		visited = new boolean[N][M][H];
		
		for(int k = 0; k < H ; k++) {
			for(int i = 0; i < N ; i++) {
				for(int j = 0; j < M ; j++) {
					arr[i][j][k] = sc.nextInt();
					if(arr[i][j][k] == 1) {
						q.add( new Point3(i,j,k,0)); //익은 토마토 미리 넣기
						visited[i][j][k] = true; //익은 토마토 방문 표시
					}
				}
			}
		}
		
	
		BFS();
		
		if(checkTomato()) {
			System.out.println(days);
		}else {
			System.out.println(-1);
		}
		
    }
    public static void BFS() {
    	while(!q.isEmpty()) {
    		Point3 p = q.poll();
    
    		for(int k = 0 ; k < directions.length ;k++) {
    		    int nextX = p.x + directions[k][0];
    		    int nextY = p.y + directions[k][1];
    		    int nextZ = p.z + directions[k][2];
    		    
    		    int nextD = p.d;
    		    
    		    if(nextX < 0 || nextY <0 || nextZ <0 || nextX>=N || nextY >=M || nextZ>=H)
    		    	continue;
    		    if(!visited[nextX][nextY][nextZ] && arr[nextX][nextY][nextZ]== 0) {
    		    	visited[nextX][nextY][nextZ] = true;
    		    	q.add(new Point3(nextX,nextY,nextZ, nextD+1));
    		    	arr[nextX][nextY][nextZ] = 1;
    		    	days = nextD+1;
    		    }
    		}
    	}	
    }
    public static boolean checkTomato(){
    	for(int k = 0 ; k < H ; k++) {
    		for(int i = 0 ; i < N ; i++) {
    			for(int j = 0 ; j < M ; j++) {
    				if(arr[i][j][k] == 0) {
    					 return false; // 익지 않은 토마토가 있으면 false 반환
    				}
    			}
    		}
    	}
    	return true;
    }
}

class Point3{
	int x;
	int y;
	int z;
	int d;
	
	public Point3(int x, int y, int z, int d) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.d = d;
	}
}
