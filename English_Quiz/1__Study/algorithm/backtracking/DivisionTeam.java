package algorithm.backtracking;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DivisionTeam {
    static int N;
    static int [][]S;

    static ArrayList<Integer> startTeam = new ArrayList<Integer>();
    static ArrayList<Integer> linkTeam = new ArrayList<Integer>();
    static boolean []check;
    
    static int gapMin = Integer.MAX_VALUE;
    
    static void Input() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        S = new int[N + 1][N + 1];

        check = new boolean[N + 1];

        for(int i = 1; i <= N; i++){

            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 1; j <= N; j++){

                S[i][j] = Integer.parseInt(st.nextToken());

            }

        }

        br.close();

    }

    static void addTeam(){

        int SA = 0, LA = 0;

        for(int i = 1; i <= N; i++){

            for(int j = i; j <= N; j++){

                if(check[i] && check[j]) SA += S[i][j] + S[j][i];
                if(!check[i] && !check[j]) LA += S[i][j] + S[j][i];

            }
        }

        int gap = Math.abs(SA - LA);

        if (gapMin > gap) gapMin = gap;

    }

    static void divisionTeam(int n){

        if (startTeam.size() == N / 2) {

            addTeam();

            return;

        }

        for(int i = 1; i <= N; i++){

            if (!check[i] && (startTeam.size() == 0 || startTeam.get(startTeam.size() - 1) < i)) {

                startTeam.add(i);

                check[i] = true;

                divisionTeam(i + 1);

                startTeam.remove(startTeam.size() - 1);

                check[i] = false;

            }
            

        }

    }

    

    static void Solution() throws IOException{

        divisionTeam(1);

        System.out.println(gapMin);

    }
    
    static void Solve() throws IOException{

        Input();

        Solution();

    }

    public static void main(String[] args) throws IOException{
        
        Solve();

    }
}