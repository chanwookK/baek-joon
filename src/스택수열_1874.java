import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class 스택수열_1874  {
    public static void main(String[] args) throws IOException {
        Deque<Character> outQueue = new ArrayDeque<>();
        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Integer> inQueue = new ArrayDeque<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        for(int i = 0; i < count; i++){
            inQueue.push(Integer.parseInt(br.readLine()));
        }

        int goal = inQueue.pollLast();

        int i = 1;
        while(true){

            if(stack.isEmpty()){
                if(i > count){
                    //성공
                    break;
                }
                stack.push(i);
                outQueue.push('+');
                i++;
            }
            else{
                if(stack.peek() == goal){
                    stack.pop();
                    outQueue.push('-');
                    if(!inQueue.isEmpty())
                        goal = inQueue.pollLast();
                }
                else{
                    if(i > count){
                        //실패
                        bw.write("NO");
                        bw.flush();
                        br.close();
                        bw.close();
                        return;
                    }
                    stack.push(i);
                    outQueue.push('+');
                    i++;
                }
            }

        }

        int c = outQueue.size();
        for(int j = 0; j < c; j++){
            bw.write(outQueue.pollLast().toString());
            bw.newLine();
        }
        bw.flush();
        br.close();
        bw.close();

    }



}
