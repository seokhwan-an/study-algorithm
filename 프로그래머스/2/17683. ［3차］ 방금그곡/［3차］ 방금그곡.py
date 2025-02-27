# 음악 찾기
# 각 음은 1분에 1개씩 재생된다. 음악은 처음부터 
# 조건이 없는 것은 None 반환
def solution(m, musicinfos):
    answer = ''
    check = []
    order = 0
    for musicinfo in musicinfos:
        start, end, name, code = musicinfo.split(",")
        second = change_second(start, end)
        played_code = play(code, second)
        
        if is_correct(m, played_code):
            check.append((name, second, order))
        
        order += 1
        
    sort_check = sorted(check, key = lambda x: (-x[1], x[2]))
    
    if len(sort_check) == 0:
        return "(None)"
    
    return sort_check[0][0]

def change_second(start, end):
    sm, ss = start.split(":")
    em, es = end.split(":")
    
    s_second = int(sm) * 60 + int(ss)
    e_second = int(em) * 60 + int(es)
    
    return e_second - s_second
    
def play(code, second):
    played_code = []
    play = 0        
    index = 0
    while play < second:
        n1 = code[index % len(code)]
        n2 = code[(index + 1) % len(code)]
        
        if (n2 == "#"):
            played_code.append(n1 + n2)
            index += 2
        else:
            played_code.append(n1)
            index += 1
            
        play += 1
    
    
    return played_code
        
def is_correct(m, play_code):
    memory = play(m, len(m) - find_shop_count(m))
    if len(memory) > len(play_code):
        return False

    for i in range(0, len(play_code) - len(memory) + 1):
        if memory == play_code[i:i + len(memory)]:
            return True
    return False
    
def find_shop_count(m):
    count = 0
    for s in m:
        if s == "#":
            count += 1
    return count

    