def solution(p):
    return make_correct(p)

def make_correct(string):
    if len(string) == 0:
        return ""
    
    u, v = split_u_and_v(string)
    print("u ", u, " v ", v)

    if is_correct(u):
        change = make_correct(v)
        print("u + change ", u + change)
        return u + change
    else:
        new_string = "("
        new_string += make_correct(v)
        new_string += ")"

        split_u = u[1:len(u) - 1]
        print("split_u ", split_u)
        print(new_string)
        for s in split_u:
            if s == "(":
                new_string += ")"
            elif s == ")":
                new_string += "("
        print("correct_u ", new_string)
        return new_string

def split_u_and_v (string):
    left_count = 0
    right_count = 0
    index = 0

    for i in range(len(string)):
        if string[i] == "(":
            left_count += 1
        elif string[i] == ")":
            right_count += 1

        if left_count == right_count:
            index = i
            break
            
    return string[0 : index + 1], string[index + 1 :]

def is_correct(string):
    stack = []

    for s in string:
        if s == "(":
            stack.append(s)
        else:
            if len(stack) == 0:
                return False
            pre = stack.pop()

            if pre == ")":
                return False

    return len(stack) == 0