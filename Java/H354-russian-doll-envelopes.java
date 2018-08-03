class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, Comparator.comparing((int[] arr) -> arr[1]).reversed());
        Arrays.sort(envelopes, Comparator.comparing((int[] arr) -> arr[0]));
        int[] incresingArray = new int[envelopes.length];
        int len = 0;
        for (int[] env: envelopes) {
            int i = Arrays.binarySearch(incresingArray, 0, len, env[1]);
            if (i < 0) i = -(i + 1);
            incresingArray[i] = env[1];
            if(i == len) len++;
        }
        return len;
    }
}