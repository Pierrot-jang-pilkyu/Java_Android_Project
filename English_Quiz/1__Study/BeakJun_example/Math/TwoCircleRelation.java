package BeakJun_example.Math;

import java.io.*;
import java.util.StringTokenizer;

public class TwoCircleRelation {
    static int T;
    static double [][]sixValue;

    static void Input() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        sixValue = new double[T + 1][7];

        for(int i = 1; i <= T; i++){

            StringTokenizer st = new StringTokenizer(br.readLine());

            sixValue[i][1] = Double.parseDouble(st.nextToken());  // x1
            sixValue[i][2] = Double.parseDouble(st.nextToken());  // y1
            sixValue[i][3] = Double.parseDouble(st.nextToken());  // r1
            sixValue[i][4] = Double.parseDouble(st.nextToken());  // x2
            sixValue[i][5] = Double.parseDouble(st.nextToken());  // y2
            sixValue[i][6] = Double.parseDouble(st.nextToken());  // r2

        }

        br.close();

    }

    static void Solution() throws IOException{

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 1; i <= T; i++){

            double two_x_distance = Math.abs(sixValue[i][1] - sixValue[i][4]);
            double two_y_distance = Math.abs(sixValue[i][2] - sixValue[i][5]);
            double two_r_sum = sixValue[i][3] + sixValue[i][6];
            double two_r_difference = Math.abs(sixValue[i][3] - sixValue[i][6]);
    
            double distance_twoPoint = Math.sqrt(Math.pow(two_x_distance, 2) + Math.pow(two_y_distance, 2));

            if(distance_twoPoint == 0){
                if(sixValue[i][3] == sixValue[i][6]) bw.write("-1" + "\n");
                else bw.write("0" + "\n");
            }
            else if(distance_twoPoint == two_r_sum || distance_twoPoint == two_r_difference) // two circle is circumscribed or inscribed.
                bw.write("1" + "\n");

            else if((two_r_difference < distance_twoPoint) && (distance_twoPoint < two_r_sum)) // two circle is met two point.
                bw.write("2" + "\n");

            else
                bw.write("0" + "\n");

            

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
