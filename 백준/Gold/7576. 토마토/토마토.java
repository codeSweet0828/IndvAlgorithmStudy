

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[][] arr;
    static boolean[][] visited;
    static Queue<Point2> q = new LinkedList<>();
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 세로 칸의 수
        int M = sc.nextInt(); // 가로 칸의 수
        arr = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] == 1) {
                    q.add(new Point2(i, j, 0)); // 익은 토마토의 좌표와 일수(0)를 큐에 추가
                    visited[i][j] = true; // 방문 표시
                }
            }
        }

        int result = BFS(M, N);

        if (checkAllTomatoes(M, N)) {
            System.out.println(result);
        } else {
            System.out.println(-1);
        }
    }

    // BFS를 통해 토마토가 익는 최소 일수를 구하는 함수
    public static int BFS(int M, int N) {
        int days = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Point2 p = q.poll();

                for (int j = 0; j < 4; j++) {
                    int nextX = p.x + dx[j];
                    int nextY = p.y + dy[j];

                    if (nextX >= 0 && nextX < M && nextY >= 0 && nextY < N
                            && !visited[nextX][nextY] && arr[nextX][nextY] == 0) {
                        visited[nextX][nextY] = true;
                        arr[nextX][nextY] = 1;
                        q.add(new Point2(nextX, nextY, p.z + 1));
                        days = p.z + 1; // 일수 갱신
                    }
                }
            }
        }

        return days;
    }

    // 모든 토마토가 익었는지 확인하는 함수
    public static boolean checkAllTomatoes(int M, int N) {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 0) {
                    return false; // 익지 않은 토마토가 있으면 false 반환
                }
            }
        }
        return true; // 모든 토마토가 익었으면 true 반환
    }
}

class Point2 {
    int x;
    int y;
    int z;

    public Point2(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
