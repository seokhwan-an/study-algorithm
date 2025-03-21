import sys

n = int(sys.stdin.readline())
m = int(sys.stdin.readline())

moves = []
for i in range(m):
    s, e, w = map(int, sys.stdin.readline().split())
    moves.append([s, e, w])

group = [-1] * (n + 1)

def find(node):
    if group[node] < 0:
        return node
    group[node] = find(group[node])  # 경로 압축
    return group[node]

def union(s, e):
    sRoot = find(s)
    eRoot = find(e)

    if sRoot == eRoot:
        return False

    if group[sRoot] == group[eRoot]:
        group[sRoot] -= 1
    # union by rank
    if group[sRoot] < group[eRoot]:
        group[eRoot] = sRoot
    else:
        group[sRoot] = eRoot

    return True

answer = 0
count = 0
moves.sort(key = lambda x : x[2])
for s, e, w in moves:
    if union(s, e):
        answer += w

print(answer)