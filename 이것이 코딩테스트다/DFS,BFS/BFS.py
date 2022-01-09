from collections import deque

def bfs(graph, start, visited):
	# 큐(Queue) 구현을 위해 deque 라이브러리 사용
	queue = deque([start])
	visited[start] = True
	while queue:
		v = queue.popleft()
		print(v, end = '')
		for i in graph[v]:
			if not visited[i]:
				queue.append(i)
				visited[i] = True

graph = [
	[],
	[2, 3, 8],
	[1, 7],
	[1, 4, 5],
	[3, 5],
	[3, 4],
  [7],
	[2, 6, 8],
	[1,7]
]
# 각 노드가 방문된 정보를 표현(1차원 리스트)
visited = [False] * 9	

bfs(graph, 1, visited)