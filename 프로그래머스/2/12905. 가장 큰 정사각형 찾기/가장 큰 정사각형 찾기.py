def solution(board):
    answer = 0
    dp = [[0] * len(board[0]) for _ in range(len(board))]
    for i in range(len(board)):
        dp[i][0] = board[i][0]
    
    for i in range(len(board[0])):
        dp[0][i] = board[0][i]
        
    for i in range(1, len(board)):
        for j in range(1, len(board[0])):
            if board[i][j] == 1:
                min_size = min(dp[i -1][j], dp[i][j - 1], dp[i - 1][j - 1])
                if min_size >= 0:
                    dp[i][j] = min_size + 1
    
    for i in range(len(board)):
        for j in range(len(board[0])):
            answer = max(answer, dp[i][j])
    
    return answer * answer