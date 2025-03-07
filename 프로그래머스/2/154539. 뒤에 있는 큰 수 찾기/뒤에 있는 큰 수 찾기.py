# stack 이용하는 문제
# stack의 peek보다 작은 수가 들어오면 stack에 원소 추가
# stack의 peek보다 큰 수가 들어오면 stack의 내부가 더 큰 수가 있을 때까지 stack에서 원소를 빼고 새로운 원소 추가
# 반복문이 끝나면 남은 stack을 돌면서 인덱스에 -1 넣기

def solution(numbers):
    answer = [-1] * len(numbers)
    
    stack = []
    
    for i in range(len(numbers)):
        n = numbers[i]
        if len(stack) == 0:
            stack.append([n, i])
            continue
        
        while len(stack) > 0 and stack[-1][0] < n:
            pn, idx = stack.pop()
            answer[idx] = n
        
        stack.append([n, i])
    
    return answer