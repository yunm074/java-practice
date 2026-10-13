package lian;
public class Counter {
    private int count;
    public void initCounter(){
        count = 0;
    }
    public void increment(){
        count++;
    }
    public int getCount(){
        return count;
    }

    public static void main(String[] args) {
        Counter c = new Counter();
        c.initCounter();
        c.increment();
        c.increment();
        c.increment();
        System.out.println(c.getCount());
    }
}