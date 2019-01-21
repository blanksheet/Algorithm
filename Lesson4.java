package Lesson;

/**
 * Created by tianze
 * 2019/1/21 15:03
 */
public class Lesson4 {
    public static void quickSort(int[] array, int low, int high){
        if(low < high){
            int mid = partition(array, low, high);
            quickSort(array, low, mid - 1);
            quickSort(array, mid + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high){
        int key = array[low];

        while (low < high){
            while (array[high] >= key && low < high){
                high--;
            }

            array[low] = array[high];

            while (array[low] <= key && low < high){
                low++;
            }

            array[high] = array[low];
        }

        array[high] = key;

        return low;
    }

    //当数组元素较少时，快速排序效率较低
    //所以当元素较少时使用插入排序，提高整体效率
    public static void quickSortOptimize(int[] array, int low, int high){
        if(high - low > 10){
            int mid = partitionOptimize(array, low, high);
            quickSortOptimize(array, low, mid - 1);
            quickSortOptimize(array, mid + 1, high);
        }
        else {
            Lesson1.insertSort(array);
        }
    }

    //三数取中优化
    private static int partitionOptimize(int[] array, int low, int high){
        int key = Math.max(array[low], Math.min(array[high], array[(high- low) / 2 + low]));

        while (low < high){
            while (array[high] >= key && low < high){
                high--;
            }

            array[low] = array[high];

            while (array[low] <= key && low < high){
                low++;
            }

            array[high] = array[low];
        }

        array[high] = key;

        return low;
    }



    public static void main(String[] args){
        int[] array = {3,4,6,1,2,6,8,4,6,12,3};
        quickSort(array, 0, array.length - 1);

        for(int i : array) {
            System.out.print(i+ " ");
        }

    }
}
