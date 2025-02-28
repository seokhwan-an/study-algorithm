n, m = map(int, input().split())

answer = []
visited = [False] * (n + 1)

def solution(n, m, count, find):
    if count == m:
        answer.append(find)
        return

    for i in range(1, n + 1):
        if not visited[i]:
            visited[i] = True
            solution(n, m, count + 1, find + str(i) + " ")
            visited[i] = False

solution(n, m, 0, "")
print("\n".join(answer))
