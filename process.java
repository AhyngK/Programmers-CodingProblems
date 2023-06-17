import java.util.*;

public class process {
    public static void main(String[] args) {
        int [] priorities = {1,1,9,1,1,1};
        int location = 0;

        Solution1 s = new Solution1();
        System.out.println(s.solution(priorities,location));

    }
}

class Solution1{
    public int solution(int[] priorities, int location){
        Queue<int[]> priortiesIndex = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            int[] temp = {priorities[i],i};
            priortiesIndex.add(temp);
        }

        Stack<int[]> Queue = new Stack<>();
        while(!priortiesIndex.isEmpty()){
            // 큐에서 하나 꺼내기
            Queue.add(priortiesIndex.poll());
            // 기존 큐를 복사할 큐, 더 큰수가 있는지 체크하는 변수
            Queue<int[]> priortiesIndex1 = new LinkedList<>();
            boolean check = false;
            // 하나씩 빼서 다른 큐에 넣으면서 비교, 결과 check에 저장
            while(!priortiesIndex.isEmpty()) {
                if(Queue.peek()[0]<priortiesIndex.peek()[0]){
                    check =true;
                }
                priortiesIndex1.add(priortiesIndex.poll());
            }
            priortiesIndex = priortiesIndex1;
            // 만약 더 큰수가 있을 경우
            if(check){
                priortiesIndex.add(Queue.pop());
            }
        }

        int count =0;
        while(Queue.peek()[1]!=location){
            Queue.pop();
            count++;
        }

        return priorities.length-count;
    }
}