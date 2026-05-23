import math

def solution(progresses, speeds):
    days = [] 
    
    for i in range(len(progresses)):
        day = math.ceil((100 - progresses[i]) / speeds[i])
        days.append(day)
    
    answer = []

    current = days[0]
    count = 1

    for i in range(1, len(days)):
        if days[i] <= current:
            count += 1
        else:
            answer.append(count)
            current = days[i]
            count = 1

    answer.append(count)
    return answer