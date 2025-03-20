import sys

n = int(sys.stdin.readline())
people = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

people.sort(key = lambda x : (x[0]))

start = people[0][0]
end = people[n - 1][0]
answer = 0
maxProfit = -1
for pay in range(start, end + 1):
    profit = 0
    for b, v in people:
        if b < pay or pay - v < 0:
            continue

        profit += pay - v

    if profit > 0 and profit > maxProfit:
        answer = pay
        maxProfit = profit

print(answer)