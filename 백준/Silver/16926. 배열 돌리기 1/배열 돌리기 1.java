

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][] arr;
    static int[] dx = {0, 1, 0, -1}; // 기존 좌표 기준 상, 우, 하, 좌
    static int[] dy = {1, 0, -1, 0};
    static int minNum;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] input = bf.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int R = Integer.parseInt(input[2]);
        arr = new int[N][M];

        for (int i = 0; i < arr.length; i++) {
            String[] row = bf.readLine().split(" ");
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = Integer.parseInt(row[j]);
            }
        }
        minNum = Math.min(N, M);

        for (int i = 1; i <= R; i++) {
            rotate();
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

 static void rotate() {
    	
    	for(int t=0; t<minNum/2; t++) { // 회전 시킬 그룹의 갯수 구하기
    		int x = t;
    		int y = t;
    		
    		int temp = arr[x][y]; // 마지막에 넣을 값 미리 빼놓음
    		
    		int idx = 0; // 우, 하, 좌, 상 방향으로 이동하며 반시계 방향으로 값 넣을 인덱스
    		while(idx < 4) { // 왼쪽으로 넣는, 위로 넣는, 오른쪽으로 넣는, 아래로 넣는 연산을 차례로 수행
    			int nx = x + dx[idx];
    			int ny = y + dy[idx];
    			
    			// 범위 안이라면
    			if(nx < arr.length-t && ny < arr[0].length-t && nx >= t && ny >= t) {
    				arr[x][y] = arr[nx][ny];
    				x = nx;
    				y = ny;
    			} 
    			// 범위를 벗어났다면 다음 방향으로 어감
    			else {
    				idx++;
    			}
    			
    		}
    		
    		arr[t+1][t] = temp; // 빼 놓은 값 넣어 줌
    	}
    }
}
