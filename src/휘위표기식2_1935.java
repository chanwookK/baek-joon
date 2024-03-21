import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class 휘위표기식2_1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<String> stack = new ArrayDeque<>();

        int count = Integer.parseInt(br.readLine());

        int strPointer = 0;
        char str[] = br.readLine().toCharArray();


        int i = 0;
        while(true){

            if(str[strPointer]>='A'&&str[strPointer]<='Z') {
                stack.push(String.valueOf(str[strPointer]));
                strPointer++;
            }
            else if(str[strPointer] == '*'){
                float a = Float.parseFloat(stack.pop());
                float b = Float.parseFloat(stack.pop());
                a = a*b;
                stack.push(String.valueOf(a));
                strPointer++;
            }
            else if(str[strPointer] == '+'){
                float a = Float.parseFloat(stack.pop());
                float b = Float.parseFloat(stack.pop());
                a = a+b;
                stack.push(String.valueOf(a));
                strPointer++;
            }
            else if(str[strPointer] == '/'){
                float a = Float.parseFloat(stack.pop());
                float b = Float.parseFloat(stack.pop());
                a = b/a;
                stack.push(String.valueOf(a));
                strPointer++;
            }
            else if(str[strPointer] == '-'){
                float a = Float.parseFloat(stack.pop());
                float b = Float.parseFloat(stack.pop());
                a = b-a;
                stack.push(String.valueOf(a));
                strPointer++;
            }

            if(strPointer == str.length + 1)
                break;


        }

        bw.write(stack.pop());
        bw.flush();
        bw.close();
        br.close();


    }
}
