package BeakJun_example.Math;

import java.io.*;
import java.util.StringTokenizer;

public class HotelManage {
    static int T;
    static int []H;
    static int []W;
    static int []N;
    static String []result;

    static void Input() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        T = Integer.parseInt(br.readLine());

        H = new int[T + 1];
        W = new int[T + 1];
        N = new int[T + 1];
        result = new String[T + 1];

        for(int i = 1; i <= T; i++){

            StringTokenizer st = new StringTokenizer(br.readLine());
    
            H[i] = Integer.parseInt(st.nextToken());
            W[i] = Integer.parseInt(st.nextToken());
            N[i] = Integer.parseInt(st.nextToken());

        }

        br.close();

    }

    static void Solution() throws IOException{

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int []temp = new int[T + 1];
        int j;

        for(int i = 1; i <= T; i++){
            
            for(j = 1; N[i] > 0; j++){

                N[i] -= H[i];

            }
            temp[i] = j - 1;

        }

        for(int i = 1; i <= T; i++){

            if(temp[i] < 10)
                result[i] = Integer.toString(H[i] + N[i]) + "0" +Integer.toString(temp[i]);
            else
                result[i] = Integer.toString(H[i] + N[i]) + Integer.toString(temp[i]);

        }

        for(int i = 1; i <= T; i++){

            bw.write(result[i] + "\n");

        }

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
