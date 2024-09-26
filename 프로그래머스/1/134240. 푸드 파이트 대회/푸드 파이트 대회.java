class Solution {
    public String solution(int[] food) {
        String answer ="";
        
        //0번 배열 제외. 대칭해줘야 하므로, 앞에서부터 answer에 i를 food[i]/2 번만큼만 더해줌
        for(int i = 1 ; i < food.length; i++){
            for(int j = 1 ; j < food[i]/2 + 1;j++){
                answer+=i;
            }
        }
        
        //물통
        answer+=0;
        
        //대칭해줘야 하므로, 뒤에서부터 answer i를 food[i] food[i]/2 번만큼만 더해줌
        for(int i = food.length -1 ; i > 0; i--){
            for(int j = food[i]/2 ; j > 0;j--){
                answer+=i;
            }
        }
        
        return answer;
    }
}