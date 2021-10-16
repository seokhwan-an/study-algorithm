def solution(lottos, win_nums):
    win = [6,6,5,4,3,2,1]
    zero = 0
    same = 0
    answer = []
    for i in lottos:
        if i == 0:
            zero += 1
        else:
            for j in win_nums:
                if i == j:
                    same += 1
    max_win = win[same + zero]
    min_win = win[same]
    answer.append(max_win)
    answer.append(min_win)
    return answer

lottos = [44,1,0,0,31,25]
win_nums = [31,10,45,1,6,19]

print(solution(lottos, win_nums))