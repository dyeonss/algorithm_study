def solution(n):
    li=list(str(n))
    li.sort()
    li.reverse()
    
    return int(''.join(li))