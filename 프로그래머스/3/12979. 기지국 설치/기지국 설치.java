class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int propagation = w * 2 + 1;
        
        int preWidth = stations[0] -w -1;
        if (preWidth >= 1 && preWidth % propagation != 0) {
            answer += preWidth / propagation + 1;
        } else if(preWidth >= 1 && preWidth % propagation  == 0) {
            answer += preWidth / propagation;
        }
        
        for (int i = 0; i <= stations.length - 2; i++) {  
            int preStation = stations[i];
            int nextStation = stations[i + 1];
            
            int middleWidth = nextStation - preStation - 2 * w - 1;
            if (middleWidth >= 1 && middleWidth % propagation != 0) {
                answer += middleWidth / propagation + 1;
            } else if(middleWidth >= 1 && middleWidth % propagation  == 0) {
                answer += middleWidth / propagation;
            }
        }
        
        
        int lastWidth = n - stations[stations.length - 1] - w;
        if (lastWidth >= 1 && lastWidth % propagation != 0) {
            answer += lastWidth / propagation + 1;
        } else if(lastWidth >= 1 && lastWidth % propagation  == 0) {
            answer += lastWidth / propagation;
        }

        return answer;
    }
}