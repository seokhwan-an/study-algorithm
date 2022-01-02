# 내가 푼 풀이
N, M = map(int,input().split())
data = []
for i in range(N):
    data.append(list(map(int,input().split())))
big = min(data[0])
for i in range(1,N):
    if min(data[i]) > big:
        big = min(data[i])
print(big)