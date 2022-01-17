array = []
for i in range(1,10):
    array.append(int(input()))

max = array[0]
cnt = 1
for i in range(1,9):
    if array[i] > max:
        max = array[i]
        cnt = i+1

print(max)
print(cnt)