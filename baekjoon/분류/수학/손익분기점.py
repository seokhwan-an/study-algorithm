def BEP(a,b,c):
    if b >= c:
        cnt = -1
    else:
        cnt = a//(c-b) + 1
    return cnt

a, b, c = map(int,input().split())
print(BEP(a,b,c))