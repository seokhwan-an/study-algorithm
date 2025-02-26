def solution(tickets):
    graph = {}
    visited = {}

    # 그래프 및 방문 딕셔너리 초기화
    for start, end in tickets:
        if start not in graph:
            graph[start] = []
        graph[start].append(end)
        
        if (start, end) not in visited:
            visited[(start, end)] = 1
        else:
            visited[(start, end)] += 1

    answers = []
    
    def dfs(start, answer):
        if len(answer) == len(tickets) + 1:
            answers.append(answer[:])  
            return
        
        if start not in graph: 
            return
        
        for next in sorted(graph[start]): 
            if visited[(start, next)] > 0:
                visited[(start, next)] -= 1
                answer.append(next)
                dfs(next, answer)
                answer.pop()  
                visited[(start, next)] += 1

    dfs("ICN", ["ICN"])
    
    return sorted(answers)[0] 