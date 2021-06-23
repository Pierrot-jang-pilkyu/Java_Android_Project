package BeakJun_example;

import java.io.*;
import java.util.*;

public class Rectangle {
    
    static HashMap<Integer, Integer> count_x = new HashMap<Integer, Integer>();
    static HashMap<Integer, Integer> count_y = new HashMap<Integer, Integer>();
    static int v[][] = new int[3][2];

    public static void Input() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 3; i++){

            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 0; j < 2; j++){

                v[i][j] = Integer.parseInt(st.nextToken());

            }

        }
        
        br.close();

    }
        
    public static void counting(int[][] v){
        
        for(int i = 0; i < 3; i++){
            
            for(int j = 0; j < 2; j++){
                
                if(j == 0) {
                    
                    if(count_x.containsKey(v[i][j])){
                        count_x.remove(v[i][j]);
                        count_x.put(v[i][j], 2);
                    }
                    else count_x.put(v[i][j], 1);
                }
                else {
                    
                    if(count_y.containsKey(v[i][j])){
                        count_y.remove(v[i][j]);
                        count_y.put(v[i][j], 2);
                    }
                    else count_y.put(v[i][j], 1);
                }
                
            }
        }
    }
    
    public static int[] solution(int[][] v) {
        int[] answer = new int[2];
        
        counting(v);

        Set<Map.Entry<Integer, Integer>> entriesX =  count_x.entrySet();
        Set<Map.Entry<Integer, Integer>> entriesY =  count_y.entrySet();
        
        for(var entry : entriesX){
            
            if(entry.getValue() == 1) answer[0] = entry.getKey();
            
        }
        
        for(var entry : entriesY){
            
            if(entry.getValue() == 1) answer[1] = entry.getKey();
            
        }
        
        return answer;
    }

    public static void Solve() throws IOException{

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Input();

        int[] answer = new int[2];

        answer = solution(v);

        bw.write(answer[0] + " " + answer[1]);
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        
        Solve();

    }
}