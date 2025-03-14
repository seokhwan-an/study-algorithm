import sys

n, k = map(int, sys.stdin.readline().split())
nation = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

nation.sort(key = lambda x : (-x[1], -x[2], -x[3]))

rank = 1
count = 0
pre = nation[0][1:]

answer = 0
for i in range(0, n):
    nexts = nation[i][1:]
    idx = nation[i][0]

    if k == idx:
        if pre == nexts:
            answer = rank
        else:
            answer = rank + count
        break

    if pre == nexts:
        count += 1
    else:
        pre = nexts
        rank += count
        count = 0


print(answer)