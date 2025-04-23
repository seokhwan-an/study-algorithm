// 이분탐색으로 해결해야하는 문제
import java.util.Arrays;
import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        
        Arrays.sort(weights);
        for (int i = 0; i < weights.length; i++) {
            int check = weights[i];
            List<Integer> targets = makeTarget(check);
            for (int t : targets) {
                int leftIndex = binarySearchLower(t, weights);
                if (leftIndex <= i) {
                    leftIndex = i + 1;
                }
                int rightIndex = binarySearchUpper(t, weights);
                
                if (leftIndex > rightIndex) {
                    continue;
                }
                
                if (weights[leftIndex] == t && weights[rightIndex] == t) {
                    answer += rightIndex - leftIndex + 1;
                }
            }
        }        
            
        return answer;
    }
    
    public List<Integer> makeTarget(int check) {
        List<Integer> target = new ArrayList<>();
        target.add(check);
        target.add(check * 2);
        if (check % 2 == 0) {
            target.add(check / 2 * 3);
        } 
        
        if (check % 3 == 0) {
            target.add(check / 3 * 4);
        }
        
        return target;
    }
    
    
    public int binarySearchLower(int target, int[] weights) {
        int start = 0;
        int end = weights.length - 1;
        
        while (start <= end) {
            int mid = (start + end) / 2;
            int number = weights[mid];
            
            if (number >= target) {
                end = mid - 1;
            } else if (number < target) {
                start = mid + 1;
            }
        }
        
        return start;
    } 
    
    public int binarySearchUpper(int target, int[] weights) {
        int start = 0;
        int end = weights.length - 1;
        
        while (start <= end) {
            int mid = (start + end) / 2;
            int number = weights[mid];
            
            if (number <= target) {
                start = mid + 1;
            } else if (number > target) {
                end = mid - 1;
            }
        }
        
        return end;
    }
}