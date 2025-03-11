def solution(n, k):
    answer = []
    visited = [0] * (n + 1)
    
    count = 1
    
    while count <= n:
        cases = getAllCount(n - count)
        case = 0 
        num = 1
        for i in range(1, n + 1):
            if visited[i] == 1:
                continue
            case += cases
            num = i
            if case >= k:
                k -= case - cases
                break
        answer.append(num)
        visited[num] = 1
        count += 1
    return answer

def getAllCount(n):
    mul = 1
    for i in range(1, n + 1):
        mul *= i
        
    return mul