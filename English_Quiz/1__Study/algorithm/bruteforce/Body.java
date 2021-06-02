package algorithm.bruteforce;

public class Body implements Comparable<Body>{
    public int height = 0;
    public int weight = 0;
    public int rank = 0;

    public Body(int _weight, int _height) {
        height = _height;
        weight = _weight;
    }

    public int getHeight(){
        return height;
    }

    public int getWeight(){
        return weight;
    }

    public int getRank(){
        return rank;
    }

    public void setHeight(int _height){
        height = _height;
    }

    public void setWeight(int _weight){
        weight = _weight;
    }

    public void setRank(int _rank){
        rank = _rank;
    }

    @Override
    public int compareTo(Body body) {
        // TODO Auto-generated method stub

        int count = 0;

        if(height > body.height) count++;
        if(weight > body.weight) count++;
        if(height == body.height && weight == body.weight) return 0;
        
        return count == 0? -1 : count == 1? 0 : 1;

    }

}