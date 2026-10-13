package lianxi;
public class Calculator {
    public int add(int a, int b){
        return a + b;
    }

    public static void main(String[] args) {
        Calculator cal = new Calculator();
        int res = cal.add(3,5);
        System.out.println(res);
    }
}
