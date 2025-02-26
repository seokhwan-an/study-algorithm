
def solution(numbers, target):
    answer = [0] 
    def dfs(numbers, target, index, num):
        if index == len(numbers) :
            if target == num:
                answer[0] += 1
            return
    
        dfs(numbers, target, index + 1, num + numbers[index])
        dfs(numbers, target, index + 1, num - numbers[index])
        
    dfs(numbers, target, 0, 0)
    return answer[0]
