def solution(n, q, ans):
    return find_answer(5, 0, [], ans, q, n)

def find_answer(m, start, check, ans, q, n):
    if len(check) == m:
        counts = []
        for j in q:
            count = sum(1 for u in j if u in check)
            counts.append(count)
        return 1 if counts == ans else 0

    total = 0
    for i in range(start + 1, n + 1):
        check.append(i)
        total += find_answer(m, i, check, ans, q, n)
        check.pop()
    return total
