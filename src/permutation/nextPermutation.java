package permutation;

public class nextPermutation {
    public void nextPerm(int[] nums) {
        // find the number which is less than it's next number in the array from right
        // let's say the number is at ith place
        // find the number which is greater than nums_i from right.. so u will find just one great number
        //swap num_i and the great number
        // reverse i+1 part
        int i=nums.length-2;
        while(i > 0 && nums[i] >= nums[i+1]) {
            i--;
        }

        if(i >= 0) {
            int j=nums.length-1;
            while(nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i+1);
    }

    public void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
