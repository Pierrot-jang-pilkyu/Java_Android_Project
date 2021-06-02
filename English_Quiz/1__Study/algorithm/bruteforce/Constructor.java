package algorithm.bruteforce;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class Constructor {
    static int N, N_length;
    static ArrayList<Integer> result = new ArrayList<Integer>();
    
    static void Input() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String nString = br.readLine();

        N = Integer.parseInt(nString);

        N_length = nString.length();

        br.close();

    }

    static void constuctor(int n){

        int i, add = n - 1;
    
        for(i = N - 1; i > N / 2; i--){
            
            add = i;
    
            for(int j = 0; j < N_length; j++){
    
                add += (i % Math.pow(10, (j + 1))) / Math.pow(10, j);
                
                if(N == add && j == N_length - 1) break;
    
            }
    
            if(N == add) result.add(i);
    
        }
    
    }

    static void Solution() throws IOException{

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        constuctor(N);
        
        result.sort(Comparator.naturalOrder());

        if(result.size() != 0)
            bw.write(result.get(0) + "\n");
        else bw.write('0');
        
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
