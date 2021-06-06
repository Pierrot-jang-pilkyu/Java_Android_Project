package algorithm.sort;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

class DescartesCross implements Comparable<DescartesCross>{
    private int x = 0;
    private int y = 0;

    DescartesCross(int _x, int _y){ x = _x; y = _y; }

    public int getX() { return x; }
    public int getY() { return y; }
    public int setX(int _x) { return x = _x; }
    public int setY(int _y) { return y = _y; }

    @Override
    public int compareTo(DescartesCross point2) {
        // TODO Auto-generated method stub
        return y > point2.y? 1 : y == point2.y && x > point2.x? 1 : x == point2.x && y == point2.y? 0 : -1;

    }
    
    
}

public class DescartesCrossSort2 {
    static int N;
    static ArrayList<DescartesCross> inVal = new ArrayList<DescartesCross>();
    
    static void Input() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for(int i = 1; i <= N; i++){

            StringTokenizer st = new StringTokenizer(br.readLine());

            inVal.add(new DescartesCross(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));

        }

        br.close();

    }

    

    static void Solution() throws IOException{

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        inVal.sort(Comparator.naturalOrder());

        for(var p : inVal)
            bw.write(p.getX() + " " + p.getY() + "\n");

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