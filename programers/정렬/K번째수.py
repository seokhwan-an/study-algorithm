def solution(array, commands):
    answer = []
    for a in commands:
        data = array
        i,j,k = a[0],a[1],a[2]
        data = data[i-1:j]
        data.sort()
        answer.append(data[k-1])
    return answer