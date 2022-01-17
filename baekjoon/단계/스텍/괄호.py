def solutions(arr):
    array = arr
    a = True
    stack = []
    answer = []
    for i in array:
        stack = []
        for j in range(len(i)):
            if i[j] == "(":
                stack.append(i[j])
            else:
                if len(stack) == 0:
                    answer.append("NO")
                    a = False
                    break
                stack.pop()
        if not a:
            a = True
            continue

        if len(stack) == 0:
            answer.append("YES")
        else:
            answer.append("NO")

    return answer

n = int(input())
arr = [] # 괄호 저장
for i in range(n):
    arr.append(input())

answer = solutions(arr)
for i in answer:
    print(i)