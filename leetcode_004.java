class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 > len2) {
            int[] temp = nums1; nums1 = nums2; nums2 = temp;
            int temp1 = len1; len1 = len2; len2 = temp1;
        }
        int iMin = 0, iMax = len1, midlen = (len1 + len2 + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = midlen - i;
            if (i < iMax && nums1[i] < nums2[j - 1]) {
                iMin++;
            } else if (i >iMin && nums1[i - 1] > nums2[j]) {
                iMax--;
            } else {
                int leftMax = 0;
                if (i == 0) {leftMax = nums2[j - 1];}
                else if (j == 0) {leftMax = nums1[i - 1];}
                else {leftMax = Math.max(nums1[i - 1], nums2[j - 1]);}
                if ((len1 + len2) % 2 == 1) {return leftMax;}
                
                int rightMin = 0;
                if (i == len1) {rightMin = nums2[j];}
                else if (j == len2) {rightMin = nums1[i];}
                else {rightMin = Math.min(nums1[i], nums2[j]);}
                return (leftMax + rightMin) / 2.0;
            }
        }
        return 0.0;
    }
}