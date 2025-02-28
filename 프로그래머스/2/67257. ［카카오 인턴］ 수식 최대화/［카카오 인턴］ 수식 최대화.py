from itertools import permutations

def solution(expression):
    answer = 0
    fun = ["*", "+", "-"]
    priorities = permutations(fun)
    expressions, count = change_to_list(expression)
    for priority in priorities:
        result = calculate(expressions[:], count, priority)
        answer = max(answer, result)
        
    return answer

def change_to_list(expression):
    pre = ""
    expression_array = []
    expression_count = {"*":0, "+":0, "-":0}
    for s in expression:
        if s.isdigit():
            pre += s
        else:
            if s == "*":
                expression_count["*"] += 1
            if s == "+":
                expression_count["+"] += 1
            if s == "-":
                expression_count["-"] += 1
                
            expression_array.append(pre)
            expression_array.append(s)
            pre = ""
    expression_array.append(pre)
    
    return expression_array, expression_count
            
def calculate(expression, counts, priority):
    for fun in priority:
        count = counts[fun]
        new_expression = []
        cal = False
        for i in range(0, len(expression)):
            if cal:
                cal = False
                continue
            if expression[i] == fun:
                pre_num = int(new_expression[-1])
                next_num = int(expression[i + 1])
                
                if expression[i] == "*":
                    new_expression[-1] = pre_num * next_num
                if expression[i] == "+":
                    new_expression[-1] = pre_num + next_num
                if expression[i] == "-":
                    new_expression[-1] = pre_num - next_num 
                cal = True
            else:
                new_expression.append(expression[i])
        expression = new_expression
    return abs(expression[0])
    