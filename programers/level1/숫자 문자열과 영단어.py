def solution(s):
    change = {'zero':0,'one':1,'two':2,'three':3,'four':4,'five':5,'six':6,'seven':7,'eight':8,'nine':9,'':''}
    string = ''
    answer = ''
    for i in s:
        if i.isalpha():
            string += i
            if string in change:
                answer += str(change[string])
                string = ''
        else:
            if string == '':
                answer += str(i)
            else:
                answer += str(change[string])
                answer += str(i)
                string = ''
    answer = int(answer)
    return answer