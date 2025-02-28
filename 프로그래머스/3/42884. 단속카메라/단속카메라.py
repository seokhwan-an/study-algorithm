def solution(routes):
    answer = 0
    
    sorted_routes = sorted(routes, key = lambda x : (x[1], x[0]))
    answer += 1
    camera = sorted_routes[0][1]
    
    for start, end  in sorted_routes[1:]:
        if start <= camera:
            continue
        else:
            answer += 1
            camera = end
    
        
    return answer