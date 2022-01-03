n = int(input())
move = list(input().split())
x,y = 1,1
dx = [0,0,-1,1]
dy = [-1,1,0,0]
method = ["L","R","U","D"]
for i in move:
    nx = x + dx[method.index(i)]
    ny = y + dy[method.index(i)]
    if nx < 1 or nx > n:
        continue
    elif ny < 1 or ny > n:
        continue
    else:
        x = nx
        y = ny

print(x,y)
