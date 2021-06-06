package algorithm.sort;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;

class Voca implements Comparable<Voca> {
    private String voca = "";

    Voca(String _voca) { voca = _voca; }

    public String getVoca() { return voca; }
    public String setVoca(String _voca) { return voca = _voca; }

    @Override
    public int compareTo(Voca v2){

        int compare = -2;

        if(voca.length() > v2.getVoca().length()) compare = 1;
        else if(voca.length() == v2.getVoca().length()){

            for(int i = 0; i < voca.length(); i++){

                if(voca.charAt(i) > v2.getVoca().charAt(i)) { compare = 1; break; }
                if(voca.charAt(i) == v2.getVoca().charAt(i)) compare = 0;
                if(voca.charAt(i) < v2.getVoca().charAt(i)) { compare = -1; break; }

            }

        }
        else compare = -1;

        return compare;

    }
}

public class VocaSort {
    static int N;
    static HashSet<String> inVal = new HashSet<String>();
    static ArrayList<Voca> result = new ArrayList<Voca>();
    
    static void Input() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for(int i = 1; i <= N; i++){

            inVal.add(br.readLine());

        }

        var iter = inVal.iterator();
        while(iter.hasNext())
            result.add(new Voca(iter.next()));

        br.close();

    }

    

    static void Solution() throws IOException{

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        result.sort(Comparator.naturalOrder());

        for(Voca v : result)
            bw.write(v.getVoca() + "\n");

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