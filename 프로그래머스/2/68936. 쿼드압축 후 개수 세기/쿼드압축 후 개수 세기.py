# 그림만 봐도 재귀호출로 풀어야 하는 문제인 것을 인식
# 재귀의 핵심은 어느 타이밍에서 탈출을 한 것이지
# 칸의 개수가 1개이면 숫자를 새고 탈출
# 영역의 칸의 모두 같은 숫자라면 해당 숫자에 +1을 하고 탈출

def solution(arr):
    answer = [0, 0]
    size = len(arr)
    def press(arr, x, y, size):
        if size == 1 or isSame(arr, x, y, size):
            num = arr[x][y]
            if num == 0:
                answer[0] += 1
            else:
                answer[1] += 1
                
            return
        ns = size // 2
        press(arr, x, y, ns)
        press(arr, x + ns, y, ns)
        press(arr, x, y + ns, ns)
        press(arr, x + ns, y + ns, ns)
    press(arr, 0, 0, size)
    return answer

def isSame(arr, x, y, size):
    num = arr[x][y]
    for i in range(x, x + size):
        for j in range(y, y + size):
            if num != arr[i][j]:
                return False
    return True