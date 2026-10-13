package cl5;
public class BinarySearchDemo {
    public static void main(String[] args) {
        int[] arr1 = {1,3,5,7,9};
        System.out.println(binarySearch(arr1,7));
        System.out.println(binarySearch(arr1,6));

        int[] arr2 = {9,1,7,3,5};
        System.out.println(binarySearch(arr2,7));

        int[] arr3 = {5};
        System.out.println(binarySearch(arr3,5));
        System.out.println(binarySearch(arr3,3));
    }

    //二分查找，只接受升序数组，找到返回下标，找不到返回‑1
    public static int binarySearch(int[] arr, int key){
        int left = 0;
        int right = arr.length - 1;
        //✅修改此处条件 left <= right
        while(left <= right){
            int mid = (left + right)/2;
            if(arr[mid]==key){
                return mid;
            }else if(arr[mid]<key){
                left = mid + 1;
            }else{
                right = mid -1;
            }
        }
        return -1;
    }
}

