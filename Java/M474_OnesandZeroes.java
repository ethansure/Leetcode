class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for(String str : strs){
            int oneCount= 0;
            int zeroCount = 0;
            for(char c : str.toCharArray()){
                if(c == '1')
                    oneCount++;
                else
                    zeroCount++;
            }
            for(int i = m; i >= zeroCount; i--){
                for(int j = n; j >= oneCount; j--){
                    if(oneCount <= j && zeroCount <= i)
                        dp[i][j] = Math.max(dp[i][j],dp[i - zeroCount][j - oneCount] + 1);
                }
            }
        }
        return dp[m][n];
    }
}