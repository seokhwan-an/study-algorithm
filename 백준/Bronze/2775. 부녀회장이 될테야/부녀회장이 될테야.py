import sys

t = int(sys.stdin.readline())

answers = []

apart = [[0] * 15 for _ in range(15)]

# 층
for i in range(15):
    if i == 0:
        for j in range(15):
            apart[i][j] = j
    # 1층 이상에 대해서
    else:
        # 호수에 대해서
        for j in range(15):
            count = 0
            for k in range(j + 1):
                count += apart[i - 1][k]

            apart[i][j] = count

answers = []
for _ in range(t):
    k = int(sys.stdin.readline())
    n = int(sys.stdin.readline())
    answers.append(apart[k][n])

print("\n".join(map(str, answers)))
