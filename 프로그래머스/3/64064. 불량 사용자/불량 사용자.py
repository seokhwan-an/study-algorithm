# 8개의 user_id에서 banned_id의 길이 만큼의 조합을 구한다.
# 그조합에 banned_id에 적합한지 비교한다.
# 된다면 answer의 값을 증가시킨다.

from itertools import combinations

def solution(user_id, banned_id):
    answer = [0]
    select = len(banned_id)
    
    senarios = list(combinations(user_id, select))
    
    sequnce = [0] * select
    visited = [0] * select
    check = set()
    def isAvailable(senario, banned_id, sequnce, n):
        if n == len(sequnce):
            available = True
            for i in range(n):
                user = senario[i]
                ban = banned_id[sequnce[i]]
                if not isMatch(ban, user):
                    available = False
                    break
            if available:
                check.add(senario)
            return
        
        for i in range(len(senario)):
            if visited[i] == 0:
                visited[i] = 1
                sequnce[n] = i
                isAvailable(senario, banned_id, sequnce, n + 1)
                visited[i] = 0
    
    for senario in senarios:
        isAvailable(senario, banned_id, sequnce, 0)   
    return len(check)
            
def isMatch(ban, user):
    # 길이가 다르면 False
    if len(ban) != len(user):
        return False
    ban = list(ban)
    user = list(user)
    
    # 글자 하나씩 매칭
    for i in range(len(ban)):
        if ban[i] == "*":
            continue
        
        if ban[i] != user[i]:
            return False
    
    return True
