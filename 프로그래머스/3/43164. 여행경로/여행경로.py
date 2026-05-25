def solution(tickets):
    tickets.sort()
    visited = [False] * len(tickets)
    
    def dfs(now, path):
        if len(path) == len(tickets)+1:
            return path
        
        for i in range(len(tickets)):
            start, end = tickets[i]
            
            if start == now and not visited[i]:
                visited[i] = True
                result = dfs(end, path+[end])
    
                if result:
                    return result
            
                visited[i] = False

    return dfs("ICN", ["ICN"])