# 보석 종류를 모두 포함하는 가장 짧은 구간 구하기
# 모두 가지는지 검증 법
# - set을 통해 모든 보석을 관리
# - 한 칸씩 나아가면서 map에 보석 정보 업데이트
# - set의 길이와 map의 key 길이를 비교해서 길이가 같으면 모든 보석이 있는 것 없으면 더 나아가야 하는 것

def solution(gems):
    answer = []
    
    if len(gems) == 1:
        return [1, 1]
    # 모든 보석 정보 넣기
    gemCheck = set(gems)
    gemDic = {}
    start = 0
    end = 1
    
    gemDic[gems[start]] = 1
    if len(gemDic.keys()) == len(gemCheck):
        answer.append([1, 1])
    
    # 투포인터
    # gemDic.keys() < gemCheck 길이 현재 end 추가하고 end + 1
    # gemDic.keys() == gemCheck 길이 현재 start를 빼고 start + 1
    while start <= end and end < len(gems):
        if len(gemDic.keys()) == len(gemCheck):
            answer.append([start + 1, end])
            gem = gems[start]
            if gemDic[gem] == 1:
                gemDic.pop(gem)
            else:
                gemDic[gem] -= 1
            start += 1
            
        elif len(gemDic.keys()) < len(gemCheck):
            gem = gems[end]
            if gem in gemDic:
                gemDic[gem] += 1
            else:
                gemDic[gem] = 1
            end += 1
            
    while len(gemDic.keys()) == len(gemCheck) and start <= end:
        if len(gemDic.keys()) == len(gemCheck):
            answer.append([start + 1, end])
            gem = gems[start]
            if gemDic[gem] == 1:
                gemDic.pop(gem)
            else:
                gemDic[gem] -= 1
            start += 1
        
    answer = sorted(answer, key = lambda x : (x[1] - x[0], x[0]))      
    
    return answer[0]