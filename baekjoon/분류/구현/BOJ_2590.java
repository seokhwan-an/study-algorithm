import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2590 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] color_paper = new int[7];
        int answer = 0;
        for(int i = 1; i < 7; i++){
            color_paper[i] = Integer.parseInt(br.readLine());
        }
        for(int i = 6; i >= 1; i--){
            // 색종이 크기가 6인 경우
            if(i == 6){
                answer += color_paper[6];
            }
            // 색종이 크키가 5인 경우
            else if(i == 5){
                answer += color_paper[5];
                if(color_paper[1] >= 11 * color_paper[5]){
                    color_paper[1] = color_paper[1] - 11 * color_paper[5];
                }
                else{
                    color_paper[1] = 0;
                }
            }
            // 색종이 크키가 4인 경우
            else if(i == 4){
                answer += color_paper[4];
                if(color_paper[2] >= 5 * color_paper[4]){
                    color_paper[2] = color_paper[2] - 5 * color_paper[4];
                }
                else {
                    if(color_paper[1] >=  color_paper[4] * 20 - color_paper[2] * 4){
                        color_paper[1] = color_paper[1] - (color_paper[4] * 20 - color_paper[2] * 4);
                    }
                    else{
                        color_paper[1] = 0;
                    }
                    color_paper[2] = 0;
                }
            }
            // 색종이 크키가 3인 경우
            else if(i == 3){
                if(color_paper[3] >= 4){
                    answer += color_paper[3] / 4;
                    if(color_paper[3] % 4 == 3){
                        answer += 1;
                        if(color_paper[2] >= 1){
                            color_paper[2]  = color_paper[2] - 1;
                            if(color_paper[1] >= 5){
                                color_paper[1] = color_paper[1] - 5;
                            }
                            else {
                                color_paper[1] = 0;
                            }
                        }
                        else{
                            if(color_paper[1] >= 9){
                                color_paper[1] = color_paper[1] - 9;
                            }
                            else{
                                color_paper[1] = 0;
                            }
                            color_paper[2] = 0;
                        }
                    }
                    if(color_paper[3] % 4 == 2){
                        answer += 1;
                        if(color_paper[2] >= 3){
                            color_paper[2]  = color_paper[2] - 3;
                            if(color_paper[1] >= 6){
                                color_paper[1] = color_paper[1]- 6;
                            }
                            else{
                                color_paper[1] = 0;
                            }
                        }
                        else if (color_paper[2] >= 2){
                            color_paper[2]  = color_paper[2] - 2;
                            if(color_paper[1] >= 10 ){
                                color_paper[1] = color_paper[1] - 10;
                            }
                            else {
                                color_paper[1] = 0;
                            }
                        }
                        else{
                            if(color_paper[1] >= 18 - color_paper[2] * 4){
                                color_paper[1] = color_paper[1] - ( 18 - color_paper[2] * 4);
                            }
                            else{
                                color_paper[1] = 0;
                            }
                            color_paper[2] = 0;
                        }
                    }
                    if(color_paper[3] % 4 == 1){
                        answer += 1;
                        if(color_paper[2] >= 4){
                            color_paper[2]  = color_paper[2] - 4;
                            if(color_paper[1] >= 11){
                                color_paper[1] = color_paper[1] - 11;
                            }
                            else {
                                color_paper[1] = 0;
                            }
                        }
                        else if(color_paper[2] >= 3){
                            color_paper[2] = color_paper[2] - 3;
                            if(color_paper[1] >= 15){
                                color_paper[1] = color_paper[1] -15;
                            }
                            else{
                                color_paper[1] = 0;
                            }
                        }
                        else if(color_paper[2] >= 2){
                            if(color_paper[1] >= 19){
                                color_paper[1] = color_paper[1] - 19;
                            }
                            else{
                                color_paper[1] = 0;
                            }
                        }
                        else if(color_paper[2] >= 1){
                            if(color_paper[1] >= 23){
                                color_paper[1] = color_paper[1] -23;
                            }
                            else{
                                color_paper[1] = 0;
                            }
                        }
                        else{
                            if(color_paper[1] >= 27 - color_paper[2]*4){
                                color_paper[1] = color_paper[1] - (27 - color_paper[2]*4);
                            }
                            else{
                                color_paper[1] = 0;
                            }
                            color_paper[2] = 0;
                        }
                    }
                }
                else if(color_paper[3] >= 1){
                    answer += 1;
                    if(color_paper[3] == 3){
                        if(color_paper[2] >= 1){
                            color_paper[2]  = color_paper[2] - 1;
                            if(color_paper[1] >= 5){
                                color_paper[1] = color_paper[1] - 5;
                            }
                            else{
                                color_paper[1] = 0;
                            }
                        }
                        else{
                            if(color_paper[1] >= 9){
                                color_paper[1] = color_paper[1] - 9;
                            }
                            else{
                                color_paper[1] = 0;
                            }
                            color_paper[2] = 0;
                        }
                    }
                    if(color_paper[3] == 2){
                        if(color_paper[2] >= 3){
                            color_paper[2]  = color_paper[2] - 3;
                            if(color_paper[1] >= 6){
                                color_paper[1] = color_paper[1]- 6;
                            }
                            else{
                                color_paper[1] = 0;
                            }
                        }
                        else if (color_paper[2] >= 2){
                            color_paper[2]  = color_paper[2] - 2;
                            if(color_paper[1] >= 10 ){
                                color_paper[1] = color_paper[1] - 10;
                            }
                            else {
                                color_paper[1] = 0;
                            }
                        }
                        else{
                            if(color_paper[1] >= 18 - color_paper[2] * 4){
                                color_paper[1] = color_paper[1] - ( 18 - color_paper[2] * 4);
                            }
                            else{
                                color_paper[1] = 0;
                            }
                            color_paper[2] = 0;
                        }
                    }
                    if(color_paper[3] == 1){
                        if(color_paper[2] >= 4){
                            color_paper[2]  = color_paper[2] - 4;
                            if(color_paper[1] >= 11){
                                color_paper[1] = color_paper[1] - 11;
                            }
                            else {
                                color_paper[1] = 0;
                            }
                        }
                        else if(color_paper[2] >= 3){
                            color_paper[2] = color_paper[2] - 3;
                            if(color_paper[1] >= 15){
                                color_paper[1] = color_paper[1] -15;
                            }
                            else{
                                color_paper[1] = 0;
                            }
                        }
                        else if(color_paper[2] >= 2){
                            if(color_paper[1] >= 19){
                                color_paper[1] = color_paper[1] - 19;
                            }
                            else{
                                color_paper[1] = 0;
                            }
                        }
                        else if(color_paper[2] >= 1){
                            if(color_paper[1] >= 23){
                                color_paper[1] = color_paper[1] -23;
                            }
                            else{
                                color_paper[1] = 0;
                            }
                        }
                        else{
                            if(color_paper[1] >= 27 - color_paper[2]*4){
                                color_paper[1] = color_paper[1] - (27 - color_paper[2]*4);
                            }
                            else{
                                color_paper[1] = 0;
                            }
                            color_paper[2] = 0;
                        }
                    }
                }
            }
            else if(i == 2){
                if(color_paper[2] >= 9){
                    answer += color_paper[2] / 9;
                    if(color_paper[2] % 9 > 0){
                        answer += 1;
                        if(color_paper[1] >= 36 - (color_paper[2] % 9) * 4){
                            color_paper[1] = color_paper[1] - (36 - (color_paper[2] % 9) * 4);
                        }
                        else{
                            color_paper[1] = 0;
                        }
                    }
                }
                else if(color_paper[2] >= 1){
                    answer += 1;
                    if(color_paper[1] >= 36 - 4 * (color_paper[2])){
                        color_paper[1] = color_paper[1] -(36 - 4 * (color_paper[2]));
                    }
                    else{
                        color_paper[1] = 0;
                    }
                }
            }
            else if(i == 1){
                answer += color_paper[1] / 36;
                if(color_paper[1] % 36 > 0){
                    answer += 1;
                }
            }
        }
        System.out.println(answer);
    }
}
