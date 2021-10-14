site = input()
x_site = ['a','b','c','d','e','f','g','h']
y_site = ['1','2','3','4','5','6','7','8']
present_site = [x_site.index(site[0])+1, y_site.index(site[1])+1]

move = [[-2,-1],[-2,1],[2,1],[2,-1],[-1,2],[-1,-2],[1,-2],[1,2]]
answer = 0
for i in move:
    mx = present_site[0] + i[0]
    my = present_site[1] + i[1]

    if  1 <= mx <=8 and 1 <= my <=8:
        answer += 1

print(answer)