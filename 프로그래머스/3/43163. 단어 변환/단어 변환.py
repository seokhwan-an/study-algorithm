from collections import deque

def solution(begin, target, words):
    
    # words 안에 target이 없는 경우 0 반환
    if target not in words:
        return 0
    
    answer = bfs(begin, target, words)
    return answer

def bfs(begin, target, words):
    visited = [0] * len(words)
    q = deque()
    q.append([begin, 0])
    
    while q:
        p = q.popleft()
        word = p[0]
        count = p[1]
        
        if word == target:
            return count
        
        if 0 in visited:
            for i in range(len(words)):
                if visited[i] == 0 and canChange(word, words[i]):
                    visited[i] = 1
                    q.append([words[i], count + 1])
    return 0
  

def canChange(string1, string2):
    diff = 0
    for i in range(len(string1)):
        if string1[i] != string2[i]:
            diff += 1
    return diff == 1