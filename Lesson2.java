/**
 * Created by tianze
 * 2018/12/19 14:36
 */
public class Lesson2 {
    public static int binarySearch(int[] array, int target){  //O(logn)
        if(array == null || array.length == 0){
            return Integer.MIN_VALUE;
        }

        int left = 0;
        int right = array.length - 1;

        while (left <= right){
            int mid = left + (right - left) /2;
            if(array[mid] == target){
                return mid;
            }
            else if(array[mid] > target){
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        return Integer.MIN_VALUE;
    }

    public static double powerANumber(int x, int n){
        boolean isNegative = false;

        if(n == 0 && x != 0){
            return 1;
        }
        if(n == 1){
            return x;
        }

        if(x == 0 && n <=0){
            System.out.println("求倒数出错");
        }
        if(x == 0 && n > 0){
            return 0;
        }

        if(n < 0){              //负数次幂
            isNegative = true;
            n = -n;
        }

        double result = powerANumber(x,n>>1);
        result *= result;

        if((n & 1) == 1){       //奇数次幂
            result *= x;
        }

        return isNegative ? 1 / result : result;
    }

    public static int fibonacci(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }

        int nminus2 = 0;
        int nminus1 = 1;

        for(int i = 2; i < n; i++){
            int temp = nminus1;
            nminus1 = nminus1 + nminus2;
            nminus2 = temp;
        }

        return nminus1 + nminus2;
    }

    public static void main(String[] args){
        int[] array = {2,4,6,7,8,9,10};
        System.out.println(binarySearch(array, 5));
        System.out.println(binarySearch(array, 6));

        System.out.println(powerANumber(2,-3));

        System.out.println(fibonacci(6));
    }
}
