# 초당 최대 처리량 = 응답 완료 여부 없이 1초간 처리하는 요청의 최대 개수

def solution(lines):
    answer = 0
    logs = []

    for line in lines:
        _, time, duration = line.split()
        time = time.split(":")
        duration = float(duration[:-1]) * 1000
        end = (int(time[0]) * 3600 + int(time[1]) * 60 + float(time[2])) * 1000
        start = end - duration + 1
        logs.append([start, end])

    for log in logs:
        answer = max(answer,
                    find_log_count(log[0], logs),
                     find_log_count(log[1], logs))
        
    return answer

def find_log_count(time, logs):
    start = time
    end = time + 1000
    count = 0
    for log in logs:
        if start <= log[1] and log[0] < end:
            count += 1
    
    return count