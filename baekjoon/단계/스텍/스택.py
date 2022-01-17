n = int(input())
stack = []
answer = []
for i in range(n):
    command = input()
    if "push" in command:
        stack.append(int(command[5:]))
    elif "top" == command:
        if len(stack) == 0:
            answer.append(-1)
        else:
            answer.append(stack[-1])
    elif "size" == command:
        answer.append(len(stack))
    elif "empty" == command:
        if len(stack) == 0:
            answer.append(1)
        else:
            answer.append(0)
    elif "pop" == command:
        if len(stack) == 0:
            answer.append(-1)
        else:
            answer.append(stack.pop())

for i in answer:
    print(i)