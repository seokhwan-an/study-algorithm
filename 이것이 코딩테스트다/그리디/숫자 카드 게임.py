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

# 책에서 알려주는 풀이
n, m = map(int,input().split())
result = 0
for i in range(n):
    data = list(map(int,input().split()))
    min_value = min(data)
    result = max(result,min_value)

print(result)