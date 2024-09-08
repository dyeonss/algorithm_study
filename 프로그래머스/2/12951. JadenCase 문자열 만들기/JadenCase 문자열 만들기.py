def solution(s):
    answer = ''
    words=s.split()
    pos=0
    
    for word in words:
        pos+=len(word)
        answer+=word[0].upper()+word[1:].lower()
        while pos<len(s) and s[pos]==' ':
            answer+=' '
            pos+=1
            
    return answer