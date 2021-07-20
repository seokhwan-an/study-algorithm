n = int(input())
a = []
for i in range(n):
    a.append(int(input()))
a.sort(reverse=True)
b = []
for i in range(1,n+1):
    b.append(a[i-1]*i)
print(max(b))