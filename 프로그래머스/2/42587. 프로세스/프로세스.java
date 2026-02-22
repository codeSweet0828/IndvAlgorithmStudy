import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        //우선순위 큐 선언(내림 차순)
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int arr : priorities){
            queue.offer(arr);
        }
        
        while(!queue.isEmpty()){
            for(int i = 0 ; i < priorities.length ; i++){
                
                if(queue.peek() == priorities[i]){
                    queue.poll();
                    answer++;
                    
                    if(location == i)
                        return answer;
                }
            }
        }
        
        
        return answer;
    }
}