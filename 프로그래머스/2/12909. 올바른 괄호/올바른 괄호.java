import java.util.Stack;
class Solution {
    boolean solution(String s) {

        Stack <Character> stack = new Stack<>();
        
        for(char ch: s.toCharArray()){
            
            if(ch == '('){
                stack.push('(');
            }else{
                if(stack.size() == 0)
                    return false;
                else{
                    stack.pop();
                }
            }
        }
        
        if(stack.size() == 0){
            return true;
        }
        else
            return false;
    }
}