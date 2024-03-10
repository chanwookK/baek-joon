import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 단어뒤집기_9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int n = Integer.parseInt(br.readLine());


        for(int i = 0; i < n; i++){

            StringTokenizer st = new StringTokenizer(br.readLine());
            StringBuilder sbSum = new StringBuilder();

            int count = st.countTokens();
            for(int j = 0; j < count; j++){
                StringBuilder sb = new StringBuilder();

                sb.append(st.nextToken()).reverse().append(" ");

                sbSum.append(sb.toString());

            }

            bw.write(sbSum.toString());
            bw.newLine();
            bw.flush();

        }

        bw.close();
        br.close();
    }
}

class 단어뒤집기_9093_Stack풀이 {
    public static void main(String[] args) throws IOException {

        Deque<Character> stack = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int n = Integer.parseInt(br.readLine());


        for(int i = 0; i < n; i++){

            StringTokenizer st = new StringTokenizer(br.readLine());


            int count = st.countTokens();
            for(int j = 0; j < count; j++){
                String str = st.nextToken();

                for (char a: str.toCharArray()) {
                    stack.push(a);
                }

                while(!stack.isEmpty())
                    bw.write(stack.pop().toString());
                bw.write(" ");
                bw.flush();

            }

            bw.newLine();


        }

        bw.close();
        br.close();
    }
}
