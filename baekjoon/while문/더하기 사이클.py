n = input()
count = 0
num = ''
while n != num:
    if len(n) == 1 and num=='':
        num = n+n
        count += 1
    else:
        if num == '':
            a = int(n[0]) + int(n[1])
            num = n[-1] + str(a)[-1]
            print(num)
            count += 1
        else:
            a = int(num[0]) + int(num[1])
            num = num[-1] + str(a)[-1]
            print(num)
            count += 1
print(count)