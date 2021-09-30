def solution(arr):
    array = arr
    a = True
    for i in arr:
        stack = []
        for j in range(len(i)):
            if i[j] == "(" or i[j] == "[":
                stack.append(i[j])
            elif i[j] == ")" or i[j] == "]":
                if len(stack) == 0:
                    a = False
                    break
                if i[j] == ")":
                    if stack[-1] == "(":
                        stack.pop()
                    else:
                        a = False
                        break
                if i[j] == "]":
                    if stack[-1] == "[":
                        stack.pop()
                    else:
                        a = False
                        break
            else:
                continue
         
        if not a :
            a = True
            print("no")
        else:
            if len(stack) ==0:
                print("yes")
            else:
                print("no")
        


arr = []
while(True):
    a = input()
    if a == ".":
        break
    else:
        arr.append(a)

solution(arr)
