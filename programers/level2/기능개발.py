def solution(progresses, speeds):
    a = progresses
    b = speeds
    cnt = 0
    answer = []
    while True:
        if len(a) == 0:
            break
        else:
            for i in range(len(a)):
                a[i] += b[i]
            if a[0] < 100:
                continue
            while a[0] >= 100:
                cnt += 1
                a.pop(0)
                b.pop(0)
                if len(a) == 0:
                    break
            answer.append(cnt)
            cnt = 0
                
    return answer