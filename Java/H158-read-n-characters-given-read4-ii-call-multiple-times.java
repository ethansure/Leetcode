/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int buffIndex = 0;
    public int sourceBuffCount = 0;
    public char[] sourceBuf = new char[4];
    
    public int read(char[] buf, int n) {
        int count = 0;
        while(count < n) {
            if (buffIndex == 0) {
                sourceBuffCount = read4(sourceBuf);
            }
            if (sourceBuffCount == 0) break;
            while(count < n && buffIndex < sourceBuffCount) {
                buf[count++] = sourceBuf[buffIndex++];
            }
            if(buffIndex == sourceBuffCount) {
                buffIndex = 0;
            }
        }
        return count;
    }
}