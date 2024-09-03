def solution(survey, choices):
    answer = ''
    scores={'R':0,'T':0,'C':0,'F':0,'J':0,'M':0,'A':0,'N':0}
    
    for s,c in zip(survey,choices):
        if c>=5:
            scores[s[1]]+=c-4
        elif c<=3:
            scores[s[0]]+=4-c
    
    personal=list(scores)
    
    for i in range(0,len(personal),2):
        answer+=personal[i] if scores[personal[i]]>=scores[personal[i+1]] else personal[i+1]

    return answer