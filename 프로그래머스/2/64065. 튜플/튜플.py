# 튜플의 표현을 통해 튜플을 추축하는 문제

# 튜플의 길이로 정렬
# 튜플의 반복문을 돌면서 answer에 없는 원소를 넣기
def solution(s):
    answer = []
    tuples = changeTuple(s)
    tuples = sorted(tuples, key = lambda x: (len(x)))
    
    for tp in tuples:
        for number in tp:
            number = int(number)
            if number not in answer:
                answer.append(number)
    
    return answer

def changeTuple(s):
    s = s[1:-1]
    index = 0
    tuples = []
    while index < len(s):
        n = s[index]
        if n == "{":
            check = []
            number = ""
            while n != "}":
                if n.isdigit():
                    number += n
                elif n == ",":
                    check.append(number)
                    number = ""
                index += 1
                n = s[index]
            check.append(number)
            tuples.append(check)
        else:
            index += 1
    
    return tuples