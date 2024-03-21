import java.util.*;

    
// 단품 -> 코스요리로 변경한다 (이전에 손님들이 주문할 때 가장 많이 함께 주문한 단품메뉴들)
// 코스요리 메뉴는 최소 2개 
// 코스요리 후보는 최소 2명 이상의 손님으로부터 단품메뉴 조합에 대해서

class Solution {
    
    class Course {
        String menu;
        int cnt;
        
        public Course (String menu, int cnt) {
            this.menu = menu;
            this.cnt = cnt;
        }
    }
    
    static List<String> menus;
    static boolean[] visited;
    static List<Course> courses;
    static List<String> hotCourse;
    
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};

        menus = getSingleMenu(orders);
        visited = new boolean[menus.size()];
        hotCourse = new ArrayList<>();
        
        for (int n : course) {
            courses = new ArrayList<>();
            findCourse(n, 0, -1, orders);
            addHotCourse();
        }
        
        
        return getAnswer();
    }
    
    private List<String> getSingleMenu(String[] orders) {
        Set<String> set = new HashSet();
        for (String order : orders) {
            String[] singles = order.split("");
            for (String single : singles) {
                set.add(single);
            }
        }
        List<String> singleMenu = new ArrayList<>(set);
        singleMenu.sort((m1, m2) -> m1.compareTo(m2));
        return singleMenu;
    }
    
    private void findCourse(int n, int k, int index, String[] orders) {
        if (k == n) {
            String courseEntry = getCourseEntry();
            addPossibleCourse(orders, courseEntry);
            return;
        }
        
        for (int i = 0; i < menus.size(); i++) {
            if (!visited[i] && i > index) {
                visited[i] = true;
                findCourse(n, k + 1, i, orders);
                visited[i] = false;
            }
        }
    }
    
    private String getCourseEntry() {
        StringBuilder br = new StringBuilder();
        for (int i = 0; i < menus.size(); i++) {
            if (visited[i]) {
                br.append(menus.get(i));
            }
        }
        return br.toString();
    }
    
    private void addPossibleCourse(String[] orders, String course) {
        int cnt = 0;
        String[] single = course.split("");
        for (String order : orders) {
            boolean possible = true;
            for (String menu : single) {
                if (!order.contains(menu)) {
                    possible = false;
                    break;
                }
            }
            
            if (possible) {
                cnt++;
            }
        }
        if (cnt >= 2) {
            courses.add(new Course(course, cnt));
        }
    }
    
    private void addHotCourse() {
        int orderCnt = 0;
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).cnt > orderCnt) {
                orderCnt = courses.get(i).cnt;
            }
        }
        
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).cnt == orderCnt) {
                hotCourse.add(courses.get(i).menu);
            }
        }
    }
    
    private String[] getAnswer() {
        hotCourse.sort((m1, m2) -> m1.compareTo(m2));
        
        String[] answer = new String[hotCourse.size()];
        
        for (int i = 0; i < hotCourse.size(); i++) {
            answer[i] = hotCourse.get(i);
        }
        
        return answer;
    }
}