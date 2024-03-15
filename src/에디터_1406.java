import java.io.*;
import java.util.*;

public class 에디터_1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Character> stack1 = new ArrayDeque<>();
        Deque<Character> stack2 = new ArrayDeque<>();

        char str[] = br.readLine().toCharArray();

        for(int i = 0; i < str.length; i++){
            stack1.push(str[i]);
        }


        int count = Integer.parseInt(br.readLine());

        for(int i = 0; i < count; i++){
            String instruction = br.readLine();

            if(instruction.equals("L")){
                if(!stack1.isEmpty())
                    stack2.push(stack1.pop());


            }
            else if (instruction.equals("D")) {
                if(!stack2.isEmpty())
                    stack1.push(stack2.pop());

            }
            else if(instruction.equals("B")){
                if(!stack1.isEmpty())
                    stack1.pop();
            }
            else{
                StringTokenizer st = new StringTokenizer(instruction);
                st.nextToken();
                stack1.push(st.nextToken().charAt(0));
            }
        }

        while(!stack1.isEmpty()){
            bw.write(String.valueOf(stack1.pollLast()));
        }
        while(!stack2.isEmpty()){
            bw.write(String.valueOf(stack2.pop()));
        }
        bw.flush();
        br.close();
        bw.close();


    }
}
