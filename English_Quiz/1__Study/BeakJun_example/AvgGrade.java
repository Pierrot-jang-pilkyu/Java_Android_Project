package BeakJun_example;

import java.io.*;
import java.util.StringTokenizer;

public class AvgGrade {
    static int C, N_MAX = 1000 + 1;
    static double []N;
    static double []avg;
    static double [][]grade;
    static String []result;

    static void Input() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        C = Integer.parseInt(br.readLine());
        N = new double[C + 1];
        grade = new double[C + 1][N_MAX];
        avg = new double[C + 1];
        result = new String[C + 1];
        
        for(int i = 1; i <= C; i++) avg[i] = 0;

        for(int i = 1; i <= C; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            N[i] = Integer.parseInt(st.nextToken());

            for(int j = 1; j <= N[i]; j++){

                grade[i][j] = Integer.parseInt(st.nextToken());
                avg[i] += grade[i][j];

            }

            avg[i] /= N[i];

        }

        br.close();

    }

    static void Solution() throws IOException{

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        double num = 0;
        
        for(int i = 1; i <= C; i++){

            for(int j = 1; j <= N[i]; j++){

                if(grade[i][j] > avg[i]) num++;

            }

            result[i] =  String.format("%.3f", ( num / N[i] ) * 100);

            num = 0;

        }

        for(int i = 1; i <= C; i++){

            bw.write(result[i] + "%" + "\n");

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
