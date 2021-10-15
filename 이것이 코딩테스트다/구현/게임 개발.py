n, m = map(int,input().split())
site = list(map(int,input().split()))
map = []
stamp =[site]
dir = [[-1,0,0],[0,1,0],[1,0,0],[0,-1,0]]
for i in range(n):
    map.append(list(map(int,input().split())))

answer = 1

while(True):
    #1번
    if map[site[0]+dir[site[2]][0]][site[0]+dir[site[2]][1]] == 1:
        site[2] = (site[2] + 1) % 4
        continue
    else:
        site = site + dir[site[2]]
        if site not in stamp:
            stamp.append(site)
        
