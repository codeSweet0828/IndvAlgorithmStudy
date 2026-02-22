import java.util.*;
class Solution {
  
    public int[] solution(int[] progresses, int[] speeds) {
       
        List<Integer> list = new ArrayList<>();
        int prevDay = (int)Math.ceil((100.0-progresses[0])/speeds[0]);
        int count =1;
        
        for(int i = 1 ; i < progresses.length; i++){
            int nowdays = (int)Math.ceil((100.0-progresses[i])/speeds[i]);
            
            if(prevDay >= nowdays){
                count++;
            }else{
                list.add(count);
                count =1;
                prevDay = nowdays;
            }
        }
        list.add(count);
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size() ; i++){
           answer[i] = list.get(i);
        }
  
        return answer;
        
    }
}