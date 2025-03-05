# n을 k 진수로 변경한다.
# 0을 기준으로 문자열을 split한다.
# 각 원소에 대해서 소수 검증을 한다.

import math

def solution(n, k):
    answer = 0
    change = changeToNumber(n, k)
    
    for num in change.split("0"):
        if num.isdigit() and "0" not in num:
            if isPrime(int(num)):
                answer += 1
            
    return answer

def changeToNumber(n, k):
    numbers = []
    
    while n // k != 0:
        numbers.append(n % k)
        n = n // k
    numbers.append(n)
    
    numbers.reverse()
    return "".join(map(str, numbers))

def isPrime(num):
    if num == 1:
        return False
    
    for i in range(2, int(math.sqrt(num)) + 1):
        if num % i == 0:
            return False
    return True