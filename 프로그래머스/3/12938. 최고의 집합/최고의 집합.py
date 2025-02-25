def solution(n, s):
    if s // n == 0:
        return [-1]
    
    m = s // n
    answer = [m] * n
    diff = s - (m * n)
    
    for i in range(diff):
        answer[i] += 1
        
    answer.reverse()
    
    return answer