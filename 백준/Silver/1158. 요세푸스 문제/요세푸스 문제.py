from collections import deque

def josephus_problem(n, k):
    numbers = []
    q = deque(range(1, n + 1))
    while q:
        q.rotate(-(k - 1))
        numbers.append(q.popleft())
    print("<",(", ".join(map(str, numbers))),">", sep="")

n, k = map(int, input().split())
josephus_problem(n, k)
