package algorithm.sort;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

class User implements Comparable<User> {
    private int age = 0;
    private String name = "";
    private int order = 0;

    User(int _age, String _name, int _order) {
        age = _age;
        name = _name;
        order = _order;
    }

    public int getAge() { return age; }
    public String getName() { return name; }
    public int getOrder() { return order; }

    public int setAge(int _age) { return age = _age; }
    public String setName(String _name) { return name = _name; }
    public int setOrder(int _order) { return order = _order; }

    @Override
    public int compareTo(User u2){

        int compare = 0;
        
        if(age > u2.getAge()) compare = 1;
        else if( age == u2.getAge()){

            if(order > u2.getOrder()) compare = 1;
            if(order < u2.getOrder()) compare = -1;

        }
        else compare = -1;

        return compare;

    }
}

public class UserSort {
    static int N;
    static ArrayList<User> inVal = new ArrayList<User>();
    
    static void Input() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for(int i = 1; i <= N; i++){

            StringTokenizer st = new StringTokenizer(br.readLine());

            inVal.add(new User(Integer.parseInt(st.nextToken()), st.nextToken(), i));

        }

        br.close();

    }

    

    static void Solution() throws IOException{

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        inVal.sort(Comparator.naturalOrder());

        for(var u : inVal)
            bw.write(u.getAge() + " " + u.getName() + "\n");


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