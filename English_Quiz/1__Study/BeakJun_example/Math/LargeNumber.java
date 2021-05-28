package BeakJun_example.Math;

import java.io.*;
import java.util.StringTokenizer;

public class LargeNumber {
    static String A;
    static String B;
    //static String result = "";

    static void Input() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        A = st.nextToken();
        B = st.nextToken();

        br.close();

    }

    static void Solution() throws IOException{

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int i = A.length(), j = B.length(), n = 0;
        long temp = 0;
        String result = "";

        int max = Math.max(i, j);

        while(max > 0){

            if(i != 0 && j != 0){

                temp = Long.parseLong(A.substring(i - 1, i)) + Long.parseLong(B.substring(j - 1, j));
    
                i--; j--;

            }
            else if(i == 0){

                temp = Long.parseLong(B.substring(j - 1, j));

                j--;

            }
            else if(j == 0){
                
                temp = Long.parseLong(A.substring(i - 1, i));

                i--;

            }

            if(result.length() > n){
    
                temp++;

                result = Long.valueOf(temp) + result.substring(1);

            }
            else result = Long.valueOf(temp) + result;

            n++;

            max--;

        }

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }
    
    static void Solve() throws IOException{

        Input();

        Solution();

    }

    public static void main(String[] args) throws IOException{
        
        Solve();

    }
}
