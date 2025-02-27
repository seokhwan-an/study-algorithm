def solution(string):
    answer = 1000
    
    if len(string) == 1 or len(string) == 2:
        return len(string)
    
    half = len(string) // 2
    
    for i in range(1, half + 1):
        stack = []
        count = [1] * len(string)
        
        for j in range(0, len(string), i):
            slice_string = string[j : j + i]
            if len(stack) < 1:
                stack.append(slice_string)
            else:
                pre = stack.pop()
                if pre == slice_string:
                    stack.append(pre)
                    count[len(stack) - 1] += 1
                else:
                    stack.append(pre)
                    stack.append(slice_string)
                    
        # 최소 길이 구하기            
        check = 0
        for j in range(len(stack)):
            if count[j] > 1:
                check += len(str(count[j]))
            check += len(stack[j])
        answer = min(answer, check)
        
        
    return answer