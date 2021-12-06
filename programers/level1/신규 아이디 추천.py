def solution(new_id):
    answer = ''
    for i in range(len(new_id)): # 1단계 2단계 해결
        if new_id[i].isalpha() or new_id[i].isdigit() or new_id[i] == "-" or new_id[i] == "_" or new_id[i] == ".":
            if  new_id[i].isalpha():
                if new_id[i].isupper:   
                    answer += new_id[i].lower()
            else:
                answer += new_id[i]
        else:
            continue
    # 3단계 해결
    check = []
    for i in range(0,len(answer)-1):
        if answer[i] == ".":
            if answer[i+1] == ".":
                check.append(i)
    print(check)
    count = 0
    for i in check:
        answer = answer[0:i-count] + answer[i+1-count:]
        count += 1
    # 4단계 해결(1)
    while True:
        if len(answer) == 0:
            break
        if answer[0] == ".": 
            answer = answer[1:]
            continue
        else:
            break
    if answer[-1] == ".":
        answer = answer[:-1]
    # 5단계 해결
    if len(answer) == 0:
        answer += 'a'
    # 6단계 해결
    if len(answer) >= 16:
        answer = answer[0:16]
    # 7단계 해결
    while len(answer) <= 2:
        answer = answer + answer[-1]
    if answer[-1] == ".":
        answer = answer[:-2]
    return answer

new_id = "=.="
print(solution(new_id))