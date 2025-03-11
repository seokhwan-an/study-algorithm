# 가장 적은 객실 수 구하기
# heap 자료구조 활용하기
# 새롭게 추가되는 예약이 기존의 예약시간과 겹치면 객실 수를 늘린다.
# 그렇지 않다면 기존의 예약을 제거하고 새롭게 최신 예약을 추가한다.(같은 객실 사용)

import heapq

def solution(book_time):
    answer = 0
    
    book_time.sort(key = lambda x : x[0])
    change = []
    for s, e in book_time:
        change.append([changeToMinute(s), changeToMinute(e)])
    
    q = []
    
    for time in change:
        if len(q) == 0:
            heapq.heappush(q, (time[1], time))
            continue
        
        _, p = heapq.heappop(q)
        
        if time[0] < p[1] + 10 and time[1] >= p[0]:
            heapq.heappush(q, (p[1], p))
        heapq.heappush(q, (time[1], time))     
    
        
    return len(q)

def changeToMinute(time):
    h, m = time.split(":")
    return int(h) * 60 + int(m)