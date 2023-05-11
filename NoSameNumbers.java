import java.util.Stack;

public class NoSameNumbers {
    public static void main(String[] args) {
        Solution01 s = new Solution01();
        int [] arr = {1,1,3,3,0,1,1};

        for (int a:s.solution(arr)){
            System.out.print(a+" ");
        }
    }
}

class Solution01 {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if(stack.isEmpty()||stack.peek()!=arr[i]){
                stack.push(arr[i]);
            }
        }
        int [] answer = new int[stack.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[answer.length-1-i] = stack.pop();
        }
        return answer;
    }
}
