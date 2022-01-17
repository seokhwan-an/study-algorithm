n = int(input())
num_arr1 = list(map(int,input().split(" ")))
num_arr2 = list(map(int,input().split(" ")))
num_arr1.sort(reverse=True)
num_arr2.sort()
answer = 0
for i in range(len(num_arr1)):
    answer += num_arr1[i] * num_arr2[i]
print(answer)