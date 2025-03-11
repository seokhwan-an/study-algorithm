import sys

n, m = map(int, sys.stdin.readline().split())
lans = [int(sys.stdin.readline()) for _ in range(n)]

start = 1
end = max(lans)

while start <= end:
    target = (start + end) // 2

    count = 0
    for lan in lans:
        count += lan // target

    if count >= m:
        start = target + 1
    else:
        end = target - 1

print(end)
