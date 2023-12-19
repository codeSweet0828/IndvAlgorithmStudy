import java.util.Scanner;

public class Main {
    static int [][] arr;
    static boolean []visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main ma = new Main();

        int N = sc.nextInt(); // 전체 사람의 수
        int Person1 = sc.nextInt(); // 사람 1
        int Person2 = sc.nextInt(); // 사람 2

        int M = sc.nextInt(); // 부모-자식 관계의 수
        arr = new int[N+1][N+1];
        visited = new boolean[N+1];

        for(int i = 0 ; i < M ; i++) {
            // 부모-자식 관계 입력
            int r1 = sc.nextInt();
            int r2 = sc.nextInt();
            arr[r1][r2] = 1;
            arr[r2][r1] = 1;
        }

        int data = ma.DFS(arr, Person1, Person2, 0);
        System.out.println(data);

    }

    public int DFS(int [][]arr, int startNum, int targetNum, int cnt) {
        if (startNum == targetNum) {
            return cnt;
        }

        visited[startNum] = true;

        for (int i = 1; i < arr.length; i++) {
            if (!visited[i] && arr[startNum][i] == 1) {
                int result = DFS(arr, i, targetNum, cnt + 1);
                if (result != -1) {
                    return result; // 결과를 찾았으면 반환하고 그렇지 않으면 계속 탐색
                }
            }
        }
        return -1; // startNum에서 targetNum까지 도달할 수 없는 경우 -1 반환
    }
}
