import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;
        int location = n;
        
        while(location != 0) {
            if (location % 2 == 1) {
                ans++;
            }
            location /= 2;
        }
        
        return ans;
    }
}