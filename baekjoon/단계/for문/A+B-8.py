n = int(input())
data = []
answer = []
for i in range(n):
    a, b = map(int,input().split())
    data.append([a,b])
    answer.append(a+b)

for i in range(1,n+1):
    print("Case #"+str(i)+": {0} + {1} = {2}".format(data[i-1][0],data[i-1][1],answer[i-1]))