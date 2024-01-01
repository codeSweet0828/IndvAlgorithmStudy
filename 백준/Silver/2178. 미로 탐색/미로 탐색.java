

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] dimensions = br.readLine().split(" ");
        int N = Integer.parseInt(dimensions[0]);
        int M = Integer.parseInt(dimensions[1]);

        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = Character.getNumericValue(row.charAt(j));
            }
        }
        br.close();

        int data = BFS(0, 0);
        System.out.println(data);
    }

    static int BFS(int x, int y) {
        Queue<Point> q = new LinkedList<Point>();
        q.add(new Point(x, y, 1));

        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = p.x + dx[i];
                int nextY = p.y + dy[i];
                if (nextX == arr.length - 1 && nextY == arr[0].length - 1)
                    return p.z + 1; 

                if (nextX < 0 || nextY < 0 || nextX >= arr.length || nextY >= arr[0].length)
                    continue;

                if (arr[nextX][nextY] == 0 || visited[nextX][nextY])
                    continue;

                q.add(new Point(nextX, nextY, p.z + 1));
                visited[nextX][nextY] = true;
            }
        }
        return -1; 
    }
}

class Point {
    int x;
    int y;
    int z;

    public Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
