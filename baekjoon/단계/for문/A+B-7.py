n = int(input())
answer = []
for i in range(n):
    a, b = map(int,input().split())
    answer.append(a+b)

for i in range(1,n+1):
    print("Case #"+str(i)+":",answer[i-1])