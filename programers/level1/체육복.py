def solution(n, lost, reserve):
    answer = n
    count = 0
    have = set(reserve) - set(lost)
    not_have = set(lost) - set(reserve)
    for i in not_have:
        if i-1 in have:
            have.remove(i-1)           
        elif i+1 in have:
            have.remove(i+1)
        else:
            answer -= 1
    return answer