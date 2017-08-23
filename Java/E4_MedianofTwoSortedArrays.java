class Solution {
    public double findMedianSortedArrays(int[] A, int[] B) {
	    int m = A.length, n = B.length;
	    int l = (m + n + 1) / 2;
	    int r = (m + n + 2) / 2;
	    return (getkth(A, B, 0, 0, l) + getkth(A, B, 0, 0, r)) / 2.0;
	}

    public double getkth(int[] A, int[] B, int aLeft, int bLeft, int k) {
        if (aLeft > A.length - 1) return B[bLeft + k - 1];            
        if (bLeft > B.length - 1) return A[aLeft + k - 1];                
        if (k == 1) return Math.min(A[aLeft], B[bLeft]);

        int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
        if (aLeft + k/2 - 1 < A.length) aMid = A[aLeft + k/2 - 1]; 
        if (bLeft + k/2 - 1 < B.length) bMid = B[bLeft + k/2 - 1];        

        if (aMid < bMid) 
            return getkth(A, B, aLeft + k/2, bLeft, k - k/2);
        else 
            return getkth(A, B, aLeft, bLeft + k/2, k - k/2);
    }
}