T = int(input())
answer = []
for i in range(T):
    num1, num2 = map(int,input().split())
    answer.append(num1+num2)

for i in answer:
    print(i)