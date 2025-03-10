def solution(players, m, k):
    answer = 0
    cover = [0] * len(players)
    for i in range(len(players)):
        if players[i] == 0 or players[i] < m or players[i] <= cover[i]:
            continue
        
        if cover[i] <= players[i]:
            diff = players[i] - cover[i]
            answer += diff // m
            
            for j in range(i, min(len(players), i + k)):
                cover[j] += m * (diff // m) 
        
    return answer