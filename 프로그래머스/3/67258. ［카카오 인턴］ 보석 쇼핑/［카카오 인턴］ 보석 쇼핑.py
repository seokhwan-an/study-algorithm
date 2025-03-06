# 보석 종류를 모두 포함하는 가장 짧은 구간 구하기
# 모두 가지는지 검증 법
# - set을 통해 모든 보석을 관리
# - 한 칸씩 나아가면서 map에 보석 정보 업데이트
# - set의 길이와 map의 key 길이를 비교해서 길이가 같으면 모든 보석이 있는 것 없으면 더 나아가야 하는 것

def solution(gems):
    answer = []
    size = len(set(gems))
    
    # 초기 설정
    gemDic = {gems[0] : 1}
    start, end = 0, 0
    
    while start <= end and end < len(gems):
        # 모두 포함되어 있으면 answer에 값 추가
        if len(gemDic) == size:
            answer.append([start + 1, end + 1])
            gem = gems[start]
            if gemDic[gem] > 1:
                gemDic[gem] -= 1
            else:
                gemDic.pop(gem)
            start += 1
        elif len(gemDic) < size:
            end += 1
            if end >= len(gems):
                break
            
            gem = gems[end]
            if gem in gemDic:
                gemDic[gem] += 1
            else:
                gemDic[gem] = 1
        
    answer = sorted(answer, key = lambda x : (x[1] - x[0], x[0]))      
    
    return answer[0]