import java.util.*;
class Solution {
    public int solution(String t, String p) {
        int answer = 0;
 
        //t의 길이가 p의 길이보다 클 경우 validation check
        if(t.length() >= p.length()){
            for(int i = 0 ; i < t.length() - p.length()+1; i++){
                String compStr = t.substring(i,i+p.length());

                if(Long.parseLong(p) >=Long.parseLong(compStr)){
                    answer++;
                }
            }
        }
       
        return answer;
    }
}