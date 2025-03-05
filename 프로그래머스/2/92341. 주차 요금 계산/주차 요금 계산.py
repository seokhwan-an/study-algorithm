# 차량별로 누적 주차시간을 구한다.
# 차량별 누적 시간을 기준으로 주차 요금을 계산한다.
# 주차 요금 = 기본 요금 + {(주차 누적 시간 - 기본시간) / 단위 시간} * 600
# 단위시간으로 나누었을 때 소수가 있다면 올림
# 주차 누적 시간이 기본시간 보다 작으면 기본 요금 내기
import math

def solution(fees, records):
    answer = []
    # 차량별 누적 주차시간 구하기
    carPark = {}
    carIn = {}
    
    for record in records:
        time, carNo, action = record.split()
        time = timeChange(time)
        if action == "IN":
            carIn[carNo] = time
        else:
            parkInTime = carIn[carNo]
            if carNo in carPark:
                carPark[carNo] += time - parkInTime
            else:
                carPark[carNo] = time - parkInTime
            carIn.pop(carNo)

    for key in carIn.keys():
        maxTime = timeChange("23:59")
        parkTime = maxTime - carIn[key]
        if key in carPark:
            carPark[key] += parkTime
        else:
            carPark[key] = parkTime
    
    # 비용 구하기
    payInfo = []
    bTime, bPay, unitTime, exPay = map(int, fees)
    
    for key in carPark:
        parkTime = carPark[key]
        overTime = parkTime - bTime
        
        if overTime <= 0:
            payInfo.append([key, bPay])
        else:
            totalPay = bPay + math.ceil(overTime / unitTime) * exPay
            payInfo.append([key, totalPay])
    sortedPayInfo = sorted(payInfo, key = lambda x: x[0])
    answer = [pay[1] for pay in sortedPayInfo]
    return answer

def timeChange(time):
    h, m = time.split(":")
    total = int(h) * 60 + int(m)
    return total