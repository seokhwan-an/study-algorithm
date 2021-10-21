def solution(n):
    answer = 0
    num = n
    data = []
    if num < 3:
        data.append(num)
    else:
        while num >= 3:
            data.append(num%3)
            num = num //3
        data.append(num)
    cnt = 0
    for i in range(len(data)-1,-1,-1):
        answer += data[i]*(3**cnt)
        cnt += 1
    return answer