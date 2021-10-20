# 효율성 문제에서 핵
def solution(scoville, K):
    data = scoville
    data.sort()
    answer = 0
    while data[0] < K:
        make = data[0] + data[1]*2
        data.pop(0)
        data.pop(0)
        data.append(make)
        data.sort()
        answer += 1
        if len(data) == 1:
            break
    if data[0] < K:
        answer = -1
    return answer