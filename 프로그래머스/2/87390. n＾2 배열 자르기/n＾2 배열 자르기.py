def solution(n, left, right):
    answer = []  
    
    while left <= right:
        x = left // n
        y = left % n  
        if y < x + 1:
            answer.append(x + 1)
        else:
            answer.append(y + 1)
        
        left += 1
    
    return answer