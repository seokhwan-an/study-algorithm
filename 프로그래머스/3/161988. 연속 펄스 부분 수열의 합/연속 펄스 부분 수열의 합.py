# 누적합 문제
def solution(sequence):
    start_minus = [0]
    start_plus = [0]
    
    sm = -1
    sp = 1
    index = 0
    # 더하기는 1, 빼기는 -1
    for num in sequence:
        start_minus.append(start_minus[index] + sm * num)
        start_plus.append(start_plus[index] + sp * num)
        index += 1
        sm *= -1
        sp *= -1
    
    start_minus = start_minus[1:]
    start_plus = start_plus[1:]
    
    min1, max1 = 0, float('-inf')
    min2, max2 = 0, float('-inf')
    
    for i in range(len(sequence)):
        max1 = max(max1, start_minus[i] - min1)
        max2 = max(max2, start_plus[i] - min2)
        
        min1 = min(min1, start_minus[i])
        min2 = min(min2, start_plus[i])
        
    
    return max(max1, max2)