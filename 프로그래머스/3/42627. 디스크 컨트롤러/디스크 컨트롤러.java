import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        //우선순위 큐 - 낮은수부터
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
       /* Arrays.sort(jobs, new Comparator<int []>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0])
                    return o1[1] - o2[1];
                else
                    return (o1[1] -o1[0])-(o2[1]- o2[0]);
                }	
        });*/
        for(int i = 0 ; i < jobs.length; i ++){
           pq.add(jobs[i][1] - jobs[i][0]);
           answer+=jobs[i][1] - jobs[i][0];
        }
      
        
        return answer;
    }
}