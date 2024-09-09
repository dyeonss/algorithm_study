def solution(n):
    cnt=bin(n)[2:].count('1')
    n+=1
    
    while True:
        if cnt==bin(n)[2:].count('1'):
            break
        n+=1
    return n