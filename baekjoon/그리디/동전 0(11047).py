n, k = map(int,input().split())
money = []
count = 0
for i in range(n):
    money.append(int(input()))
money.sort(reverse=True)
if n == 1:
    print(k//money[0])
else:
    for i in money:
        if k >= i:
            count += k//i
            k = k % i
    print(count)        
