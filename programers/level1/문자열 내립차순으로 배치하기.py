def solution(s):
    answer = ''
    data = sorted(s)
    for i in range(len(data)-1,-1,-1):
        if data[i].islower():
            answer += data[i]
    
    for i in range(len(data)-1,-1,-1):
        if data[i].isupper():
            answer += data[i]
    return answer