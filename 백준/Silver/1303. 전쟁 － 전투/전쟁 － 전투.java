

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static char[][] arr;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int sumW = 0;
    static int sumB = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = bf.readLine().split(" ");

        int M = Integer.parseInt(tmp[0]);
        int N = Integer.parseInt(tmp[1]);

        arr = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < arr.length; i++) {
            String row = bf.readLine();
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = row.charAt(j);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (!visited[i][j]) {
                    BFS(i, j, arr[i][j]);
                }
            }
        }
        System.out.println(sumW + " " + sumB);
    }

    private static void BFS(int x, int y, char value) {
        int count = 0;
        Queue<Spot> q = new LinkedList<>();
        q.add(new Spot(x, y));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Spot p = q.poll();
            count++;

            for (int i = 0; i < 4; i++) {
                int nextX = p.x + dx[i];
                int nextY = p.y + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= arr.length || nextY >= arr[0].length)
                    continue;

                if (!visited[nextX][nextY] && arr[nextX][nextY] == value) {
                    visited[nextX][nextY] = true;
                    q.add(new Spot(nextX, nextY));
                }
            }
        }

        if (value == 'W')
            sumW += count * count;
        else
            sumB += count * count;
    }
}

class Spot {
    int x;
    int y;

    public Spot(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
