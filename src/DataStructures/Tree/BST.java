class Solution {
    public int search(int[] nums, int target) {
        int high = nums.length-1;
        int middle, low = 0;        
        while (low <= high){
            middle = low + (high - low)/2;
            if (nums[middle] == target){
                return middle;
            } else if (nums[middle] < target){
                low = middle + 1;
            } else {
                high = middle - 1;
            }            
        }
        return -1;
    }
}