# 게임 진행시 말해야하는 전체 문자열 구하기
# - 문자열 개수 : 참가자 수 * 미리 구할 숫자의 개수
# 각 숫자를 진수로 변경하기
# - 10부터 15는 A,B,C,D,F로 대응
# 반복문으로 돌면서 순번을 통해 튜브가 말해야 하는 문자열 구하기
def solution(n, t, m, p):
    answer = ''
    
    allGameTalk = makeAllTalk(n, t, m)
    
    p = p - 1
    count = 0
    for i in range(len(allGameTalk)):
        if i % m == p and count < t:
            count += 1
            answer += allGameTalk[i]
    
    return answer

def makeAllTalk(n, t, m):
    gameTalk = ""
    
    num = 0
    while len(gameTalk) < t * m:
        gameTalk += changeNum(num, n)
        num += 1

    return gameTalk

def changeNum(num, n):
    if num == 0:
        return "0"
    
    table = {10:"A", 11:"B", 12:"C", 13:"D", 14:"E", 15:"F"}
    string = ""
    while num:
        div = num%n
        if div in table:
            string += table[div]
        else:
            string += str(div)
        num //= n
    
    return string[::-1]
    
    
        
        