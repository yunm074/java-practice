package lian;
//无额外输入，判断及格人数
public class CountPass {
    public static void main(String[] args) {
        double[] scores = {99, 100, 62, 15, 48, 65, 98, 99, 5, 59.5, 75};
        int count = 0;
        for(int i = 0; i < scores.length; i++){
            if(scores[i] >= 60){
                count++;
            }
        }
        System.out.println(count);
    }
}
