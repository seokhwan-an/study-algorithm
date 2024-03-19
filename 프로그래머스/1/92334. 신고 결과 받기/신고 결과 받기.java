import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Map<String, Integer> memberInfo = initMemberInfo(id_list);
        Map<String, Integer> reportCnt = initReportCntMap(id_list);
        List<String> reportInfos = deleteDuplicate(report);
        
        for (String reportInfo : reportInfos) {
            String[] detail = reportInfo.split(" ");
            String reportedMember = detail[1];
            reportCnt.put(reportedMember, reportCnt.get(reportedMember) + 1);
        }
        
        for (String reportInfo : reportInfos) {
            String[] detail = reportInfo.split(" ");
            String reportingMemeber = detail[0];
            String reportedMember = detail[1];
            
            int cnt = reportCnt.get(reportedMember);
            
            if (cnt >= k) {
                answer[memberInfo.get(reportingMemeber)] += 1;
            }
        }
        
        return answer;
    }
    
    private Map<String, Integer> initMemberInfo(String[] id_list) {
        Map<String, Integer> memberInfo = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            memberInfo.put(id_list[i], i);
        }
        
        return memberInfo;
    }
    
    
    private Map<String, Integer> initReportCntMap(String[] id_list) {
        Map<String, Integer> reportCnt = new HashMap<>();
        for (String id : id_list) {
            reportCnt.put(id, 0);
        }
        
        return reportCnt;
    }
    
    private List<String> deleteDuplicate(String[] report) {
        Set<String> set = new HashSet<>(Arrays.asList(report));
        return new ArrayList<>(set);
    }
}