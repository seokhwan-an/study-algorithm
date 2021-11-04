def solution(n):
    answer = 0
    if n == 1:
        answer = 1
    else:
        for i in range(1,n//2+1):
            data = i
            for j in range(i+1,n//2+2):
                data += j
                if data < n:
                    continue
                elif data == n:
                    answer += 1
                else:
                    break
    answer += 1
    return answer