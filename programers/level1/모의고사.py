def solution(answers):
    one = [1,2,3,4,5]
    two = [2,1,2,3,2,4,2,5] 
    three = [3,3,1,1,2,2,4,4,5,5]
    test = [0,0,0,0]
    count = [0,0,0]
    answer = []
    for i in range(len(answers)):
        if one[test[1]] == answers[i]:
            count[0] += 1
        if two[test[2]] == answers[i]:
            count[1] += 1
        if three[test[3]] == answers[i]:
            count[2] += 1
        test[1] = (test[1] + 1) % len(one)
        test[2] = (test[2] + 1) % len(two)
        test[3] = (test[3] + 1) % len(three)
    standard = count[0]
    answer.append(1)
    for i in range(1,3):
        if count[i] > standard:
            answer = []
            answer.append(i+1)
            standard = count[i]
        elif count[i] == standard:
            answer.append(i+1)
        else:
            continue
    return answer