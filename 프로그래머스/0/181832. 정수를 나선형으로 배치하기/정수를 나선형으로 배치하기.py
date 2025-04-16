def solution(n):
    answer = [[0] * n for _ in range(n)]

    sx, sy = 0, 0
    stamp = 2
    move_dir = 0
    move = n - 1
    count = 3
    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]
    check = n * n - 1
    while check:
        for _ in range(move):
            sx = sx + dx[move_dir]
            sy = sy + dy[move_dir]
            answer[sx][sy] = stamp
            stamp += 1
            check -= 1

        count -= 1
        move_dir = (move_dir + 1) % 4

        if count == 0:
            count = 2
            move -= 1

    answer[0][0] = 1
    return answer