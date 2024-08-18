def solution(n):
    answer=[]
    li=list(reversed(str(n)))
    
    for i in li:
        answer.append(int(i))
        
    return answer