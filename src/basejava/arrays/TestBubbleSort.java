package basejava.arrays;

import java.util.Arrays;

public class TestBubbleSort {
    public static void main(String[] args) {
        int[] a = {2,5,7,9,1,3,8};
        System.out.println(Arrays.toString(TestBubbleSort.bubbleSort(a)));
    }

    private static int[] bubbleSort(int[] array){
        //设置交换中间参数
        int temp;
        for(int i = 0; i<array.length;i++){
            for(int j = i+1;j<array.length;j++){
                if(array[i]>array[j]){
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }
}
