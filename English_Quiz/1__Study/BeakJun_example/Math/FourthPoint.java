package BeakJun_example.Math;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Pair{
    private int x;
    private int y;

    Pair(){
        this.x = 0;
        this.y = 0;
    }

    Pair(int _x, int _y){
        this.x = _x;
        this.y = _y;
    }

    public void setPair(int _x, int _y){
        this.x = _x;
        this.y = _y;
    }

    public int getFirst(){
        return this.x;
    }

    public int getSecond(){
        return this.y;
    }
}

public class FourthPoint {
    static ArrayList<Pair> point = new ArrayList<Pair>();

    static void Input() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 1; i <= 3; i++){

            StringTokenizer st = new StringTokenizer(br.readLine());

            point.add(new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));

        }

        br.close();

    }

    static void Solution() throws IOException{

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int resultX = 0, resultY = 0;

        for(int i = 0; i < 3; i++){

            for(int j = i + 1; j < 3; j++){

                if(point.get(i).getFirst() == point.get(j).getFirst())
                    for(int k = 0; k < 3; k++)
                        { if(k != i && k != j) resultX = point.get(k).getFirst(); }
                else if(point.get(i).getSecond() == point.get(j).getSecond())
                    for(int k = 0; k < 3; k++)
                        { if(k != i && k != j) resultY = point.get(k).getSecond(); }

            }
        }

        bw.write(resultX + " " + resultY + "\n");


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
