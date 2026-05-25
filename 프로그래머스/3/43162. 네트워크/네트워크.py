def solution(n, computers):
    answer = 0
    visited = [False] * n
    
    def dfs(v):
        visited[v] = True
        for nxt in range(n):
            if computers[v][nxt] == 1 and visited[nxt] == False:
                dfs(nxt)
    
    count = 0
    
    for i in range(n):
        if not visited[i]:
            dfs(i)
            count += 1
    
    return count