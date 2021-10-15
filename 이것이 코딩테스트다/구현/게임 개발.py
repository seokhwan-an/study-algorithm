n, m = map(int,input().split())
dx, dy, dir = map(int,input().split())
stamp = [[0]*m for _ in range(n)]
stamp[dx][dy] = 1 
stage = []
mx = [-1,0,1,0]
my = [0,-1,0,1]
for i in range(n):
    stage.append(list(map(int,input().split())))
turn = 0
answer = 1
def turn_left():
    global dir
    dir = (dir+1) % 4

while(True):
    turn_left()
    turn += 1
    x = mx[dir] + dx
    y = my[dir] + dy
    if stage[x][y] == 0 and stamp[x][y] == 0:
        stamp[x][y] = 1
        answer += 1
        dx = x
        dy = y
        turn = 0
        continue
    else:
        if turn == 4:
            x = dx - mx[(dir+2)%4]
            y = dy - my[(dir+2)%4]
            if stage[x][y] == 0:
                dx = x
                dy = y
            else:
                break
            turn = 0

print(answer)