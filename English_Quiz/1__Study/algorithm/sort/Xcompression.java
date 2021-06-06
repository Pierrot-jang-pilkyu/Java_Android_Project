package algorithm.sort;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Xcompression {
    static int N, mid;
    static ArrayList<Integer> inVal = new ArrayList<Integer>();
    static int []result;
    
    static void Input() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= N; i++){

            inVal.add(Integer.parseInt(st.nextToken()));

        }

        result = new int[N];

        br.close();

    }

    static void binarySearch(int key, ArrayList<Integer> arr){

        int left = 0;
        int right = arr.size() - 1;

        while(left <= right){
            mid = (left + right) / 2;

            if(arr.get(mid) == key) break;

            if(arr.get(mid) < key) left = mid + 1;
            else right = mid - 1;

        }
    }

    

    static void Solution() throws IOException{

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashSet<Integer> tempSet = new HashSet<Integer>(inVal);

        ArrayList<Integer> tempList = new ArrayList<Integer>(tempSet);
        int []sortResult = new int[tempList.size()];

        tempList.sort(Comparator.naturalOrder());

        for(int i = 0; i < tempList.size() - 1; i++){

            if(tempList.get(i) < tempList.get(i + 1)) 
                sortResult[i + 1] = sortResult[i] + 1;
            else sortResult[i + 1] = sortResult[i];

        }

        for(int i = 0; i < N; i++){

            binarySearch(inVal.get(i), tempList);
            bw.write(sortResult[mid] + " ");

        }


        bw.newLine();
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