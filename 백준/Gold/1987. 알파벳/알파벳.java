
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{

    static String[][] arr;
    static boolean[] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int maxCount = 1; // 시작점은 무조건 포함

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int R = Integer.parseInt(input[0]);
        int C = Integer.parseInt(input[1]);

        arr = new String[R][C];
        visited = new boolean[26]; // 알파벳 개수만큼 방문 여부를 체크

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = line.substring(j, j + 1);
            }
        }

        visited[arr[0][0].charAt(0) - 'A'] = true; // 시작 지점 방문 표시
        DFS(0, 0, 1); // 시작점은 무조건 포함

        System.out.println(maxCount);
        br.close();
    }

    public static void DFS(int x, int y, int count) {
        maxCount = Math.max(maxCount, count);

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (newX >= 0 && newX < arr.length && newY >= 0 && newY < arr[0].length
                    && !visited[arr[newX][newY].charAt(0) - 'A']) {
                visited[arr[newX][newY].charAt(0) - 'A'] = true;
                DFS(newX, newY, count + 1);
                visited[arr[newX][newY].charAt(0) - 'A'] = false; // 백트래킹
            }
        }
    }
}
