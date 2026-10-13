package cl5;

public class zuoye2 {
    public static void main(String[] args) {

        int N = 40125;
        int d = N % 10;
        int len = d + 3;


        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (N * (i + 1)) % 100;
        }

        int[] origin = arr.clone();
        int[] bubbleArr = arr.clone();
        int[] reverseArr = arr.clone();

        int max = origin[0];
        int min = origin[0];
        double sum = 0;
        for(int i = 0; i < len; i++){
            if(origin[i] > max) max = origin[i];
            if(origin[i] < min) min = origin[i];
            sum += origin[i];
        }
        double avg = sum / len;

        for(int i = 0; i < bubbleArr.length -1; i++){
            for(int j = 0; j < bubbleArr.length - 1 - i; j++){
                if(bubbleArr[j] > bubbleArr[j+1]){
                    int t = bubbleArr[j];
                    bubbleArr[j] = bubbleArr[j+1];
                    bubbleArr[j+1] = t;
                }
            }
        }

        int minIndex = 0;
        for(int i=0;i<origin.length;i++){
            if(origin[i]==min){
                minIndex = i;
            }
        }
        int key = 45;
        int left = 0, right = bubbleArr.length-1;
        int binaryIdx = -1;
        while(left <= right){
            int mid = (left + right)/2;
            if(bubbleArr[mid]==key){
                binaryIdx = mid;
                break;
            }else if(bubbleArr[mid]<key){
                left = mid + 1;
            }else{
                right = mid -1;
            }
        }

        for(int i=0;i<reverseArr.length/2;i++){
            int t = reverseArr[i];
            reverseArr[i] = reverseArr[reverseArr.length-1-i];
            reverseArr[reverseArr.length-1-i] = t;
        }

        System.out.println("========== 学号数组实验室 ==========");
        System.out.printf("学号后四位: %d (个位d=%d, 数组长度 %d)%n",N,d,len);

        System.out.print("第1项 原始数组    : ");
        for(int num:origin) System.out.print(num+" ");
        System.out.println();

        System.out.printf("第2项 最大/最小/平均 : %d / %d / %.1f%n",max,min,avg);

        System.out.print("第3项 冒泡升序    : ");
        for(int num:bubbleArr) System.out.print(num+" ");
        System.out.println();

        System.out.printf("第4项 查找        : 最小值在第 %d 位; 二分查找 %d → 找到, 下标 %d%n",minIndex,key,binaryIdx);

        System.out.print("第5项 逆序存储    : ");
        for(int num:reverseArr) System.out.print(num+" ");
        System.out.println();

        System.out.println("====================================");
    }

}
