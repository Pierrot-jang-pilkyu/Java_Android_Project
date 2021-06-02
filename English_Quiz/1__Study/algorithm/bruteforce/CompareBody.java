package algorithm.bruteforce;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class CompareBody {
    static int N;
    static ArrayList<Body> people = new ArrayList<Body>();
    
    static void Input() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for(int i = 1; i <= N; i++){

            StringTokenizer st = new StringTokenizer(br.readLine());

            people.add(new Body(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));

        }

        br.close();

    }

    

    static void Solution() throws IOException{

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<Body> temp = new ArrayList<Body>(people);

        temp.sort(Comparator.reverseOrder());

        temp.get(0).setRank(1);

        for(int i = 0; i < temp.size() - 1; i++){

            if (temp.get(i).compareTo(temp.get(i + 1)) == 1)
                temp.get(i + 1).setRank(i + 2);

            if (temp.get(i).compareTo(temp.get(i + 1)) == 0)
                temp.get(i + 1).setRank(temp.get(i).getRank());

        }

        for(int i = 0; i < people.size(); i++){

            bw.write(people.get(i).getRank() + " ");
            
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


