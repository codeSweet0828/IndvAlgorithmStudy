class Solution {
    public int solution(String s) {

        // 최소 길이 (초기값은 압축 안 한 길이)
        int answer = s.length();

        // step = 몇 글자씩 자를지
        for(int step = 1; step <= s.length() / 2; step++){

            StringBuilder sb = new StringBuilder();

            // 첫 덩어리
            String prev = s.substring(0, step);

            int count = 1;

            // step씩 이동하면서 비교
            for(int i = step; i < s.length(); i += step){

                String curr;

                // step만큼 자를 수 있으면
                if(i + step <= s.length()){
                    curr = s.substring(i, i + step);
                }
                // 남은 부분만 자르기
                else{
                    curr = s.substring(i);
                }

                // 같으면 count 증가
                if(prev.equals(curr)){
                    count++;
                }
                // 다르면 저장
                else{
                    if(count > 1){
                        sb.append(count);
                    }

                    sb.append(prev);

                    prev = curr;
                    count = 1;
                }
            }

            // 마지막 처리 (필수)
            if(count > 1){
                sb.append(count);
            }

            sb.append(prev);

            // 최소 길이 갱신
            answer = Math.min(answer, sb.length());
        }

        return answer;
    }
}