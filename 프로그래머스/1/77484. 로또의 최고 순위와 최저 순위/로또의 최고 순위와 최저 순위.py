def solution(lottos, win_nums):
    answer = []
    table = {k:v for (k,v) in zip(list(range(6, 1, - 1)), list(range(1, 6)))}
    zeroCount = 0
    
    for l in lottos:
        if l == 0:
            zeroCount += 1
    match = 0
    for l in lottos:
        if l in win_nums:
            match += 1
    
    worst = 0
    best = 0
    if zeroCount == 6:
        worst = 0
        best = 6
    else:
        worst = match
        best = match + zeroCount
               
    worst = table[worst] if worst in table else 6
    best = table[best] if best in table else 6
    answer = [best, worst]
    return answer