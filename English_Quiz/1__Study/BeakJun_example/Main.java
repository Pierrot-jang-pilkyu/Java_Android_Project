package BeakJun_example;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
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

        

        while(i >= 1 && j >= 1){

            temp = Long.parseLong(A.substring(i - 1, i)) + Long.parseLong(B.substring(j - 1, j));

            i--; j--;

            if(result.length() > n){

                temp++;

                result = Long.valueOf(temp) + result.substring(1);

            }
            else result = Long.valueOf(temp) + result;

            n++;

        }



        if(i >= 1){
    
            if(result.length() > n){
                if(result.charAt(0) == '0') result = A.substring(0, i) + result;
                else
                    result = A.substring(0, i - 1) + Long.valueOf(Long.parseLong(A.substring(i - 1, i) ) + 1) + result.substring(1);
 
            }
            else result = A.substring(0, i) + result;

            i--;
        }
        else if(j >= 1){
    
            if(result.length() > n){
                if(result.charAt(0) == '0') result = B.substring(0, j) + result;
                else
                    result = B.substring(0, j - 1) + Long.valueOf(Long.parseLong(B.substring(j - 1, j) ) + 1) + result.substring(1);
                    
            }
            else result = B.substring(0, j) + result;

            j--;
    
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
