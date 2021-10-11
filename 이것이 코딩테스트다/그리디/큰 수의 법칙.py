# 내가 푼 풀이
N, M, K = map(int, input().split())
arr = list(map(int,input().split()))
arr.sort(reverse=True)
first = arr[0]
second = arr[1]
term = first*K + second
answer = (M//(K+1))*term + (M%(K+1))*first
print(answer)

# 책에서 설명해주는 간략하게 푸는 법(시간복잡도 낮게)
N, M, K = map(int, input().split())
arr = list(map(int,input().split()))
arr.sort(reverse=True)
first = arr[0]
second = arr[1]
cnt = 1
answer = 0
while(cnt <= M):
    if cnt % (K+1) == 0:
        answer += second
        cnt += 1
    else:
        answer += first
        cnt += 1
print(answer)