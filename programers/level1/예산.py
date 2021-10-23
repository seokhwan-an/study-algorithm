def solution(d, budget):
    data = [0]
    d.sort()
    answer = 0
    for i in range(len(d)):
        data.append(d[i])
        if sum(data) <= budget:
            answer += 1
        else:
            break
    return answer