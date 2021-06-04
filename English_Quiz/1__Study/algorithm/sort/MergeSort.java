package algorithm.sort;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

public class MergeSort {
    static int N;
    static HashSet<Integer> inVal = new HashSet<Integer>();
    static int []sortVal;
    static ArrayList<Integer> result = new ArrayList<Integer>();
    
    static void Input() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for(int i = 1; i <= N; i++){

            inVal.add(Integer.parseInt(br.readLine()));

        }

        result = new ArrayList<Integer>(inVal);

        sortVal = new int[N];

        br.close();

    }

    static void merge(int left, int middle, int right){

        int i = left;
        int j = middle + 1;
        int k = left;

        while(i <= middle && j <= right){

            if(result.get(i) < result.get(j)){

                sortVal[k] = result.get(i);
                i++;

            }
            else{

                sortVal[k] = result.get(j);
                j++;

            }

            k++;
            
        }

        if(i >middle){

            for(int x = j; x <= right; x++){

                sortVal[k] = result.get(x);
                k++;

            }
            
        }
        else if(j > right){

            for(int x = i; x <= middle; x++){

                sortVal[k] = result.get(x);
                k++;

            }

        }

        for(int x = left; x <= right; x++){

            result.set(x, sortVal[x]);

        }

    }

    static void mergeSort(int left, int right){

        if(left < right){

            int middle = (left + right) / 2;
            mergeSort(left, middle);
            mergeSort(middle + 1, right);
            merge(left, middle, right);

        }

    }

    static void Solution() throws IOException{

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        mergeSort(0, result.size() - 1);


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