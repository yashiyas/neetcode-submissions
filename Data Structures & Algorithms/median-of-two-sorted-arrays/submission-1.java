class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {


        if(nums1.length < nums2.length){
            return findPartition(nums1, nums2);
        } else{
            return findPartition(nums2, nums1);
        }


    }

    private double findPartition(int[] nums1, int[] nums2){
        int n1 = nums1.length;
        int n2 = nums2.length;
        int total = n1+n2;
        int req = (total+1)/2;

        int low = 0;
        int high = n1;

        int nums1L;
        int nums2L;
        int nums1R;
        int nums2R;
        int partition1;
        int partition2;

        while(low <= high && low >=0 && high <= n1){
            int mid = low + (high-low)/2;
            partition1 = mid;
            partition2 = req-mid;
            nums1L = partition1-1;
            nums2L = partition2 - 1;
            nums1R = partition1;
            nums2R = partition2;

            int nums1LValue = nums1L < 0 ? Integer.MIN_VALUE : nums1[nums1L];
            int nums2LValue = nums2L < 0? Integer.MIN_VALUE : nums2[nums2L];
            int nums1RValue = nums1R >= n1 ? Integer.MAX_VALUE : nums1[nums1R];
            int nums2RValue = nums2R >= n2 ? Integer.MAX_VALUE : nums2[nums2R];

            if(nums1LValue <= nums2RValue && nums2LValue <= nums1RValue){
                if(total%2 != 0){
                    return Math.max(nums1LValue, nums2LValue);
                } else{
                    return ((double) Math.min(nums1RValue, nums2RValue) + Math.max(nums2LValue, nums1LValue)) / 2;
                }
            }
            else if(nums1LValue > nums2RValue){
                high = mid-1;
            } else{
                low = mid+1;
            }
            
        }

            return -1;
    }

    

}
