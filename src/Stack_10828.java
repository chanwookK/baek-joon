import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;

public class Stack_10828 {
    public static void main(String[] args) throws IOException {
        //stack 생성
        Deque<Integer> stack = new ArrayDeque<>();

        //read buffer 입력버퍼
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //명령의 갯수 개산
        int n = Integer.parseInt(br.readLine());

        int status;

        //명령 처리 구문
        for(int i = 0; i < n; i++) {

            //push 명령어 구분
            StringTokenizer st = new StringTokenizer(br.readLine());

            if(st.countTokens() == 2){
                st.nextToken();
                int pushNum = Integer.parseInt(st.nextToken());
                stack.push(pushNum);

            }
            else{
                String instruction = st.nextToken();

                status = 0;
                switch (instruction){
                    case "pop":
                        if(stack.isEmpty()) {
                            status = -1;
                            break;
                        }
                        status = stack.pop();
                        break;
                    case "size":
                        status = stack.size();
                        break;
                    case "empty":
                        status = stack.isEmpty()? 1:0;
                        break;
                    case "top":
                        if(stack.isEmpty()){
                            status = -1;
                            break;
                        }

                        status = stack.peek();
                        break;

                }

                bw.write(String.valueOf(status));
                bw.newLine();
                bw.flush();

            }

        }
        bw.close();
        br.close();

    }
}
