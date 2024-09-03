def solution(survey, choices):
    answer = ''
    scores={'R':0,'T':0,'C':0,'F':0,'J':0,'M':0,'A':0,'N':0}
    
    for i in range(len(choices)):
        if choices[i]>=5:
            scores[survey[i][1]]+=choices[i]-4
        elif choices[i]<=3:
            scores[survey[i][0]]+=4-choices[i]
    
    personal=list(scores)
    
    for i in range(0,len(personal),2):
        answer+=personal[i] if scores[personal[i]]>=scores[personal[i+1]] else personal[i+1]

    return answer