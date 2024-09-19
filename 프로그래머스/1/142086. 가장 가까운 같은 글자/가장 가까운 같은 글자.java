import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        String[] sArr = s.split("");
        Map <String, Integer> map = new HashMap<>();
       
        for(int i = 0 ; i < s.length(); i++){
            //key가 있을 떼
            if(map.containsKey(sArr[i])){
                answer[i] = i-map.get(sArr[i]);
                map.put(sArr[i], i);
           }
            //key 가 없을 때
            else{
                answer[i] = -1;
                map.put(sArr[i], i);
           }
        }
    
        return answer;
    }
}