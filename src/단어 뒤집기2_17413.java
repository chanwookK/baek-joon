import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;


public class 단어 뒤집기2_17413 {
    public static void main(String[] args) throws IOException {
        Deque<Character> stack = new ArrayDeque<>();
        Deque<Character> queue = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String st = br.readLine();
        char in[] = st.toCharArray();


        for(int i = 0; i < in.length; i++){
            if(in[i] == '<'){
                bw.write("<");
                bw.flush();
                int j;
                for(j = i + 1; in[j] != '>'; j++){
                    bw.write(String.valueOf(in[j]));
                }
                bw.write(">");
                bw.flush();
                i = j;
            }
            else if(in[i] == ' '){
                bw.write(" ");
                bw.flush();
                int j;
                for(j = i + 1; in[j] != '<'&& in[j] != ' '; j++){
                    stack.push(in[j]);
                    if(j == in.length - 1){
                        while(!stack.isEmpty()){
                            bw.write(String.valueOf(stack.pop()));
                            bw.flush();
                        }
                        return;
                    }
                }
                while(!stack.isEmpty()){
                    bw.write(String.valueOf(stack.pop()));
                    bw.flush();
                }
                i = j - 1;
            }
            else {
                int j;
                for(j = i; in[j] != '<'&& in[j] != ' '; j++){
                    stack.push(in[j]);
                    if(j == in.length - 1) {
                        while(!stack.isEmpty()){
                            bw.write(String.valueOf(stack.pop()));
                            bw.flush();
                        }
                        return;
                    }
                }
                while(!stack.isEmpty()){
                    bw.write(String.valueOf(stack.pop()));
                    bw.flush();
                }
                i = j - 1;
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
