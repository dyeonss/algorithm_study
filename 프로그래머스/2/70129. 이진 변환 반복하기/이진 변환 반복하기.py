def solution(s):
    answer = [0,0]
    
    while s!='1':
        x=''
        for i in range(len(s)):
            if s[i]=='1':
                x+=s[i]

        n=len(x)
        x=''
        answer[1]+=len(s)-n
        while n!=0:
            x+=str(n%2)
            n=n//2
        s=x[::-1]
        answer[0]+=1
    
    return answer