def solution(s):
    answer = True
    
    stack = []
    
    for type in s:
        if type == "(":
            stack.append(type)
        else:
            if len(stack) == 0:
                return False
            
            if stack[-1] == ")":
                return False
            
            stack.pop()
            
    if len(stack) > 0:
        return False
    
    return answer