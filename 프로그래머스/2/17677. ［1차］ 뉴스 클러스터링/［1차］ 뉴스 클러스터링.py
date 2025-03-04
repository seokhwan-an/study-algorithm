# 유사한 기사를 묶기 
# 자카드 유사도 : 집합간의 유사도를 검사하는 방법 
# 두 집합의 교집합의 크기를 합집합의 크기로 나눈 값
# 두 집합 모두 공집합일 경우 자카드 유사도는 1로 정의

# 중복을 허용하는 다중집합에 대해서 자카드 유사도를 구하기
# 문자열을 두글자씩 자른 배열 구하기 -> 영어만 포함된 경우 모두 소문자로 변경해서
# 교집합 구하기, 합집합 구하기
# 교집합의 길이를 합집합으로 나누고 65536 곱하기
from collections import Counter

def solution(str1, str2):
    answer = 0
    num = 65536
    
    str1 = makeArray(str1)
    str2 = makeArray(str2)
    
    if len(str1) == 0 and len(str2) == 0:
        return num
    
    dic1 = Counter(str1)
    dic2 = Counter(str2)
    
    sameUnit = 0
    allUnit = 0
    
    for unit in set(str1):
        if unit in dic1 and unit in dic2:
            sameUnit += min(dic1[unit], dic2[unit])
            allUnit += max(dic1[unit], dic2[unit])
        elif unit in dic1:
            allUnit += dic1[unit]
    for unit in set(str2):
        if unit in dic2 and unit not in dic1:
            allUnit += dic2[unit]
    
    jakade = sameUnit / allUnit
    answer = int(num * jakade)
    return answer

def makeArray(string):
    return [string[i : i + 2].lower() for i in range(0, len(string) - 1) if string[i : i + 2].isalpha()]
