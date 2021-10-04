def gcd_solution (a,b):
    if b == 0:
        return a
    else:
        return gcd_solution(b, a%b)

num1 , num2 = map(int,input().split())

if num1 > num2:
    a = num1
    b = num2
else:
    a = num2
    b = num1

gcd = gcd_solution(a,b)
lcd = int(gcd * (a/gcd) * (b/gcd))
print(gcd)
print(lcd)