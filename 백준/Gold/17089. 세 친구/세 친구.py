import sys

n, m = map(int, sys.stdin.readline().split())

graph = {}

for _ in range(m):
    s, e = map(int, sys.stdin.readline().split())

    if s in graph:
        graph[s].add(e)
    else:
        friends = set()
        friends.add(e)
        graph[s] = friends
    if e in graph:
        graph[e].add(s)
    else:
        friends = set()
        friends.add(s)
        graph[e] = friends

check = []

for i in range(1, n + 1):
    if i not in graph:
        continue
    friendsA = graph[i]
    for j in range(i + 1, n + 1):
        if j not in graph:
            continue
        friendsB = graph[j]
        if j in friendsA and i in friendsB:
            for k in range(j + 1, n + 1):
                if k not in graph:
                    continue
                friendsC = graph[k]
                if k in friendsA and k in friendsB and i in friendsC and j in friendsC:
                    check.append((i, j, k))

answer = float("inf")

for a, b, c in check:
    case = len(graph[a]) + len(graph[b]) + len(graph[c]) - 6
    answer = min(answer, case)
if answer == float("inf"):
    print(-1)
else:
    print(answer)