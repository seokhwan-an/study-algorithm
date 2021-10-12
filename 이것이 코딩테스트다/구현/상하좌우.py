n = int(input())
arr = list(input().split())
x, y = 1, 1

move_x = [0,0,-1,1]
move_y = [-1,1,0,0]
mode = ['L','R','U','D']

for i in arr:
    x += move_x[mode.index(i)]
    y += move_y[mode.index(i)]
    if x == 0:
        x = 1
    elif x == (n+1):
        x = n
    if y == 0:
        y = 1
    elif y == (n+1):
        y = n
print(x,y)
