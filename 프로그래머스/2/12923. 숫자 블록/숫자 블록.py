# O(N) 방식으로 풀기에는 현재 n이 10억이어서 불가능


import math

def solution(begin, end):
    answer = [0] * (end - begin + 1)
    for i in range(begin, end + 1):
        available = False
        if isPrime(i):
            answer[i - begin] = 1
            continue
     
        available = False
        for j in range(2, int(math.sqrt(i)) + 1):
            if i % j == 0:
                answer[i - begin] = j
                available = True
                if i // j <= 10000000:
                    answer[i - begin] = i // j
                    break
        if i != 1 and not available:
            answer[i - begin] = 1
            
                
    return answer

def isPrime(num):
    if num == 1:
        return False
    
    for i in range(2, min(int(math.sqrt(num)) + 1, 10000001)):
        if num % i == 0:
            return False
        
    return True
    