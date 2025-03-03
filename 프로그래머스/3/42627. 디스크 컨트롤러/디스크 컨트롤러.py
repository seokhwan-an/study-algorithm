import heapq

def solution(jobs):
    jobs.sort()  # 요청 시간이 빠른 순서대로 정렬 (start 기준)
    heap = []  # 실행 대기 큐 (소요 시간 기준)
    time, total_time, count = 0, 0, 0  # 현재 시간, 총 반환 시간, 완료된 작업 수
    i = 0  # jobs 배열 인덱스

    while count < len(jobs):
        # 현재 시간 이하에서 실행 가능한 작업을 모두 힙에 추가
        while i < len(jobs) and jobs[i][0] <= time:
            heapq.heappush(heap, (jobs[i][1], jobs[i][0]))  # (소요 시간, 요청 시각)
            i += 1
        
        if heap:
            # 소요 시간이 가장 짧은 작업 실행
            duration, start = heapq.heappop(heap)
            time += duration  # 현재 시간 업데이트
            total_time += (time - start)  # 요청부터 종료까지 걸린 시간 계산
            count += 1
        else:
            # 대기 중인 작업이 없는 경우, 시간을 다음 요청 작업으로 이동
            time = jobs[i][0]
    
    return total_time // len(jobs)
