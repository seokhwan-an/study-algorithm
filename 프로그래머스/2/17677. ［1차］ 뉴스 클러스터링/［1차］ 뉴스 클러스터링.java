// 자카드 유사도 교집합 / 합집합
// 교집합과 합집합 모두 0 이면 1
// 다중 집합에도 적용하자
// 다중 집합은 영어로만 확인한다.

import java.util.*;

class Solution {
    
    private static int NUMBER = 65536;
    
    public int solution(String str1, String str2) {
        int answer = 0;
        
        List<String> set1 = getMultiSet(str1);
        System.out.println(set1);
        List<String> set2 = getMultiSet(str2);
        System.out.println(set2);
        
        if (set1.isEmpty() && set2.isEmpty()) {
            answer = 1;
            return answer * NUMBER;
        }
        
        List<String> intersection = getIntersectionSet(set1, set2);
        System.out.println(intersection);
        List<String> union = getUnionSet(set1, set2);
        System.out.println(union);
        
        answer =  (int) Math.floor((intersection.size() / (float) union.size()) * NUMBER); 
        System.out.println(answer);
        
        return answer;
    }
    
    private List<String> getMultiSet(String str) {
        List<String> set = new ArrayList<>();
        for (int i = 0; i < str.length() - 1; i++) {
            String unit = str.substring(i, i + 2);
            if (unit.matches("^[a-zA-Z]*$")) {
                set.add(unit.toLowerCase());
            }
        }
        
        return set;
    }
    
    private List<String> getIntersectionSet(List<String> set1, List<String> set2) {
        int cnt = 0;
        List<String> intersectionSet = new ArrayList<>();
        for (String unit : set1) {
            if (set2.contains(unit) && !intersectionSet.contains(unit)) {
                int set1UnitCnt = getUnitCount(set1, unit);
                int set2UnitCnt = getUnitCount(set2, unit);
                cnt = Math.min(set1UnitCnt, set2UnitCnt);
                
                for (int i = 0; i < cnt; i++) {
                    intersectionSet.add(unit);
                }
            }
        }
        return intersectionSet;
    }
    
    private List<String> getUnionSet(List<String> set1, List<String> set2) {
        int cnt = 0;
        List<String> unionSet = new ArrayList<>();
        for (String unit : set1) {
            if (set2.contains(unit) && !unionSet.contains(unit)) {
                int set1UnitCnt = getUnitCount(set1, unit);
                int set2UnitCnt = getUnitCount(set2, unit);
                cnt = Math.max(set1UnitCnt, set2UnitCnt);
                
                for (int i = 0; i < cnt; i++) {
                    unionSet.add(unit);
                }
            } else if (!unionSet.contains(unit)) {
                int unitCnt = getUnitCount(set1, unit);
                for (int i = 0; i < unitCnt; i++) {
                    unionSet.add(unit);
                }
            }
        }
        
        for (String unit : set2) {
            if (!unionSet.contains(unit)) {
                int unitCnt = getUnitCount(set2, unit);
                for (int i = 0; i < unitCnt; i++) {
                    unionSet.add(unit);
                }
            }
        }
        return unionSet;
    }
    
    private int getUnitCount(List<String> set, String unit) {
        int cnt = 0;
        for (String setUnit : set) {
            if (setUnit.equals(unit)) {
                cnt++;
            }
        }
        return cnt;
    }
}