class Solution {
    static boolean [] visited;
    static int count= 0;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[computers.length];
        
        //자기 자신은 방문처리와 0처리
        for(int i=0; i < computers.length; i++){
            computers[i][i] = 0;
        }
        
        for(int i = 0 ; i < computers.length; i++){
            if(!visited[i]){
                findNetwork(computers, i);
                count++;
            }
        }
        return count;
    }
    public void findNetwork(int[][] computers, int startIndex){
          visited[startIndex] = true;
        
        for(int j = 0; j<computers[0].length; j++){
            if(!visited[j] && computers[startIndex][j]== 1){
                findNetwork(computers,j);
            }
        }
        
    }
}