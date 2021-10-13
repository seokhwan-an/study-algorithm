n = int(input())
answer = 0
for i in range(0,n+1):
    if "3" in str(i):
        answer += 60*60
    else:
        answer = answer+ 60 * 15 + 45*15

print(answer)
