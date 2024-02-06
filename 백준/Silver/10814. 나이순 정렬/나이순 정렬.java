import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        HashMap<Integer, ArrayList<String>> people = new HashMap<Integer, ArrayList<String>>();
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            if(people.keySet().contains(age)) people.get(age).add(name);
            else{
                people.put(age, new ArrayList<String>());
                people.get(age).add(name);
            }
        }
        Object[] ages = people.keySet().toArray();
        Arrays.sort(ages);
        for(Object key : ages){
            for(int j = 0; j < people.get(key).size(); j++){
                System.out.println(key+" "+people.get(key).get(j));
            }
        }
    }
}