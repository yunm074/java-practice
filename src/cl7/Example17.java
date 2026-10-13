package cl7;
class Outer01{
    private static int num=6;
    static class Inner{
        void show(){
            System.out.println("num="+num);
        }
    }
}
class Example17 {
    public static void main(String[] args){
        Outer01.Inner inner =new Outer01.Inner();
        inner.show();
    }
}
