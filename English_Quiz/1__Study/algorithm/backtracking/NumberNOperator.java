package algorithm.backtracking;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class NumberNOperator {
    static int N;
    static int []Operator = new int[5];
    static ArrayList<Integer> inVal = new ArrayList<Integer>();
    static ArrayList<Integer> result = new ArrayList<Integer>();
    
    static void Input() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= N; i++){

            inVal.add(Integer.parseInt(st.nextToken()));

        }

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= 4; i++){

            Operator[i] = Integer.parseInt(st.nextToken());

        }

        br.close();

    }

    static void insertOperator(int numIndex, int calValue){

        if(numIndex == N) { result.add(calValue); return; }

        int temp = calValue;

        for (int j = 1; j < 5; j++) {

            if (Operator[j] != 0) {

                calValue = j == 1 ? calValue + inVal.get(numIndex)
                         : j == 2 ? calValue - inVal.get(numIndex)
                         : j == 3 ? calValue * inVal.get(numIndex)
                         : calValue / inVal.get(numIndex);

                Operator[j]--;

                insertOperator(numIndex + 1, calValue);

                Operator[j]++;

                calValue = temp;

            }

        }

    }

    

    static void Solution() throws IOException{

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        insertOperator(1, inVal.get(0));

        result.sort(Comparator.naturalOrder());

        bw.write(result.get(result.size() - 1) + "\n");
        bw.write(result.get(0) + "\n");
        

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