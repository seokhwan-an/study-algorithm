def solution(arr):
    answer = []
    answer.append(arr[0])
    pre = arr[0]
    for i in range(1, len(arr)):
        next = arr[i]
        if pre == next:
            continue
        answer.append(next)
        pre = next
    
    return answer