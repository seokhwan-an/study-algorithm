def get_count_of_departments_cleaned_by_robot_vacuum(r, c, d, room_map):
    answer = 0
    n = len(room_map)
    m = len(room_map[0])
    visited = [[0] * len(room_map[0]) for _ in range(len(room_map))]

    # 벽처리
    for i in range(len(room_map)):
        for j in range(len(room_map[0])):
            if room_map[i][j] == 1:
                visited[i][j] = 1

    x = r
    y = c
    while True:
        # 1. 현재 위치 청소하기
        if visited[x][y] == 0:
            answer += 1
            visited[x][y] = 2
        dx = [-1, 0, 1, 0]
        dy = [0, 1, 0, -1]
        # 왼쪽 탐색 0:북, 1:동, 2:남, 3:서
        next = d
        available = False
        for i in range(4):
            next = (next + 3) % 4
            nx, ny = x + dx[next], y + dy[next]
            if visited[nx][ny] == 0:
                available = True
                break

        if available:
            d = next
            x, y = x + dx[d], y + dy[d]
            continue
        else:
            back_dir = (d + 2) % 4
            x, y = x + dx[back_dir], y + dy[back_dir]
            if visited[x][y] == 1:
                break

    return answer

n, m = map(int, input().split())
r, c, d = map(int, input().split())
board = []
for i in range(n):
    row = list(map(int, input().split()))
    board.append(row)

print(get_count_of_departments_cleaned_by_robot_vacuum(r, c, d, board))
