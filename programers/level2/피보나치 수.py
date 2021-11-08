def solution(n):
    answer = 0
    a = 1
    b = 0
    for i in range(n-1):
        answer = a + b
        b = a
        a = answer
    answer = answer % 1234567
    return answer