def solution(n):
    answer = 0
    fibo=[0,1,1,2,3,5]
    
    for i in range(6,n+1):
        fibo.append((fibo[i-2]+fibo[i-1]))
    
    return fibo[n]%1234567