import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2108 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i < N; i++){
            arr.add(Integer.parseInt(br.readLine()));
        }
        //정렬
        Collections.sort(arr);
        average(arr);
        median(arr);
        mode(arr);
        range(arr);
    }

    //산술평균
    public static void average(ArrayList<Integer> arr){
        int sum = 0;
        for(int i = 0; i < arr.size(); i++){
            sum += arr.get(i);
        }
        System.out.println((int)Math.round((double)sum / N));

    }
    //중앙값
    public static void median(ArrayList<Integer> arr){
        int check = arr.size()/2 + 1;
        if(arr.size() == 1){
            System.out.println(arr.get(0));
        }
        else{
            System.out.println(arr.get(check-1));
        }
    }
    //최빈값
    public static void mode(ArrayList<Integer> arr){
        Map<Integer, Integer> check  = new HashMap();
        for(int i = 0; i < arr.size(); i++){
            if(check.keySet().contains(arr.get(i))){
                check.put(arr.get(i),check.get(arr.get(i))+1);
            }
            else{
                check.put(arr.get(i), 1);
            }
        }
        List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(check.entrySet());
        entryList.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        int pre = 4001;
        ArrayList<Integer> num = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry: entryList){
            if(pre == 4001){
                pre = entry.getValue();
                num.add(entry.getKey());
            }
            else{
                if(entry.getValue() == pre){
                    num.add(entry.getKey());
                }
                else if(entry.getValue() < pre) break;
            }
        }
        Collections.sort(num);
        if(num.size() > 1){
            System.out.println(num.get(1));
        }
        else{
            System.out.println(num.get(0));
        }
    }

    //범위
    public static void range(ArrayList<Integer> arr){
        if(arr.size() == 1){
            System.out.println(0);
        }
        else{
            System.out.println(arr.get(arr.size()-1) - arr.get(0));
        }
    }
}
