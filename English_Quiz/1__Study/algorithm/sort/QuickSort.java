package algorithm.sort;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;


public class QuickSort {
    static int N;
    static HashSet<Integer> inVal = new HashSet<Integer>();
    static ArrayList<Integer> sortVal;
    
    static void Input() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for(int i = 1; i <= N; i++){

            inVal.add(Integer.parseInt(br.readLine()));

        }

        sortVal = new ArrayList<Integer>(inVal);

        sortVal.add(Integer.MAX_VALUE);

        br.close();

    }

    static void swap(int i, int j){

        int temp = sortVal.get(i);

        sortVal.set(i, sortVal.get(j));
        sortVal.set(j, temp);

    }

    static void quickSort(int left, int right){

        
        if(left < right) {
            
            int pivot = sortVal.get(left);
    
            int i = left, j = right + 1;
    
            while(true){
    
                do { i++; } while(sortVal.get(i) < pivot);
                do { j--; } while(sortVal.get(j) > pivot);
        
                
                if(i < j) swap(i, j);
                else break;
    
            }
    
            swap(left, j);
    
            quickSort(left, j - 1);
            quickSort(j + 1, right);

        }
        

    }

    static void Solution() throws IOException{

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        quickSort(0, sortVal.size() - 1);

        sortVal.remove(sortVal.size() - 1);

        for(int i : sortVal)
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

