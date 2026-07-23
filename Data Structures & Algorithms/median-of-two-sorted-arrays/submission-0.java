class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[] nums3 = new int[n+m];
        int i = 0;
        for(int j = 0; j < n; j++){
            nums3[i++] = nums1[j];
        }
        for(int j = 0; j < m; j++){
            nums3[i++] = nums2[j];
        }
        Arrays.sort(nums3);
        int nlen = nums3.length;
        double median = 0.0;
        if(nlen % 2 == 0){
            median = (double)(nums3[nlen/2] + nums3[(nlen - 1)/2])/2;
        }
        else{
            median = (double)nums3[nlen/2];
        }
        return median;
        
    }
}
