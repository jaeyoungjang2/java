import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class baekjoon17298{
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int[] ary = new int[count];

        String[] temp = (br.readLine().split(" "));      
        

        for (int i = 0; i < ary.length; i++) {
            ary[i] = Integer.parseInt(temp[i]);
        }
        
        int[] res = new int[count];
        // 스택은 내림차순으로 나타날 것임.
        // 스택에는 인덱스 번호를 넣어주고
        // 인덱스 번호가 지정한 값보다 현재 값이 더 클 경우에는 결과 값에 저장
        Stack<Integer> stk = new Stack<Integer>();
        for (int i = 0; i < ary.length; i++) {
            while (stk.size() > 0 && ary[stk.peek()] < ary[i]){                
                res[stk.pop()] = ary[i];
            }
            stk.push(i);
        }
        
        while (!stk.isEmpty()) {
            res[stk.pop()] = -1;
        }
        
        StringBuilder sb = new StringBuilder();
		for(int i = 0; i < count; i++) {
			sb.append(res[i]).append(' ');
		}
		System.out.println(sb);
    }
}
