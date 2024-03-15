import java.io.*;
import java.util.*;

public class 오큰수_17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> mainStack = new ArrayDeque<>();
        Deque<Integer> numStack = new ArrayDeque<>();
        List<String> NGE = new ArrayList<>();

        int count = Integer.parseInt(br.readLine());

        String outPut[] = new String[count];

        StringTokenizer st = new StringTokenizer(br.readLine());



        mainStack.push(Integer.parseInt(st.nextToken()));
        numStack.push(0);

        for(int i = 1; i < count; i++){
            int token = Integer.parseInt(st.nextToken());

            while(token > mainStack.peek()){
                mainStack.pop();
                outPut[numStack.pop()] = String.valueOf(token);

                if(mainStack.isEmpty())
                    break;
            }

            mainStack.push(token);
            numStack.push(i);

        }


        while(!mainStack.isEmpty()){
            mainStack.pop();
            outPut[numStack.pop()] = "-1";
        }


        for(int i = 0; i < count; i++){
            bw.write(outPut[i]);
            bw.write(" ");
        }

        bw.flush();
        bw.close();
        br.close();



    }
}
