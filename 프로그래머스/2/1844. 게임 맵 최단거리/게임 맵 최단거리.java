import java.util.*;
class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static boolean [][] visited;
    public int solution(int[][] maps) {
        visited = new boolean[maps.length][maps[0].length];
        int answer = findRoute(0,0, maps);
    
        return answer;
    }
    public int findRoute(int x, int y, int [][] maps){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x,y,1));
        
        while(!q.isEmpty()){
            Point p = q.poll();
            for(int i = 0; i <4 ;i++){
                int nextX = p.x + dx[i];
                int nextY = p.y + dy[i];
                 int currentZ = p.z;
                if(nextX < 0 || nextY < 0 || nextX>= maps.length || nextY >= maps[0].length)
                    continue;
                 if (nextX == maps.length - 1 && nextY == maps[0].length - 1) {
                    return currentZ + 1;
                }

                if (maps[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    q.add(new Point(nextX, nextY, currentZ + 1)); 
                }
            }
            
        }
        return -1;
    }
}
class Point{
    int x;
    int y;
    int z;
    
    public Point(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z= z;
    }
}