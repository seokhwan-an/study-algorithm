def solution(s):
    answer = 0
    
    for i in range(len(s)):
        center = s[i]
        left = i - 1
        right = i + 1
        while left >= 0 and right < len(s):
            if s[left] != s[right]:
                break
            left -= 1
            right += 1
        
        size = right - left - 1
        answer = max(answer, size)
        
    for i in range(len(s) - 1):
        center1 = s[i]
        center2 = s[i + 1]
        
        if center1 != center2:
            continue
            
        left = i - 1
        right = i + 2
        while left >= 0 and right < len(s):
            if s[left] != s[right]:
                break
            left -= 1
            right += 1
        
        size = right - left - 1
        answer = max(answer, size)

    return answer