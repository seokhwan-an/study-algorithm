def solution(numbers):
    number = [0,1,2,3,4,5,6,7,8,9]
    answer = 0
    for i in number:
        if i in numbers:
            continue
        else:
            answer += i
    if answer == 0:
        answer = -1
    return answer