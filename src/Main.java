import java.util.Arrays;

public class Main {
    public static void mergeSort(int[] nums){
        if(nums == null) {
            return;
        }

        if(nums.length > 1){
            int mid = nums.length / 2;
            int[] left = new int[mid];
            for(int i = 0; i < mid; i++) {
                left[i] = nums[i];
            }

            int[] right = new int[nums.length - mid];
            for(int i = mid; i < nums.length; i++){
                right[i - mid] = nums[i];
            }

            mergeSort(left);
            mergeSort(right);

            int l = 0;
            int r = 0;
            int m = 0;

            while(l < left.length && r < right.length){
                if(left[l] < right[r]){
                    nums[m] = left[l];
                    l++;
                } else {
                    nums[m] = right[r];
                    r++;
                }
                m++;
            }
            while(l < left.length){
                nums[m] = left[l];
                l++;
                m++;
            }
            while(r < right.length){
                nums[m] = right[r];
                r++;
                m++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {12, 11, 13, 14, 15, 1, 25, 6, 10, 99, 100, 1};
        System.out.println("Sorting... " + Arrays.toString(nums));
        mergeSort(nums);
        System.out.println("Sorted... " + Arrays.toString(nums));
    }
}
