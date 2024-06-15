import java.io.*;
import java.util.*;

public class 휘위표기식2_1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Double> stack = new ArrayDeque<>();
        Map<Character, Integer> numMap = new HashMap<>();

        int count = Integer.parseInt(br.readLine());

        int strPointer = 0;
        char str[] = br.readLine().toCharArray();

        for(int i = 0; i < count; i++){
            int store = Integer.parseInt(br.readLine());
            char charset = (char)('A' + i);
            numMap.put(charset, store);
        }

        int i = 0;
        while(true){

            if(str[strPointer]>='A'&&str[strPointer]<='Z') {
                stack.push((double) numMap.get(str[strPointer]));
                strPointer++;
            }
            else if(str[strPointer] == '*'){
                double a = stack.pop();
                double b = stack.pop();
                a = a*b;
                stack.push(a);
                strPointer++;
            }
            else if(str[strPointer] == '+'){
                double a = stack.pop();
                double b = stack.pop();
                a = a+b;
                stack.push(a);
                strPointer++;
            }
            else if(str[strPointer] == '/'){
                double a = stack.pop();
                double b = stack.pop();
                a = b/a;
                stack.push(a);
                strPointer++;
            }
            else if(str[strPointer] == '-'){
                double a = stack.pop();
                double b = stack.pop();
                a = b-a;
                stack.push(a);
                strPointer++;
            }

            if(strPointer == str.length)
                break;


        }

        System.out.printf("%.2f", stack.pop());
        bw.flush();
        bw.close();
        br.close();


    }
}
