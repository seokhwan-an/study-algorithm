def solution(storey):
    answer = 0
    
    while storey > 0:
        last = storey % 10  # 현재 자릿수
        next_digit = (storey // 10) % 10  # 다음 자릿수 (올림을 고려하기 위함)
        
        if last < 5:
            answer += last
            storey -= last
        elif last > 5:
            answer += 10 - last
            storey += 10 - last
        else:  # last == 5일 경우
            if next_digit >= 5:  # 다음 자릿수가 5 이상이면 올림
                answer += 10 - last
                storey += 10 - last
            else:  # 그렇지 않으면 내리기
                answer += last
                storey -= last
        
        storey //= 10  
    
 
    return answer