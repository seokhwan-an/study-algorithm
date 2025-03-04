# 문제 정리
# 도서 이름 검색 시 도시와 관련된 맛집 게시물을 제공하는 서비스
# 데이터베이스에서 게시물을 가져오는 부분의 실행시간이 너무 오래 걸린다
# 캐시 크기 설정이 고민이 된다. -> 캐시 크기에 따른 실행시간 측정 프로그램 작성
# cache hit는 실행시간 1 miss인 경우는 실행시간 5
# 캐시는 LRU 방식

# 풀이 방법
# 먼저 캐시 크기 만큼 도시를 넣으면서 실행시간 +5한다.
# 도시이름이 캐시에 없을 경우 가장 앞에 있는 도시를 캐시에서 빼고 +5를 한다.
# 도시이름이 캐시에 있을 경우 해당 도시를 캐시의 맨 마지막에 넣고 +1을 한다.

def solution(cacheSize, cities):
    answer = 0
    cache = []
    
    # 캐시의 크기 만큼 도시를 넣으면 실행시간 +5하기
    for city in cities:
        city = city.upper()
        if cacheSize == 0:
            answer += 5
            continue
        if city in cache:
            cache.remove(city)
            cache.append(city)
            answer += 1
        else:
            if len(cache) == cacheSize:
                cache.pop(0)
            cache.append(city)
            answer += 5
            
    return answer