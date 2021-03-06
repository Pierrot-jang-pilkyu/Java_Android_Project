package BeakJun_example.Math;

import java.io.*;
import java.util.StringTokenizer;

public class Warp {
    static int T;
    static int []X;
    static int []Y;
    static int []gap;
    static int []result;

    static void Input() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        X = new int[T + 1];
        Y = new int[T + 1];
        gap = new int[T + 1];
        
        for(int i = 1; i <= T; i++){

            StringTokenizer st = new StringTokenizer(br.readLine());

            X[i] = Integer.parseInt(st.nextToken());
            Y[i] = Integer.parseInt(st.nextToken());

        }
        
        for(int i = 1; i <= T; i++) {
        	
        	gap[i] = Y[i] - X[i];
        	
        }

        br.close();
    
    }

    static void Solution() throws IOException{

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        result = new int[T + 1];

        for(int i = 1; i <= T; i++) {
        	
        	long count = (long) Math.sqrt((double)(Y[i] - X[i]));
        	
        	if((count * count) == gap[i])
        		bw.write(2 * count - 1 + "\n");
        	else if((count * count) < gap[i] && gap[i] <= (count * (count + 1)))
        		bw.write(2 * count + "\n");
        	else if((count * (count + 1)) < gap[i] && gap[i] <= ((count + 1) * (count + 1)))
        		bw.write(2 * count + 1 + "\n");
        	
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
