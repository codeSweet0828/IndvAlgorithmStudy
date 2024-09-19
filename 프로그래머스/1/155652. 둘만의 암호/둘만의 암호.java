import java.util.*;

class Solution {
    Set<Character> skipSet;
    
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        skipSet = new HashSet<>();
        
        //toCharArray로 skip문자열 중복확인
        for (char ch : skip.toCharArray()) {
            skipSet.add(ch);
        }
        
        //index에 따른 char 체크
        for (char ch : s.toCharArray()) {
            char newChar = getNextChar(ch, index);
            //문자열 append
            answer.append(newChar);
        }
        
        //char을 toString()형태로 반환
        return answer.toString();
    }
    
    private char getNextChar(char ch, int index) {
        //알파벳 소문자
        int alphabetSize = 26;
        char result = ch;
        
        for (int i = 0; i < index; i++) {
            result++;
            
            if (result > 'z') {
                result = 'a';
            }
            
            //result에 따라 setCheck한 후, 더해지는 문자열 반환
            while (skipSet.contains(result)) {
                result++;
                
                if (result > 'z') {
                    result = 'a';
                }
            }
        }
        
        return result;
    }
}
