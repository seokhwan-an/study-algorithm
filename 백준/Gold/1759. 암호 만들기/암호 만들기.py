n, m = map(int, input().split())
units = input().split()
units.sort()

v = ["a", "e", "i", "o", "u"]
# 모음 최소 한개, 자음 최소 2개
# 먼저 오름 차순이다 즉 넘어온 인덱스 값보다 큰 원소만 선택
# 마지막 검증시 모음 개수와 자음 개수 검증 후 문자열 만들어서 추가
visited = [0] * m
answers = []

def solution(k, mCnt, jCnt, next):
    if k == n:
        if mCnt >= 1 and jCnt >= 2:
            password = ""
            for i in range(m):
                if visited[i] == 1:
                    password += units[i]
            answers.append(password)

        return

    for i in range(m):
        if i > next and visited[i] == 0:
            visited[i] = 1
            s = units[i]
            if s in v:
                solution(k + 1, mCnt + 1, jCnt, i)
            else:
                solution(k + 1, mCnt, jCnt + 1, i)
            visited[i] = 0

solution(0, 0, 0, -1)

print("\n".join(answers))
