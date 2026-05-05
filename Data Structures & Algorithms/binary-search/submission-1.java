class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int medium = 0;
        while(low<=high){
            medium = low + (high-low)/2;
            if(nums[medium]==target) return medium;
            else if(nums[medium]<target) low = medium+1;
            else high = medium-1;
        }
        return -1;
    }
}
