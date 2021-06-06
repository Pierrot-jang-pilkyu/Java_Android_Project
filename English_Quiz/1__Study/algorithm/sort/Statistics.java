package algorithm.sort;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;


public class Statistics {
    static int N_MAX = 8001 + 1;    // -4000 ~ 4000
    static int N;
    static ArrayList<Integer> inVal = new ArrayList<Integer>();
    static ArrayList<Integer> result = new ArrayList<Integer>();
    static int []Count = new int[N_MAX];
    
    static void Input() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for(int i = 1; i <= N; i++){

            inVal.add(Integer.parseInt(br.readLine()));

        }

        br.close();

    }

    static int counting(int n){

        int max = 0;
        ArrayList<Integer> mode = new ArrayList<Integer>();

        for(int i = 0; i < n; i++){

            Count[inVal.get(i) + 4000] += 1;

        }

        for(int i = -4000; i <= 4000; i++){

            if(Count[i + 4000] == 0) continue;
            max = Math.max(max, Count[i + 4000]);
            
        }

        for(int i = -4000; i <= 4000; i++){

            if(Count[i + 4000] == max) mode.add(i);
            
        }

        return mode.size() == 1? mode.get(0) : mode.get(1);

    }
    

    static void Solution() throws IOException{

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        double add = 0;

        inVal.sort(Comparator.naturalOrder());
        
        // 1. arithmatic mean
        for(int i : inVal)
            add += i;

        result.add((int)Math.round(add / N));

        // 2. middle value
        double middle = Math.ceil(N / 2);

        result.add(inVal.get((int)middle));

        // 3. mode
        result.add(counting(N));

        // 4. range
        int min = inVal.get(0);
        int max = inVal.get(inVal.size() - 1);

        result.add(max - min);

        for(int i : result)
            bw.write(i + "\n");


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