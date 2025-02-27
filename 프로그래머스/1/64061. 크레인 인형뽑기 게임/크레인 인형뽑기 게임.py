# 각 격자 칸에는 다양한 인형이 있다.
# 뽑은 인형을 담은 stack이 필요
# 같은 두개의 인형이 stack에 연속으로 쌓이면 사라진다.
# 사라진 인형의 개수를 구해라

def solution(board, moves):
    answer = 0
    pick = []
    
    for move in moves:
        index = move - 1
        height = 0
        
        # 인형의 높이로 이동
        while height < len(board):
            if board[height][index] != 0:
                break;
            height += 1
        
        
        # 인형이 없는 경우
        if height == len(board):
            continue
        
        # 인형이 있는 경우
        doll = board[height][index]
        board[height][index] = 0
        
        if len(pick) == 0:
            pick.append(doll)
        else:   
            picked_doll = pick.pop()
            if doll == picked_doll:
                answer += 2
            else:
                pick.append(picked_doll)
                pick.append(doll)       
    return answer