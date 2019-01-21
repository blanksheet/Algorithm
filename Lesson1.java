package Lesson;

/**
 * Created by tianze
 * 2018/12/12 15:15
 */
public class Lesson1 {
    public static void insertSort(int[] array){
        if(array == null || array.length == 0){
            return;
        }

        for(int i = 1; i < array.length; i++){
            int j = i - 1;

            while( j >= 0){
                if(array[j] > array[i]){
                    swap(array, j, i);
                    i = j;
                }
                j--;
            }
        }
    }

    private static void swap(int[] array, int j, int i){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static int[] mergeSort(int[] array, int low, int high){
        if(array == null || array.length == 0 || low >= high){
            return array;
        }

        int mid  = low + (high - low) / 2;

        mergeSort(array, low , mid);
        mergeSort(array, mid + 1 , high);

        merge(array, low, mid,high);

        return array;
    }

    private static void merge(int[] array, int low, int mid, int high){ //O(nlogn)
        int[] temp = new int[high - low + 1];

        int count = 0;
        int leftStart = low;
        int rightStart = mid + 1;

        while(leftStart <= mid && rightStart <= high){
            if(array[leftStart] <= array[rightStart]){
                temp[count] = array[leftStart];
                count++;
                leftStart++;
            }
            else{
                temp[count] = array[rightStart];
                count++;
                rightStart++;
            }
        }

        while(leftStart <= mid){
            temp[count] = array[leftStart];
            count++;
            leftStart++;
        }

        while(rightStart <= high){
            temp[count] = array[rightStart];
            count++;
            rightStart++;
        }

        for(int i : temp){
            array[low] = i;
            low++;
        }

    }


    public static void main(String[] args){
        int[] array = {1,3,2,7,6,3};
        mergeSort(array,0,array.length - 1);
        for (int i : array){
            System.out.print(i + " ");
        }
    }

}
