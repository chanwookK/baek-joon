import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class 쇠막대기_10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Character> stack = new ArrayDeque<>();

        char str[] = br.readLine().toCharArray();
        int sum = 0;
        int stick = 0;

        stack.push(str[0]);

        for(int i = 1; i < str.length; i++){
            if(str[i - 1] == '(' && str[i] == ')'){
                stack.pop();
                sum += stack.size();
            }
            else if(str[i] == ')'){
                stick++;
                stack.pop();

            }
            else if(str[i] == '('){
                stack.push('(');
            }

        }
        sum += stick;

        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
        br.close();

    }

}
