# 내가 푼 풀이
n, k = map(int,input().split())
cnt = 0

while(n % k != 0):
    n = n-1
    cnt += 1
while(n != 1):
    n /= k
    cnt += 1

print(cnt)