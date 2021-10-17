import math
def solution(numbers, hand):
    left = [1,4]
    right = [3,4]
    middle = [0,0]
    answer = ''
    key = [[1,4,7],[2,5,8,0],[3,6,9]]
    for i in numbers:
        if i == 1 or i == 4 or i == 7:
            answer += 'L'
            if i == 1:
                left = [1,1]
            elif i == 4:
                left = [1,2]
            else:
                left = [1,3]
        elif i == 3 or i == 6 or i == 9:
            answer += 'R'
            if i == 3:
                right = [3,1]
            elif i == 6:
                right = [3,2]
            else:
                right = [3,3]
        else:
            if i == 2:
                middle = [2,1]
            elif i == 5:
                middle = [2,2]
            elif i == 8:
                middle = [2,3]
            else:
                middle = [2,4]
            left_len = abs(left[0]-middle[0]) + abs(left[1]-middle[1])
            right_len = abs(right[0]-middle[0]) + abs(right[1]-middle[1])
            if left_len < right_len:
                answer +='L'
                left = [middle[0],middle[1]]
            elif left_len > right_len:
                answer += 'R'
                right = [middle[0],middle[1]]
            else:
                if hand == "right":
                    answer += 'R'
                    right = [middle[0],middle[1]]
                else:
                    answer += 'L'
                    left = [middle[0],middle[1]]
    return answer