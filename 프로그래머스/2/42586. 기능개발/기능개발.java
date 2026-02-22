import java.util.*;
class Solution {
     int[] newArr;
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        int prevDay = (int)Math.ceil((100.0- progresses[0])/speeds[0]);
        int count = 1;
              
        for(int i = 1 ; i < progresses.length ;i ++){
            int nowDay = (int)Math.ceil((100.0- progresses[i])/speeds[i]);
            
            if(nowDay <= prevDay){
                count++;
            }
            else{
                
                //배포갯수 더하기
                list.add(count);
                count = 1;
                
                //기준 초기화
                prevDay = nowDay;
            }
            
        }
        
        //마지막 배포갯수 더하기
        list.add(count);
  
        answer = new int[list.size()];
        
        for(int i= 0; i< list.size() ;i++){
            answer[i] = list.get(i);
        }
        
  
        return answer;
        
    }
}