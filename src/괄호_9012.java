import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class 괄호_9012 {
    public static void main(String[] args) throws IOException {
        Deque<Integer> stack = new ArrayDeque<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());

        Label: for(int i = 0; i < count; i++){
            stack.clear();
            //한줄 처리
            char element[] = br.readLine().toCharArray();

            for (char e: element) {
                if(e == '(')
                    stack.push(0);
                else{
                    if(!stack.isEmpty()){
                        stack.pop();
                    }
                    else {
                        bw.write("NO");
                        bw.newLine();
                        bw.flush();
                        continue Label;
                    }
                }
            }

            if(!stack.isEmpty()){
                bw.write("NO");
                bw.newLine();
                bw.flush();
            }
            else {
                bw.write("YES");
                bw.newLine();
                bw.flush();
            }

        }
        br.close();
        bw.close();
    }
}
