# LZW 압축 구현하기
# 현재 위치에 사전에 포함된 가장 긴 길의 문자열을 구하고 추가한다
# 사전에 없는 문자열의 경우 
def solution(msg):
    answer = []
    lzw = {"A":1, "B":2, "C":3, "D":4, "E":5, "F":6, "G":7, "H":8, "I":9, "J":10, "K":11, "L":12, "M":13, "N":14, "O":15, "P":16, "Q":17, "R":18, "S":19, "T":20, "U":21, "V":22, "W":23, "X":24, "Y":25, "Z":26}
    
    startIndex = 0
    lastNumber = 27
    while startIndex < len(msg):
        string = ""
        notFind = False
        for i in range(startIndex, len(msg)):
            string += msg[i]
            if string not in lzw:
                notFind = True
                startIndex = i
                break
        if notFind:
            lzw[string] = lastNumber
            lastNumber += 1
        answer.append(lzw[string[:-1]])
        
    return answer