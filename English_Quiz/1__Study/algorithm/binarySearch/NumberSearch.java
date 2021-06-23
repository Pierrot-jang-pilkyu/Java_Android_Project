package algorithm.binarySearch;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class NumberSearch {
    static int N, M;
    static ArrayList<Integer> A = new ArrayList<Integer>();
    static ArrayList<Integer> X = new ArrayList<Integer>();
    static ArrayList<Integer> result = new ArrayList<Integer>();
    
    static void Input() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= N; i++){

            A.add(Integer.parseInt(st.nextToken()));

        }

        M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= M; i++){

            X.add(Integer.parseInt(st.nextToken()));

        }

        br.close();

    }

    static void binarySearch(int key, ArrayList<Integer> arr){

        int left = 0, right = arr.size() - 1;
        
        while(left <= right){

            int mid = (left + right) / 2;

            if(arr.get(mid) == key) { result.add(1); return; }

            if(arr.get(mid) > key) right = mid - 1;
            else left = mid + 1;

        }

        result.add(0);

    }

    

    static void Solution() throws IOException{

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        A.sort(Comparator.naturalOrder());

        for(int i = 0; i < M; i++) binarySearch(X.get(i), A);

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