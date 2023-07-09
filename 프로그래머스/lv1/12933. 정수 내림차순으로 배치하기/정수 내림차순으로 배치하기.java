import java.util.*;
class Solution {
    public long solution(long n) {
        StringBuilder sb = new StringBuilder();
        char[] num = sb.append(n).toString().toCharArray();
        Arrays.sort(num);
        sb.setLength(0);
        return Long.parseLong(sb.append(num).reverse().toString());
    }
}