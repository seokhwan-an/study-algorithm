import sys

t = int(sys.stdin.readline())

answers = []

for _ in range(t):
    n = int(sys.stdin.readline())
    answer = n
    people = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
    people.sort()
    small = people[0][1]
    for i in range(n):
        if people[i][1] > small:
            answer -= 1
        else:
            small = people[i][1]
    answers.append(answer)

print("\n".join(map(str, answers)))
